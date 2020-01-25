import java.io.*;
import java.util.Scanner;
public class ReaderList {
	private Reader[] readers = new Reader[86];
	
	public ReaderList() {
		for(int i = 0; i < 86; i++) {
			readers[i] = new Reader();
		}
	}
	
	public ReaderList(String path) throws IOException{
		Scanner reader = new Scanner(new File(path));
		int s = 0;
		while(reader.hasNextLine()) {
			String name = reader.nextLine();
			int scores[] = new int[55];
			for(int i = 0; i < 55; i++) {
				scores[i] = reader.nextInt();
			}
			reader.nextLine();
			readers[s] = new Reader(name, scores);
			///System.out.println(readers[s].toString());
			s++;
			
		}
		reader.close();
	}
	
	public Reader[] getReaders() {
		return readers;
	}
	
}