import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class PayrollEmp extends Employee {
	private int ndep;
	
	public PayrollEmp() {
		super();
		ndep = 0;
	}
	
	public PayrollEmp(String fn, String ln,int a,String g, String ms,  int hw, double w, int IDnum, int nd) {
		
		super(fn, ln, a, g, ms, IDnum, hw, w);
		
		ndep = nd;	
		
	}
	
	public int getDep() {
		return ndep;
	}
	
	public void setDep(int d) {
		ndep = d;
	}
	
	public void randFill() throws IOException {
		super.randFill();
		Random bob = new Random();
		ndep = bob.nextInt(5);
	}
	
	public double findGrossPay() {
		double x = super.getWage() * super.getHours();
		x = (x * 100.0) / 100.0;
		return x;
	}
	
	public double findFed() {
		double taxrate = 0;
		if (0 <= findGrossPay() &&  findGrossPay() <= (9700/52)) {
			taxrate = 0.1;
		}
		else if (findGrossPay() <= (39475/52)) {
			taxrate = 0.12;
		}
		else if (findGrossPay() <= (84200/52)) {
			taxrate = 0.22;
		}
		else if (findGrossPay() <= (160725/52)) {
			taxrate = 0.24;
		}
		else if (findGrossPay() <= (204100/52)) {
			taxrate = 0.32;
		}
		else if(findGrossPay() <= (510300/52)) {
			taxrate = 0.35;
		}
		else  {
			taxrate = 0.37;
		}
		
		taxrate = taxrate - (0.02 * ndep);
		return taxrate;
		
	}
	
	public double findState() {
		double taxrate = 0;
		if(findGrossPay() < (16300/52)) {
			taxrate = 0.0198;
		}
		else if(findGrossPay() < (21750/52)) {
			taxrate = 0.0248;
		}
		else if(findGrossPay() < (43450/52)) {
			taxrate = 0.0297;
		}
		else if(findGrossPay() < (86900/52)) {
			taxrate = 0.0346;
		}
		else if(findGrossPay() < (108700/52)) {
			taxrate = 0.0396;
		}
		else if(findGrossPay() < (217400/52)) {
			taxrate = 0.046;
		}
		else {
			taxrate = 0.05;
		}
		
		taxrate = taxrate - (0.005 * ndep);
		
		return taxrate;
	}
	
	public double findLocal() {
		double taxrate = 0.0112;
		return taxrate;
	}
	
	public double findSS() {
		double taxrate = 0.062;
		return taxrate;
	}
	
	
	public double findNP() {
		double netPay;
		double gp = findGrossPay();
		netPay = gp - (findFed() * gp) - (findState() * gp) - (findLocal() * gp)
				- (findSS() * gp);
		return netPay;
	}
	
	public double YTD(double num) {
		Calendar cal1 = Calendar.getInstance();
		int dayOfYear = cal1.get(Calendar.DAY_OF_YEAR);
		int year = cal1.get(Calendar.YEAR);
		Calendar cal2 = new GregorianCalendar(year,11,31);
		int day = cal2.get(Calendar.DAY_OF_YEAR);
		int total_days = day - dayOfYear;
		int tempD = 52 - ((int)(total_days/7));
		return(num * tempD);
	}
	
	public String toString() {
		return (super.toString() + "\n" + ndep);
	}
	
	public String paystub() {
		DecimalFormat df = new DecimalFormat("0.00");
		String stub = "";
		double gp = findGrossPay();
		
		stub = ("------------------\nName: " + super.getFName() + " " + super.getLName() + "	ID: " + super.getID()+ "\nMaritial Status: " + super.getMarStat()
		+ "\nGender: " + super.getGender() + "\nHours: " + super.getHours() + "\nWage: $" + df.format(super.getWage()) + "\nGross Pay: $" + df.format(gp) + 
		"	YTD: $" + df.format(YTD(findGrossPay()))+"\nDependents: "
		+ ndep + "\n\nFederal Tax: $" + df.format(findFed() * gp) +"	YTD: $" + df.format(YTD(findFed() * gp)) + "\nState Tax: $" + df.format(findState() * gp)
		+"	YTD: $" + df.format(YTD(findState() * gp))+ "\nLocal Tax: $" +
		df.format(findLocal() * gp) +"	YTD: $" + df.format(YTD(findLocal() * gp)) + "\nSS Tax: $" + df.format(findSS() * gp) +"        YTD: $"
		+ df.format(YTD(findSS() * gp))+ "\n\nNet Pay: $" + df.format(findNP()) + "	YTD: $" + df.format(YTD(findNP())) + "\n------------------");
		
		return stub;
	}
	
}