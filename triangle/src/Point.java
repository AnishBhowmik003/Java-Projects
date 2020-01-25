import java.util.Random;

public class Point {
	private double myX;
	private double myY;
	
	public Point(double x, double y) {
		myX = x;
		myY = y;
	}
	
	public Point() {
		myX = 0;
		myY = 0;
	}
	
	public void randFill() {
		Random bob = new Random();
		myX = bob.nextInt(100);
		myY = bob.nextInt(100);
	}
	
	public void setX(double x) {
		myX = x;
	}
	
	public double getX() {
		return myX;
	}
	
	public void setY(double y)  {
		myY = y;
	}
	
	public double getY() {
		return myY;
	}
	
	public String toString() {
		return("(" + myX + ", " + myY + ")");
	}
 
 }
