package ch_16;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

/**
 * **16.26 (Simulation: raise flag and play anthem) Write a program that displays a flag
 * rising up, as shown in Figure 15.14. As the national flag rises, play the national
 * anthem. (You may use a flag image and anthem audio file from Listing 16.15.)
 */
public class Exercise16_26 extends Application {
    private static final String SLASH = File.separator;

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        String imagePath = "resources" + SLASH + "images" + SLASH + "us.gif";
        ImageView imageView = new ImageView(imagePath);
        pane.getChildren().add(imageView);
        PathTransition pt = new PathTransition(Duration.millis(10000),
                new Line(100, 200, 100, 0), imageView);
        pt.setCycleCount(5);
        pt.play();

        Scene scene = new Scene(pane, 250, 200);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        String audioClipPath = "resources" + SLASH + "audio" +
                SLASH + "anthem" + SLASH + "anthem2.mp3";
        AudioClip audioClip = new AudioClip(new File(audioClipPath).toURI().toString());
        audioClip.setCycleCount(Timeline.INDEFINITE);
        audioClip.play();
    }
}
