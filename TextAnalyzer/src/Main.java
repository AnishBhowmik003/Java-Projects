import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		String ans = "y";
		Scanner scanner = new Scanner(System.in);
		do {
			
			System.out.println("Enter Word: ");
			Word w1 = new Word(scanner.next());
			System.out.println(w1.getSyllables());
			System.out.println("Run Again? ");
			ans = scanner.next();
		}while(ans.equals("y"));
		
		scanner.close();
	}
}
