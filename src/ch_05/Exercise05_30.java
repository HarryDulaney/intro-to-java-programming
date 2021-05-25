package ch_05;

import java.util.Scanner;

/**
 * 5.30 (Financial application: compound value) Suppose you save $100
 * each month into a savings account with the annual interest rate 5%.
 * So, the monthly interest rate is 0.05 / 12 = 0.00417. After the first
 * month, the value in the account becomes.
 * Write a program that prompts the user to enter an amount (e.g., 100)
 * the annual interest rate (e.g., 5), and the number of months (e.g., 6)
 * and displays the amount in the savings account after the given month.
 */
public class Exercise05_30 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount you would like to invest each month: ");

        double investment = input.nextDouble();

        System.out.print("Enter the annual interest rate(e.g. 5,10,20): ");

        double interestRate = input.nextDouble();

        interestRate = interestRate / 100;

        System.out.println("Enter the number of months: ");

        int numberOfMonths = input.nextInt();

        double total = 0;

        for (int i = 1; i <= numberOfMonths; i++) {


            total = (investment + total) * (1 + (interestRate / 12));

        }


        System.out.println("After the " + numberOfMonths + "th month, " + "the account value is " + total);


    }

}
