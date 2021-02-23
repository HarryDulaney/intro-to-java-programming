package ch_11.exercise11_08;

import java.util.Date;

/**
 * *    +Transaction(type: char,amount: double, balance: double, description: String)
 * *    -date: java.util.Date
 * *    -type: char
 * *    -amount: double
 * *    -balance: double
 * *    -description: String
 * The date of this transaction.
 * The type of the transaction, such as 'W' for withdrawal, 'D'
 * for deposit.
 * The amount of the transaction.
 * The new balance after this transaction.
 * Construct a Transaction with the specified date, type,
 * balance, and description.
 * The description of this transaction.
 * <p>
 */
public class Transaction {

    private char type;
    private double amount;
    private double balance;
    private String description;
    private Date transactionDate;

    static final char WITHDRAWAL = 'W';
    static final char DEPOSIT = 'D';


    public Transaction(char type, double amount, double balance, String description) {
        this.transactionDate = new Date();
        this.amount = amount;
        this.balance = balance;
        this.type = type;
        this.description = description;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public Transaction setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    public char getType() {
        return type;
    }

    public Transaction setType(char type) {
        this.type = type;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public Transaction setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public double getBalance() {
        return balance;
    }

    public Transaction setBalance(double balance) {
        this.balance = balance;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Transaction setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "\nTransaction:\n" +
                "type=" + type +
                ", amount=$" + amount +
                ", balance=$" + balance +
                ", description='" + description + '\'' +
                ", transactionDate=" + transactionDate;
    }


}
