package ch_15;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * *15.23 (Auto resize stop sign) Rewrite Programming Exercise 14.15 so that the stop
 * sign’s width and height are automatically resized when the window is resized.
 */
public class Exercise15_23 extends Application {
    double originalWidth = 200, originalHeight = 200;
    double originalFontSize = 42;
    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane stackPane = new StackPane();
        stackPane.setPrefWidth(originalWidth);
        stackPane.setPrefHeight(originalHeight);
        drawStopSign(stackPane);
        Scene scene = new Scene(stackPane, originalWidth, originalHeight);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setResizable(true);
        primaryStage.show();

        scene.widthProperty().addListener((observable, oldValue, newValue) -> {
            stackPane.setPrefWidth((double) newValue);
            drawStopSign(stackPane);

        });

        scene.heightProperty().addListener((observable, oldValue, newValue) -> {
            stackPane.setPrefHeight((double) newValue);
            drawStopSign(stackPane);
        });
    }

    void drawStopSign(StackPane stackPane) {
        Polygon polygon = new Polygon();
        stackPane.getChildren().clear();
        double width = stackPane.getPrefWidth();
        double height = stackPane.getPrefHeight();
        stackPane.getChildren().add(polygon);
        polygon.setFill(Color.RED);
        polygon.setStroke(Color.RED);

        ObservableList<Double> list = polygon.getPoints();
        double centerX = width / 2, centerY = height / 2;
        double radius = Math.min(width, height) * 0.4;
        // Add points to the polygon list -> divide Math.PI by 8 for Octagon
        for (int i = 0; i < 8; i++) {
            list.add(centerX + radius * Math.cos(2 * i * Math.PI / 8));
            list.add(centerY - radius * Math.sin(2 * i * Math.PI / 8));
        }
        polygon.setRotate(22.5);

        Text text = new Text("STOP");
        text.setTextAlignment(TextAlignment.CENTER);
        text.setFill(Color.WHITE);
        text.setStroke(Color.WHITE);
        text.setFont(Font.font(originalFontSize * Math.min(width, height) / Math.min(originalWidth, originalHeight)));
        stackPane.getChildren().add(text);

    }

}