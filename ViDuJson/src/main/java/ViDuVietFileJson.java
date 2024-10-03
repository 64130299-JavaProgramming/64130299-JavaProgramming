import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ViDuVietFileJson {
    public static void main(String[] args) {
        // Thông tin sinh viên thứ nhất
        JSONObject sinhVienDetails1 = new JSONObject();
        sinhVienDetails1.put("firstName", "Nguyễn");
        sinhVienDetails1.put("lastName", "Xuân Đạt");
        sinhVienDetails1.put("studentID", "64130299");
        sinhVienDetails1.put("class", "64CNTT.CLC2");
        sinhVienDetails1.put("email", "datnx@example.com");
         
        JSONObject sinhVienObject1 = new JSONObject(); 
        sinhVienObject1.put("student", sinhVienDetails1);
         
        // Thông tin sinh viên thứ hai (ví dụ)
        JSONObject sinhVienDetails2 = new JSONObject();
        sinhVienDetails2.put("firstName", "Trần");
        sinhVienDetails2.put("lastName", "Tiến Phúc");
        sinhVienDetails2.put("studentID", "64130300");
        sinhVienDetails2.put("class", "64CNTT.CLC2");
        sinhVienDetails2.put("email", "phuctt@example.com");
         
        JSONObject sinhVienObject2 = new JSONObject(); 
        sinhVienObject2.put("student", sinhVienDetails2);
         
        // Thêm sinh viên vào danh sách
        JSONArray sinhVienList = new JSONArray();
        sinhVienList.add(sinhVienObject1);
        sinhVienList.add(sinhVienObject2);
         
        // Ghi file JSON
        try (FileWriter file = new FileWriter("sinhVien.json")) {
            file.write(sinhVienList.toJSONString()); 
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
