import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;
public class ColorPanel extends JPanel{
	
	private Circle circle;
	private Timer timer;
	private Paddle paddle1;
	private Paddle paddle2;
	private Player mp1;
	private Player mp2;
	
	private JLabel score1;
	private JLabel score2;
	
	private int pscore1 = 0;
	private int pscore2 = 0;
	private File pong = new File("pong.WAV");
	private File coin = new File("coin.WAV");
	private JMenuBar menubar;
	private JMenu view;
	private JMenuItem viewTen;
	
	private ImageIcon Image = new ImageIcon("pic.jpg");
	
	private Top10 tten;
	
	
	static void PlaySound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();
		}catch(Exception e) {
			
		}
	}
	
	public ColorPanel(Color backColor, int width, int height, Player p1, Player p2) throws IOException {
		
		
		setBackground(backColor);
		setPreferredSize(new Dimension(width, height));
		this.addMouseListener(new MyMouseListener());
		this.addKeyListener(new MyKeyListener());
		this.addMouseMotionListener(new MyMouseListener());
		
		setFocusable(true);
		circle = new Circle(width/ 2, height/2 , 12, Color.red);
		circle.setDirection(180);
		circle.setSpeed(5);
		tten = new Top10();
		menubar = new JMenuBar();
		view = new JMenu("View");
		menubar.add(view);
		viewTen = new JMenuItem("View Top 10");
		viewTen.addActionListener(new MenuActionListener());
		view.add(viewTen);
		this.setLayout(new BorderLayout());
		this.add(menubar, BorderLayout.NORTH);
		
		
		
		score1 = new JLabel();
		score2 = new JLabel();
		
		paddle1 = new Paddle(25, (height/2) - 100, 100, 25, Color.blue);
		
		paddle2 = new Paddle(width - 50, (height/2) - 100, 100, 25, Color.blue);
		
		this.add(score1, BorderLayout.SOUTH);
		score1.setHorizontalAlignment(JLabel.CENTER);
		Font font = new Font("Verdana", Font.BOLD, 30);
		score1.setFont(font);
		//this.add(score2, BorderLayout.EAST);
		
		paddle1.setSpeed(30);
		paddle2.setSpeed(30);
		mp1 = p1;
		mp2 = p2;
		timer = new Timer(33, new MoveListener());
		timer.start();
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Image.paintIcon(this,  g, getWidth() / 2 - (Image.getIconWidth() / 2), getHeight() / 2 - (Image.getIconHeight() / 2));
		circle.fill(g);
		paddle1.fill(g);
		paddle2.fill(g);
		paddle1.tick();
		
		score1.setText(mp1.getName() + ": " + Integer.toString(mp1.getScore()) + "     " + mp2.getName() +": " + Integer.toString(mp2.getScore()));
		//score2.setText(mp2.getName() +": " + Integer.toString(mp2.getScore()));
		
		
	}
	
	private class MyMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			//System.out.println("Bruh moment");
			
			//repaint();
			
		}
		
		public void mouseMoved(MouseEvent e) {
		
			int y = e.getY();
			//paddle2.setY(y - paddle2.getHeight() / 2);
			paddle2.setY(y);
			
		
		}
	}
	
	private class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,  tten.toString());
		}
	}
	
	private class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			
			//System.out.println("keyEvent");
			int keyCode = e.getKeyCode();
			if(keyCode == KeyEvent.VK_W) {
				//paddle1.setDirection(270);
				//paddle1.move();
				paddle1.setVelY(-5);
			}
			if(keyCode == KeyEvent.VK_S) {
				//paddle1.setDirection(90);
				//paddle1.move();
				paddle1.setVelY(5);
			}
			
			repaint();
			
		}
		public void keyReleased(KeyEvent e) {
			
			int keyCode = e.getKeyCode();
			if(keyCode == KeyEvent.VK_W) {
				paddle1.setVelY(0);
			}
			if(keyCode == KeyEvent.VK_S) {
				paddle1.setVelY(0);
			}
			repaint();
			
		}
	}
	
	
	
	private class MoveListener implements ActionListener{

	
		public void actionPerformed(ActionEvent e){
		
			int x = circle.getX();
			int y = circle.getY();
			int radius = circle.getRadius();
			int height = getHeight();
			int width = getWidth();
			Random bob = new Random();
			//if (x - radius <= 0 || x + radius >= width) {
				//circle.turn(bob.nextInt(170) + 100);
				//circle.turn(circle.getDirection());
				
				
				//circle.setDirection(circle.getDirection() + (bob.nextInt(180) + 91));
				//circle.turn(180);
				
				
				//circle.turn(bob.nextInt(50) + 160);
				
			//}
			
			if (x - radius <= 0) {
				circle.setDirection(180);
				//circle.turn(bob.nextInt(180) + 91);
				PlaySound(coin);
				circle.setPoint(getWidth()/2, getHeight() /2);
				circle.setSpeed(5);
				mp2.setScore(mp2.getScore() + 1);
				if(mp2.getScore() == 10) {
					JOptionPane.showMessageDialog(null, mp2.getName() + " has won!");
					try {
						mp2.setScore(mp2.getScore() - mp1.getScore());
						tten.addPlayer(mp2);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mp2.setScore(0);
					mp1.setScore(0);
				}
				
			}
			
			if (x + radius >= width) {
				circle.setDirection(0);
				PlaySound(coin);
				//circle.turn(bob.nextInt(180) + 91);
				circle.setPoint(getWidth()/2, getHeight() /2);
				circle.setSpeed(5);
				mp1.setScore(mp1.getScore() + 1);
				
				if(mp1.getScore() == 10) {
					JOptionPane.showMessageDialog(null, mp1.getName() + " has won!");
					try {
						mp1.setScore(mp1.getScore() - mp2.getScore());
						tten.addPlayer(mp1);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mp1.setScore(0);
					mp2.setScore(0);
					
				}
			}
			
			if (y - radius <= 0 || y + radius >= height) {
				circle.setDirection(-circle.getDirection());
				PlaySound(pong);
				}
			
			
			
			
			if (x - radius <= paddle1.getX() + paddle1.getWidth() && y + radius >= paddle1.getY() && y - radius <= paddle1.getY() + paddle1.getHeight()) {
				circle.setDirection(180);
				circle.turn(bob.nextInt(180) + 91);
				circle.setSpeed(circle.getSpeed() + 1);
				PlaySound(pong);
				
								
				
			}
			
			if (x + radius >= paddle2.getX() && y + radius >= paddle2.getY() && y - radius <= paddle2.getY() + paddle2.getHeight()) {
				circle.setDirection(0);
				circle.turn(bob.nextInt(180) + 91);
				circle.setSpeed(circle.getSpeed() + 1);
				PlaySound(pong);
				
			}	
			circle.move();
			repaint();
			
		}
		
	}
}
