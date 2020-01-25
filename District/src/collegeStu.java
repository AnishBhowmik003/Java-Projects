
public class collegeStu extends Student{
	
	public collegeStu() {
		super();
		totalCollegeStus++;
		fee = 1000;
		totalCollegefee += fee;
		totalFees += fee;
	}
	
	
	public double getAverage() {
		double a;
		//hw/labs, tests, projects
		//1 = hw, 2 = tests, 3 = projects
		a = (0.1 * s1) + (0.4 * s2) + (0.5 * s3);
		
		return a;
	}

	
	public double getGPA() {
		double g = 0;
		double a = getAverage();
		Colscore += a;
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
