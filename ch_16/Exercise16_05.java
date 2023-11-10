package ch_16;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * 16.5 (Convert numbers) Write a program that converts between decimal, hex, and binary
 * numbers, as shown in Figure 16.37c.
 * When you enter a decimal value in the decimal value
 * text field and press the Enter key, its corresponding hex and binary numbers are
 * displayed in the other two text fields. Likewise, you can enter values in the other fields
 * and convert them accordingly.
 * <p>
 * (Hint: Use the Integer.parseInt(s, radix)
 * method to parse a string to a decimal and use Integer.toHexString(decimal)
 * and Integer.toBinaryString(decimal) to obtain a hex number or a binary
 * number from a decimal.)
 */
public class Exercise16_05 extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextField decimalTextField = new TextField();
        decimalTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            /* If decimal input field contains non-numeric characters */
            if (!newValue.matches("\\d*")) {
                /* Remove any non-numeric characters */
                decimalTextField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

        TextField hexTextField = new TextField();
        TextField binaryTextField = new TextField();
        decimalTextField.setAlignment(Pos.BOTTOM_RIGHT);
        hexTextField.setAlignment(Pos.BOTTOM_RIGHT);
        binaryTextField.setAlignment(Pos.BOTTOM_RIGHT);
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(2);
        pane.add(new Label("Decimal"), 0, 0);
        pane.add(decimalTextField, 1, 0);
        pane.add(new Label("Hex"), 0, 1);
        pane.add(hexTextField, 1, 1);
        pane.add(new Label("Binary"), 0, 2);
        pane.add(binaryTextField, 1, 2);

        decimalTextField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                hexTextField.setText(Integer.toHexString(
                        Integer.parseInt(decimalTextField.getText())));

                binaryTextField.setText(Integer.toBinaryString(
                        Integer.parseInt(decimalTextField.getText())));
            }
        });

        hexTextField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                decimalTextField.setText(String.valueOf(
                        Integer.parseInt(hexTextField.getText(), 16)));

                binaryTextField.setText(Integer.toBinaryString(
                        Integer.parseInt(hexTextField.getText(), 16)));
            }
        });

        binaryTextField.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                decimalTextField.setText(String.valueOf(
                        Integer.parseInt(binaryTextField.getText(), 2)));

                hexTextField.setText(Integer.toHexString(
                        Integer.parseInt(binaryTextField.getText(), 2)));
            }
        });

        Scene scene = new Scene(pane, 280, 160);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}