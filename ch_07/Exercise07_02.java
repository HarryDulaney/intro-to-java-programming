package ch_07;

import java.util.Scanner;

/**
 * 7.2 (Reverse the numbers entered) Write a program that
 * reads ten integers and displays them in the reverse
 * of the order in which they were read.
 */
public class Exercise07_02 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter ten space-separated integers: ");

        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = input.nextInt();
        }

        displayReverse(arr);
        input.close();
    }

    private static void displayReverse(int[] arrRev) {
        for (int i = arrRev.length - 1; i >= 0; i--) {
            System.out.print(arrRev[i] + " ");

        }
    }
}
