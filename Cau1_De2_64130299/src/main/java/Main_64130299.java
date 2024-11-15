import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main_64130299 extends Application {
    @Override
    public void start(Stage sanKhauChinh) throws Exception {
        VBox goc = FXMLLoader.load(getClass().getResource("BMI_64130299.fxml"));
        Scene canh = new Scene(goc);
        sanKhauChinh.setTitle("Ứng dụng Tính BMI và Chuyển đổi Byte");
        sanKhauChinh.setScene(canh);
        sanKhauChinh.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
