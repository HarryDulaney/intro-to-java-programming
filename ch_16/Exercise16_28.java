package ch_16;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;

/**
 * **16.28 (Slide show) Programming Exercise 15.30 developed a slide show using images.
 * Rewrite that program to develop a slide show using text files. Suppose ten text
 * files named slide0.txt, slide1.txt, . . . , and slide9.txt are stored in the text directory.
 * Each slide displays the text from one file. Each slide is shown for one second,
 * and the slides are displayed in order. When the last slide finishes, the first
 * slide is redisplayed, and so on. Use a text area to display the slide.
 */
public class Exercise16_28 extends Application {
    private static final String SLASH = java.io.File.separator;
    private final static int NUMBER_OF_SLIDES = 10;
    private int current = 0;
    private String[] slides = new String[NUMBER_OF_SLIDES];

    @Override
    public void start(Stage primaryStage) {
        loadTextToSlides();

        TextArea ta = new TextArea();
        ta.setWrapText(true);

        StackPane pane = new StackPane();
        pane.getChildren().add(new ScrollPane(ta));

        Scene scene = new Scene(pane, 400, 200);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(2000), e -> {
                    ta.setText(slides[current]);
                    current = (current + 1) % NUMBER_OF_SLIDES;
                    ;
                }));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        pane.setOnMouseClicked(e -> {
            if (animation.getStatus() == Animation.Status.PAUSED) {
                animation.play();
            } else {
                animation.pause();
            }
        });
    }

    private void loadTextToSlides() {
        for (int i = 0; i < NUMBER_OF_SLIDES; i++) {
            String relativeFilePath = "resources" + SLASH + "text";
            slides[i] = readAFile(relativeFilePath + SLASH + "slide" + i + ".txt");
        }
    }

    private String readAFile(String filePath) {
        StringBuilder text = new StringBuilder();
        File toRead = new File(filePath);
        System.out.println("Reading file: " + toRead.getAbsolutePath());
        try {
            java.util.Scanner input = new java.util.Scanner(toRead);
            while (input.hasNext()) {
                text.append(input.nextLine()).append("\n");
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("FileNotFound: " + filePath);
        }

        return text.toString();
    }
}
