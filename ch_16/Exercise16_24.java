package ch_16;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

/**
 * **16.24 (Revise Listing 16.14 MediaDemo.java) Add a slider to enable the user to set the
 * current time for the video and a label to display the current time and the total
 * time for the video. As shown in Figure 16.47a, the total time is 5 minutes and 3
 * seconds and the current time is 3 minutes and 58 seconds. As the video plays, the
 * slider value and current time are continuously updated.
 */
public class Exercise16_24 extends Application {
    private final static String SLASH = File.separator;

    @Override
    public void start(Stage primaryStage) {
        String mediaPath = "resources" + SLASH + "videos" + SLASH + "sample.mp4";
        Media media = new Media(new File(mediaPath).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        Button playButton = new Button(">");
        playButton.setOnAction(e -> {
            if (playButton.getText().equals(">")) {
                mediaPlayer.play();
                playButton.setText("||");
            } else {
                mediaPlayer.pause();
                playButton.setText(">");
            }
        });

        Slider slTime = new Slider();

        Slider slVolume = new Slider();
        slVolume.setPrefWidth(150);
        slVolume.setMaxWidth(Region.USE_PREF_SIZE);
        slVolume.setMinWidth(30);
        slVolume.setValue(50);
        mediaPlayer.volumeProperty().bind(
                slVolume.valueProperty().divide(100));

        Label lblTime = new Label();

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton, new Label("Time"),
                slTime, lblTime, new Label("Volume"), slVolume);

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 650, 560);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        slTime.valueProperty().addListener(ov -> {
            if (slTime.isValueChanging()) {
                mediaPlayer.seek(mediaPlayer.getTotalDuration().
                        multiply(slTime.getValue() / 100.0));
            }
        });

        mediaPlayer.currentTimeProperty().addListener(ov -> {
            slTime.setValue(mediaPlayer.getCurrentTime().divide(
                    mediaPlayer.getMedia().getDuration()).toMillis() * 100.0);
            lblTime.setText(
                    format((int) mediaPlayer.getCurrentTime().toSeconds()) + "/" +
                            format((int) mediaPlayer.getTotalDuration().toSeconds()));
        });
    }

    public static String format(long seconds) {
        int hour = (int) (seconds / 3600 % 24);
        int minute = (int) (seconds / 60 % 60);
        int second = (int) (seconds % 60);
        return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute) + ":" +
                (second < 10 ? "0" + second : second);
    }
}
