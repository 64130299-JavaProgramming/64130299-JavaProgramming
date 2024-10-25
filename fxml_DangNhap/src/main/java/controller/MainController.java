package controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Node;

public class MainController {

    // Xử lý sự kiện đăng xuất
    @FXML
    private void handleLogout(ActionEvent event) {
        try {
            // Tải giao diện FXML cho form đăng nhập
            FXMLLoader loader = new FXMLLoader(getClass().getResource("form_login.fxml"));
            Parent root = loader.load();
            // Lấy stage hiện tại và thay đổi scene về màn hình đăng nhập
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Đăng Nhập");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
