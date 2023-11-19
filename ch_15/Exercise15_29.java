package ch_15;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * **15.29 (Racing car) Write a program that simulates car racing, as shown in
 * Figure 15.34a. The car moves from left to right. When it hits the right end, it
 * restarts from the left and continues the same process. You can use a timer to
 * control animation. Redraw the car with a new base coordinates (x, y), as shown
 * in Figure  15.34b. Also let the user pause/resume the animation with a
 * button press/release and increase/decrease the car speed by pressing the UP and
 * DOWN arrow keys.
 */
public class Exercise15_29 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        CarPane car = new CarPane();

        Scene scene = new Scene(car, 200, 200);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.widthProperty().addListener(e -> car.setW(car.getWidth()));
        scene.heightProperty().addListener(e -> car.setH(car.getHeight()));

        car.setOnMousePressed(e -> car.pause());
        car.setOnMouseReleased(e -> car.play());

        car.requestFocus();
        car.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                car.increaseSpeed();
            } else if (e.getCode() == KeyCode.DOWN) {
                car.decreaseSpeed();
            }
        });
        car.play();
    }


    class CarPane extends Pane {
        private double w = 200;
        private double h = 200;
        private double baseX = 0;
        private double baseY = h;
        private Circle c1 = new Circle(baseX + 10 + 5, baseY - 10 + 5, 5);
        private Circle c2 = new Circle(baseX + 30 + 5, baseY - 10 + 5, 5);
        private double animationRate = 0.8;

        private Rectangle carBody = new Rectangle(baseX, baseY - 20, 50, 10);
        private Polygon carTop = new Polygon(baseX + 10, baseY - 20,
                baseX + 20, baseY - 30, baseX + 30, baseY - 30,
                baseX + 40, baseY - 20);
        private Timeline animation;

        public CarPane() {
            carBody.setFill(Color.BLACK);
            carTop.setFill(Color.BLACK);
            animation = new Timeline(
                    new KeyFrame(Duration.millis(50), e -> move()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.setRate(animationRate);
            this.getChildren().addAll(c1, c2, carBody, carTop);
            move();
        }

        /**
         * Pause animation
         */
        public void pause() {
            animation.pause();
        }

        /**
         * Play animation
         */
        public void play() {
            animation.play();
        }

        /**
         * Increase rate by 1
         */
        public void increaseSpeed() {
            animation.setRate(animation.getRate() + 0.01);
        }

        /**
         * decrease rate by 1
         */
        public void decreaseSpeed() {
            animation.setRate(animation.getRate() > 0.01 ? animation.getRate() - 0.01 : 0.01);
        }

        public void move() {
            if (baseX > w)
                baseX = -20;
            else
                baseX += 1;

            setValues();
        }

        public void setValues() {
            c1.setCenterX(baseX + 10 + 5);
            c1.setCenterY(baseY - 10 + 5);
            c2.setCenterX(baseX + 30 + 5);
            c2.setCenterY(baseY - 10 + 5);

            carBody.setX(baseX);
            carBody.setY(baseY - 20);

            carTop.getPoints().clear();
            carTop.getPoints().addAll(baseX + 10, baseY - 20,
                    baseX + 20, baseY - 30, baseX + 30, baseY - 30,
                    baseX + 40, baseY - 20);
        }

        public void setW(double w) {
            this.w = w;
            setValues();
        }

        public void setH(double h) {
            this.h = h;
            baseY = h;
            setValues();
        }
    }
}