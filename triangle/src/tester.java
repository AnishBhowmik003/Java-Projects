import java.util.Scanner;
import java.io.*;
public class tester {
	public static void main(String[] args) throws IOException {
		String ans = "y";
		Scanner scanner = new Scanner(System.in);
		do {
			Point[] points = new Point[4];
			points[0] = new Point(0, 0);
			points[1] = new Point(0, 2);
			points[2] = new Point(2,2);
			points[3] = new Point(2, 0);
			Polygon p1 = new Polygon(points);
			Polygon p2 = new Polygon("points.txt");
			System.out.println(p1.checkPoly());
			
			
			
			System.out.println("\nRun again? (y/n)");
			ans = scanner.nextLine();
		}while(ans.equals("y"));
		
		
	}
}
