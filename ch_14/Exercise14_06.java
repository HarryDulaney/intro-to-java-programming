package ch_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * *14.6 (Game: display a checkerboard) Write a program that displays a checkerboard
 * in which each white and black cell is a Rectangle with a fill color black or
 * white, as shown in Figure 14.44c.
 */
public class Exercise14_06 extends javafx.application.Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        boolean colorCell = false;
        Rectangle[][] rectangles = new Rectangle[8][8];
        for (int r = 0; r < rectangles.length; r++) {
            for (int c = 0; c < rectangles[r].length; c++) {
                rectangles[r][c] = new Rectangle(25, 25);
                rectangles[r][c].setFill(colorCell ? Color.BLACK : Color.WHITE);
                colorCell = !colorCell;
            }
            colorCell = !colorCell;
        }
        for (int r = 0; r < rectangles.length; r++) {
            for (int c = 0; c < rectangles[r].length; c++) {
                gridPane.add(rectangles[r][c], c, r);

            }
        }
        Scene scene = new Scene(gridPane);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
