package ch_15;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

/**
 * ***15.33 (Game: bean-machine animation) Write a program that animates the bean
 * machine introduced in Programming Exercise 7.21. The animation terminates
 * after ten balls are dropped, as shown in Figure 15.36b and c.
 */
public class Exercise15_33 extends Application {

    @Override
    public void start(Stage primaryStage) {
        double WIDTH = 400;
        double HEIGHT = 400;
        BeanMachinePane pane = new BeanMachinePane(WIDTH, HEIGHT, 8);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();
        playAnimation(pane);
    }

    static void playAnimation(BeanMachinePane pane) {
        /* Drop 10 balls */
        for (int i = 0; i < 10; i++) {
            pane.dropBall();
        }
    }

    static class BeanMachinePane extends Pane {
        private final int numberOfPins;
        private final int numberOfSlots;

        double ballRadius;

        Line[] outlineShape;
        Line outlineShapeBaseLine;
        Line[] slotVerticalLines;
        Circle[] pins;

        List<Circle> droppedBalls = new ArrayList<>();

        double spaceBallDropDelaySeconds = 0.5;

        public BeanMachinePane(double width, double height, int numberOfSlots) {
            setWidth(width);
            setHeight(height);
            this.numberOfSlots = numberOfSlots;
            this.numberOfPins = getNumberOfPins(numberOfSlots);
            buildStaticShapes();
            getChildren().add(outlineShapeBaseLine);
            getChildren().addAll(outlineShape);
            getChildren().addAll(slotVerticalLines);
            getChildren().addAll(pins);
        }

        public void dropBall() {
            ballDropAnimation();
        }

        private void ballDropAnimation() {
            /* Draw ball in the center flask shape opening */
            double flaskOpeningCenterX = getDropStartPtX();
            /* Draw ball just ABOVE flask shape opening */
            ballRadius = pins[0].getRadius();
            Circle ball = new Circle(flaskOpeningCenterX,
                    outlineShape[5].getEndY() - ballRadius - 20,
                    ballRadius,
                    Color.RED);
            Polyline polyline = createRandomPath(ball);
            PathTransition path = new PathTransition(Duration.seconds(4), polyline, ball);
            path.setDelay(Duration.seconds(spaceBallDropDelaySeconds));
            spaceBallDropDelaySeconds += 1.5;
            getChildren().addAll(polyline);
            getChildren().addAll(ball);
            droppedBalls.add(ball);
            path.play();
        }

        private double getDropStartPtX() {
            return outlineShapeBaseLine.getStartX()
                    + (outlineShapeBaseLine.getEndX()
                    - outlineShapeBaseLine.getStartX()) / 2;
        }


        private Line getBaseLineShape(double paneWidth, double paneHeight) {
            /* Horizontal line at the bottom of the machine (Y value does not change) */
            double baseLineYValue = paneHeight * 0.8;
            double baseLineStartXValue = paneWidth * 0.2;
            double baseLineEndXValue = paneWidth * 0.8;
            return new Line(baseLineStartXValue, baseLineYValue, baseLineEndXValue, baseLineYValue);

        }


        /**
         * @param slots the number of slots in the bean machine
         * @return the number of pins in the bean machine
         */
        int getNumberOfPins(int slots) {
            int numPins = 0;
            do {
                slots--;
                numPins += slots;
            } while (slots > 1);

            return numPins;
        }

        private void buildStaticShapes() {
            double paneWidth = getWidth();
            double paneHeight = getHeight();
            outlineShapeBaseLine = getBaseLineShape(paneWidth, paneHeight);
            double distance = (outlineShapeBaseLine.getEndX() - outlineShapeBaseLine.getStartX()) / numberOfSlots;
            pins = new Circle[numberOfPins];
            int index = 0;
            for (int i = 1; i < numberOfSlots; i++) {
                double x = outlineShapeBaseLine.getStartX() + (i * distance * 0.50) + distance / 2;
                double y = outlineShapeBaseLine.getStartY() - (distance * i) - distance / 2;
                for (int j = 0; j < numberOfSlots - i; j++) {
                    pins[index++] = new Circle(x, y, paneWidth * 0.012, Color.BLUE);
                    x += distance;
                }
            }

            distance = distance + (distance / 2) - pins[0].getRadius();
            slotVerticalLines = new Line[numberOfSlots - 1];
            for (int i = 0; i < numberOfSlots - 1; i++) {
                double x1 = pins[i].getCenterX() + pins[i].getRadius() * Math.sin(Math.PI);
                double y1 = pins[i].getCenterY() - pins[i].getRadius() * Math.cos(Math.PI);
                slotVerticalLines[i] = new Line(x1, y1, x1, y1 + distance);

            }

            outlineShape = new Line[6];
            outlineShape[0] = new Line(
                    outlineShapeBaseLine.getEndX(), outlineShapeBaseLine.getEndY(),
                    outlineShapeBaseLine.getEndX(), outlineShapeBaseLine.getEndY() - distance);
            outlineShape[1] = new Line(
                    outlineShapeBaseLine.getStartX(), outlineShapeBaseLine.getStartY(),
                    outlineShapeBaseLine.getStartX(), outlineShapeBaseLine.getStartY() - distance);

            for (int i = 2; i < 4; i++) {
                double x = pins[pins.length - i].getCenterX();
                double y = pins[pins.length - i].getCenterY() - distance;
                outlineShape[i] =
                        new Line(x, y, outlineShape[i - 2].getEndX(), outlineShape[i - 2].getEndY());
            }

            for (int i = 4; i < outlineShape.length; i++) {
                outlineShape[i] =
                        new Line(
                                outlineShape[i - 2].getStartX(),
                                outlineShape[i - 2].getStartY(),
                                outlineShape[i - 2].getStartX(),
                                outlineShape[i - 2].getStartY() - (distance * 0.6)
                        );
            }
        }

        private Polyline createRandomPath(Circle ball) {
            Polyline polyLine = new Polyline();
            polyLine.setFill(Color.TRANSPARENT);
            polyLine.setStroke(Color.TRANSPARENT);
            ObservableList<Double> pathPoints = polyLine.getPoints();
            Point2D startPoint = new Point2D(ball.getCenterX(), ball.getCenterY());
            double nextX = startPoint.getX(); // Set current X to ball's center X starting position
            double nextY = startPoint.getY(); // Set current Y to ball's center Y starting position
            pathPoints.addAll(nextX, nextY);

            while (nextY < outlineShapeBaseLine.getStartY() - ball.getRadius()) {
                nextY += 1; // Move ball down on Y axis to simulate falling
                /* Re-calculate random path until it does not pass through a static shape */
                nextX = getRandomX(nextX);
                while (collideWithPins(nextX, nextY) || collideWithOutline(nextX, nextY)) {
                    nextX = getRandomX(nextX);
                }
                pathPoints.addAll(nextX, nextY);
            }

            return polyLine;
        }

        private boolean collideWithOutline(double nextX, double nextY) {
            return false;
        }

        private boolean collideWithPins(double nextX, double nextY) {
            for (Circle pin : pins) {
                if (pin.contains(nextX, nextY + ballRadius)) {
                    return true;
                }
            }
            return false;
        }

        private double getRandomX(double currentX) {
            double random = Math.random();
            if (random < 0.5) {
                currentX -= 1;
            } else {
                currentX += 1;
            }
            return currentX;
        }


    }
}
