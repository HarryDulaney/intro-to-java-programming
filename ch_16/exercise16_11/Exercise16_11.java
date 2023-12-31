package ch_16.exercise16_11;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

/**
 * **16.11 (Create a histogram for occurrences of letters) Write a program that reads a
 * file and displays a histogram to show the occurrences of each letter in the file,
 * as shown in Figure 16.40b. The file name is entered from a text field. Pressing
 * the Enter key on the text field causes the program to start to read and process
 * the file and displays the histogram. The histogram is displayed in the center of the
 * window. Define a class named Histogram that extends Pane. The class contains the property counts that is an array
 * of 26 elements. counts[0] stores the
 * number of A, counts[1] the number of B, and so on. The class also contains a
 * setter method for setting a new counts and displaying the histogram for the new
 * counts.
 * <p>
 * Example Filename input:
 * C:\Users\Harry\IdeaProjects\intro-to-java-programming\ch_16\exercise16_11\testFile.txt
 * (Right-click on the testFile.txt and choose 'copy absolute path')
 */
public class Exercise16_11 extends javafx.application.Application {
    private int[] counts = new int[26];

    @Override
    public void start(Stage primaryStage) throws Exception {
        Histogram histogram = new Histogram(new int[26]);
        Label label = new Label("Filename:");
        TextField fileInputField = new TextField();
        Button viewHistogramButton = new Button("View");
        VBox parentBox = new VBox();
        double WIDTH = 800;
        histogram.setPrefWidth(WIDTH);
        double HEIGHT = 500;
        histogram.setPrefHeight(HEIGHT);
        parentBox.setPrefWidth(WIDTH);
        parentBox.setPrefHeight(HEIGHT);
        VBox.setVgrow(histogram, javafx.scene.layout.Priority.ALWAYS);
        parentBox.getChildren().add(histogram);
        parentBox.getChildren().addAll(label, fileInputField, viewHistogramButton);
        viewHistogramButton.setOnMousePressed(event -> {
            String filePath = fileInputField.getText();
            if (filePath.isEmpty()) {
                return;
            }
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File does not exist");
                return;
            }
            histogram.setCounts(countLetterFromFile(file, counts));
        });
        Scene scene = new Scene(parentBox, WIDTH, HEIGHT);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static int[] countLetterFromFile(File file, int[] counts) {
        String s = "";
        try (java.util.Scanner input = new java.util.Scanner(file)) {
            while (input.hasNext()) {
                s = input.nextLine();
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (Character.isLetter(c)) {
                        int index = Character.toUpperCase(c) - 'A';
                        counts[index]++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file");
            System.out.println("Error Message: " + e.getMessage());
        }

        return counts;
    }


}
