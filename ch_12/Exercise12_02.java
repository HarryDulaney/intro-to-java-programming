package ch_12;

import jdk.internal.util.xml.impl.Input;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 12.2 (InputMismatchException) Write a program that prompts the user to read
 * two integers and displays their sum. Your program should prompt the user to
 * read the number again if the input is incorrect.
 */
public class Exercise12_02 {
    public static void main(String[] args) {
        int i1, i2;
        boolean inputMismatch = false;

        Scanner in = new Scanner(System.in);

        do {
            System.out.print("Enter two integers: ");

            try {
                i1 = in.nextInt();
                i2 = in.nextInt();

                System.out.print("Sum = " + (i1 + i2));
                inputMismatch = false;

            } catch (InputMismatchException ime) {
                inputMismatch = true;

                System.out.println("Incorrect input type, please try again: ");
                in.nextLine();
            }
        } while (inputMismatch);

        in.close();
    }
}
