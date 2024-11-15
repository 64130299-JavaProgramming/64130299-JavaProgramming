package thigiuaki_64130299;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestFXML extends Application{
	 @Override
	    public void start(Stage primaryStage) {
	        try {
	            // Tải giao diện FXML cho màn hình đăng nhập
	            Parent root = FXMLLoader.load(getClass().getResource("formdangnhap.fxml"));
	            primaryStage.setTitle("Đăng Nhập");
	            primaryStage.setScene(new Scene(root));
	            primaryStage.show();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
}
