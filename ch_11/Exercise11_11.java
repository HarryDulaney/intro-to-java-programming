package ch_11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 11.11 (Sort ArrayList) Write the following method that sorts an ArrayList of
 * numbers:
 * public static void sort(ArrayList<Integer> list)
 * <p>
 * Write a test program that prompts the user to enter 5 numbers, stores them in an
 * array list, and displays them in increasing order.
 */
public class Exercise11_11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter five integers: ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }

        sort(list);
        System.out.print("The numbers in increasing order: ");
        System.out.print("\n" + list.toString());
        in.close();
    }

    public static void sort(ArrayList<Integer> list) {
        boolean loop = true;
        while (loop) {
            loop = false; //Reset to check if can remain false
            for (int n = 0; n < list.size(); n++) {
                for (int i = n; i < list.size(); i++) {
                    if (!(i == n)) {
                        if (list.get(n) > list.get(i)) {
                            loop = true; // Not finished sorting..
                            swapElements(list, n, i);
                        }

                    }
                }
            }

        }


    }

    static void swapElements(ArrayList<Integer> list, int idx1, int idx2) {
        Integer temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);
    }
}
