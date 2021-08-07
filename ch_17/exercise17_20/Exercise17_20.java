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
    private SimpleStringProperty editBoxString = new SimpleStringProperty();

    public static void main(String[] args) {
        Application.launch(args);
    }

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
            filePath = textField.getText().trim();
            try {
                writeFile(editBoxString.get(), new File(filePath));
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

                    String bytes = readFile(new File(filePath));
                    editBoxString.set(bytes);

                } catch (IOException ioException) {
                    System.out.println("FilePath: " + filePath);
                    ioException.printStackTrace();
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

    }

    private void writeFile(String text, File file) throws IOException {
        BitOutputStream bitOutputStream = new BitOutputStream(file);
        bitOutputStream.writeBit(text);

    }

    private String readFile(File file) throws IOException {
        BitInputStream bitOutputStream = new BitInputStream(file);
        return bitOutputStream.readAllBytes();
    }

    public static class BitOutputStream implements Closeable {
        private FileOutputStream output;
        private int value;
        private int count = 0;
        private int mask = 1;

        public BitOutputStream(File file) throws IOException {
            output = new FileOutputStream(file);
        }

        public void writeBit(char bit) throws IOException {
            count++;
            value = value << 1;
            if (bit == '1')
                value = value | mask;
            if (count == 8) {
                output.write(value);
                count = 0;
            }
        }

        public void writeBit(String bitString) throws IOException {
            for (int i = 0; i < bitString.length(); i++)
                writeBit(bitString.charAt(i));
        }

        @Override
        public void close() throws IOException {
            if (count > 0) {
                value = value << (8 - count);
                output.write(value);
            }
            output.close();
        }

        void t() {
        }

    }

    public static class BitInputStream implements Closeable {
        private FileInputStream input;
        private String stringValue;
        private static final int EOF = -1;

        public BitInputStream(File file) throws IOException {
            input = new FileInputStream(file);
        }

        private String readAllBytes() throws IOException {
            stringValue = "";
            int intValue;
            while ((intValue = input.read()) != EOF) {
                stringValue += readBits(intValue);
            }
            input.close();
            return stringValue;

        }

        private String readBits(int value) {
            String bits = "";
            int mask = 1;
            for (int i = 7; i >= 0; i--) {
                int temp = value >> i;
                int bit = temp & mask;
                bits = bits + bit;
            }
            return bits;
        }

        @Override
        public void close() throws IOException {
            input.close();
        }
    }
}
