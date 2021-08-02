package ch_09.exercise09_07;

public class Exercise09_07 {

    public static void main(String[] args) {

        Account obj = new Account(1122, 20_000);
        obj.setAnnualInterestRate(4.5);
        obj.withdraw(2500);
        obj.deposit(3000);

        System.out.println("The balance in account " + obj.getID() + " is now: $" + obj.getBalance());
        System.out.println("The total interest, at a rate of " + obj.getMonthlyInterestRate() + "%"
                + " per month is " + obj.getMonthlyInterest());
        System.out.println("And your account was created on " + obj.getDateCreated());
    }
}
