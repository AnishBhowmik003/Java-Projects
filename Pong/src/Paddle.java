import java.awt.*;
public class Paddle {
	private int centerX, centerY, height, width;
	private Color color;
	private int speed, direction;
	
	private double velX = 0;
	private double velY = 0;
	
	
	public Paddle(int x, int y, int h, int w, Color c) {
		centerX = x;
		centerY = y;
		height = h;
		width = w;
		color = c;
	}
	
	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(color);
		g.drawRect(centerX, centerY, width, height);
		g.setColor(oldColor);
	}
	
	public void fill(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(color);
		g.fillRect(centerX, centerY, width, height);
		g.setColor(oldColor);
	}
	
	public int getX() {
		return centerX;
	}
	
	public void setX(int x) {
		centerX = x;
	}
	
	public int getY() {
		return centerY;
	}
	
	public void tick() {
		centerY += velY;
	}
	
	public void setY(int y) {
		centerY = y;
	}
	
	public void move(int xAmount, int yAmount) {
		centerX = centerX + xAmount;
		centerY = centerY + yAmount;
	}
	
	public void setSpeed(int s) {
		speed = s;
	}
	public void move() {
		move((int)(speed * Math.cos(Math.toRadians(direction))), 
			(int)(speed * Math.sin(Math.toRadians(direction))));
	}
	public void setDirection(int degrees) {
		direction = degrees % 360;
	}
	
	
	
	void turn(int degrees) {
		direction = (direction + degrees) % 360;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void setVelY(double vel) {
		velY = vel;
	}
}
