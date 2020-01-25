import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
public class GUI {
	
	static Matrix m1;
	static Matrix m2;
	
	static JFrame theGUI = new JFrame();
	static JMenuBar menubar = new JMenuBar();
	static JMenu functions = new JMenu("Functions");
	static JMenu other = new JMenu("Other");
	static JMenuItem add = new JMenuItem("Addition");
	static JMenuItem subtract = new JMenuItem("Subtraction");
	static JMenuItem mult = new JMenuItem("Multiply");
	static JMenuItem scalMult = new JMenuItem("Scalar Multiplication");
	static JMenuItem clear = new JMenuItem("Clear");
	
	static JMenuItem editM1 = new JMenuItem("Edit Matrix 1");
	static JMenuItem editM2 = new JMenuItem("Edit Matrix 2");
	
	static JMenuItem randFill1 = new JMenuItem("Random Fill Matrix 1");
	static JMenuItem randFill2 = new JMenuItem("Random Fill Matrix 2");
	
	static JMenuItem fileFill1 = new JMenuItem("File Fill Matrix 1");
	static JMenuItem fileFill2 = new JMenuItem("File Fill Matrix 2");
	
	static JTextArea label = new JTextArea();
	
	static JTextArea rArea = new JTextArea();
	static JTextArea lArea = new JTextArea();
	
	
	public static void main(String[] args) {
		
		theGUI.setTitle("Matrix");
		theGUI.setSize(900, 500);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theGUI.setFocusable(true);
		theGUI.setVisible(true);
		
		
		
		
		//theGUI.add(vMat1);
		//theGUI.add(vMat2);
		theGUI.setLayout(new GridLayout(1,3));
		theGUI.add(menubar);
		theGUI.setJMenuBar(menubar);
		
		
		
		theGUI.add(rArea);
		theGUI.add(label);
		theGUI.add(lArea);
		
		Font font = new Font("Verdana", Font.BOLD, 30);
		rArea.setFont(font);
		label.setFont(font);
		lArea.setFont(font);
		
		//theGUI.add(label, BorderLayout.NORTH);
		
		
		
		//theGUI.add(rArea, BorderLayout.WEST);
		//theGUI.add(lArea, BorderLayout.EAST);
		
		menubar.add(functions);
		menubar.add(other);
		functions.add(add);
		functions.add(subtract);
		functions.add(mult);
		functions.add(scalMult);
		other.add(clear);
		
		other.add(editM1);
		other.add(editM2);
		other.add(randFill1);
		other.add(randFill2);
		other.add(fileFill1);
		other.add(fileFill2);
		
		
		rArea.setEditable(false);
		lArea.setEditable(false);
		label.setEditable(false);
		
		
		
		//vMat2.setLocation(400, 400);
		//vMat1.setLocation(30, 400);
		
		add.addActionListener(new addition());
		subtract.addActionListener(new subtraction());
		mult.addActionListener(new multiplication());
		scalMult.addActionListener(new scalarMultiplication());
		
		clear.addActionListener(new Clear());
		
		editM1.addActionListener(new editMatrix1());
		editM2.addActionListener(new editMatrix2());
		
		
		randFill1.addActionListener(new rFill1());
		randFill2.addActionListener(new rFill2());
		
		fileFill1.addActionListener(new fFill1());
		fileFill2.addActionListener(new fFill2());
	}
	
	
	static class fFill1 implements ActionListener {
		public void actionPerformed(ActionEvent e){
			System.out.println("File fill 1");
			try {
				m1 = new Matrix("matrix1.txt");
				rArea.setText(m1.toString());
				System.out.println(m1.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	static class fFill2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("File fill 2");
			try {
				m2 = new Matrix("matrix2.txt");
				lArea.setText(m2.toString());
				System.out.println(m2.toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	static class editMatrix1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Edit Matrix 1");
			int r = Integer.parseInt(JOptionPane.showInputDialog("Enter # of rows", null));
			int c = Integer.parseInt(JOptionPane.showInputDialog("Enter # of columns", null));
			System.out.println("Rows: " + r);
			System.out.println("Columns: " + c);
			
			
			m1 = new Matrix(r,  c);
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					int x = Integer.parseInt(JOptionPane.showInputDialog("Enter number " + (j + 1) + " for row " + (i + 1), null));
					m1.setNum(i, j, x);
					
				}
			}
			System.out.println(m1.toString());
			rArea.setText(m1.toString());
		}
	}
	
	static class editMatrix2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Edit Matrix 2");
			int r = Integer.parseInt(JOptionPane.showInputDialog("Enter # of rows", null));
			int c = Integer.parseInt(JOptionPane.showInputDialog("Enter # of columns", null));
			System.out.println("Rows: " + r);
			System.out.println("Rows: " + c);
			
			m2 = new Matrix(r, c);
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					int x = Integer.parseInt(JOptionPane.showInputDialog("Enter number " + (j + 1) + " for row " + (i + 1), null));
					m2.setNum(i, j, x);
					
				}
			}
			System.out.println(m2.toString());
			lArea.setText(m2.toString());
		}
	}
	
	
	
	static class addition implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("addition");
			Matrix added = new Matrix();
			if(m1.ChAddSubt(m2) == true) {
				added = m1.add(m2);
				label.setText(added.toString());
				System.out.println(added.toString());
			}
			else {
				JOptionPane.showMessageDialog(null, "Can't add these");
			}
		}
	}
	
	static class subtraction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Subtraction");
			if(m1.ChAddSubt(m2) == true) {
				Matrix newMat = m1.subtract(m2);
				System.out.println(newMat.toString());
				label.setText(newMat.toString());
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Can't subtract these");
			}
		}
	}
	
	static class multiplication implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("multiplication");
			Matrix multed = new Matrix();
			if(m1.ChMult(m2) == true) {
				multed = m1.multiply(m2);
				label.setText(multed.toString());
				System.out.println(multed.toString());
			}
			else {
				JOptionPane.showMessageDialog(null, "Can't multiply these");
			}
		}
	}
	
	static class scalarMultiplication implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("scalar multiplication");
			int x = Integer.parseInt(JOptionPane.showInputDialog("Enter number to multiply"));
			Matrix newMat = new Matrix();
			newMat = m1.scalarMultiply(x);
			System.out.println(newMat.toString());
			label.setText(newMat.toString());
		}
	}
	
	static class Clear implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("clear");
			m1 = new Matrix();
			m2 = new Matrix();
			label.setText("");
			rArea.setText(m1.toString());
			lArea.setText(m2.toString());
		}
	}
	
	static class rFill1 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Random fill 1");
			int r = Integer.parseInt(JOptionPane.showInputDialog("Enter max rows"));
			int c = Integer.parseInt(JOptionPane.showInputDialog("Enter max columns"));
			int n = Integer.parseInt(JOptionPane.showInputDialog("Enter max number"));
			m1 = new Matrix();
			m1.randFill(r, c, n);
			System.out.println(m1.toString());
			rArea.setText(m1.toString());
		}
	}
	
	static class rFill2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Random fill 2");
			int r = Integer.parseInt(JOptionPane.showInputDialog("Enter max rows"));
			int c = Integer.parseInt(JOptionPane.showInputDialog("Enter max columns"));
			int n = Integer.parseInt(JOptionPane.showInputDialog("Enter max number"));
			m2 = new Matrix();
			m2.randFill(r, c, n);
			System.out.println(m2.toString());
			lArea.setText(m2.toString());
		}
	}
}
