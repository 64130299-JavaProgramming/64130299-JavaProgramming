package fxml_QuanLyBanHang;


import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainController {
	//Khai báo các thuộc tính cần sử dụng
	private TextField idField;
	private TextField nameField;
	private TextField priceField;
	private TextField descriptionField;
	private TableView<SanPham> productTable;
	
	//Khai báo các cột trong tableview
	private TableColumn<SanPham, Integer> idColumn;
	private TableColumn<SanPham, String> nameColumn;
	private TableColumn<SanPham, Double> priceColumn;
	private TableColumn<SanPham, String> descriptionColumn;
	
	//Khai báo các nút xử lý
	private Button addButton;
	private Button deleteButton;
	private Button editButton;
	private Button updateButton;
	private Button seacrhButton;
	
	//Khai báo biến để kết nối cơ sở dữ liệu
	private Connection connection;
	// Danh sách chứa các sản phẩm, cho phép theo dõi sự thay đổi trong danh sách.
	// Khi danh sách thay đổi, giao diện người dùng có thể tự động cập nhật.
	private ObservableList<SanPham> productList;
	
	private void connectToDatabase() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demobanhang","root", "");
		System.out.println("Kết nối cơ sở dữ liệu thành công !");
	}
}
