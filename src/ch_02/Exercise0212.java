package ch_02;

import java.util.Scanner;

/*
(Physics: finding runway length) Given an airplane’s acceleration a and take-off
speed v, you can compute the minimum runway length needed for an airplane to
take off using the following formula:
length =v^2 / 2*a
Write a program that prompts the user to enter v in meters/second (m/s) and the
acceleration a in meters/second squared (m/s2), and displays the minimum runway
length.
*/
public class Exercise0212 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter speed and acceleration: ");
        int v = input.nextInt();
        double acc = input.nextDouble();

        double numerator = Math.pow(v, 2);
        double denominator = 2 * acc;
        double minRunwayLength = numerator / denominator;
        System.out.println("The minimum runway length for this airplane is "
                + minRunwayLength);


    }
}
