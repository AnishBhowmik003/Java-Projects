
public class MSStu extends Student{
	public MSStu() {
		super();
		totalMSStus++;
		fee = 50;
		totalMSfee += fee;
		totalFees += fee;
	}
	
	public double getAverage() {
		double a = 0;
		//hw/labs, tests, projects
		//1 = hw, 2 = tests, 3 = projects
		a = (0.3 * s1) + (0.3 * s2) + (0.4 * s3);
		
		return a;
	}
	
	public double getGPA() {
		double g = 0;
		double a = getAverage();
		MSscore += a;
		if (a >= 89.5) {
			g = 4;
		}
		else if (a >= 79.5) {
			g = 3;
		}
		else if (a >= 69.5) {
			g = 2;
		}
		else if( a >= 59.5) {
			g = 1;
		}
		else {
			g = 0;
		}
		return g;
	}
	
}
