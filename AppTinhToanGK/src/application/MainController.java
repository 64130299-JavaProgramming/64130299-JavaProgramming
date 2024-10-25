package application;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MainController {
	@FXML
	private TextField txtKetQua;
	
	private StringBuilder duLieuHienTai = new StringBuilder();
	private double ketQua = 0;
	private String toanTuCuoi = "=";
}
