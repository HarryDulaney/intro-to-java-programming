package ch_15;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.xml.soap.Text;

/**
 * *15.4 (Create a simple calculator) Write a program to perform addition, subtraction,
 * multiplication, and division, as shown in Figure 15.25a.
 * <p>
 * FIGURE 15.25 (a) Exercise 15.4 performs addition, subtraction, multiplication, and division
 * on double numbers. (b) The user enters the investment amount, years, and interest rate to
 * compute future value.
 */
public class Exercise15_04 extends Application {

    @Override
    public void start(Stage primaryStage) {
        FlowPane pane = new FlowPane();
        pane.setHgap(5);
        pane.setAlignment(Pos.CENTER);
        TextField textFieldOne = new TextField();
        TextField textFieldTwo = new TextField();
        TextField textFieldResult = new TextField();
        textFieldResult.setEditable(false);
        textFieldOne.setPrefColumnCount(5);
        textFieldTwo.setPrefColumnCount(5);
        textFieldResult.setPrefColumnCount(10);

        pane.getChildren().addAll(new Label("Number 1: "), textFieldOne,
                new Label("Number 2: "), textFieldTwo, new Label("Result: "), textFieldResult);

        HBox hBox = new HBox(5);
        Button addButton = new Button("Add");
        Button subtractButton = new Button("Subtract");
        Button multiplyButton = new Button("Multiply");
        Button divideButton = new Button("Divide");

        addButton.setOnAction(e -> {
            if (checkFields(textFieldOne, textFieldTwo)) {
                textFieldResult.setText(Double.parseDouble(textFieldOne.getText()) +
                        Double.parseDouble(textFieldTwo.getText()) + "");
            }
        });

        subtractButton.setOnAction(e -> {
            if (checkFields(textFieldOne, textFieldTwo)) {
                textFieldResult.setText(Double.parseDouble(textFieldOne.getText()) -
                        Double.parseDouble(textFieldTwo.getText()) + "");
            }
        });

        multiplyButton.setOnAction(e -> {
            if (checkFields(textFieldOne, textFieldTwo)) {
                textFieldResult.setText(Double.parseDouble(textFieldOne.getText()) *
                        Double.parseDouble(textFieldTwo.getText()) + "");
            }
        });

        divideButton.setOnAction(e -> {
            if (checkFields(textFieldOne, textFieldTwo)) {
                textFieldResult.setText(Double.parseDouble(textFieldOne.getText()) /
                        Double.parseDouble(textFieldTwo.getText()) + "");
            }
        });

        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(addButton, subtractButton, multiplyButton, divideButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.TOP_CENTER);

        Scene scene = new Scene(borderPane, 600, 150);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private boolean checkFields(TextField t1, TextField t2) {
        return !t1.getText().isEmpty() && !t1.getText().isEmpty();
    }
}
