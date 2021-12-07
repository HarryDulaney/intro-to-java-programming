package ch_08;

import java.util.*;

/**
 * ***8.9 (Game: play a tic-tac-toe game) In a game of tic-tac-toe, two players
 * take turns marking an available cell in a 3 * 3 grid with their respective
 * tokens (either X or O). When one player has placed three tokens in a
 * horizontal, vertical, or diagonal row on the grid, the game is over and that
 * player has won. A draw (no winner) occurs when all the cells on the grid have
 * been filled with tokens and neither player has achieved a win. Create a
 * program for playing tic-tac-toe. The program prompts two players to enter an
 * X token and O token alternately. Whenever a token is entered, the program
 * redisplays the board on the console and determines the status of the game
 * (win, draw, or continue). Here is a sample run:
 * <p>
 * ——————-——————
 * |   |   |   |
 * ——————-——————
 * |   |   |   |
 * ——————-——————
 * |   |   |   |
 * ——————-——————
 * Enter a row (0, 1, or 2) for player X: 1
 * Enter a column (0, 1, or 2) for player X: 1
 * ——————-——————
 * |   |   |   |
 * ——————-——————
 * |   | X |   |
 * ——————-——————
 * |   |   |   |
 * ——————-——————
 * Enter a row (0, 1, or 2) for player O: 1
 * Enter a column (0, 1, or 2) for player O: 2
 * ——————-——————
 * |   |   |   |
 * ——————-——————
 * |   | X | O |
 * ——————-——————
 * |   |   |   |
 * ——————-——————
 * <p>
 * Enter a row (0, 1, or 2) for player X:
 * . . .
 * ——————-——————
 * | X |   |   |
 * ——————-——————
 * | O | X | O |
 * ——————-——————
 * |   |   | X |
 * ——————-——————
 * X player won
 */
public class Exercise08_09 {
    private static final String USER_X_ID = "X";
    private static final String USER_O_ID = "O";
    static final String IN_PROMPT_ROW = "Enter a row (0, 1, or 2) for player";
    static final String IN_PROMPT_COLUMN = "Enter a column (0, 1, or 2) for player";
    static String[][] boxes;
    static String nextMove;
    static String currentMove;
    static boolean blank;
    static final String verticalLine = "——————-——————\r\n";
    static String status;
    static String winner;
    static int totalMoves = 9;

    static {
        boxes = new String[][]{{"", "", ""},
                {"", "", ""},
                {"", "", ""}}; //Tic tac toe board empty
        nextMove = USER_X_ID;
        status = "continue";
        blank = true;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = 0, col = 0;
        System.out.print("Welcome to Tic Tac Toe!\n");
        while (status.equals("continue")) {
            if (blank) {
                printBlankBoard();
                blank = false;
            } else {
                printGameBoard();
            }
            System.out.print(IN_PROMPT_ROW + " " + nextMove + ":");
            row = in.nextInt();
            System.out.print(IN_PROMPT_COLUMN + " " + nextMove + ":");
            col = in.nextInt();
            if ((col == 0 || col == 1 || col == 2) && (row == 0 || row == 1 || row == 2)) {
                addMove(row, col);
            } else {
                System.out.println("You entered an invalid character player " + nextMove + " enter a 0, 1, or 2 next time...");
            }
        }
        if (status.equals("win")) {
            //WIN
            printGameBoard();
            System.out.print("\nPlayer " + winner + " won!");
        } else {
            //DRAW
            System.out.println("The match is a draw!!");
        }

    }

    //Add players move to the boxes array and test win condition
    static void addMove(int markRow, int markCol) {
        if (boxes[markRow][markCol].equals("")) {
            boxes[markRow][markCol] = nextMove;
            totalMoves--;
        } else {
            System.out.println("Nice try, you can only enter your mark in an empty box...");
        }

        if (checkWinner()) {
            status = "win";
        } else if (totalMoves < 1) {
            status = "draw";
        }
    }

    private static void printGameBoard() {

        for (int i = 0; i < 3; i++) {
            System.out.print(verticalLine);
            for (int j = 0; j < 3; j++) {
                if (boxes[i][j].equals("")) {
                    System.out.print("|   ");
                } else {
                    System.out.print("| ");
                    System.out.print(boxes[i][j]);
                    System.out.print(" ");
                }
            }
            System.out.print("|\r\n"); // Last piece of bottom right box
        }
        System.out.println(verticalLine);//Bottom line t-t-t board

        nextMove = nextMove.equals(USER_X_ID) ? USER_O_ID : USER_X_ID;
    }

    //Runs first iteration of main while loop
    static void printBlankBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.print(verticalLine);
            for (int j = 0; j < 3; j++) {
                System.out.print("|   ");
            }
            System.out.print("|\r\n");
        }
        System.out.println(verticalLine);//Bottom line t-t-t board
    }

    //Iterate boxes array's and determine which player, if any, is the winner
    static boolean checkWinner() {
        boolean won = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(boxes[i][j].equals(""))) {
                    if (boxes[i][j].equals("X")) {
                        if (boxes[0][0].equals("X") && boxes[0][1].equals("X") && boxes[0][2].equals("X") ||
                                boxes[1][0].equals("X") && boxes[1][1].equals("X") && boxes[1][2].equals("X") ||
                                boxes[2][0].equals("X") && boxes[2][1].equals("X") && boxes[2][2].equals("X") ||
                                boxes[0][0].equals("X") && boxes[1][0].equals("X") && boxes[2][0].equals("X") ||
                                boxes[0][1].equals("X") && boxes[1][1].equals("X") && boxes[2][1].equals("X") ||
                                boxes[0][2].equals("X") && boxes[1][2].equals("X") && boxes[2][2].equals("X") ||
                                boxes[0][0].equals("X") && boxes[1][1].equals("X") && boxes[2][2].equals("X") ||
                                boxes[0][2].equals("X") && boxes[1][1].equals("X") && boxes[2][0].equals("X")) {
                            winner = "X";
                            won = true;
                        }

                    } else {
                        if (boxes[0][0].equals("O") && boxes[0][1].equals("O") && boxes[0][2].equals("O") ||
                                boxes[1][0].equals("O") && boxes[1][1].equals("O") && boxes[1][2].equals("O") ||
                                boxes[2][0].equals("O") && boxes[2][1].equals("O") && boxes[2][2].equals("O") ||
                                boxes[0][0].equals("O") && boxes[1][0].equals("O") && boxes[2][0].equals("O") ||
                                boxes[0][1].equals("O") && boxes[1][1].equals("O") && boxes[2][1].equals("O") ||
                                boxes[0][2].equals("O") && boxes[1][2].equals("O") && boxes[2][2].equals("O") ||
                                boxes[0][0].equals("O") && boxes[1][1].equals("O") && boxes[2][2].equals("O") ||
                                boxes[0][2].equals("O") && boxes[1][1].equals("O") && boxes[2][0].equals("O")) {
                            winner = "O";
                            won = true;
                        }


                    }


                }

            }
        }

        return won;

    }

} 