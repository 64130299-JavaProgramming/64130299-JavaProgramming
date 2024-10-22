package fxml_QuanLyBanHang;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Tải file FXML
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/QuanLyBanHang.fxml"));

        primaryStage.setTitle("Ứng dụng quản lý bán hàng");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

