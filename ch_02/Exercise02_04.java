package ch_02;

import java.util.Scanner;

/**
 * 2.4 (Convert pounds into kilograms) Write a program that converts pounds into kilograms.
 * The program prompts the user to enter a number in pounds, converts it
 * to kilograms, and displays the result. One pound is 0.454 kilograms. Here is a
 * sample run:
 */
public class Exercise02_04 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a value for number of pounds now: ");

        double numLbs = input.nextDouble();
        double numKilos = numLbs * 0.454;

        System.out.println(numLbs + " pounds is equal to " + numKilos + " kilograms");

    }

}
