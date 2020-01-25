
abstract public class Student {
	protected String fname;
	protected String lname;
	protected int myid;
	protected int s1, s2, s3;
	double fee;
	
	public Student() {
		fname = "";
		lname = "";
		s1 = 0; //homework/labs
		s2 = 0; //tests
		s3 = 0; //projects
		fee = 0;
		totalStus++;
		myid  = idnum;
		idnum++;
	}
	
	public void setName(String f, String l) {
		fname  = f;
		lname = l;
	}
	
	public void setScore1(int n) {
		s1 = n;
	}
	
	public void setScore2(int n) {
		s2 = n;
	}
	
	public void setScore3(int n) {
		s3 = n;
	}
	
	public String getFname() {
		return fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public int getScore1() {
		return s1;
	}
	
	public int getScore2() {
		return s2;
	}
	
	public int getScore3() {
		return s3;
	}
	
	public double getFees() {
		return fee;
	}
	
	public String getName() {
		String output;
		output = fname + " " + lname;
		return output;
	}
	
	public String toString() {
		String output = "";
		output = getFname() + " " + getLname() + "\nID: " + myid + "\nHomework/labs: " + s1 + "\nTests: " + s2 + "\nProjects: " + s3 + "\nAverage: " + getAverage();
		if (this instanceof HSStu || this instanceof MSStu || this instanceof collegeStu) {
			output += "\nGPA: " + getGPA();
		}
		output += "\nFee: $" + fee;
		if (this instanceof HSStu) {
			output += "\nSchool: High School";
		}
		else if (this instanceof MSStu) {
			output += "\nSchool: Middle School";
		}
		else if (this instanceof ElemStu) {
			output += "\nSchool: Elementray School";
		}
		else if (this instanceof collegeStu) {
			output += "\nSchool: College";
		}
		
		return output;
	}
	
	abstract public double getAverage();
	abstract public double getGPA();
	
	//--------------------------------------------------------
	
	protected static int totalStus = 0;
	protected static double totalFees = 0;
	protected static int idnum = 100000;
	
	protected static int totalHSStus = 0;
	protected static int totalMSStus = 0;
	protected static int totalElemStus = 0;
	protected static int totalCollegeStus = 0;
	
	protected static double totalHSfee = 0;
	protected static double totalMSfee = 0;
	protected static double totalElemfee = 0;
	protected static double totalCollegefee = 0;
	
	protected static double HSscore = 0;
	protected static double MSscore = 0;
	protected static double Elemscore = 0;
	protected static double Colscore = 0;
	
	public static double getHSaverage() {
		return (HSscore / totalHSStus);
	}
	
	public static double getMSaverage() {
		return (MSscore / totalMSStus);
	}
	
	public static double getElemaverage() {
		return (Elemscore / totalElemStus);
	}
	
	public static double getColAverage() {
		return (Colscore / totalCollegeStus);
	}
	
	public static int getTotalCollegeStus() {
		return totalCollegeStus;
	}
	
	public static int getTotalStus() {
		return totalStus;
	}
	
	public static double getTotalFees() {
		return totalFees;
	}
	
	public static int getTotalHS() {
		return totalHSStus;
	}
	
	public static int getTotalElem() {
		return totalElemStus;
	}
	
	public static int getTotalMS() {
		return totalMSStus;
	}
	
	public static int getHSfees() {
		return (getTotalHS() * 100);
	}
	
	public static int getMSfees() {
		return (getTotalMS() * 50);
	}
	
	public static int getELfees() {
		return (getTotalElem() * 25);
	}
	
	public static int getColFees() {
		return (getTotalCollegeStus() * 1000);
	}
}