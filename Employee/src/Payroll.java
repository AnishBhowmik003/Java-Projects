import java.util.Scanner;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
public class Payroll {
	//use protected instead private if you want to use data from other class
	
	//4 if tests, find gross pay * 52, 4 if tests for fed tax, 4 if tests for state
	//take 2% for each dependent on fed, 1% for state for each dependent
	
	
	private PayrollEmp[] arremps = new PayrollEmp[100];
	
	
	public Payroll(String path) throws IOException {
		for(int i = 0; i < 100; i++) {
			arremps[i] = new PayrollEmp();
		}
		Scanner file1 = new Scanner(new File(path));
		int c = 0;
		while(file1.hasNextLine()) {
			
				arremps[c].setFName(file1.nextLine());
				arremps[c].setLName(file1.nextLine());
				arremps[c].setAge(Integer.parseInt(file1.nextLine()));
				arremps[c].setGender(file1.nextLine());
				arremps[c].setMarStat(file1.nextLine());
				arremps[c].setID(Integer.parseInt(file1.nextLine()));
				arremps[c].setHours(Integer.parseInt(file1.nextLine()));
				arremps[c].setWage(Double.parseDouble(file1.nextLine()));
				arremps[c].setDep(Integer.parseInt(file1.nextLine()));
				c++;
		}
		file1.close();
		
	}
	
	
	
	public Payroll(PayrollEmp[] e) {
		for(int i = 0; i< 100; i++) {
			arremps[i] = e[i];
		}
	}
	
	public Payroll() {
		
		for(int i = 0; i< 100; i++) {
			arremps[i] = new PayrollEmp();
		}
		
		
	}
	public double totalGrossPay() {
		double tgrosspay = 0;
		for(int i = 0; i < 100; i++) {
			tgrosspay = tgrosspay + arremps[i].findGrossPay();
		}
		return tgrosspay;
	}
	
	public double totalNetPay() {
		double tnetpay = 0;
		
		for(int i = 0; i < 100; i++) {
			tnetpay = tnetpay + arremps[i].findNP();
		}
		return tnetpay;
	}
	
	public double totalFedTax() {
		double tfedtax = 0;
		for(int i = 0; i < 100; i++) {
			tfedtax = tfedtax + (arremps[i].findGrossPay() * arremps[i].findFed());
		}
		return tfedtax;
	}
	
	public double totalStateTax() {
		double tstatetax = 0;
		for(int i = 0; i < 100; i++) {
			tstatetax = tstatetax + (arremps[i].findGrossPay() * arremps[i].findState());
		}
		return tstatetax;
	}
	
	public double totalLocalTax() {
		double tlocaltax = 0;
		for(int i = 0; i < 100; i++) {
			tlocaltax = tlocaltax + (arremps[i].findGrossPay() * arremps[i].findLocal());
		}
		return tlocaltax;
	}
	
	public double totalSocialSecurityTax() {
		double tsstax = 0;
		for(int i = 0; i < 100; i++) {
			tsstax = tsstax + (arremps[i].findGrossPay() * arremps[i].findSS());
		}
		
		return tsstax;
	}
	
	public double NetMinusGross() {
		double x;
		x = totalGrossPay() - totalNetPay();
		return x;
	}
	
	public double meanNetPay() {
		double sum = 0;
		for(int i = 0; i < 100; i++) {
			sum = sum + arremps[i].findNP();
		}
		double average = sum / 100;
		return average;
	}
	
	public double meanGrossPay() {
		double sum = 0;
		for(int i = 0; i < 100; i++) {
			sum = sum + arremps[i].findGrossPay();
		}
		double average = sum / 100;
		return average;
	}
	
	public double meanDeps() {
		double sum = 0;
		for(int i = 0; i < 100; i++) {
			sum = sum + arremps[i].getDep();
		}
		double average = sum / 100;
		return average;
	}
	
	public double medianNetPay() {
		double[] netpays = new double[100];
		for(int i = 0; i < 100; i++) {
			netpays[i] = arremps[i].findNP();
		}
		Arrays.sort(netpays);
		double median = (netpays[48] + netpays[49]) / 2;
		return median;
		
	}
	
	public double medianGrossPay() {
		double[] grosspays = new double[100];
		for(int i = 0; i < 100; i++) {
			grosspays[i] = arremps[i].findGrossPay();
		}
		Arrays.sort(grosspays);
		double median = (grosspays[48] + grosspays[49]) / 2;
		return median;
	}
	
	public double medianDeps() {
		int[] deps = new int[100];
		for(int i = 0; i < 100; i++) {
			deps[i] = arremps[i].getDep();
		}
		Arrays.sort(deps);
		double median = (deps[48] + deps[49]) / 2;
		return median;
	}
	
	public double rangeNetPay() {
		double[] netpays = new double[100];
		for(int i = 0; i < 100; i++) {
			netpays[i] = arremps[i].findNP();
		}
		Arrays.sort(netpays);
		double range = netpays[99] - netpays[0];
		return range;
	}
	
	public double rangeGrossPay() {
		double[] grosspays = new double[100];
		for(int i = 0; i < 100; i++) {
			grosspays[i] = arremps[i].findGrossPay();
		}
		Arrays.sort(grosspays);
		double range = grosspays[99] - grosspays[0];
		return range;
	}
	
	public double rangeDeps() {
		int[] deps = new int[100];
		for(int i = 0; i < 100; i++) {
			deps[i] = arremps[i].getDep();
		}
		Arrays.sort(deps);
		double range = deps[99] - deps[0];
		return range;
	}
	
	public double standDevNetPay() {
		double mean = meanNetPay();
		double[] arrdiff = new double[100];
		double sum = 0;
		for(int i = 0; i < 100; i++) {
			arrdiff[i] = mean - arremps[i].findNP();
			arrdiff[i] = arrdiff[i] * arrdiff[i];
			sum = sum + arrdiff[i];
		}
		double deviation = Math.pow(sum / 100, 0.5);
		return deviation;
		
	}
	
	public double standDevGrossPay() {
		double mean = meanGrossPay();
		double[] arrdiff = new double[100];
		double sum = 0;
		for(int i = 0; i < 100; i++) {
			arrdiff[i] = mean - arremps[i].findGrossPay();
			arrdiff[i] = arrdiff[i] * arrdiff[i];
			sum = sum + arrdiff[i];
		}
		double deviation = Math.pow(sum / 100, 0.5);
		return deviation;
		
	}
	
	public double standDevDeps() {
		double mean = meanDeps();
		double[] arrdiff = new double[100];
		double sum = 0;
		for(int i = 0; i < 100; i++) {
			arrdiff[i] = mean - arremps[i].getDep();
			arrdiff[i] = arrdiff[i] * arrdiff[i];
			sum = sum + arrdiff[i];
		}
		double deviation = Math.pow(sum / 100, 0.5);
		return deviation;
		
	}
	
	public double varianceGP() {
		double var = Math.pow(standDevGrossPay(), 2);
		return var;
	}
	
	public double varianceNP() {
		double var = Math.pow(standDevNetPay(), 2);
		return var;
	}
	
	public double varianceDeps() {
		double var = Math.pow(standDevDeps(), 2);
		return var;
	}
	
	public String toString() {
		
		DecimalFormat df = new DecimalFormat("0.00");
		String output = "";
		for(int i = 0; i < 100; i++) {
			output = output + "\n" + arremps[i].paystub();
		}
		output = output + "\n" + "\nTotal Gross Pay: $" + df.format(totalGrossPay()) + "\nTotal Fed Tax: $" + df.format(totalFedTax())
				+ "\nTotal State Tax: $" + df.format(totalStateTax()) + "\nTotal Local Tax: $" + df.format(totalLocalTax())
				+"\nTotal SS Tax: $" + df.format(totalSocialSecurityTax()) + "\nTotal Net Pay: $" + df.format(totalNetPay())
				+ "\nTotal Amount of Tax: $" + df.format(NetMinusGross()) + "\n\nMean Gross Pay: $" + df.format(meanGrossPay())
				+ "\nMedian Gross Pay: $" + df.format(medianGrossPay()) + "\nRange of Gross Pay: $" + df.format(rangeGrossPay())
				+ "\nStand. Dev. Gross Pay: $" + df.format(standDevGrossPay()) + "\nVariance of GP: $"+ df.format(varianceGP()) + "\n\nMean Net Pay: $" + df.format(meanNetPay())
				+ "\nMedian Net Pay: $" + df.format(medianNetPay()) + "\nRange of Net Pay: $" + df.format(rangeNetPay())
				+ "\nStand. Dev. Net Pay: $" + df.format(standDevNetPay()) + "\nVariance of NP: $" + df.format(varianceNP()) + "\n\nMean Dependents: " + df.format(meanDeps())
				+ "\nMedian Dependents: " + medianDeps() + "\nRange of Deps: " + rangeDeps() + "\nStand. Dev. of Deps: "
				+ df.format(standDevDeps()) + "\nVariance of Deps: " + df.format(varianceDeps()); 
		return output;
	}
	
}
