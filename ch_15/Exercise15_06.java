package ch_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * **15.6 (Alternate two messages) Write a program to display the text Java is fun
 * and Java is powerful alternately with a mouse click.
 */
public class Exercise15_06 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Text text = new Text("Java is fun");
        pane.getChildren().add(text);

        pane.setOnMouseClicked(e -> {
            if (text.getText().equals("Java is fun")) {
                text.setText("Java is powerful");
            } else {
                text.setText("Java is fun");
            }
        });

        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}