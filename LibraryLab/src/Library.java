import java.util.ArrayList;
public class Library {
	//private Patron[] patrons = new Patron[5];
	//private Book[] books = new Book[7];
	
	
	private ArrayList<Book> books = new ArrayList<Book>();
	private ArrayList<Patron> patrons = new ArrayList<Patron>();
	
	
	
	public Library() {
		books.clear();
		patrons.clear();
	}
	
	public void addBook(Book b) {
		books.add(b);
	}
	
	public void addBook(String a, String t) {
		books.add(new Book(a, t));
	}
	
	public void addPatron(String name) {
		patrons.add(new Patron(name));
	}
	
	public void addPatron(Patron p1) {
		patrons.add(p1);
	}
	
	public Patron getPatron(int p) {
		return patrons.get(p);
	}
	
	public String viewBook(int s) {
		String output;
		output = books.get(s).toString();
		return output;
	}
	
	public boolean borrowBook(int p, int b) {
		boolean x;
		x = patrons.get(p).borrow(books.get(b));
		return x;
		
	}
	
	public boolean ifBorrow(int p, String title) {
		boolean x;
		x = patrons.get(p).ifBorrow(title);
		return x;
	}
	
	public boolean returnBook(int p, String title) {
		boolean x;
		x = patrons.get(p).returnBook(title);
		return x;
	}
	
	public String viewBooks() {
		String output = "";
		for(int i = 0; i < books.size(); i++) {
			if (i == 0) {
				output += books.get(i).toString();
			}
			else {
				output += "\n" + books.get(i).toString();
			}
			
		}
		return output;
	}
	
	public String viewPatrons() {
		String output = "";
		for(int i = 0; i < patrons.size(); i++) {
			if (i == 0) {
				output += patrons.get(i).toString();
			}
			else {
				output += "\n" + patrons.get(i).toString();
			}
			
		}
		return output;
	}
	
	public boolean removeBook(int b) {
		if (b < books.size()) {
			books.remove(b);
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean removePatron(int p) {
		if (p < patrons.size()) {
			patrons.remove(p);
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
