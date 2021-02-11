package ch_17.exercise17_06;


import java.io.Serializable;

/**
 * The type Loan.
 */
public class Loan implements Serializable {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    /**
     * Default constructor
     */
    public Loan() {
        this(2.5, 1, 1000);
    }

    /**
     * Instantiates a new Loan.
     *
     * @param annualInterestRate the annual interest rate
     * @param numberOfYears      the number of years
     * @param loanAmount         the loan amount
     */
    public Loan(double annualInterestRate, int numberOfYears,
                double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }

    /**
     * Return annualInterestRate
     *
     * @return the annual interest rate
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Set a new annualInterestRate
     *
     * @param annualInterestRate the annual interest rate
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Return numberOfYears
     *
     * @return the number of years
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Set a new numberOfYears
     *
     * @param numberOfYears the number of years
     */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * Return loanAmount
     *
     * @return the loan amount
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Set a new loanAmount
     *
     * @param loanAmount the loan amount
     */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    /**
     * Find monthly payment
     *
     * @return the monthly payment
     */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }

    /**
     * Find total payment
     *
     * @return the total payment
     */
    public double getTotalPayment() {
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    /**
     * Return loan date
     *
     * @return the loan date
     */
    public java.util.Date getLoanDate() {
        return loanDate;
    }

    @Override
    public String toString() {
        return "Loan Date=" + this.loanDate + " | Annual Interest Rate=" + this.annualInterestRate + " | " +
                "Num years=" + this.numberOfYears + " | " + "Loan Amount=" + this.loanAmount + " | " +
                "Monthly payment=" + getMonthlyPayment() + " | " + " Total payment=" + getTotalPayment();
    }
}
