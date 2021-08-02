package ch_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * *14.13 (Display a pie chart) Write a program that uses a pie chart to display the percentages
 * of the overall grade represented by projects, quizzes, midterm exams, and
 * the final exam, as shown in Figure 14.46c. Suppose that projects take 20 percent
 * and are displayed in red, quizzes take 10 percent and are displayed in blue,
 * midterm exams take 30 percent and are displayed in green, and the final exam
 * takes 40 percent and is displayed in orange. Use the Arc class to display the pies.
 * Interested readers may explore the JavaFX PieChart class for further study.
 */
public class Exercise14_13 extends Application {
    double width = 350;
    double height = 350;
    double nextSliceStart = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();

        double wedge20Percent = 0.2 * 360;
        double wedge10Percent = 0.1 * 360;
        double wedge30Percent = 0.3 * 360;
        double wedge40Percent = 0.4 * 360;
        double centerX = width / 2;
        double centerY = height / 2;
        double radius = 150;

        Circle circle = new Circle(centerX, centerY, radius);

        Arc projects = new Arc(centerX, centerY, circle.getRadius(), circle.getRadius(), nextSliceStart, wedge20Percent);
        nextSliceStart += wedge20Percent;
        projects.setType(ArcType.ROUND);
        projects.setFill(Color.RED);
        projects.setStroke(Color.RED);
        Text projectText = new Text(centerX + 25, centerY - 15, "Project -- 20%");


        Arc quizzes = new Arc(centerX, centerY, circle.getRadius(), circle.getRadius(), nextSliceStart, wedge10Percent);
        nextSliceStart += wedge10Percent;
        quizzes.setType(ArcType.ROUND);
        quizzes.setFill(Color.BLUE);
        quizzes.setStroke(Color.BLUE);
        Text quizText = new Text(centerX + 15, centerY - (radius + 10), "Quizzes -- 10%");


        Arc midTerms = new Arc(centerX, centerY, circle.getRadius(), circle.getRadius(), nextSliceStart,
                wedge30Percent);
        nextSliceStart += wedge30Percent;
        midTerms.setType(ArcType.ROUND);
        midTerms.setFill(Color.GREEN);
        midTerms.setStroke(Color.GREEN);
        Text midtermText = new Text(centerX - 135, centerY, "MidTerm -- 30%");

        Arc finals = new Arc(centerX, centerY, circle.getRadius(), circle.getRadius(), nextSliceStart, wedge40Percent);
        nextSliceStart += wedge40Percent;
        finals.setType(ArcType.ROUND);
        finals.setFill(Color.ORANGE);
        finals.setStroke(Color.ORANGE);
        Text finalsText = new Text(centerX + 15, centerY + (radius - 15), "Finals -- 40%");


        pane.getChildren().add(circle);
        pane.getChildren().addAll(projects, quizzes, midTerms, finals);
        pane.getChildren().addAll(projectText, quizText, midtermText, finalsText);

        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Scene scene = new Scene(pane, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle(getClass().getName());
        primaryStage.show();
    }
}
