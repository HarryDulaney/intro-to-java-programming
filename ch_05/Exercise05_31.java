package ch_05;

import java.util.*;

/**
 * *5.31 (Financial application: compute CD value) Suppose you put $10,000 into a CD
 * with an annual percentage yield of 5.75%. After one month, the CD is worth
 * 10000 + 10000 * 5.75 / 1200 = 10047.92
 * After two months, the CD is worth
 * 10047.91 + 10047.91 * 5.75 / 1200 = 10096.06
 * After three months, the CD is worth
 * 10096.06 + 10096.06 * 5.75 / 1200 = 10144.44
 * and so on.
 * Write a program that prompts the user to enter an amount (e.g., 10000), the
 * annual percentage yield (e.g., 5.75), and the number of months (e.g., 18) and
 * displays a table as shown in the sample run.
 */
public class Exercise05_31 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the initial deposit amount: ");
        double deposit = input.nextDouble();

        System.out.print("Enter annual percentage yield: ");
        double annualInterestRate = input.nextDouble();
        double monthlyInterestRate = annualInterestRate / 1200.0;

        System.out.print("Enter maturity period in months: ");
        double numberOfMonths = input.nextInt();

        System.out.print("Months\t\t\tCD Value\n");
        double amountInAccount = deposit;
        for (int i = 1; i <= numberOfMonths; i++) {
            amountInAccount *= (1.0D + monthlyInterestRate);
            System.out.printf("%5d%20.2f\n", i, amountInAccount);
        }
    }
}