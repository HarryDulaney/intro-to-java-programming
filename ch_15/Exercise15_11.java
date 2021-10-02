package ch_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * *15.11 (Move a circle using keys) Write a program that moves a circle up, down, left,
 * or right using the arrow keys.
 */
public class Exercise15_11 extends Application {
    static final double WIDTH = 400;
    static final double HEIGHT = 250;
    double x;
    double y;
    double radius = 25;

    @Override
    public void start(Stage primaryStage) throws Exception {
        x = WIDTH / 2; // Start at the Center X
        y = HEIGHT / 2; // Start at the Center Y
        Pane pane = new Pane();
        Circle circle = new Circle(x, y, radius, Color.BLACK);
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        scene.setOnKeyPressed(e -> {
            KeyCode keyCode = e.getCode();
            double addX = 0, addY = 0;
            if (keyCode == KeyCode.UP) {
                addY -= 2;
            } else if (keyCode == KeyCode.DOWN) {
                addY += 2;
            } else if (keyCode == KeyCode.LEFT) {
                addX -= 2;
            } else if (keyCode == KeyCode.RIGHT) {
                addX += 2;
            }
            circle.setCenterX(x + addX);
            circle.setCenterY(y + addY);

            x += addX;
            y += addY;

        });

        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
