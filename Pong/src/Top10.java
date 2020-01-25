import java.io.*;
import java.util.Scanner;
public class Top10{
	private Player[] players = new Player[10];
	
	public Top10()  throws IOException{
		Scanner fnames = new Scanner(new File("names.txt"));
		Scanner fscores = new Scanner(new File("scores.txt"));
		for(int i = 0; i < 10; i++) {
			players[i] = new Player(fnames.nextLine(), Integer.parseInt(fscores.nextLine()));
		}
		
		fnames.close();
		fscores.close();
	}
	
	public void addPlayer(Player p) throws IOException {
		if (p.getScore() > players[9].getScore()) {
			players[9] = p;
			Player temp;
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9-i; j++) {
					if (players[j].getScore() < players[j+1].getScore()) {
						temp = players[j];
						players[j] = players[j+1];
						players[j+1] = temp;
					}
				}
			}
		}
		PrintWriter names = new PrintWriter(new File("names.txt"));
		PrintWriter scores = new PrintWriter(new File("scores.txt"));
		
		for(int i = 0; i < 10; i++) {
			names.println(players[i].getName());
			scores.println(players[i].getScore());
		}
		names.close();
		scores.close();
		
	}
	
	public String toString() {
		String output = players[0].toString();
		for(int i = 1; i < 10; i++) {
			output += "\n" + players[i].toString();
		}
		return output;
	}
	
	
}
