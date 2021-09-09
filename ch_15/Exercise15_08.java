package ch_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *15.8 (Display the mouse position) Write two programs, such that one displays the
 * mouse position when the mouse button is clicked (see Figure 15.26a) and the
 * other displays the mouse position when the mouse button is pressed and ceases
 * to display it when the mouse button is released.
 */
public class Exercise15_08 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Text text = new Text();
        pane.getChildren().add(text);

        pane.setOnMousePressed(e -> {
            text.setX(e.getX());
            text.setY(e.getY());
            text.setText("(" + e.getX() + ", " + e.getY() + ")");
        });

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}