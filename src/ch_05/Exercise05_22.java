package ch_05;

import java.util.*;

/**
 * For the formula to compute monthly payment, see Listing 2.9, ComputeLoan.java.
 * **5.22 (Financial application: loan amortization schedule) The monthly payment for a
 * given loan pays the principal and the interest. The monthly interest is computed
 * by multiplying the monthly interest rate and the balance (the remaining principal).
 * The principal paid for the month is therefore the monthly payment minus
 * the monthly interest. Write a program that lets the user enter the loan amount,
 * number of years, and interest rate and displays the amortization schedule for the
 * loan.
 * <p>
 * Here is a sample run:
 * Loan Amount: 10000
 * Number of Years: 1
 * Annual Interest Rate: 7
 * Monthly Payment: 865.26
 * Total Payment: 10383.21
 * Payment# Interest Principal Balance
 * 1 58.33 806.93 9193.07
 * 2 53.62 811.64 8381.43
 * ...
 * 11 10.0 855.26 860.27
 * 12 5.01 860.25 0.01
 * Note
 * The balance after the last payment may not be zero. If so, the last payment should be
 * the normal monthly payment plus the final balance.
 * Hint: Write a loop to display the table. Since the monthly payment is the
 * same for each month, it should be computed before the loop. The balance
 * is initially the loan amount. For each iteration in the loop, compute the
 * interest and principal, and update the balance. The loop may look like this:
 * for (i = 1; i <= numberOfYears * 12; i++) {
 * interest = monthlyInterestRate * balance;
 * principal = monthlyPayment - interest;
 * balance = balance - principal;
 * System.out.println(i + "\t\t" + interest
 * + "\t\t" + principal + "\t\t" + balance);
 * }
 */
public class Exercise05_22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the loan amount: ");
        double loanAmount = in.nextDouble();

        System.out.println("Number of years: ");
        int numYears = in.nextInt();

        System.out.println("Annual Interest Rate (as a percent (ex. enter '7' for 7%)): ");
        double rate = in.nextDouble();

        /* Monthly interest rate */
        double monthlyInterestRate = rate / 1200;

        /* Monthly payment */
        double monthlyPayment = loanAmount * monthlyInterestRate / (1
                - 1 / Math.pow(1 + monthlyInterestRate, numYears * 12));
        System.out.printf("Monthly Payment: %.2f", monthlyPayment);

        double totalPayment = monthlyPayment * numYears * 12;

        System.out.printf("\nTotal Payment: %.2f", totalPayment);
        System.out.println();
        double balance = totalPayment;
        double principal;

        for (int i = 1; i <= numYears * 12; i++) {

            System.out.println("\nPayment# Interest Principal Balance");
            double interest = monthlyInterestRate * balance;
            principal = monthlyPayment - interest;
            balance = balance - principal;
            System.out.printf("%1d\t\t%4.2f\t\t%4.2f\t\t%.2f", i, interest, principal, balance);
        }


        in.close();
    }
}