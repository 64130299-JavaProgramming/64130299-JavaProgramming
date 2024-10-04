package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Tải file FXML
        	Parent root = FXMLLoader.load(getClass().getResource("/application/TinhBMI1.fxml"));
            
            // Tạo Scene với kích thước phù hợp
            Scene scene = new Scene(root, 600, 400);
            
            // Đặt Scene cho Stage
            primaryStage.setScene(scene);
            primaryStage.setTitle("BMI Calculator");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
