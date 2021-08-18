package ch_18;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * **18.27 (Koch snowflake fractal) The text presented the Sierpinski triangle fractal.
 * In this exercise, you will write a program to display another fractal, called the Koch
 * snowflake, named after a famous Swedish mathematician. A Koch snowflake is
 * created as follows:
 * 1. Begin with an equilateral triangle, which is considered to be the Koch fractal
 * of order (or level) 0, as shown in Figure 18.14a.
 * 2. Divide each line in the shape into three equal line segments and draw an outward equilateral
 * triangle with the middle line segment as the base to create a
 * Koch fractal of order 1, as shown in Figure 18.14b.
 * 3. Repeat Step 2 to create a Koch fractal of order 2, 3, . . . , and so on, as shown
 * in Figure 18.14c–d.
 * <p>
 * FIGURE 18.14 A Koch snowflake is a fractal starting with a triangle.
 */
public class Exercise18_27 extends Application {

    private final double WIDTH = 350;
    private final double HEIGHT = 350;
    private final Label mainLabel = new Label("Enter an Order");
    private int orderOfFractal = 0;

    Pane drawPane = new Pane();
    ObservableList<Node> FRACTAL = drawPane.getChildren();

    @Override
    public void start(Stage primaryStage) {
        VBox mainBox = new VBox(5);
        mainBox.setAlignment(Pos.CENTER);
        VBox.setMargin(drawPane,new Insets(15,0,0,0));
        mainBox.getChildren().add(drawPane);

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);

        TextField inputField = new TextField();
        inputField.setPrefWidth(100);

        hBox.getChildren().addAll(mainLabel, inputField);
        HBox.setMargin(mainLabel, new Insets(5, 5, 10, 10));
        HBox.setMargin(inputField, new Insets(5, 5, 10, 3));
        drawPane.setCenterShape(true);
        drawPane.setPrefHeight(HEIGHT - hBox.getHeight());
        mainBox.getChildren().add(hBox);

        inputField.textProperty().addListener((observable, oldValue, newValue) -> {
            FRACTAL.clear();
            if (!newValue.isEmpty()) {
                orderOfFractal = Integer.parseInt(newValue);
                drawBaseShape(orderOfFractal);
            }
        });

        Scene scene = new Scene(mainBox, WIDTH, HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /* Draw the starter Triangle when: order >= 0 */
    private void drawBaseShape(int order) {
        double length = HEIGHT - 100;
        Line l1 = new Line(WIDTH / 2, 0, (WIDTH / 2) + length * Math.cos(1 * (Math.PI * 2 / 6)),
                0 + length * Math.sin(1 * (Math.PI * 2 / 6)));
        Line l2 = new Line(l1.getEndX(), l1.getEndY(), l1.getEndX() - length, l1.getEndY());
        Line l3 = new Line(l2.getEndX(), l2.getEndY(), l1.getStartX(), l1.getStartY());
        FRACTAL.addAll(l1, l2, l3);
        if (order > 0) {
            draw(order);
        }
    }

    private void draw(int order) {
        if (order == 0) // Check Base Case (end recursion)
            return;

        ArrayList<Line> lines = new ArrayList<>();
        for (Node node : FRACTAL) {
            if (node instanceof Line) {
                lines.add((Line) node);
            }
        }

        for (Line line : lines) {
            triangle(line);
        }
        draw(order - 1); // Recurse
    }

    private void triangle(Line line) {
        double DIST = getLength(line) / 3;
        double dy = (line.getStartY() - line.getEndY());
        double dx = (line.getEndX() - line.getStartX());
        double th = Math.atan2(dy, dx);

        double x1 = line.getStartX() + DIST * Math.cos(th);
        double y1 = line.getStartY() - DIST * Math.sin(th);

        double x2 = line.getEndX() + DIST * Math.cos(th + Math.toRadians(180));
        double y2 = line.getEndY() - DIST * Math.sin(th + Math.toRadians(180));

        double x3 = x2 + DIST * Math.cos(th + Math.toRadians(120));
        double y3 = y2 - DIST * Math.sin(th + Math.toRadians(120));

        Line l1 = new Line(line.getStartX(), line.getStartY(), x1, y1);
        Line l2 = new Line(x2, y2, line.getEndX(), line.getEndY());
        Line l3 = new Line(l1.getEndX(), l1.getEndY(), x3, y3);
        Line l4 = new Line(l3.getEndX(), l3.getEndY(), x2, y2);

        drawPane.getChildren().remove(line);
        FRACTAL.addAll(l1, l2, l3, l4);

    }

    private double getLength(Line line) {
        // Use formula for 2D distance to get length of line
        return Math.sqrt(Math.pow(line.getEndX() - line.getStartX(), 2) + Math.pow(line.getEndY() - line.getStartY(),
                2));
    }
}




