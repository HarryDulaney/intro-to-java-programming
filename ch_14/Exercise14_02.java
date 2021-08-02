package ch_14;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.util.Random;

/**
 * *14.2 (Tic-tac-toe board) Write a program that displays a tic-tac-toe board, as shown
 * in Figure 14.43b. A cell may be X, O, or empty. What to display at each cell is
 * randomly decided. The X and O are images in the files x.gif and o.gif.
 */
public class Exercise14_02 extends Application {
    Random random = new Random();
    static final String resourcePath = "resources" + File.separator + "tictactoe";

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gameBoard = new GridPane();
        Image X = new Image(resourcePath + File.separator + "x.png");
        Image O = new Image(resourcePath + File.separator + "o.png");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Pane pane = new Pane();
                ImageView imageView = new ImageView();
                if (getRandomXO()) {
                    if (getRandomXO()) {
                        imageView.setImage(X);
                    } else {
                        imageView.setImage(O);
                    }

                }
                imageView.setPreserveRatio(true);
                imageView.setFitHeight(100);
                pane.getChildren().add(imageView);
                gameBoard.add(pane, i, j);
            }
        }
        Scene scene = new Scene(gameBoard, 315, 315);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    boolean getRandomXO() {
        return random.nextBoolean();
    }
}
