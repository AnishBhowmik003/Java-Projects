import java.util.Scanner;
import java.io.*;
public class empTester {

	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		
		PrintWriter writer = new PrintWriter(new File("100emps.txt"));
		String ans = "y";
		do {
			
		PayrollEmp[] payemps = new PayrollEmp[100];	
		
		
		
		for(int i =  0; i < 100; i++) {
			
			payemps[i] = new PayrollEmp();
			payemps[i].randFill();
			writer.println(payemps[i].toString());
			//System.out.println(payemps[i].toString());
			System.out.println(payemps[i].paystub());
		}
		writer.close();
		
		
		
		System.out.println("Saved txt file");
		
		
		System.out.println("\nRun again?(y/n)");
		ans = scanner.nextLine();
		
		
		}while(ans.equals("y"));
		scanner.close();
	}

}