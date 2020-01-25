import java.awt.Color;
import java.io.*;
import java.awt.Container;

import javax.swing.*;
public class Main {

	public static void main(String[] args) throws IOException{
		
		String pname1 = JOptionPane.showInputDialog("Enter player 1 name");
		String pname2 = JOptionPane.showInputDialog("Enter player 2 name");
		Player p1 = new Player(pname1);
		Player p2 = new Player(pname2);
		
		
		JFrame theGUI = new JFrame();
		theGUI.setTitle("Pong");
		theGUI.setSize(1000, 800);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ColorPanel panel = new ColorPanel(Color.white, 1000, 800, p1, p2);
		
		Container pane = theGUI.getContentPane();
		pane.add(panel);
		theGUI.setVisible(true);
		
		

	}

}
