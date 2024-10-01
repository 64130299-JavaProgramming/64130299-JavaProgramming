import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, String> tuDien = new HashMap<String, String>();
		tuDien.put("Hello", "Xin chào");
		tuDien.put("Thank", "Cảm ơn");
		tuDien.put("Bye", "Chào tạm biệt");
		tuDien.put("Computer", "Máy tính");
		tuDien.put("Two", "Hai");
		tuDien.put("Three", "Ba");
		tuDien.put("Red", "Màu đỏ");
		tuDien.put("Blue", "Màu xanh");
		tuDien.put("Yellow", "Màu vàng");
		tuDien.put("Black", "Màu đen");
		System.out.println("Nhập từ cần tra cứu: ");
		String timTu = sc.nextLine();
		System.out.println(timTu + ": " + tuDien.get(timTu));
	}
}
