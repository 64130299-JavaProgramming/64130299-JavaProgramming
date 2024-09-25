import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class DanhSachSinhVien {
	ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();

	// 1.Thêm sinh viên vào danh sách
	public void themSinhVien(SinhVien sv) {
		danhSachSinhVien.add(sv);
	}

	// 2.Hiển thị danh sách sinh viên
	public void hienThiDSSV() {
		for (SinhVien sv : danhSachSinhVien) {
			System.out.println(sv);
		}
	}

	// 3.Sửa thông tin dựa vào mã sinh viên
	public void suaThongTinSV(String maSV) {
		Scanner sc = new Scanner(System.in);
		for (SinhVien sv : danhSachSinhVien) {
			if (sv.getMaSV().equals(maSV)) {
				//Nhập thông tin mới
				System.out.println("Nhập họ và tên mới: ");
				String hoten = sc.nextLine();
				System.out.println("Nhập tuổi mới: ");
				int tuoi = sc.nextInt();
				System.out.println("Nhập điểm trung bình mới: ");
				float dtb = sc.nextFloat();
				
				sv.setHoTen(hoten);
				sv.setTuoi(tuoi);
				sv.setDtb(dtb);
				
				System.out.println("Cập nhật thông tin thành công !");
				break;
			}
			System.out.println("Không tìm thấy sinh viên mã số " + sv.getMaSV() + " trong danh sách !");
		}
	}
	
	//4.Xóa sinh viên khỏi danh sách dựa vào mã số sinh viên
	public void xoaSinhVien(String maSV) {
		for(SinhVien sv: danhSachSinhVien) {
			if(sv.getMaSV().equals(maSV)) {
				danhSachSinhVien.remove(sv);
				System.out.println("Xóa sinh viên thành công");
				break;
			}
			System.out.println("Không tìm thấy sinh viên để xóa !");
		}
	}

	// 5.Tìm kiếm thông tin sinh viên dựa vào mã số sinh viên
	public void timThongTinSV(String maSV) {
		for (SinhVien sv : danhSachSinhVien) {
			if (sv.getMaSV().equals(maSV)) {
				System.out.println(sv.toString());
				break;
			}
			System.out.println("Không tìm thấy sinh viên mã số " + sv.getMaSV() + " trong danh sách !");
		}
	}
	
	//6.Sắp xếp danh sách sinh viên theo điểm trung bình giảm dần
	public void sapXepSinhVienTheoDiem() {
		Collections.sort(danhSachSinhVien,new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien sv1, SinhVien sv2) {
				return Double.compare(sv2.getDtb(), sv1.getDtb());
			}
		});
		System.out.println("*** Sắp xếp sinh viên thành công ***");
	}
}
