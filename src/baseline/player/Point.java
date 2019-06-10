package baseline.player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Point implements Comparable<Point>{

	public Point() {
		// TODO Auto-generated constructor stub
	}
	
	public Point(int pos, int score) {
		super();
		this.pos = pos;
		this.score = score;
	}

	public void draw() {
		System.out.println("(" + pos + ", " + score + ")");
	}
	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	private int pos = 0;
	private int score = 0;
	@Override
	public int compareTo(Point arg0) {
		// TODO Auto-generated method stub
		return this.score - arg0.score;
	}
	
	public static Comparator<Point> scoreComparator = new Comparator<Point>(){
	       public int compare(Point p1, Point p2) {
	           return p2.score - p1.score;
	        }
	};
	
	public static void main(String[] agrs) {
		ArrayList<Point> points = new ArrayList<>();
		Point p = new Point(5, 1);
		points.add(p);
		p = new Point(4, 5);
		points.add(p);
		p = new Point(6, 2);
		points.add(p);
		p = new Point(7, 6);
		points.add(p);
		p = new Point(8, 4);
		points.add(p);
		
		points.sort(scoreComparator);
		
		Iterator<Point> itr = points.iterator();
		
		while (itr.hasNext()) {
			itr.next().draw();
		}
		
		
	}
}
