package core.game;

import java.util.ArrayList;
import java.util.Iterator;

import core.player.Player;

public class GameEvent {

	public GameEvent() {
		// TODO Auto-generated constructor stub
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	ArrayList<Player> players = new ArrayList<>();
	
	public void arrangeMatches() {		
		
		int gameNumbers = 1;	//每对棋手下几盘
		//单循环
		int size = players.size();		
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				matches.add(new Match(gameNumbers, players.get(i), players.get(j)));
			}
		}
	}
	
	ArrayList<Match> matches = new ArrayList<>();
	
	public void run() {
		Iterator<Match> itr = matches.iterator();
		while (itr.hasNext()) {
			Match match = itr.next();
			match.process();
		}
	}
	
}
