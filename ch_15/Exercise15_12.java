package ch_15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * **15.12 (Geometry: inside a circle?) Write a program that draws a fixed circle centered
 * at (100, 60) with radius 50. Whenever the mouse is moved, display a message
 * indicating whether the mouse point is inside the circle at the mouse point or
 * n outside of it, as shown in Figure 15.27a.
 */
public class Exercise15_12 extends Application {
    static final double WIDTH = 400;
    static final double HEIGHT = 150;
    static double mouseX;
    static double mouseY;
    static double RADIUS = 50;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Circle circle = new Circle(100, 60, RADIUS, Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        Text message = new Text(circle.getCenterX(), circle.getCenterY(), "");
        pane.getChildren().add(circle);
        pane.getChildren().add(message);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);

        scene.setOnMouseMoved(mouseEvent -> {
            mouseX = mouseEvent.getSceneX();
            mouseY = mouseEvent.getSceneY();
            if (isPointInCircle(mouseX, mouseY, circle)) {
                message.setX(mouseX);
                message.setY(mouseY);
                message.setText("Mouse point is inside the circle");
            } else {
                message.setX(mouseX);
                message.setY(mouseY);
                message.setText("Mouse point is outside the circle");

            }
        });

        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private boolean isPointInCircle(double mouseX, double mouseY, Circle circle) {
        double distFromCenterPoint =
                Math.sqrt(Math.pow(mouseX - circle.getCenterX(), 2) + Math.pow(mouseY - circle.getCenterY(), 2));
        return distFromCenterPoint <= RADIUS;
    }

    public static void main(String[] args) {
        launch(args);
    }

}
