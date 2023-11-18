package ch_15;


import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 15.21 (Drag points) Draw a circle with three random points on the circle. Connect
 * the points to form a triangle. Display the angles in the triangle. Use the mouse
 * to drag a point along the perimeter of the circle. As you drag it, the triangle and
 * angles are redisplayed dynamically, as shown in Figure 15.30b. For computing
 * angles in a triangle, see Listing 4.1.
 * <p>
 * The parametric equation for a circle is
 * x = cx + r * cos(a)
 * y = cy + r * sin(a)
 * where r is the radius, (cx, cy) the center of the circle, and a, an angle in radians.
 */
public class Exercise15_21 extends Application {
    private double radius = 10;
    private int centerX = 200;
    private int centerY = 125;
    private int radiusMainCircle = 100;
    private Pane pane = new Pane();
    private Circle outlineCircle = new Circle(centerX, centerY, radiusMainCircle);
    private Circle[] points = new Circle[3];
    private Line line1 = new Line();
    private Line line2 = new Line();
    private Line line3 = new Line();
    private Text[] text = {new Text(), new Text(), new Text()};

    @Override
    public void start(Stage primaryStage) {
        draw();
        pane.getChildren().addAll(points[0], points[1], points[2],
                line1, line2, line3, text[0], text[1], text[2]);
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        points[0].setOnMouseDragged(e -> {
            if (points[0].contains(e.getX(), e.getY())) {
                // Recompute and display angles
                points[0].setCenterX(e.getX());
                points[0].setCenterY(e.getY());
                setLines();
            }
        });

        points[1].setOnMouseDragged(e -> {
            if (points[1].contains(e.getX(), e.getY())) {
                // Recompute and display angles
                points[1].setCenterX(e.getX());
                points[1].setCenterY(e.getY());
                setLines();
            }
        });

        points[2].setOnMouseDragged(e -> {
            if (points[2].contains(e.getX(), e.getY())) {
                // Recompute and display angles
                points[2].setCenterX(e.getX());
                points[2].setCenterY(e.getY());
                setLines();
            }
        });
    }


    void draw() {
        points[0] = new Circle(40, 40, 10);
        points[1] = new Circle(140, 40, 10);
        points[2] = new Circle(60, 140, 10);
        setLines();
    }

    private void setLines() {
        line1.setStartX(points[0].getCenterX());
        line1.setStartY(points[0].getCenterY());
        line1.setEndX(points[1].getCenterX());
        line1.setEndY(points[1].getCenterY());
        line2.setStartX(points[0].getCenterX());
        line2.setStartY(points[0].getCenterY());
        line2.setEndX(points[2].getCenterX());
        line2.setEndY(points[2].getCenterY());
        line3.setStartX(points[1].getCenterX());
        line3.setStartY(points[1].getCenterY());
        line3.setEndX(points[2].getCenterX());
        line3.setEndY(points[2].getCenterY());

        // Compute angles
        double a = new Point2D(points[2].getCenterX(), points[2].getCenterY()).
                distance(points[1].getCenterX(), points[1].getCenterY());
        double b = new Point2D(points[2].getCenterX(), points[2].getCenterY()).
                distance(points[0].getCenterX(), points[0].getCenterY());
        double c = new Point2D(points[1].getCenterX(), points[1].getCenterY()).
                distance(points[0].getCenterX(), points[0].getCenterY());
        double[] angle = new double[3];
        angle[0] = Math.acos((a * a - b * b - c * c) / (-2 * b * c));
        angle[1] = Math.acos((b * b - a * a - c * c) / (-2 * a * c));
        angle[2] = Math.acos((c * c - b * b - a * a) / (-2 * a * b));

        for (int i = 0; i < 3; i++) {
            text[i].setX(points[i].getCenterX());
            text[i].setY(points[i].getCenterY() - radius);
            text[i].setText(String.format("%.2f", Math.toDegrees(angle[i])));
        }
    }
}
