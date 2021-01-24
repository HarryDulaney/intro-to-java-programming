package ch_04;

import java.util.Scanner;

/**
 * *4.11 (Decimal to hex) Write a program that prompts the user to enter an integer between
 * 0 and 15 and displays its corresponding hex number. Here are some sample runs:
 * Enter a decimal value (0 to 15): 11
 * The hex value is B
 * Enter a decimal value (0 to 15): 5
 * The hex value is 5
 * Enter a decimal value (0 to 15): 31
 * 31 is an invalid input
 */
public class Exercise04_11 {
    public static void main(String[] args) {

        System.out.println("Please enter a decimal number from (0 to 15): ");

        Scanner input = new Scanner(System.in);
        int userInput = input.nextInt();

        if (userInput > 15 || userInput < 0) {
            System.out.println("Invalid number, please try again and enter a decimal number from 0 and 15");
        }
        if (userInput >= 0 && userInput <= 9) {
            System.out.println("The hex value is " + userInput);
        }

        switch (userInput) {
            case 10:
                System.out.println("The hex value is " + "A");
                break;

            case 11:
                System.out.println("The hex value is " + "B");
                break;

            case 12:
                System.out.println("The hex value is " + "C");
                break;

            case 13:
                System.out.println("The hex value is " + "D");
                break;

            case 14:
                System.out.println("The hex value is " + "E");
                break;

            case 15:
                System.out.println("The hex value is " + "F");
                break;
        }


    }

}




