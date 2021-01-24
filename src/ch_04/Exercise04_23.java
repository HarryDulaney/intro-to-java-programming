package ch_04;

import java.util.*;

/**
 * *4.23 (Financial application: payroll) Write a program that reads the following information and prints a payroll statement:
 * Employee’s name (e.g., Smith)
 * Number of hours worked in a week (e.g., 10)
 * Hourly pay rate (e.g., 9.75)
 * Federal tax withholding rate (e.g., 20%)
 * State tax withholding rate (e.g., 9%)
 * <p>
 * A sample run is shown below:
 * Enter employee's name: Smith
 * Enter number of hours worked in a week: 10
 * Enter hourly pay rate: 9.75
 * Enter federal tax withholding rate: 0.20
 * Enter state tax withholding rate: 0.09
 * <p>
 * Employee Name: Smith
 * Hours Worked: 10.0
 * Pay Rate: $9.75
 * Gross Pay: $97.5
 * Deductions:
 * Federal Withholding (20.0%): $19.5
 * State Withholding (9.0%): $8.77
 * Total Deduction: $28.27
 * Net Pay: $69.22
 */
public class Exercise04_23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter employee's name:");
        String name = in.next();

        System.out.print("Enter number of hours worked in a week:");
        double hours = in.nextInt();

        System.out.print("Enter hourly pay rate:");
        double payRate = in.nextDouble();

        System.out.print("Enter federal tax withholding rate:");
        double federalTaxRate = in.nextDouble();

        System.out.print("Enter state tax withholding rate:");
        double stateTaxRate = in.nextDouble();

        double grossPay = hours * payRate;
        double federalTax = grossPay * federalTaxRate;
        double stateTax = grossPay * stateTaxRate;
        double totalTax = federalTax + stateTax;
        double netPay = grossPay - totalTax;

        System.out.print("\nEmployee Name: " + name);
        System.out.printf("\nHours Worked: %.1f", hours);
        System.out.print("\nPay Rate: $" + payRate);
        System.out.printf("\nGross Pay: $%.2f", grossPay);
        System.out.print("\nDeductions: ");

        System.out.printf("\nFederal Withholding: $%.2f", federalTax);
        System.out.printf("\nState Withholding: $%.2f", stateTax);
        System.out.printf("\nTotal Deductions: $%.2f", totalTax);
        System.out.printf("\n\nNet Pay: $%.2f", netPay);
        in.close();
    }
}