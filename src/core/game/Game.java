package core.game;

import static core.board.PieceColor.BLACK;
import static core.board.PieceColor.WHITE;

import java.io.File;
import java.util.ArrayList;

import core.player.Player;
import core.board.Board;

/** Controls the play of the game.
 *  @author
 */
public class Game {
	private static final int MAXSTEP = 180;
    /** A new Game, using BOARD to play on */
	public Game(Board board) {
        _board = board;
    }
	
	public Game(Board board, Player black, Player white) {
		this(board);
		this.black = black;
		this.white = white;
		black.setColor(BLACK);
		white.setColor(WHITE);
		black.playGame(this);
		white.playGame(this);
	}
	
    /** My board and its read-only view. */
    private Board _board;
    
    public void process() {
    	Move currentMove = null;
    	_board.clear();
    	_board.draw();
    	int step = 0;
    	Player currPlayer;
        while (true) {    
        	Move move = null;
        	if (_board.whoseMove() == BLACK) {
        		currPlayer = black;
        	} else {
        		currPlayer = white;
        	}
        	
    		if (currPlayer.isManual()) System.out.print(currPlayer.getColor() + ">");
    		
    		move = currPlayer.findMove(currentMove);
        	
            step++;
        	System.out.println(step + "> " + currPlayer.getColor() + "--" + currPlayer.name() + ": " + "move " + move.toString());
        	_board.makeMove(move);
        	_board.draw();
        	currentMove = move;
        	
        	if (_board.gameOver()) {
        		System.out.println("Game Over, " + currPlayer.getColor() + "--" + currPlayer.name() + " is win");
        		break;
        	}
        	
        	if (step == MAXSTEP) {
        		System.out.println("Game Over, draw...");
        		break;
        	}
        }
    }
    
    /**  recording the game into a file */
    public void record() {
    	//记录比赛双方名字，比赛时间，比赛结果等
    	
    	//记录比赛的所有走步
    	//_board.record(gameRecord);
    }
    
    Player black = null;	//执黑的棋手
    Player white = null;    //执白的棋手
    
    ArrayList<Move> moveList = new ArrayList<>();
}
