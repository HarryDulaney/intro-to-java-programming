package ch_07;

import java.util.Arrays;

/**
 * **7.24 (Simulation: coupon collector’s problem) Coupon collector is a classic statistics
 * problem with many practical applications. The problem is to pick objects from
 * a set of objects repeatedly and find out how many picks are needed for all the
 * objects to be picked at least once.
 * <p>
 * A variation of the problem is to pick cards from
 * a shuffled deck of 52 cards repeatedly and find out how many picks are needed
 * before you see one of each suit.
 * <p>
 * Assume a picked card is placed back in the deck
 * before picking another.
 * <p>
 * Write a program to simulate the number of picks needed
 * to get four cards from each suit and display the four cards picked (it is possible a
 * card may be picked twice).
 * <p>
 * Here is a sample run of the program:
 * Queen of Spades
 * 5 of Clubs
 * Queen of Hearts
 * 4 of Diamonds
 * Number of picks: 12
 */
public class Exercise07_24 {
    public static void main(String[] args) {
        /* 1-13 : Hearts; 14-26: Diamonds; 27-39: Clubs; 40-52: Spades */
        int[] deck = getShuffledDeck();
        // 0:Hearts; 1:Diamonds; 2:Clubs, 3:Spades
        int[] suits = new int[4];

        int numPicks = 0;
        while (suits[0] != 1 || suits[1] != 1 || suits[2] != 1 || suits[3] != 1) {
            int card = pickACard(deck);
            printCard(card);
            numPicks++;

            if (card >= 1 && card <= 13) {
                suits[0] = 1;
            } else if (card >= 14 && card <= 26) {
                suits[1] = 1;
            } else if (card >= 27 && card <= 39) {
                suits[2] = 1;
            } else if (card >= 40) {
                suits[3] = 1;
            }
        }
        System.out.println("Number of picks: " + numPicks);
    }

    static void printCard(int card) {
        String suit = "";
        if (card >= 1 && card <= 13) {
            suit += "Hearts\n";
        } else if (card >= 14 && card <= 26) {
            suit += "Diamonds\n";
        } else if (card >= 27 && card <= 39) {
            suit += "Clubs\n";
        } else if (card >= 40) {
            suit += "Spades\n";
        }
        if (card > 13) {
            while (card >= 13) {
                card -= 13;
            }
        }

        String value = "";
        switch (card) {
            case 1:
                value += "Ace of ";
                break;
            case 11:
                value += "Jack of ";
                break;
            case 12:
                value += "Queen of ";
                break;
            case 13:
                value += "King of ";
                break;
            default:
                value = card + " of ";

        }

        System.out.print(value + suit);

    }

    static int pickACard(int[] deck) {
        return deck[(int) (Math.random() * 52)];
    }

    static int[] getShuffledDeck() {
        int[] dck = new int[52];

        for (int i = 0; i < 52; i++) {
            dck[i] = (i + 1);// i + 1 so that deck[0] == 1 and deck[51] = 52
        }
        //Shuffle the deck
        for (int i = 0; i < 260; i++) {
            int random1 = (int) (Math.random() * 52);
            int random2 = (int) (Math.random() * 52);
            int temp = dck[random1];
            dck[random1] = dck[random2];
            dck[random2] = temp;
        }

        return dck;
    }
}