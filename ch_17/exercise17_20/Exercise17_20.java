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

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * **17.20 (Binary editor) Write a GUI application that lets the user enter a file name in the
 * text field and press the Enter key to display its binary representation in a text area.
 * The user can also modify the binary code and save it back to the file, as shown in
 * Figure 17.23a.
 * <p>
 * <p>
 * Example file input field: ch_17/exercise17_20/testFile.txt
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
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        StringBuilder result = new StringBuilder();
        for (String byteString : splitBytes) {
            int posValue = 128;
            char valueAsByte = 0;
            for (char c : byteString.toCharArray()) {
                if (c == '1') {
                    valueAsByte += posValue;
                }
                posValue /= 2;
            }
            result.append(valueAsByte);
        }
        outputStreamWriter.write(result.toString());
        outputStreamWriter.close();

    }

    private String readBytesFromFile() throws IOException {
        StringBuilder result = new StringBuilder();
        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        for (byte b : bytes) {
            String strByte = getBits(b);
            result.append(strByte);
        }

        return result.toString();

    }

    public static String getBits(byte value) {
        StringBuilder bits = new StringBuilder();
        long i;
        for (i = 128; i > 0; i /= 2) {
            bits.append((value & i) != 0 ? "1" : "0");
        }
        return bits.toString();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
