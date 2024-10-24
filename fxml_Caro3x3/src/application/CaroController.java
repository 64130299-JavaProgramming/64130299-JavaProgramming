package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CaroController {
	@FXML
	private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
	//Biến để theo dõi lượt của người chơi
	private boolean isXTurn = true;
	//Mangr lưu trạng thái của bàn cờ
	private String[][] board = new String[3][3];
	
	@FXML
	public void initialize() {
		//Khởi tạo bàn cờ trống
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = "";
			}
		}
	}
	
	@FXML
	private void handleButtonClick(Button btn,int row,int col) {
		if(board[row][col].isEmpty()) {
			//Cập nhật nút và bàn cờ
			board[row][col] = isXTurn ? "X" : "O";
			btn.setText(board[row][col]);
			
			//Kiểm tra xem người chơi hiện tại có thắng không
			if(checkWin()) {
				showAlert(board[row][col] + "win");
				resetGame();
			}
			else if(isBoardFul()) {
				showAlert("It's a tie");
				resetGame();
			}
			else {
				//Đổi lượt người chơi
				isXTurn = !isXTurn;
			}
		}
	}
	//Sự kiện khi người chơi nhấn vào các ô
	@FXML
	private void onBtn1Click() {
		handleButtonClick(btn1, 0, 0);
	}
	
	@FXML
	private void onBtn2Click() {
		handleButtonClick(btn2, 0, 1);
	}
	
	@FXML
	private void onBtn3Click() {
		handleButtonClick(btn3, 0, 2);
	}
	
	@FXML
	private void onBtn4Click() {
		handleButtonClick(btn4, 1, 0);
	}
	
	@FXML
	private void onBtn5Click() {
		handleButtonClick(btn5, 1, 1);
	}
	
	@FXML
	private void onBtn6Click() {
		handleButtonClick(btn6, 1, 2);
	}
	
	@FXML
	private void onBtn7Click() {
		handleButtonClick(btn7, 2, 0);
	}
	
	@FXML
	private void onBtn8Click() {
		handleButtonClick(btn8, 2, 1);
	}
	
	@FXML
	private void onBtn9Click() {
		handleButtonClick(btn9, 2, 2);
	}
}
