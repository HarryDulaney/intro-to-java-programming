package ch_03;

import java.util.Scanner;

/**
 * **3.15 (Game: lottery) Revise Listing 3.8, Lottery.java, to generate a
 * lottery of a three digit number.
 * <p>
 * The program prompts the user to enter a three-digit number and determines
 * whether the user wins according to the following rules:
 * <p>
 * 1. If the user input matches the lottery number in the exact order, the award
 * is $10,000.
 * <p>
 * 2.If all digits in the user input match all digits in the lottery number, the
 * award is $3,000.
 * <p>
 * 3. If one digit in the user input matches a digit in the lottery number, the
 * award is $1,000
 */
public class Exercise03_15 {
    public static void main(String[] args) {

        int lottery = (int) (Math.random() * 1000);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your lottery pick as an integer of three digits: ");

        int guess = input.nextInt();

        int l1 = lottery / 100;
        int l2 = lottery % 100;
        int l3 = l2 / 10;
        l2 %= 10;

        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);
        System.out.println("l3 = " + l3);

        int g1 = guess / 100;
        int g2 = guess % 100;
        int g3 = g2 / 10;
        g2 %= 10;

        System.out.println("g1 = " + g1);
        System.out.println("g2 = " + g2);
        System.out.println("g3 = " + g3);

        System.out.println("The lottery number is " + lottery);
        String result = "";

        if (guess == lottery) {
            result += "Exact match: you win $10,000";
        } else if ((g1 == l1 || g1 == l2 || g1 == l3) && (g2 == l1 || g2 == l2 || g2 == l3)
                && (g3 == l1 || g3 == l2 || g3 == l3)) {
            result += "Match all digits: you win $3,000";

        } else if ((g1 == l1 || g1 == l2 || g1 == l3) && (g3 == l1 || g3 == l2 || g3 == l3)
                && (g2 == l1 || g2 == l2 || g2 == l3)) {
            result += "Match all digits: you win $3,000";

        } else if ((g2 == l1 || g2 == l2 || g2 == l3) && (g1 == l1 || g1 == l2 || g1 == l3)
                && (g3 == l1 || g3 == l2 || g3 == l3)) {
            result += "Match all digits: you win $3,000";

        } else if ((g2 == l1 || g2 == l2 || g2 == l3) && (g3 == l1 || g3 == l2 || g3 == l3)
                && (g1 == l1 || g1 == l2 || g1 == l3)) {
            result += "Match all digits: you win $3,000";

        } else if ((g3 == l1 || g3 == l2 || g3 == l3) && (g1 == l1 || g1 == l2 || g1 == l3)
                && (g2 == l1 || g2 == l2 || g2 == l3)) {
            result += "Match all digits: you win $3,000";

        } else if ((g3 == l1 || g3 == l2 || g3 == l3) && (g2 == l1 || g2 == l2 || g2 == l3)
                && (g1 == l1 || g1 == l2 || g1 == l3)) {

            result += "Match all digits: you win $3,000";

        } else if (g1 == l1 || g1 == l2 || g1 == l3 || g2 == l1 || g2 == l2 || g2 == l3 || g3 == l1 || g3 == l2
                || g3 == l3) {

            result += "Match one digit: you win $1,000";

        } else {
            result += "Sorry no match, play again!!!";
        }
        System.out.println(result);
        input.close();

    }

}
