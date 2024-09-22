import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int luaChon = 0;
		News news = new News();
		while(luaChon != 4){
			System.out.println("******HỆ THỐNG QUẢN LÝ TIN TỨC******");	
			System.out.println("1. Insert news");
			System.out.println("2. View list news");
			System.out.println("3. Average rate");
			System.out.println("4. Exit");
			luaChon = sc.nextInt();
			sc.nextLine();
			switch (luaChon) {
			case 1: 
				System.out.println("Nhập title: ");
				String title = sc.nextLine();
				news.setTitle(title);
				System.out.println("Nhập Publish Date: ");
				String publishDate = sc.nextLine();
				news.setPublishDate(publishDate);
				System.out.println("Nhập Author: ");
				String author = sc.nextLine();
				news.setAuthor(author);
				System.out.println("Nhập Content: ");
				String content = sc.nextLine();
				news.setContent(content);
				
				//Nhập vào 3 đánh giá để lưu và rateList
				int rateList[] = new int[3];
				for(int i = 0; i < rateList.length; i++) {
					System.out.println("Nhập RateList " + i + ": ");
					rateList[i] = sc.nextInt();
				}
				news.setRateList(rateList);
				news.Calculate();
				
				break;	
			case 2:
				System.out.println("==== List News ====");
				news.display();
				break;
			case 3:
				news.Calculate();
				System.out.println("==== Average rate ==== ");
				news.display();
				break;
			case 4:
				System.out.println("Chương trình kết thúc!");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + luaChon);
			}
		}

	}

}
