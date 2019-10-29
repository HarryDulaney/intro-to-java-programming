package Ch_11;

/* 11.3 (Subclasses of Account) In Programming Exercise 9.7 , the Account class was 
 * defined to model a bank account. An account has the properties account number, 
 * balance, annual interest rate, and date created, and methods to deposit and 
 * withdraw funds. Create two subclasses for checking and saving accounts. 
 * A checking account has an overdraft limit, but a savings account cannot be overdrawn.
 * 
 * Draw the UML diagram for the classes and then implement them. 
 * Write a test program that creates objects of Account, SavingsAccount, 
 * and CheckingAccount and invokes their toString() methods.
 */

/*
 ______________________________________________
| 				Account09_07				   |
|______________________________________________|
 					  ^
					  |							*/
/*_______________UML Diagram____________________*
 *______________________________________________*
 *             SavingsAccount				 	*
 *______________________________________________*
 * 							  			 		*
 *	+SavingsAccount()							*		
 *	+minBalance	: double(zero)					*
 *	+withdraw(amount:double):void				*									
 * 	+toString(): String							*
 * _____________________________________________*
 *//*********************************************
	*/

/*
 ______________________________________________
| 				Account09_07				   |
|______________________________________________|
					  ^
					  |							*/
/*_______________UML Diagram____________________*
*_______________________________________________*
*              CheckingAccount				 	*
*_______________________________________________*
* 	+CheckingAccount()							*
* 	+minBalance	: double				 	 	*
* 	+toString: String							*
* 	+withdraw(amount:double) :void				*
* ______________________________________________*
*//*********************************************
	*/
import Ch_09.*;

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
