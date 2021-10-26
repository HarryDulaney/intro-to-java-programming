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
 * *18.35 (H-tree fractal) An H-tree (introduced at the beginning of this chapter in
 * Figure 18.1) is a fractal defined as follows:
 * 1. Begin with a letter H. The three lines of the H are of the same length, as
 * shown in Figure 18.1a.
 * 2. The letter H (in its sans-serif form, H) has four endpoints.
 * Draw an H centered at each of the four endpoints to an H-tree of order 1, as shown in
 * Figure 18.1b. These Hs are half the size of the H that contains the four
 * endpoints.
 * 3. Repeat Step 2 to create an H-tree of order 2, 3, . . . , and so on, as shown in
 * Figure 18.1c–d.
 * Write a program that draws an H-tree, as shown in Figure 18.1.
 */
public class Exercise18_35 extends Application {

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
        VBox.setMargin(drawPane, new Insets(15, 0, 0, 0));
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
                double baseHSize = HEIGHT / 2 - 50;
                double centerX = drawPane.getWidth() / 2 - baseHSize / 2; // X of point where base H is centered in Pane
                double centerY = drawPane.getHeight() / 2 - baseHSize / 2; // Y of point where base H is center in Pane
                drawHTree(orderOfFractal, centerX, centerY, baseHSize);
            }
        });

        Scene scene = new Scene(mainBox, WIDTH, HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void drawH(double x, double y, double size) {
        Line leftVert = new Line(x, y, x, y + size);
        Line rightVert = new Line(x + size, y, x + size, y + size);
        Line horizontal = new Line(x, y + size / 2.0, x + size, y + size / 2.0);
        FRACTAL.addAll(leftVert, rightVert, horizontal);
    }

    private void drawHTree(int order, double x, double y, double size) {
        drawH(x, y, size);
        if (order > 0) {
            drawHTree(order - 1, x - size / 4, y - size / 4, size / 2);
            drawHTree(order - 1, x + size - size / 4, y - size / 4, size / 2);
            drawHTree(order - 1, x - size / 4, y + size - size / 4, size / 2);
            drawHTree(order - 1, x + size - size / 4, y + size - size / 4, size / 2);
        }

    }


}