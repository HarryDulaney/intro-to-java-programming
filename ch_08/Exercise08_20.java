package ch_08;

import java.util.*;

/**
 * ***8.20 (Game: connect four) Connect four is a two-player board game in which the
 * players alternately drop colored disks into a seven-column, six-row vertically
 * suspended grid, as shown below.
 * The objective of the game is to connect four same-colored disks in a row, a column, or a diagonal before your opponent can do likewise. The program prompts
 * two players to drop a red or yellow disk alternately. In the preceding figure, the
 * red disk is shown in a dark color and the yellow in a light color. Whenever a disk
 * is dropped, the program will redisplay the board on the console and determines the
 * status of the game (win, draw, or continue).
 * <p>
 * Here is a sample run:
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * ———————————————
 * * Drop a red disk at column (0–6): 0
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * |R| | | | | | |
 * ———————————————
 * Drop a yellow disk at column (0–6): 3
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * | | | | | | | |
 * |R| | |Y| | | |
 * . . .
 * . . .
 * . . .
 * Drop a yellow disk at column (0–6): 6
 * | | | | | | | |
 * | | | | | | | |
 * | | | |R| | | |
 * | | | |Y|R|Y| |
 * | | |R|Y|Y|Y|Y|
 * |R|Y|R|Y|R|R|R|
 * ———————————————
 * The yellow player won
 *
 * @author Harry D.
 */
public class Exercise08_20 {
    private static final String RED = "R";
    private static final String YELLOW = "Y";
    private static final String WIN = "win";
    private static final String CONTINUE = "continue";
    private static final String DRAW = "draw";
    private static final String EMPTY = " ";
    private static final String DASH = "-";
    private static final String SEP = "|";

    static boolean turn = true; //false is reds turn

    public static void main(String[] args) {
        int numMoves = 0;
        String[][] board = new String[6][7];
        for (String[] strings : board) {
            Arrays.fill(strings, EMPTY);
        }
        Scanner in = new Scanner(System.in);
        String result = CONTINUE; //Initialize result of a move
        while (true) {
            turn = !turn; //Other players turn
            int move = printBoard(board, turn ? YELLOW : RED, in);
            playerMove(move, board, turn ? YELLOW : RED);
            result = evaluateGame(board);
            if (result.equals(WIN)) {
                printBoard(board);
                if (turn) { // Yellow won
                    System.out.println("The yellow player won.");
                } else { // Red Won
                    System.out.println("The red player won.");
                }
                break;
            } else if (result.equals(DRAW)) {
                System.out.println("The game is a draw.");
            }

        }

    }

    static void playerMove(int column, String[][] board, String player) {

        for (int r = (board.length - 1); r >= 0; r--) {
            String val = board[r][column];
            if (val.equals(EMPTY)) {
                board[r][column] = player;
                break;
            }
        }

    }

    static String evaluateGame(String[][] board) {
        int redPoints;
        int yellowPoints = 0;

        /* Check rows */
        for (int r = 0; r < board.length; r++) {
            redPoints = 0;
            yellowPoints = 0;
            for (int c = 0; c < board[r].length; c++) {
                String g = board[r][c];
                if (!g.equals(EMPTY)) {
                    if (g.equals(RED)) {
                        redPoints++;
                        yellowPoints = 0;
                    } else if (g.equals(YELLOW)) {
                        yellowPoints++;
                        redPoints = 0;
                    }
                    if (redPoints >= 4) {
                        return WIN;
                    } else if (yellowPoints >= 4) {
                        return WIN;
                    }
                } else {
                    redPoints = 0;
                    yellowPoints = 0;
                }
            }


        }

        /* Check Columns */
        for (int c = 0; c < board[0].length; c++) {
            redPoints = 0;
            yellowPoints = 0;
            for (int r = 0; r < board.length; r++) {
                String g = board[r][c];
                if (!g.equals(EMPTY)) {
                    if (g.equals(RED)) {
                        redPoints++;
                        yellowPoints = 0;
                    } else if (g.equals(YELLOW)) {
                        yellowPoints++;
                        redPoints = 0;
                    }
                    if (redPoints >= 4) {
                        return WIN;
                    }
                    if (yellowPoints >= 4) {
                        return WIN;
                    }

                } else {
                    redPoints = 0;
                    yellowPoints = 0;
                }
            }
        }


        /* Check Diagonals */
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                String g = board[r][c];
                if (!g.equals(EMPTY)) {
                    if (g.equals(RED)) {
                        redPoints = 1;
                        /* Check down and right diagonal */
                        for (int d = 1; (r + d) < board.length && (c + d) < board[r].length; d++) {
                            if (board[r + d][c + d].equals(RED)) {
                                redPoints++;
                            } else {
                                break;
                            }
                            if (redPoints == 4) {
                                return WIN;
                            }
                        }
                        redPoints = 1;
                        /* Check up and right diagonal */
                        for (int d = 1; (r - d) >= 0 && (c + d) < board[r].length; d++) {
                            if (board[r - d][c + d].equals(RED)) {
                                redPoints++;
                            } else {
                                break;
                            }
                            if (redPoints == 4) {
                                return WIN;
                            }
                        }
                        redPoints = 1;
                        /* Check down and left diagonal */
                        for (int d = 1; (r + d) < board.length && (c - d) >= 0; d++) {
                            if (board[r + d][c - d].equals(RED)) {
                                redPoints++;
                            } else {
                                break;
                            }
                            if (redPoints == 4) {
                                return WIN;
                            }
                        }
                        redPoints = 1;
                        /* Check up and left diagonal */
                        for (int d = 1; (r - d) >= 0 && (c - d) >= 0; d++) {
                            if (board[r - d][c - d].equals(RED)) {
                                redPoints++;
                            } else {
                                break;
                            }
                            if (redPoints == 4) {
                                return WIN;
                            }
                        }
                    } else if (g.equals(YELLOW)) {
                        yellowPoints = 1;
                        /* Check down and right diagonal */
                        for (int d = 1; (r + d) < board.length && (c + d) < board[r].length; d++) {
                            if (board[r + d][c + d].equals(YELLOW)) {
                                yellowPoints++;
                            } else {
                                break;
                            }
                            if (yellowPoints == 4) {
                                return WIN;
                            }
                        }
                        yellowPoints = 1;
                        /* Check up and right diagonal */
                        for (int d = 1; (r - d) >= 0 && (c + d) < board[r].length; d++) {
                            if (board[r - d][c + d].equals(YELLOW)) {
                                yellowPoints++;
                            } else {
                                break;
                            }
                            if (yellowPoints == 4) {
                                return WIN;
                            }
                        }
                        yellowPoints = 1;
                        /* Check down and left diagonal */
                        for (int d = 1; (r + d) < board.length && (c - d) >= 0; d++) {
                            if (board[r + d][c - d].equals(YELLOW)) {
                                yellowPoints++;
                            } else {
                                break;
                            }
                            if (yellowPoints == 4) {
                                return WIN;
                            }
                        }
                        yellowPoints = 1;
                        /* Check up and left diagonal */
                        for (int d = 1; (r - d) >= 0 && (c - d) >= 0; d++) {
                            if (board[r - d][c - d].equals(YELLOW)) {
                                yellowPoints++;
                            } else {
                                break;
                            }
                            if (yellowPoints == 4) {
                                return WIN;
                            }
                        }

                    }
                }
            }
        }
        return CONTINUE;

    }

    static int printBoard(String[][] board, String player, Scanner in) {
        printBoard(board);
        System.out.print("Drop a " + (player.equals(RED) ? "red" : "yellow") + " disk at column (0" + DASH + "6): ");
        int move = in.nextInt();
        return move;
    }

    static void printBoard(String[][] board) {
        for (String[] strings : board) {
            for (String s : strings) {
                System.out.print(SEP + s);
            }
            System.out.println(SEP);
        }
        System.out.println(DASH + DASH + DASH + DASH + DASH + DASH + DASH + DASH + DASH + DASH + DASH + DASH + DASH + DASH + DASH);


    }
}