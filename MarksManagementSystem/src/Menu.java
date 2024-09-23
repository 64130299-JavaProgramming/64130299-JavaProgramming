import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		ArrayList<StudentMark> studentMarks = new ArrayList<>();
		StudentMark studentMark = new StudentMark();
		do {
			System.out.println("**** MARKS MANAGEMENT SYSTEM **** ");
			System.out.println("1. Insert new students");
			System.out.println("2. View list of students");
			System.out.println("3. Average Mark");
			System.out.println("4. Exit");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("Enter full name: ");
				String fullName = sc.nextLine();
				studentMark.setFullName(fullName);

				System.out.println("Enter class name: ");
				String className = sc.nextLine();
				studentMark.setClasses(className);

				System.out.println("Enter semester: ");
				int semester = sc.nextInt();
				studentMark.setSemester(semester);

				int[] subjectMarkList = new int[5];
				for (int i = 0; i < subjectMarkList.length; i++) {
					System.out.println("Enter subject mark " + i);
					subjectMarkList[i] = sc.nextInt();
				}
				studentMark.setSubjectMarkList(subjectMarkList);
				studentMark.AveCal();
				studentMarks.add(studentMark);
				break;
			case 2:
				System.out.println("&&& List of students &&&");
				if(studentMarks.isEmpty()) {
					System.out.println("There is no student in the list !");
				}
				else {
					for (StudentMark st: studentMarks) {
						st.display();
					}
				}
				break;
			case 3:
				System.out.println("%%% Average Mark %%%");
				if(studentMarks.isEmpty()) {
					System.out.println("There is no student in the list !");
				}
				else {
					for (StudentMark st: studentMarks) {
						st.AveCal();
						st.display();
					}
				}
				break;
			case 4:
				System.out.println("Exit");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
		} while (choice != 4);
	}
}
