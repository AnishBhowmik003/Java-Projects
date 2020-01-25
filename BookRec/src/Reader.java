
public class Reader {
	private String name;
	private int[] scores = new int[55];
	
	public Reader() {
		name = "";
	}
	
	public Reader(String n, int[] s) {
		name = n;
		scores = s;
	}
	
	public int getScore(int n) {
		return (scores[n]);
		
	}
	
	public void setScore(int n, int s) {
		scores[n] = s;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public int[] getScores() {
		return scores;
	}
	
	public void setScores(int[] nums) {
		scores = nums;
	}
	
	public String toString() {
		String output = name + "\n ";
		for(int i = 0; i < 55; i++) {
			output += scores[i] + " ";
		}
		return output;
	}
}
