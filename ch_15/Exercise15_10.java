package ch_15;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * *15.10 (Enter and display a string) Write a program that receives a string from the
 * keyboard and displays it on a pane. The Enter key signals the end of a string.
 * Whenever a new string is entered, it is displayed on the pane.
 */
public class Exercise15_10 extends javafx.application.Application {
    double x = 300;
    double y = 200;
    double moveText = 150;
    String nuString = "";
    boolean alternate = true;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Canvas canvas = new Canvas(600, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.moveTo(x, y);
        gc.setFill(Color.BLACK);
        pane.getChildren().add(canvas);
        Scene scene = new Scene(pane, 600, 400);

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (alternate) {
                    alternate = false;
                    gc.strokeText(nuString, (x + Math.random() * moveText), (y + Math.random() * moveText));
                } else {
                    gc.strokeText(nuString, (x + Math.random() * -moveText), (y + Math.random() * -moveText));
                }
                nuString = "";
            } else {
                nuString += event.getText();
            }
        });

        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}