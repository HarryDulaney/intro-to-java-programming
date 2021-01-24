package ch_04;

import javax.print.DocFlavor;
import java.util.*;

/**
 * *4.26 (Financial application: monetary units) Rewrite Listing 2.10, ComputeChange.
 * java, to fix the possible loss of accuracy when converting a float value to an int
 * value. Read the input as a string such as "11.56". Your program should extract
 * the dollar amount before the decimal point and the cents after the decimal amount
 * using the indexOf and substring methods.
 */
public class Exercise04_26 {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        // Receive the amount
        System.out.print(
                "Enter an amount in double, for example 11.56: ");
        String numStr = input.next();
        if (numStr.length() < 4) {
            System.out.println("Please enter an amount with the format ##.## ie 11.56");
            System.exit(0);
        }
        String numberOfOneDollars = numStr.substring(0, numStr.indexOf("."));

        String cents = numStr.substring(numStr.indexOf(".") + 1); //Everything to the right of the "."
        Integer change = Integer.parseInt(cents);
        int numQuarter = change / 25;
        change %= 25;
        int dime = change / 10;
        change %= 10;
        int nickel = change / 5;
        change %= 5;
        int penny = change;


        String numberOfQuarters = String.valueOf(numQuarter);
        String numberOfDimes = String.valueOf(dime);
        String numberOfNickels = String.valueOf(nickel);
        String numberOfPennies = String.valueOf(penny);

        // Display results
        System.out.println("Your amount " + numStr + " consists of");
        System.out.println(" " + numberOfOneDollars + " dollars");
        System.out.println(" " + numberOfQuarters + " quarters ");
        System.out.println(" " + numberOfDimes + " dimes");
        System.out.println(" " + numberOfNickels + " nickels");
        System.out.println(" " + numberOfPennies + " pennies");

    }
}