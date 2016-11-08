import java.time.LocalDate;
import java.time.LocalDateTime;


public class Book {
	
	private String title;
	private String author;
	private String status; // ("On Shelf", or "Checked out");
	private LocalDate dueDate; //month-day-year
	
	public Book(String title, String author, String status, LocalDate date) {
		this.title = title;
		this.author = author;
		this.status = status;
		this.dueDate = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	} 
	
	
	
}
