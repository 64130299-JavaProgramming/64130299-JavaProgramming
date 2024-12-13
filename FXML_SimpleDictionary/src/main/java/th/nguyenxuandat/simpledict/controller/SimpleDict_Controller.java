package th.nguyenxuandat.simpledict.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.HashMap;

public class SimpleDict_Controller {

    @FXML
    private TextField searchField;
    @FXML
    private Button searchButton;
    @FXML
    private ListView<String> wordListView;
    @FXML
    private TextArea definitionTextArea;
    @FXML
    private TextField newWordField;
    @FXML
    private TextField newDefinitionField;
    @FXML
    private Button addWordButton;
    @FXML
    private Button deleteWordButton;

    private final HashMap<String, String> dictionary = new HashMap<>();
    private final ObservableList<String> wordList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        dictionary.put("apple", "táo");
        dictionary.put("banana", "chuối");
        dictionary.put("cat", "mèo");

        wordList.addAll(dictionary.keySet());
        wordListView.setItems(wordList);

        searchButton.setOnAction(e -> searchWord());
        addWordButton.setOnAction(e -> addWord());
        deleteWordButton.setOnAction(e -> deleteWord());
        wordListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showDefinition(newValue));
    }

    private void searchWord() {
        String search = searchField.getText().trim().toLowerCase();
        if (dictionary.containsKey(search)) {
            wordListView.getSelectionModel().select(search);
            definitionTextArea.setText(dictionary.get(search));
        } else {
            definitionTextArea.setText("Từ không tìm thấy.");
        }
    }

    private void addWord() {
        String newWord = newWordField.getText().trim().toLowerCase();
        String newDefinition = newDefinitionField.getText().trim();
        if (!newWord.isEmpty() && !newDefinition.isEmpty() && !dictionary.containsKey(newWord)) {
            dictionary.put(newWord, newDefinition);
            wordList.add(newWord);
            newWordField.clear();
            newDefinitionField.clear();
        } else {
            definitionTextArea.setText("Từ đã tồn tại hoặc thông tin không hợp lệ.");
        }
    }

    private void deleteWord() {
        String selectedWord = wordListView.getSelectionModel().getSelectedItem();
        if (selectedWord != null) {
            dictionary.remove(selectedWord);
            wordList.remove(selectedWord);
            definitionTextArea.clear();
        }
    }

    private void showDefinition(String word) {
        if (word != null) {
            definitionTextArea.setText(dictionary.get(word));
        }
    }
}
