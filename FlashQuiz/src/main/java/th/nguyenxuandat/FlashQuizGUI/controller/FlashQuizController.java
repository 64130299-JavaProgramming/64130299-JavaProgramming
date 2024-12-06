package th.nguyenxuandat.FlashQuizGUI.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;

public class FlashQuizController {

    @FXML private Button btnQuestion1,btnQuestion2,btnQuestion3,btnQuestion4,
    btnQuestion5,btnQuestion6,btnQuestion7,btnQuestion8,btnQuestion9,btnQuestion10;
    
    @FXML private Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4;
    
    @FXML private StackPane spAnswer1, spAnswer2, spAnswer3, spAnswer4;

    private List<Button> buttonQuestionList = new ArrayList<>(); // Danh sách các button để thực hiển đổi màu
    
    //Danh sách các button và stackpane câu trả lời
    private List<Button> buttonAnswerList = new ArrayList<>();
    private List<StackPane> stackPaneAnswerList = new ArrayList<>();

    @FXML
    public void initialize() {
        initializeQuestionButtonList();
        initializeAnswerButtonList();
    }

     //Hàm thêm tất cả các button vào danh sách để xử lý đổi màu
    private void initializeQuestionButtonList() {
        // Lấy tất cả các button và thêm vào danh sách
    	buttonQuestionList.addAll(List.of(btnQuestion1, btnQuestion2, btnQuestion3, btnQuestion4, btnQuestion5, 
        		btnQuestion6, btnQuestion7, btnQuestion8, btnQuestion9, btnQuestion10));
    }
    
    //Hàm thêm các btn và stackpane vào danh sách để xử lý đổi màu
    private void initializeAnswerButtonList() {
    	buttonAnswerList.addAll(List.of(btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4));
    	stackPaneAnswerList.addAll(List.of(spAnswer1,spAnswer2,spAnswer3,spAnswer4));
    }

    @FXML
    public void handleButtonQuestionClick(ActionEvent event) {
        // Đưa tất cả button về màu mặc định
        for (Button btn : buttonQuestionList) {
            btn.setStyle("-fx-background-color: #D4EBF8;");
        }

        // Đổi màu cho button được nhấn
        Button clickedButton = (Button) event.getSource();
        clickedButton.setStyle("-fx-background-color: #F96E2A;");
    }
    
    @FXML
    public void handleAnswerButtonClick(ActionEvent event) {
        // Lấy nút được nhấn
        Button clickedAnswerButton = (Button) event.getSource();
        int index = buttonAnswerList.indexOf(clickedAnswerButton);

        // Đặt lại tất cả nút và StackPane về màu mặc định
        for (Button btnAnswer : buttonAnswerList) {
        	btnAnswer.setStyle("-fx-background-radius: 50; -fx-pref-width: 60; -fx-pref-height: 60; -fx-background-color: #D4EBF8;");
        }
        for (StackPane sp : stackPaneAnswerList) {
            sp.setStyle("-fx-background-color: none;-fx-border-color: white;");
        }

        // Đổi màu nút và StackPane đúng
        if (index != -1) {
        	buttonAnswerList.get(index).setStyle("-fx-background-radius: 50; -fx-pref-width: 60; -fx-pref-height: 60; -fx-background-color: #399918;"); 
        	stackPaneAnswerList.get(index).setStyle("-fx-background-color: #399918;-fx-border-color: white;");
        }
    }
}

