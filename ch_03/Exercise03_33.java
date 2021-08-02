package ch_03;

import java.util.*;

/**
 * *3.33 (Financial: compare costs) Suppose you shop for rice in two different packages.
 * You would like to write a program to compare the cost. The program prompts the
 * user to enter the weight and price of the each package and displays the one with
 * the better price.
 * <p>
 * Here is a sample run:
 * <p>
 * Enter weight and price for package 1: 50 24.59
 * Enter weight and price for package 2: 25 11.99
 * Package 2 has a better price.
 * <p>
 * Notes
 * 11.99/25 = 24.99/50 -> 23.98/50 = 24.99/50
 */
public class Exercise03_33 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter weight(Integer) and price(Float) for package 1: ");
        int weightP1 = in.nextInt();
        double p1 = in.nextDouble();
        System.out.print("\nEnter weight and price for package 2: ");
        int weightP2 = in.nextInt();
        double p2 = in.nextDouble();
        int low = 0, high = 0, lcm = 0;

        String betterPrice = "";
        if (weightP1 <= 0 || weightP2 <= 0) {
            System.out.println("Weight must be a positive number. ");
        } else if (p1 <= 0 || p2 <= 0) {
            System.out.println("Price must be a positive number. ");

        } else { // Find greater number
            if (weightP1 > weightP2) {
                low = weightP2;
                high = weightP1;
            } else if (weightP1 < weightP2) {
                low = weightP1;
                high = weightP2;
            } else { //Weights are equal, return lowest price.
                betterPrice += (p1 < p2 ? "1" : "2");
                System.out.println("Package " + betterPrice + " has a better price.");
                System.exit(0);
            }
            lcm = high; // Start lcm with higher number as multiple
            //Calculate LCM
            while (lcm % low != 0) {
                lcm += high;
            }
            int adjustP1 = lcm / weightP1; //Divide by LCM to get multiple
            int adjustP2 = lcm / weightP2;

            double adjustedPrice1 = p1 * adjustP1; //Use multiple to adjust the price for weight difference
            double adjustedPrice2 = p2 * adjustP2;

            betterPrice += adjustedPrice1 < adjustedPrice2 ? "1" : "2";
        }


        System.out.println("Package " + betterPrice + " has a better price.");
    }
}