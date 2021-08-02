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
public class Exercise11_03 {
    public static void main(String[] args) {

        Account testAcct = new Account(1, 100);

        SavingsAccount testSaves = new SavingsAccount(2, 500);

        CheckingAccount testCheck = new CheckingAccount(3, 1000);

        System.out.println(testAcct.toString());
        System.out.println(testSaves.toString());
        System.out.println(testCheck.toString());

    }

}
