package ch_11.exercise11_08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


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
 * <p>
 * ■ Modify the withdraw and deposit methods to add a transaction to the
 * transactions array list.
 * <p>
 * ■ All other properties and methods are the same as in Programming Exercise 9.7.
 */
public class Account {

    private String ownerName;
    private ArrayList<Transaction> transactions;

    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;


    public Account() {
        id = 0;
        balance = 0;
        annualInterestRate = 0;
        transactions = new ArrayList<>();
    }

    public Account(String ownerName, int id, double balance) {
        this.ownerName = ownerName;
        this.id = id;
        this.balance = balance;
        transactions = new ArrayList<>();
    }

    public Account(int newId, double newBalance) {
        this.id = newId;
        this.balance = newBalance;
        dateCreated = new Date();
        annualInterestRate = 0;
        transactions = new ArrayList<>();

    }

    public int getID() {

        return id;
    }

    public void setID(int newID) {

        this.id = newID;
    }

    public double getBalance() {

        return balance;
    }

    public void setBalance(double newBalance) {

        this.balance = newBalance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double newInterestRate) {

        this.annualInterestRate = newInterestRate;
    }

    public Date getDateCreated() {

        Date startDate = dateCreated;

        return startDate;
    }

    public double getMonthlyInterestRate() {

        return (annualInterestRate / 12);
    }

    public double getMonthlyInterest() {

        return balance * (this.getMonthlyInterestRate() / 100);
    }

    public void withdraw(double amount) {
        balance -= amount;
        Transaction transaction = new Transaction(Transaction.WITHDRAWAL, amount, this.balance, "Standard");
        transactions.add(transaction);

    }

    public void deposit(double amountDeposit) {
        balance += amountDeposit;
        Transaction transaction = new Transaction(Transaction.DEPOSIT, amountDeposit, this.balance, "Standard");
        transactions.add(transaction);

    }

    @Override
    public String toString() {
        return "Account Summary: \n" +
                "ownerName=" + ownerName +
                ", annualInterestRate=" + annualInterestRate + "%" +
                ", balance=$" + balance + "\n" +
                "Transactions:\n" + Arrays.toString(transactions.toArray());
    }

}
