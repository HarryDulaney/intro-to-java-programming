package ch_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * **14.29 (Game: bean machine) Write a program that displays a bean machine introduced
 * in Programming Exercise 7.21, as shown in Figure 14.52c.
 */
public class Exercise14_29 extends Application {

    @Override
    public void start(Stage primaryStage) {
        double WIDTH = 400;
        double HEIGHT = 400;
        BeanMachinePane pane = new BeanMachinePane(WIDTH, HEIGHT, 8);
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();


    }

    static class BeanMachinePane extends Pane {
        private final int numberOfPins;
        private final int numberOfSlots;
        private Circle[] pins;

        public BeanMachinePane(double width, double height, int numberOfSlots) {
            setWidth(width);
            setHeight(height);
            this.numberOfSlots = numberOfSlots;
            this.numberOfPins = getNumberOfPins(numberOfSlots);
            paint();
        }

        private void paint() {
            double paneWidth = getWidth();
            double paneHeight = getHeight();
            Line lowerLine = new Line(paneWidth * 0.2,
                    paneHeight * 0.8,
                    paneWidth * 0.8,
                    paneHeight * 0.8);

            double distance = (lowerLine.getEndX() - lowerLine.getStartX()) / numberOfSlots;
            pins = new Circle[numberOfPins];
            int index = 0;
            for (int i = 1; i < numberOfSlots; i++) {
                double x = lowerLine.getStartX() + (i * distance * 0.50) + distance / 2;
                double y = lowerLine.getStartY() - (distance * i) - distance / 2;
                for (int j = 0; j < numberOfSlots - i; j++) {
                    pins[index++] = new Circle(x, y, paneWidth * 0.012, Color.BLUE);
                    x += distance;
                }
            }
            distance = distance + (distance / 2) - pins[0].getRadius();
            Line[] lines = new Line[numberOfSlots - 1];
            for (int i = 0; i < numberOfSlots - 1; i++) {
                double x1 = pins[i].getCenterX() + pins[i].getRadius() * Math.sin(Math.PI);
                double y1 = pins[i].getCenterY() - pins[i].getRadius() * Math.cos(Math.PI);
                lines[i] = new Line(
                        x1, y1,
                        x1, y1 + distance);

            }

            Line[] outlineShape = new Line[6];
            outlineShape[0] = new Line(
                    lowerLine.getEndX(), lowerLine.getEndY(),
                    lowerLine.getEndX(), lowerLine.getEndY() - distance);
            outlineShape[1] = new Line(
                    lowerLine.getStartX(), lowerLine.getStartY(),
                    lowerLine.getStartX(), lowerLine.getStartY() - distance);

            for (int i = 2; i < 4; i++) {
                double x = pins[pins.length - i].getCenterX();
                double y = pins[pins.length - i].getCenterY() - distance;
                outlineShape[i] = new Line(x, y, outlineShape[i - 2].getEndX(), outlineShape[i - 2].getEndY());
            }

            for (int i = 4; i < outlineShape.length; i++) {
                outlineShape[i] = new Line(
                        outlineShape[i - 2].getStartX(), outlineShape[i - 2].getStartY(),
                        outlineShape[i - 2].getStartX(), outlineShape[i - 2].getStartY() - (distance * 0.6)
                );
            }

            getChildren().addAll(lowerLine);
            getChildren().addAll(pins);
            getChildren().addAll(lines);
            getChildren().addAll(outlineShape);
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

    }
}
