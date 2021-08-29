package ch_18;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * *18.32 (Game: Knight’s Tour) The Knight’s Tour is an ancient puzzle. The objective is
 * to move a knight, starting from any square on a chessboard, to every other square
 * once, as shown in Figure 18.15a. Note that the knight makes only L-shaped
 * moves (two spaces in one direction and one space in a perpendicular direction).
 * As shown in Figure 18.15b, the knight can move to eight squares.
 * <p>
 * Write a program that displays the moves for the knight, as shown in Figure 18.15c.
 * When you click a cell, the knight is placed at the cell. This cell will be starting
 * point for the knight. Clicking the Solve button to display the path for a solution.
 * <p>
 * <p>
 * (Hint: A brute-force approach for this problem is to move the knight from one
 * square to another available square arbitrarily. Using such an approach, your
 * program will take a long time to finish. A better approach is to employ some
 * heuristics. A knight has two, three, four, six, or eight possible moves, depending
 * on its location. Intuitively, you should attempt to move the knight to the least
 * accessible squares first and leave those more accessible squares open, so there
 * will be a better chance of success at the end of the search.)
 */
public class Exercise18_32 extends Application {
    private static final int SIZE = 8;
    private int startX = 0;
    private int startY = 0;
    private ArrayList<Point2D> moves = null;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        Board board = new Board();
        pane.setCenter(board);
        Button solveButton = new Button("Solve");
        pane.setBottom(solveButton);
        BorderPane.setAlignment(solveButton, Pos.CENTER);

        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        board.draw();

        solveButton.setOnAction(e -> {
            boolean[][] moves = new boolean[SIZE][SIZE];
            moves[startX][startY] = true;
            resetMoves();
            addMove(startX, startY);
            solvePuzzle(moves, 1, startX, startY);
            board.draw();
        });

    }

    private boolean solvePuzzle(boolean[][] moves, int numMoves, int x, int y) {
        int nextX = 0;
        int nextY = 0;
        int bestMoveX = 0;
        int bestMoveY = 0;
        int bestMoveX2 = 0;
        int bestMoveY2 = 0;
        int minMoveCount = SIZE;
        int moveCount = 0;

        for (int i = 2; i >= -2; i += -4) {
            for (int j = 1; j >= -1; j += -2) {
                nextX = x + i;
                nextY = y + j;
                if (nextX >= 0 && nextX <= SIZE - 1 && nextY >= 0 && nextY <= SIZE - 1
                        && !moves[nextX][nextY]) {
                    moveCount = lookAheadCount(moves, nextX, nextY);
                    if (moveCount <= minMoveCount) {
                        minMoveCount = moveCount;
                        bestMoveX2 = bestMoveX;
                        bestMoveY2 = bestMoveY;
                        bestMoveX = nextX;
                        bestMoveY = nextY;
                    }
                }

                nextX = x + j;
                nextY = y + i;
                if (nextX >= 0 && nextX <= SIZE - 1 && nextY >= 0 && nextY <= SIZE - 1
                        && !moves[nextX][nextY]) {
                    moveCount = lookAheadCount(moves, nextX, nextY);
                    if (moveCount <= minMoveCount) {
                        minMoveCount = moveCount;
                        bestMoveX2 = bestMoveX;
                        bestMoveY2 = bestMoveY;
                        bestMoveX = nextX;
                        bestMoveY = nextY;
                    }
                }
            }
        }
        moves[bestMoveX][bestMoveY] = true;
        addMove(bestMoveX, bestMoveY);
        numMoves++;
        if (numMoves == (SIZE * SIZE))
            return true;
        if (moveCount > 0 && solvePuzzle(moves, numMoves, bestMoveX, bestMoveY)) {
            return true;
        }
        moves[bestMoveX][bestMoveY] = false;
        moves[bestMoveX2][bestMoveY2] = true;
        removeLastMoveHistory();
        addMove(bestMoveX2, bestMoveY2);
        if (moveCount > 1 && solvePuzzle(moves, numMoves, bestMoveX2, bestMoveY2)) {
            return true;
        }
        moves[bestMoveX2][bestMoveY2] = false;
        removeLastMoveHistory();
        numMoves--;
        return false;
    }

    private int lookAheadCount(boolean[][] moves, int x, int y) {
        int maxCount = 0;
        for (int i = -2; i <= 2; i += 4) {
            for (int j = -1; j <= 1; j += 2) {
                int nextX = x + i;
                int nextY = y + j;
                if (nextX >= 0 && nextX <= SIZE - 1 && nextY >= 0 && nextY <= SIZE - 1
                        && !moves[nextX][nextY]) {
                    maxCount++;
                }

                nextX = x + j;
                nextY = y + i;
                if (nextX >= 0 && nextX <= SIZE - 1 && nextY >= 0 && nextY <= SIZE - 1
                        && !moves[nextX][nextY]) {
                    maxCount++;
                }
            }
        }
        return maxCount;
    }

    public void resetMoves() {
        moves = new ArrayList(63);
    }

    public void addMove(int x, int y) {
        moves.add(new Point2D(x, y));
    }

    public void removeLastMoveHistory() {
        moves.remove(moves.size() - 1);
    }

    private class Board extends Pane {
        ImageView theKnight = new ImageView("resources/images/knight.jpg");

        Board() {
            this.setOnMouseClicked(e -> {
                startX = (int) (e.getX() / (getWidth() / SIZE));
                startY = (int) (e.getY() / (getHeight() / SIZE));
                resetMoves();
                draw();
            });
        }

        protected void draw() {
            this.getChildren().clear();

            this.getChildren().add(theKnight);
            theKnight.setX(startX * getWidth() / SIZE);
            theKnight.setY(startY * getHeight() / SIZE);
            theKnight.setFitWidth(getWidth() / SIZE);
            theKnight.setFitHeight(getHeight() / SIZE);

            for (int i = 1; i <= SIZE; i++) {
                this.getChildren().add(
                        new Line(0, i * getHeight() / SIZE, getWidth(), i * getHeight() / SIZE));
                this.getChildren().add(
                        new Line(i * getWidth() / SIZE, 0, i * getWidth() / SIZE, getHeight()));
            }

            if (moves != null) {
                for (int i = 1; i < moves.size(); i++) {
                    Point2D p1 = moves.get(i - 1);
                    Point2D p2 = moves.get(i);
                    this.getChildren().add(
                            new Line(p1.getX() * (getWidth() / SIZE) + getWidth() / SIZE / 2,
                                    p1.getY() * (getHeight() / SIZE) + (getHeight() / SIZE / 2),
                                    p2.getX() * (getWidth() / SIZE) + getWidth() / SIZE / 2,
                                    p2.getY() * (getHeight() / SIZE) + getHeight() / SIZE / 2));
                }
            }
        }
    }
}
