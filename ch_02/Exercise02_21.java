package ch_02;

import java.util.Scanner;

/**
 * *2.21(Financial application: calculate future investment value) Write a
 * program that reads in investment amount, annual interest rate, and number of
 * years, and displays the future investment value using the following formula:
 * <p>
 * futureInvestmentValue = investmentAmount * (1 +
 * monthlyInterestRate)^numberOfYears*12
 * <p>
 * For example, if you enter amount 1000, annual interest rate 3.25%, and number
 * of years 1, the future investment value is 1032.98. Here is a sample run:
 * <p>
 * Enter investment amount: 1000.56 Enter annual interest rate in percentage:
 * 4.25 Enter number of years: 1 Accumulated value is $1043.92
 */
public class Exercise02_21 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double investmentAmount = in.nextDouble();

        System.out.print("Enter annual interest rate in percentage: ");
        double monthInterestRate = in.nextDouble();

        System.out.print("Enter number of years: ");
        double years = in.nextInt();

//		futureInvestmentValue = investmentAmount * (1 + monthlyInterestRate)^(numberOfYears*12)

        years *= 12;
        monthInterestRate /= 1200; //Convert from yearly to monthly and from percent to decimal

        System.out.printf("Accumulated Value is $%.2f",
                investmentAmount * Math.pow(monthInterestRate + 1, years));
        in.close();

    }

}
