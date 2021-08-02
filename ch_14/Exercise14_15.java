package ch_14;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * 14.15 (Display a STOP sign) Write a program that displays a STOP sign, as shown
 * in Figure 14.47b. The octagon is in red and the sign is in white. (Hint: Place an
 * octagon and a text in a stack pane.)
 */
public class Exercise14_15 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane stackPane = new StackPane();
        Polygon polygon = new Polygon();
        stackPane.getChildren().add(polygon);
        polygon.setFill(Color.RED);
        polygon.setStroke(Color.RED);

        ObservableList<Double> list = polygon.getPoints();
        final double WIDTH = 200, HEIGHT = 200;
        double centerX = WIDTH / 2, centerY = HEIGHT / 2;
        double radius = Math.min(WIDTH, HEIGHT) * 0.4;
        // Add points to the polygon list -> divide Math.PI by 8 for Octagon
        for (int i = 0; i < 8; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
        }
        polygon.setRotate(22.5);

        Text text = new Text("STOP");
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFill(Color.WHITE);
        text.setStroke(Color.WHITE);
        text.setFont(Font.font(42));
        stackPane.getChildren().add(text);

        Scene scene = new Scene(stackPane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
