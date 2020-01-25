import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;

public class GUI {
	static JTextArea input = new JTextArea();
	static JFrame theGUI = new JFrame("Loan Amortization Table");
	static JFrame loanTable = new JFrame("Table");
	
	public static void main(String[] args) {
		
		theGUI.setLayout(null);
		theGUI.setSize(400, 300);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		input.setSize(100,50);
		input.setLocation(100,100);
		input.setBackground(Color.WHITE);
		theGUI.add(input);
		JButton gInput = new JButton("Enter");
		gInput.addActionListener(new getInput());
		gInput.setLocation(200, 100);
		gInput.setSize(100,50);
		theGUI.add(gInput);
		theGUI.setVisible(true);
		
		
	}
	
	static class getInput implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Getting input");
			System.out.println(input.getText());
			double price = Double.parseDouble(input.getText());
			double dPayment = 0.1 * price;
			double balance = price - dPayment;
			
			theGUI.setVisible(false);
			
			loanTable.setSize(600, 600);
			loanTable.setLayout(new BorderLayout());
			loanTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			//month, balance owed, interest, principal owed, payment for that month, balance remaining
			ArrayList<Integer> months = new ArrayList<Integer>();
			ArrayList<Double> bBalance = new ArrayList<Double>();
			ArrayList<Double> interest = new ArrayList<Double>();
			ArrayList<Double> mPayment = new ArrayList<Double>();
			ArrayList<Double> principal = new ArrayList<Double>();
			ArrayList<Double> fBalance = new ArrayList<Double>();
			int month = 0;
		
			String lItem;
			for(int i = 0; balance > 0; i++) {
				months.add(i + 1);
				bBalance.add(balance);
				double mpay = 0.05 * (price - dPayment);
				//if(balance - mpay < 0) {
					//mpay = balance;
				//}
				
				double intrst = balance * (0.12 / 12);
				
				interest.add(intrst);
				System.out.println(intrst);
				double princ = mpay - intrst;
				if (balance - princ < 0) {
					princ = balance;
					mpay = princ + intrst;
				}
				principal.add(princ);
				mPayment.add(mpay);
				balance = balance - princ;
				if (balance < 0) {
					balance = 0;
				}
				fBalance.add(balance);
			}
			
			String[] lItems = new String[months.size() + 1];
			
			lItems[0] = "Month   Balanced Owed   Interest   Principal   Payment   Remaining Balance";
						//5      24              8          9           7         17
			for(int i = 0; i < months.size(); i++) {
				int sMonth = (months.get(i));
				double sbBal = (Math.round(bBalance.get(i) * 100.0) / 100.0);
				double sInt = (Math.round(interest.get(i) * 100.0) / 100.0);
				double smPay = (Math.round(mPayment.get(i) * 100.0) / 100.0);
				double sPrinc = (Math.round(principal.get(i) * 100.0) / 100.0);
				double sfBal = (Math.round(fBalance.get(i) * 100.0) / 100.0);
				
			
				
				lItems[i+1] = String.format("%5d", sMonth) + "   " + String.format("%12.2f", sbBal) + "   " + String.format("%8.2f", sInt) + "   "
				+ String.format("%10.2f", sPrinc) + "   " + String.format("%7.2f", smPay) + "   " + String.format("%17.2f", sfBal);
			}
			
			
			JList list = new JList(lItems);
			Font f1 = new Font("Consolas", 1, 12);
			
			list.setFont(f1);
			loanTable.add(list, BorderLayout.CENTER);
			
			loanTable.setVisible(true);
			
			
		}
	}
	
	
}
