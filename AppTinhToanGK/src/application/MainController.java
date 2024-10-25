package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainController {
	@FXML
	private TextField display;
	
	private StringBuilder currentInput = new StringBuilder();
	private double result = 0;
	private String lastOperator = "=";
	
	//Xử lý sự kiện nhấn trên các nút chứa số
	@FXML
	private void handleButtonClick(Button button) {
		String buttonText = button.getText();
		//Kiểm tra xem người dùng có bấm trên nút số hay không
		if("0123456789".contains(buttonText)) {
			//nếu có thì thêm vào biến input
			currentInput.append(buttonText);
			display.setText(currentInput.toString());
		}
		else {
			//nếu không thì truyền vào hàm tính toán
			handleOperator(buttonText);
		}
	}
	//Xử lý các phép toán cộng, trừ, nhân, chia
	private void handleOperator(String operator) {
		// TODO Auto-generated method stub
		if(!currentInput.toString().isEmpty()) {
			double currentNumber = Double.parseDouble(currentInput.toString());
			switch (lastOperator) {
				case "+" :
					result += currentNumber;
					break;
				case "-" :
					result -= currentNumber;
					break;
				case "x" :
					result *= currentNumber;
					break;
				case "÷" :
					if(currentNumber != 0) {
						result  /= currentNumber;
					}
					else {
						display.setText("Error!");
						return;
					}
					break;
				case "=" :
					result = currentNumber;
					break;
			}
			display.setText(String.valueOf(result));
			currentInput.setLength(0);
		}
		lastOperator = operator;
	}
	//Xóa display
	private void clear() {
		currentInput.setLength(0);
		display.clear();
		result = 0;
		lastOperator = "=";
	}
}

