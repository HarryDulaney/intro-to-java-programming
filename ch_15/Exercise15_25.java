package ch_15;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * **15.25 (Animation: ball on curve) Write a program that animates a ball moving along
 * a sine curve, as shown in Figure 15.32. When the ball gets to the right border,
 * it starts over from the left. Enable the user to resume/pause the animation with
 * a click on the left/right mouse button.
 */
public class Exercise15_25 extends Application {
    private final double sceneWidth = 600;
    private final double sceneHeight = 260;
    private final int fontSize = 16;

    private final double centerX;
    private final double centerY;

    public Exercise15_25() {
        centerX = sceneWidth / 2;
        centerY = sceneHeight / 2;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Polyline xAxis = new Polyline();
        Polyline yAxis = new Polyline();
        drawYAxis(pane, yAxis);
        drawXAxis(pane, xAxis);

        Polyline polyline1 = new Polyline();
        ObservableList<Double> list = polyline1.getPoints();
        int startXValue = -170;
        int endXValue = 170;
        for (int x = startXValue; x <= endXValue; x++) {
            list.add(x + centerX);
            double y = calculateY(x, centerY);
            list.add(y);
            if (isYIntersectingXAxis(y, centerY)) {
                Text text = new Text(x + centerX, centerY / 0.9, getXAxisLabel(x));
                pane.getChildren().add(text);
            }

        }
        Circle point = new Circle(list.get(0), list.get(1), 10);
        PathTransition path = new PathTransition(Duration.millis(4000), polyline1, point);
        path.setCycleCount(PathTransition.INDEFINITE);
        pane.getChildren().addAll(xAxis, yAxis, polyline1, point);
        pane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                path.play();
            } else if (e.getButton() == MouseButton.SECONDARY) {
                path.pause();
            }
        });
        primaryStage.setScene(new Scene(pane, sceneWidth, sceneHeight));
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();

    }

    private double calculateY(int x, double centerY) {
        return centerY - 50 * Math.sin((x / 100.0) * 2 * Math.PI);
    }

    private boolean isYIntersectingXAxis(double y, double centerY) {
        return y - centerY < 0.01 && y - centerY > -0.01;
    }

    private void drawXAxis(Pane pane, Polyline xAxis) {
        ObservableList<Double> xAxisList = xAxis.getPoints();
        double limit = sceneWidth * 0.95;

        for (double x = 0; x < limit; x++) {
            xAxisList.add(x);
            xAxisList.add(centerY);
        }

        Line line1 = new Line(limit, centerY, limit - sceneWidth * 0.05, centerY * 0.875);
        Line line2 = new Line(limit, centerY, limit - sceneWidth * 0.05, centerY / 0.875);
        Text text = new Text(limit + (sceneWidth * 0.02), centerY, "X");
        text.setFont(Font.font(fontSize));
        pane.getChildren().addAll(line1, line2, text);
    }

    private void drawYAxis(Pane pane, Polyline yAxis) {

        ObservableList<Double> yAxisList = yAxis.getPoints();
        double limit = sceneHeight * 0.95;

        for (double y = 0; y < limit; y++) {
            yAxisList.add(centerX);
            yAxisList.add(y + sceneHeight * 0.1);

        }
        Line line1 = new Line(centerX, sceneHeight * 0.1, centerX - sceneWidth * 0.03, sceneHeight * 0.22);
        Line line2 = new Line(centerX, sceneHeight * 0.1, centerX + sceneWidth * 0.03, sceneHeight * 0.22);
        Text text = new Text(limit + (sceneWidth * 0.2), sceneHeight * 0.1, "Y");
        text.setFont(Font.font(fontSize));
        pane.getChildren().addAll(line1, line2, text);
    }

    private String getXAxisLabel(double x) {
        if (isRoughlyEqual(x, 0)) {
            return "0";
        } else if (isRoughlyEqual(x, 50)) {
            return "π";
        } else if (isRoughlyEqual(x, -50)) {
            return "-π";
        } else if (isRoughlyEqual(x, 100)) {
            return "2π";
        } else if (isRoughlyEqual(x, -100)) {
            return "-2π";
        }

        return "";

    }

    private boolean isRoughlyEqual(double a, double b) {
        return a - b < 0.01 && a - b > -0.01;
    }

}

