import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Home {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Đăng kí divew
		Class.forName("com.mysql.jdbc.Driver");
		
		String strConn = "jdbc:mysql://localhost:3306/demobanhang" ;
		
		Connection conn = DriverManager.getConnection(strConn, "root", "");
		
		String sqlSelect = "Select * from SanPham";
		Statement lenh = conn.createStatement();
		ResultSet ketQua = lenh.executeQuery(sqlSelect);
		
		//Hiện kết quả
		while (ketQua.next()) {
			int id = ketQua.getInt(1); // lấy dữ liệu ở cột 0
			String tenSP = ketQua.getString(2);
			String giaSP = ketQua.getString(3);
			String moTa = ketQua.getString(4);
			System.out.println(id + " | " + tenSP + " | " + giaSP + " | " + moTa + "\n");
		}
	}

}
