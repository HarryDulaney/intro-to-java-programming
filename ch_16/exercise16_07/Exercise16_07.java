package ch_16.exercise16_07;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 * *16.7 (Set clock time) Write a program that displays a clock and sets the time with the
 * input from three text fields, as shown in Figure 16.38b. Use the ClockPane in
 * Listing 14.21. Resize the clock to the center of the pane.
 */
public class Exercise16_07 extends Application {
    private double WIDTH = 450;
    private double HEIGHT = 400;
    SimpleIntegerProperty hourProperty = new SimpleIntegerProperty(12);
    SimpleIntegerProperty minuteProperty = new SimpleIntegerProperty(0);
    SimpleIntegerProperty secondProperty = new SimpleIntegerProperty(0);

    @Override
    public void start(Stage primaryStage) {

        VBox mainLayoutBox = new VBox(5);
        HBox inputsBox = new HBox(1);
        ClockPane clockPane = new ClockPane();

        Label hourLabel = new Label("Hour");
        Label minutelabel = new Label("Minute");
        Label secondsLabel = new Label("Second");

        TextField hourInput = new TextField();
        TextField minuteInput = new TextField();
        TextField secondInput = new TextField();
        hourInput.textProperty().bindBidirectional(hourProperty, new NumberStringConverter());
        minuteInput.textProperty().bindBidirectional(minuteProperty, new NumberStringConverter());
        secondInput.textProperty().bindBidirectional(secondProperty, new NumberStringConverter());

        inputsBox.getChildren().add(hourLabel);
        inputsBox.getChildren().add(hourInput);
        inputsBox.getChildren().add(minutelabel);
        inputsBox.getChildren().add(minuteInput);
        inputsBox.getChildren().add(secondsLabel);
        inputsBox.getChildren().add(secondInput);


        /* Add ClockPane to Parent Pane*/
        mainLayoutBox.getChildren().add(clockPane);
        VBox.setVgrow(clockPane, Priority.ALWAYS);
        /* Add input footer to parent Pane */
        mainLayoutBox.getChildren().add(inputsBox);

        mainLayoutBox.widthProperty().addListener((observable, oldValue, newValue) -> {
            hourInput.setMaxWidth(newValue.doubleValue() / 6); // Set max width of input boxes to 1/6th total width of parent Pane
            secondInput.setMaxWidth(newValue.doubleValue() / 6);
            minuteInput.setMaxWidth(newValue.doubleValue() / 6);
            clockPane.setW(newValue.doubleValue());
        });
        mainLayoutBox.heightProperty().addListener((observable, oldValue, newValue) -> {
            Number inputFooterHeight = inputsBox.getHeight();
            clockPane.setH(newValue.doubleValue() - inputFooterHeight.doubleValue());
        });

        clockPane.setHour(hourProperty.intValue());
        clockPane.setMinute(minuteProperty.intValue());
        clockPane.setSecond(secondProperty.intValue());

        hourProperty.addListener((o, ov, nv) -> {
            clockPane.setHour(nv.intValue());
        });
        minuteProperty.addListener((o, ov, nv) -> {
            clockPane.setMinute(nv.intValue());
        });
        secondProperty.addListener((o, ov, nv) -> {
            clockPane.setSecond(nv.intValue());
        });

        Scene scene = new Scene(mainLayoutBox, WIDTH, HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }
}
