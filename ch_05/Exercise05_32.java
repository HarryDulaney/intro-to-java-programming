package ch_05;

import java.util.*;

/**
 * **5.32 (Game: lottery) Revise Listing 3.8, Lottery.java, to generate a lottery of a two digit number.
 * The two digits in the number are distinct. (Hint: Generate the first
 * digit. Use a loop to continuously generate the second digit until it is different
 * from the first digit.)
 */
public class Exercise05_32 {
    public static void main(String[] args) {

        int lottery;
        int lotteryDigit1;
        int lotteryDigit2;
        do {
            lottery = 10 + (int) (Math.random() * 90);

            // Get digits from lottery
            lotteryDigit1 = lottery / 10;
            lotteryDigit2 = lottery % 10;
        } while (lotteryDigit1 == lotteryDigit2);

        System.out.println(lotteryDigit1 + " " + lotteryDigit2 + " " + lottery);

        // Prompt the user to enter a guess
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your lottery pick (two digits): ");
        int guess = input.nextInt();


        // Get digits from guess
        int guessDigit1 = guess / 10;
        int guessDigit2 = guess % 10;

        System.out.println("The lottery number is " + lottery);

        // Check the guess
        if (guess == lottery)
            System.out.println("Exact match: you win $10,000");
        else if (guessDigit2 == lotteryDigit1
                && guessDigit1 == lotteryDigit2)
            System.out.println("Match all digits: you win $3,000");
        else if (guessDigit1 == lotteryDigit1
                || guessDigit1 == lotteryDigit2
                || guessDigit2 == lotteryDigit1
                || guessDigit2 == lotteryDigit2)
            System.out.println("Match one digit: you win $1,000");
        else
            System.out.println("Sorry, no match");

    }
}