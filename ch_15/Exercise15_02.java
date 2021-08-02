package ch_15;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.logging.Logger;

/**
 * 15.2 (Rotate a rectangle) Write a program that rotates a rectangle 15 degrees right
 * when the Rotate button is clicked, as shown in Figure 15.24b.
 */
public class Exercise15_02 extends Application {
    Logger LOGGER = Logger.getLogger(getClass().getName());
    private static double rotation = 0;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox vbox = new VBox();
        HBox mainBox = new HBox();
        HBox buttonBar = new HBox();
        vbox.setFillWidth(true);
        VBox.setVgrow(mainBox, Priority.ALWAYS);

        mainBox.setAlignment(Pos.CENTER);
        mainBox.setFillHeight(true);

        Rectangle rectangle = new Rectangle(200, 100);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);

        Button rotateButton = new Button("Rotate");
        rotateButton.setOnAction(e -> rotate(rectangle));

        buttonBar.getChildren().add(rotateButton);
        buttonBar.setAlignment(Pos.BOTTOM_CENTER);
        mainBox.setCenterShape(true);
        mainBox.getChildren().add(rectangle);
        vbox.getChildren().add(mainBox);

        vbox.getChildren().add(buttonBar);
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();
    }

    private void rotate(Rectangle rectangle) {
        if (rotation == 360) {
            rotation = 0;
        }
        rotation += 15;
        rectangle.setRotate(rotation);
        LOGGER.info("Rotation value is: " + rotation);

    }
}
