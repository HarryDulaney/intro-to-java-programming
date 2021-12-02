package ch_06;

/**
 * **6.30 (Game: craps) Craps is a popular dice game played in casinos. Write a program
 * to play a variation of the game, as follows:
 * Roll two dice. Each die has six faces representing values 1, 2, …, and 6, respectively.
 * Check the sum of the two dice.
 * <p>
 * If the sum is 2, 3, or 12 (called craps), you
 * lose; if the sum is 7 or 11 (called natural), you win; if the sum is another value
 * (i.e., 4, 5, 6, 8, 9, or 10), a point is established. Continue to roll the dice until either
 * a 7 or the same point value is rolled. If 7 is rolled, you lose. Otherwise, you win.
 * Your program acts as a single player. Here are some sample runs.
 * You rolled 5 + 6 = 11
 * You win
 * You rolled 1 + 2 = 3
 * You lose
 * You rolled 4 + 4 = 8
 * point is 8
 * You rolled 6 + 2 = 8
 * You win
 * You rolled 3 + 2 = 5
 * point is 5
 * You rolled 2 + 5 = 7
 * You lose
 *
 * @author Harry D.
 */
public class Exercise06_30 {
    public static void main(String[] args) {
        int point = 0;
        System.out.println("Rolling dice.......");
        int rolled = roleDie1() + roleDie2();
        String res = checkResult(rolled);

        if (res.equalsIgnoreCase("craps")) {
            System.out.println("Craps!! Rolled a " + rolled + ". Better luck next time...");

        } else if (res.equalsIgnoreCase("point")) {
            point = rolled;
            System.out.println("Rolled " + rolled + ", point is established. Rolling again...");
            int rolling = 0;

            while (rolling != 7) {
                rolling = roleDie1() + roleDie2();
                System.out.println("You rolled a " + rolling);
                if (rolling == point) {
                    System.out.println("You Win!");
                    break;
                } else if (rolling == 7) {
                    System.out.println("You loose!");
                    break;
                }
            }

        } else if (res.equalsIgnoreCase("natural")) {
            System.out.println("Natural! You rolled a " + rolled + " you win!");
        }


    }

    static int roleDie1() {
        return (int) (1 + Math.random() * 7);
    }

    static int roleDie2() {
        return (int) (1 + Math.random() * 7);

    }

    static String checkResult(int roll) {
        if (roll == 2 || roll == 3 || roll == 12) {
            return "craps";
        } else if (roll == 7 || roll == 11) {
            return "natural";
        }
        return "point";

    }
}