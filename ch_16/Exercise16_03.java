package ch_16;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

import java.awt.*;

/**
 * **16.3 (Traffic lights) Write a program that simulates a traffic light.
 * The program lets the user select one of three lights:
 * red, yellow, or green. When a radio button is selected, the
 * light is turned on. Only one light can be on at a time (see
 * Figure 16.37a). No light is on when the program starts.
 */
public class Exercise16_03 extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox mainBox = new VBox(5);
        HBox topBox = new HBox(5);
        topBox.setAlignment(Pos.CENTER);

        Rectangle rectangle = new Rectangle(100, 250);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.TRANSPARENT);

        HBox buttonBox = new HBox(5);
        ToggleGroup radioButtons = new ToggleGroup();
        RadioButton redButton = new RadioButton("Red");

        RadioButton greenButton = new RadioButton("Green");
        RadioButton yellowButton = new RadioButton("Yellow");
        radioButtons.getToggles().addAll(redButton, greenButton, yellowButton);
        buttonBox.getChildren().addAll(redButton, greenButton, yellowButton);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        rectangle.setTranslateY(50);
        rectangle.setTranslateX(30);
        buttonBox.setTranslateY(100);

        Circle redLight = new Circle(rectangle.getWidth() / 2 - 15);
        redLight.setTranslateX(-62);
        redLight.setTranslateY(-20);
        redLight.setFill(Color.TRANSPARENT);
        redLight.setStroke(Color.BLACK);

        Circle greenLight = new Circle(rectangle.getWidth() / 2 - 15);
        greenLight.setTranslateX(-137);
        greenLight.setTranslateY(57);
        greenLight.setFill(Color.TRANSPARENT);
        greenLight.setStroke(Color.BLACK);

        Circle yellowLight = new Circle(rectangle.getWidth() / 2 - 15);
        yellowLight.setTranslateX(-212);
        yellowLight.setTranslateY(135);
        yellowLight.setFill(Color.TRANSPARENT);
        yellowLight.setStroke(Color.BLACK);

        radioButtons.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (redButton.isSelected()) {
                redLight.setFill(Color.RED);
                greenLight.setFill(Color.TRANSPARENT);
                yellowLight.setFill(Color.TRANSPARENT);
            } else if (greenButton.isSelected()) {
                greenLight.setFill(Color.GREEN);
                redLight.setFill(Color.TRANSPARENT);
                yellowLight.setFill(Color.TRANSPARENT);
            } else if (yellowButton.isSelected()) {
                yellowLight.setFill(Color.YELLOW);
                greenLight.setFill(Color.TRANSPARENT);
                redLight.setFill(Color.TRANSPARENT);

            }
        });
        topBox.getChildren().add(rectangle);
        topBox.getChildren().add(redLight);
        topBox.getChildren().add(greenLight);
        topBox.getChildren().add(yellowLight);

        mainBox.getChildren().add(topBox);
        mainBox.getChildren().add(buttonBox);

        redButton.setSelected(true);

        Scene scene = new Scene(mainBox, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

    }

}
