package ch_17.exercise17_13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;

/**
 * *17.13 (Combine files GUI) Rewrite Exercise 17.12 with a GUI, as shown in
 * Figure 17.21b.
 */
public class Exercise17_13 extends Application {
    private static final String PARENT_PATH = "ch_17/exercise17_13";

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox mainBox = new VBox();
        HBox topHBox = new HBox();
        Text text = new Text("If the base file is named temp.txt with 3 pieces,\n temp.txt.1, temp.txt.2, and temp" +
                ".txt.3 are combined into temp.txt");
        topHBox.getChildren().add(text);

        HBox.setHgrow(text, Priority.ALWAYS);
        HBox.setMargin(text, new Insets(5, 5, 5, 5));

        HBox middleHBox = new HBox(5);
        TextField fileField = new TextField();
        Text filePrompt = new Text("Enter a file: ");
        filePrompt.setTextAlignment(TextAlignment.LEFT);
        HBox.setMargin(fileField, new Insets(0, 10, 0, 258));
        fileField.setMinWidth(200);
        middleHBox.getChildren().add(filePrompt);
        middleHBox.getChildren().add(fileField);

        HBox lowMiddleHBox = new HBox(5);
        Text numPiecesPrompt = new Text("Specify the number of smaller files: ");
        numPiecesPrompt.setTextAlignment(TextAlignment.LEFT);
        lowMiddleHBox.getChildren().add(numPiecesPrompt);
        TextField numPiecesField = new TextField();
        numPiecesField.setPromptText("Example: 3");
        numPiecesField.setMinWidth(200);
        lowMiddleHBox.getChildren().add(numPiecesField);
        HBox.setHgrow(numPiecesPrompt, Priority.ALWAYS);
        HBox.setMargin(numPiecesField, new Insets(0, 10, 0, 100));

        HBox buttonBox = new HBox();
        Button startButton = new Button("Start");
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().add(startButton);

        startButton.setOnAction(e -> {
            String fileInput = fileField.getText();
            if (fileInput.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter a value for file name before pressing start button.");
                alert.show();

            } else if (numPiecesField.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please enter a value for number of files to output...");
                alert.show();
            } else {
                int numOutFiles = Integer.parseInt(numPiecesField.getText());
                File targetFile = new File("src/ch_17/exercise17_13", fileInput);

                File[] sourceFiles = new File[numOutFiles];
                for (int i = 0; i < sourceFiles.length; i++) {
                    String nextFileName = fileInput + "." + (i + 1);
                    sourceFiles[i] = new File(PARENT_PATH, nextFileName);
                }
                try {
                    combineFiles(sourceFiles, targetFile);
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setContentText("Success!");
                    alert.show();

                } catch (Exception ex) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText(ex.getMessage());
                    alert.show();

                    ex.printStackTrace();
                }

            }
        });
        mainBox.getChildren().addAll(topHBox, middleHBox, lowMiddleHBox, buttonBox);
        VBox.setVgrow(topHBox, Priority.ALWAYS);
        VBox.setVgrow(middleHBox, Priority.ALWAYS);
        VBox.setVgrow(lowMiddleHBox, Priority.ALWAYS);
        VBox.setVgrow(buttonBox, Priority.ALWAYS);

        Scene scene = new Scene(mainBox, 550, 150);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    private static void combineFiles(File[] srcFiles, File targetFile) throws Exception {
        System.out.println("Combining src files into target file: " + targetFile.getName());
        byte[][] bytes = new byte[srcFiles.length][];
        int arraysIdx = 0;
        for (File f : srcFiles) {
            System.out.println("Processing: " + f.getName());
            bytes[arraysIdx++] = Files.readAllBytes(f.toPath());
        }
        FileOutputStream outputStream = new FileOutputStream(targetFile);
        for (byte[] bytArray : bytes) {
            outputStream.write(bytArray);
        }
        outputStream.flush();
        outputStream.close();
        System.out.println("Completed: Success");
    }
}
