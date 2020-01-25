import java.util.Scanner;
public class LibraryTester {

	public static void main(String[] args) {
		
		Library l1 = new Library();
		String choice = "";
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. add book\n2. add patron\n3. view book\n4. borrow book\n5. return book\n6. check if book has been borrowed\n"
				+ "7. view patron\n8. Remove book\n9. Remove patron\n10. view all book\n11. view all patrons\n12. exit");
		do {
			System.out.println("Enter choice:");
			choice = scanner.nextLine();
			if(choice.equals("1")) {
				System.out.println("What is the author?");
				String author = scanner.nextLine();
				System.out.println("what is tht title?");
				String title = scanner.nextLine();
				l1.addBook(author, title);
			}
			else if(choice.equals("2")) {
				System.out.println("What is the name?");
				String name = scanner.nextLine();
				l1.addPatron(name);
			}
			
			else if(choice.equals("3")) {
				System.out.println("Which book do you want to view?");
				int s = scanner.nextInt();
				scanner.nextLine();
				System.out.println(l1.viewBook(s));
			}
			
			else if(choice.equals("4")) {
				System.out.println("Which patron?");
				int p = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Which book?");
				int b = scanner.nextInt();
				scanner.nextLine();
				System.out.println(l1.borrowBook(p,  b));
			}
			
			else if(choice.equals("5")) {
				System.out.println("Which patron?");
				int p = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Which book title?");
				String t = scanner.nextLine();
				System.out.println(l1.returnBook(p,  t));
			}
			else if(choice.equals("6")) {
				System.out.println("Which patron?");
				int p = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Which title?");
				String t = scanner.nextLine();
				System.out.println(l1.ifBorrow(p,  t));
			}
			else if(choice.equals("7")) {
				System.out.println("Which patron?");
				int p = scanner.nextInt();
				scanner.nextLine();
				System.out.println(l1.getPatron(p).toString());
			}
			else if(choice.equals("8")) {
				System.out.println("Enter int for book to remove");
				int b = scanner.nextInt();
				scanner.nextLine();
				System.out.println(l1.removeBook(b));
			}
			else if(choice.equals("9")) {
				System.out.println("Enter int for patron to remove");
				int p = scanner.nextInt();
				scanner.nextLine();
				System.out.println(l1.removePatron(p));
			}
			else if(choice.equals("10")) {
				System.out.println(l1.viewBooks());
			}
			else if(choice.equals("11")) {
				System.out.println(l1.viewPatrons());
			}
			
			
		}while(choice.equals("12") == false);
		
		scanner.close();
}

}