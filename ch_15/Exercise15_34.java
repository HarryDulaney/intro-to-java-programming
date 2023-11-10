package ch_15;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * ***15.34 (Simulation: self-avoiding random walk) A self-avoiding walk in a lattice is a
 * path from one point to another that does not visit the same point twice.
 * Self-avoiding walks have applications in physics, chemistry, and mathematics. They
 * can be used to model chain-like entities such as solvents and polymers. Write
 * a program that displays a random path that starts from the center and ends at a
 * point on the boundary, as shown in Figure 15.37a or ends at a dead-end point
 * (i.e., surrounded by four points that have already been visited), as shown in
 * Figure 15.37b. Assume the size of the lattice is 16 by 16.
 */
public class Exercise15_34 extends Application {
    private double paneWidth = 300;
    private double paneHeight = 250;

    @Override
    public void start(Stage primaryStage) {
        Lattice lattice = new Lattice();

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(lattice);
        Button btStart = new Button("Start");
        btStart.setOnAction(e -> lattice.getAPath());
        borderPane.setBottom(btStart);
        BorderPane.setAlignment(btStart, Pos.CENTER);

        Scene scene = new Scene(borderPane, paneWidth, paneHeight + 40);
        primaryStage.setTitle("Exercise15_34");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    class Lattice extends Pane {
        public static final int N = 16;
        private Point[][] lattice = new Point[N + 1][N + 1];
        private double hGap = paneWidth / N;
        private double vGap = paneHeight / N;

        public Lattice() {
            drawLines();
        }

        /**
         * Draw lines
         */
        public void drawLines() {
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
         * Draw a path
         */
        public void drawPath() {
            getChildren().clear();
            drawLines();

            // Start from the center point in the lattice (i, j)
            int i = (N + 1) / 2;
            int j = (N + 1) / 2;

            while (lattice[i][j] != null) {
                Point p = lattice[i][j];
                Line line = new Line(i * hGap, j * vGap, p.x * hGap, p.y * vGap);
                getChildren().add(line);
                i = p.x;
                j = p.y;
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

            drawPath();
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
