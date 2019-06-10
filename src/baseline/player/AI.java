/**
 * 老师和助教提供的一个AI棋手，作为评价的一个Baseline
 */

package baseline.player;

import core.game.Game;
import core.game.Move;
import static core.board.PieceColor.*;
import static core.game.Move.SIDE;

import java.util.ArrayList;
import java.util.Random;

public class AI extends core.player.AI {

	/** Maximum minimax search depth before going to static evaluation. */
	private static final int MAX_DEPTH = 2;
	/**
	 * A position magnitude indicating a win (for white if positive, black if
	 * negative).
	 */
	private static final int WINNING_VALUE = Integer.MAX_VALUE - 1;
	/** A magnitude greater than a normal value. */
	private static final int INFTY = Integer.MAX_VALUE;

	public AI() {
		// TODO Auto-generated constructor stub
	}
    
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
		
		//掷色子。同学们可以修改为alpha-beta剪枝
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

	/**
	 * The move found by the last call to one of the ...FindMove methods below.
	 */
	private Move _lastFoundMove;

	private int findMove(int depth, int sense, int alpha, int beta) {		
			return 0;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "baseline";
	}
	
	@Override
	public void playGame(Game game) {
		super.playGame(game);
		board = new Board4AI(); 
	}

	//自己保有的棋盘
	private Board4AI board = null;
}
