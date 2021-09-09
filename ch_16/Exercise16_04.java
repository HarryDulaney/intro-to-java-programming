package ch_16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * *16.4 (Create a miles/kilometers converter) Write a program that converts miles and
 * kilometers, as shown in Figure 16.37b. If you enter a value in the Mile text field
 * and press the Enter key, the corresponding kilometer measurement is displayed
 * in the Kilometer text field. Likewise, if you enter a value in the Kilometer text
 * field and press the Enter key, the corresponding miles is displayed in the Mile
 * text field
 */
public class Exercise16_04 extends Application {
    private double WIDTH = 300;
    private double HEIGHT = 100;

    @Override
    public void start(Stage primaryStage) {
        TextField tfMile = new TextField();
        TextField tfKilometer = new TextField();
        tfMile.setAlignment(Pos.BOTTOM_RIGHT);
        tfKilometer.setAlignment(Pos.BOTTOM_RIGHT);

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.add(new Label("Miles"), 0, 0);
        pane.add(tfMile, 1, 0);
        pane.add(new Label("Kilometers"), 0, 1);
        pane.add(tfKilometer, 1, 1);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        tfMile.setOnAction(e -> {
            double mile = new Double(tfMile.getText().trim()).doubleValue();
            double kilometer = mile / 0.6241;
            tfKilometer.setText(new Double(kilometer).toString());
        });

        tfKilometer.setOnAction(e -> {
            double kilometer = new Double(tfKilometer.getText().trim()).doubleValue();
            double mile = 0.6241 * kilometer;
            tfMile.setText(new Double(mile).toString());
        });
    }
}
