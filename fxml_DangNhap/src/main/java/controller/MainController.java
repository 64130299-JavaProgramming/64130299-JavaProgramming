package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.sql.*;

public class MainController {
    @FXML private TableView<HocSinh> studentTable;
    @FXML private TableColumn<HocSinh, Integer> idColumn;
    @FXML private TableColumn<HocSinh, String> nameColumn;
    @FXML private TableColumn<HocSinh, Integer> ageColumn;
    @FXML private TableColumn<HocSinh, String> classColumn;
    
    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField ageField;
    @FXML private TextField addressField;

    private ObservableList<HocSinh> studentList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        ageColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getAge()).asObject());
        classColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClassName()));

        loadStudents();
    }

    private void loadStudents() {
        String query = "SELECT * FROM hocsinh";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            studentList.clear();
            while (rs.next()) {
                studentList.add(new HocSinh(rs.getInt("id"), rs.getString("ten"), rs.getInt("tuoi"), rs.getString("diachi")));
            }
            studentTable.setItems(studentList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleAdd() {
        try {
            String query = "INSERT INTO hocsinh (ten, tuoi, diachi) VALUES (?, ?, ?)";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, nameField.getText());
                pstmt.setInt(2, Integer.parseInt(ageField.getText()));
                pstmt.setString(3, addressField.getText());

                pstmt.executeUpdate();
                loadStudents();
                clearFields();
                showAlert("Thêm học sinh thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Lỗi khi thêm học sinh!");
        } catch (NumberFormatException e) {
            showAlert("Vui lòng nhập số hợp lệ cho tuổi!");
        }
    }

    @FXML
    private void handleEdit() {
        if (studentTable.getSelectionModel().getSelectedItem() == null) {
            showAlert("Vui lòng chọn học sinh để sửa!");
            return;
        }

        try {
            String query = "UPDATE hocsinh SET ten = ?, tuoi = ?, diachi = ? WHERE id = ?";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                HocSinh selectedStudent = studentTable.getSelectionModel().getSelectedItem();
                pstmt.setString(1, nameField.getText());
                pstmt.setInt(2, Integer.parseInt(ageField.getText()));
                pstmt.setString(3, addressField.getText());
                pstmt.setInt(4, selectedStudent.getId());

                pstmt.executeUpdate();
                loadStudents();
                clearFields();
                showAlert("Sửa thông tin học sinh thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Lỗi khi sửa thông tin học sinh!");
        } catch (NumberFormatException e) {
            showAlert("Vui lòng nhập số hợp lệ cho tuổi!");
        }
    }

    @FXML
    private void handleDelete() {
        if (studentTable.getSelectionModel().getSelectedItem() == null) {
            showAlert("Vui lòng chọn học sinh để xóa!");
            return;
        }

        try {
            String query = "DELETE FROM hocsinh WHERE id = ?";
            try (Connection conn = connect();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {
                HocSinh selectedStudent = studentTable.getSelectionModel().getSelectedItem();
                pstmt.setInt(1, selectedStudent.getId());

                pstmt.executeUpdate();
                loadStudents();
                clearFields();
                showAlert("Xóa học sinh thành công!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Lỗi khi xóa học sinh!");
        }
    }

    private void clearFields() {
        idField.clear();
        nameField.clear();
        ageField.clear();
        addressField.clear();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private Connection connect() {
        String url = "jdbc:mysql://localhost:3306/danhsachhocsinh";
        String user = "root";  // Change this to your MySQL username
        String password = ""; // Change this to your MySQL password
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
