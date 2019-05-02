//Bansri Shah
//110335850

import java.util.*;

/**
 * This class is the driver class which has 3 bookshelves, option(given by user), and currentShelf
 * It prints all the options and the user must input one of the letters in order to do the action
 * It will continue to loop until user input "Q" (case insensitive) in order to quit the program
 * It uses a try-catch block to bring exceptions to attention and notify the user of the error
 * @author Bansri
 *
 */
public class RipoffRental {
	public static void main (String [] args) 
			throws IllegalArgumentException, FullShelfException, 
			ArrayIndexOutOfBoundsException, EmptyShelfException, 
			LoanedBookException, EmptyIndexException, NullPointerException {
		Bookshelf shelfA = new Bookshelf();
		Bookshelf shelfB = new Bookshelf();
		Bookshelf shelfC = new Bookshelf();
		String currentShelf = "a";
		
		String option = "";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Welcome to Bee's aMAZin' Textbook Rentals, lowest price guaranteed!");
		
		while(option.equals("Q") == false && option.equals("q") == false) {
		try {
			System.out.println("Menu:");
			System.out.println("A) Add Books");
			System.out.println("S) Swap Books");
			System.out.println("L) Loan Book");
			System.out.println("R) Remove Book");
			System.out.println("D) Duplicate Book");
			System.out.println("C) Change Shelf");
			System.out.println("O) Overwrite shelf with clone of current shelf");
			System.out.println("E) Check if two shelves are equal");
			System.out.println("P) Print current bookshelf");
			System.out.println("Q) Quit");
			System.out.println();
			System.out.print("Please select an option: ");
			option = scan.next();
			
			if(option.equals("A") || option.equals("a")) {
				System.out.print("Please enter a title: ");
				String title = scan.next();
				title = title + " " + scan.nextLine();
				System.out.print("Please enter an author: ");
				String author = scan.next();
				System.out.print("Please enter condition (1-5): ");
				int condition = scan.nextInt();
				System.out.print("Please enter position on shelf: ");
				int index = scan.nextInt();
				
				Book b = new Book(title, author, condition);
				
				
				if(currentShelf.equals("a") || currentShelf.equals("A")) {
					shelfA.addBook(index, b);
				}
				
				else if(currentShelf.equals("b") || currentShelf.equals("B")) {
					shelfB.addBook(index, b);
				}
				
				else if(currentShelf.equals("c") || currentShelf.equals("C")) {
					shelfC.addBook(index,  b);
				}
				
				System.out.println("Book added!\n");
			}
			
			else if(option.equals("S") || option.equals("s")) {
				System.out.print("Please enter an index: ");
				int index1 = scan.nextInt();
				System.out.print("Please enter another index: ");
				int index2 = scan.nextInt();
				
				if(currentShelf.equals("a") || currentShelf.equals("A")) {
					System.out.println(shelfA.getBook(index1).getTitle() + " has swapped with " + shelfA.getBook(index2).getTitle() + "\n");
					shelfA.swapBooks(index1, index2);
				}
				
				else if(currentShelf.equals("b") || currentShelf.equals("B")) {
					System.out.println(shelfB.getBook(index1).getTitle() + " has swapped with " + shelfB.getBook(index2).getTitle() + "\n");
					shelfB.swapBooks(index1, index2);
				}
				
				else if(currentShelf.equals("c") || currentShelf.equals("C")) {
					System.out.println(shelfC.getBook(index1).getTitle() + " has swapped with " + shelfC.getBook(index2).getTitle() + "\n");
					shelfC.swapBooks(index1, index2);
				}
			}
			
			else if(option.equals("L") || option.equals("l")) {
				System.out.print("Please enter an index: ");
				int index = scan.nextInt();
				System.out.print("Please enter a recipient: ");
				String recipient = scan.next();
				System.out.print("Please enter condition (1-5): ");
				int condition = scan.nextInt();
				
				if(currentShelf.equals("a") || currentShelf.equals("A")) {
					shelfA.getBook(index).setCondition(condition);
					shelfA.getBook(index).setBorrower(recipient);
					System.out.println(shelfA.getBook(index).getTitle() + " has been loaned to " + recipient + ".\n");
				}
				
				else if(currentShelf.equals("b") || currentShelf.equals("B")) {
					shelfB.getBook(index).setCondition(condition);
					shelfB.getBook(index).setBorrower(recipient);
					System.out.println(shelfB.getBook(index).getTitle() + " has been loaned to " + recipient + ".\n");
				}
				
				else if(currentShelf.equals("c") || currentShelf.equals("C")) {
					shelfC.getBook(index).setCondition(condition);
					shelfC.getBook(index).setBorrower(recipient);
					System.out.println(shelfC.getBook(index).getTitle() + " has been loaned to " + recipient + ".\n");
				}
			}
			
			else if(option.equals("R") || option.equals("r")) {
				System.out.print("Please enter an index: ");
				int index = scan.nextInt();
				

				if(currentShelf.equals("a") || currentShelf.equals("A")) {
					shelfA.removeBook(index);
				}
				
				else if(currentShelf.equals("b") || currentShelf.equals("B")) {
					shelfB.removeBook(index);
				}
				
				else if(currentShelf.equals("c") || currentShelf.equals("C")) {
					shelfC.removeBook(index);
				}
				
				System.out.println("Book has been removed!\n");
			}
			
			else if(option.equals("D") || option.equals("d")) {
				System.out.print("Please enter a source index: ");
				int sourceIndex = scan.nextInt();
				System.out.print("Please enter a destination index: ");
				int destIndex = scan.nextInt();

				if(currentShelf.equals("a") || currentShelf.equals("A")) {
					shelfA.addBook(destIndex, shelfA.getBook(sourceIndex).clone());
					System.out.println("A new copy of " + shelfA.getBook(sourceIndex).getTitle() + " is in index " + destIndex + "\n");
				}
				
				else if(currentShelf.equals("b") || currentShelf.equals("B")) {
					shelfB.addBook(destIndex, shelfB.getBook(sourceIndex).clone());
					System.out.println("A new copy of " + shelfB.getBook(sourceIndex).getTitle() + " is in index " + destIndex + "\n");
				}
				
				else if(currentShelf.equals("c") || currentShelf.equals("C")) {
					shelfC.addBook(destIndex,  shelfC.getBook(sourceIndex).clone());
					System.out.println("A new copy of " + shelfC.getBook(sourceIndex).getTitle() + " is in index " + destIndex + "\n");
				}
			}
			
			else if(option.equals("C") || option.equals("c")) {
				System.out.print("Please select a shelf to look at: ");
				currentShelf = scan.next();
				System.out.println("Shelf " + currentShelf.toUpperCase() + " Selected.\n");
			}
			
			else if(option.equals("O") || option.equals("o")) {
				System.out.print("Please select shelf to overwrite to: ");
				String destShelf = scan.next();
		
				if(currentShelf.equals("a") || currentShelf.equals("A")) {
					if(destShelf.equals("b") || destShelf.equals("B")) {
						shelfB = (Bookshelf) shelfA.clone();
						System.out.println("Shelf B overwritten with a copy of Shelf A.\n");
					}
					else if(destShelf.equals("c") || destShelf.equals("C")) {
						shelfC = (Bookshelf) shelfA.clone();
						System.out.println("Shelf C overwritten with a copy of Shelf A.\n");
					}
				}
				
				else if(currentShelf.equals("b") || currentShelf.equals("B")) {
					if(destShelf.equals("a") || destShelf.equals("A")) {
						shelfA = (Bookshelf) shelfB.clone();
						System.out.println("Shelf A overwritten with a copy of Shelf B.\n");
					}
					else if(destShelf.equals("c") || destShelf.equals("C")) {
						shelfC = (Bookshelf) shelfB.clone();
						System.out.println("Shelf C overwritten with a copy of Shelf B.\n");
					}
				}
				
				else if(currentShelf.equals("c") || currentShelf.equals("C")) {
					if(destShelf.equals("a") || destShelf.equals("A")) {
						shelfA = (Bookshelf) shelfC.clone();
						System.out.println("Shelf A overwritten with a copy of Shelf C.\n");
					}
					else if(destShelf.equals("b") || destShelf.equals("B")) {
						shelfB = (Bookshelf) shelfC.clone();
						System.out.println("Shelf B overwritten with a copy of Shelf C.\n");
					}
				}
			}
			
			else if(option.equals("E") || option.equals("e")) {
				System.out.print("Please select a shelf: ");
				String shelf1 = scan.next();
				System.out.print("Please select another shelf: ");
				String shelf2 = scan.next();
				
				if(shelf1.equals("a") || shelf1.equals("A")) {
					if(shelf2.equals("b") || shelf2.equals("B")) {
						if(shelfA.equals(shelfB) == true) {
							System.out.println("These shelves are equal.\n");
						}
					}
					else if(shelf2.equals("c") || shelf2.equals("C")) {
						if(shelfA.equals(shelfC) == true) {
							System.out.println("These shelves are equal.\n");
						}
					}
				}
				
				else if(shelf1.equals("b") || shelf1.equals("B")) {
					if(shelf2.equals("a") || shelf2.equals("A")) {
						if(shelfB.equals(shelfA) == true) {
							System.out.println("These shelves are equal.\n");
						}
					}
					else if(shelf2.equals("c") || shelf2.equals("C")) {
						if(shelfB.equals(shelfC) == true) {
							System.out.println("These shelves are equal.\n");
						}
					}
				}
				
				else if(shelf1.equals("c") || shelf1.equals("C")) {
					if(shelf2.equals("a") || shelf2.equals("A")) {
						if(shelfC.equals(shelfA) == true) {
							System.out.println("These shelves are equal.\n");
						}
					}
					else if(shelf2.equals("b") || shelf2.equals("B")) {
						if(shelfC.equals(shelfB) == true) {
							System.out.println("These shelves are equal.\n");
						}
					}
				}
				
				else {
					System.out.println("These shelves are not equal.\n");
				}
			}
			
			else if(option.equals("P") || option.equals("p")) {
				if(currentShelf.equals("a") || currentShelf.equals("A")) {
					System.out.println();
					System.out.println("Bookshelf A:");
					System.out.println("Spot Title\t\t\t\t\tAuthor\t\t\tCond.\t\tBorrower");
					System.out.println("========================================================================================================");
					
					for(int i = 1; i < 21; i++) {
						if(shelfA.getBook(i) != null) {
							System.out.println( i + ".  " + shelfA.getBook(i).toString());
						}
					}
				}
				
				else if(currentShelf.equals("b") || currentShelf.equals("B")) {
					System.out.println();
					System.out.println("Bookshelf B:");
					System.out.println("Spot Title\t\t\t\t\tAuthor\t\t\tCond.\t\tBorrower");
					System.out.println("========================================================================================================");
					
					for(int i = 1; i < 21; i++) {
						if(shelfB.getBook(i) != null) {
							System.out.println( i + ".  " + shelfB.getBook(i).toString());
						}
					}
				}
				
				else if(currentShelf.equals("c") || currentShelf.equals("C")) {
					System.out.println();
					System.out.println("Bookshelf C:");
					System.out.println("Spot Title\t\t\t\t\tAuthor\t\t\tCond.\t\tBorrower");
					System.out.println("========================================================================================================");
					
					for(int i = 1; i < 21; i++) {
						if(shelfC.getBook(i) != null) {
							System.out.println( i + ".  " + shelfC.getBook(i).toString());
						}
					}
				}
			}
			
			else if(option.equals("Q") || option.equals("q")) {
				System.out.println("Goodbye!");
			}
			
			else {
				System.out.println("Invalid option. Please select an option listed above.\n");
			}
		}
		
		catch(IllegalArgumentException e) {
			System.out.println("Index is invalid\n");
		}
		catch(FullShelfException full) {
			System.out.println("Shelf is full\n");
		}
		
		catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("Index is invalid\n");
		}
		
		catch(EmptyShelfException e) {
			System.out.println("Shelf is empty\n");
		}
		
		catch(LoanedBookException e) {
			System.out.println("Book cannot be removed because it is loaned\n");
		}
		
		catch(EmptyIndexException e) {
			System.out.println("There is no book at that index\n");
		}
		
		catch(NullPointerException e) {
			System.out.println("These shelves are not equal.\n");
		}
		}
	}
}
