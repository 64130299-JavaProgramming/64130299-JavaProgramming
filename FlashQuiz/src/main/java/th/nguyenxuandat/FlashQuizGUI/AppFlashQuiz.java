package th.nguyenxuandat.FlashQuizGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppFlashQuiz extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/th/nguyenxuandat/FlashQuizGUI/fxml_flashquiz.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 971, 570); 
            primaryStage.setTitle("App Flash Quiz");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
