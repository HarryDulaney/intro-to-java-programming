package ch_15;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * **15.17 (Geometry: find the bounding rectangle) Write a program that enables the user
 * to add and remove points in a two-dimensional plane dynamically, as shown
 * in Figure 15.29a. A minimum bounding rectangle is updated as the points are
 * added and removed. Assume that the radius of each point is 10 pixels
 */
public class Exercise15_17 extends javafx.application.Application {

    Pane pane = new Pane();
    ArrayList<Circle> points = new ArrayList<>();
    static final int RADIUS = 10;
    static final Color FILL_COLOR = Color.TRANSPARENT;
    static final Color LINE_COLOR = Color.BLACK;

    static final Label instructionsHeader = new Label("INSTRUCTION");
    static final Label addInstruction = new Label("Add: Left Click");
    static final Label removeInstruction = new Label("Remove: Right Click");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        double width = 600;
        double height = 400;
        VBox instructionsBox = new VBox();
        instructionsBox.setPadding(new Insets(5, 5, 5, 5));
        instructionsBox.setStyle("-fx-border-color: black");


        instructionsBox.getChildren().addAll(instructionsHeader, addInstruction, removeInstruction);
        Pane infoPane = new Pane(instructionsBox);
        infoPane.setPadding(new Insets(10, 10, 10, 10));

        pane.getChildren().addAll(infoPane);
        instructionsBox.setLayoutX(10);
        instructionsBox.setLayoutY(10);

        pane.setOnMouseClicked(e -> {
            double x = e.getX();
            double y = e.getY();
            if (infoPane.contains(x, y)) return;

            if (e.getButton() == MouseButton.PRIMARY) {
                Circle c = drawPoint(x, y);
                points.add(c);
                pane.getChildren().add(c);
                drawMinBoundingRec();

            } else if (e.getButton() == MouseButton.SECONDARY) {
                removePoint(x, y);
                drawMinBoundingRec();

            }

        });

        Scene scene = new Scene(pane, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("click to draw circle");
        primaryStage.show();
    }

    private Circle drawPoint(double x, double y) {
        Circle c = new Circle(x, y, RADIUS, FILL_COLOR);
        c.setStroke(LINE_COLOR);
        return c;
    }

    private void drawMinBoundingRec() {
        clearCurrentRectangle();

        if (points.isEmpty()) return;

        Circle top = points.get(0);
        Circle bottom = points.get(0);
        Circle right = points.get(0);
        Circle left = points.get(0);

        for (Circle c : points) {
            if (c.getCenterX() < left.getCenterX()) left = c;
            if (c.getCenterX() > right.getCenterX()) right = c;
            if (c.getCenterY() > bottom.getCenterY()) bottom = c;
            if (c.getCenterY() < top.getCenterY()) top = c;
        }
        double width = right.getCenterX() - left.getCenterX() + top.getRadius() * 2;
        double height = bottom.getCenterY() - top.getCenterY() + top.getRadius() * 2;
        double centerX = (right.getCenterX() + left.getCenterX()) / 2;
        double centerY = (top.getCenterY() + bottom.getCenterY()) / 2;

        Rectangle rec = calculateRectangle(centerX, centerY, width, height);
        pane.getChildren().add(rec);

    }

    Rectangle calculateRectangle(double centerX, double centerY, double width, double height) {
        Rectangle rec = new Rectangle(centerX - width / 2, centerY - height / 2, width, height);
        rec.setStroke(LINE_COLOR);
        rec.setFill(FILL_COLOR);
        return rec;
    }


    private void removePoint(double x, double y) {
        ObservableList<Node> list = pane.getChildren();
        for (int i = list.size() - 1; i >= 0; i--) {
            Node c = list.get(i);

            if (c instanceof Circle && c.contains(x, y)) {
                pane.getChildren().remove(c);
                points.remove(c);

                break;
            }
        }
    }

    private void clearCurrentRectangle() {
        ObservableList<Node> list = pane.getChildren();

        for (Node c : list) {
            if (c instanceof Rectangle) {
                pane.getChildren().remove(c);

                break;
            }
        }

    }
}
