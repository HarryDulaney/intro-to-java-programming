package ch_15;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * ***15.35 (Animation: self-avoiding random walk) Revise the preceding exercise to display
 * the walk step by step in an animation, as shown in Figure 15.37c and  d.
 */
public class Exercise15_35 extends Application {
    private double paneWidth = 300;
    private double paneHeight = 250;
    private StringProperty buttonLabel = new SimpleStringProperty("Start");

    @Override
    public void start(Stage primaryStage) {
        Lattice lattice = new Lattice();
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(lattice);
        Button btStart = new Button();
        btStart.textProperty().bind(buttonLabel);
        btStart.setOnAction(e -> lattice.actionButtonPressed());
        borderPane.setBottom(btStart);
        BorderPane.setAlignment(btStart, Pos.CENTER);

        Scene scene = new Scene(borderPane, paneWidth, paneHeight + 40);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class Lattice extends Pane {
        public static final int N = 16;
        private Point[][] lattice = new Point[N + 1][N + 1];
        private double hGap = paneWidth / N;
        private double vGap = paneHeight / N;

        private List<Line> steps = new ArrayList<>();
        private int stepIndex = 0;

        public Lattice() {
            drawGrid();
        }

        /**
         * Draw lines
         */
        public void drawGrid() {
            // Draw lattice lines
            for (int i = 1; i < N + 1; i++) {
                Line line1 = new Line(0, i * vGap, paneWidth, i * vGap);
                Line line2 = new Line(i * hGap, 0, i * hGap, paneHeight);
                this.getChildren().addAll(line1, line2);
                line1.setStroke(Color.LIGHTGRAY);
                line2.setStroke(Color.LIGHTGRAY);
            }
        }

        /**
         * Build the steps of the path and store in a Line array
         */
        public void createPathSteps() {
            getChildren().clear();
            drawGrid();

            // Start from the center point in the lattice (i, j)
            int i = (N + 1) / 2;
            int j = (N + 1) / 2;

            while (lattice[i][j] != null) {
                Point p = lattice[i][j];
                Line line = new Line(i * hGap, j * vGap, p.x * hGap, p.y * vGap);
                steps.add(line);
                i = p.x;
                j = p.y;
            }
        }

        void drawNextStep() {
            if (stepIndex == 0) {
                buttonLabel.setValue("Next");
            }

            if (stepIndex < steps.size()) {
                getChildren().add(steps.get(stepIndex++));
            } else {
                buttonLabel.setValue("Restart");
            }
        }

        public void getAPath() {
            // Refresh lattice
            for (int i = 0; i < lattice.length; i++) {
                for (int j = 0; j < lattice.length; j++) {
                    lattice[i][j] = null;
                }
            }

            // (i, j) is the current path point. Initially it is at the center
            int i = (N + 1) / 2;
            int j = (N + 1) / 2;

            while (i > 0 && i < N && j > 0 && j < N) {
                if (lattice[i - 1][j] != null && lattice[i + 1][j] != null
                        && lattice[i][j - 1] != null && lattice[i][j + 1] != null) {
                    break; // Dead end
                }

                double r = Math.random();
                if (r < .25 && lattice[i][j + 1] == null) {
                    lattice[i][j] = new Point(i, j + 1); // Right
                    j++;
                } else if (r < .50 && lattice[i + 1][j] == null) {
                    lattice[i][j] = new Point(i + 1, j); // Down
                    i++;
                } else if (r < .75 && lattice[i][j - 1] == null) {
                    lattice[i][j] = new Point(i, j - 1); // Left
                    j--;
                } else if (r < 1.00 && lattice[i - 1][j] == null) {
                    lattice[i][j] = new Point(i - 1, j); // Up
                    i--;
                }
            }

            createPathSteps();
        }

        public void actionButtonPressed() {
            if (buttonLabel.getValue().equals("Start")) {
                getAPath();
                drawNextStep();
            } else if (buttonLabel.getValue().equals("Next")) {
                drawNextStep();
            } else if (buttonLabel.getValue().equals("Restart")) {
                getChildren().clear();
                steps.clear();
                stepIndex = 0;
                drawGrid();
                buttonLabel.setValue("Start");
            }
        }

        class Point {
            int x;
            int y;

            Point(int i, int j) {
                this.x = i;
                this.y = j;
            }
        }
    }

}
