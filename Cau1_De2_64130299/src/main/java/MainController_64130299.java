import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class MainController_64130299 {
    @FXML private TextField truongCanNang;
    @FXML private TextField truongChieuCao;
    @FXML private TextField truongByte;
    @FXML private TextArea truongKetQua;
    @FXML private TextArea truongLichSu;

    private static final String FILE_LICH_SU = "log.txt";

    @FXML
    public void initialize() {
        taiLichSu();
    }

    @FXML
    private void tinhBMI() {
        try {
            double canNang = Double.parseDouble(truongCanNang.getText());
            double chieuCao = Double.parseDouble(truongChieuCao.getText());
            double bmi = canNang / (chieuCao * chieuCao);
            String ketQua = String.format("BMI: %.2f", bmi);
            truongKetQua.setText(ketQua);
            ghiLichSu(ketQua);
        } catch (NumberFormatException e) {
            truongKetQua.setText("Dữ liệu không hợp lệ cho tính BMI.");
        }
    }

    @FXML
    private void chuyenDoiSangBit() {
        try {
            int bytes = Integer.parseInt(truongByte.getText());
            int bits = bytes * 8;
            String ketQua = String.format("Bit: %d", bits);
            truongKetQua.setText(ketQua);
            ghiLichSu(ketQua);
        } catch (NumberFormatException e) {
            truongKetQua.setText("Dữ liệu không hợp lệ cho chuyển đổi Byte sang Bit.");
        }
    }

    public void ghiLichSu(String noiDung) {
        try {
            File file = new File(FILE_LICH_SU);
            // Tạo file nếu chưa tồn tại
            if (!file.exists()) {
                file.createNewFile();
            }
            
            // Đọc nội dung hiện tại của file
            List<String> lines = Files.readAllLines(Paths.get(FILE_LICH_SU));
            
            // Nếu có hơn 10 dòng, xóa dòng đầu tiên
            if (lines.size() >= 10) {
                lines.remove(0);
            }
            
            // Thêm dòng mới vào cuối danh sách
            lines.add(noiDung);
            
            // Ghi lại toàn bộ danh sách vào file
            FileWriter writer = new FileWriter(file);
            for (String line : lines) {
                writer.write(line + System.lineSeparator());
            }
            writer.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        taiLichSu();
    }

    private void taiLichSu() {
        try {
            List<String> lichSu = Files.lines(Paths.get(FILE_LICH_SU)).collect(Collectors.toList());
            capNhatLichSu(lichSu);
        } catch (IOException e) {
            truongLichSu.setText("Không có lịch sử.");
        }
    }

    private void capNhatLichSu(List<String> lichSu) {
        truongLichSu.clear();
        for (String muc : lichSu) {
            truongLichSu.appendText(muc + "\n");
        }
    }
}
