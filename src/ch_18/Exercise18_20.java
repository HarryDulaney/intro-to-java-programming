package ch_18;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

/**
 * 18.20 (Display circles) Write a Java program that displays ovals,
 * as shown in Figure 18.12b.
 * <p>
 * The circles are centered in the pane.
 * <p>
 * The gap between two adjacent circles is 10 pixels,
 * and the gap between the border of the pane and the largest
 * circle is also 10.
 */
public class Exercise18_20 extends Application {

    private double widthStart = 170.0;
    private double space = 10.0;
    Stage stage;

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        Pane pane = new Pane();
        pane.setCenterShape(true);
        drawCircles(widthStart - space, pane);

    }

    private Circle drawCircles(double radius, Pane pane) {
        if (radius < 10.0) {
            Scene scene = new Scene(pane, 340, 340);
            stage.setScene(scene);
            stage.show();
            return new Circle();
        }
        Circle circle = new Circle(widthStart, widthStart, radius);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.TRANSPARENT);
        pane.getChildren().add(circle);
        return drawCircles(radius - 10, pane);
    }
}
