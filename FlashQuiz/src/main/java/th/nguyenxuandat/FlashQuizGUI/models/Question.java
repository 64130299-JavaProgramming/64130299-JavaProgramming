package th.nguyenxuandat.FlashQuizGUI.models;

public class Question {
    private String questionText;
    private String[] options;
    private String correctAnswer;
    private String imageUrl;

    public Question(String questionText, String[] options, String correctAnswer, String imageUrl) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.imageUrl = imageUrl;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
    
    
}

