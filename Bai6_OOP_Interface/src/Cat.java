
public class Cat implements IAnimal {
	private boolean gender;
	private String category;
	
	

	public Cat(boolean gender, String category) {
		super();
		this.gender = gender;
		this.category = category;
	}

	@Override
	public void sound() {
		System.out.println("Meo Meo ...");
	}

	@Override
	public String toString() {
		return "Cat [gender=" + gender + ", category=" + category + "]";
	}
	
	
	
}
