package ch_16;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * 16.2 (Select geometric figures) Write a program that draws various figures, as shown
 * in Figure 16.36b. The user selects a figure from a radio button and uses a check
 * box to specify whether it is filled.
 */
public class Exercise16_02 extends Application {
    Rectangle rectangle = new Rectangle(100, 100);
    Circle circle = new Circle(50);
    Ellipse ellipse = new Ellipse(100, 50);

    @Override
    public void start(Stage primaryStage) {
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.TRANSPARENT);

        circle.setStroke(Color.BLACK);
        circle.setFill(Color.TRANSPARENT);

        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.TRANSPARENT);

        VBox vBox = new VBox();
        rectangle.setVisible(false);
        circle.setVisible(false);
        ellipse.setVisible(false);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(rectangle, circle, ellipse);
        vBox.getChildren().add(stackPane);
        stackPane.setPadding(new Insets(10, 10, 10, 10));

        RadioButton circleButton = new RadioButton();
        circleButton.setText("Circle");

        RadioButton rectangleButton = new RadioButton();
        rectangleButton.setText("Rectangle");

        RadioButton ellipseButton = new RadioButton();
        ellipseButton.setText("Ellipse");

        CheckBox fillBox = new CheckBox();
        fillBox.setText("Fill");


        circleButton.setOnAction(e -> {
            rectangle.setVisible(false);
            ellipse.setVisible(false);
            circle.setVisible(true);
        });
        rectangleButton.setOnAction(e -> {
            circle.setVisible(false);
            ellipse.setVisible(false);
            rectangle.setVisible(true);
        });
        ellipseButton.setOnAction(e -> {
            rectangle.setVisible(false);
            circle.setVisible(false);
            ellipse.setVisible(true);

        });
        fillBox.setOnAction(e -> {
            if (rectangle.isVisible()) {
                if (rectangle.getFill().equals(Color.TRANSPARENT)) {
                    rectangle.setFill(Color.BLACK);
                } else {
                    rectangle.setFill(Color.TRANSPARENT);
                }

            } else if (circle.isVisible()) {
                if (circle.getFill().equals(Color.TRANSPARENT)) {
                    circle.setFill(Color.BLACK);
                } else {
                    circle.setFill(Color.TRANSPARENT);

                }
            } else if (ellipse.isVisible()) {
                if (ellipse.getFill().equals(Color.TRANSPARENT)) {
                    ellipse.setFill(Color.BLACK);
                } else {
                    ellipse.setFill(Color.TRANSPARENT);

                }
            }

        });


        ToggleGroup radioButtonGroup = new ToggleGroup();
        circleButton.setToggleGroup(radioButtonGroup);
        rectangleButton.setToggleGroup(radioButtonGroup);
        ellipseButton.setToggleGroup(radioButtonGroup);

        HBox toolBar = new HBox();
        toolBar.getChildren().addAll(circleButton, rectangleButton, ellipseButton, fillBox);
        toolBar.setAlignment(Pos.CENTER);
        toolBar.setSpacing(10.5);
        toolBar.setPadding(new Insets(10, 10, 10, 10));

        vBox.getChildren().add(toolBar);

        Scene scene = new Scene(vBox);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
