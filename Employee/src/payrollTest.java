import java.io.*;
import java.util.Scanner;
public class payrollTest {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		int ans = 1;
		do {
			PrintWriter writer = new PrintWriter(new File("payroll.txt"));
			String path = "100emps.txt";
			Payroll p1 = new Payroll(path);
			System.out.println(p1.toString());
			writer.println(p1.toString());
			System.out.println("Run Again?");
			ans = Integer.parseInt(scanner.nextLine());
			writer.close();
		}while(ans == 1);
		
		scanner.close();
		
	}
}
