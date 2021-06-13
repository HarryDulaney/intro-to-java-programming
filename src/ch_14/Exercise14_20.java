package ch_14;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.shape.Line;

import java.util.Random;

/**
 * **14.20 (Draw an arrow line) Write a static method that draws an arrow line
 * from a starting point to an ending point in a pane using the following method header:
 * public static void drawArrowLine(double startX, double startY,
 * double endX, double endY, Pane pane)
 * Write a test program that randomly draws an arrow line, as shown in Figure 14.49a.
 * <p>
 * x3 = x2+L2/L1[(x1−x2)cosθ+(y1−y2)sinθ]
 * <p>
 * y3 = y2+L2/L1[(y1−y2)cosθ−(x1−x2)sinθ]
 * <p>
 * x4 = x2+L2/L1[(x1−x2)cosθ−(y1−y2)sinθ]
 * <p>
 * y4 = y2+L2/L1[(y1−y2)cosθ+(x1−x2)sinθ]
 *
 * <p>
 * Reference:
 * <a href="https://math.stackexchange.com/questions/1314006/drawing-an-arrow">Math for drawing an arrow</a>
 * </p>
 */
public class Exercise14_20 extends Application {
    private static Stage primaryStage;
    private static double WIDTH = 400;
    private static double HEIGHT = 400;

    private static double x1;
    private static double x2;
    private static double y1;
    private static double y2;
    /* Length of main line body */
    private static double L1;
    /* Length of the lines that make the arrow */
    private static double L2;


    public static void drawArrowLine(double startX, double startY, double endX, double endY, Pane pane) {
        double x3, y3, x4, y4;

        Group group = new Group();
        Line line = new Line(startX, startY, endX, endY); // Draw the line for main body of arrow
        L1 = length(line);
        L2 = L1 / 8;
        //Calculate end points for the tip of the arrow
        x3 = endX + (L2 / L1) * (((startX - endX) * Math.cos(Math.toRadians(45.0))) + ((startY - endY) * Math.sin(Math.toRadians(45.0))));
        y3 = endY + (L2 / L1) * (((startY - endY) * Math.cos(Math.toRadians(45.0))) - ((startX - endX) * Math.sin(Math.toRadians(45.0))));
        x4 = endX + (L2 / L1) * (((startX - endX) * Math.cos(Math.toRadians(45.0))) - ((startY - endY) * Math.sin(Math.toRadians(45.0))));
        y4 = endY + (L2 / L1) * (((startY - endY) * Math.cos(Math.toRadians(45.0))) + ((startX - endX) * Math.sin(Math.toRadians(45.0))));

        Line arrowLine1 = new Line(endX, endY, x3, y3);
        Line arrowLine2 = new Line(endX, endY, x4, y4);

        group.getChildren().addAll(line, arrowLine1, arrowLine2);
        pane.getChildren().add(group);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.setTitle(Exercise14_20.class.getName());
        primaryStage.show();

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Exercise14_20.primaryStage = primaryStage;
        Random random = new Random();
        double bound = WIDTH - 100;
        x1 = random.nextInt((int) bound);
        y1 = random.nextInt((int) bound);
        x2 = random.nextInt((int) bound);
        y2 = random.nextInt((int) bound);
        if (Math.abs(y1 - y2) < 75) {
            y2 += 50;
        }
        if (Math.abs(x1 - x2) < 50) {
            x2 += 50;
        }
        Pane pane = new Pane();
        drawArrowLine(x1, y1, x2, y2, pane);

    }

    public static double findSlope(Line l) {
        return (l.getStartY() - l.getEndY()) / (l.getStartX() - l.getEndX());
    }

    public static double length(Line line) {
        return Math.sqrt((line.getStartX() - line.getEndX())
                * (line.getStartX() - line.getEndX())
                + (line.getStartY() - line.getEndY())
                * (line.getStartY() - line.getEndY()));
    }
}
