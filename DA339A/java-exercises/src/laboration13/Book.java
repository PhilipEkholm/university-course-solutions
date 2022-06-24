package laboration13;

public class Book extends Media{
	private String author;
	
	public Book(long id, String title, String author){
		super(id, title);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String toString(){
		return this.getTitle() + " skriven av " + this.author;
	}
}
