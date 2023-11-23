package ch_15;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

/**
 * **15.30 (Slide show) Twenty-five slides are stored as image files (slide0.jpg, slide1
 * .jpg, . . . , slide24.jpg) in the image directory downloadable along with the
 * source code in the book. The size of each image is 800 * 600.
 * <p>
 * Write a program that automatically displays the slides repeatedly.
 * Each slide is shown for two seconds. The slides are displayed in order. When the last slide finishes, the
 * first slide is redisplayed, and so on. Click to pause if the animation is currently
 * playing. Click to resume if the animation is currently paused
 * <p>
 * Note: I used the card images from the book's resources folder instead of the slides as
 * I could not find the slides.
 */
public class Exercise15_30 extends Application {
    private int index = 0;

    @Override
    public void start(Stage primaryStage) {
        Image[] image = new Image[26];

        for (int i = 0; i < 25; i++) {
            String imagePath = "resources" + File.separator + "images" + File.separator + "slide" + i + ".jpg";
            image[i] = new Image(imagePath);
        }

        ImageView imageView = new ImageView(image[0]);

        StackPane pane = new StackPane();
        pane.getChildren().add(imageView);
        Scene scene = new Scene(pane, 800, 600);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(2000), e -> {
                    imageView.setImage(image[++index % 25]);
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

}
