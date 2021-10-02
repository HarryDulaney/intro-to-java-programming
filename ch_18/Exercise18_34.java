package ch_18;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * **18.34 (Game: Eight Queens) The Eight Queens problem is to find a solution to place
 * a queen in each row on a chessboard such that no two queens can attack each
 * other. Write a program to solve the Eight Queens problem using recursion and
 * display the result as shown in Figure 18.17.
 */
public class Exercise18_34 extends Application {
    private static final int SIZE = 8;
    private int[] queens = new int[SIZE]; // Queen positions

    @Override
    public void start(Stage primaryStage) {
        search(0); // Search for a solution from row 0

        ChessBoard board = new ChessBoard();
        Scene scene = new Scene(board, 250, 250);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        board.paint();

    }

    /**
     * Check if a queen can be placed at row i and column j
     */
    private boolean isValid(int row, int column) {
        for (int i = 1; i <= row; i++)
            if (queens[row - i] == column // Check column
                    || queens[row - i] == column - i // Check upleft diagonal
                    || queens[row - i] == column + i) // Check upright diagonal
                return false; // There is a conflict
        return true; // No conflict
    }

    /**
     * Search for a solution starting from a specified row
     */
    private boolean search(int row) {
        if (row == SIZE) // Stopping condition
            return true; // A solution found to place 8 queens in 8 rows

        for (int column = 0; column < SIZE; column++) {
            queens[row] = column; // Place a queen at (row, column)
            if (isValid(row, column) && search(row + 1))
                return true; // Found, thus return true to exit for loop
        }

        // No solution for a queen placed at any column of this row
        return false;
    }

    private class ChessBoard extends Pane {
        Image queenImage = new Image("resources/images/queen.jpg");

        public void paint() {
            // Clear previous drawing
            this.getChildren().clear();

            // Draw the queens
            for (int i = 0; i < SIZE; i++) {
                // Add the queen image view
                ImageView queenImageView = new ImageView(queenImage);
                this.getChildren().add(queenImageView);
                int j = queens[i]; // The position of the queen in row i
                queenImageView.setX(j * getWidth() / SIZE);
                queenImageView.setY(i * getHeight() / SIZE);
                queenImageView.setFitWidth(getWidth() / SIZE);
                queenImageView.setFitHeight(getHeight() / SIZE);
            }

            // Draw the lines
            for (int i = 1; i <= SIZE; i++) {
                this.getChildren().add(
                        new Line(0, i * getHeight() / SIZE, getWidth(), i * getHeight() / SIZE));
                this.getChildren().add(
                        new Line(i * getWidth() / SIZE, 0, i * getWidth() / SIZE, getHeight()));
            }
        }
    }
}
