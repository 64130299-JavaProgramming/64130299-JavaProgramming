
import java.util.HashMap;
import java.util.Scanner;

	public class WordCounter {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        // Nhập đoạn văn bản từ người dùng
	        System.out.println("Nhập một đoạn văn bản:");
	        String input = scanner.nextLine();

	        // Chuyển đổi đoạn văn bản thành các từ và đếm số lần xuất hiện của chúng
	        HashMap<String, Integer> wordCount = demSoLanXuatHien(input);

	        // In ra kết quả
	        System.out.println("Số lần xuất hiện của từng từ:");
	        for (HashMap.Entry<String, Integer> entry : wordCount.entrySet()) {
	            System.out.println(entry.getKey() + ": " + entry.getValue());
	        }

	        scanner.close();
	    }

	    // Phương thức để đếm số lần xuất hiện của từng từ
	    public static HashMap<String, Integer> demSoLanXuatHien(String input) {
	        // Chuyển đoạn văn bản thành chữ thường và loại bỏ dấu câu
	        input = input.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "");

	        // Tách đoạn văn thành các từ
	        String[] words = input.split("\\s+");

	        // Sử dụng HashMap để lưu số lần xuất hiện của từng từ
	        HashMap<String, Integer> wordCount = new HashMap<>();

	        for (String word : words) {
	            // Nếu từ đã có trong HashMap, tăng giá trị lên 1
	            if (wordCount.containsKey(word)) {
	                wordCount.put(word, wordCount.get(word) + 1);
	            } else {
	                // Nếu từ chưa có trong HashMap, thêm từ đó với giá trị là 1
	                wordCount.put(word, 1);
	            }
	        }

	        return wordCount;
	    }
	}


