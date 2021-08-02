package ch_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * *14.16 (Display a 3 * 3 grid) Write a program that displays a 3 * 3 grid, as shown in
 * Figure 14.47c. Use red color for vertical lines and blue for horizontals. The lines
 * are automatically resized when the window is resized.
 */
public class Exercise14_16 extends Application {
    private static final double WIDTH = 200;
    private static final double HEIGHT = 200;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Line line1 = new Line(0, 0, 0, 0);
        line1.startYProperty().bind(pane.heightProperty().divide(3));
        line1.endXProperty().bind(pane.widthProperty());
        line1.endYProperty().bind(pane.heightProperty().divide(3));
        line1.setStroke(Color.BLUE);

        Line line2 = new Line(0, 0, 0, 0);
        line2.startYProperty().bind(pane.heightProperty().multiply(2).divide(3));
        line2.endXProperty().bind(pane.widthProperty());
        line2.endYProperty().bind(pane.heightProperty().multiply(2).divide(3));
        line2.setStroke(Color.BLUE);

        Line line3 = new Line(0, 0, 0, 0);
        line3.startXProperty().bind(pane.widthProperty().divide(3));
        line3.endXProperty().bind(pane.widthProperty().divide(3));
        line3.endYProperty().bind(pane.heightProperty());
        line3.setStroke(Color.RED);

        Line line4 = new Line(0, 0, 0, 0);
        line4.startXProperty().bind(pane.widthProperty().multiply(2).divide(3));
        line4.endXProperty().bind(pane.widthProperty().multiply(2).divide(3));
        line4.endYProperty().bind(pane.heightProperty());
        line4.setStroke(Color.RED);

        pane.getChildren().addAll(line1, line2, line3, line4);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();
    }

}
