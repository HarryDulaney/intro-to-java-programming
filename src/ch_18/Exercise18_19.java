package ch_18;

import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * 18.19 (Sierpinski triangle) Revise Listing 18.9 to develop a program that lets the user
 * use the + and – buttons to increase or decrease the current order by 1, as shown
 * in Figure 18.12a. The initial order is 0. If the current order is 0, the Decrease
 * button is ignored.
 */
public class Exercise18_19 extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) {
        SierpinskiTrianglePane trianglePane = new SierpinskiTrianglePane();

        Button minusButton = new Button("-");
        minusButton.setOnAction(event -> trianglePane.decreaseByOne());
        Button plusButton = new Button("+");
        plusButton.setOnAction(event -> trianglePane.increaseByOne());

        // Pane to hold plus and minus buttons
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().setAll(minusButton, plusButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(trianglePane);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 200, 210);
        primaryStage.setTitle("SierpinskiTriangle");
        primaryStage.setScene(scene);
        primaryStage.show();
        trianglePane.paint();

        scene.widthProperty().addListener(ov -> trianglePane.paint());
        scene.heightProperty().addListener(ov -> trianglePane.paint());
    }

    /**
     * Pane for displaying triangles
     */
    static class SierpinskiTrianglePane extends Pane {
        private int order = 0;

        /**
         * Set a new order
         */
        public void setOrder(int order) {
            this.order = order;
            paint();
        }

        SierpinskiTrianglePane() {
        }

        protected void paint() {
            // Select three points in proportion to the pane size
            Point2D p1 = new Point2D(getWidth() / 2, 10);
            Point2D p2 = new Point2D(10, getHeight() - 10);
            Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);
            this.getChildren().clear(); // Clear the pane before redisplay
            displayTriangles(order, p1, p2, p3);
        }

        private void displayTriangles(int order, Point2D p1,
                                      Point2D p2, Point2D p3) {
            if (order == 0) {

                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(),
                        p2.getY(), p3.getX(), p3.getY());
                triangle.setStroke(Color.BLACK);
                triangle.setFill(Color.WHITE);
                this.getChildren().add(triangle);
            } else {

                Point2D p12 = p1.midpoint(p2);
                Point2D p23 = p2.midpoint(p3);
                Point2D p31 = p3.midpoint(p1);
                // Recursively display three triangles
                displayTriangles(order - 1, p1, p12, p31);
                displayTriangles(order - 1, p12, p2, p23);
                displayTriangles(order - 1, p31, p23, p3);
            }
        }

        public void decreaseByOne() {
            if (order > 0) {
                setOrder(order - 1);
            }
        }

        public void increaseByOne() {
            setOrder(order + 1);
        }
    }

}
