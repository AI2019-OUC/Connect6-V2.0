package core.board;

import static baseline.player.Road.FORWARD;
import static core.board.PieceColor.*;
import static core.game.Move.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import core.game.Move;


/** A Connect6 board.  The squares are labeled by column (a char value between
 *  'A' and 'S') and row (also a char value between 'A' and 'S').
 *  
 *  Moves on this board are denoted by Moves.
 *  @author Jianliang Xu
 */
public class Board extends Observable {

    /** A new, cleared board at the start of the game. */
    public Board() {
        _board = new PieceColor[SIDE * SIDE];
        clear();
    }

    /** A copy of B. */
    public Board(Board b) {
        _board = new PieceColor[SIDE * SIDE];
        internalCopy(b);
    }

    /** Return a constant view of me (allows any access method, but no
     *  method that modifies it). */
    public Board constantView() {
        return this.new ConstantBoard();
    }

    /** Clear me to my starting state, with pieces in their initial
     *  positions. */
    public void clear() {
        _whoseMove = WHITE;
        _gameOver = false;

        for (int i = 0; i < SIDE * SIDE; i++) {
            _board[i] = EMPTY;
        }
       //黑方先下第一个子，默认为棋盘的天元
        _board[Move.index('J', 'J')] = BLACK;
        moveList.clear();
        setChanged();
        notifyObservers();
    }

    /** Copy B into me. */
    public void copy(Board b) {
        internalCopy(b);
    }

    /** Copy B into me. */
    private void internalCopy(Board b) {
        _gameOver = b.gameOver();
        _whoseMove = b.whoseMove();
        //System.arraycopy(b._board, 0, _board, 0, SIDE * SIDE);
        for (int i = 0; i < SIDE * SIDE; i++) {
            _board[i] = b.get(i);
        }
        //System.arraycopy(b.moveList, 0, moveList, 0, b.moveList.size());
    }

    /** Return true iff the game is over: i.e., after the last move, 
     *  there is at lease one connect6 of the last player. */
    public boolean gameOver() {
    	if (moveList.isEmpty()) return false;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
    	Move lastMove = moveList.get(moveList.size() - 1);
    	char[] cols = new char[2];
    	char[] rows = new char[2];
    	
    	cols[0] = lastMove.col0();
    	cols[1] = lastMove.col1();
    	rows[0] = lastMove.row0();
    	rows[1] = lastMove.row1();
    	
    	for (int i = 0; i < 2; i++) {
    		if (isWin(cols[i], rows[i])) {
    			_gameOver = true;
    			return _gameOver;
    		}
    	}
    	
        return false;
    }
    
    //从点(startCol, startRow)开始，沿着方向dir向前的len个位置，连续与该点颜色相同的棋子的个数
    //该个数 <= len.
    private int lengthConnected(char startCol, char startRow, int dir, int len) {
    	
    	int myLen = 0;
    	//点(startCol, startRow)的棋子的颜色
    	PieceColor myColor = _whoseMove.opposite();
		for (int j = 0; j < len; j++) {
			char tempCol = (char)(startCol + FORWARD[dir][0] * j);
			char tempRow = (char)(startRow + FORWARD[dir][1] * j);
			if (Move.validSquare(tempCol, tempRow) && this.get(tempCol, tempRow) == myColor) {
				myLen++;
			}
			else {
				break;
			}
		}
		return myLen;
    }
    
    //棋手在点(col，row)上落子后，该棋手是否获胜
    private boolean isWin(char col, char row) {
    	
    	for (int dir = 0; dir < 4; dir++) {
    		//从当前点沿dir方向，连续相同颜色的点的个数，包括当前点
    		int len = lengthConnected(col, row, dir, 6);
    		//已经六连
    		if (len == 6) {
    			return true;
    		}
    		else {
    			//从当前点，沿dir方向的反方向，退后（6-len）个点的位置
    			char startCol = (char)(col - FORWARD[dir][0] * (6 -len));
    			char startRow = (char)(row - FORWARD[dir][1] * (6 -len));
    			//如果不是合法的点，则继续查看下一个方向
    			if (!Move.validSquare(startCol, startRow)) {
    				continue;
    			}
    			int tempLen = 6 - len;
    			len = lengthConnected(startCol, startRow, dir, tempLen);
    			//如果连六
        		if (len == tempLen) {
        			return true;
        		}
        		else {
        			continue;
        		}
    		}
    	}
    	return false;
    }

    /** Return the current contents of square C R, where 'A' <= C <= 'S',
     *  and 'A' <= R <= 'S'.  */
    public PieceColor get(char c, char r) {
        assert validSquare(c, r);
        return _board[index(c, r)];
    }

    /** Return the current contents of the square at linearized index K. */
    public PieceColor get(int k) {
        assert validSquare(k);
        return _board[k];
    }

    /** Set square(C, R) to V, where 'A' <= C <= 'S', and 'A' <= R <= 'S'. */
    protected void set(char c, char r, PieceColor v) {
        assert validSquare(c, r);
        set(index(c, r), v);
    }

    /** Set square(K) to V, where K is the linearized index of a square. */
    protected void set(int k, PieceColor v) {
        assert validSquare(k);
        _board[k] = v;
    }

    /** Return true iff MOV is legal on the current board. */
    public boolean legalMove(Move mov) {
    	return validSquare(mov.index1()) && get(mov.index1()) == EMPTY && 
    			validSquare(mov.index2()) && get(mov.index2()) == EMPTY;
    }

    /** Return the color of the player who has the next move.  The
     *  value is arbitrary if gameOver(). */
    public PieceColor whoseMove() {
        return _whoseMove;
    }

    /** Perform the move C0R0-C1R1.*/
    public void makeMove(char c0, char r0, char c1, char r1) {
        makeMove(new Move(c0, r0, c1, r1));
    }

    /** Make the Move MOV on this Board, assuming it is legal. */
    public void makeMove(Move mov) {
        assert legalMove(mov);
        
        moveList.add(mov);
        //System.out.println(_whoseMove + ": " + "move " + mov.toString());
        set(mov.col0(), mov.row0(), _whoseMove);
        set(mov.col1(), mov.row1(), _whoseMove);
        
        _whoseMove = _whoseMove.opposite();

        setChanged();
        notifyObservers();
    }

    /** Undo the last move, if any. */
    public void undo() {
        Move mov = moveList.remove(moveList.size() - 1);
        undo(mov);
        _whoseMove = _whoseMove.opposite();
        setChanged();
        notifyObservers();
    }

    public void undo(Move mov) {
        set(mov.col0(), mov.row0(), EMPTY);
        set(mov.col1(), mov.row1(), EMPTY);
    }

    @Override
    public String toString() {
        return toString(false);
    }

    /** Return a text depiction of the board. If LEGEND, supply row and
     *  column numbers around the edges. */
    public String toString(boolean legend) {
    	StringBuffer strBuff = new StringBuffer();
    	
    	strBuff.append("  ");
    	for (int i = 0; i < SIDE; i++)
    		strBuff.append((char)('A' + i));
    	strBuff.append("\n");
    	
    	for (int i = 0; i < SIDE * SIDE; i++) {
    		if (i % SIDE == 0) 
    			strBuff.append((char)('A' + i / SIDE) + " ");
    		if (_board[i] == EMPTY) {
    			strBuff.append("-");
    		}
    		else if (_board[i] == BLACK) {
    			strBuff.append("x");
    		}
    		else {
    			strBuff.append("o");
    		}
    		if ((i+1) % SIDE == 0)
    			strBuff.append("\n");
    	}
        return strBuff.toString();  // FIXME
    }
    
    public void draw() {
    	System.out.print(this.toString(true));
    }
    
    public void showMoves() {
    	Iterator<Move> itr = moveList.iterator();
    	PieceColor turn = WHITE;
    	while (itr.hasNext()) {
    		System.out.println(turn.toString() + ": " + itr.next().toString());
    		turn = turn.opposite();
    	}
    }
    
    /** Recording the movelist into a file*/
    public void record(File record) {
    	
    }

    /** Player that is on move. */
    private PieceColor _whoseMove;

    /** Player that is on move. */
    private PieceColor[] _board;

    /** Set true when game ends. */
    private boolean _gameOver;

    private ArrayList<Move> moveList = new ArrayList<>();

    @Override
    public boolean equals(Object b) {
        if (((Board) b)._whoseMove != _whoseMove || ((Board) b)._gameOver != _gameOver) {
            return false;
        }
        for (int i = 0; i < SIDE * SIDE; i++){
            if (((Board) b)._board[i] != _board[i]) {
                return false;
            }
        }
        return true;
    }

    /** A read-only view of a Board. */
    private class ConstantBoard extends Board implements Observer {
        /** A constant view of this Board. */
        ConstantBoard() {
            super(Board.this);
            Board.this.addObserver(this);
        }

        @Override
        public void copy(Board b) {
            assert false;
        }

        @Override
        public void clear() {
            assert false;
        }

        @Override
        public void makeMove(Move move) {
            assert false;
        }

        /** Undo the last move. */
        @Override
        public void undo() {
            assert false;
        }

        @Override
        public void update(Observable obs, Object arg) {
            super.copy((Board) obs);
            setChanged();
            notifyObservers(arg);
        }
    }
}
