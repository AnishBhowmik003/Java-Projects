import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorPanel extends JPanel{
	
	private Matrix m1;
	private Matrix m2;
	
	private JMenuBar menubar;
	private JMenu functions;
	private JMenu other;
	private JMenuItem clear;
	
	private JMenuItem add;
	private JMenuItem subtract;
	private JMenuItem multiply;
	private JMenuItem scalarMult;
	
	private JButton Vmatrix1;
	private JButton Vmatrix2;
	
	public ColorPanel(Color backColor, int width, int height) {
		setBackground(backColor);
		setPreferredSize(new Dimension(width, height));
		this.setFocusable(true);
		menubar = new JMenuBar();
		functions = new JMenu("Functions");
		other  = new JMenu("Other");
		menubar.add(functions);
		menubar.add(other);
		
		add = new JMenuItem("Add");
		subtract = new JMenuItem("Subtract");
		multiply = new JMenuItem("Multiply");
		scalarMult = new JMenuItem("Scalar Multiplication");
		
		clear = new JMenuItem("Clear");
		
		functions.add(add);
		functions.add(subtract);
		functions.add(multiply);
		functions.add(scalarMult);
		
		other.add(clear);
		//viewTen.addActionListener(new MenuActionListener());
		add.addActionListener(new addition());
		subtract.addActionListener(new subtraction());
		multiply.addActionListener(new multiplication());
		scalarMult.addActionListener(new scalarMultiplication());
		
		clear.addActionListener(new Clear());
		
		Vmatrix1 = new JButton("View Matrix 1");
		Vmatrix2 = new JButton("View Matrix 2");
		
		this.setLayout(new BorderLayout());
		this.add(menubar, BorderLayout.NORTH);
		//this.setLayout(new GridLayout(3,3));
		
		this.add(Vmatrix1, BorderLayout.EAST);
		this.add(Vmatrix2, BorderLayout.WEST);
		Vmatrix1.setSize(100, 200);
		Vmatrix2.setSize(100, 200);
		
	}
	
	public void paintComponent(Graphics g) {
		
	}
	
	private class addition implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("addition");
		}
	}
	
	private class subtraction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Subtraction");
		}
	}
	
	private class multiplication implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("multiplication");
		}
	}
	
	private class scalarMultiplication implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("scalar multiplication");
		}
	}
	
	private class Clear implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("clear");
		}
	}
	
}
