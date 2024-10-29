package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Node;

public class MainController {
	@FXML
    private TableView<Product> productTable;
    @FXML
    private TableColumn<Product, Integer> idColumn;
    @FXML
    private TableColumn<Product, String> nameColumn;
    @FXML
    private TableColumn<Product, Double> priceColumn;
    @FXML
    private TableColumn<Product, Integer> quantityColumn;
    
    @FXML
    private TableColumn<Product, String> descriptionColumn;

    private ObservableList<Product> productList = FXCollections.observableArrayList();
    
    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description")); 

        loadProductData();
        productTable.setItems(productList);
    }
    
    private void loadProductData() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connection = dbConnection.getConnection();

        String query = "SELECT * FROM products"; // Thay 'products' bằng tên bảng của bạn
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description"); // Lấy mô tả

                Product product = new Product(id, name, price, quantity, description); // Thêm mô tả vào Product
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
 // Hiển thị thông báo khi nhấn nút "Thêm Sản Phẩm"
    @FXML
    private void handleAddProduct() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Thêm Sản Phẩm");
        alert.setHeaderText(null);
        alert.setContentText("Chức năng Thêm Sản Phẩm đã được chọn.");
        alert.showAndWait();
    }
    
 // Hiển thị thông báo khi nhấn nút "Xóa Sản Phẩm"
    @FXML
    private void handleDeleteProduct() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Xóa Sản Phẩm");
        alert.setHeaderText(null);
        alert.setContentText("Chức năng Xóa Sản Phẩm đã được chọn.");
        alert.showAndWait();
    }

    // Hiển thị thông báo khi nhấn nút "Sửa Sản Phẩm"
    @FXML
    private void handleEditProduct() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Sửa Sản Phẩm");
        alert.setHeaderText(null);
        alert.setContentText("Chức năng Sửa Sản Phẩm đã được chọn.");
        alert.showAndWait();
    }

    // Xử lý sự kiện đăng xuất
    @FXML
    private void handleLogout(ActionEvent event) {
        try {
            // Tải giao diện FXML cho form đăng nhập
            FXMLLoader loader = new FXMLLoader(getClass().getResource("form_login.fxml"));
            Parent root = loader.load();
            // Lấy stage hiện tại và thay đổi scene về màn hình đăng nhập
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Đăng Nhập");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
