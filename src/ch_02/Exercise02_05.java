package ch_02;

import java.util.Scanner;

/**
 * 2.5 (Financial application: calculate tips)
 * Write a program that reads the sub-total and
 * the gratuity rate, then computes the gratuity and
 * total. For example, if the user enters 10 for sub-total
 * and 15% for gratuity rate, the program displays $1.5 as
 * gratuity and $11.5 as total.
 */
public class Exercise02_05 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the super excellent java master gratuity and bill calculator! :) ");
        System.out.println("Enter your subtotal and the gratuity rate: ");

        double subTotal = input.nextDouble();
        double percentGratuity = input.nextDouble();

        double gratuity = subTotal * (percentGratuity / 100);

        double total = subTotal + gratuity;

        System.out.print("The gratuity is: $");
        System.out.printf("%.2f", gratuity);
        System.out.print(" and the total including gratuity is: $" + total);


    }

}
