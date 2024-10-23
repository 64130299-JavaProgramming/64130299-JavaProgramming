package fxml_QuanLyBanHang;


import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class MainController {
	//Khai báo các thuộc tính cần sử dụng
	@FXML
	private TextField idField;
	@FXML
	private TextField nameField;
	@FXML
	private TextField priceField;
	@FXML
	private TextField descriptionField;
	@FXML
	private TableView<SanPham> productTable;
	
	//Khai báo các cột trong tableview
	@FXML
	private TableColumn<SanPham, Integer> idColumn;
	@FXML
	private TableColumn<SanPham, String> nameColumn;
	@FXML
	private TableColumn<SanPham, Double> priceColumn;
	@FXML
	private TableColumn<SanPham, String> descriptionColumn;
	
	//Khai báo các nút xử lý
	@FXML
	private Button addButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button editButton;
	@FXML
	private Button updateButton;
	@FXML
	private Button searchButton;
	
	//Khai báo biến để kết nối cơ sở dữ liệu
	private Connection connection;
	// Danh sách chứa các sản phẩm, cho phép theo dõi sự thay đổi trong danh sách.
	// Khi danh sách thay đổi, giao diện người dùng có thể tự động cập nhật.
	private ObservableList<SanPham> productList;
	
	public void initialize() throws SQLException {
		//Khởi tạo danh sách các sản phẩm và thiết lập cột cho tableview
		productList = FXCollections.observableArrayList();
		productTable.setItems(productList);
		idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
		descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
		
		//Kết nối đến cơ sở dữ liệu
		connectToDatabase();
		
		//Load sản phẩm từ cơ sở dữ liệu
		loadProduct();
		
		//Thêm sự kiện cho các nút
		addButton.setOnAction(e -> {
			try {
				addProduct();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		deleteButton.setOnAction(e -> {
			try {
				deleteProduct();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		editButton.setOnAction(e -> editProduct());
		updateButton.setOnAction(e -> updateProduct());
		searchButton.setOnAction(e -> {
			try {
				searchProduct();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	private void connectToDatabase() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demobanhang","root", "");
		System.out.println("Kết nối cơ sở dữ liệu thành công !");
	}
	//Hiện danh sách sản phẩm
	private void loadProduct() throws SQLException {
		String query = "SELECT * FROM sanpham";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		while(resultSet.next()) {
			int id = resultSet.getInt("id");
			String name = resultSet.getString("TenSP");
			double price = resultSet.getDouble("GiaSP");
			String description = resultSet.getString("MoTa");
			productList.add(new SanPham(id, name, price, description));
		}
	}
	//Thêm sản phẩm
	private void addProduct() throws SQLException {
		String query = "INSERT INTO sanpham(TenSP,GiaSP,MoTa) VALUES(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, nameField.getText());
		preparedStatement.setDouble(2, Double.parseDouble(priceField.getText()));
		preparedStatement.setString(3, descriptionField.getText());
		preparedStatement.executeUpdate();
	}
	//Tìm kiếm sản phẩm
	private void searchProduct() throws SQLException {
		String query = "SELECT * FROM sanpham WHERE TenSP LIKE ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, "%" + nameField.getText() + "%");
		ResultSet resultSet = preparedStatement.executeQuery();
		productList.clear();
		while(resultSet.next()) {//Hiển thị tất cả các dòng được tìm kiếm dựa theo tên
			int id = resultSet.getInt("id");
			String name = resultSet.getString("TenSP");
			double price = resultSet.getDouble("GiaSP");
			String description = resultSet.getString("MoTa");
			productList.add(new SanPham(id, name, price, description));
		}
	}

	private Object updateProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object editProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	//Xóa sản phẩm
	private void deleteProduct() throws SQLException {
		String query = "DELETE FROM sanpham WHERE id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, Integer.parseInt(idField.getText()));
		preparedStatement.executeUpdate();
		productList.clear();
	}
}
