package ch_14;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * 14.28 (Random time) Modify the ClockPane class with three new Boolean properties—
 * hourHandVisible, minuteHandVisible, and secondHandVisible—and
 * their associated accessor and mutator methods. You can use the set methods to
 * make a hand visible or invisible.
 * <p>
 * Write a test program that displays only the hour
 * and minute hands. The hour and minute values are randomly generated. The hour
 * is between 0 and 11, and the minute is either 0 or 30, as shown in Figure 14.52b.
 */
public class Exercise14_28 extends Application {

    private static final int HOUR_UPPER_BOUND = 12;
    private static final int MIN_UPPER_BOUND = 30;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CustomClockPane clock = new CustomClockPane((int) (Math.random() * HOUR_UPPER_BOUND),
                (int) (Math.random() * MIN_UPPER_BOUND), 0);
        clock.setSecondHandVisible(false);
        String time = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
        Label currentTimeLabel = new Label(time);

        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(currentTimeLabel);
        BorderPane.setAlignment(currentTimeLabel, Pos.TOP_CENTER);
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

class CustomClockPane extends Pane {
    private int hour;
    private int minute;
    private int second;
    private boolean hourHandVisible = true;
    private boolean minuteHandVisible = true;
    private boolean secondHandVisible = true;

    public CustomClockPane() {
        setTime();
    }

    public CustomClockPane(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        render();

    }

    public boolean isHourHandVisible() {
        return hourHandVisible;
    }

    public CustomClockPane setHourHandVisible(boolean hourHandVisible) {
        this.hourHandVisible = hourHandVisible;
        return this;
    }

    public boolean isMinuteHandVisible() {
        return minuteHandVisible;
    }

    public CustomClockPane setMinuteHandVisible(boolean minuteHandVisible) {
        this.minuteHandVisible = minuteHandVisible;
        return this;
    }

    public boolean isSecondHandVisible() {
        return secondHandVisible;
    }

    public CustomClockPane setSecondHandVisible(boolean secondHandVisible) {
        this.secondHandVisible = secondHandVisible;
        return this;
    }


    void setHour(int hour) {
        this.hour = hour;
        render();
    }


    void setMinute(int minute) {
        this.minute = minute;
        render();
    }


    void setSecond(int second) {
        this.second = second;
        render();
    }

    int getHour() {
        return this.hour;
    }

    int getMinute() {
        return this.minute;
    }

    int getSecond() {
        return this.second;
    }

    void setTime() {
        Calendar calendar = new GregorianCalendar();

        this.hour = calendar.get(Calendar.HOUR_OF_DAY);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);

        render();
    }

    private void render() {
        double clockRadius = Math.min(getWidth(), getHeight()) * 0.8 * 0.5;
        double centerX = getWidth() / 2;
        double centerY = getHeight() / 2;

        Circle circle = new Circle(centerX, centerY, clockRadius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Text t1 = new Text(centerX - 5, centerY - clockRadius + 12, "12");
        Text t2 = new Text(centerX - clockRadius + 3, centerY + 5, "9");
        Text t3 = new Text(centerX + clockRadius - 10, centerY + 3, "3");
        Text t4 = new Text(centerX - 3, centerY + clockRadius - 3, "6");

        double sLength = clockRadius * 0.8;
        double secondX = centerX + sLength *
                Math.sin(second * (2 * Math.PI / 60));
        double secondY = centerY - sLength *
                Math.cos(second * (2 * Math.PI / 60));
        Line sLine = new Line(centerX, centerY, secondX, secondY);
        sLine.setStroke(Color.RED);

        double mLength = clockRadius * 0.65;
        double xMinute = centerX + mLength *
                Math.sin(minute * (2 * Math.PI / 60));
        double minuteY = centerY - mLength *
                Math.cos(minute * (2 * Math.PI / 60));
        Line mLine = new Line(centerX, centerY, xMinute, minuteY);
        mLine.setStroke(Color.BLUE);

        double hLength = clockRadius * 0.5;
        double hourX = centerX + hLength *
                Math.sin((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        double hourY = centerY - hLength *
                Math.cos((hour % 12 + minute / 60.0) * (2 * Math.PI / 12));
        Line hLine = new Line(centerX, centerY, hourX, hourY);
        hLine.setStroke(Color.GREEN);

        getChildren().clear();
        getChildren().addAll(circle, t1, t2, t3, t4);

        if (secondHandVisible) {
            getChildren().add(sLine);
        }

        if (minuteHandVisible) {
            getChildren().add(mLine);
        }

        if (hourHandVisible) {
            getChildren().add(hLine);
        }
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        render();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        render();
    }
}