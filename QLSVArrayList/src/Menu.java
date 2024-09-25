import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		DanhSachSinhVien danhSachSinhVien = new DanhSachSinhVien();
		
		do {
			System.out.println("****** CHƯƠNG TRÌNH QUẢN LÝ DANH SÁCH SINH VIÊN ******");
			System.out.println("1. Thêm sinh viên mới vào danh sách.");
			System.out.println("2. Hiển thị danh sách sinh viên.");
			System.out.println("3. Sửa thông tin sinh viên dựa vào mã sinh viên.");
			System.out.println("4. Xóa sinh viên khỏi danh sách dựa vào mã sinh viên.");
			System.out.println("5. Tìm kiếm sinh viên theo mã sinh viên.");
			System.out.println("6. Sắp xếp danh sách sinh viên theo điểm trung bình giảm dần.");
			System.out.println("7. Thoát chương trình.");
			System.out.println("******************************************************");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1: 
				System.out.println("Nhập mã số sinh viên: ");
				String maSV = sc.nextLine();
				System.out.println("Nhập họ và tên: ");
				String hoten = sc.nextLine();
				System.out.println("Nhập tuổi: ");
				int tuoi = sc.nextInt();
				System.out.println("Nhập điểm trung bình: ");
				float dtb = sc.nextFloat();
				SinhVien sv = new SinhVien(maSV, hoten, tuoi, dtb);
				sv.setMaSV(maSV);
				sv.setHoTen(hoten);
				sv.setTuoi(tuoi);
				sv.setDtb(dtb);
				danhSachSinhVien.themSinhVien(sv);
				System.out.println("Thêm thành công !");
				break;
			case 2:
				danhSachSinhVien.hienThiDSSV();
				break;
			case 3:
				System.out.println("Nhập mã số sinh viên cần sửa: ");
				maSV = sc.nextLine();
				danhSachSinhVien.suaThongTinSV(maSV);
				break;
			case 4:
				System.out.println("Nhập mã số sinh viên cần xoá: ");
				maSV = sc.nextLine();
				danhSachSinhVien.xoaSinhVien(maSV);
				break;
			case 5:
				System.out.println("Nhập mã số sinh viên cần tìm kiếm: ");
				maSV = sc.nextLine();
				danhSachSinhVien.timThongTinSV(maSV);
				break;
			case 6:
				System.out.println("$$$ DANH SÁCH SINH VIÊN SẮP XẾP THEO ĐIỂM TRUNG BÌNH GIẢM DẦN $$$");
				danhSachSinhVien.sapXepSinhVienTheoDiem();
				break;
			case 7:	
				System.out.println("Chương trình kết thúc !");
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		}while(choice != 7);
	}
}
