package ch_20;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.event.TextListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * *20.2 (Store numbers in a linked list) Write a program that lets the user enter
 * numbers from a graphical user interface and displays them in a text area, as shown in
 * Figure 20.17a. Use a linked list to store the numbers. Do not store duplicate numbers.
 * Add the buttons Sort, Shuffle, and Reverse to sort, shuffle, and reverse the list.
 */
public class Exercise20_02 extends Application {
    LinkedList<Integer> NUMBERS = new LinkedList<>();
    TextArea textArea;

    @Override
    public void start(Stage primaryStage) {
        VBox vBox = new VBox(5);

        textArea = new TextArea();
        textArea.setPrefSize(400, 200);
        textArea.setMaxWidth(400);
        textArea.setMinWidth(400);
        textArea.setPadding(new Insets(5, 5, 5, 5));

        HBox inBox = new HBox();
        Label label = new Label("Enter a number: ");
        TextField textFieldNumberIn = new TextField();
        textFieldNumberIn.setPrefWidth(100);
        textFieldNumberIn.setMaxWidth(100);
        textFieldNumberIn.setMinWidth(100);
        textFieldNumberIn.setPadding(new Insets(5, 5, 5, 5));

        textFieldNumberIn.textProperty().addListener((observable, oldValue, newValue) -> {
            if (oldValue.contains(newValue)) {
                return;
            }
            if (NUMBERS.contains(Integer.valueOf(newValue))) {
                return;
            }
            if (!newValue.equals("")) {
                NUMBERS.add(Integer.parseInt(newValue));
                refreshUI(NUMBERS);
            }
        });

        inBox.getChildren().add(label);
        textFieldNumberIn.setPrefWidth(15);
        inBox.getChildren().add(textFieldNumberIn);


        vBox.getChildren().addAll(inBox, textFieldNumberIn);
        vBox.getChildren().add(textArea);
        Button sortButton = new Button("Sort");
        sortButton.setOnAction(event -> sortNumbers(NUMBERS));

        Button shuffleButton = new Button("Shuffle");
        shuffleButton.setOnAction(e -> shuffleNumbers(NUMBERS));

        Button reverseButton = new Button("Reverse");
        reverseButton.setOnAction(e -> reverseNumbers(NUMBERS));

        HBox buttonBox = new HBox();
        buttonBox.getChildren().addAll(sortButton, shuffleButton, reverseButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(8);
        vBox.getChildren().add(buttonBox);

        Scene scene = new Scene(vBox, 420, 250);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void refreshUI(LinkedList<Integer> numbers) {
        textArea.setText(Arrays.toString(numbers.toArray()));
    }

    private void reverseNumbers(LinkedList<Integer> numbers) {
        Collections.reverse(numbers);
        textArea.setText(Arrays.toString(numbers.toArray()));
        //        NUMBERS = numbers;
    }

    private void shuffleNumbers(LinkedList<Integer> numbers) {
        Collections.shuffle(numbers);
        //        NUMBERS = numbers;
        textArea.setText(Arrays.toString(numbers.toArray()));
    }

    private void sortNumbers(LinkedList<Integer> numbers) {
        Collections.sort(numbers);
//        NUMBERS = numbers;
        textArea.setText(Arrays.toString(numbers.toArray()));

    }
}
