
public class Citizen {
	//Field
	private String id;
	private String name;
	private String gender;
	private Short year;
	private String nation;
	

	//Constructor
	public Citizen(String id, String name, String gender, Short year, String nation) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.year = year;
		this.nation = nation;
	}


	public Citizen() {
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public Short getYear() {
		return year;
	}


	public void setYear(Short year) {
		this.year = year;
	}


	public String getNation() {
		return nation;
	}


	public void setNation(String nation) {
		this.nation = nation;
	}


	@Override
	public String toString() {
		return "[id=" + id + ", Tên =" + name + ", Giới tính=" + gender + ", Năm sinh=" + year + ", Quốc Tịch=" + nation
				+ "]";
	}
	
	
}
