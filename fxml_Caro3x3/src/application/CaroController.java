package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class CaroController {
	@FXML
	private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
	// Biến để theo dõi lượt của người chơi
	private boolean isXTurn = true;
	// Mảng lưu trạng thái của bàn cờ
	private String[][] board = new String[3][3];

	@FXML
	public void initialize() {
		// Khởi tạo bàn cờ trống
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = "";
			}
		}
	}

	@FXML
	private void handleButtonClick(Button btn, int row, int col) {
		if (board[row][col].isEmpty()) {
			// Cập nhật nút và bàn cờ
			board[row][col] = isXTurn ? "X" : "O";
			btn.setText(board[row][col]);

			// Kiểm tra xem người chơi hiện tại có thắng không
			if (checkWin()) {
				showAlert(board[row][col] + " win");
				resetGame();
			} else if (isBoardFull()) {
				showAlert("It's a tie");
				resetGame();
			} else {
				// Đổi lượt người chơi
				isXTurn = !isXTurn;
			}
		}
	}

	// Sự kiện khi người chơi nhấn vào các ô
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

	// Hàm kiểm tra xem có người chơi nào thắng hay không
	private boolean checkWin() {
		// Kiểm tra hàng,cột và đường chéo
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// Kiểm tra có hàng nào thắng hay không
				if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].isEmpty()) {
					return true;
				}
				// Kiểm tra có cột nào thắng hay không
				if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].isEmpty()) {
					return true;
				}
				// Kiểm tra 2 đường chéo có thắng hay không
				if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].isEmpty()) {
					return true;
				}
				if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].isEmpty()) {
					return true;
				}
			}
		}
		return false;
	}

	// Hàm kiểm tra xem bàn cờ có đầy hay không
	private boolean isBoardFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}

	// Hiển thị thông báo khi trò chơi kết thúc
	private void showAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Game over");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	// Reset trò chơi
	private void resetGame() {
		isXTurn = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = "";
			}
		}
		btn1.setText("");
		btn2.setText("");
		btn3.setText("");
		btn4.setText("");
		btn5.setText("");
		btn6.setText("");
		btn7.setText("");
		btn8.setText("");
		btn9.setText("");
	}
}
