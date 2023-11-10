package ch_15;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * *15.26 (Change opacity) Rewrite Programming Exercise 15.24 so that the ball’s
 * opacity is changed as it swings.
 */
public class Exercise15_26 extends Application {
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
        pt.play(); // Play path transition animation

        FadeTransition ft = new FadeTransition(Duration.millis(3000), circle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play(); // Play fade transition animation

        pane.setOnMousePressed(e -> pt.pause());
        pane.setOnMouseReleased(e -> pt.play());

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle("Exercise15_26");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
