package fxml_2D_Shape;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.StrokeLineJoin;

public class ShapeTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Tạo đối tượng Canvas
        Canvas canvas = new Canvas(300, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Thiết lập Stroke Miter Limit (giới hạn miter)
        gc.setLineJoin(StrokeLineJoin.MITER);
        gc.setLineWidth(3);
        gc.setStroke(Color.BLACK);
        gc.setMiterLimit(5); // Đặt giới hạn miter

        // Vẽ Tam giác lớn (Phần đầu)
        gc.beginPath();
        gc.moveTo(150, 50);
        gc.lineTo(29.8, 200);
        gc.lineTo(273.8, 200);
        gc.closePath();
        gc.stroke();

        // Vẽ Tai trái (Tam giác nhỏ)
        gc.beginPath();
        gc.moveTo(108.8, 86.8);
        gc.lineTo(90, 40);
        gc.lineTo(132, 56.8);
        gc.closePath();
        gc.stroke();

        // Vẽ Tai phải (Tam giác nhỏ)
        gc.beginPath();
        gc.moveTo(194, 96.8);
        gc.lineTo(213.2, 48.7);
        gc.lineTo(170, 70);
        gc.closePath();
        gc.stroke();

        // Vẽ Mũi (Tam giác nhỏ màu đỏ)
        gc.setStroke(Color.RED);
        gc.beginPath();
        gc.moveTo(150.4, 190.8);
        gc.lineTo(123.4, 160);
        gc.lineTo(179.4, 160);
        gc.closePath();
        gc.stroke();

        // Vẽ Thân (Hình tròn lớn)
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.TRANSPARENT);
        gc.strokeOval(70, 220, 160, 160); // Vẽ hình tròn

        // Vẽ Chân trái (Hình tròn nhỏ)
        gc.strokeOval(70, 370, 60, 60);

        // Vẽ Chân phải (Hình tròn nhỏ)
        gc.strokeOval(170, 370, 60, 60);

        // Vẽ Chi tiết chân trái (Hai hình cung màu đỏ tạo hiệu ứng ngắt quãng nằm ngang)
        gc.setStroke(Color.RED);
        gc.beginPath();
        gc.arc(100, 400, 15, 15, 135, 90);
        gc.stroke();
        gc.beginPath();
        gc.arc(100, 400, 15, 15, 315, 90);
        gc.stroke();

        // Vẽ Chi tiết chân phải (Hai hình cung màu đỏ tạo hiệu ứng ngắt quãng nằm ngang)
        gc.beginPath();
        gc.arc(200, 400, 15, 15, 135, 90);
        gc.stroke();
        gc.beginPath();
        gc.arc(200, 400, 15, 15, 315, 90);
        gc.stroke();

        // Đưa Canvas vào một Group và hiển thị trên Stage
        Group root = new Group();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root, 300, 500);
        primaryStage.setTitle("Shape Drawing with Canvas and Stroke Miter Limit");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
