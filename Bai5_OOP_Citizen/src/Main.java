
public class Main {

	public static void main(String[] args) {
		Citizen c1 = new Citizen("001", "Nguyễn Xuân Đạt", "Nam", (short) 2004, "Việt Nam");
		Citizen c2 = new Citizen("002", "Jame Bond", "Nam", (short) 2001, "Hoa Kỳ");
		Citizen c3 = new Citizen("003", "Trần Tiến Phúc", "Nam", (short) 2000, "Trung Quốc");
		Citizen c4 = new Citizen();
		
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		System.out.println(c4.toString());
		
		System.out.println("Tên id 1: " + c1.getName());
		c1.setGender("Nữ");
		System.out.println("Giới tính id 1: " + c1.getGender());
	}
}
