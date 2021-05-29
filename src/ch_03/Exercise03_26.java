package ch_03;

import java.util.*;

/**
 * 3.26 (Use the &&, || and ^ operators)
 * Write a program that prompts the user to enter
 * an integer and determines whether it is divisible by 5 and 6, whether it is divisible
 * by 5 or 6, and whether it is divisible by 5 or 6, but not both. Here is a sample run
 * of this program:
 * <p>
 * Enter an integer: 10
 * Is 10 divisible by 5 and 6? false
 * Is 10 divisible by 5 or 6? true
 * Is 10 divisible by 5 or 6, but not both? true
 */
public class Exercise03_26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int userInt = in.nextInt();

        boolean fiveAndSix = userInt % 5 == 0 && userInt % 6 == 0;
        boolean fiveOrSix = userInt % 5 == 0 || userInt % 6 == 0;
        boolean fiveSixNotBoth = (userInt % 5 == 0 || userInt % 6 == 0) ^ (userInt % 5 == 0 && userInt % 6 == 0);

        System.out.println("Is " + userInt + " divisible by 5 and 6? " + fiveAndSix);
        System.out.println("Is " + userInt + " divisible by 5 or 6? " + fiveOrSix);
        System.out.println("Is " + userInt + " divisible by 5 or 6, but not both? " + fiveSixNotBoth);


    }
}