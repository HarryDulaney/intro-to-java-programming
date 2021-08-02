package ch_07;

import java.util.Arrays;

/**
 * *7.29 (Game: pick four cards) Write a program that picks four cards from a deck of 52
 * cards and computes their sum. An Ace, King, Queen, and Jack represent 1, 13,
 * 12, and 11, respectively. Your program should display the number of picks that
 * yields the sum of 24.
 */
public class Exercise07_29 {

    public static void main(String[] args) {
        int[] deck = makeDeck();
        int picks = 0;
        int sum = 0;
        while (sum != 24) {
            picks++;
            sum = randomDraw4(deck);
            System.out.println("Pick #" + picks);
            System.out.println("Drew 4 cards and their sum was " + sum);
        }
        System.out.println("Drew cards " + picks + " times to yield " + sum);
    }

    private static int randomDraw4(int[] deck) {
        int card1 = deck[(int) (Math.random() * 51)]; //array of 52 cards has indexes 0 to 51
        int card2 = deck[(int) (Math.random() * 51)];
        int card3 = deck[(int) (Math.random() * 51)];
        int card4 = deck[(int) (Math.random() * 51)];

        return (card1 + card2 + card3 + card4);
    }

    /**
     * Hearts = suiteNum == [position < 13];
     * Clubs = suiteNum == [13 < position < 26];
     * Diamonds = suiteNum == [26 < position < 39];
     * Spades = suiteNum == [39 < position];
     *
     * @return the deck of 52 cards
     */
    private static int[] makeDeck() {
        int[] deck = new int[52];
        int cardNum = 1;
        for (int i = 0; i < deck.length; i++) {
            deck[i] = cardNum;
            if (cardNum == 13) {
                cardNum = 1;
                continue;
            }
            cardNum++;

        }
        return deck;
    }

}
