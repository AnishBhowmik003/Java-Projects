import java.util.Random;

public class Triangle {
	private Lineseg myL1;
	private Lineseg myL2;
	private Lineseg myL3;
	
	public Triangle() {
		myL1 = new Lineseg();
		myL2 = new Lineseg();
		myL3 = new Lineseg();
	}
	
	public Triangle(Point p1, Point p2, Point p3) {
		myL1 = new Lineseg(p1, p2);
		myL2 = new Lineseg(p2, p3);
		myL3 = new Lineseg(p3, p1);
	}
	
	public Triangle (Lineseg l1, Lineseg l2, Lineseg l3) {
		myL1 = l1;
		myL2 = l2;
		myL3 = l3;
	}
	
	public void setLine1(Lineseg l1) {
		myL1 = l1;
	}
	
	public void setLine2(Lineseg l2) {
		myL2 = l2;
	}
	
	public void setLine3(Lineseg l3) {
		myL3 = l3;
	}
	
	public Lineseg getLine1() {
		return myL1;
	}
	
	public Lineseg getLine2() {
		return myL2;
	}
	
	public Lineseg getLine3() {
		return myL3;
	}
	
	public void randFill() {
		Point p1 = new Point();
		Point p2 = new Point();
		Point p3 = new Point();
		p1.randFill();
		p2.randFill();
		p3.randFill();
		myL1 = new Lineseg(p1, p2);
		myL2 = new Lineseg(p2, p3);
		myL3 = new Lineseg(p3, p1);
		
	}
	
	public boolean isTri() {
		Lineseg bigLine, smallLine1, smallLine2;
		if (myL3.getDistance() > myL2.getDistance() && myL3.getDistance() > myL1.getDistance()) {
			bigLine = myL3;
			smallLine1 = myL1;
			smallLine2 = myL2;
		}
		else if (myL2.getDistance() > myL1.getDistance() && myL2.getDistance() > myL3.getDistance()) {
			bigLine = myL2;
			smallLine1 = myL1;
			smallLine2 = myL3;
		}
		else {
			bigLine = myL1;
			smallLine1 = myL2;
			smallLine2 = myL3;
		}
		
		if (smallLine1.getDistance() + smallLine2.getDistance() > bigLine.getDistance()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String kind() {
		
		Lineseg bigLine, smallLine1, smallLine2;
		if (myL3.getDistance() > myL2.getDistance() && myL3.getDistance() > myL1.getDistance()) {
			bigLine = myL3;
			smallLine1 = myL1;
			smallLine2 = myL2;
		}
		else if (myL2.getDistance() > myL1.getDistance() && myL2.getDistance() > myL3.getDistance()) {
			bigLine = myL2;
			smallLine1 = myL1;
			smallLine2 = myL3;
		}
		else {
			bigLine = myL1;
			smallLine1 = myL2;
			smallLine2 = myL3;
		}
		
		if (isTri() == true) {
			
		if (Math.pow(smallLine1.getDistance(), 2) + Math.pow(smallLine2.getDistance(), 2) == Math.pow(bigLine.getDistance(), 2)) {
			return("Right");
		}
		else if (Math.pow(smallLine1.getDistance(), 2) + Math.pow(smallLine2.getDistance(), 2) < Math.pow(bigLine.getDistance(), 2)) {
			return("Acute");
		}
		else {
			return("Obtuse");
		}
	}
		else {
			return("not triangle");
		}
	}
	
	public double perimeter() {
	
			return(myL1.getDistance() + myL2.getDistance() + myL3.getDistance());
		
	}
	
	public double angle1() {
		double a = myL1.getDistance();
		double b = myL2.getDistance();
		double c = myL3.getDistance();
		if (isTri() == true) {
			double angle;
			
			angle = Math.acos(((c * c) - (a* a) - (b * b)) / (-2 * a * b));
			return (angle * (180 / Math.PI));
		}
		else {
			double x = Math.sqrt(-1);
			return x;
		}
	}
	
	public double angle2() {
		double a = myL3.getDistance();
		double b = myL1.getDistance();
		double c = myL2.getDistance();
		if (isTri() == true) {
			double angle;
			
			angle = Math.acos(((c * c) - (a* a) - (b * b)) / (-2 * a * b));
			return (angle * (180 / Math.PI));
		}
		else {
			double x = Math.sqrt(-1);
			return x;
		}
	}
	
	public double angle3() {
		double a = myL2.getDistance();
		double b = myL3.getDistance();
		double c = myL1.getDistance();
		if (isTri() == true) {
			double angle;
			
			angle = Math.acos(((c * c) - (a* a) - (b * b)) / (-2 * a * b));
			return (angle * (180 / Math.PI));
		}
		else {
			double x = Math.sqrt(-1);
			return x;
		}
	}
	
	public String sideType() {
		double a, b, c;
		a = myL1.getDistance();
		b = myL2.getDistance();
		c = myL3.getDistance();
		
		if (isTri() == true) {
			if (a == b && b == c) {
				return ("equalateral");
			}
			else if (a == b && a != c) {
				return ("isosceles");
			}
			else {
				return ("scalene");
			}
		}
		else {
			return ("Not a triangle");
		}
		
	}
	
	public double area() {
		double s = (myL1.getDistance() + myL2.getDistance() + myL3.getDistance()) / 2;
		double area = Math.sqrt(s * (s - myL1.getDistance()) * (s - myL2.getDistance()) * (s-myL3.getDistance()) );
		return area;
	}
	
	public String toString() {
		return("Is triangle?: " + isTri() + "\nLine 1: " + myL1.toString() + "\nLine 2: " + myL2.toString() + "\nLine 3: " + 
	myL3.toString() + "\nAngle 1: " + angle1() + "\nAngle 2: " + angle2() + "\nAngle 3: " + 
				angle3() + "\nPerimeter: " + perimeter() + "\nArea: " + area() + "\nKind: " + kind() + "\nSide Type: " + sideType());
	}
 }
