import java.util.Scanner;
import java.io.*;
import javax.swing.*;
import java.awt.*;
public class lab410 {

	public static void main(String[] args) throws IOException {
		
		Scanner reader = new Scanner(new File("teachers.txt"));
		Scanner scanner = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(new File("teacher2.txt"));
		
		//String inputStr = JOptionPane.showInputDialog("Enter name", "");
		
		String ans = "y";
		do {
			
			int flag = 0;
			int choice;
			double startSalary = 0 ;
			int educationLvl = 0;
			int years = 0;
			do {
				choice = Integer.valueOf(JOptionPane.showInputDialog("1. manual entry\n2. read file"));
				
				if(choice == 1) {
					flag = 1;
					System.out.println("executing manual entry");
					startSalary = Double.valueOf(JOptionPane.showInputDialog("Enter starting salary", ""));
					educationLvl = Integer.valueOf(JOptionPane.showInputDialog("Enter education level", ""));
					years = Integer.valueOf(JOptionPane.showInputDialog("Enter years", ""));
					writer.println(startSalary);
					writer.println(educationLvl);
					writer.println(years);
					writer.close();
					
					
				}
				else if(choice == 2) {
					flag = 1;
					System.out.println("reading file");
					while(reader.hasNext()) {
						startSalary = reader.nextDouble();
						educationLvl = reader.nextInt();
						years = reader.nextInt();
					}
					
				}
				else {
					flag = 0;
					System.out.println("Enter valid answer");
				}
				
			}while(flag == 0);
			
			chart(startSalary);
			double salary = 0;
			
			if(educationLvl == 1) {
				salary = startSalary * (Math.pow(1.02,  years));
			}
			else if(educationLvl == 2) {
				salary = startSalary * (Math.pow(1.05,  years));
			}
			else if(educationLvl == 3) {
				salary = startSalary * (Math.pow(1.10,  years));
			}
			
			salary = (Math.round(salary * 100.0)) / 100.0;
			JOptionPane.showMessageDialog(null, salary);
			
			
			
			
			
			ans = JOptionPane.showInputDialog("Run Again?(y/n)", "");
			
		}while(ans.equals("y"));
		
		
		
		reader.close();
		writer.close();
		
		
	}
	
	static void chart(double startSal) throws IOException {
		double bach, master, phd;
		bach = startSal;
		master = startSal;
		phd = startSal;
		PrintWriter writer = new PrintWriter(new File("sched.txt"));
		
		
		System.out.println("	Bachelors     Masters     PHD");
		for(int i = 0; i <= 20; i++) {
			bach = startSal * (Math.pow(1.02, i));
			master =startSal * (Math.pow(1.05,  i));
			phd = startSal * (Math.pow(1.10,  i));
			
			bach = (Math.round(bach * 100.0)) / 100.0;
			master = (Math.round(master * 100.0)) / 100.0;
			phd = (Math.round(phd * 100.0)) / 100.0;
			System.out.println((i) + "     " + bach + "     " + master + "     " + phd);
			writer.println((i) + "     " + bach + "     " + master + "     " + phd);
			
		}
		writer.close();
	}
	

}
