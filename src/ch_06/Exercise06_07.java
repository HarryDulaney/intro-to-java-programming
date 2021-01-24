package ch_06;

import java.util.*;

/**
 * *6.7 (Financial application: compute the future investment value) Write a method that
 * computes future investment value at a given interest rate for a specified number
 * of years. The future investment is determined using the formula in Programming
 * Exercise 2.21.
 * <p><br>
 * {@code
 * 2.21(Financial application: calculate future investment value) Write a
 * * program that reads in investment amount, annual interest rate, and number of
 * * years, and displays the future investment value using the following formula:
 * *
 * * futureInvestmentValue = investmentAmount * (1 +
 * * monthlyInterestRate)^numberOfYears*12
 * *
 * * For example, if you enter amount 1000, annual interest rate 3.25%, and number
 * * of years 1, the future investment value is 1032.98. Here is a sample run:
 * *
 * * Enter investment amount: 1000.56 Enter annual interest rate in percentage:
 * * 4.25 Enter number of years: 1 Accumulated value is $1043.92}</p><br>
 * Use the following method header:
 * public static double futureInvestmentValue(
 * double investmentAmount, double monthlyInterestRate, int years)
 * For example, futureInvestmentValue(10000, 0.05/12, 5) returns
 * 12833.59.
 * Write a test program that prompts the user to enter the investment amount (e.g.,
 * 1000) and the interest rate (e.g., 9%) and prints a table that displays future value
 * for the years from 1 to 30, as shown below:
 * The amount invested: 1000
 * Annual interest rate: 9
 * <p>
 * Years Future Value
 * 1 1093.80
 * 2 1196.41
 * ...
 * 29 13467.25
 * 30 14730.57
 */
public class Exercise06_07 {
    static final int firstYear = 1;
    static final int lastYear = 30;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the amount invested: ");
        double amount = in.nextDouble();

        System.out.println("The Annual interest rate as (ex: 5.25 for 5.25%:):  ");
        double yearRate = in.nextDouble();
        yearRate /= 100;

        double monthRate = yearRate / 12;

        System.out.println("Years --- Future Value ");

        for (int i = firstYear; i <= lastYear; i++) {
            System.out.print(i);
            System.out.printf("      %.2f", futureInvestmentValue(amount, monthRate, i));
            System.out.println();
        }

        in.close();
    }


    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);
    }
}