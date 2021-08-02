package ch_14;

import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.application.Application;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import javafx.scene.text.Text;

/**
 * *14.21 (Two circles and their distance) Write a program that draws two filled circles
 * with radius 15 pixels, centered at random locations, with a line connecting the
 * two circles. The distance between the two centers is displayed on the line, as
 * shown in Figure 14.49b.
 */
public class Exercise14_21 extends Application {
    private static final double HEIGHT = 400;
    private static final double WIDTH = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Circle c1 = new Circle();
        c1.setRadius(15);
        c1.setFill(Color.BLACK);
        c1.setCenterX(10 + Math.random() * (WIDTH - 15));
        c1.setCenterY(10 + Math.random() * (HEIGHT - 15));
        pane.getChildren().add(c1);

        Circle c2 = new Circle();
        c2.setRadius(15);
        c2.setFill(Color.BLACK);
        c2.setCenterX(10 + Math.random() * (WIDTH - 15));
        c2.setCenterY(10 + Math.random() * (HEIGHT - 15));
        pane.getChildren().add(c2);

        Line line = drawConnectLine(c1.getCenterX(), c1.getCenterY(), c2.getCenterX(), c2.getCenterY());
        Text text = new Text(findDistanceFromCenters(c1, c2));
        text.setX((c1.getCenterX() + c2.getCenterX()) / 2);
        text.setY((c1.getCenterY() + c2.getCenterY()) / 2);

        pane.getChildren().add(line);
        pane.getChildren().add(text);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

    }

    private Line drawConnectLine(double x1, double y1, double x2, double y2) {
        return new Line(x1, y1, x2, y2);
    }


    public static void main(String[] args) {
        Application.launch(args);
    }

    static String findDistanceFromCenters(Circle c1, Circle c2) {
        return String.format("%.2f",
                Math.sqrt(Math.pow(c1.getCenterX() - c2.getCenterX(), 2) + Math.pow(c1.getCenterY() - c2.getCenterY(), 2)));
    }

}
