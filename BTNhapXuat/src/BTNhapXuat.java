import java.util.Scanner;

public class BTNhapXuat {
	public static void main(String[] args) {
		//Khai báo biến
		int a,b,tong;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập a: ");
		//Nhập dữ liệu
		a = scanner.nextInt();
		System.out.print("Nhập b: ");
		b = scanner.nextInt();
		tong = a + b;
		System.out.print("Tổng hai số a và b: " +tong);
	}
}
