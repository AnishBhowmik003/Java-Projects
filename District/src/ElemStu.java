
public class ElemStu extends Student{
	public ElemStu() {
		super();
		totalElemStus++;
		fee = 25;
		totalElemfee += fee;
		totalFees += fee;
	}
	
	public double getAverage() {
		double a = 0;
		//hw/labs, tests, projects
		//1 = hw, 2 = tests, 3 = projects
		a = (0.5 * s1) + (0.4 * s2) + (0.1 * s3);
		Elemscore += a;
		return a;
	}
	
	public double getGPA() {
		double a = getAverage();
		Elemscore += a;
		return (-1);
		
		
	}
}
