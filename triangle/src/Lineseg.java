import java.util.Random;
public class Lineseg {
	private Point point1;
	private Point point2;
	
	public Lineseg() {
		point1 = new Point();
		point2 = new Point();
	}
	
	public Lineseg(Point p1, Point p2) {
		point1 = p1;
		point2 = p2;
	}
	
	public Lineseg(double p1x, double p1y, double p2x, double p2y) {
		point1.setX(p1x);
		point1.setY(p1y);
		
		point2.setX(p2x);
		point2.setY(p2y);
	}
	
	public void setPoint1(Point p1) {
		point1 = p1;
	}
	
	public Point getPoint1() {
		return point1;
	}
	
	public void setPoint2(Point p2) {
		point2 = p2;
	}
	
	public Point getPoint2() {
		return point2;
	}
	
	public void randFill() {
		point1.randFill();
		point2.randFill();
	}
	
	public double getSlope() {
		double y = point1.getY() - point2.getY();
		double x = point1.getX() - point2.getX();
		double slope = y/x;
		return slope;
	}
	
	public double getDistance() {
		double y = point1.getY() - point2.getY();
		double x = point1.getX() - point2.getX();
		double dist = Math.sqrt((y * y) + (x * x));
		return dist;
	}
	
	public boolean checkIntersect(Lineseg l1) {
		int flag = 0;
		double m1 = getSlope();
		double b1 = point1.getY() - (m1 * point1.getX());
		
		double m2 = l1.getSlope();
		double b2 = l1.getPoint1().getY() - (m2 * l1.getPoint1().getX());
		
		double m3 = m1 - m2;
		double b3 = b2 - b1;
		if (m1 == m2 && b1 != b2) {
			return false;
		}
		else if(m1 == m2 && ((point1.getX() < Math.max(l1.getPoint1().getX(), l1.getPoint2().getX()) && point1.getX() > Math.min(l1.getPoint1().getX(),
				l1.getPoint2().getX())) || (point2.getX() < Math.max(l1.getPoint1().getX(), l1.getPoint2().getX()) && point2.getX() > Math.min(l1.getPoint1().getX(), l1.getPoint2().getX())))) {
			return true;
		}
		else {
			double x = b3 / m3;
			if(x < Math.max(point1.getX(), point2.getX()) && x > Math.min(point1.getX(), point2.getX())) {
				return true;
			}
			else {
				return false;
			}
		}
		
		
		
		
	}
	
	
	public String toString() {
		return(point1.toString() + ", " + point2.toString());
	}
	
}
