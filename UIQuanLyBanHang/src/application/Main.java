package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
		//Tải file fxml
		Parent root = FXMLLoader.load(getClass().getResource("QuanLyBanHang.fxml"));
		//Taọ scene và đặt nó lên stage
		Scene scene = new Scene(root);
		primaryStage.setTitle("Ứng dụng quản lý bán hàng");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
