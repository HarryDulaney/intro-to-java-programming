package ch_15;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * **15.24 (Animation: palindrome) Write a program that animates a palindrome swing as
 * shown in Figure 15.31. Press/release the mouse to pause/resume the animation.
 * <p>
 * FIGURE 15.31 The program animates a palindrome swing.
 */
public class Exercise15_24 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Circle circle = new Circle(0, 0, 10);
        circle.setFill(Color.ORANGE);

        Arc arc = new Arc(125, 100, 80, 40, 210, 125);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);
        pane.getChildren().add(arc);
        pane.getChildren().add(circle);
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(arc);
        pt.setNode(circle);
        pt.setOrientation(
                PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        pane.setOnMousePressed(e -> pt.pause());
        pane.setOnMouseReleased(e -> pt.play());

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

