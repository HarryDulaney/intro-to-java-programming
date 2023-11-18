package ch_16;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * **16.30 (Pattern recognition: consecutive four equal numbers) Write a GUI program for
 * Programming Exercise 8.19, as shown in Figure 16.49a–b. Let the user enter the
 * numbers in the text fields in a grid of 6 rows and 7 columns. The user can click
 * the Solve button to highlight a sequence of four equal numbers,
 * if it exists. Initially, the values in the text fields are filled with numbers from 0 to 9 randomly.
 */
public class Exercise16_30 extends Application {
    private int[][] numbers = new int[6][7];

    @Override
    public void start(Stage primaryStage) {
        Label lblStatus = new Label();

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        TextField[][] tfValues = new TextField[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                tfValues[i][j] = new TextField((int) (Math.random() * 10) + "");
                tfValues[i][j].setPrefColumnCount(1);
                gridPane.add(tfValues[i][j], j, i);
            }
        }

        BorderPane pane = new BorderPane();
        Button btSolve = new Button("Solve");
        pane.setTop(lblStatus);
        BorderPane.setAlignment(lblStatus, Pos.CENTER);
        pane.setCenter(gridPane);
        pane.setBottom(btSolve);
        BorderPane.setAlignment(btSolve, Pos.CENTER);

        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

        btSolve.setOnAction(e -> {
            for (int i = 0; i < numbers.length; i++)
                for (int j = 0; j < numbers[i].length; j++) {
                    tfValues[i][j].setStyle("-fx-background: white");
                    if (tfValues[i][j].getText().trim().length() == 0) {
                        lblStatus.setText("All cells must be filled with numbers");
                        return;
                    } else
                        numbers[i][j] = Integer.parseInt(tfValues[i][j].getText().trim());
                }

            int[][] result = isConsecutiveFour(numbers);
            if (result != null) {
                lblStatus.setText("A consecutive four found");
                tfValues[result[0][0]][result[0][1]].setStyle("-fx-background: red");
                tfValues[result[1][0]][result[1][1]].setStyle("-fx-background: red");
                tfValues[result[2][0]][result[2][1]].setStyle("-fx-background: red");
                tfValues[result[3][0]][result[3][1]].setStyle("-fx-background: red");
            } else {
                lblStatus.setText("No four consecutive numbers in a row, a column, or a diagonal");
            }
        });
    }

    public static int[][] isConsecutiveFour(int[][] values) {
        int numberOfRows = values.length;
        int numberOfColumns = values[0].length;

        // Check rows
        for (int i = 0; i < numberOfRows; i++) {
            if (isConsecutiveFour(values[i]) != null) {
                int[][] result = new int[4][2];
                result[0][0] = result[1][0] = result[2][0] = result[3][0] = i;
                int k = isConsecutiveFour(values[i]);

                result[0][1] = k;
                result[1][1] = k + 1;
                result[2][1] = k + 2;
                result[3][1] = k + 3;

                return result;
            }
        }

        // Check columns
        for (int j = 0; j < numberOfColumns; j++) {
            int[] column = new int[numberOfRows];
            // Get a column into an array
            for (int i = 0; i < numberOfRows; i++)
                column[i] = values[i][j];

            if (isConsecutiveFour(column) != null) {
                int[][] result = new int[4][2];
                result[0][1] = result[1][1] = result[2][1] = result[3][1] = j;
                int k = isConsecutiveFour(column);

                result[0][0] = k;
                result[1][0] = k + 1;
                result[2][0] = k + 2;
                result[3][0] = k + 3;

                return result;
            }
        }

        // Check major diagonal (lower part)
        for (int i = 0; i < numberOfRows - 3; i++) {
            int numberOfElementsInDiagonal
                    = Math.min(numberOfRows - i, numberOfColumns);
            int[] diagonal = new int[numberOfElementsInDiagonal];
            for (int k = 0; k < numberOfElementsInDiagonal; k++)
                diagonal[k] = values[k + i][k];

            if (isConsecutiveFour(diagonal) != null) {
                int[][] result = new int[4][2];
                int k = isConsecutiveFour(diagonal);
                result[0][0] = k + i;
                result[1][0] = k + 1 + i;
                result[2][0] = k + 2 + i;
                result[3][0] = k + 3 + i;
                result[0][1] = k;
                result[1][1] = k + 1;
                result[2][1] = k + 2;
                result[3][1] = k + 3;
                return result;
            }
        }

        // Check major diagonal (upper part)
        for (int j = 1; j < numberOfColumns - 3; j++) {
            int numberOfElementsInDiagonal
                    = Math.min(numberOfColumns - j, numberOfRows);
            int[] diagonal = new int[numberOfElementsInDiagonal];
            for (int k = 0; k < numberOfElementsInDiagonal; k++)
                diagonal[k] = values[k][k + j];

            if (isConsecutiveFour(diagonal) != null) {
                int[][] result = new int[4][2];
                int k = isConsecutiveFour(diagonal);
                result[0][0] = k;
                result[1][0] = k + 1;
                result[2][0] = k + 2;
                result[3][0] = k + 3;
                result[0][1] = k + j;
                result[1][1] = k + 1 + j;
                result[2][1] = k + 2 + j;
                result[3][1] = k + 3 + j;
                return result;
            }
        }

        // Check sub-diagonal (left part)
        for (int j = 3; j < numberOfColumns; j++) {
            int numberOfElementsInDiagonal
                    = Math.min(j + 1, numberOfRows);
            int[] diagonal = new int[numberOfElementsInDiagonal];

            for (int k = 0; k < numberOfElementsInDiagonal; k++)
                diagonal[k] = values[k][j - k];

            if (isConsecutiveFour(diagonal) != null) {
                int[][] result = new int[4][2];
                int k = isConsecutiveFour(diagonal);
                result[0][0] = k;
                result[1][0] = k + 1;
                result[2][0] = k + 2;
                result[3][0] = k + 3;
                result[0][1] = j - k;
                result[1][1] = j - k - 1;
                result[2][1] = j - k - 2;
                result[3][1] = j - k - 3;
                return result;
            }
        }

        // Check sub-diagonal (right part)
        for (int i = 1; i < numberOfRows - 3; i++) {
            int numberOfElementsInDiagonal
                    = Math.min(numberOfRows - i, numberOfColumns);
            int[] diagonal = new int[numberOfElementsInDiagonal];

            for (int k = 0; k < numberOfElementsInDiagonal; k++)
                diagonal[k] = values[k + i][numberOfColumns - k - 1];

            if (isConsecutiveFour(diagonal) != null) {
                int[][] result = new int[4][2];
                int k = isConsecutiveFour(diagonal);
                result[0][0] = k + i;
                result[1][0] = k + i + 1;
                result[2][0] = k + i + 2;
                result[3][0] = k + i + 3;
                result[0][1] = numberOfColumns - k - 1;
                result[1][1] = numberOfColumns - (k + 1) - 1;
                result[2][1] = numberOfColumns - (k + 2) - 1;
                result[3][1] = numberOfColumns - (k + 3) - 1;
                return result;
            }
        }

        return null;
    }

    public static Integer isConsecutiveFour(int[] values) {
        for (int i = 0; i < values.length - 3; i++) {
            boolean isEqual = true;
            for (int j = i; j < i + 3; j++) {
                if (values[j] != values[j + 1]) {
                    isEqual = false;
                    break;
                }
            }

            if (isEqual) return new Integer(i);
        }

        return null;
    }
}
