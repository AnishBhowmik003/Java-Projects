
public class Player {
	private String name;
	private int score;
	
	public Player(String n) {
		name = n;
		score = 0;
	}
	public Player() {
		name = "";
		score = 0;
	}
	public Player(String n, int s) {
		name = n;
		score = s;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setScore(int s) {
		score = s;
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public String toString() {
		String output = getName() + ": " + getScore();
		return output;
	}
}
