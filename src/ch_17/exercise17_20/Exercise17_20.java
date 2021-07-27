package ch_17.exercise17_20;

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
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * **17.20 (Binary editor) Write a GUI application that lets the user enter a file name in the
 * text field and press the Enter key to display its binary representation in a text area.
 * The user can also modify the binary code and save it back to the file, as shown in
 * Figure 17.23a.
 * <p>
 * <p>
 * Example file input field: src/ch_17/exercise17_20/testFile.txt
 */
public class Exercise17_20 extends Application {
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
                saveBytesToFile(editBoxString.get());
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
                    if (filePath == null) {
                        filePath = textField.getText();
                    }
                    String bytes = readBytesFromFile();
                    editBoxString.set(bytes);

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

    }

    private void saveBytesToFile(String text) throws IOException {
        int counter = 0;
        ArrayList<String> splitBytes = new ArrayList<>();
        StringBuilder strByte = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (counter < 8) {
                strByte.append(ch);
                counter++;
            } else {
                splitBytes.add(strByte.toString());
                counter = 0;
                strByte = new StringBuilder();
            }
        }
        FileOutputStream fOs = new FileOutputStream(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fOs);
        char ch = 0;
        for (String bits : splitBytes) {
            ch = (char) getCharFromByte(bits);
            stringBuilder.append(ch);
        }

        outputStreamWriter.write(stringBuilder.toString());
        outputStreamWriter.close();

    }

    private String readBytesFromFile() throws IOException {
        StringBuilder result = new StringBuilder();
        FileInputStream fIs = new FileInputStream(filePath);
        InputStreamReader iSr = new InputStreamReader(fIs);
        Reader in = new BufferedReader(iSr);
        int ch;
        while ((ch = in.read()) != -1) {
            String valueAsByte = getBits(ch);
            result.append(valueAsByte);
        }
        in.close();

        return result.toString();

    }

    public static String getBits(int value) {
        StringBuilder bits = new StringBuilder();
        long i;
        for (i = 128; i > 0; i /= 2) {
            bits.append((value & i) != 0 ? "1" : "0");
        }
        return bits.toString();
    }

    public static int getCharFromByte(String value) {
        int numVal = Integer.parseInt(value, 2);
        return numVal;
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
