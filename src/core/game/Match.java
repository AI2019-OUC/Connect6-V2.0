package core.game;

import core.player.Player;
import core.board.Board;

public class Match {
	public Match() {
		// TODO Auto-generated constructor stub
	}

	public Match(int gameNumbers) {
		super();
		this.gameNumbers = gameNumbers;
	}
	
	public Match(int gameNumbers, Player one, Player another) {
		super();
		this.gameNumbers = gameNumbers;
		this.one = one;
		this.another = another;
	}

	public void process() {
		Player black = one;
		Player white = another;		
		for (int i = 0; i < gameNumbers; i++) {
			System.out.println(black.name() + " : " + white.name() + " - " + (i + 1));
			Board board = new Board();
			Game game = new Game(board, black, white);
			game.process();
			
			Player temp;
			temp = black;
			black = white;
			white = temp;
			//exchange(black, white);
		}
	}

//	private void exchange(Player black, Player white) {
//		Player temp;
//		temp = black;
//		black = white;
//		white = temp;
//	}
	
	private int gameNumbers;	//一场比赛比几局
	
	private Player one;			//棋手1
	private Player another;	    //棋手2
}
