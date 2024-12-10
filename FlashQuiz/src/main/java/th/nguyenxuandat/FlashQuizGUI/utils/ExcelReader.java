package th.nguyenxuandat.FlashQuizGUI.utils;

import org.apache.poi.ss.usermodel.*;

import th.nguyenxuandat.FlashQuizGUI.models.Question;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    public static List<Question> readQuestionsFromExcel(String filePath) {
        List<Question> questions = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Bỏ qua tiêu đề
                String questionText = row.getCell(0).getStringCellValue();
                String optionA = row.getCell(1).getStringCellValue();
                String optionB = row.getCell(2).getStringCellValue();
                String optionC = row.getCell(3).getStringCellValue();
                String optionD = row.getCell(4).getStringCellValue();
                String correctAnswer = row.getCell(5).getStringCellValue();
                questions.add(new Question(questionText, new String[]{optionA, optionB, optionC, optionD}, correctAnswer));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }
}

