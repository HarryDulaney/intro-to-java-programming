package ch_06;

/**
 * *6.15 (Financial application: print a tax table) Listing 3.5 gives a program to compute
 * tax. Write a method for computing tax using the following header:
 * public static double computeTax(int status, double taxableIncome)
 * <p>
 * Use this method to write a program that prints a tax table for taxable income from
 * $50,000 to $60,000 with intervals of $50 for all the following statuses:
 * Taxable
 * Income
 * Single Married Joint
 * or Qualifying
 * Widow(er)
 * Married
 * Separate
 * Head of
 * a House
 * 50000 8688 6665 8688 7353
 * 50050 8700 6673 8700 7365
 * ...
 * 59950 11175 8158 11175 9840
 * 60000 11188 8165 11188 9853
 * Hint: round the tax into integers using Math.round (i.e., Math
 * .round(computeTax(status, taxableIncome)).
 *
 * @author Harry D.
 */
public class Exercise06_15 {
    static final String space = "       ";
    static final String spacex2 = space + "    ";

    public static void main(String[] args) {
        System.out.print("Taxable" + space + "Single" + space + "Married Joint" + space + "Married" + space + "Head " +
                "of");
        System.out.print("\nIncome" + space + "     " + space + "  Or Qualifying" + space + "Separate" + "      " + "a " +
                "House");
        System.out.print("\n      " + space + "       " + space + "Widow(er)" + space + "       " + space + "     ");
        System.out.print(
                "\n_____________________________________________________________________");

        for (int i = 50000; i <= 60000; i += 50) {

            System.out.print("\n" + i);
            System.out.print(spacex2 + Math.round(computeTax(0, i)));
            System.out.print(spacex2 + Math.round(computeTax(1, i)));
            System.out.print(spacex2 + Math.round(computeTax(2, i)));
            System.out.print(spacex2 + Math.round(computeTax(3, i)));
        }
    }

    public static double computeTax(int status, double taxableIncome) {
        double tax = 0;

        int upBound10 = 0, upBound15 = 0, upBound25 = 0, upBound28 = 0, upBound33 = 0;

        if (status == 0) { // Compute tax for single filers
            upBound10 = 8350;
            upBound15 = 33950;
            upBound25 = 82250;
            upBound28 = 171550;
            upBound33 = 372950;

        } else if (status == 1) { // Married Filing Jointly or Qualifying Widow(er)
            upBound10 = 16700;
            upBound15 = 67900;
            upBound25 = 137050;
            upBound28 = 208850;
            upBound33 = 372950;

        } else if (status == 2) { // Compute tax for married separately
            upBound10 = 8350;
            upBound15 = 33950;
            upBound25 = 68525;
            upBound28 = 104425;
            upBound33 = 186475;

        } else if (status == 3) { // Compute tax for head of household
            upBound10 = 11950;
            upBound15 = 45500;
            upBound25 = 117450;
            upBound28 = 190200;
            upBound33 = 372950;
        } else {
            System.out.println("Error: invalid status");
            System.exit(1);
        }

        if (taxableIncome <= upBound10)
            tax = taxableIncome * 0.10;
        else if (taxableIncome <= upBound15)
            tax = upBound10 * 0.10 + (taxableIncome - upBound10) * 0.15;
        else if (taxableIncome <= upBound25)
            tax = upBound10 * 0.10 + (upBound15 - upBound10) * 0.15 + (taxableIncome - upBound15) * 0.25;
        else if (taxableIncome <= upBound28)
            tax = upBound10 * 0.10 + (upBound15 - upBound10) * 0.15 + (upBound25 - upBound15) * 0.25
                    + (taxableIncome - upBound25) * 0.28;
        else if (taxableIncome <= upBound33)
            tax = upBound10 * 0.10 + (upBound15 - upBound10) * 0.15 + (upBound25 - upBound15) * 0.25
                    + (upBound28 - upBound25) * 0.28 + (taxableIncome - upBound28) * 0.33;
        else
            tax = upBound10 * 0.10 + (upBound15 - upBound10) * 0.15 + (upBound25 - upBound15) * 0.25
                    + (upBound28 - upBound25) * 0.28 + (upBound33 - upBound28) * 0.33 + (taxableIncome - upBound33) * 0.35;

        return tax;
    }
}