package ch_07;

/**
 * *7.13 (Random number chooser) Write a method that returns a random number between
 * 1 and 54, excluding the numbers passed in the argument. The method header is
 * specified as follows:
 * public static int getRandom(int... numbers)
 */
public class Exercise07_13 {
    public static void main(String[] args) {
        System.out.println("Random number is " + getRandom(12, 13, 47));
    }

    public static int getRandom(int... numbers) {
        int randomInt = (int) (1 + Math.random() * 54);
        for (int num : numbers) {
            if (randomInt == num) {
                return getRandom(numbers);
            }
        }
        return randomInt;

    }
}