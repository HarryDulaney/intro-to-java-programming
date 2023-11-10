package ch_03;

import java.util.*;

/**
 * **3.24 (Game: pick a card)
 * Write a program that simulates picking a card from a deck
 * of 52 cards. Your program should display the rank (Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10,
 * Jack, Queen, King) and suit (Clubs, Diamonds, Hearts, Spades) of the card.
 * <p>
 * Here is a sample run of the program:
 * <p>
 * The card you picked is Jack of Hearts
 */
public class Exercise03_24 {

    private static String card = "";
    private static String suit = "";

    public static void main(String[] args) {
        int randomCardNumber = new Random().nextInt(53);
        // 0 is not a valid card number
        if(randomCardNumber == 0) {
            randomCardNumber = 1;
        }
        System.out.println("Random card whole number is: " + randomCardNumber);
        setCardFromRandomNumber(randomCardNumber);
        System.out.println("The card you picked is " + card + " of " + suit);

    }

    static void setCardFromRandomNumber(int randomCardNumber) {
        if (randomCardNumber <= 13) {
            suit = "Clubs";
        } else if (randomCardNumber <= 26) {
            suit = "Diamonds";
        } else if (randomCardNumber <= 39) {
            suit = "Hearts";
        } else {
            suit = "Spades";
        }

        card = getCardValue(randomCardNumber);
    }

    static String getCardValue(int randomCardNumber) {
        int cardValue = randomCardNumber % 13; // Remove the suit from the card number
        if (cardValue == 1) {
            return "Ace";
        } else if (cardValue == 11) {
            return "Jack";
        } else if (cardValue == 12) {
            return "Queen";
        } else if (cardValue == 0) { // 13 % 13 = 0
            return "King";
        } else {
            return String.valueOf(cardValue);
        }
    }
}