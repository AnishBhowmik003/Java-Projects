import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class Polygon {
	private ArrayList<Lineseg> mylines = new ArrayList<Lineseg>();
	private ArrayList<Point> mypoints = new ArrayList<Point>();
	
	public Polygon(Lineseg[] lines) {
		int x = lines.length;
		for (int i = 0; i < x; i++) {
			mylines.add(lines[i]);
			mypoints.add(lines[i].getPoint1());
		}
		
	}
	
	public Polygon(ArrayList<Point> points) {
		mypoints.clear();
		mylines.clear();
		int x = points.size();
		for(int i = 0; i < points.size(); i++) {
			if (i != x-1) {
				Lineseg l1 = new Lineseg(points.get(i), points.get(i + 1));
				mylines.add(l1);
			}
			else {
				Lineseg l2 = new Lineseg(points.get(i), points.get(0));
				mylines.add(l2);
			}
			mypoints.add(points.get(i));
		}
		
	}
	
	public Polygon(String path) throws IOException {
		Scanner file1 = new Scanner(new File(path));
		int i = 0;
		while(file1.hasNextLine()) {
			mypoints.add(new Point(Integer.parseInt(file1.nextLine()), Integer.parseInt(file1.nextLine())));
		}
		int x = mypoints.size();
		for(int c = 0; c < x; c++) {
			if(c != x-1) {
				Lineseg l1 = new Lineseg(mypoints.get(c), mypoints.get(c+1));
				mylines.add(l1);
			}
			else {
				Lineseg l2 = new Lineseg(mypoints.get(c), mypoints.get(0));
				mylines.add(l2);
			}
		}
		file1.close();
		
	}
	
	public Polygon(Point[] points) {
		int x = points.length;
		for(int i = 0; i < x; i++) {
			mypoints.add(points[i]);
			if (i != x-1) {
				Lineseg l1 = new Lineseg(points[i], points[i+1]);
				mylines.add(l1);
			}
			else {
				Lineseg l2 = new Lineseg(points[i], points[0]);
				mylines.add(l2);
			}
		}
	}
	public Polygon() {
		
	}
	
	public int numPoints() {
		int x = mypoints.size();
		return x;
	}
	
	public boolean triTester() {
		if (checkPoly() == true) {
			if(mypoints.size() == 3) {
				Triangle triangle = new Triangle(mypoints.get(0), mypoints.get(1), mypoints.get(2));
				return triangle.isTri();
					
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
		
		
	}
	public Lineseg getLineseg(int n) {
		return mylines.get(n);
	}
	
	public void setLineseg(int n, Lineseg line) {
		mylines.set(n,  line);
	}
	
	public Point getPoint(int n) {
		return mypoints.get(n);
	}
	
	public void setPoint(int n, Point point) {
		mypoints.set(n,  point);
	}
	
	public double area() {
		if (checkPoly() == true) {
			int len = mypoints.size();
			int sum1 = 0;
			int sum2 = 0;
			for(int i = 0; i < len; i++) {
				if(i != len - 1) {
					sum1 += mypoints.get(i).getX() * mypoints.get(i+1).getY();
					sum2 += mypoints.get(i).getY() * mypoints.get(i + 1).getX();
				}
				else {
					sum1 += mypoints.get(i).getX() * mypoints.get(0).getY();
					sum2 += mypoints.get(i).getY() * mypoints.get(0).getX();
				}
			}
			int diff = Math.abs(sum1 - sum2);
			double area = diff / 2;
			return area;
		}
		else {
			return (0);
		}
		
	}
	
	public String type() {
		if(checkPoly() == true) {
			int flag = 0;
			String f;
			for(int i = 0; i < mylines.size(); i++) {
				if(mylines.get(0).getDistance() != mylines.get(i).getDistance()) {
					flag = 1;
				}
			}
			if(flag == 1) {
				f = "Irregular";
			}
			else {
				f = "Regular";
			}
			if(mylines.size() == 3) {
				return(f + " Triangle");
			}
			else if(mylines.size() == 4) {
				return(f + " Quadrilateral");
			}
			else if(mylines.size() == 5) {
				return(f + " Pentagon");
			}
			else if(mylines.size() == 6) {
				return(f + " Hexagon");
			}
			else if(mylines.size() == 7) {
				return(f + " Heptagon");
			}
			else if(mylines.size() == 8) {
				return(f + " Octagon");
			}
			else if(mylines.size() == 9) {
				return(f + " Nonagon");
			}
			else if(mylines.size() == 10) {
				return(f + " Decagon");
			}
			else {
				return(f + " Unkown");
			}
		}
		else {
			return("Not a Polygon");
		}
		
	}
	
	public boolean checkPoly() {
		int flag = 0;
		for(int i = 0; i < mylines.size() - 1; i++) {
			for(int j = 1; j < mylines.size()-i; j++) {
				if(i == j) {
					
				}
				else {
					
				
				if(mylines.get(i).checkIntersect(mylines.get(j)) == true) {
					flag = 1;
				}
				}
			}
		}
		if (flag == 1) {
			return false;
		}
		else {
			return true;
		}
		
	}
	
	public double sumOfAngles() {
		double x = (mylines.size() - 2) * 180;
		return x;
	}
	
	public double perimeter() {
		if (checkPoly() == true) {
			int x = mylines.size();
			double peri = 0;
			for(int i = 0; i < x; i++) {
				peri = peri + mylines.get(i).getDistance();
			}
			return peri;
		}
		else {
			return (0);
		}
	}
	
	public String toString () {
		String output = "";
		for(int i = 0; i < mypoints.size(); i++) {
			output = output + "\n" + mypoints.get(i).toString();
		}
		output += "\nPoly Test: " + checkPoly() + "\nNum Points: " + numPoints() + "\nPerimeter: " + perimeter() + "\nArea: " + area() + "\nTri Test: " + triTester() + 
				"\nSum of Angles: " + sumOfAngles() + "\nType: " + type();
		return output;
	}
}
