
import BLL.NhanVienBLL;
import DAL.NhanVienDAL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Home extends Application {

	@Override
	public void start(Stage stage) throws Exception {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("/login.fxml"));
	    Parent root = loader.load();
	    Scene scene = new Scene(root);
	    stage.setScene(scene);
	    stage.show();
	}


    public static void main(String[] args) {
//    	String username = "DatXuan223@";
//    	String password = "DatXuan223@";
//    	NhanVienDAL nvDAl = new NhanVienDAL();
//    	NhanVienBLL nvBLL = new NhanVienBLL();
//    	System.out.println(nvDAl.login(username, password));
//    	System.out.println(nvBLL.checkLogin(username, password));
        launch(args);
    }
}
