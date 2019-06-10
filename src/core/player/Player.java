package core.player;

import core.board.Board;
import core.board.PieceColor;
import core.game.Game;
import core.game.Move;

/** A generic Connect6 Player.
 *  @author
 */
public abstract class Player {
  
	public abstract boolean isManual();
	public abstract String name();
	
    public PieceColor getColor() {
		return _myColor;
	}
    
    /** A Player that will play MYCOLOR in GAME. */
	public void setColor(PieceColor myColor) {
		_myColor = myColor;
	}


	/** Return the game I am playing in. */
	public Game game() {
        return _game;
    }
	
	/** Join a game. */
	public void playGame(Game game) {
		_game = game;
	}
    
    /** Return a legal move for me according to my opponent's move, 
     *  and at that moment, I am facing a board after the opponent's move. 
     *  Abstract method to be implemented by subclasses. */
	public abstract Move findMove(Move opponentMove);

    /** The game I am playing in. */
    private Game _game;
    
    /** The color of my pieces. */
    private PieceColor _myColor;

}
