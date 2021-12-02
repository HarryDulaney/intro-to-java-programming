package ch_06;

/**
 * **6.32 (Game: chance of winning at craps) Revise Exercise 6.30 to run it 10,000 times
 * and display the number of winning games.
 *
 * @author Harry D.
 */
public class Exercise06_32 {
    static int wins = 0;

    public static void main(String[] args) {
        startGames(10000);
        System.out.println("Played 10,000 games of craps and won " + wins + " times.");

    }

    static int roleDie1() {
        return (int) (1 + Math.random() * 7);
    }

    static int roleDie2() {
        return (int) (1 + Math.random() * 7);

    }

    static void startGames(int iterations) {
        for (int i = 0; i < iterations; i++) {
            int point = 0;
            int rolled = roleDie1() + roleDie2();
            String res = checkResult(rolled);

            if (res.equalsIgnoreCase("point")) {
                point = rolled;
                int rolling = 0;
                while (rolling != 7) {
                    rolling = roleDie1() + roleDie2();

                    if (rolling == point) {
                        wins++;
                        break;
                    } else if (rolling == 7) {
                        break;
                    }
                }

            } else if (res.equalsIgnoreCase("natural")) {
                wins++;
            }
        }
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