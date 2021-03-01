package ch_12;

/**
 * *12.4 (IllegalArgumentException) Modify the Loan class in Listing 10.2 to
 * throw IllegalArgumentException if the loan amount, interest rate, or
 * number of years is less than or equal to zero.
 */
public class Exercise12_04 {
    public static void main(String[] args) {
        Loan testLoan = new Loan();

        try {
            testLoan.setLoanAmount(-123_000);
        } catch (IllegalArgumentException e1) {
            System.out.println("IllegalArgumentException Caught: " + e1.getMessage());
        }

        try {
            testLoan.setAnnualInterestRate(-5.5);
        } catch (IllegalArgumentException e2) {
            System.out.println("IllegalArgumentException Caught: " + e2.getMessage());

        }

        try {
            testLoan.setNumberOfYears(0);

        } catch (IllegalArgumentException e3) {
            System.out.println("IllegalArgumentException Caught: " + e3.getMessage());

        }


        try {
            testLoan.setAnnualInterestRate(7.4);
            testLoan.setNumberOfYears(10);
            testLoan.setLoanAmount(100_000);


        } catch (IllegalArgumentException e5) {
            System.out.println("IllegalArgumentException Caught: " + e5.getMessage());

        }

        try {
            System.out.println("For a Loan where: ");
            System.out.println("Annual interest rate = " + testLoan.getAnnualInterestRate());
            System.out.println("Amount = " + testLoan.getLoanAmount());
            System.out.println("number of years = " + testLoan.getNumberOfYears());
            System.out.println("loan date = " + testLoan.getLoanDate());
            System.out.printf("The monthly payment = $%.2f", testLoan.getMonthlyPayment());

        } catch (IllegalArgumentException e6) {
            System.out.println("IllegalArgumentException Caught: " + e6.getMessage());

        }


    }
}

class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private java.util.Date loanDate;

    /* Default constructor */
    public Loan() {
        this(2.5, 1, 1000);
    }

    /**
     * Construct a loan with specified annual interest rate,
     * number of years, and loan amount
     */
    public Loan(double annualInterestRate, int numberOfYears,
                double loanAmount) {
        if (loanAmount <= 0) {
            throw new IllegalArgumentException("Loan Amount must be greater than 0.");
        } else if (annualInterestRate <= 0) {
            throw new IllegalArgumentException("Annual interest rate must be greater than 0.");
        } else if (numberOfYears <= 0) {
            throw new IllegalArgumentException("Number of years must be greater than 0.");
        }
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        loanDate = new java.util.Date();
    }

    /**
     * Return annualInterestRate
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * Set a new annualInterestRate
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        if (annualInterestRate <= 0) {
            throw new IllegalArgumentException("Annual Interest Rate must be greater than 0.");
        }
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * Return numberOfYears
     */
    public int getNumberOfYears() {
        return numberOfYears;
    }

    /**
     * Set a new numberOfYears
     */
    public void setNumberOfYears(int numberOfYears) {
        if (numberOfYears <= 0) {
            throw new IllegalArgumentException("Number of years must be greater than 0.");
        }
        this.numberOfYears = numberOfYears;
    }

    /**
     * Return loanAmount
     */
    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * Set a new loanAmount
     */
    public void setLoanAmount(double loanAmount) {
        if (loanAmount <= 0) {
            throw new IllegalArgumentException("Loan Amount must be greater than 0.");
        }

        this.loanAmount = loanAmount;
    }

    /**
     * Find monthly payment
     */
    public double getMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 1200;
        return loanAmount * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
    }

    /**
     * Find total payment
     */
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }

    /**
     * Return loan date
     */
    public java.util.Date getLoanDate() {
        return loanDate;
    }
}

