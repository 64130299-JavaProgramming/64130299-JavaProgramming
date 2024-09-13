import java.util.Scanner;

public class AppKiemTraBMI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float chieuCao = -1,canNang = -1;
		do {
			try {
				System.out.print("Nhập chiều cao (m): ");
				chieuCao = sc.nextFloat();
				System.out.print("Nhập cân nặng (kg): ");
				canNang = sc.nextFloat();
			} catch (Exception e) {
				System.out.println("Vui lòng nhập đúng kí tự số");
				sc.next();
			}
		}while(chieuCao <= 0 || canNang <= 0);
	
		float bmi = (float) (canNang / (Math.pow(chieuCao, 2)));
		System.out.println("BMI của bạn là " + bmi);
		if(bmi < 18.5) {
			System.out.println("Bạn bị thiếu cân, ăn nhiều vô !");
		}
		else if(bmi < 24.9){
			System.out.println("Bạn bình thường !");
		}
		else if(bmi < 29.9) {
			System.out.println("Bạn thừa cân !");
		}
		else {
			System.out.println("Bạn bị béo phì, ăn ít thôi !");
		}
	}
}
