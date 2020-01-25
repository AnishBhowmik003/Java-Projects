import java.awt.*;
import javax.swing.*;
public class GUI {

	public static void main(String[] args) {
		JFrame f = new JFrame("Employee");
		JButton b = new JButton("Button1");
		JButton b2 = new JButton("Button2");
		
		b.setBounds(100, 100, 140, 40);
		b2.setBounds(100, 150, 140, 40);
		f.add(b);
		f.add(b2);
		f.setSize(600, 700);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}

}
