import java.time.LocalDateTime;


public class Book {
	
	private String title;
	private String author;
	private String status; // ("On Shelf", or "Checked out");
	private LocalDateTime dueDate; //month-day-year
	
	public Book(String title, String author, String status, LocalDateTime date) {
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

	public LocalDateTime getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	} 
	
	
	
}
