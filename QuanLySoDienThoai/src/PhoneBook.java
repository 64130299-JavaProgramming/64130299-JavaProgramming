import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PhoneBook implements Phone {
	ArrayList<String> phoneList = new ArrayList<String>();

	// 1.Thêm người dùng cùng số điện thoại tương ứng vào danh sách
	@Override
	public void insertPhone(String name, String phone) {
	    boolean nameExists = false;
	    
	    for (int i = 0; i < phoneList.size(); i++) {
	        String phoneRecord = phoneList.get(i);
	        
	        // Kiểm tra nếu tên đã tồn tại trong danh bạ
	        if (phoneRecord.contains(name)) {
	            nameExists = true;
	            
	            // Kiểm tra nếu số điện thoại đã tồn tại với tên đó
	            if (phoneRecord.contains(phone)) {
	                System.out.println(phone + " đã có trong danh bạ!");
	                return; // Không cần tiếp tục thực hiện nếu số đã tồn tại
	            } else {
	                // Cập nhật thêm số điện thoại mới vào bản ghi
	                phoneList.set(i, phoneRecord + " , " + phone);
	                System.out.println("Đã cập nhật sđt " + phone + " của " + name + " vào danh sách.");
	                return;
	            }
	        }
	    }
	    // Nếu tên chưa tồn tại, thêm một bản ghi mới
	    if (!nameExists) {
	        phoneList.add(name + " : " + phone);
	        System.out.println("Đã thêm sđt " + phone + " của " + name + " vào danh sách.");
	    }
	}

	// Xóa người dùng cùng số điện thoại ra khỏi danh sách
	@Override
	public void removePhone(String name) {
		boolean found = false;
		for (String phoneRecord : phoneList) {
			if (phoneRecord.contains(name)) {
				phoneList.remove(phoneRecord);
				System.out.println("Đã xóa số điện thoại của" + name + "ra khỏi danh sách.");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println(name + "không có trong danh bạ để xóa số điện thoại.");
		}

	}

	@Override
	public void updatePhone(String name, String newphone) {
		boolean found = false;
		for (int i = 0; i < phoneList.size(); i++) {
			if (phoneList.get(i).contains(name)) {
				phoneList.set(i, name + ":" + newphone);
				System.out.println(name + " : " + newphone);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println(name + "không có trong danh bạ để cập nhật số điện thoại mới.");
		}

	}

	@Override
	public void searchPhone(String name) {
		boolean found = false;
		for (String phoneRecord : phoneList) {
			if (phoneRecord.contains(name)) {
				System.out.println(name + " : " + phoneRecord);
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println(name + "không có trong danh bạ để thêm số điện thoại.");
		}
	}

	@Override
	public void sort() {
		// Sắp xếp danh bạ theo tên
		Collections.sort(phoneList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// tách chuỗi thành mảng con
				return o1.split(":")[0].compareTo(o2.split(":")[0]);
			}
		});
		System.out.println("----DANH BẠ ĐÃ ĐƯỢC SẮP XẾP----");
	}
	
	//Phương thức để in ra danh bạ hiện tại
	public void printPhoneBook() {
		for(String phoneRecord : phoneList) {
			System.out.println(phoneRecord);
		}
	}

}
