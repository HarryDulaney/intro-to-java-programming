package ch_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * 14.10 (Display a cylinder) Write a program that draws a cylinder, as shown in
 * Figure 14.45b. You can use the following method to set the dashed stroke for an arc:
 * arc.getStrokeDashArray().addAll(6.0, 21.0);
 */
public class Exercise14_10 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Ellipse ellipse = new Ellipse(150, 60, 70, 25);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);
        pane.getChildren().add(ellipse);

        Arc arc1 = new Arc(ellipse.getCenterX(), 200, ellipse.getRadiusX(),
                ellipse.getRadiusY(), 0, -180);
        arc1.setType(ArcType.OPEN);
        arc1.setFill(Color.WHITE);
        arc1.setStroke(Color.BLACK);
        pane.getChildren().add(arc1);

        Arc arc2 = new Arc(ellipse.getCenterX(), arc1.getCenterY(),
                ellipse.getRadiusX(), ellipse.getRadiusY(), 0, 180);
        arc2.setType(ArcType.OPEN);
        arc2.setFill(Color.WHITE);
        arc2.setStroke(Color.BLACK);
        arc2.getStrokeDashArray().addAll(6.0, 21.0);
        pane.getChildren().add(arc2);


        Line line1 = new Line(ellipse.getCenterX() - ellipse.getRadiusX(),
                ellipse.getCenterY(), ellipse.getCenterX() - ellipse.getRadiusX(),
                arc1.getCenterY());
        pane.getChildren().add(line1);

        Line line2 = new Line((ellipse.getCenterX() - ellipse.getRadiusX()) +
                ellipse.getRadiusX() * 2, ellipse.getCenterY(),
                (ellipse.getCenterX() - ellipse.getRadiusX())
                        + ellipse.getRadiusX() * 2, arc1.getCenterY());

        pane.getChildren().add(line2);

        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
