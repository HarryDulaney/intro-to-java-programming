package ch_03;

import java.util.*;

/**
 * *3.31 (Financials: currency exchange) Write a program that prompts the user to enter
 * the exchange rate from currency in U.S. dollars to Chinese RMB.
 * <p>
 * Prompt the user to enter 0 to convert from U.S. dollars to Chinese RMB and 1 to convert from
 * Chinese RMB and U.S. dollars.
 * <p>
 * Prompt the user to enter the amount in U.S. dollars or Chinese RMB to convert it to Chinese RMB or U.S. dollars, respectively.
 * Here are the sample runs:
 * <p>
 * Enter the exchange rate from dollars to RMB: 6.81
 * Enter 0 to convert dollars to RMB and 1 vice versa: 0
 * Enter the dollar amount: 100
 * $100.0 is 681.0 yuan
 */
public class Exercise03_31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nEnter the exchange rate from dollars to RMB: ");
        double rate = in.nextDouble();

        System.out.print("\nEnter 0 to convert dollars to RMB and 1 vice versa: ");
        int choice = in.nextInt();

        double amt = 0;

        if (choice == 1) {
            System.out.print("\nEnter the RMB amount: ");
        } else {
            System.out.println("\nEnter the dollar amount: ");
        }

        amt = in.nextDouble();

        if (choice == 1) {
            double yuan = amt * rate;
            System.out.println("$" + amt + " dollars is " + yuan + " yuan");

        } else {
            double dollars = amt / rate;
            System.out.printf("%.2f yuan is %.2f dollars", amt, dollars);

        }


    }
}