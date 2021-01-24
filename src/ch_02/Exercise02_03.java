package ch_02;

import java.util.Scanner;

/**
 * 2.3 (Convert feet into meters) Write a program that reads a number in feet, converts it
 * to meters, and displays the result. One foot is 0.305 meter.
 */
public class Exercise02_03 {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        System.out.println("Enter a value for number of feet now: ");

        double numFeet = input.nextDouble();
        double numMeters = numFeet * 0.305;


        System.out.println(numFeet + " feet is equal to " + numMeters + " meters");
    }
}
