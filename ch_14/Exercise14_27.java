package ch_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * *14.27 (Draw a detailed clock) Modify the ClockPane class in Section 14.12 to draw
 * the clock with more details on the hours and minutes, as shown in Figure 14.52a.
 * <p>
 * <p>
 * Any point (x,y) on the path of the circle is x=r∗sin(θ),y=r∗cos(θ)
 * θ is the angle in radians
 */
public class Exercise14_27 extends Application {
    final double WIDTH = 250;
    final double HEIGHT = 250;

    @Override
    public void start(Stage primaryStage) {
        StyledClockPane styledClockPane = new StyledClockPane(4, 20, 45);

        Scene scene = new Scene(styledClockPane, WIDTH, HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Styled ClockPane displays a more detailed version of the clock with the current time
     */
    class StyledClockPane extends Pane {
        double paneWidth = 250;
        double paneHeight = 250;

        int hour;
        int minute;
        int second;
        double centerX;
        double centerY;
        static final double CLOCK_WIDTH_OFFSET = 0.8;
        static final double CLOCK_DIGITS_OFFSET = 0.03;
        static final double CLOCK_TICK_MARK_LENGTH = 0.03;
        double clockRadius;
        Circle circle;

        public StyledClockPane() {
            setCurrentTime();
            this.clockRadius = calculateRadius(paneWidth, paneHeight);
            this.centerX = paneWidth / 2;
            this.centerY = paneHeight / 2;
        }

        public StyledClockPane(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
            this.clockRadius = calculateRadius(paneWidth, paneHeight);
            this.centerX = paneWidth / 2;
            this.centerY = paneHeight / 2;
            paint();
        }

        double calculateRadius(double paneWidth, double paneHeight) {
            double diameter = Math.min(paneWidth, paneHeight) * 0.8; // small offset from edge of pane
            return diameter / 2; // radius
        }

        public void setCurrentTime() {
            Calendar calendar = new GregorianCalendar();
            this.hour = calendar.get(Calendar.HOUR_OF_DAY);
            this.minute = calendar.get(Calendar.MINUTE);
            this.second = calendar.get(Calendar.SECOND);
            this.clockRadius = calculateRadius(paneWidth, paneHeight);
            paint();
        }

        protected void paint() {
            if (!getChildren().isEmpty()) {
                getChildren().clear();
            }
            circle = getNewCircle();
            centerX = circle.getCenterX();
            centerY = circle.getCenterY();
            Line secondHand = getSecondHandLine();
            Line minuteHand = getMinuteHandLine();
            Line hourHand = getHourHandLine();
            Line[] detailedTickMarks = getTickMarks();
            getChildren().addAll(circle, secondHand, minuteHand, hourHand);
            getChildren().addAll(detailedTickMarks);
            Text[] numbers = getNumbers();
            getChildren().addAll(numbers);
        }

        Circle getNewCircle() {
            Circle c = new Circle(centerX, centerY, clockRadius);
            c.setFill(Color.WHITE);
            c.setStroke(Color.BLACK);
            return c;
        }

        Line getHourHandLine() {
            double length = clockRadius * 0.5;
            double xValue = centerX + length *
                    Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            double yValue = centerY - length *
                    Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            Line hourHandleLine = new Line(centerX, centerY, xValue, yValue);
            hourHandleLine.setStroke(Color.GREEN);
            return hourHandleLine;
        }

        Line[] getTickMarks() {
            Line[] tickMarks = new Line[60];
            for (int i = 0; i < tickMarks.length; i++) {
                double coefficient = (i % 5 == 0) ? 0.91 : 0.955;
                double pt1x = centerX + clockRadius * Math.cos(i * 2 * Math.PI / 60);
                double pt1y = centerY + clockRadius * Math.sin(i * 2 * Math.PI / 60);
                double[] pt2 = getPointToFormLine(centerX, centerY, pt1x, pt1y, coefficient);
                tickMarks[i] = new Line(pt1x, pt1y, pt2[0], pt2[1]);
                tickMarks[i].setStroke(Color.BLACK);
            }
            return tickMarks;
        }

        Text[] getNumbers() {
            Text[] clockNumbers = new Text[12];
            for (int i = 0; i < 12; i++) {
                int hourDigit = (i + 3 > 12) ? i + 3 - 12 : i + 3;
                double[] pt = new double[2];
                pt[0] = (centerX + clockRadius * Math.cos(i * 2 * Math.PI / 12) * CLOCK_WIDTH_OFFSET);
                pt[1] = (centerY + clockRadius * Math.sin(i * 2 * Math.PI / 12) * CLOCK_WIDTH_OFFSET);
                clockNumbers[i] = new Text(pt[0] - (clockRadius * CLOCK_DIGITS_OFFSET),
                        pt[1] + (clockRadius * CLOCK_DIGITS_OFFSET),
                        "" + hourDigit);
            }
            return clockNumbers;
        }

        Line getMinuteHandLine() {
            double length = clockRadius * 0.65;
            double xValue = centerX + length *
                    Math.sin(minute * (2 * Math.PI / 60));
            double yValue = centerY - length *
                    Math.cos(minute * (2 * Math.PI / 60));
            Line minuteHandlLine = new Line(centerX, centerY, xValue, yValue);
            minuteHandlLine.setStroke(Color.BLUE);
            return minuteHandlLine;
        }

        Line getSecondHandLine() {
            double length = clockRadius * CLOCK_WIDTH_OFFSET;
            double xValue = centerX + length *
                    Math.sin(second * (2 * Math.PI / 60));
            double yValue = centerY - length *
                    Math.cos(second * (2 * Math.PI / 60));
            Line secondHandLine = new Line(centerX,
                    centerY,
                    xValue,
                    yValue);
            secondHandLine.setStroke(Color.RED);
            return secondHandLine;
        }

        double[] getPointToFormLine(double pt1x,
                                    double pt1y,
                                    double pt2x,
                                    double pt2y,
                                    double coefficient) {

            double dx = pt2x - pt1x;
            double dy = pt2y - pt1y;

            return new double[]{
                    pt1x + coefficient * dx,
                    pt1y + coefficient * dy
            };


        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
            paint();
        }


        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
            paint();
        }

        public double getW() {
            return paneWidth;
        }

        public void setW(double w) {
            this.paneWidth = w;
            paint();
        }

        public double getH() {
            return paneHeight;
        }

        public void setH(double h) {
            this.paneHeight = h;
            paint();
        }
    }
}
