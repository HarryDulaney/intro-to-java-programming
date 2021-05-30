package ch_03;

import java.util.*;

/**
 * *3.18 (Cost of shipping) A shipping company uses the following function to
 * calculate the cost (in dollars) of shipping based on the weight of the
 * package (in pounds). c(w) = d 3.5, if 0 5.5, if 1 8.5, if 3 10.5, if 10 666
 * 6www w666 ===6 =131020
 * <p>
 * Write a program that prompts the user to enter the weight of the package and
 * display the shipping cost. If the weight is greater than 50, display a
 * message “the package cannot be shipped.”
 */
public class Exercise03_18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your packages weight: ");
        String shipping = "";

        double weight = in.nextDouble();

        if (weight > 50) {
            System.out.println("The package cannot be shipped.");
            in.close();
            return;
        } else if (weight > 0 && weight <= 1) {
            shipping += 3.5;

        } else if (weight > 1 && weight <= 3) {
            shipping += 5.5;

        } else if (weight > 3 && weight <= 10) {
            shipping += 8.5;

        } else if (weight > 10 && weight <= 20) {
            shipping += 10.5;

        }
        System.out.println("With a package weight of " + weight + " your cost of shipping will be " + shipping);
        in.close();
    }
}