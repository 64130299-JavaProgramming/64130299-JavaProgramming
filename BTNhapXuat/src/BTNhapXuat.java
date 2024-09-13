import java.util.Scanner;

public class BTNhapXuat {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập a: ");
		int a = scanner.nextInt();
		System.out.println("Nhập b: ");
		int b = scanner.nextInt();
		System.out.println("Tổng hai số a và b: " + (a+b));
	}
}
