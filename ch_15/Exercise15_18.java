package ch_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * **15.18 (Move a rectangle using mouse) Write a program that displays a rectangle.
 * You can point the mouse inside the rectangle and drag (i.e., move with mouse
 * pressed) the rectangle wherever the mouse goes. The mouse point becomes the
 * center of the rectangle.
 */
public class Exercise15_18 extends javafx.application.Application {
    static final double WIDTH = 600;
    static final double HEIGHT = 600;
    static final Color FILL_COLOR = Color.TRANSPARENT;
    static final Color STROKE_COLOR = Color.BLACK;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Rectangle rec = rectangle();
        Pane pane = new Pane(rec);
        rec.setOnMouseDragged(e -> {
            rec.setX(e.getX() - rec.getWidth() / 2);
            rec.setY(e.getY() - rec.getHeight() / 2);
        });
        primaryStage.setScene(new Scene(pane, WIDTH, HEIGHT));
        primaryStage.setTitle("Move a rectangle using mouse");
        primaryStage.show();
    }

    Rectangle rectangle() {
        Rectangle rec = new Rectangle(WIDTH / 2, HEIGHT / 2, 60, 30);
        rec.setFill(FILL_COLOR);
        rec.setStroke(STROKE_COLOR);
        return rec;
    }

}
