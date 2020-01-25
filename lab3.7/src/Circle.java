import java.awt.*;
public class Circle {
	private int centerX, centerY, radius;
	private Color color;
	
	public Circle(int x, int y, int r, Color c) {
		centerX = x;
		centerY = y;
		radius = r;
		color  = c;
	}
	
	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(color);
		g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
		g.setColor(oldColor);
	}
	
	public void fill(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(color);
		g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
		g.setColor(oldColor);
	}
	
	
}
