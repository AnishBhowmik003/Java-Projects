
public class Book {
	private String author;
	private String title;
	
	public Book(String a, String t) {
		author = a;
		title = t;
	}
	
	public Book() {
		author = null;
		title = null;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public String getTitle() {
		return title;
	}
	
	
	public String toString() {
		

			return(title +", " + author);

		
		
	}
}
