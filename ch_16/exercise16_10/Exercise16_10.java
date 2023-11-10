package ch_16.exercise16_10;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * **16.10 (Text viewer) Write a program that displays a text file in a text area, as shown
 * in Figure 16.40a. The user enters a file name in a text field and clicks the View
 * button; the file is then displayed in a text area.
 * <p>
 * To Test with the provided test file:
 * enter the following in the filename text field:
 * ...relative-path-to-project\intro-to-java-programming\ch_16\exercise16_10\test\Welcome.java
 */
public class Exercise16_10 extends Application {
    protected TextField fileNameTextField = new TextField();
    protected TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) throws Exception {
        fileNameTextField.setPrefColumnCount(23);
        Button viewButton = new Button("View");
        HBox paneForTextField = new HBox();
        paneForTextField.getChildren().addAll(new Label("Filename: "),
                fileNameTextField, viewButton);
        textArea.setEditable(false);
        textArea.setWrapText(true);
        ScrollPane scrollPane = new ScrollPane(textArea);
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(scrollPane, paneForTextField);
        viewButton.setOnAction(e -> {
            try {
                Exercise16_10.getTextFile(fileNameTextField.getText(), textArea);
            } catch (FileNotFoundException ex) {
                textArea.setText("Error! File Not Found.");
            }
        });

        Scene scene = new Scene(pane, 600, 200);
        primaryStage.setTitle("Exercise_16_10");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param fileName Name of file to read
     * @param textArea TextArea to display text
     * @throws FileNotFoundException Read file  text from file and displays it in a text area
     */
    private static void getTextFile(String fileName, TextArea textArea) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            textArea.setText(fileName + " does not exist");
        } else {
            StringBuilder text = new StringBuilder();
            try (Scanner input = new Scanner(file)) {
                while (input.hasNext()) {
                    text.append(input.nextLine());
                    text.append("\n");
                }
                textArea.setText(text.toString());
            }
        }
    }
}