package fxml_QuanLyBanHang;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerPropertyBase;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SanPham {
	private final IntegerPropertyBase id;
	private final StringProperty name;
	private final DoubleProperty price;
	private final StringProperty description;
	public SanPham(int id, String name, double price, String description) {
		super();
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.price = new SimpleDoubleProperty(price);
		this.description = new SimpleStringProperty(description);
	}
	
	public int getId() {
		return id.get();
	}
	public IntegerPropertyBase idProperty() {
		return id;
	}
	
	public String getName() {
		return name.get();
	}
	public StringProperty nameProperty() {
		return name;
	}
	
	public double getPrice() {
		return price.get();
	}
	public DoubleProperty priceProperty() {
		return price;
	}
	
	public String getDescription() {
		return description.get();
	}
	public StringProperty descriptionProperty() {
		return description;
	}
	
	
}
