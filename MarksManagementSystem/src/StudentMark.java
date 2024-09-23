

public class StudentMark implements IStudentMark{
	private String fullName;
	private int id;
	private String classes;
	private int semester;
	private float averageMark;
	@Override
	public void display() {
		System.out.println("Full name : " + fullName);
		System.out.println("ID: " + id);
		System.out.println("Class: " + classes);
		System.out.println("Semester: " + semester);
		System.out.println("Average Mark: " + averageMark);
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int[] getSubjectMarkList() {
		return subjectMarkList;
	}

	public void setSubjectMarkList(int[] subjectMarkList) {
		this.subjectMarkList = subjectMarkList;
	}

	public float getAverageMark() {
		return averageMark;
	}

	private int[] subjectMarkList = new int[5];
	
	public void AveCal() {
		float sum = 0;
		for(int i = 0; i < subjectMarkList.length; i++) {
			sum += subjectMarkList[i];
		}
		averageMark = (float)sum / 5;
	}
}
