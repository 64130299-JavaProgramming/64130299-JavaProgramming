package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private TextField txtHeight; // Trường nhập chiều cao

    @FXML
    private TextField txtWeight; // Trường nhập cân nặng

    @FXML
    private TextField txtResult; // Trường hiển thị kết quả BMI

    @FXML
    private TextField txtStatus; // Trường hiển thị tình trạng sức khỏe

    @FXML
    private Button btnCalculate; // Nút tính BMI

    @FXML
    private Label lblHeight; // Label "Nhập chiều cao"
    
    @FXML
    private Label lblWeight; // Label "Nhập cân nặng"

    @FXML
    private Label lblResult; // Label "Kết quả"

    @FXML
    private Label lblStatus; // Label "Tình Trạng"

    // Hàm khởi tạo (initialize) được gọi khi giao diện FXML được tải
    @FXML
    public void initialize() {
        btnCalculate.setOnAction(event -> calculateBMI());
    }

    // Hàm tính toán BMI khi người dùng nhấn nút "Tính BMI"
    public void calculateBMI() {
        try {
            // Lấy chiều cao và cân nặng từ TextField
            double height = Double.parseDouble(txtHeight.getText());
            double weight = Double.parseDouble(txtWeight.getText());

            // Tính BMI
            double bmi = weight / (height * height);

            // Hiển thị kết quả BMI
            txtResult.setText(String.format("%.2f", bmi));

            // Đánh giá tình trạng sức khỏe dựa trên chỉ số BMI
            String status;
            if (bmi < 18.5) {
                status = "Thiếu cân";
            } else if (bmi < 24.9) {
                status = "Bình thường";
            } else if (bmi < 29.9) {
                status = "Thừa cân";
            } else {
                status = "Béo phì";
            }

            // Hiển thị tình trạng sức khỏe
            txtStatus.setText(status);

        } catch (NumberFormatException e) {
            // Nếu có lỗi khi nhập liệu, hiển thị thông báo lỗi
            txtResult.setText("Dữ liệu không hợp lệ");
            txtStatus.setText("");
        }
    }
}
