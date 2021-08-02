package ch_10.exercise10_08;


//_________________________UML DIAGRAM______________________________*
/*																	|
 * 							  Tax     								|
 *------------------------------------------------------------------|
 *           + SINGLE_FILER : int                                   |
 *           + MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_ER : int         |
 *            + MARRIED_SEPARATELY : int                            |
 *            + HEAD_OF_HOUSEHOLD : int                             |
 *            - filingStatus : int                                  |
 *            - brackets : int[][]                                  |
 *            -  taxableIncome : double                             |
 *            - rates: double[]                                     |
 *                                                                  |
 *                                                                  |
 *------------------------------------------------------------------|
 *                     +Tax()          	    			       		|
 *                     +Tax(int[][], double[],double)       		|
 * 	 																|
 * 					+getTax(int[],double[],double):double           |
 * 						                                        	|
 * 				    ***** getters and setters  *****                |
 * 	 																|
 * 																	|
 *__________________________________________________________________|  */

import java.util.Arrays;

/**
 * ***10.8 (Financial: the Tax class) Programming Exercise 8.12 writes a program for
 * computing taxes using arrays.
 * <p>
 * Design a class named Tax to contain the following instance data fields:
 * ■ int filingStatus: One of the four tax-filing statuses: 0—single filer, 1—
 * married filing jointly or qualifying widow(er), 2—married filing separately,
 * and 3—head of household. Use the public static constants SINGLE_FILER
 * (0), MARRIED_JOINTLY_OR_QUALIFYING_WIDOW(ER) (1), MARRIED_
 * SEPARATELY (2), HEAD_OF_HOUSEHOLD (3) to represent the statuses.
 * ■ int[][] brackets: Stores the tax brackets for each filing status.
 * ■ double[] rates: Stores the tax rates for each bracket.
 * ■ double taxableIncome: Stores the taxable income.
 * Provide the getter and setter methods for each data field and the getTax()
 * method that returns the tax.
 * Also provide a no-arg constructor and the constructor Tax(filingStatus, brackets, rates, taxableIncome).
 * <p>
 * Draw the UML diagram for the class and then implement the class.
 */
public class Tax {
    public static final int SINGLE_FILER = 0;
    public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW_ER = 1;
    public static final int MARRIED_SEPARATELY = 2;
    public static final int HEAD_OF_HOUSEHOLD = 3;

    private int filingStatus;
    private int[][] brackets;
    private double taxableIncome;
    private double[] rates;

    public Tax() {

    }

    Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
        this.filingStatus = filingStatus;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;
    }

    public double getTax() {
        int[] bracket = brackets[filingStatus];

        if (taxableIncome <= bracket[0]) {
            return taxableIncome * rates[0];
        }
        int i = 1;
        double tax = bracket[0] * rates[0];
        while (i < bracket.length) {
            if (taxableIncome <= bracket[i]) {
                return tax + (taxableIncome - bracket[i - 1]) * rates[i];
            }
            tax += (bracket[i] - bracket[i - 1]) * rates[i];
            i++;
        }
        return tax + (taxableIncome - bracket[bracket.length - 1]) * rates[rates.length - 1];
    }


    public int getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public int[][] getBrackets() {
        return brackets;
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double[] getRates() {
        return rates;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    private int getNumRates() {
        return rates.length;
    }

    @Override
    public String toString() {
        int[] bracket = brackets[filingStatus];
        return "Tax{" +
                "filingStatus=" + filingStatus +
                ", brackets=" + Arrays.toString(bracket) +
                ", taxableIncome=" + taxableIncome +
                ", rates=" + Arrays.toString(rates) +
                '}';
    }
}
