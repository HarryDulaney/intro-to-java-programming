package ch_14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

/**
 * 14.11 (Paint a smiley face) Write a program that paints a smiley face, as shown in
 * Figure 14.46a
 */
public class Exercise14_11 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        double faceRadius = 150;
        Pane pane = new Pane();

        /* Outline of face */
        Circle circle = new Circle(160, 160, faceRadius);
        double centerOfFaceX = circle.getCenterX();
        double centerOfFaceY = circle.getCenterY();
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);

        /* Nose */
        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(
                centerOfFaceX, centerOfFaceY + 30,
                centerOfFaceX - 30, centerOfFaceY - 30,
                centerOfFaceX + 30, centerOfFaceY - 30
        );
        triangle.setRotate(180);
        triangle.setFill(Color.WHITE);
        triangle.setStroke(Color.BLACK);
        pane.getChildren().add(triangle);

        /* Left Eye - Outline */
        Ellipse ellipse1 = new Ellipse(circle.getCenterX() - 60,circle.getCenterY()-60,circle.getRadius()/6,
                circle.getRadius()/5);
        ellipse1.setRotate(90);
        ellipse1.setFill(Color.TRANSPARENT);
        ellipse1.setStroke(Color.BLACK);
        pane.getChildren().add(ellipse1);
        /* Left Eye - Pupil */
        Circle circle1 = new Circle(16);
        circle1.setCenterX(ellipse1.getCenterX());
        circle1.setCenterY(ellipse1.getCenterY());
        pane.getChildren().add(circle1);

        /* Right Eye - Outline */
        Ellipse ellipse2 = new Ellipse(circle.getCenterX() + 60,circle.getCenterY()-60,circle.getRadius()/6,
                circle.getRadius()/5);
        ellipse2.setRotate(90);
        ellipse2.setFill(Color.TRANSPARENT);
        ellipse2.setStroke(Color.BLACK);
        pane.getChildren().add(ellipse2);
        /* Right Eye - Pupil */
        Circle circle2 = new Circle(16);
        circle2.setCenterX(ellipse2.getCenterX());
        circle2.setCenterY(ellipse2.getCenterY());
        pane.getChildren().add(circle2);

        /* Smile */
        Arc arc = new Arc(circle.getCenterX(), 200, circle.getRadius()-60,
                circle.getRadius()-100, 0, -180);
        arc.setType(ArcType.OPEN);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BLACK);
        pane.getChildren().add(arc);

        Scene scene = new Scene(pane, 320, 320);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

    }
}
