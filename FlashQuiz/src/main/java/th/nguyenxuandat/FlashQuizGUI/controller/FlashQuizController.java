package th.nguyenxuandat.FlashQuizGUI.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import th.nguyenxuandat.FlashQuizGUI.models.Question;
import th.nguyenxuandat.FlashQuizGUI.utils.ExcelReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.FileInputStream;
import java.net.URL;


public class FlashQuizController {

	@FXML
	private Button btnQuestion1, btnQuestion2, btnQuestion3, btnQuestion4, btnQuestion5, btnQuestion6, btnQuestion7,
			btnQuestion8, btnQuestion9, btnQuestion10;

	@FXML
	private Button btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4;

	@FXML
	private StackPane spAnswer1, spAnswer2, spAnswer3, spAnswer4;

	@FXML
	private Label lblAnswerA, lblAnswerB, lblAnswerC, lblAnswerD;

	@FXML
	private Label lblQuestion;

	@FXML
	private TextField tfScore;
	
	// Định nghĩa các tệp âm thanh
    private static final String CORRECT_ANSWER_SOUND = "/th/nguyenxuandat/FlashQuizGUI/controller/correct.wav";
    private static final String INCORRECT_ANSWER_SOUND = "/th/nguyenxuandat/FlashQuizGUI/controller/incorrect.mp3";

	private List<Button> buttonQuestionList = new ArrayList<>(); // Danh sách các button để thực hiển đổi màu

	// Danh sách các button và stackpane câu trả lời
	private List<Button> buttonAnswerList = new ArrayList<>();
	private List<StackPane> stackPaneAnswerList = new ArrayList<>();

	private List<Question> questionList = new ArrayList<>();
	private int currentQuestionIndex = 0;
	private double score = 0.0;

	@FXML
	public void initialize() {
		initializeQuestionButtonList();
		initializeAnswerButtonList();

		// Đọc câu hỏi từ file Excel
		questionList = ExcelReader.readQuestionsFromExcel(
				"src/main/java/th/nguyenxuandat/FlashQuizGUI/controller/MonAnVietNam_Updated.xlsx");

		// Load câu hỏi đầu tiên
		if (!questionList.isEmpty()) {
			loadQuestion(0);
			highlightButton(buttonQuestionList.get(0));
		}
	}

	private void highlightButton(Button button) {
		// Đặt màu nền cho các nút được chọn
		for (Button btn : buttonQuestionList) {
			btn.setStyle("-fx-background-color: #D4EBF8;");
		}
		// Đổi màu cho các button được nhấn
		button.setStyle("-fx-background-color: #F96E2A;");
	}

	private void loadQuestion(int questionIndex) {
		// Kiểm tra chỉ số câu hỏi hợp lệ
		if (questionIndex < 0 || questionIndex >= questionList.size())
			return;

		// Lấy câu hỏi từ danh sách và cập nhật giao diện
		Question question = questionList.get(questionIndex);
		lblQuestion.setText(question.getQuestionText()); // Cập nhật câu hỏi vào Label

		// Cập nhật các phương án trả lời vào các Label tương ứng
		String[] options = question.getOptions();
		lblAnswerA.setText(options[0]);
		lblAnswerB.setText(options[1]);
		lblAnswerC.setText(options[2]);
		lblAnswerD.setText(options[3]);
		
		// Đặt lại màu nền của các button và stackpane về mặc định
	    resetAnswerStyles();
	}

	private void resetAnswerStyles() {
		for (Button btn : buttonAnswerList) {
	        btn.setStyle("-fx-background-radius: 50; -fx-pref-width: 60; -fx-pref-height: 60; -fx-background-color: #D4EBF8;");
	    }
	    for (StackPane sp : stackPaneAnswerList) {
	        sp.setStyle("-fx-background-color: none; -fx-border-color: white;");
	    }
	}

	// Hàm thêm tất cả các button vào danh sách để xử lý đổi màu
	private void initializeQuestionButtonList() {
		// Lấy tất cả các button và thêm vào danh sách
		buttonQuestionList.addAll(List.of(btnQuestion1, btnQuestion2, btnQuestion3, btnQuestion4, btnQuestion5,
				btnQuestion6, btnQuestion7, btnQuestion8, btnQuestion9, btnQuestion10));
	}

	// Hàm thêm các btn và stackpane vào danh sách để xử lý đổi màu
	private void initializeAnswerButtonList() {
		buttonAnswerList.addAll(List.of(btnAnswer1, btnAnswer2, btnAnswer3, btnAnswer4));
		stackPaneAnswerList.addAll(List.of(spAnswer1, spAnswer2, spAnswer3, spAnswer4));
	}

	@FXML
	public void handleButtonQuestionClick(ActionEvent event) {
		// Xử lý khi người dùng nhấn nút câu hỏi
		Button clickedQuestion = (Button) event.getSource();
		int questionIndex = buttonQuestionList.indexOf(clickedQuestion);

		if (questionIndex != -1) {
			currentQuestionIndex = questionIndex; // Cập nhật chỉ số câu hỏi hiện tại
			highlightButton(clickedQuestion);// Đổi màu nút câu hỏi được chọn
			loadQuestion(questionIndex); // Load câu hỏi tương ứng
		}
	}

	@FXML
	public void handleAnswerButtonClick(ActionEvent event) {
		// Lấy nút được nhấn
		Button clickedAnswerButton = (Button) event.getSource();
		int index = buttonAnswerList.indexOf(clickedAnswerButton);
		// Đổi màu nút và StackPane đúng
		if (index != -1) {
			Question currentQuestion = questionList.get(currentQuestionIndex);
			String selectedAnswer = buttonAnswerList.get(index).getText();

			// Đặt lại tất cả nút và StackPane về màu mặc định
			for (Button btnAnswer : buttonAnswerList) {
				btnAnswer.setStyle(
						"-fx-background-radius: 50; -fx-pref-width: 60; -fx-pref-height: 60; -fx-background-color: #D4EBF8;");
			}
			for (StackPane sp : stackPaneAnswerList) {
				sp.setStyle("-fx-background-color: none;-fx-border-color: white;");
			}

			// Kiểm tra câu trả lời để cập nhật điểm số và giao diện
			if (selectedAnswer.equals(currentQuestion.getCorrectAnswer())) {
				score += 1.0;
				clickedAnswerButton.setStyle(
						"-fx-background-radius: 50; -fx-pref-width: 60; -fx-pref-height: 60; -fx-background-color: #399918;");
				stackPaneAnswerList.get(index).setStyle("-fx-background-color: #399918;-fx-border-color: white;");
				// Phát âm thanh cho câu trả lời đúng
				playSound("/th/nguyenxuandat/FlashQuizGUI/controller/correct-choice-43861.mp3");
			} else {
				score -= 0.2;
				clickedAnswerButton.setStyle(
						"-fx-background-radius: 50; -fx-pref-width: 60; -fx-pref-height: 60; -fx-background-color: #FA1616;");
				stackPaneAnswerList.get(index).setStyle("-fx-background-color: #FA1616;-fx-border-color: white;");
				// Phát âm thanh cho câu trả lời sai
                playSound("/th/nguyenxuandat/FlashQuizGUI/controller/incorrect.mp3");
			}
			// Cập nhật điểm số hiển thị
			tfScore.setText(String.format("%.1f", score));
		}
	}
	private void playSound(String soundFilePath) {
	    try {
	        // Lấy đường dẫn từ tài nguyên dự án
	        URL soundURL = getClass().getResource(soundFilePath);
	        if (soundURL == null) {
	            System.err.println("Sound file not found: " + soundFilePath);
	            return;
	        }

	        // Dùng JLayer để phát file MP3
	        FileInputStream fileInputStream = new FileInputStream(soundURL.getFile());
	        AdvancedPlayer player = new AdvancedPlayer(fileInputStream);
	        player.play();
	    } catch (JavaLayerException | IOException e) {
	        System.err.println("Error playing MP3: " + e.getMessage());
	        e.printStackTrace();
	    }
	}



}
