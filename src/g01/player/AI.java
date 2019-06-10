package g01.player;

import static core.board.PieceColor.*;
import static core.game.Move.*;

import java.util.Random;

import core.board.Board;

import core.game.Move;

/* A player who plays by throwing dice*/
public class AI extends core.player.AI {

    /** Return a move for me from the current position, assuming there
     *  is a move. */
    @Override
    public Move findMove(Move opponentMove) {	
		if (opponentMove == null) {
			Move move = firstMove();
			board.makeMove(move);
			return move;
		}
		else {
			board.makeMove(opponentMove);
		}
		
    	Random rand = new Random();
    	while (true) {
    		int index1 = rand.nextInt(SIDE * SIDE);
    		int index2 = rand.nextInt(SIDE * SIDE);
    		
    		if (index1 != index2 && board.get(index1) == EMPTY && board.get(index2) == EMPTY) {
    			Move move = new Move(index1, index2);
    			board.makeMove(move);
    			return move;
    		}
    	}
    }

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "G01-SixKiller";  //组编号-为自己的AI所取的名字
	}
	
	Board board = new Board();
}
