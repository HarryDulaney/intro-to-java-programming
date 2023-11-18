package ch_16;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.io.File;

/**
 * 16.22 (Play, loop, and stop a sound clip) Write a program that meets the following
 * requirements:
 * ■ Get an audio file from the class directory using AudioClip.
 * ■ Place three buttons labeled Play, Loop, and Stop, as shown in Figure 16.46a.
 * ■ If you click the Play button, the audio file is played once. If you click the
 * Loop button, the audio file keeps playing repeatedly. If you click the Stop
 * button, the playing stops.
 */
public class Exercise16_22 extends Application {

    private static final String SLASH = File.separator;

    @Override
    public void start(Stage primaryStage) {
        String audioClipPath = "resources" + SLASH + "audio" +
                SLASH + "anthem" + SLASH + "anthem2.mp3";
        AudioClip audioClip = new AudioClip(new File(audioClipPath).toURI().toString());

        Button btPlay = new Button("Play");
        Button btLoop = new Button("Loop");
        Button btStop = new Button("Stop");

        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btPlay, btLoop, btStop);

        btPlay.setOnAction(e -> {
            audioClip.setCycleCount(1);
            audioClip.play();
        });

        btLoop.setOnAction(e -> {
            audioClip.setCycleCount(Timeline.INDEFINITE);
            audioClip.play();
        });

        btStop.setOnAction(e -> {
            audioClip.stop();
        });

        Scene scene = new Scene(hBox, 200, 100);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
