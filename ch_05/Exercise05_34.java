package ch_05;

import java.util.*;

/**
 * ***5.34 (Game: scissor, rock, paper) Programming Exercise 3.17 gives a program that
 * plays the scissor-rock-paper game. Revise the program to let the user continuously play
 * until either the user or the computer wins more than two times than its
 * opponent
 */
public class Exercise05_34 {
    public static void main(String[] args) {

        int compWins = 0;
        int userWins = 0;

        while (userWins != compWins * 2 && compWins != userWins * 2 || userWins == 0 && compWins == 0) {
            int computerHand = (int) (Math.random() * 3);
            Scanner input = new Scanner(System.in);

            System.out.print("Enter 0 for scissor, 1 for rock, 2 for paper: ");
            int playerHand = input.nextInt();

            String computer = getHand(computerHand);
            String player = getHand(playerHand);
            String gameStats = getGameStatus(computerHand, playerHand);

            if (gameStats.equals("You won")) userWins++;

            if (gameStats.equals("You lost")) compWins++;

            System.out.println("The computer is " + computer + ". You are " + player + ". " + gameStats + ".");

        }

        if (userWins > compWins) {
            System.out.println("You WON the game! " + "User wins: " + userWins + " Computer wins: " + compWins);
        } else {
            System.out.println("You LOST the game! " + "User wins: " + userWins + " Computer wins: " + compWins);

        }

    }

    public static String getHand(int hand) {

        String handString;
        switch (hand) {
            case 0:
                handString = "scissor";
                break;
            case 1:
                handString = "rock";
                break;
            case 2:
                handString = "paper";
                break;
            default:
                handString = null;
        }
        return handString;
    }

    public static String getGameStatus(int computer, int player) {
        if (computer == player) return "It's a draw";

        String status = "";
        switch (player) {
            case 0:
                status = (computer != 1) ? "You won" : "You lost";
                break;
            case 1:
                status = (computer != 2) ? "You won" : "You lost";
                break;
            case 2:
                status = (computer != 0) ? "You won" : "You lost";
                break;
        }

        return status;
    }
}