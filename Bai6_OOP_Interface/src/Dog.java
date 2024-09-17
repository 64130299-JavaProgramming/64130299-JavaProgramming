
public class Dog implements IAnimal{
	private boolean gender;
	private String category;
	
	
	


	public Dog(boolean gender, String category) {
		super();
		this.gender = gender;
		this.category = category;
	}


	@Override
	public void sound() {
		System.out.println("Gâu Gâu ...");
		
	}


	@Override
	public String toString() {
		return "Dog [gender=" + gender + ", category=" + category + "]";
	}
	
	

}
