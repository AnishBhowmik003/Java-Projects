import java.io.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;
public class GUI {
	static JFrame theGUI = new JFrame("Book Recomendation");
	static JButton methB = new JButton("Method B");
	static JButton gen = new JButton("Generate");
	static JButton methA = new JButton("Method A");
	static JButton methC = new JButton("Method C");
	static JList list1 = new JList()  ;
	static ReaderList l1 = new ReaderList();
	static Library lib = new Library();
	static JList list2 = new JList();
	
	static JLabel label1 = new JLabel();
	static JLabel imglabel = new JLabel();
	
	static DefaultListModel listModel2 = new DefaultListModel();
	static DefaultListModel listModel = new DefaultListModel();
	
	
	//go to page 297 in the text book
	public static void main(String[] args) throws IOException{
		
		lib = new Library("books.txt");
		
		theGUI.setSize(1100, 650);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theGUI.setLayout(null);
		
		methB.setLocation(150, 12);
		methB.setSize(100, 100);
		theGUI.add(methB);
		theGUI.add(gen);
		
		gen.setSize(100, 100);
		gen.setLocation(20, 12);
		gen.addActionListener(new generate());
		methB.addActionListener(new methodB());
		
		methA.setLocation(280, 12);
		methA.setSize(100, 100);
		methA.addActionListener(new methodA());
		theGUI.add(methA);
		
		methC.setLocation(410, 12);
		methC.setSize(100, 100);
		methC.addActionListener(new methodC());
		theGUI.add(methC);
		
		
		list1 = new JList(listModel);
		//list1.setSize(597, 316);
		//list1.setLocation(20, 130);
		JScrollPane j1 = new JScrollPane(list1);
		j1.setSize(597, 200);
		j1.setLocation(20, 130);
		
		theGUI.add(j1);
		
		list2 = new JList(listModel2);
		JScrollPane j2 = new JScrollPane(list2);
		j2.setSize(597, 200);
		j2.setLocation(20, 350);
		theGUI.add(j2);
		
		label1.setSize(442, 46);
		label1.setLocation(650, 130);
		theGUI.add(label1);
		
		
		imglabel.setLocation(650, 200);
		imglabel.setSize(200, 250);
		
		
		theGUI.add(imglabel);
		
		theGUI.setVisible(true);
	}
	
	static class methodB implements ActionListener {

		
		public void actionPerformed(ActionEvent e) {
			System.out.println("Method B");
			int r = list1.getSelectedIndex();
			
			System.out.println(l1.getReaders()[r].toString());
			
			int[] tscores = new int[86];
			for(int i = 0; i < 86; i++) {
				tscores[i] = 0;
			}
			
			
			for (int i = 0; i < 86; i++) {
				for(int j = 0; j < 55; j++) {
					if (i == list1.getSelectedIndex()) {
						tscores[i] = 0;
					}
					else {
						tscores[i] += l1.getReaders()[i].getScore(j) * l1.getReaders()[r].getScore(j);
					}
					
				}
			}
			
			int loc = 0;
			int high = 0;
			for(int i = 0 ; i < 86; i++) {
				if (tscores[i] > high) {
					high = tscores[i];
					loc = i;
				}
			}
			
			
			int bloc = 0;
			int dif = 0;
			for(int i = 0; i < 55; i++) {
				if ((l1.getReaders()[r].getScore(i) == 0) && (l1.getReaders()[loc].getScore(i) > dif)) {
					dif = l1.getReaders()[loc].getScore(i);
					bloc = i;
				}
			}
			System.out.println(lib.getBook(bloc).toString());
			label1.setText(lib.getBook(bloc).toString());
			String path = "D:\\bookimages\\" + lib.getBook(bloc).getTitle() + ".jpg";
			System.out.println(path);
			imglabel.setIcon( new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT)));
		}
	}
	
	
	static class methodA implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Method A");
			int[] avg = new int[55];
			for(int i = 0; i < 55; i++) {
				
				int num = 0;
				for(int j = 0; j < 86; j++) {
					if (j == list1.getSelectedIndex()) {
						j++;
					}
					num += l1.getReaders()[j].getScore(i);
				}
				
				avg[i] = num;
			}
			double dif = 0;
			int bloc = 0;
			int r = list1.getSelectedIndex();
			for(int i = 0; i < 55; i++) {
				if ((l1.getReaders()[r].getScore(i) == 0) && (avg[i] > dif)) {
					dif = avg[i];
					bloc = i;
				}
			}
			label1.setText(lib.getBook(bloc).toString());
			String path = "D:\\bookimages\\" + lib.getBook(bloc).getTitle() + ".jpg";
			System.out.println(path);
			imglabel.setIcon( new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT)));
		}
	}
	
	
	static class generate implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Generate");
			try {
				l1 = new ReaderList("readerratings.txt");
				System.out.println("Got readers");
				System.out.println(l1.getReaders()[0].toString());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String[] rString = new String[86];
			for(int i = 0; i < 86; i++) {
				rString[i] = l1.getReaders()[i].toString();
				listModel.addElement(rString[i]);
			}
			for(int i = 0; i < 55; i++) {
				listModel2.addElement(lib.getBook(i).toString());
			}
		
		}
		
	}
	
	static class methodC implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Method C");
			int r = list1.getSelectedIndex();
			
			System.out.println(l1.getReaders()[r].toString());
			int[] tbscore = new int[55];
			for(int i = 0; i < 55; i++) {
				tbscore[i] = 0;
			}
			
			int[] tscores = new int[86];
			for(int i = 0; i < 86; i++) {
				tscores[i] = 0;
			}
			
			
			for (int i = 0; i < 86; i++) {
				for(int j = 0; j < 55; j++) {
					if (i == list1.getSelectedIndex()) {
						tscores[i] = 0;
					}
					else {
						tscores[i] += l1.getReaders()[i].getScore(j) * l1.getReaders()[r].getScore(j);
					}
					
				}
				
			}
			
			for(int i = 0; i < 55; i++) {
				for(int j = 0; j < 86; j++) {
					tbscore[i] += l1.getReaders()[j].getScore(i) * tscores[j];
				}
			}
			
			
			int bloc = 0;
			int high = 0;
			
			for(int i = 0; i < 55; i++) {
				if(tbscore[i] > high) {
					high = tbscore[i];
					bloc = i;
				}
			}
			
			
			
			System.out.println(lib.getBook(bloc).toString());
			label1.setText(lib.getBook(bloc).toString());
			String path = "D:\\bookimages\\" + lib.getBook(bloc).getTitle() + ".jpg";
			System.out.println(path);
			imglabel.setIcon( new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(200, 250, Image.SCALE_DEFAULT)));
		}
	}
	
}
