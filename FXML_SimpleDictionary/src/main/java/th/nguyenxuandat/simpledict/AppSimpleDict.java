package th.nguyenxuandat.simpledict;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppSimpleDict extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/th/nguyenxuandat/simpledict/fxml/SimpleDict_GUI.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.setTitle("Từ Điển Anh-Việt");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
