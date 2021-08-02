package ch_05;

import java.util.*;

/**
 * **5.21 (Financial application: compare loans with various interest rates)
 * <p>
 * Write a program that lets the user enter the loan amount and loan period in number of years
 * and displays the monthly and total payments for each interest rate starting from
 * 5% to 8%, with an increment of 1/8. Here is a sample run:
 * Loan Amount: 10000
 * Number of Years: 5
 * Interest Rate Monthly Payment Total Payment
 * 5.000% 188.71 11322.74
 * 5.125% 189.29 11357.13
 * 5.250% 189.86 11391.59
 * ...
 * 7.875% 202.17 12129.97
 * 8.000% 202.76 12165.84
 */
public class Exercise05_21 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Loan amount: ");
        double loanAmount = in.nextDouble();

        System.out.println("Number of years: ");
        int numYears = in.nextInt();
        System.out.println("\nInterest rate - Monthly Payment - Total Payment");
        for (double i = 5.0; i <= 8.0; i += 0.125) {

            // Obtain monthly interest rate
            double monthlyInterestRate = i / 1200; //As decimal number
            // Calculate payment
            double monthlyPayment = loanAmount * monthlyInterestRate / (1
                    - 1 / Math.pow(1 + monthlyInterestRate, numYears * 12));
            double totalPayment = monthlyPayment * numYears * 12;

            System.out.printf("\t%.3f", i);
            System.out.print("%");
            System.out.printf("\t\t\t%.2f", monthlyPayment);
            System.out.printf("\t\t\t%.2f", totalPayment);
            System.out.println();

        }


        in.close();


    }
}