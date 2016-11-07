import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;


public class LibraryMain {
	
	static ArrayList<Book> books = new ArrayList<Book>();
	

	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the library");
		
		
		//Sample Books
		books.add(new Book("title1", "author1", "status1", LocalDateTime.now()));
		books.add(new Book("title2", "author2", "status2", LocalDateTime.now()));
		books.add(new Book("title3", "author3", "status3", LocalDateTime.now()));
		books.add(new Book("title4", "author4", "status4", LocalDateTime.now()));
		books.add(new Book("title5", "author5", "status5", LocalDateTime.now()));
		books.add(new Book("title6", "author6", "status6", LocalDateTime.now()));
		books.add(new Book("title8", "author8", "status8", LocalDateTime.now()));
		books.add(new Book("title9", "author9", "status9", LocalDateTime.now()));
		books.add(new Book("title10", "author10", "status10", LocalDateTime.now()));
		
		
		//System.out.println(books.get().getAuthor());
		
		//1. Populate an arraylist of books with files from a text file.
		
		
		System.out.println("Press 1 to Display all books.");
		System.out.println("Press 2 to search by author ");
		System.out.println("Press 3 to serach by title");
		System.out.println("Press 4 to check out a book");
		System.out.println("Press 5 to return a book");
		System.out.println("Press 6 add a book");
		
		//get input.
		//if input == 1 then, run displayBooks();
		//run corresponding method.
		
		//displayAllBooks();
		//searchAuthor("Tolstoy");

	}
	
		public static void displayAllBooks() {
			//prints list of all books
			for (Book b: books) {
				System.out.println(b.getTitle() + ", " + b.getAuthor() + ", " + b.getStatus());
			}
		}
		
		public static String searchAuthor(String input) {
				//returns all books with inputted Author
		}
		
		public static String searchTitle(String input) {
			 //returns all books with inputted title
		}
		
		public static void checkoutBook(String titleInput) {
			//changes status of book to Checked Out
		}
		
		public static void displayCheckedOut() {
			// prints out all checked out books
		}
		
		public static void returnBook(String titleInput) {
			//changes status of book to On shelf
		}
		
		public static Book addBook(String title, String author) {
			//adds to list of books.
			//sets default status as On shelf
			//sets 
			//books.add(title, author, "On shelf", LocalDateTime.now());
		}
		
}
