

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import BLL.NhanVienBLL;

public class LoginController {

    @FXML
    private TextField usernameField;
    
    @FXML
    private PasswordField passwordField;

    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        
        // Kiểm tra đăng nhập
        NhanVienBLL userDAL = new NhanVienBLL();
        
        if (userDAL.checkLogin(username, password)) {
            // Đăng nhập thành công
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Đăng Nhập Thành Công");
            alert.setHeaderText(null);
            alert.setContentText("Chào mừng bạn đến với hệ thống!");
            alert.showAndWait();
        } else {
            // Đăng nhập thất bại
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Lỗi Đăng Nhập");
            alert.setHeaderText(null);
            alert.setContentText("Tên đăng nhập hoặc mật khẩu không chính xác.");
            alert.showAndWait();
        }
    }
}
