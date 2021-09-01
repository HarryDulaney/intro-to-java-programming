package ch_15;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.logging.Logger;

/**
 * 15.3 (Move the ball) Write a program that moves the ball in a pane. You should
 * define a pane class for displaying the ball and provide the methods for moving
 * the ball left, right, up, and down, as shown in Figure 15.24c.
 * Check the boundary to prevent the ball from moving out of sight completely.
 */
public class Exercise15_03 extends Application {

    Logger LOGGER = Logger.getLogger(getClass().getName());
    private static final double WIDTH = 320;
    private static final double HEIGHT = 200;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox mainBox = new VBox();
        HBox buttonBar = new HBox(5);

        CustomBallPane ballPane = new CustomBallPane(WIDTH / 2, HEIGHT / 2);

        Button leftBtn = new Button("Left");
        leftBtn.setOnAction(e -> {
            ballPane.moveLeft();
        });

        Button rightBtn = new Button("Right");
        rightBtn.setOnAction(e -> {
            ballPane.moveRight();
        });

        Button upBtn = new Button("Up");
        upBtn.setOnAction(e -> {
            ballPane.moveUp();
        });

        Button downBtn = new Button("Down");
        downBtn.setOnAction(e -> {
            ballPane.moveDown();
        });

        buttonBar.getChildren().addAll(leftBtn, rightBtn, upBtn, downBtn);
        buttonBar.setAlignment(Pos.BOTTOM_CENTER);
        buttonBar.setFillHeight(false);
        mainBox.getChildren().addAll(ballPane, buttonBar);
        VBox.setVgrow(buttonBar, Priority.NEVER);
        VBox.setVgrow(ballPane, Priority.ALWAYS);

        Scene scene = new Scene(mainBox, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();
    }

    static class CustomBallPane extends Pane {
        double move = 10;
        double radius = 20;
        Circle ball;

        public CustomBallPane(double positionX, double positionY) {
            ball = new Circle(radius);
            ball.setCenterX(positionX);
            ball.setCenterY(positionY);

            ball.setFill(Color.TRANSPARENT);
            ball.setStroke(Color.BLACK);
            getChildren().add(ball);
        }

        void moveLeft() {
            double calcMove = ball.getCenterX() - move;
            if ((calcMove - radius) > ball.getParent().getLayoutBounds().getMinX()) {
                ball.setCenterX(calcMove);
            }
        }

        void moveRight() {
            double calcMove = ball.getCenterX() + move;
            if ((calcMove + radius) < ball.getParent().getLayoutBounds().getMaxX()) {
                ball.setCenterX(calcMove);
            }
        }

        void moveUp() {
            double calcMove = ball.getCenterY() - move;
            if ((calcMove - radius) > ball.getParent().getLayoutBounds().getMinY()) {
                ball.setCenterY(calcMove);
            }
        }

        void moveDown() {
            double calcMove = ball.getCenterY() + move;
            if ((calcMove + radius) < ball.getParent().getLayoutBounds().getMaxY()) {
                ball.setCenterY(calcMove);
            }
        }
    }
}
