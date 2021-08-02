package ch_11.exercise11_08;

/**
 * *11.8 (New Account class) An Account class was specified in Programming
 * Exercise 9.7. Design a new Account class as follows:
 * ■ Add a new data field name of the String type to store the name of the
 * customer.
 * ■ Add a new constructor that constructs an account with the specified name, id,
 * and balance.
 * ■ Add a new data field named transactions whose type is ArrayList
 * that stores the transaction for the accounts. Each transaction is an instance
 * of the Transaction class. The Transaction class is defined as shown in
 * Figure 11.6.
 * <p>
 * FIGURE 11.6 The Transaction class describes a transaction for a bank account.
 * ■ Modify the withdraw and deposit methods to add a transaction to the
 * transactions array list.
 * ■ All other properties and methods are the same as in Programming Exercise 9.7.
 * <p>
 * Write a test program that creates an Account with annual interest rate 1.5%,
 * balance 1000, id 1122, and name George. Deposit $30, $40, and $50 to the
 * account and withdraw $5, $4, and $2 from the account.
 * Print an account summary that shows account holder name, interest rate, balance, and all transactions.
 */
public class Exercise11_08 {
    //Test
    public static void main(String[] args) {
        Account testAccount = new Account("George", 1122, 1000);
        testAccount.setAnnualInterestRate(1.5);
        testAccount.deposit(30);
        testAccount.deposit(40);
        testAccount.deposit(50);

        testAccount.withdraw(5);
        testAccount.withdraw(4);
        testAccount.withdraw(2);

        System.out.println(testAccount.toString());

    }
}
