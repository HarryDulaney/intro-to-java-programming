package ch_17.exercise17_21;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;

/**
 * *17.21 (Hex editor) Write a GUI application that lets the user enter a file name in the
 * text field and press the Enter key to display its hex representation in a text area.
 * The user can also modify the hex code and save it back to the file, as shown in
 * Figure 17.23b.
 * <p>
 * Example file input: ch_17/exercise17_21/testFile.txt
 */
public class Exercise17_21 extends Application {
    private static String filePath = null;
    SimpleStringProperty editBoxString = new SimpleStringProperty();

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox mainBox = new VBox(5);
        HBox topBox = new HBox(5);

        TextField textField = new TextField();
        Label label = new Label("Enter a file: ");
        topBox.getChildren().add(label);
        topBox.getChildren().add(textField);
        mainBox.getChildren().add(topBox);

        HBox.setHgrow(textField, Priority.ALWAYS);
        HBox.setMargin(textField, new Insets(5, 5, 5, 1));
        HBox.setMargin(label, new Insets(9, 1, 5, 5));

        TextArea editBox = new TextArea();
        editBox.setWrapText(true);
        editBoxString.bindBidirectional(editBox.textProperty());

        mainBox.getChildren().add(editBox);

        HBox buttonBox = new HBox(5);
        Button saveButton = new Button("Save the change");
        saveButton.setOnAction(e -> {
            try {
                write(editBoxString.get(), filePath);
                editBox.clear();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().add(saveButton);
        saveButton.setCenterShape(true);

        mainBox.getChildren().add(buttonBox);
        VBox.setMargin(buttonBox, new Insets(5, 5, 5, 5));

        Scene scene = new Scene(mainBox, 600, 300);
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    filePath = textField.getText().trim();
                    String hexValuesInString = read(filePath);
                    editBoxString.set(hexValuesInString);

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

    }

    private void write(String hexValues, String filePath) throws IOException {
        FileOutputStream output = new FileOutputStream(filePath);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
        for (int i = 0; i < hexValues.length(); i += 2) {
            char value = (char) ((Character.digit(hexValues.charAt(i), 16) << 4) + Character.digit(hexValues.charAt(i + 1), 16));
           writer.write(value);
        }
        writer.close();
    }

    private String read(String filePath) throws IOException {
        FileInputStream input = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String asChars = "";
        int next;
        while ((next = reader.read()) != -1) {
            asChars += String.format("%H", next);
        }
        input.close();
        return asChars;
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
