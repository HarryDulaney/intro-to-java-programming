package ch_14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *14.12 (Display a bar chart) Write a program that uses a bar chart to display the percentages
 * of the overall grade represented by projects, quizzes, midterm exams, and the
 * final exam, as shown in Figure 14.46b.
 * <p>
 * Suppose that projects take 20 percent and are displayed in red,
 * quizzes take 10 percent and are displayed in blue, midterm
 * exams take 30 percent and are displayed in green, and the final exam takes 40
 * percent and is displayed in orange.
 * <p>
 * Use the Rectangle class to display the bars.
 * Interested readers may explore the JavaFX BarChart class for further study.
 */
public class Exercise14_12 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        double fullBarValue = 250;
        HBox hBox = new HBox(5);
        VBox projectBox = new VBox(5);
        VBox quizBox = new VBox(5);
        VBox midtermBox = new VBox(5);
        VBox finalBarBox = new VBox(5);

        Rectangle projectBar = new Rectangle(125, fullBarValue * .2);
        projectBar.setFill(Color.RED);

        Rectangle quizBar = new Rectangle(125, fullBarValue * .1);
        quizBar.setFill(Color.BLUE);

        Rectangle midtermBar = new Rectangle(125, fullBarValue * .3);
        midtermBar.setFill(Color.GREEN);

        Rectangle finalBar = new Rectangle(125, fullBarValue * .4);
        finalBar.setFill(Color.ORANGE);

        Text projectText = new Text("Project -- 20%");
        Text quizText = new Text("Quiz -- 10%");
        Text midtermText = new Text("Midterm -- 30%");
        Text finalText = new Text("Final -- 40%");

        projectBox.getChildren().add(projectText);
        projectBox.getChildren().add(projectBar);
        projectBox.setAlignment(Pos.BOTTOM_CENTER);

        quizBox.getChildren().add(quizText);
        quizBox.getChildren().add(quizBar);
        quizBox.setAlignment(Pos.BOTTOM_CENTER);

        midtermBox.getChildren().add(midtermText);
        midtermBox.getChildren().add(midtermBar);
        midtermBox.setAlignment(Pos.BOTTOM_CENTER);

        finalBarBox.getChildren().add(finalText);
        finalBarBox.getChildren().add(finalBar);
        finalBarBox.setAlignment(Pos.BOTTOM_CENTER);

        hBox.getChildren().addAll(projectBox, quizBox, midtermBox, finalBarBox);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.setPadding(new Insets(10, 10, 10, 10));

        Scene scene = new Scene(hBox);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
