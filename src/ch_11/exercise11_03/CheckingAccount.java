package ch_11.exercise11_03;

import ch_09.exercise09_07.Account;

/**
 * 11.3 (Subclasses of Account) In Programming Exercise 9.7, the Account class was
 * defined to model a bank account. An account has the properties account number,
 * balance, annual interest rate, and date created, and methods to deposit and withdraw funds.
 * Create two subclasses for checking and saving accounts. A checking
 * account has an overdraft limit, but a savings account cannot be overdrawn.
 * Draw the UML diagram for the classes and then implement them. Write
 * a test program that creates objects of Account, SavingsAccount, and
 * CheckingAccount and invokes their toString() methods.
 */
public class CheckingAccount extends Account {

    public double minBalance;

    public CheckingAccount() {

        this.minBalance = -50;

    }

    public CheckingAccount(int id, double newBalance) {

        super(id, newBalance);
        this.minBalance = -50;
    }

    @Override
    public void withdraw(double amount) {

        if (this.getBalance() - amount < minBalance) {
            System.out.println("We cannot complete this transaction. \nIt will put you over your withdrawl limit.");
        } else {
            this.setBalance(this.getBalance() - amount);
        }
    }

    @Override
    public String toString() {

        return super.toString() + "\nOverdraft protection up to : $" + minBalance;

    }
}
