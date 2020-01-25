import java.io.*;
import java.util.Scanner;

public class Library {
	private Book arrbooks[] = new Book[55];
	
	
	public Library() {
		for(int i = 0; i < 55; i++) {
			arrbooks[i] = new Book();
		}
	}
	
	public Library(String path) throws IOException {
		Scanner reader = new Scanner(new File(path));
		int i = 0;
		while(reader.hasNext()) {
			
			String s = reader.nextLine();
			int x = s.indexOf(',');
			String a = s.substring(0, x);
			//System.out.println(a);
			String t = s.substring(x + 1, s.length());
			//System.out.println(t);
			arrbooks[i] = new Book(a, t);
			//System.out.println(arrbooks[i].toString());
			i++;
		}
		reader.close();
	}
	
	public Book getBook(int n) {
		return arrbooks[n];
	}
	
	public String toString() {
		
		String output = "";
		for(int i = 0; i < 54; i++) {
			output = output +  arrbooks[i].toString() + "\n";
		}
		output = output +  arrbooks[54].toString();
		return output;
	}
}
