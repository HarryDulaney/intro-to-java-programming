package ch_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *14.22 (Connect two circles) Write a program that draws two circles with radius
 * 15 pixels, centered at random locations, with a line connecting the two circles.
 * The line should not cross inside the circles, as shown in Figure 14.49c.
 */
public class Exercise14_22 extends Application {
    static final double WIDTH = 400;
    static final double HEIGHT = 400;
    static final double RADIUS = 15;


    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        double x1 = Math.random() * (WIDTH - 15);
        double y1 = Math.random() * (HEIGHT - 15);
        double x2 = Math.random() * (WIDTH - 15);
        double y2 = Math.random() * (HEIGHT - 15);

        Circle c1 = new Circle(x1, y1, RADIUS);
        Circle c2 = new Circle(x2, y2, RADIUS);
        c1.setFill(Color.WHITE);
        c1.setStroke(Color.BLACK);
        c2.setFill(Color.WHITE);
        c2.setStroke(Color.BLACK);

        Text text1 = new Text(x1, y1, "1");
        Text text2 = new Text(x2, y2, "2");

        Line line = drawConnectionLine(x1, y1, x2, y2, RADIUS);

        pane.getChildren().addAll(c1, c2, line, text1, text2);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Line drawConnectionLine(
            double x1, double y1, double x2, double y2, double radius) {
        double d = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        int x11 = (int) (x1 - radius * (x1 - x2) / d);
        int y11 = (int) (y1 - radius * (y1 - y2) / d);
        int x21 = (int) (x2 + radius * (x1 - x2) / d);
        int y21 = (int) (y2 + radius * (y1 - y2) / d);
        return new Line(x11, y11, x21, y21);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}