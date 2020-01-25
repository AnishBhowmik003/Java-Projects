import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;

public class triGUI {
	public static void main(String[] args) throws IOException{
		String ans = "y";
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1. File\n2. GUI\n3. Sets");
			int choice = Integer.parseInt(scanner.nextLine());
			if(choice == 1) {
				Polygon poly = new Polygon("points.txt");
				System.out.println(poly.toString());
			}
			else if(choice == 2) {
				JFrame theGUI = new JFrame();
				theGUI.setTitle("GUI Program");
				theGUI.setSize(300, 200);
				theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ColorPanel panel = new ColorPanel(Color.white);
				
				Container pane = theGUI.getContentPane();
				pane.add(panel);
				
				theGUI.setVisible(true);
			}
			else if(choice == 3) {
				Point[] points = new Point[4];
				points[0] = new Point(0, 0);
				points[1] = new Point(2, 2);
				points[2] = new Point(1, 1);
				points[3] = new Point(3, 3);
				Polygon poly = new Polygon(points);
				System.out.println(poly.toString());
				
			}
			
			System.out.println("Run Again? (y/n)");
			
				ans = scanner.nextLine();
			
			
			
		}while(ans.equals("y"));
		
		
		
		
		
		
		
		
	}
}
