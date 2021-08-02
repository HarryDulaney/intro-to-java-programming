package ch_11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 11.4 (Maximum element in ArrayList) Write the following method that returns the
 * maximum value in an ArrayList of integers. The method returns null if the
 * list is null or the list size is 0.
 * public static Integer max(ArrayList<Integer> list)
 * <p>
 * Write a test program that prompts the user to enter a sequence of numbers ending
 * with 0, and invokes this method to return the largest number in the input.
 */
public class Exercise11_04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a sequence of numbers ending with a 0: ");

        ArrayList<Integer> list = new ArrayList<>();
        Integer integer;
        while ((integer = in.nextInt()) != 0) {
            list.add(integer);
        }

        System.out.println("The largest number is " + max(list));
        in.close();
    }

    public static Integer max(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Integer max = list.get(0);
        for (Integer integer : list) {
            max = Math.max(max, integer);
        }
        return max;
    }

}
