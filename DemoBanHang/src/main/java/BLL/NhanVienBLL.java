package BLL;

import DAL.NhanVienDAL;
import DTO.NhanVien;

public class NhanVienBLL {
	NhanVienDAL nvDAL = new NhanVienDAL();
	public boolean ThemMoi(NhanVien nv) {
		//Các xử lý khác ở đây
		boolean kq = nvDAL.addNew(nv);
		return kq;
	}
	public boolean checkLogin(String tenDN, String matKhau) {
        // Kiểm tra tên đăng nhập không được rỗng và có đúng định dạng
        if (tenDN == null || tenDN.trim().isEmpty()) {
            System.out.println("Tên đăng nhập không được rỗng!");
            return false;
        }
        
        // Kiểm tra mật khẩu không được rỗng và có đủ độ dài tối thiểu
        if (matKhau == null || matKhau.trim().isEmpty()) {
            System.out.println("Mật khẩu không được rỗng!");
            return false;
        }
        
        if (matKhau.length() < 6) {
            System.out.println("Mật khẩu phải có ít nhất 6 ký tự!");
            return false;
        }

        // Gọi dịch vụ DAL để kiểm tra tên đăng nhập và mật khẩu
        boolean isValidUser = nvDAL.login(tenDN, matKhau);

        // Nếu thông tin đăng nhập đúng
        if (isValidUser) {
            return true;
        } else {
            System.out.println("Tên đăng nhập hoặc mật khẩu không chính xác.");
            return false;
        }
    }
}
