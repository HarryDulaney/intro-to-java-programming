package ch_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * 15.9 (Draw lines using the arrow keys) Write a program that draws line segments
 * using the arrow keys. The line starts from the center of the pane and draws
 * toward east, north, west, or south when the right-arrow key, up-arrow key, left
 * arrow key, or down-arrow key is pressed, as shown in Figure 15.26b.
 */
public class Exercise15_09 extends Application {
    static final double WIDTH = 400;
    static final double HEIGHT = 250;
    double x;
    double y;

    @Override
    public void start(Stage primaryStage) throws Exception {
        x = WIDTH / 2; // Start at the Center X
        y = HEIGHT / 2; // Start at the Center Y
        Pane pane = new Pane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.moveTo(x, y);
        gc.setFill(Color.BLACK);
        gc.setLineWidth(3);
        pane.getChildren().add(canvas);
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
            gc.lineTo(x + addX, y + addY);
            x += addX;
            y += addY;
            gc.stroke();


        });
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
