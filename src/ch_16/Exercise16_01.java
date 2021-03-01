package ch_16;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * 16.1 (Use radio buttons) Write a GUI program as shown in Figure 16.36a. You can
 * use buttons to move the message to the left and right and use the radio buttons to
 * change the color for the message displayed.
 */
public class Exercise16_01 extends javafx.application.Application {


    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        Text text = new Text(50, 50, "Programming is fun");

        RadioButton rbRed = new RadioButton();
        rbRed.setText("Red");

        RadioButton rbYellow = new RadioButton();
        rbYellow.setText("Yellow");

        RadioButton rbBlack = new RadioButton();
        rbBlack.setText("Black");

        RadioButton rbOrange = new RadioButton();
        rbOrange.setText("Orange");

        RadioButton rbGreen = new RadioButton();
        rbGreen.setText("Green");


        rbRed.setOnAction(e -> {
            text.setFill(Color.RED);
        });
        rbYellow.setOnAction(e -> {
            text.setFill(Color.YELLOW);
        });
        rbBlack.setOnAction(e -> {
            text.setFill(Color.BLACK);

        });
        rbOrange.setOnAction(e -> {
            text.setFill(Color.ORANGE);

        });
        rbGreen.setOnAction(e -> {
            text.setFill(Color.GREEN);

        });

        ToggleGroup radioButtonGroup = new ToggleGroup();
        rbRed.setToggleGroup(radioButtonGroup);
        rbYellow.setToggleGroup(radioButtonGroup);
        rbBlack.setToggleGroup(radioButtonGroup);
        rbOrange.setToggleGroup(radioButtonGroup);
        rbGreen.setToggleGroup(radioButtonGroup);

        HBox radioButtonBox = new HBox();
        radioButtonBox.getChildren().addAll(rbRed, rbYellow, rbBlack, rbOrange, rbGreen);
        radioButtonBox.setAlignment(Pos.CENTER);
        radioButtonBox.setSpacing(10.5);


        Pane textPane = new Pane();
        textPane.setPadding(new Insets(10,10,10,10));
        textPane.getChildren().add(text);


        Button left = new Button("<=");
        Button right = new Button("=>");
        left.setOnAction(event -> {
            text.setX(text.getX() - 5.0);
        });
        right.setOnAction(event -> {
            text.setX(text.getX() + 5.0);
        });

        HBox bottomBox = new HBox();
        bottomBox.getChildren().add(left);
        bottomBox.getChildren().add(right);
        bottomBox.setAlignment(Pos.CENTER);


        borderPane.setBottom(bottomBox);
        borderPane.setTop(radioButtonBox);
        borderPane.setCenter(textPane);
        borderPane.setPadding(new Insets(10,10,10,10));

        Scene scene = new Scene(borderPane);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
