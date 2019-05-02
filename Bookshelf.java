//Bansri Shah
//110335850

/**
 * This class represents a Bookshelf which has an array of several Book objects, counter, and capacity
 * @author Bansri
 *
 */
public class Bookshelf{
	private Book [] books;
	private int count;
	final int CAPACITY = 21;
	
	/**
	 * This is a default empty constructor which creates an empty array (bookshelf),
	 * initializes the first index to null to offset the entire array, and initializes count to 0
	 */
	
	public Bookshelf() {
		books = new Book[CAPACITY];
		books[0] = null;
		count = 0;
	}
	
	/**
	 * This is a total number of books method in the bookshelf
	 * @return
	 * returning the count which is the counter holding the total number of books on the shelf
	 */
	
	public int numBooks() {
		return count;
	}
	
	/**
	 * This is a getBook method 
	 * @param index
	 * The user inputs the index they wish to look at
	 * @return
	 * returns the book located in the index of the array (index location on shelf)
	 * @throws ArrayIndexOutOfBoundsException
	 * if index given is higher than capacity, an exception is thrown
	 */
	
	public Book getBook(int index) 
	throws ArrayIndexOutOfBoundsException {
		return books[index];
	}
	
	/**
	 * This is a removeBook method
	 * @param index
	 * The user inputs the index at which the book to remove
	 * @return
	 * returns the book they wish to remove
	 * @throws ArrayIndexOutOfBoundsException
	 * if index given is higher than the count or capacity, an exception is thrown
	 * @throws EmptyShelfException
	 * if shelf is empty, count is 0, an exception is thrown
	 * @throws LoanedBookException
	 * if book is loaned, borrower has a name assigned, an exception is thrown
	 * @throws EmptyIndexException
	 * if index location given is empty, no book is at location given, an exception is thrown
	 */
	
	public Book removeBook(int index)
	throws ArrayIndexOutOfBoundsException, EmptyShelfException, 
	LoanedBookException, EmptyIndexException {
		Book temp = null;
		if(index > count || index > CAPACITY) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		else {
			if(books[index].getBorrower() == null) {
			temp = books[index].clone();
		if(books[index] != null) {
			for(int i = index; i <= 21; i++) {
				if(books[i + 1] != null) {
				books[i] = books[i + 1].clone();
				count--;
				}
				
				else if(books[i + 1] == null) {
					books[i] = null;
					count--;
					break;
				}
			}
		}
			}
			
			else if(books[index].getBorrower() != null) {
				throw new LoanedBookException();
			}
		else if(count == 0) {
			throw new EmptyShelfException();
		}
		else if (books[index] == null) {
			throw new EmptyIndexException();
		}
		}
		return temp;
	}
	
	/**
	 * This is an addBook method
	 * @param index
	 * The user inputs the index location at which to add a book
	 * @param book
	 * The user input the information for the book to be added
	 * @throws IllegalArgumentException
	 * if index given is higher than capacity, an exception is thrown
	 * @throws FullShelfException
	 * if shelf is full, count is 20, an exception is thrown
	 */
	
	public void addBook(int index, Book book) 
	throws IllegalArgumentException, FullShelfException {
		if(index > CAPACITY) {
			throw new IllegalArgumentException();
		}
		
		if(count >= 1 && index > count + 1) {
			throw new IllegalArgumentException();
		}
		if(books[index] == null) {
			books[index] = book;
			count++;
		}
		else if(count < 20) {
			for(int i = 20; i >= index; i--) {
				books[i] = books[i - 1];
			}
			books[index] = book;
			count++;
		}
		else if(count == 20) {
			throw new FullShelfException();
		}
	}
	
	/**
	 * This is a swapBooks method
	 * @param index1
	 * The user inputs the first index location of the book they wish to swap
	 * @param index2
	 * The user inputs the second index location of the book they wish to swap with
	 * @throws ArrayIndexOutOfBoundsException
	 * if index given is higher than capacity, higher than count, or equal to second index,
	 * an exception is thrown
	 */
	
	public void swapBooks(int index1, int index2) 
	throws ArrayIndexOutOfBoundsException {
		if((index1 <= count && index2 <= count) && (index1 != index2)) {
			Book temp = books[index1];
			books[index1] = books[index2];
			books[index2] = temp;
		}
	}
	
	/**
	 * 
	 */
	
	public Bookshelf clone() {
		Bookshelf shelf2 = new Bookshelf();
		for(int i = 1; i < count + 1; i++) {
				shelf2.books[i] = getBook(i).clone();
		}
		return shelf2;
	}
	
	/**
	 * 
	 */
	
	public boolean equals(Object o) 
	throws NullPointerException{
		if(o instanceof Bookshelf) {
			Bookshelf b = (Bookshelf) o;
			for(int i = 1; i <= 20; i++) {
				if(books[i].equals(b.books[i])) {
					return true;
				}
			}
		}
		
		if(o == null || books == null) {
			throw new NullPointerException();
		}
		return false;
	}
	
	/**
	 * 
	 */
	
	public String toString() {
		String str = "";
		for(int i = 1; i <= 20; i++) {
			if(books[i] != null) {
			str ="\n" + i + ".  " + books[i].toString() + "";
			}
			else {
				break;
			}
		}
		return str;
	}
	
}
