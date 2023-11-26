package ch_15;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * *15.27 (Control a moving text) Write a program that displays a moving text, as shown
 * in Figure 15.33a and b. The text moves from left to right circularly. When it
 * disappears in the right, it reappears from the left. The text freezes when the
 * mouse is pressed and moves again when the button is released.
 */
public class Exercise15_27 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Text text = new Text("Programing is fun");
        pane.getChildren().add(text);
        PathTransition pt = new PathTransition(Duration.millis(10000),
                new Line(-50, 50, 250, 50), text);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();
        pane.setOnMousePressed(e -> pt.pause());
        pane.setOnMouseReleased(e -> pt.play());
        Scene scene = new Scene(pane, 200, 100);
        primaryStage.setTitle("Exercise_15_27");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}