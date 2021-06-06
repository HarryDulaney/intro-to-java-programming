package ch_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * 14.14 (Display a rectanguloid) Write a program that displays a rectanguloid, as shown
 * in Figure 14.47a. The cube should grow and shrink as the window grows or
 * shrinks.
 */
public class Exercise14_14 extends Application {
    double sceneWidth = 325;
    double sceneHeight = 325;

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        /* Create the bottomLeftAlg 2D-rectangle part of the cube */
        Rectangle bottomLeftAlignedRectangle = new Rectangle(0, 0);
        bottomLeftAlignedRectangle.setFill(Color.TRANSPARENT);
        bottomLeftAlignedRectangle.setStroke(Color.BLACK);
        /* Bind the rectangle to x and y properties of it's container pane,and offset to achieve 3D effect  */
        bottomLeftAlignedRectangle.xProperty().bind(pane.widthProperty().divide(4).subtract(25));
        bottomLeftAlignedRectangle.yProperty().bind(pane.heightProperty().divide(4).add(25));
        bottomLeftAlignedRectangle.widthProperty().bind(pane.widthProperty().divide(2));
        bottomLeftAlignedRectangle.heightProperty().bind(pane.heightProperty().divide(2));

        /* Create the topRightAlignedRectangle */
        Rectangle topRightAlignedRectangle = new Rectangle(0, 0);
        topRightAlignedRectangle.setFill(Color.TRANSPARENT);
        topRightAlignedRectangle.setStroke(Color.BLACK);

        /* Bind to width and height of its container and offset */
        topRightAlignedRectangle.xProperty().bind(pane.widthProperty().divide(4).add(25));
        topRightAlignedRectangle.yProperty().bind(pane.heightProperty().divide(4).subtract(25));
        topRightAlignedRectangle.widthProperty().bind(pane.widthProperty().divide(2));
        topRightAlignedRectangle.heightProperty().bind(pane.heightProperty().divide(2));

        /* Create the lines to connect the font and back rectangles to form the cube/  "rectanguloid"*/
        /* Bind the points in the rectangles to the start and end properties of the connecting lines */
        Line l1 = new Line();
        l1.startXProperty().bind(bottomLeftAlignedRectangle.xProperty());
        l1.startYProperty().bind(bottomLeftAlignedRectangle.yProperty());
        l1.endXProperty().bind(topRightAlignedRectangle.xProperty());
        l1.endYProperty().bind(topRightAlignedRectangle.yProperty());

        Line l2 = new Line();
        l2.startXProperty().bind(bottomLeftAlignedRectangle.xProperty());
        l2.startYProperty().bind(bottomLeftAlignedRectangle.yProperty().add(bottomLeftAlignedRectangle.heightProperty()));
        l2.endXProperty().bind(topRightAlignedRectangle.xProperty());
        l2.endYProperty().bind(topRightAlignedRectangle.yProperty().add(bottomLeftAlignedRectangle.heightProperty()));

        Line l3 = new Line();
        l3.startXProperty().bind(bottomLeftAlignedRectangle.xProperty().add(bottomLeftAlignedRectangle.widthProperty()));
        l3.startYProperty().bind(bottomLeftAlignedRectangle.yProperty().add(bottomLeftAlignedRectangle.heightProperty()));
        l3.endXProperty().bind(topRightAlignedRectangle.xProperty().add(bottomLeftAlignedRectangle.widthProperty()));
        l3.endYProperty().bind(topRightAlignedRectangle.yProperty().add(bottomLeftAlignedRectangle.heightProperty()));

        Line l4 = new Line();
        l4.startXProperty().bind(bottomLeftAlignedRectangle.xProperty().add(bottomLeftAlignedRectangle.widthProperty()));
        l4.startYProperty().bind(bottomLeftAlignedRectangle.yProperty());
        l4.endXProperty().bind(topRightAlignedRectangle.xProperty().add(bottomLeftAlignedRectangle.widthProperty()));
        l4.endYProperty().bind(topRightAlignedRectangle.yProperty());

        pane.getChildren().addAll(bottomLeftAlignedRectangle, topRightAlignedRectangle, l1, l2, l3, l4);
        Scene scene = new Scene(pane, sceneWidth, sceneHeight);
        scene.xProperty().add(scene.yProperty());
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}