package ch_15;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * **15.31 (Geometry: pendulum) Write a program that animates a pendulum swinging,
 * as shown in Figure 15.35. Press the UP arrow key to faster the speed and the
 * DOWN key to slower it. Press the S key to stop animation and the R key to
 * resume it.
 */
public class Exercise15_31 extends Application {
    private final double sceneWidth = 400;

    private final double sceneHeight = 400;

    @Override
    public void start(Stage primaryStage) throws Exception {
        PendulumPane pendulumPane = new PendulumPane(sceneWidth, sceneHeight);
        Scene scene = new Scene(pendulumPane, sceneWidth, sceneHeight);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        pendulumPane.play();

        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case UP:
                    pendulumPane.faster();
                    break;
                case DOWN:
                    pendulumPane.slower();
                    break;
            }
        });
    }
}

class PendulumPane extends Pane {
    PathTransition animationPath;
    Circle referenceCircleTop;
    Circle referenceCircleBottom;
    Line shaft;
    Arc pendulumSwingArc;

    PendulumPane(double width, double height) {
        setPrefWidth(width);
        setPrefHeight(height);
        pendulumSwingArc = new Arc(width / 2,
                height * 0.8,
                width * 0.15,
                width * 0.15,
                180,
                180);
        pendulumSwingArc.setFill(Color.TRANSPARENT);
        pendulumSwingArc.setStroke(Color.BLACK);

        referenceCircleBottom = new Circle(pendulumSwingArc.getCenterX() - pendulumSwingArc.getRadiusX(),
                pendulumSwingArc.getCenterY(),
                10);
        referenceCircleTop = new Circle(pendulumSwingArc.getCenterX(),
                pendulumSwingArc.getCenterY() - height / 2,
                referenceCircleBottom.getRadius() / 2);
        pendulumSwingArc = new Arc(referenceCircleTop.getCenterX(),
                referenceCircleTop.getCenterY(),
                width / 2,
                height / 2,
                240,
                60);
        shaft = new Line(
                referenceCircleTop.getCenterX(), referenceCircleTop.getCenterY(),
                referenceCircleBottom.getCenterX(), referenceCircleBottom.getCenterY());

        shaft.endXProperty().bind(referenceCircleBottom.translateXProperty().add(referenceCircleBottom.getCenterX()));
        shaft.endYProperty().bind(referenceCircleBottom.translateYProperty().add(referenceCircleBottom.getCenterY()));
        animationPath = new PathTransition();
        animationPath.setDuration(Duration.millis(4000));
        animationPath.setPath(pendulumSwingArc);
        animationPath.setNode(referenceCircleBottom);
        animationPath.setOrientation(PathTransition.OrientationType.NONE);
        animationPath.setCycleCount(PathTransition.INDEFINITE);
        animationPath.setAutoReverse(true);

        getChildren().addAll(referenceCircleBottom, referenceCircleTop, shaft);

    }

    public void play() {
        animationPath.play();
    }


    public void faster() {
        animationPath.rateProperty().set(animationPath.getRate() + 1);
    }

    public void slower() {
        animationPath.rateProperty().set(animationPath.getRate() - 1);
    }
}