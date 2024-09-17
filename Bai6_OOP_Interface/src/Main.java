
public class Main {
	public static void main(String[] args) {
		Cat c = new Cat(true,"Tam The");
		Dog d = new Dog(false, "Bull");
		
		System.out.println(c.toString());
		System.out.println(d.toString());
		
		IAnimal c1 = new Cat(false, "Tam The");
		IAnimal c2 = new Dog(true, "Bull");
		
		System.out.println(c.toString());
		System.out.println(d.toString());
	}
}
