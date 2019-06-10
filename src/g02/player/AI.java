package g02.player;

import static core.board.PieceColor.*;
import static core.game.Move.*;

import java.util.Random;

import core.board.Board;
import core.game.Move;
import core.player.Player;

/* A player who plays by throwing dice*/
public class AI extends core.player.AI {

//    /** A new AI for GAME that will play MYCOLOR. */
//	public Dicer(Game game, PieceColor myColor) {
//        super(game, myColor, false);
//    }

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
		return "G02-Lucker";  //组编号-为自己的AI所取的名字
	}
	
	Board board = new Board();
}
