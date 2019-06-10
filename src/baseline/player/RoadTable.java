package baseline.player;

import static baseline.player.Road.FORWARD;
import static core.board.PieceColor.*;
import static core.game.Move.SIDE;

import java.util.ArrayList;

import core.board.PieceColor;
import core.game.Move;

public class RoadTable {
	

	public RoadTable() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < playerRoads.length; i++) {
			for (int j = 0; j < playerRoads[0].length; j++) {
				playerRoads[i][j] = new RoadList();
			}
		}
	}
	
	//获取以startPos为起点的，前进方向上的4条路
	public Road[] getRoads(int startPos) {
		return roads[startPos];
	}

	//初始化路表
	public void clear() {
	
	}
	
	public boolean noThreats(PieceColor whoseMove) {
		return true;
	}
	
	private int getPotentialThreats(PieceColor whoseMove) {
		return 0;
	}
	
	//获取将子下在位置pos时，受到影响的所有的有效路
	public ArrayList<Road> getAffectedRoads(int pos){
		ArrayList<Road> affectedRoads = new ArrayList<>();
	
		return affectedRoads;
	}

	
	//将路road，从其所在的路表中删除
	public void removeRoad(Road road)
	{
		
	}
	
	//将路road，添加到相应的路表中
	public void addRoad(Road road)
	{
		
	}
	
	//基本路表： 以每个点为起点的路
	private Road[][] roads = new Road[SIDE * SIDE][4]; 
	
	//按黑白子个数划分的路表：包含0个至6个黑子, 0个至6个白子的路；简称为黑白路表
	//例如： playerRoads[3][2]表示含有3个黑子，2个白子的路
	private RoadList[][] playerRoads = new RoadList[7][7];
	
	public static void main(String[] args) {
		RoadTable rt = new RoadTable();
		rt.clear();
		ArrayList<Point> intStus = new ArrayList<>();
		
		intStus.addAll(null);
		
	}
}
