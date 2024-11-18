package fxml_2D_Shape;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.StrokeLineJoin;

public class ShapeTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Tạo Canvas và GraphicsContext
        Canvas canvas = new Canvas(300, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Label hiển thị tọa độ
        Label coordinatesLabel = new Label("Tọa độ: (0, 0)");
        coordinatesLabel.setFont(new Font("Arial", 14));
        coordinatesLabel.setStyle("-fx-text-fill: #333;");

        // Xử lý sự kiện di chuyển chuột trên Canvas
        canvas.setOnMouseMoved(event -> {
            double x = event.getX();
            double y = event.getY();
            coordinatesLabel.setText(String.format("Tọa độ: (%.1f, %.1f)", x, y));
        });

        // Tạo Button để vẽ hình
        Button drawButton = new Button("Vẽ Hình");
        drawButton.setOnAction(event -> drawShapes(gc));

        // Thiết lập giao diện nút
        drawButton.setFont(new Font("Arial", 16));
        drawButton.setStyle(
            "-fx-background-color: linear-gradient(to right, #6a11cb, #2575fc);" +
            "-fx-text-fill: white;" +
            "-fx-padding: 10 20;" +
            "-fx-border-radius: 20;" +
            "-fx-background-radius: 20;"
        );

        // Tạo VBox để căn chỉnh các phần tử
        VBox root = new VBox(10); // Khoảng cách giữa các phần tử là 10px
        root.setAlignment(Pos.CENTER); // Căn giữa các phần tử trong VBox
        root.getChildren().addAll(canvas, coordinatesLabel, drawButton); // Thêm Canvas, Label, và Button

        // Thiết lập Scene và Stage
        Scene scene = new Scene(root, 300, 550);
        primaryStage.setTitle("Shape Drawing with Coordinates Display");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Phương thức vẽ hình
    private void drawShapes(GraphicsContext gc) {
        // Xóa Canvas trước khi vẽ
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

        // Thiết lập Stroke Miter Limit (giới hạn miter)
        gc.setLineJoin(StrokeLineJoin.MITER);
        gc.setLineWidth(3);
        gc.setStroke(Color.BLACK);
        gc.setMiterLimit(5); // Đặt giới hạn miter

        // Vẽ Tam giác lớn (Phần đầu)
        gc.beginPath();
        gc.moveTo(150, 70);   // Di chuyển đầu ra vị trí hợp lý
        gc.lineTo(50, 200);   // Di chuyển về phía trái
        gc.lineTo(250, 200);  // Di chuyển về phía phải
        gc.closePath();
        gc.stroke();

        // Vẽ Tai trái (Tam giác nhỏ)
        gc.beginPath();
        gc.moveTo(110, 100);  // Di chuyển tai trái gần đầu hơn
        gc.lineTo(90, 50);    // Di chuyển tai trái lên gần đầu
        gc.lineTo(130, 70);   // Di chuyển tai trái xuống dưới một chút
        gc.closePath();
        gc.stroke();

        // Vẽ Tai phải (Tam giác nhỏ)
        gc.beginPath();
        gc.moveTo(190, 100);  // Di chuyển tai phải gần đầu hơn
        gc.lineTo(210, 50);   // Di chuyển tai phải lên gần đầu
        gc.lineTo(170, 70);   // Di chuyển tai phải xuống dưới một chút
        gc.closePath();
        gc.stroke();

        // Vẽ Mũi (Tam giác nhỏ màu đỏ)
        gc.setStroke(Color.RED);
        gc.beginPath();
        gc.moveTo(150, 180);  // Di chuyển mũi xuống gần phía dưới đầu
        gc.lineTo(125, 150);  // Vị trí bên trái mũi
        gc.lineTo(175, 150);  // Vị trí bên phải mũi
        gc.closePath();
        gc.stroke();

        // Vẽ Thân (Hình tròn lớn)
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.TRANSPARENT);
        gc.strokeOval(85, 220, 130, 130);  // Di chuyển thân về phía dưới đầu

        // Vẽ Chân trái (Hình tròn nhỏ)
        gc.strokeOval(85, 360, 60, 60);  // Chân trái gần thân hơn

        // Vẽ Chân phải (Hình tròn nhỏ)
        gc.strokeOval(155, 360, 60, 60);  // Chân phải gần thân hơn

        // Vẽ Chi tiết chân trái (Hai hình cung màu đỏ tạo hiệu ứng ngắt quãng nằm ngang)
        gc.setStroke(Color.RED);
        gc.beginPath();
        gc.arc(115, 390, 15, 15, 135, 90);  // Vị trí chi tiết chân trái
        gc.stroke();
        gc.beginPath();
        gc.arc(115, 390, 15, 15, 315, 90);  // Vị trí chi tiết chân trái
        gc.stroke();

        // Vẽ Chi tiết chân phải (Hai hình cung màu đỏ tạo hiệu ứng ngắt quãng nằm ngang)
        gc.beginPath();
        gc.arc(185, 390, 15, 15, 135, 90);  // Vị trí chi tiết chân phải
        gc.stroke();
        gc.beginPath();
        gc.arc(185, 390, 15, 15, 315, 90);  // Vị trí chi tiết chân phải
        gc.stroke();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
