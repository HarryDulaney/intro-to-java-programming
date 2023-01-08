package ch_16.exercise16_09;

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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * **16.9 (Geometry: two rectangles intersect?) Write a program that enables the user to
 * specify the location and size of the rectangles and displays whether the two rectangles intersect,
 * as shown in Figure 16.39b. Enable the user to point the mouse
 * inside a rectangle and drag it. As the rectangle is being dragged, the rectangle’s
 * center coordinates in the text fields are updated.
 */
public class Exercise16_09 extends Application {
    private RectangleExt rectangle1;
    private RectangleExt rectangle2;
    private Rectangle layoutRect;
    private Pane drawPane;

    private TextField r1centerXTextField;
    private TextField r1centerYTextField;
    private TextField r1WidthTextField;
    private TextField r1HeightTextField;
    private TextField r2centerXTextField;
    private TextField r2centerYTextField;
    private TextField r2WidthTextField;
    private TextField r2HeightTextField;

    @Override
    public void start(Stage primaryStage) {
        layoutRect = new Rectangle(0, 0, 250, 110);
        layoutRect.setStroke(Color.WHITE);
        layoutRect.setFill(Color.WHITE);
        rectangle1 = new RectangleExt(52.0, 60.0, Color.WHITE);
        rectangle1.setTopLeft(new Pt(200, 10));
        rectangle1.setStroke(Color.BLACK);
        rectangle2 = new RectangleExt(80.0, 56.0, Color.WHITE);
        rectangle2.setStroke(Color.BLACK);
        rectangle2.setTopLeft(new Pt(60, 10));

        drawPane = new Pane(layoutRect, rectangle1, rectangle2);
        r1centerXTextField = new TextField();
        r2centerXTextField = new TextField();
        r1centerYTextField = new TextField();
        r2centerYTextField = new TextField();
        r1WidthTextField = new TextField();
        r1HeightTextField = new TextField();
        r2WidthTextField = new TextField();
        r2HeightTextField = new TextField();
        r1centerXTextField.setPrefColumnCount(3);
        r1centerYTextField.setPrefColumnCount(3);
        r1HeightTextField.setPrefColumnCount(3);
        r2centerXTextField.setPrefColumnCount(3);
        r2centerYTextField.setPrefColumnCount(3);
        r2WidthTextField.setPrefColumnCount(3);


        r1centerXTextField.setText(String.valueOf(rectangle1.getCenter().getX()));
        r1centerYTextField.setText(String.valueOf(rectangle1.getCenter().getY()));
        r1WidthTextField.setText(String.valueOf(rectangle1.getWidth()));
        r1HeightTextField.setText(String.valueOf(rectangle1.getHeight()));

        r2centerXTextField.setText(String.valueOf(rectangle2.getCenter().getX()));
        r2centerYTextField.setText(String.valueOf(rectangle2.getCenter().getY()));
        r2WidthTextField.setText(String.valueOf(rectangle2.getWidth()));
        r2HeightTextField.setText(String.valueOf(rectangle2.getHeight()));

        VBox paneForTable1 = getInputGrid(r1centerXTextField,
                r1centerYTextField, r1WidthTextField, r1HeightTextField, 1);

        VBox paneForTable2 = getInputGrid(r2centerXTextField,
                r2centerYTextField, r2WidthTextField, r2HeightTextField, 2);

        HBox paneForTables = new HBox(5);
        paneForTables.setAlignment(Pos.CENTER);
        paneForTables.getChildren().addAll(paneForTable1, paneForTable2);
        Button redrawButton = new Button("Redraw Rectangles");
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(intersect(), drawPane,
                paneForTables, redrawButton);
        redrawButton.setOnAction(e -> {
            draw();
            vBox.getChildren().remove(0);
            vBox.getChildren().add(0, intersect());
        });

        rectangle1.setOnMouseDragged(e -> {
                rectangle1.setTopLeft(new Pt(e.getX(), e.getY()));
                r1centerXTextField.setText(String.valueOf(rectangle1.getCenter().getX()));
                r1centerYTextField.setText(String.valueOf(rectangle1.getCenter().getY()));
            vBox.getChildren().remove(0);
            vBox.getChildren().add(0, intersect());
        });

        rectangle2.setOnMouseDragged(e -> {
                rectangle2.setTopLeft(new Pt(e.getX(), e.getY()));
                r2centerXTextField.setText(String.valueOf(rectangle2.getCenter().getX()));
                r2centerYTextField.setText(String.valueOf(rectangle2.getCenter().getY()));
            vBox.getChildren().remove(0);
            vBox.getChildren().add(0, intersect());

        });

        Scene scene = new Scene(vBox);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        vBox.widthProperty().addListener(ov ->
                layoutRect.widthProperty().bind(vBox.widthProperty())
        );

        vBox.heightProperty().addListener(ov ->
                layoutRect.heightProperty().bind(vBox.heightProperty().multiply(0.5))
        );

        vBox.heightProperty().addListener(ov ->
                layoutRect.heightProperty().bind(vBox.heightProperty().multiply(0.5))
        );

        layoutRect.setWidth(vBox.getWidth());
        layoutRect.setHeight(vBox.getHeight());


    }


    private Text intersect() {
        return new Text("Two rectangles intersect? " + checkIntersection());
    }


    String checkIntersection() {
        if (rectangle1.overlaps(rectangle2)) {
            return "Yes";
        }

        return "No";
    }

    protected VBox getInputGrid(
            TextField x,
            TextField y,
            TextField w,
            TextField h,
            int n) {
        VBox vBox = new VBox(1);
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Center X:"), 0, 0);
        gridPane.add(x, 1, 0);
        gridPane.add(new Label("Center Y:"), 0, 1);
        gridPane.add(y, 1, 1);
        gridPane.add(new Label("Width:"), 0, 2);
        gridPane.add(w, 1, 2);
        gridPane.add(new Label("Height:"), 0, 3);
        gridPane.add(h, 1, 3);
        vBox.getChildren().addAll(new Label("Enter rectangle " +
                n + " info:"), gridPane);
        return vBox;
    }

    private void draw() {
        double x1 = Double.parseDouble(r1centerXTextField.getText());
        if (x1 != rectangle1.getCenter().getX()) {
            rectangle1.setCenter(new Pt(x1, rectangle1.getCenter().getY()));
        }

        double y1 = Double.parseDouble(r1centerYTextField.getText());
        if (y1 != rectangle1.getCenter().getY()) {
            rectangle1.setCenter(new Pt(rectangle1.getCenter().getX(), y1));
        }

        double x2 = Double.parseDouble(r2centerXTextField.getText());
        if (x2 != rectangle2.getCenter().getX()) {
            rectangle2.setCenter(new Pt(x2, rectangle2.getCenter().getY()));
        }

        double y2 = Double.parseDouble(r2centerYTextField.getText());
        if (y2 != rectangle2.getCenter().getY()) {
            rectangle2.setCenter(new Pt(rectangle2.getCenter().getX(), y2));
        }

        double h1 = Double.parseDouble(r1HeightTextField.getText());
        if (h1 != rectangle1.getHeight()) {
            rectangle1.setHeight(h1);
        }

        double w1 = Double.parseDouble(r1WidthTextField.getText());
        if (w1 != rectangle1.getWidth()) {
            rectangle1.setWidth(w1);
        }

        double w2 = Double.parseDouble(r2WidthTextField.getText());
        if (w2 != rectangle2.getWidth()) {
            rectangle2.setWidth(w2);
        }

        double h2 = Double.parseDouble(r2HeightTextField.getText());
        if (h2 != rectangle2.getHeight()) {
            rectangle2.setHeight(h2);
        }


    }
}