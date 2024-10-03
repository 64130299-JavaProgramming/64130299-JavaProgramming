import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ViDuDocFileJson {
    public static void main(String[] args) {
        // Khởi tạo parser để đọc file JSON
        JSONParser jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader("sinhVien.json")) {
            // Đọc file JSON và chuyển đổi thành JSONArray
            Object obj = jsonParser.parse(reader);
            JSONArray sinhVienList = (JSONArray) obj;
             
            // Duyệt qua danh sách sinh viên
            sinhVienList.forEach(sv -> parseSinhVienObject((JSONObject) sv));
             
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    
    // Phương thức để phân tích và in thông tin sinh viên
    private static void parseSinhVienObject(JSONObject sinhVien) {
        // Lấy đối tượng sinh viên
        JSONObject sinhVienObject = (JSONObject) sinhVien.get("student");
         
        // Lấy các thuộc tính của sinh viên
        String firstName = (String) sinhVienObject.get("firstName");
        String lastName = (String) sinhVienObject.get("lastName");
        String studentID = (String) sinhVienObject.get("studentID");
        String className = (String) sinhVienObject.get("class");
        String email = (String) sinhVienObject.get("email");
         
        // In thông tin sinh viên
        System.out.println("Họ và tên: " + firstName + " " + lastName);
        System.out.println("Mã sinh viên: " + studentID);
        System.out.println("Lớp: " + className);
        System.out.println("Email: " + email);
        System.out.println("-----------------------");
    }
}
