package ch_14;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *14.18 (Plot the square function) Write a program that draws a diagram for the function
 * f(x) = x2 (see Figure 14.48b).
 * Hint: Add points to a polyline using the following code:
 * <p><br>
 * {@code
 * Polyline polyline = new Polyline();
 * ObservableList<Double> list = polyline.getPoints();
 * double scaleFactor = 0.0125;
 * for (int x = -100; x <= 100; x++) {
 * list.add(x + 200.0);
 * list.add(scaleFactor * x * x);
 * }
 * }
 */
public class Exercise14_18 extends Application {
    private static final double WIDTH = 400;
    private static final double HEIGHT = 400;

    @Override
    public void start(Stage primaryStage) {
        Polyline polyline = new Polyline();
        ObservableList<Double> list = polyline.getPoints();

        double scaleFactor = 0.0125;
        for (int x = -100; x <= 100; x++) {
            list.add(x + 200.0);
            list.add(200 - scaleFactor * x * x);
        }

        Line line1 = new Line(10, 200, 390, 200);
        Line line2 = new Line(200, 30, 200, 390);

        Line line3 = new Line(390, 200, 370, 190);
        Line line4 = new Line(390, 200, 370, 210);
        Line line5 = new Line(200, 30, 190, 50);
        Line line6 = new Line(200, 30, 210, 50);

        Text text1 = new Text(380, 170, "X");
        Text text2 = new Text(220, 40, "Y");

        Group group = new Group();
        group.getChildren().addAll(polyline, line1, line2,
                line3, line4, line5, line6, text1, text2);

        Scene scene = new Scene(new BorderPane(group), WIDTH, HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
