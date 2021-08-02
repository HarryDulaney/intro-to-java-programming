package ch_14;

import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 14.24 (Geometry: Inside a polygon?) Write a program that prompts the user to enter
 * the coordinates of five points from the command line.
 * <p>
 * The first four points form a polygon, and the program displays the polygon and a text that indicates whether
 * the fifth point is inside the polygon, as shown in Figure 14.51a.
 * Hint: Use the Node’s contains method to test whether a point is inside a node.
 */
public class Exercise14_24 extends Application {
    private static final double WIDTH = 200;
    private static final double HEIGHT = 200;


    @Override
    public void start(Stage primaryStage) {
        System.out.print("Enter five points: ");
        Scanner input = new Scanner(System.in);

        Polygon polygon = new Polygon();
        polygon.setFill(Color.WHITE);
        polygon.setStroke(Color.BLACK);

        ObservableList<Double> list = polygon.getPoints();
        for (int i = 0; i < 4; i++) {
            list.add(input.nextDouble());
            list.add(input.nextDouble());
        }

        double x5 = input.nextDouble();
        double y5 = input.nextDouble();

        Pane pane = new Pane();

        Text text = new Text(50, HEIGHT - 20, "");
        if (polygon.contains(x5, y5)) {
            text.setText("The point is inside the polygon");
        } else {
            text.setText("The point is not inside the polygon");
        }

        pane.getChildren().addAll(polygon, new Circle(x5, y5, 10), text);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
} 
