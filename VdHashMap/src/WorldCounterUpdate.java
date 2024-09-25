import java.util.HashMap;
import java.util.Scanner;

public class WorldCounterUpdate {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Nhập đoạn văn bản từ người dùng
		System.out.println("Nhập văn bản từ người dùng: ");
		String input = sc.nextLine();
		
		HashMap<String, Integer> wordCount = demSoLanXuatHienTu(input);
		
		//In ra kết quả
		System.out.println("Số lần xuất hiện của từng từ:");
		for (HashMap.Entry<String, Integer> entry : wordCount.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	//Đếm số lần xuất hiện từ(tiếng anh và tiếng việt)
	private static HashMap<String, Integer> demSoLanXuatHienTu(String input) {
		//Chuyển toàn bộ về chữ thường để không phân biệt hoa thường
		input = input.toLowerCase();
		
		// Biểu thức chính quy để giữ lại các từ bao gồm chữ cái và số (cả dấu tiếng Việt)
        input = input.replaceAll("[^\\p{L}0-9 , \\ . ]", "");
        
        //Tách đoạn văn bản thành các từ
        String[] words = input.split("\\s+");
        
        //Sử dụng hashMap để lưu lại số lần xuất hiện từ
        HashMap<String, Integer> wordCount = new HashMap<>();
        
        for (String word : words) {
			//Nếu từ đã có trong HashMap, tăng giá trị lên 1
        	if(wordCount.containsKey(word)) {
        		wordCount.put(word, wordCount.get(word) + 1);
        	}
        	else {
        	//Nếu chưa có,thì thêm giá trị từ đó vào 1
        		wordCount.put(word, 1);
        	}
		}
		return wordCount;
	}
	
	
}
