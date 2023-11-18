package ch_31;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.io.File;

/**
 * *31.2 (BMI server) Write a server for a client. The client sends the weight and
 * height for a person to the server (see Figure  31.18a). The server computes
 * BMI (Body Mass Index) and sends back to the client a string that reports the
 * BMI (see Figure 31.18b). See Section 3.8 for computing BMI. Name the client
 * Exercise31_02Client and the server Exercise31_02Server.
 */
public class Exercise31_02 extends Application {
    private final String SLASH = File.separator;

    @Override
    public void start(Stage primaryStage) {
        String imagePath1 = "resources" + SLASH + "image" + SLASH + "x.gif";
        String imagePath2 = "resources" + SLASH + "image" + SLASH + "o.gif";
        Image imageX = new Image(imagePath1);
        Image imageO = new Image(imagePath2);

        GridPane pane = new GridPane();
        pane.getStylesheets().add("mystyle.css");
        pane.getStyleClass().add("border");

        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((int) (Math.random() * 3) == 0) {
                    ImageView imageView1 = new ImageView(imageX);
                    imageView1.getStyleClass().add("border");
                    pane.add(imageView1, j, i);
                } else if ((int) (Math.random() * 3) == 1) {
                    ImageView imageView2 = new ImageView(imageO);
                    imageView2.getStyleClass().add("border");
                    pane.add(imageView2, j, i);
                }
            }
        }

        Scene scene = new Scene(pane);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

} 
