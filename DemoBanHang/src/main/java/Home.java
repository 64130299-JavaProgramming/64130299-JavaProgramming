import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Home {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Đăng kí divew
		Class.forName("com.mysql.jdbc.Driver");
		
		String strConn = "jdbc:mysql://localhost:3306/demobanhang" ;
		
		Connection conn = DriverManager.getConnection(strConn, "root", "");
		System.out.println("Haha");
	}

}
