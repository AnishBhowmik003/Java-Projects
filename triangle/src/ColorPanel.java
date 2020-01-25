import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class ColorPanel extends JPanel  {
	
	
	
	
	private ArrayList<Integer> mx = new ArrayList<Integer>();
	private ArrayList<Integer> my = new ArrayList<Integer>();
	private ArrayList<Point> mypoints = new ArrayList<Point>();
	
	
	
	private double xHalf;
	private double yHalf;
	
	private double oldX;
	private double oldY;
	
	private int flag = 0;
	
	
	private Circle c1, c2;
	
	public ColorPanel(Color backColor) {
		setBackground(backColor);
		KeyListener listener = new MyKeyListener();
		addKeyListener(listener);
		MouseListener listen = new MyMouseListener();
		addMouseListener(listen);
		setFocusable(true);
		
		
	}
	

	
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		xHalf = getWidth()/2;
		yHalf = getHeight()/2;
		mypoints.clear();
		
		g.setColor(Color.blue);
		g.drawLine(0,  getHeight() / 2, getWidth(), getHeight() / 2);
		g.setColor(Color.red);
		g.drawLine(getWidth() / 2, 0, getWidth()/2, getHeight());
		g.setColor(Color.blue);

		//addMouseListener(new PanelListener());

		
		ArrayList<Circle> circles = new ArrayList<Circle>();
		
		if (flag == 0) {
			mypoints.clear();
			for(int s = 0; s < mx.size(); s++) {
				mx.set(s,  (int)(mx.get(s) * (xHalf/oldX)));
				my.set(s,  (int)(my.get(s) * (yHalf/oldY)));
				String f = "(" + (mx.get(s) - getWidth() / 2) + ", " + (getHeight()/2 - my.get(s)) + ")";
				g.drawString(f, (mx.get(s)), my.get(s));
				
				circles.add(new Circle(mx.get(s).intValue(), my.get(s).intValue(), 3, Color.blue));
				circles.get(s).fill(g);
				
			}
		}
		else if (flag == 1){
			mypoints.clear();
			for(int s = 0; s < mx.size(); s++) {
				mx.set(s,  (int)(mx.get(s) * (xHalf/oldX)));
				my.set(s,  (int)(my.get(s) * (yHalf/oldY)));
				String f = "(" + (mx.get(s) - getWidth() / 2) + ", " + (getHeight()/2 - my.get(s)) + ")";
				g.drawString(f, (mx.get(s)), my.get(s));
				//System.out.println(f);
				circles.add(new Circle(mx.get(s).intValue(), my.get(s).intValue(), 3, Color.blue));
				circles.get(s).fill(g);
				
				
				
			}
			for(int s = 0; s < mx.size(); s++) {
				if (s != mx.size() - 1) {
					g.drawLine(mx.get(s), my.get(s), mx.get(s+1), my.get(s+1));
				}
				else {
					g.drawLine(mx.get(s), my.get(s), mx.get(0), my.get(0));
				}
				mypoints.add(new Point(mx.get(s) - getWidth()/2, getHeight()/2 - my.get(s)));
			}
			
			flag = 2;
		}
		
		
		
		oldX = xHalf;
		oldY = yHalf;
	}
	
	
	
	
	
	
	
	public void output() {
		
		
		Polygon poly = new Polygon(mypoints);
		System.out.println(poly.toString());
		//System.out.println(poly.toString());
	}
	
	public class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			if (flag == 0) {
				mx.add((e.getX()));
				my.add((e.getY()));
				repaint();
				
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public class MyKeyListener implements KeyListener {

		
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		
		public void keyPressed(KeyEvent e) {
			System.out.print(e.getKeyChar());
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_ENTER) {
				
				//System.out.println("Enter");
				flag = 1;
				repaint();
				output();
				
			}
			else if(keyCode ==KeyEvent.VK_ESCAPE) {
				clear();
				repaint();
				
				
			}
			
		}

		
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public void clear() {
		mx.clear();
		my.clear();
		mypoints.clear();
		flag = 0;
	}
	
}
