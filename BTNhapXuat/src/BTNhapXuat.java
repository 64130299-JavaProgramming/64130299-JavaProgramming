import java.util.Scanner;

public class BTNhapXuat {
	public static void main(String[] args) {
		//Khai báo biến
		int a,b,tong;
		
		//Chuẩn bị nhập dữ liệu
		Scanner scanner = new Scanner(System.in);
		
		//Nhập dữ liệu
		System.out.println("---- CHƯƠNG TRÌNH TÍNH TỔNG HAI SỐ NGUYÊN ----");
		System.out.print("Nhập a: ");
		a = scanner.nextInt();
		System.out.print("Nhập b: ");
		b = scanner.nextInt();
		tong = a + b;
		
		//Xuất kết quả
		System.out.print("Tổng hai số a và b: " +tong);
	}
}
