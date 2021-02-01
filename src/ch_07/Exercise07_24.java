package ch_07;

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
        /* 0-12 : Hearts; 13-25: Diamonds; 26-38: Clubs; 39-51: Spades */
        int[] deck = getShuffledDeck();
        int[] suits = new int[4];// 0:Hearts; 1:Diamonds; 2:Clubs, 3:Spades
        int numPicks = 0;
        int card = -1;
        while (suits[0] == 0 || suits[1] == 0 || suits[2] == 0 || suits[3] == 0) {
            card = pickACard(deck);
            printCard(card);
            numPicks++;

            if (card >= 0 && card <= 12) {
                suits[0] = 1;
            } else if (card >= 13 && card <= 25) {
                suits[1] = 1;
            } else if (card >= 26 && card <= 38) {
                suits[2] = 1;
            } else if (card >= 39) {
                suits[3] = 1;
            }
        }
        System.out.println("Number of picks: " + numPicks);
    }

    static void printCard(int card) {
        if (card == 0 || card == 13 || card == 26 || card == 39) {
            System.out.print("Ace of ");
        } else if (card == 10 || card == 23 || card == 36 || card == 49) {
            System.out.print("Jack of ");
        } else if (card == 11 || card == 24 || card == 37 || card == 50) {
            System.out.print("Queen of ");
        } else if (card == 12 || card == 25 || card == 38 || card == 51) {
            System.out.print("King of ");
        }
        if (card >= 0 && card <= 12) {
            System.out.print("Hearts\n");

        } else if (card >= 13 && card <= 25) {
            System.out.print("Diamonds\n");


        } else if (card >= 26 && card <= 38) {
            System.out.print("Clubs\n");


        } else if (card >= 39) {
            System.out.print("Spades\n");


        }

    }

    static int pickACard(int[] deck) {
        return deck[(int) (Math.random() * 52)];
    }

    static int[] getShuffledDeck() {
        int[] dck = new int[52];

        for (int i = 0, card = 1; i < 52; i++) {
            dck[i] = card++;

            if (card % 13 == 0) {
                card = 1;
            }


        }
        return dck;

    }
}