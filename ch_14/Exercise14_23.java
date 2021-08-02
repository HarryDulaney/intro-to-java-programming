package ch_14;

import ch_10.exercise10_13.MyRectangle2D;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.List;
import java.util.Scanner;

/**
 * 14.23 (Geometry: two rectangles) Write a program that prompts the user to enter the
 * center coordinates, width, and height of two rectangles from the command line.
 * The program displays the rectangles and a text indicating whether the two are
 * overlapping, whether one is contained in the other, or whether they don’t overlap,
 * as shown in Figure 14.50. See Programming Exercise 10.13 for checking the
 * relationship between two rectangles.
 */
public class Exercise14_23 extends Application {
    MyRectangle2D rectangleModel1 = new MyRectangle2D();
    MyRectangle2D rectangleModel2 = new MyRectangle2D();

    private static final String OVERLAP = "The rectangles overlap.";
    private static final String DONT_OVERLAP = "The rectangles do not overlap.";
    private static final String CONTAIN = "One rectangle is contained in another.";

    public static void main(String[] args) {
        String[] myArgs = new String[8];
        Scanner in = new Scanner(System.in);
        System.out.println("Rectangle 1 -> x and y are Center coordinates. Enter: x, y, width, height:  ");
        args = in.nextLine().split(" ");
        System.arraycopy(args, 0, myArgs, 0, 4);
        System.out.println("Rectangle 2 -> x and y are Center coordinates. Enter: x, y, width, height:  ");
        String[] rect2 = in.nextLine().split(" ");
        System.arraycopy(rect2, 0, myArgs, 4, 4);
        in.close();

        Application.launch(myArgs);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        Parameters params = getParameters();
        List<String> passedInArgs = params.getRaw();
        if (passedInArgs.size() < 8) {
            System.out.println("Usage: Must be called with parameters to create Rectangles.... Should be 8 String" +
                    " values.");
        }
        rectangleModel1.setX(Double.parseDouble(passedInArgs.get(0)));
        rectangleModel1.setY(Double.parseDouble(passedInArgs.get(1)));
        rectangleModel1.setHeight(Double.parseDouble(passedInArgs.get(2)));
        rectangleModel1.setWidth(Double.parseDouble(passedInArgs.get(3)));

        rectangleModel2.setX(Double.parseDouble(passedInArgs.get(4)));
        rectangleModel2.setY(Double.parseDouble(passedInArgs.get(5)));
        rectangleModel2.setHeight(Double.parseDouble(passedInArgs.get(6)));
        rectangleModel2.setWidth(Double.parseDouble(passedInArgs.get(7)));

        Rectangle r1View = new Rectangle(rectangleModel1.getX(), rectangleModel1.getY(), rectangleModel1.getWidth(),
                rectangleModel1.getHeight());
        r1View.setFill(Color.TRANSPARENT);
        r1View.setStroke(Color.BLACK);
        Rectangle r2View = new Rectangle(rectangleModel2.getX(), rectangleModel2.getY(), rectangleModel2.getWidth(),
                rectangleModel2.getHeight());
        r2View.setFill(Color.TRANSPARENT);
        r2View.setStroke(Color.BLACK);
        Text text = new Text(getTextFromRectangles(rectangleModel1, rectangleModel2));
        text.setTextAlignment(TextAlignment.CENTER);
        text.setY(380);
        text.setX(125);
        pane.getChildren().addAll(r1View, r2View, text);

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private String getTextFromRectangles(MyRectangle2D rectangleModel1, MyRectangle2D rectangleModel2) {
        if (rectangleModel1.overlaps(rectangleModel2)) {
            return OVERLAP;
        } else if (rectangleModel1.contains(rectangleModel2) || rectangleModel2.contains(rectangleModel1)) {
            return CONTAIN;
        } else {
            return DONT_OVERLAP;
        }
    }


}
