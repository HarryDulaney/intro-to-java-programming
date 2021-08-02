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
    public static void main(String[] args) {

        String card = "";
        String suit = "";
        String[] cards = new String[]{"Ace", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};

        int randomCard, randomSuit;
        randomCard = new Random().nextInt(13);
        randomSuit = new Random().nextInt(5);

        System.out.println("The card you picked is " + cards[randomCard] + " of " + suits[randomSuit]);

    }
}