package controller;

public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String description;

    public Product(int id, String name, double price, int quantity,String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
    }

    // Getters và setters
    public int getId() { 
    	return id; 
    }
    public String getName() {
    	return name; 
    }
    public double getPrice() {
    	return price; 
    }
    public int getQuantity() {
    	return quantity;
    }

	public String getDescription() {
		return description;
	}
}
