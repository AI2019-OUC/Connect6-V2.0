package core.player;

import java.util.Scanner;

import core.game.Move;

/* A delegate player of the opponent*/
public class Delegate extends Player {

	@Override
	public Move findMove(Move opponentMove) { 
		Move move = Move.parseMove(_sc.next());
		// TODO Auto-generated method stub
		return move;
	}
	private Scanner _sc = new Scanner(System.in);
	@Override
	public boolean isManual() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Console";
	}
}
