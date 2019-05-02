//Bansri Shah
//110335850

/**
 * This class represents a Book which has a title, author, condition, and borrower (once assigned)
 * @author Bansri
 *
 */

public class Book {
	private String title;
	private String author;
	private String borrower;
	private int condition;
	
	/**
	 * This is a constructor used to create a new Book object
	 * @param title
	 * The title of the Book
	 * @param author
	 * The author of the book
	 * @param condition
	 * The condition of the book
	 */
	
	public Book (String title, String author, int condition) {
		this.title = title;
		this.author = author;
		this.condition = condition;
		this.borrower = "";
	}
	
	/**
	 * This is a getter method for the title
	 * @return
	 * return the title of this book
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * This is a setter method for the title
	 * @param title
	 * Setting the title of this book
	 */
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * This is a getter method for the author
	 * @return
	 * return the author of this book
	 */
	public String getAuthor() {
		return this.author;
	}
	
	/**
	 * This is a setter method for the author
	 * @param author
	 * Setting the author of this book
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * This is a getter method for the borrower
	 * @return
	 * return the borrower of this book (if assigned)
	 */
	
	public String getBorrower() {
		return this.borrower;
	}
	
	/**
	 * This is a setter method for the borrower
	 * @param borrower
	 * Setting the borrower of this book (if assigned)
	 */
	
	public void setBorrower(String borrower) {
		this.borrower = borrower;
	}
	
	/**
	 * This is a getter method for the condition
	 * @return
	 * return the condition of this book
	 */
	
	public int getCondition() {
		return this.condition;
	}
	
	/**
	 * This is a setter method for the condition
	 * @param condition
	 * Setting the condition of this book
	 */
	
	public void setCondition(int condition) {
		this.condition = condition;
	}
	
	/**
	 * 
	 */
	
	public Book clone() {
		String clonedTitle = this.title;
		String clonedAuthor = this.author;
		int clonedCondition = this.condition;
		Book b = new Book(clonedTitle, clonedAuthor, clonedCondition);
		return b;
	}
	
	/**
	 * 
	 */
	
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			Book b = (Book) obj;
			if(b.getTitle().equals(this.title) && b.getAuthor().equals(this.author) && b.getCondition() == this.condition) {
				return true;
			}
		}
			return false;
	}
	
	/**
	 * 
	 */
	
	public String toString() {
		return getTitle() + String.format("%45s", getAuthor()) + String.format("%20s", getCondition()) + String.format("%20s", "<" + getBorrower() + ">\n");
	}
}
