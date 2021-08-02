package ch_12.exercise12_04;

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

