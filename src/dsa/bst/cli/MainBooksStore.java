package dsa.bst.cli;

import java.util.Scanner;

import dsa.bst.bookshop.*;
import dsa.bst.exceptions.FullTreeException;
import dsa.bst.exceptions.NotFoundException;
import dsa.bst.gui.PrintAll;

public class MainBooksStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("Books Store");
			System.out.println("\n1. Add a Book");
			System.out.println("2. Delete a Book");
			System.out.println("3. Search a Book");
			System.out.println("4. Print all Books");
			
			System.out.print("\nEnter Your Choice : ");
			Scanner sc = new Scanner(System.in);
			String userInput = sc.next();
			
			MainBooksStore mainBooksStore = new MainBooksStore();
			
			if(mainBooksStore.isNumeric(userInput)){
				
				int userInp= Integer.parseInt(userInput);
				
				switch(userInp){
					
					case 1: mainBooksStore.AddBook();
							break;
					case 2: mainBooksStore.Delete();
							break;
					case 3: System.out.println("Search a Book");
							break;
					case 4: System.out.println("Print All Books");
							break;
					default:System.out.println("Not a valid Choice");
							break;
				
			
				}
			}else{
					System.out.println("Not a Numeric Input");
			}
				
		}
	//}
	
	/* Numeric Check */
	private boolean isNumeric(String text) {
        if (text == null || text.trim().equals("")) {
            return false;
        }
        for (int iCount = 0; iCount < text.length(); iCount++) {
            if (!Character.isDigit(text.charAt(iCount))) {
                return false;
            }
        }
        return true;
    }
	
	private void AddBook(){
		
		Book book = new Book();
		
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		System.out.println("Add a Book\n");
		
		System.out.print("+ Book : ");
		String bookInput = sc.nextLine();
		
		System.out.print("+ ISBN : ");
		String isbn = sc2.next();
		
		while(!isNumeric(isbn)){
			System.out.println("Not a valid ISBN ... Try Again ");
			System.out.print("\n+ ISBN : ");
			isbn = sc2.next();
		}
		
		System.out.print("+ First Name : ");
		String authorFname = sc.nextLine();
		
		System.out.print("+ Last Name : ");
		String authorLname = sc.nextLine();
		
		book.setTitle(bookInput);
		book.setIsbn(Integer.parseInt(isbn));
		book.setFirstName(authorFname);
		book.setSurName(authorLname);
		book.setCategory("Not Available");
		//System.out.println("O/P"+bookInput+" "+isbn+" "+authorFname+" "+authorLname);
		try {
			dsa.bst.gui.Main.bookShopDatabase.insert(book);
			System.out.println("Book Added");
		} catch (FullTreeException e) {
			// TODO Auto-generated catch block
			System.out.println("Our Books Store is Full ");
		};
		
	}
	
	private void Delete() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Delete a Book");
		
		System.out.print("- Book Name : ");
		String bookName = sc.next(); // to get user input
		
		// Deletion...
		try {
			dsa.bst.gui.Main.bookShopDatabase.delete(bookName);
			System.out.println("Book Added");
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("This book isn't exists...!!!");
		}
		
	}
	
	private void SearchBook(){
		
	}

}
