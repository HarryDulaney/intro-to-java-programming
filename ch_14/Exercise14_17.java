package ch_14;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 14.17 (Game: hangman) Write a program that displays a drawing for the popular hangman game, as shown in Figure 14.48a.
 */
public class Exercise14_17 extends Application {

    private final static double HEIGHT = 320;
    private final static double WIDTH = 300;

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        try {
            Parent root = fxmlLoader.load(new FileInputStream("ch_14/exercise14_17/hangman.fxml"));
            primaryStage.setTitle(getClass().getName());
            root.setTranslateX(20); //Float right to center in frame
            Scene scene = new Scene(root, WIDTH, HEIGHT);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        /*
        Pane pane = new Pane();
        ObservableList<Node> list = pane.getChildren();

        Arc arc = new Arc(WIDTH / 4, HEIGHT - HEIGHT / 12, WIDTH / 5, HEIGHT / 12, 0, 180);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(Color.BLACK);
        list.add(arc);

        Line pole = new Line(arc.getCenterX(), arc.getCenterY() - arc.getRadiusY(), arc.getCenterX(), pane.getHeight() / 12);
        list.add(pole);

        Line holder = new Line(pole.getEndX(), pole.getEndY(), pane.getWidth() / 1.5, pole.getEndY());
        list.add(holder);
        Line hang = new Line(holder.getEndX(), holder.getEndY(), holder.getEndX(), pane.getHeight() / 6);
        list.add(hang);

        double radius = WIDTH / 10;
        Circle c = new Circle(holder.getEndX(), pane.getHeight() / 6 + radius, radius);
        c.setFill(Color.TRANSPARENT);
        c.setStroke(Color.BLACK);
        list.add(c);

        Line leftArm = new Line(pane.getWidth() / 2, pane.getHeight() / 2,
                c.getCenterX() + c.getRadius() * Math.cos(Math.toRadians(angle)),
                c.getCenterY() - c.getRadius() * Math.sin(Math.toRadians(angle));
        list.add(leftArm);

        Line rightArm = new Line(pane.getWidth() / 1.2, pane.getHeight() / 2,
                c.getCenterX() + c.getRadius() * Math.cos(Math.toRadians(angle),
                        c.getCenterY() - c.getRadius() * Math.sin(Math.toRadians(angle));
        list.add(rightArm);

        Line body = new Line(c.getCenterX() + c.getRadius() * Math.cos(Math.toRadians(angle)),
                c.getCenterY() - c.getRadius() * Math.sin(Math.toRadians(angle)),
                c.getCenterX() + c.getRadius() * Math.cos(Math.toRadians(angle), pane.getHeight() / 1.6);
        list.add(body);

        Line leftLeg = new Line(body.getEndX(), body.getEndY(),
                pane.getWidth() / 2, pane.getHeight() / 1.3);
        list.add(leftLeg);

        Line rightLeg = new Line(body.getEndX(), body.getEndY(),
                pane.getWidth() / 1.2, pane.getHeight() / 1.3);
        list.add(rightLeg); */

    }
}
