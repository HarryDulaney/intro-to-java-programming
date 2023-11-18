package ch_15;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
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

    private final double WIDTH = 600;
    private final double HEIGHT = 100;

    @Override
    public void start(Stage primaryStage) throws Exception {
        RacingPane pane = new RacingPane(WIDTH, HEIGHT);
        pane.start();
        pane.setOnMousePressed(e -> pane.pause());
        pane.setOnMouseReleased(e -> pane.play());

        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                pane.increaseSpeed();
            } else if (e.getCode() == KeyCode.DOWN) {
                pane.decreaseSpeed();
            }
        });

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        pane.requestFocus();
    }

}

class RacingPane extends Pane {
    private double x;
    private double y;
    private CarShape car;
    private Timeline animation;

    /**
     * Construct and animate a default CarPane
     */
    RacingPane(double width, double height) {
        setHeight(height);
        setWidth(width);
        car = new CarShape(x, y, 5, this);
        x = 0;
        y = 100;
        animation = new Timeline(
                new KeyFrame(Duration.millis(50), e -> car.moveCar(x, y, this)));
        animation.setCycleCount(Timeline.INDEFINITE);
    }


    void start() {
        animation.play();
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
        animation.setRate(animation.getRate() + 1);
    }

    /**
     * decrease rate by 1
     */
    public void decreaseSpeed() {
        animation.setRate(animation.getRate() > 0 ? animation.getRate() - 1 : 0);
    }

    class CarShape {
        private double wheelRadius;
        private Rectangle lowerBody;
        private Polygon topBody;
        private Circle wheel1;
        private Circle wheel2;

        public CarShape(double x, double y, double wheelRadius, Pane pane) {
            this.wheelRadius = wheelRadius;
            drawAndRender(x, y, pane);
        }

        void drawAndRender(double x, double y, Pane pane) {
            if (!pane.getChildren().isEmpty()) {
                pane.getChildren().clear();
            }

            lowerBody = new Rectangle(x, y - 20, 50, 10);
            topBody = new Polygon(x + 10, y - 20, x + 20, y - 30, x + 30,
                    y - 30, x + 40, y - 20);
            wheel1 = new Circle(x + 15, y - 5, wheelRadius);
            wheel2 = new Circle(x + 35, y - 5, wheelRadius);
            pane.getChildren().addAll(getLowerBody(), getWheel1(), getWheel2(), getTopBody());
        }

        /**
         * Calculate new x position and draw car
         *
         * @param x    the current x position
         * @param y    the current y position
         * @param pane the pane to render the car on
         */
        protected void moveCar(double x, double y, Pane pane) {
                x += 1;


            drawAndRender(x, y, pane);
        }

        public Rectangle getLowerBody() {
            return lowerBody;
        }

        public Polygon getTopBody() {
            return topBody;
        }

        public Circle getWheel1() {
            return wheel1;
        }

        public Circle getWheel2() {
            return wheel2;
        }
    }
}