import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ColorPanel extends JPanel {
	
	private double mx;
	private double my;
	
	private double xHalf;
	private double yHalf;
	
	private double oldX;
	private double oldY;
	
	
	
	
	private Circle c1, c2;
	
	public ColorPanel(Color backColor) {
		setBackground(backColor);
		
		
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		xHalf = getWidth()/2;
		yHalf = getHeight()/2;
		
		
		g.setColor(Color.blue);
		g.drawLine(0,  getHeight() / 2, getWidth(), getHeight() / 2);
		g.setColor(Color.red);
		g.drawLine(getWidth() / 2, 0, getWidth()/2, getHeight());
		g.setColor(Color.blue);
		g.drawString("(0, 0)", (getWidth() / 2), (getHeight() / 2) );
		c1 = new Circle(getWidth() / 2, getHeight() / 2, 3, Color.blue);
		c1.fill(g);
		addMouseListener(new PanelListener());
		String cord;
		
		
		mx= mx*(xHalf/oldX);
		my=my*(yHalf/oldY);
		cord = "(" + ((int)mx - getWidth()/2) + ", " + (getHeight()/2 - (int)my) + ")";
		g.drawString(cord, (int)mx, (int)my);
		
		c2 = new Circle((int)mx, (int)my, 3, Color.blue);
		c2.fill(g);
	
			
		
		
		oldX = xHalf;
		oldY = yHalf;
	}
	
	
	
	private class PanelListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			//obtain the current mouse coordinates and refresh
			mx = e.getX();
			my = e.getY();
			repaint();
			
		}
	}
	
}
