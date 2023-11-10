package ch_16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * **16.8 (Geometry: two circles intersect?) Write a program that enables the user to
 * specify the location and size of the circles and displays whether the two circles
 * intersect, as shown in Figure 16.39a. Enable the user to point the mouse inside a
 * circle and drag it. As the circle is being dragged, the circle’s center coordinates
 * in the text fields are updated.
 * <p>
 * FIGURE 16.39 Check whether two circles and two rectangles are overlapping
 */
public class Exercise16_08 extends Application {
    private Circle circle1;
    private Circle circle2;
    private Rectangle rectangle;
    private Pane circlePane;
    private TextField c1XTextfield;
    private TextField c1YTextfield;
    private TextField c1RTextfield;
    private TextField c2XTextfield;
    private TextField c2YTextfield;
    private TextField c2RTextfield;

    @Override
    public void start(Stage primaryStage) {
        rectangle = new Rectangle(0, 0, 250, 110);
        rectangle.setStroke(Color.WHITE);
        rectangle.setFill(Color.WHITE);
        circle1 = new Circle(52.0, 60.0, 30);
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.BLACK);
        circle2 = new Circle(180.0, 56.0, 40);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);

        circlePane = new Pane(rectangle, circle1, circle2);
        c1XTextfield = new TextField();
        c2XTextfield = new TextField();
        c1YTextfield = new TextField();
        c2YTextfield = new TextField();
        c1RTextfield = new TextField();
        c2RTextfield = new TextField();
        c1XTextfield.setPrefColumnCount(3);
        c1YTextfield.setPrefColumnCount(3);
        c1RTextfield.setPrefColumnCount(3);
        c2XTextfield.setPrefColumnCount(3);
        c2YTextfield.setPrefColumnCount(3);
        c2RTextfield.setPrefColumnCount(3);

        c1XTextfield.setText(String.valueOf(circle1.getCenterX()));
        c1YTextfield.setText(String.valueOf(circle1.getCenterY()));
        c1RTextfield.setText(String.valueOf(circle1.getRadius()));
        c2XTextfield.setText(String.valueOf(circle2.getCenterX()));
        c2YTextfield.setText(String.valueOf(circle2.getCenterY()));
        c2RTextfield.setText(String.valueOf(circle2.getRadius()));


        VBox paneForTable1 = getInputGrid(c1XTextfield,
                c1YTextfield, c1RTextfield, 1);

        VBox paneForTable2 = getInputGrid(c2XTextfield,
                c2YTextfield, c2RTextfield, 2);

        HBox paneForTables = new HBox(5);
        paneForTables.setAlignment(Pos.CENTER);
        paneForTables.getChildren().addAll(paneForTable1, paneForTable2);
        Button btRedrawCircles = new Button("Redraw Circles");
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(intersect(), circlePane,
                paneForTables, btRedrawCircles);
        btRedrawCircles.setOnAction(e -> {
            draw();
            vBox.getChildren().remove(0);
            vBox.getChildren().add(0, intersect());
        });

        setDraggable(vBox, circle1, c1XTextfield, c1YTextfield);
        setDraggable(vBox, circle2, c2XTextfield, c2YTextfield);

        Scene scene = new Scene(vBox);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        vBox.widthProperty().addListener(ov ->
                rectangle.widthProperty().bind(vBox.widthProperty())
        );

        vBox.heightProperty().addListener(ov ->
                rectangle.heightProperty().bind(vBox.heightProperty().multiply(0.5))
        );
    }

    private void setDraggable(VBox vBox, Circle circle, TextField textFieldX, TextField textFieldY) {
        circle.setOnMouseDragged(e -> {
            if (circle.contains(e.getX(), e.getY())) {
                circle.setCenterX(e.getX());
                circle.setCenterY(e.getY());
                textFieldX.setText(String.valueOf(e.getX()));
                textFieldY.setText(String.valueOf(e.getY()));
            }
            vBox.getChildren().remove(0);
            vBox.getChildren().add(0, intersect());
        });
    }

    private Text intersect() {
        return new Text("Two circles intersect? " + checkIntersection());
    }

    private String checkIntersection() {
        if (Math.sqrt(Math.pow(circle1.getCenterX() - circle2.getCenterX(), 2) +
                Math.pow(circle1.getCenterY() - circle2.getCenterY(), 2)) <= circle1.getRadius() + circle2.getRadius()) {
            return "Yes";
        }
        return "No";
    }

    protected VBox getInputGrid(
            TextField centerX, TextField centerY, TextField r, int n) {
        VBox vBox = new VBox(1);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Center x:"), 0, 0);
        gridPane.add(centerX, 1, 0);
        gridPane.add(new Label("Center y:"), 0, 1);
        gridPane.add(centerY, 1, 1);
        gridPane.add(new Label("Radius:"), 0, 2);
        gridPane.add(r, 1, 2);
        vBox.getChildren().addAll(new Label("Enter circle " +
                n + " info:"), gridPane);
        return vBox;
    }

    private void draw() {
        double x1 = Double.parseDouble(c1XTextfield.getText());
        if (x1 != circle1.getCenterX()) {
            circle1.setCenterX(x1);
        }

        double y1 = Double.parseDouble(c1YTextfield.getText());
        if (y1 != circle1.getCenterY()) {
            circle1.setCenterY(y1);
        }

        double x2 = Double.parseDouble(c2XTextfield.getText());
        if (x2 != circle2.getCenterX()) {
            circle2.setCenterX(x2);
        }

        double y2 = Double.parseDouble(c2YTextfield.getText());
        if (y2 != circle2.getCenterY()) {
            circle2.setCenterY(y2);
        }

        double r1 = Double.parseDouble(c1RTextfield.getText());
        if (r1 != circle1.getRadius()) {
            circle1.setRadius(r1);
        }
        double r2 = Double.parseDouble(c2RTextfield.getText());
        if (r2 != circle2.getRadius()) {
            circle2.setRadius(r2);
        }
    }
}