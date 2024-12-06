package th.nguyenxuandat.BaiTH1_SimpleMath.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class SimpleMathController {
    @FXML
    private TextField inputA;
    @FXML
    private TextField inputB;
    @FXML
    private ToggleButton addButton, subtractButton, multiplyButton, divideButton;
    private ToggleGroup operatorGroup;
    @FXML
    private Label resultLabel;
    
    @FXML
    private void initialize() {
        // Tạo ToggleGroup và thêm các ToggleButton vào nhóm
        operatorGroup = new ToggleGroup();
        addButton.setToggleGroup(operatorGroup);
        subtractButton.setToggleGroup(operatorGroup);
        multiplyButton.setToggleGroup(operatorGroup);
        divideButton.setToggleGroup(operatorGroup);
    }
    
    private void calculateResult() {
        try {
            double a = Double.parseDouble(inputA.getText());
            double b = Double.parseDouble(inputB.getText());

            // Get selected operation
            ToggleButton selectedButton = (ToggleButton) operatorGroup.getSelectedToggle();
            if (selectedButton == null) {
                resultLabel.setText("Please select an operation");
                return;
            }

            String operation = selectedButton.getText();
            double result = 0;
            switch (operation) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b != 0) {
                        result = a / b;
                    } else {
                        resultLabel.setText("Error: Division by zero");
                        return;
                    }
                    break;
                default:
                    resultLabel.setText("Invalid operation");
                    return;
            }
            // Hiển thị kết quả
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultLabel.setText("Error: Please enter valid numbers");
        }
    }
  
}

