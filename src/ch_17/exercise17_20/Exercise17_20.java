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

import java.io.IOException;
import java.io.PrintWriter;
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
        String temp = "";
        for (char ch : text.toCharArray()) {
            if (counter < 8) {
                temp += ch;
                counter++;
            } else {
                splitBytes.add(temp);
                counter = 0;
                temp = "";
            }
        }
PrintWriter printWriter = new PrintWriter(filePath, StandardCharsets.UTF_8.name());
        char ch = 0;
        for (String bits : splitBytes) {
            ch = getCharFromByte(bits);
            printWriter.write(ch);
        }
        printWriter.flush();
        printWriter.close();

    }

    private String readBytesFromFile() throws IOException {
        StringBuilder result = new StringBuilder();
        Scanner in = new Scanner(Paths.get(filePath), StandardCharsets.UTF_8.name());
        while (in.hasNextLine()) {
            String line = in.nextLine();
            for (char ch : line.toCharArray()) {
                result.append(getBits(ch));
            }
        }
        in.close();

        return result.toString();
    }

    public static String getBits(int value) {
        String bits = "";
        for (int i = 0; i < 8; i++) {
            bits += (value & 1);
            value >>= 1;
        }
        return bits;
    }

    public static char getCharFromByte(String value) {
        int numVal = Integer.parseInt(value, 2);
        return (char) numVal;
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
