package ch_02;

import java.util.Scanner;

/**
 * **2.13 (Financial application: compound value) Suppose you save $100 each month
 * into a savings account with the annual interest rate 5%. Thus, the monthly interest
 * rate is 0.05/12 = 0.00417.
 * <p>
 * Write a program that prompts the user to enter a monthly saving amount and
 * displays the account value after the sixth month. (In Exercise 5.30, you will use a
 * loop to simplify the code and display the account value for any month.)
 */
public class Exercise02_13 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter  monthly contribution: ");
        double monthDeposit = input.nextDouble();
        double interestPerMonth = 0.05 / 12;
        double interestFactor = 1 + interestPerMonth;

        int count = 6;
        double total = 0;

        while (count != 0) {

            total = (total + monthDeposit) * interestFactor;

            --count;

        }

        System.out.print("At a 5% interest rate, you will have $");
        System.out.printf("%.2f", total);
        System.out.print(" in your saving account after six months");

    }

}