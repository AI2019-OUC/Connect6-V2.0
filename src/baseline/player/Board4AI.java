package baseline.player;

import static core.board.PieceColor.*;
import static core.game.Move.SIDE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import core.board.Board;
import core.board.PieceColor;
import core.game.Move;

public class Board4AI extends Board {

	public Board4AI() {
		// TODO Auto-generated constructor stub
		roadTable.clear();
	}

	public Board4AI(Board b) {
		super(b);
		// TODO Auto-generated constructor stub
	}
	
	private RoadTable roadTable = new RoadTable();
}


