package ch_18;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 * 18.36 (Sierpinski triangle) Write a program that lets the user to enter the order and
 * display the filled Sierpinski triangles as shown in Figure 18.18.
 */
public class Exercise18_36 extends Application {

    private static final double HEIGHT = 220;
    private static final double WIDTH = 200;

    @Override
    public void start(Stage primaryStage) {
        SierpinskiTrianglePane trianglePane = new SierpinskiTrianglePane();
        TextField textField = new TextField();
        textField.setAlignment(Pos.BOTTOM_RIGHT);
        textField.setPrefColumnCount(4);
        textField.setOnAction(
                e -> trianglePane.setOrder(Integer.parseInt(textField.getText())));

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("(Enter) an order: "), textField);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(trianglePane);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, WIDTH, HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    /**
     * The type Sierpinski triangle pane.
     */
    public static class SierpinskiTrianglePane extends Pane {
        private int order = 0;

        public void setOrder(int order) {
            this.order = order;
            draw();
        }

        SierpinskiTrianglePane() {
        }

        protected void draw() {
            Point2D p1 = new Point2D(getWidth() / 2, 10);
            Point2D p2 = new Point2D(10, getHeight() - 10);
            Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);

            this.getChildren().clear();

            showTriangles(order, p1, p2, p3);
        }

        private void showTriangles(int order, Point2D p1,
                                   Point2D p2, Point2D p3) {
            if (order == 0) {
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(),
                        p2.getY(), p3.getX(), p3.getY());

                this.getChildren().add(triangle);
            } else {
                Point2D p12 = p1.midpoint(p2);
                Point2D p23 = p2.midpoint(p3);
                Point2D p31 = p3.midpoint(p1);

                /* Recursively call showTriangles to draw the inner triangles */
                showTriangles(order - 1, p1, p12, p31);
                showTriangles(order - 1, p12, p2, p23);
                showTriangles(order - 1, p31, p23, p3);
            }
        }
    }

}
