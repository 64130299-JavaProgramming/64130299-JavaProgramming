import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		ArrayList<Book> books = new ArrayList<>();
		Book book = new Book();
		do {
			System.out.println("****BOOKS MANAGEMENT SYSTEM****");
			System.out.println("1. Insert new book");
			System.out.println("2. View list of books");
			System.out.println("3. Average Price");
			System.out.println("4. Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1: 
				System.out.println("Enter name: ");
				String name = sc.nextLine();
				book.setName(name);
				System.out.println("Enter publish date: ");
				String publishDate = sc.nextLine();
				book.setPublishDate(publishDate);
				System.out.println("Enter author: ");
				String author = sc.nextLine();
				book.setAuthor(author);
				System.out.println("Enter language: ");
				String language = sc.nextLine();
				book.setLanguage(language);
				
				int priceList[] = new int[5];
				for(int i = 0;i < priceList.length;i++) {
					System.out.println("Enter price list " + i +": ");
					priceList[i] = sc.nextInt();
				}
				book.setPriceList(priceList);
				book.calculate();
				books.add(book);
				break;
			case 2:	
				System.out.println("$$$ List of books $$$");
				if(books.isEmpty()) {
					System.out.println("No books in the list !");
				}
				else {
					for (Book b : books) {
						b.display();
					}
				}
				break;
			case 3:
				System.out.println("^^^ Average Price ^^^");
				if(books.isEmpty()) {
					System.out.println("No books in the list !");
				}
				else {
					for (Book b : books) {
						b.calculate();
						b.display();
					}
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}while(choice != 4);
	}
}
