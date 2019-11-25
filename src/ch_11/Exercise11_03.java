package ch_11;

import ch_09.*;

/**
 * @author Harry G. Dulaney IV
 */

public class Exercise11_03 {
	public static void main(String[] args) {

		Account09_07 testAcct = new Account09_07(1, 100);

		SavingsAccount testSaves = new SavingsAccount(2, 500);

		CheckingAccount testCheck = new CheckingAccount(3, 1000);

		System.out.println(testAcct.toString());
		System.out.println(testSaves.toString());
		System.out.println(testCheck.toString());

	}

}

class SavingsAccount extends Account09_07 {

	public double minBalance;

	public SavingsAccount() {

		this.minBalance = 0;

	}

	public SavingsAccount(int id, double newBalance) {

		super(id, newBalance);
		this.minBalance = 0;
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

		return super.toString() + "\nOverdraft protection not included";
	}

}

class CheckingAccount extends Account09_07 {

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
