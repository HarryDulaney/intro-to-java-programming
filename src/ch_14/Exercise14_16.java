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
    private static final double WIDTH = 400;
    private static final double HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        double offSet = 3;
        for (int i = 0; i < 2; i++, offSet /= 2) {
            Line verticalLine = new Line();
            verticalLine.setStroke(Color.RED);
            verticalLine.startXProperty().bind(pane.widthProperty().divide(offSet));
            verticalLine.startYProperty().bind(pane.layoutYProperty());
            verticalLine.endXProperty().bind(pane.widthProperty().divide(offSet));
            verticalLine.endYProperty().bind(pane.heightProperty());
            pane.getChildren().add(verticalLine);

        }
        offSet = 3;
        for (int i = 0; i < 2; i++, offSet /= 2) {
            Line horizontalLine = new Line();
            horizontalLine.setStroke(Color.BLUE);
            horizontalLine.startXProperty().bind(pane.layoutXProperty());
            horizontalLine.startYProperty().bind(pane.heightProperty().divide(offSet));
            horizontalLine.endXProperty().bind(pane.widthProperty());
            horizontalLine.endYProperty().bind(pane.heightProperty().divide(offSet));
            pane.getChildren().add(horizontalLine);
        }

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

    }
}
