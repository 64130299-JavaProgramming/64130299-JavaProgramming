package th.nguyenxuandat.FlashQuizGUI.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.List;

public class FlashQuizController {

    @FXML private Button btnQuestion1,btnQuestion2,btnQuestion3,btnQuestion4,btnQuestion5,
    btnQuestion6,btnQuestion7,btnQuestion8,btnQuestion9,btnQuestion10;

    private List<Button> buttonQuestionList; // Danh sách các button để thực hiển đổi màu

    @FXML
    public void initialize() {
        initializeButtonList();
    }

     //Hàm thêm tất cả các button vào danh sách để xử lý đổi màu
    private void initializeButtonList() {
    	buttonQuestionList = new ArrayList<>();

        // Lấy tất cả các button và thêm vào danh sách
    	buttonQuestionList.addAll(List.of(btnQuestion1, btnQuestion2, btnQuestion3, btnQuestion4, btnQuestion5, 
        		btnQuestion6, btnQuestion7, btnQuestion8, btnQuestion9, btnQuestion10));
    }

    @FXML
    public void handleButtonClick(javafx.event.ActionEvent event) {
        // Đưa tất cả button về màu mặc định
        for (Button btn : buttonQuestionList) {
            btn.setStyle("-fx-background-color: #D4EBF8;");
        }

        // Đổi màu cho button được nhấn
        Button clickedButton = (Button) event.getSource();
        clickedButton.setStyle("-fx-background-color: #F96E2A;");
    }
}

