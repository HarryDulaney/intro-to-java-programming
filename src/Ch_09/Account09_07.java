package Ch_09;
/*Exercise 9.7 (The Account class) Design a class named Account that contains:

* A private int data field named id for the account (default 0).

* A private double data field named balance for the account (default 0).

* A private double data field named annualInterestRate that stores the current interest rate 
* 
* (default 0). Assume all accounts have the same interest rate.

* A private Date data field named dateCreated that stores the date when the account was created.

* A no-arg constructor that creates a default account.

* A constructor that creates an account with the specified id and initial balance.

* The accessor and mutator methods for id, balance, and annualInterestRate.

* The accessor method for dateCreated.

* A method named getMonthlyInterestRate() that returns the monthly interest rate.

* A method named getMonthlyInterest() that returns the monthly interest.

* A method named withdraw that withdraws a specified amount from the account.

* A method named deposit that deposits a specified amount to the account.

* Draw the UML diagram for the class and then implement the class. 
* (Hint: The method getMonthlyInterest() is to return monthly interest, not the interest rate.
* Monthly interest is balance * monthlyInterestRate. monthlyInterestRate is annualInterestRate / 12. 
* Note that annualInterestRate is a percentage, e.g., like 4.5%. You need to divide it by 100.)

* Write a test program that creates an Account object with an account ID of 1122, a balance of 
* $20,000, and an annual interest rate of 4.5%. Use the withdraw method to withdraw $2,500, use 
* the deposit method to deposit $3,000, and print the balance, the monthly interest, and the 
* date when this account was created.
*/




//__________________________UML DIAGRAM_____________________________*
/*																	|																															
* 							  Account								|
*-------------------------------------------------------------------|
* 	-id : int														|
* 																	|	
*  -balance : double												|
* 																	|
* 	-annualInterestRate : double									|
* 																	|
* 	-dateCreated : Date												|
*-------------------------------------------------------------------|
* 	 +Account()														|
* 	 																|
* 	 +Account(ID:int,balance: double)								|
* 																	|
* 	+getID() : int													|
* 	 																|
* 	+setID() : void													|
* 																	|
* 	+getBalance() : double											|
* 																	|	
* 	+setBalance(balance:double) : void								|
* 																	|		
* 	+getAnnualInterestRate() : double								|
* 																	|
* 	+setAnnualInterestRate(double: newInterestRate) : void 			|
* 																	|
* 	+getDateCreated() : Date										|
* 																	|
* 	+getMonthlyInterestRate(interestRatePerYear: double)		    |
* 																	|
* +getMonthlyInterest(InterestRatePerMonth:double,balance:double)   |
* 																	|
* 	+withdraw(amount: double, balance: double)						|
* 																	|
* 	+deposit(amount: double, balance: double)						|
*___________________________________________________________________|  */


/**
 * @author Harry G. Dulaney IV
 */
import java.util.Date;


public class Account09_07 {
	
	private int id;
	
	private double balance;
	
	private double annualInterestRate;
	
	private Date dateCreated;
	
	public Account09_07(){
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		
	}
	
	public Account09_07(int newId,double newBalance){
		
		this.id = newId;
		this.balance = newBalance;	
		dateCreated = new Date();
		annualInterestRate = 0;
	}
	public int getID() {
		
	return id;}
	
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
		
		double InterestRatePerMonth = (annualInterestRate / 12);
		
	return InterestRatePerMonth; 
	}
	
	public double getMonthlyInterest() {
		
		double monthlyInterest = balance * (this.getMonthlyInterestRate()/100);
		
		return monthlyInterest;
  }
	
	public void withdraw(double amount) {
		
	 balance -= amount;
	}
	
	public void deposit(double amountDeposit) {
		
		balance += amountDeposit;
	 
	}
@Override
public String toString() {
	
	return "\nAccount ID: " + getID() + "\nBalance: " + getBalance() + 
			"\nDate created " + getDateCreated();
			
	
}


	public static void main(String[] args) {
	
		Account09_07 obj = new Account09_07(1122,20_000);
	
		 obj.setAnnualInterestRate(4.5);
		 
		 obj.withdraw(2500);
		 
		 obj.deposit(3000);
		 
		 System.out.println("The balance in account " + obj.getID() + " is now: $" + obj.getBalance());
		 System.out.println("The total interest, at a rate of " + obj.getMonthlyInterestRate() + "%" 
		 		+ " per month is " + obj.getMonthlyInterest());
		 System.out.println("And your account was created on " + obj.getDateCreated());
	}
}
