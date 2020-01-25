import java.util.Random;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.*;

public class Employee {
	private String FName;
	private String LName;
	private int hours;
	private int idNum;
	private int age;
	private double wage;
	private String marStat;
	private String gender;
	
	
	
	public Employee(String f, String l, int a, String g, String ms, int id, int h, double w) {
		//first, last, age, gender, relationship status, id, hours, wage
		FName = f;
		LName = l;
		idNum = id;
		hours = h;
		wage = w;
		age = a;
		
		gender = g;
		marStat = ms;
	}
	
	public Employee(String f, String l, String g) {
		DecimalFormat format1 = new DecimalFormat("##.##");
		Random bob = new Random();
		FName = f;
		LName = l;
		gender = g;
		if(bob.nextInt(2) == 0) {
			marStat = "Married";
		}
		else {
			marStat = "Single";
		}
		idNum = bob.nextInt(999999);
		hours = bob.nextInt(1600) + 400;
		wage = bob.nextDouble() + bob.nextInt(450) + 9;
		wage = Double.valueOf(format1.format(wage));
		age = bob.nextInt(75) + 13;
		
		
		
	}
	
	public void randFill() throws IOException{
		DecimalFormat format1 = new DecimalFormat("##.##");
		Scanner malenames = new Scanner(new File("malefirstnames.txt"));
		Scanner femalenames = new Scanner(new File("femalefirstnames.txt"));
		Scanner lastnames = new Scanner(new File("LastNames.txt"));
		
		
		String[] Malefirst = new String[1400];
		String[] Femalefirst = new String[5000];
		String[] last = new String[70000];
		
		int a = 0;
		while(malenames.hasNext()) {
			Malefirst[a] = malenames.nextLine();
			a++;
		}
		
		int b = 0;
		while(femalenames.hasNext()) {
			Femalefirst[b] = femalenames.nextLine();
			b++;
		}
		
		int c = 0;
		while(lastnames.hasNext()) {
			last[c] = lastnames.nextLine();
			c++;
		}
		
		
		
	
		Random bob = new Random();
		if(bob.nextInt(2) == 0) {
			int f = bob.nextInt(a);
			FName = Malefirst[f];
			gender = "M";
		}
		else {
			int f = bob.nextInt(b);
			FName = Femalefirst[f];
			gender = "F";
		}
		
		if(bob.nextInt(2)== 0) {
			marStat = "Married";
		}
		else {
			marStat = "Single";
		}
		
		
		int l = bob.nextInt(c);
		LName = last[l];
		idNum = bob.nextInt(999999 - 100000) + 100000;
		hours = bob.nextInt(40) + 7;
		wage = bob.nextDouble() + bob.nextInt(250) + 9;
		wage = Double.valueOf(format1.format(wage));
		age = bob.nextInt(75-18) + 18;
		
		
		
		malenames.close();
		femalenames.close();
		lastnames.close();
	}
	
	
	public Employee() {
		FName = "";
		LName = "";
		hours = 0;
		wage = 0;
		age = 0;
		idNum = 0;
		marStat = "";
		
		
		gender = "";
		
	}
	
	public String getMarStat() {
		return marStat;
	}
	
	public void setMarStat(String m) {
		marStat = m;
	}
	
	public String getFullName() {
		String x = FName + " " + LName;
		return x;
	}
	
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String g) {
		gender = g;
	}
	
	public String canVote() {
		if(age >= 18) {
			return "yes";
		}
		else {
			return "no";
		}
		
	}
	
	public void addHours(int h) {
		hours = hours + h;
		
	}
	
	public void addWage(double w) {
		wage = wage + w;
	}

	public void addAge(int a) {
		age = age + a;
	}
	
	public double netPay() {
		double grossPay = wage * hours;
		double x = grossPay - (0.05 * grossPay);
		x = (x * 100.0) / 100.0;
		return x;
	}
	

	
	
	public void setAge(int a) {
		age = a;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setID(int id) {
		idNum = id;
	}
	
	public int getID() {
		return idNum;
	}
	
	
	public void setFName(String f) {
		FName = f;
	}
	
	public String getFName() {
		return FName;
	}
	
	public void setLName(String l) {
		LName = l;
	}
	
	public String getLName() {
		return LName;
	}
	
	public void setHours(int h) {
		hours = h;
		
	}
	
	public double getHours() {
		return hours;
	}
	
	public void setWage(double w) {
		wage = w;
		
	}
	
	public double getWage() {
		return wage;
		
	}
	
	public String toString() {
		DecimalFormat format1 = new DecimalFormat("##.##");
		double grossPay = ((wage * hours) * 100.0)/100.0;
		grossPay = Double.valueOf(format1.format(grossPay));
		String x;
		String vote = canVote();
		
		x = FName + "\n" + LName + "\n" + age + "\n" + gender + "\n" + marStat + 
				"\n" + idNum + "\n" + hours + "\n" + wage;
		
		return x;
	}
	
	
}
