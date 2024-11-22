package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Utils.DBUtils;
import Utils.ComonUtils;

import DTO.NhanVien;

public class NhanVienDAL {
	public boolean addNew(NhanVien nv) {
		return true;
	}
	boolean delete(int id) {
		return true;
	}
	   // Phương thức đăng nhập
    public boolean login(String username, String plainPassword) {
        // Mã hóa mật khẩu người dùng nhập vào
        String hashedPassword = ComonUtils.encodePassword(plainPassword);
        
        // SQL để kiểm tra tên đăng nhập và mật khẩu
        String query = "SELECT * FROM user_64130299 WHERE username = ? AND password = ?";
        
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            // Thiết lập tham số cho câu truy vấn
            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);
            
            // Thực thi truy vấn và nhận kết quả
            ResultSet rs = stmt.executeQuery();
            
            // Nếu tìm thấy người dùng khớp với tên đăng nhập và mật khẩu
            if (rs.next()) {
                return true; // Đăng nhập thành công
            } else {
                return false; // Đăng nhập thất bại
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Lỗi kết nối cơ sở dữ liệu hoặc lỗi truy vấn
        }
    }
}
