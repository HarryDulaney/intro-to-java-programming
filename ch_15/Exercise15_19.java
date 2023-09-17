package ch_15;

import ch_09.exercise09_06.StopWatch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * **15.19 (Game: eye-hand coordination) Write a program that displays a circle of radius
 * 10 pixels filled with a random color at a random location on a pane, as shown
 * in Figure 15.29b. When you click the circle, it disappears and a new random color
 * circle is displayed at another random location. After twenty circles are
 * clicked, display the time spent in the pane, as shown in Figure 15.29c
 */
public class Exercise15_19 extends javafx.application.Application {
    private final double WIDTH = 600;
    private final double HEIGHT = 600;
    static final int MAX_CIRCLE_COUNT = 20;
    static final String TITLE_TEXT = "Exercise15_19";

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AtomicInteger circleCount = new AtomicInteger();
        Circle circle = new Circle(0, 0, 10);
        drawCircle(circle);
        Pane pane = new Pane(circle);
        Text countText = new Text(50, 50, String.valueOf(circleCount));
        pane.getChildren().add(countText);
        StopWatch stopWatch = new StopWatch();
        circle.setOnMouseClicked(e -> {
            int currentCount = circleCount.get();
            if (currentCount == 0) {
                stopWatch.start();
            } else if (currentCount < MAX_CIRCLE_COUNT - 1) {
                circleCount.getAndIncrement();
                countText.setText(String.valueOf(circleCount));
                drawCircle(circle);
            } else {
                stopWatch.stop();
                circleCount.getAndIncrement();
                countText.setText(String.valueOf(circleCount));
                pane.getChildren().remove(circle);
                pane.getChildren().add(new Text(WIDTH / 2, HEIGHT / 2, "Time spent is " +
                        stopWatch.getElapsedTime() + " milliseconds"));
            }
        });
        primaryStage.setScene(new Scene(pane, WIDTH, HEIGHT));
        primaryStage.setTitle(TITLE_TEXT);
        primaryStage.show();
    }

    private void drawCircle(Circle circle) {
        double min = circle.getRadius() + 5;
        double max = WIDTH - circle.getRadius() - 5;
        circle.setCenterX((Math.random() * (max - min) + min));
        max = WIDTH - circle.getRadius() - 5;
        circle.setCenterY((Math.random() * (max - min) + min));
        circle.setFill(new Color(Math.random(), Math.random(), Math.random(), 1));
    }
}