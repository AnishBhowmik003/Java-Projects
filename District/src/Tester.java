import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class Tester {
	public static void main(String[] args) throws IOException{
		Scanner l = new Scanner(new File("LastNames.txt"));
		Scanner mf = new Scanner(new File("MaleNamesDictionary.txt"));
		Scanner ff = new Scanner(new File("FemaleNamesDictionary.txt"));
		
		String lnames[] = new String[65536];
		String ffnames[] = new String[4275];
		String mfnames[] = new String[1219];
		
		int f = 0;
		while(l.hasNextLine()) {
			lnames[f] = l.nextLine();
			f++;
		}
		l.close();
		f = 0;
		while(mf.hasNextLine()) {
			mfnames[f] = mf.nextLine();
			
			f++;
		}
		f = 0;
		mf.close();
		while(ff.hasNextLine()) {
			ffnames[f] = ff.nextLine();
			f++;
		}
		ff.close();
		
		Student stus[] = new Student[1000];
		Random rand = new Random();
		for(int i = 0; i < 1000; i++) {
			int s = rand.nextInt(4);
			switch(s) {
			case 0:
				stus[i] = new HSStu();
				break;
			case 1:
				stus[i] = new MSStu();
				break;
			case 2:
				stus[i] = new ElemStu();
				break;
				
			case 3:
				stus[i] = new collegeStu();
				break;
			}
			
			int g = rand.nextInt(1);
			if(g == 0) {
				int ln = rand.nextInt(65536);
				int fn = rand.nextInt(4275);
				stus[i].setName(ffnames[fn], lnames[ln]);
			}
			else {
				int ln = rand.nextInt(65536);
				int mn = rand.nextInt(1219);
				stus[i].setName(mfnames[mn], lnames[ln]);
			}
			int t1 = rand.nextInt(100);
			int t2 = rand.nextInt(100);
			int t3 = rand.nextInt(100);
			stus[i].setScore1(t1);
			stus[i].setScore2(t2);
			stus[i].setScore3(t3);
			System.out.println(stus[i].toString());
			System.out.println();
		}
		System.out.println("Total students: "+  Student.getTotalStus());
		System.out.println("Total HIgh School Students: " + Student.getTotalHS());
		System.out.println("Total Elementary Students: " + Student.getTotalElem());
		System.out.println("Total Middle School Students: " + Student.getTotalMS());
		System.out.println("Total College Students: " + Student.getTotalCollegeStus());
		System.out.println("\nTotal Fees: $" + Student.getTotalFees());
		System.out.println("HS Fees: $" + Student.getHSfees());
		System.out.println("MS fees: $" + Student.getMSfees());
		System.out.println("EL fees: $" + Student.getELfees());
		System.out.println("Col fees: $" + Student.getColFees());
		System.out.println("\nHS Average Grade: " + Student.getHSaverage());
		System.out.println("MS Average Grade: " + Student.getMSaverage());
		System.out.println("EL Average Grade: " + Student.getElemaverage());
		System.out.println("Col Average Grade: " + Student.getColAverage());
	}
}
