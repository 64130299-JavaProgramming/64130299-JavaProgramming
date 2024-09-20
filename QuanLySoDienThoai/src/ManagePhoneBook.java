import java.util.Scanner;

public class ManagePhoneBook {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PhoneBook phoneBook = new PhoneBook();
		int choice = -1;
		do {
			System.out.println("****PHONE BOOK MANAGEMENT SYSTEM****");
			System.out.println("0. Print Phone Book");
			System.out.println("1. Insert Phone");
			System.out.println("2. Remove Phone");
			System.out.println("3. Update Phone");
			System.out.println("4. Search Phone");
			System.out.println("5. Sort");
			System.out.println("6. Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 0:
				phoneBook.printPhoneBook();
				break;
			case 1: 
				String phone,name;
				System.out.println("Nhập tên: ");
				name = sc.nextLine();
				System.out.println("Nhập số điện thoại: ");
				phone = sc.nextLine();
				phoneBook.insertPhone(name, phone);
				break;
			case 2:
				System.out.println("Nhập tên người dùng để xóa số điện thoại.");
				name = sc.nextLine();
				phoneBook.removePhone(name);
				break;
			case 3:
				System.out.println("Nhập tên:");
				name = sc.nextLine();
				System.out.println("Nhập số điện thoại mới");
				String newPhone =sc.nextLine();
				phoneBook.updatePhone(name, newPhone);
				break;
			case 4:
				System.out.println("Nhập tên cần để tìm số:");
				name = sc.nextLine();
				phoneBook.searchPhone(name);
				break;
			case 5:	
				phoneBook.sort();
				System.out.println("Danh bạ hiện tại");
				phoneBook.printPhoneBook();
				break;
			}
		}while(choice != 6);
	}
}
