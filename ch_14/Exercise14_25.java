package ch_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * *14.25 (Random points on a circle) Modify {@linkplain ch_04.Exercise04_06} to create five
 * random points on a circle, form a polygon by connecting the points clockwise,
 * and display the circle and the polygon, as shown in Figure 14.51b.
 */
public class Exercise14_25 extends Application {
    private final double RADIUS = 80;
    private final double WIDTH = 200;
    private final double HEIGHT = 200;

    @Override
    public void start(Stage primaryStage) throws Exception {
        double[][] pointsInCircle = new double[5][2];
        Circle circle = new Circle(100,100, RADIUS);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);

        for (int i = 0; i < 5; i++) {
            pointsInCircle[i] = randomPointOnCircle(circle.getCenterX(), circle.getCenterY(), RADIUS);
        }
        drawCircleWithPolygonPoints(pointsInCircle, primaryStage, circle);

    }

    private void drawCircleWithPolygonPoints(double[][] points, Stage stage, Circle circle) {
        Pane pane = new Pane();
        pane.getChildren().add(circle);

        for (int i = 0; i < points.length - 1; i++) {
            Line line = new Line(points[i][0], points[i][1], points[i + 1][0], points[i + 1][1]);
            pane.getChildren().add(line);
        }

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle(getClass().getName());
        stage.show();

    }

    private double[] randomPointOnCircle(double centerX, double centerY, double radius) {
        double angle = Math.random() * 2 * Math.PI,
                A = Math.sqrt(Math.random()) * radius,
                B = Math.cos(angle) * A,
                C = Math.sin(angle) * A;
        return new double[]{centerX + B, centerY + C};
    }

    public static void main(String[] args) {
        launch(args);
    }

}
