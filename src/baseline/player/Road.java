package baseline.player;

import java.util.ArrayList;
import static core.game.Move.*;
import core.board.Board;
import core.board.PieceColor;

import static core.board.PieceColor.*;

public class Road {

	//某点四个前进方向的位移量；后退方向  = -前进方向
	//前进方向：下， 右，右下，右上；  {col增量，row增量}
	public static final int FORWARD[][] = {
		{0, 1}, {1, 0}, {1, 1}, {1, -1}
	};
	
	//某点直接影响到的范围，共8个方向，相对于该点的位移量
	public static final int DIRECTIONS[][] = {
		//下， 右，右下，右上
		{0, 1}, {1, 0}, {1, 1}, {1, -1},
		//上，左，左上， 左下
		{0, -1}, {-1, 0}, {-1, -1}, {-1, 1} 
	};
	
	
	public Road() {
		// TODO Auto-generated constructor stub
	}

	public Road(int startPos, int dir, int blackNum, int whiteNum, int index) {
		super();
		this.startPos = startPos;
		this.dir = dir;
		this.blackNum = blackNum;
		this.whiteNum = whiteNum;
		this.index = index;
	}
	
	//向该路中添加一个棋子
	public void addStone(PieceColor stone) {
		if (stone == BLACK) blackNum++;
		else if (stone == WHITE) whiteNum++;
	}
	//从该路中移除一个棋子
	public void removeStone(PieceColor stone) {
		if (stone == BLACK) blackNum--;
		else if (stone == WHITE) whiteNum--;
	}
	
	public int getBlackNum() {
		return blackNum;
	}
	public int getWhiteNum() {
		return whiteNum;
	}
	
	public boolean isEmpty() {
		return blackNum == 0 && whiteNum == 0;
	}
	
	public int getStartPos() {
		return startPos;
	}

	public int getDir() {
		return dir;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	private int startPos; 	//该路的起点的编号 （0~360）
	private	int dir;   	  	//该路的方向，起点的前进方向： 下，右，右下，右上

	private int blackNum; 	//该路中黑子的个数
	private int whiteNum; 	//该路中白子的个数
	
	private int index; 		//该路在其相应的黑白路表中的下标; 在该路被添加到黑白路表中时确定

		
	/**
	 * 从路中寻找空位。那些已经在其他路中遍历过的空位，不计算在内
	 * @param b
	 * @param vis
	 * @return
	 */
	public ArrayList<Point> findEmptyPos(Board b, boolean[] vis) {
		ArrayList<Point> points = new ArrayList<>();
		return points;
	}
}
