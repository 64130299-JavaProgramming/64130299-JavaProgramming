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
}
