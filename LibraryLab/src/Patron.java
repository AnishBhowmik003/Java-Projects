
public class Patron {
	private String name;
	private Book book1 = new Book();
	private Book book2 = new Book();
	private Book book3 = new Book();
	
	public Patron() {
		book1 = null;
		book2 = null;
		book3 = null;
		name = null;
	}
	
	
	public Patron(String n) {
		book1 = null;
		book2 = null;
		book3 = null;
		name = n;
	}
	
	
	public boolean borrow(Book book) {
		if(book1 == null) {
			book1 = book;
			return true;
		}
		else if(book2 == null) {
			book2 = book;
			return true;
		}
		else if(book3 == null) {
			book3 = book;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String n) {
		name = n;
	}

  public boolean ifBorrow(String title) {
      if(book1 != null && book1.getTitle().equals(title) == true) {
        return true;
      }
      else if(book2 != null && book2.getTitle().equals(title) == true) {
        return true;
      }
      else if(book3 != null && book3.getTitle().equals(title) == true) {
        return true;
      }
      else {
        return false;
      }
  }
	
	
	
	public boolean returnBook(String title) {
		if(book1 != null && book1.getTitle().equals(title) == true) {
			book1 = null;
			return true;
			
		}
		else if(book2 != null && book2.getTitle().equals(title) == true) {
			book2 = null;
			return true;
			
		}
		else if(book3 != null && book3.getTitle().equals(title) == true) {
			book3 = null;
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	public String toString() {
		String output = name;
		if(book1 == null) {
			output += "\nNull";
		}
		else {
			output += "\n" + book1.getTitle() +", " + book1.getAuthor();
		}
		
		if(book2 == null) {
			output += "\nNull";
		}
		else {
			output += "\n" + book2.getTitle() +", " + book2.getAuthor();
		}
		
		if(book3 == null) {
			output += "\nNull";
		}
		else {
			output += "\n" + book3.getTitle() +", " + book3.getAuthor();
		}
		
		return output;
	}
	
}
