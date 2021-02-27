package ch_11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 11.14 (Combine two lists) Write a method that returns the union of two array lists of
 * integers using the following header:
 * public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2)
 * <p>
 * For example, the union of two array lists {2, 3, 1, 5} and {3, 4, 6} is
 * {2, 3, 1, 5, 3, 4, 6}.
 * <p>
 * Write a test program that prompts the user to enter two lists,
 * each with five integers, and displays their union. The numbers are separated by
 * exactly one space in the output. Here is a sample run:
 * Enter five integers for list1: 3 5 45 4 3
 * Enter five integers for list2: 33 51 5 4 13
 * The combined list is 3 5 45 4 3 33 51 5 4 13
 */
public class Exercise11_14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        System.out.print("Enter 5 integers for list1: ");
        for (int i = 0; i < 5; i++) {
            one.add(in.nextInt());
        }
        System.out.print("Enter 5 integers for list2: ");
        for (int i = 0; i < 5; i++) {
            two.add(in.nextInt());
        }


        System.out.println("The combined list is " + union(one, two).toString());
        in.close();
    }

    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        list1.addAll(list2);
        return list1;

    }
}
