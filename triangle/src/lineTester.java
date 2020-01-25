
public class lineTester {

	public static void main(String[] args) {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(2, 2);
		Point p3 = new Point(0, 2);
		Point p4 = new Point(2, 0);
		
		Point p5 = new Point(3, 0);
		Point p6 = new Point(0, 3);
		Lineseg[] lines = new Lineseg[3];
		
		lines[0] = new Lineseg(p1, p2);
		lines[1] = new Lineseg(p3, p4);
		lines[2] = new Lineseg(p5, p6);
		
		//lines[3] = new Lineseg(p7, p8);
		Polygon poly = new Polygon(lines);
		System.out.println(poly.checkPoly());
		
		Point[] points = new Point[4];
		points[0] = new Point(0, 0);
		points[1] = new Point(0, 2);
		points[2] = new Point(2, 2);
		points[3] = new Point(2, 0);
		Polygon poly2 = new Polygon(points);
		System.out.println(poly2.checkPoly());
		
		

	}

}
