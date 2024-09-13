import java.util.Scanner;

public class AppKiemTraChanLe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an integer: ");
		int a = sc.nextInt();
		String result = a % 2 == 0 ?  "is odd" :"is even";
		
		System.out.println(a + " " +result);
		System.out.println("bye");
	}
}
