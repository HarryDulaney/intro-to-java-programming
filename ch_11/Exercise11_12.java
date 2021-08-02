package ch_11;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * 11.12 (Sum ArrayList) Write the following method that returns the sum of all numbers in an ArrayList:
 * public static double sum(ArrayList<Double> list)
 * <p>
 * Write a test program that prompts the user to enter 5 numbers, stores them in an
 * array list, and displays their sum.
 */
public class Exercise11_12 {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter 5 numbers: ");
        for (int i = 0; i < 5; i++) {
            list.add(in.nextDouble());
        }
        System.out.println("Sum = " + sum(list));

        in.close();
    }

    public static double sum(ArrayList<Double> list) {
        double sum = 0;
        ListIterator<Double> iterator = list.listIterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        return sum;
    }

}
