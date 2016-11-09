import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.FormatStyle;

public class LibraryMain {

	static ArrayList<Book> books = new ArrayList<Book>();

	public static void main(String[] args) throws IOException {

		String choice = "y";
		String userInput;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to The Detroit Grand Circus Library\n");
		displayMenuOptions();
		books = getObjectsFromFile();

		while (choice.equalsIgnoreCase("y")) {

			System.out.println();
			
			
			int getInt = Validator.getInt(scan, "Enter your number here, press 0 for menu, 7 for quit: ", 0, 7);
			
			
			switch (getInt) {
			case 0:
				displayMenuOptions();
				break;
			case 1:
				
				displayAllBooks();

				break;

			case 2:
				
				
				System.out.println("Type the name of the author you're searching for: ");
				userInput = scan.nextLine();
				searchAuthor(userInput);
				break;

			case 3:
				searchTitle("War");
				break;

			case 4:
				
				System.out.println("Books on shelf:");
				displayOnShelf();
				System.out.println("Type the title of the book you want to check out: ");
				userInput = scan.nextLine();
				checkoutBook(userInput);
				saveFile(books);
				
				break;

			case 5:
				System.out.println("Checked Out:");
				displayCheckedOut();
				System.out.println("Type the title of the book you want to return: ");
				userInput = scan.nextLine();
				returnBook(userInput);
				saveFile(books);
				 
				break;

			case 6:				
				displayCheckedOut();
				break;

			case 7:
				choice="n";
				System.out.println("bye!!");
				break;

			default:
				System.out.println("Re-enter your number here, press 0 for menu: ");
				break;
			}

		}
		saveFile(books);
	}

	
	public static void displayMenuOptions() {

		System.out.println("===========LIBRARY MENU=============");
		System.out.println("Please press 1 to display all books. ");
		System.out.println("Please press 2 to search by author. ");
		System.out.println("Please press 3 to search by title. ");
		System.out.println("Please press 4 to check out a book. ");
		System.out.println("Please press 5 to return a book. ");
		System.out.println("Please press 6 to add a book. ");
		System.out.println("Press to 7 to exit library");
		System.out.println("====================================");
	}
	
	

	// prints list of all books in library
	public static void displayAllBooks() {
		for (Book b : books) {
			if (b.getDueDate() == null) {
				System.out.println(b.getTitle() + ", " + b.getAuthor() + ", "
						+ b.getStatus());
			} else {
			System.out.println(b.getTitle() + ", " + b.getAuthor() + ", "
					+ b.getStatus() + ", Due Back: " + b.getDueDate());
			}
		}
	}
	
	

	//Search all Author returns all books with inputed Author
    public static void searchAuthor(String findAuthor) {
        
        findAuthor = findAuthor.toLowerCase();
        System.out.println("Searching for " + findAuthor + " in the library catalog \n");
        for (Book s : books){
        	
            if (s.getAuthor().toLowerCase().contains(findAuthor)) {
	        System.out.print("    "+s.getAuthor() );
	        System.out.print("   "+s.getTitle());     
	        System.out.println("   "+s.getStatus());
            }
        }
        
    }
    
    
    
         //returns all title and return books with inputed title
    public static void searchTitle(String findTitle) {
        
    	findTitle = findTitle.toLowerCase();
        System.out.println("Searching for Title in the library catalog \n");
        for (Book s : books){
        	s.setTitle(s.getTitle().toLowerCase());
		        if(s.getTitle().contains(findTitle)){
		        System.out.print("   "+s.getTitle());     
		        System.out.print("    "+s.getAuthor() );
		        System.out.println("   "+s.getStatus());
	        }
		        else{
		        	System.out.println("Sorry, we dont have any books with that title.");
		        }
        }
}


	public static void checkoutBook(String titleInput) {
		
		for(Book b: books){
			if(titleInput.equalsIgnoreCase(b.getTitle())
					&& b.getStatus().equalsIgnoreCase("On shelf")){
				b.setStatus("checked out");
				b.setDueDate(LocalDate.now().plusWeeks(2));
				System.out.println("You checked out "+ b.getTitle() + ", it's due back:" +b.getDueDate());
			}
					
		}
		
	}

	public static void displayCheckedOut() {
		
		for (Book b : books){
			if (b.getStatus().equalsIgnoreCase("Checked Out")){
				System.out.println(b.getTitle() + " " + b.getAuthor() + " " + b.getStatus() + " due back: " + b.getDueDate()); 
			}
		}
	}

	public static void displayOnShelf() {

		for (Book b : books) {
			if (b.getStatus().equalsIgnoreCase("On Shelf")) {
				System.out.println(
						b.getTitle() + ", " + b.getAuthor() + ", " + b.getStatus() );
			}
		}
	}

	public static void returnBook(String titleInput) {
		for(Book b: books){
			if(titleInput.equalsIgnoreCase(b.getTitle())
					&& b.getStatus().equalsIgnoreCase("Checked Out")){
				b.setStatus("On Shelf");
				b.setDueDate(null);
				System.out.println("You returned "+ b.getTitle());
			}
					
		}
	}

	

	// stores objects from listofbooks.txt into an arrayList
	public static ArrayList<Book> getObjectsFromFile() {

		DateTimeFormatter dateFormat = DateTimeFormatter
				.ofPattern("uuuu-MM-dd"); // sets the format

		LocalDate formattedDate;

		ArrayList<Book> books = new ArrayList<Book>();

		File file = new File(System.getProperty("user.dir")
				+ "/src/ListOfBooks.txt");
		// separated to be able to close the buffer
		// set to null because eclipse was expecting it to be initialized
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {

				String[] objectsToGet = line.split("/");
				String stringDate = objectsToGet[3].toString();
				if (stringDate.equalsIgnoreCase("empty")) {
					books.add(new Book(objectsToGet[0], objectsToGet[1],
							objectsToGet[2], null));
				} else {
					formattedDate = LocalDate.parse(stringDate, dateFormat);
					books.add(new Book(objectsToGet[0], objectsToGet[1],
							objectsToGet[2], formattedDate));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);

		}

		return books;
	}

	// public static Book addBook(String title, String author) {
	// adds to list of books.
	// sets default status as On shelf
	// sets
	// books.add(title, author, "On shelf", LocalDateTime.now());
	// }

	public static void saveFile(ArrayList<Book> books) throws IOException {

		DateTimeFormatter dateFormat = DateTimeFormatter
				.ofPattern("uuuu-MM-dd"); // sets the format

		LocalDate formattedDate;

		// take everything in our arraylist and save it to the ListOfBooks.txt
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				new File(System.getProperty("user.dir")
						+ "/src/ListOfBooks.txt"))));

		for (Book b : books) {

			if (b.getDueDate() == null) {
				out.println(b.getTitle() + "/" + b.getAuthor() + "/"
						+ b.getStatus() + "/empty");
			} else {
				String stringDate = b.getDueDate().toString();
				formattedDate = LocalDate.parse(stringDate, dateFormat);
				out.println(b.getTitle() + "/" + b.getAuthor() + "/"
						+ b.getStatus() + "/" + formattedDate);
			}
		}
		out.close();
	}

}
