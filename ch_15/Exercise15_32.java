package ch_15;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.util.Duration;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 * *15.32 (Control a clock) Modify Listing 14.21, ClockPane.java, to add the animation
 * into this class and add two methods start() and stop() to start and stop the
 * clock. Write a program that lets the user control the clock with the Start and
 * Stop buttons, as shown in Figure 15.36a.
 */
public class Exercise15_32 extends Application {
    @Override
    public void start(Stage primaryStage) {
        ClockPane clock = new ClockPane();
        HBox hBox = new HBox(5);
        Button btStop = new Button("Stop");
        Button btStart = new Button("Start");
        hBox.getChildren().addAll(btStop, btStart);
        hBox.setAlignment(Pos.CENTER);
        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(hBox);

        Scene scene = new Scene(pane, 250, 300);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        btStart.setOnAction(e -> clock.start());
        btStop.setOnAction(e -> clock.stop());
    }

    static class ClockPane extends Pane {
        private int hour;
        private int minute;
        private int second;

        private final EventHandler<ActionEvent> eventHandler = e -> {
            setCurrentTime();
        };

        private final Timeline animation = new Timeline(
                new KeyFrame(Duration.millis(1000), eventHandler));

        /**
         * Construct a default clock with the current time
         */
        public ClockPane() {
            setCurrentTime();
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
        }

        /**
         * Construct a clock with specified hour, minute, and second
         */
        public ClockPane(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
            paintClock();

            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
        }

        public void pause() {
            animation.pause();
        }

        public void start() {
            animation.play();
        }

        public void stop() {
            animation.stop();
        }

        /**
         * Return hour
         */
        public int getHour() {
            return hour;
        }

        /**
         * Set a new hour
         */
        public void setHour(int hour) {
            this.hour = hour;
            paintClock();
        }

        /**
         * Return minute
         */
        public int getMinute() {
            return minute;
        }

        /**
         * Set a new minute
         */
        public void setMinute(int minute) {
            this.minute = minute;
            paintClock();
        }

        /**
         * Return second
         */
        public int getSecond() {
            return second;
        }

        /**
         * Set a new second
         */
        public void setSecond(int second) {
            this.second = second;
            paintClock();
        }

        /**
         * Set the current time for the clock
         */
        public void setCurrentTime() {
            Calendar calendar = new GregorianCalendar();
            this.hour = calendar.get(Calendar.HOUR_OF_DAY);
            this.minute = calendar.get(Calendar.MINUTE);
            this.second = calendar.get(Calendar.SECOND);
            paintClock();
        }

        /**
         * Paint the clock
         */
        private void paintClock() {
            double clockRadius =
                    Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
            double centerX = getWidth() / 2;
            double centerY = getHeight() / 2;
            Circle circle = new Circle(centerX, centerY, clockRadius);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
            Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
            Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
            Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

            // Second hand
            double sLength = clockRadius * 0.8;
            double secondX = centerX + sLength
                    * Math.sin(second * (2 * Math.PI / 60));
            double secondY = centerY - sLength
                    * Math.cos(second * (2 * Math.PI / 60));
            Line sLine = new Line(centerX, centerY, secondX, secondY);
            sLine.setStroke(Color.RED);

            // Minute hand
            double mLength = clockRadius * 0.65;
            double xMinute = centerX + mLength
                    * Math.sin(minute * (2 * Math.PI / 60));
            double minuteY = centerY - mLength
                    * Math.cos(minute * (2 * Math.PI / 60));
            Line mLine = new Line(centerX, centerY, xMinute, minuteY);
            mLine.setStroke(Color.BLUE);

            // Hour hand
            double hLength = clockRadius * 0.5;
            double hourX = centerX + hLength
                    * Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            double hourY = centerY - hLength
                    * Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
            Line hLine = new Line(centerX, centerY, hourX, hourY);
            hLine.setStroke(Color.GREEN);

            getChildren().clear();
            getChildren().addAll(circle, t1, t2, t3, t4, sLine, mLine, hLine);
        }

        @Override
        public void setWidth(double width) {
            super.setWidth(width);
            paintClock();
        }

        @Override
        public void setHeight(double height) {
            super.setHeight(height);
            paintClock();
        }
    }
}

