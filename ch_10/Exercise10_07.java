package ch_10;

import java.util.Scanner;

import ch_09.exercise09_07.Account;

/**
 * 10.7 (Game: ATM machine) Use the Account class created in
 * Programming Exercise 9.7 to simulate an ATM machine.
 * Create ten accounts in an array with id 0, 1, . . . , 9,
 * and initial balance $100. The system prompts the user to
 * enter an id. If the id is entered incorrectly, ask the user
 * to enter a correct id. Once an id is accepted, the main menu
 * is displayed as shown in the sample run. You can enter a choice
 * 1 for viewing the current balance, 2 for withdrawing money, 3 for
 * depositing money, and 4 for exiting the main menu. Once you exit,
 * the system will prompt for an id again. Thus, once the system
 * starts, it will not stop.
 *
 * @author Harry D.
 */
public class Exercise10_07 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Account[] atmAccounts = new Account[10];

        for (int i = 0; i < atmAccounts.length; i++) {

            atmAccounts[i] = new Account(i, 100.00);

        }
        LOOP:
        for (; ; ) { // Enter 1234 to end the program

            System.out.print("Please enter an account ID#: ");


            int idOfAcc = input.nextInt();
            if (idOfAcc == 1234) {
                break;
            }

            while (idOfAcc < 0 | idOfAcc > 9) {

                System.out.println("Incorrect ID# please enter a correct ID# ");

                idOfAcc = input.nextInt();
                if (idOfAcc == 1234) {
                    break LOOP;
                }
            }


            int userInput = 0;

            while (userInput != 4) {


                System.out.println("Main Menu");
                System.out.println("1: Check Balance");
                System.out.println("2: Withdraw");
                System.out.println("3: Deposit");
                System.out.println("4: Exit");
                System.out.print("Enter a choice now:");

                userInput = input.nextInt();
                executeCommand(userInput, idOfAcc, input, atmAccounts);

            }
        }
    }

    public static void executeCommand(int userCommand, int accId,
                                      Scanner j, Account[] arr) {

        switch (userCommand) {

            case 1:
                System.out.printf("The balance in account " + accId + " is $%.2f \n",
                        arr[accId].getBalance());
                break;

            case 2:
                System.out.print("Enter the amount you want to withdraw:");
                arr[accId].withdraw(j.nextDouble());
                break;

            case 3:
                System.out.print("Enter the amount you you want to deposit:");
                arr[accId].deposit(j.nextDouble());


        }

    }

}
