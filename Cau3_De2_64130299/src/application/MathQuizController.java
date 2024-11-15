package application;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javafx.util.Duration;

public class MathQuizController {

    @FXML private Label questionLabel;
    @FXML private Button option1;
    @FXML private Button option2;
    @FXML private Button option3;
    @FXML private Button option4;
    @FXML private Label timerLabel;
    @FXML private Label scoreLabel;

    private int correctAnswer;
    private int score = 0;
    private int questionNumber = 1; // Thêm biến theo dõi số thứ tự câu hỏi
    private Timeline countdownTimer;
    private boolean isTimeOut = false; // Biến để theo dõi trạng thái hết thời gian

    @FXML
    public void initialize() {
        generateQuestion();
    }

    private void generateQuestion() {
        Random random = new Random();
        int a = random.nextInt(10) + 1;
        int b = random.nextInt(10) + 1;
        String operation = getRandomOperation(random);
        
        // Tính toán đáp án đúng dựa trên phép toán
        switch (operation) {
            case "+":
                correctAnswer = a + b;
                break;
            case "-":
                correctAnswer = a - b;
                break;
            case "*":
                correctAnswer = a * b;
                break;
            case "/":
                correctAnswer = a / b;
                break;
            case "div":
                correctAnswer = a / b; 
                break;
            case "mod":
                correctAnswer = a % b;
                break;
        }

        // Cập nhật nhãn câu hỏi với số thứ tự câu hỏi
        questionLabel.setText("Câu hỏi " + questionNumber + ": " + a + " " + operation + " " + b + " = ?");

        // Tạo tùy chọn
        List<Integer> options = generateOptions(correctAnswer);
        Collections.shuffle(options);

        // Thiết lập văn bản cho các nút
        option1.setText(options.get(0).toString());
        option2.setText(options.get(1).toString());
        option3.setText(options.get(2).toString());
        option4.setText(options.get(3).toString());

        // Bắt đầu đếm ngược
        startCountdown();
    }

    private String getRandomOperation(Random random) {
        String[] operations = {"+", "-", "*", "/", "div", "mod"};
        return operations[random.nextInt(operations.length)];
    }

    private List<Integer> generateOptions(int correct) {
        List<Integer> options = new ArrayList<>();
        options.add(correct);  // Thêm đáp án đúng
        Random random = new Random();

        // Tạo 3 đáp án sai
        while (options.size() < 4) {
            int wrongAnswer = random.nextInt(20);
            if (!options.contains(wrongAnswer)) {
                options.add(wrongAnswer);
            }
        }
        return options;
    }

    @FXML
    private void handleAnswer(ActionEvent event) {
        if (isTimeOut) { // Nếu hết thời gian thì không xử lý trả lời
            return;
        }

        Button selectedButton = (Button) event.getSource();
        int selectedAnswer = Integer.parseInt(selectedButton.getText());

        if (selectedAnswer == correctAnswer) {
            selectedButton.setStyle("-fx-background-color: green; -fx-text-fill: white;");
            score++;
            scoreLabel.setText("Điểm: " + score);
            questionLabel.setText("Đúng rồi! Điểm: " + score);
        } else {
            selectedButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
            questionLabel.setText("Sai rồi! Đáp án đúng: " + correctAnswer);
        }

        // Dừng bộ đếm thời gian
        if (countdownTimer != null) {
            countdownTimer.stop();
        }

        // Tăng số thứ tự câu hỏi và tạo câu hỏi tiếp theo
        questionNumber++; // Tăng số thứ tự câu hỏi
        Timeline delayTimeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            // Reset styles cho tất cả các nút
            option1.setStyle("-fx-background-color: #87cefa; -fx-text-fill: white;");
            option2.setStyle("-fx-background-color: #87cefa; -fx-text-fill: white;");
            option3.setStyle("-fx-background-color: #87cefa; -fx-text-fill: white;");
            option4.setStyle("-fx-background-color: #87cefa; -fx-text-fill: white;");

            generateQuestion(); // Tạo câu hỏi tiếp theo
        }));
        delayTimeline.setCycleCount(1);
        delayTimeline.play();
    }

    private void startCountdown() {
        isTimeOut = false; // Reset trạng thái hết thời gian
        timerLabel.setText("Thời gian: 5");
        countdownTimer = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            int timeLeft = Integer.parseInt(timerLabel.getText().split(": ")[1]) - 1;
            if (timeLeft >= 0) {
                timerLabel.setText("Thời gian: " + timeLeft);
            } else {
                countdownTimer.stop();
                isTimeOut = true; // Đánh dấu là hết thời gian
                
                // Vô hiệu hóa các nút lựa chọn khi hết thời gian
                option1.setDisable(true);
                option2.setDisable(true);
                option3.setDisable(true);
                option4.setDisable(true);

                questionLabel.setText("Hết thời gian! Đáp án đúng: " + correctAnswer);
                questionNumber++; // Tăng số thứ tự câu hỏi
                generateQuestion(); // Tạo câu hỏi tiếp theo sau khi hết thời gian
            }
        }));
        countdownTimer.setCycleCount(5);
        countdownTimer.play();
    }

}
