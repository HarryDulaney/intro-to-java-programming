package ch_14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * 14.9 (Create four fans) Write a program that places four fans in a GridPane with two
 * rows and two columns, as shown in Figure 14.45b.
 */
public class Exercise14_09 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        StackPane[] stackPanes = new StackPane[4];
        GridPane gridPane = new GridPane();

        int paneArrayIdx = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Circle circle = new Circle(100);
                circle.setStroke(Color.BLACK);
                circle.setFill(Color.WHITE);
                StackPane stackPane = new StackPane();
                stackPane.getChildren().add(circle);
                stackPane.getChildren().add(new ArcPane());
                gridPane.add(stackPane, j, i);
                stackPanes[paneArrayIdx++] = stackPane;
            }
        }
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        Scene scene = new Scene(gridPane);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}

class ArcPane extends Pane {

    ArcPane() {
        super();
        create();
    }

    void create() {
        int angle = 120;
        int numArcs = 4;
        while (numArcs > 0) {
            Arc arc = new Arc(100, 100, 80, 80, angle, 35);
            numArcs--;
            angle += 90;
            arc.setFill(Color.GREY);
            arc.setType(ArcType.ROUND);
            super.getChildren().add(arc);
        }
    }

}
