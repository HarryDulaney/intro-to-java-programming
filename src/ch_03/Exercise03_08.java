package ch_03;

import java.util.Scanner;

//Sort the integers in non-decreasing order


/**
 * 3.8 (Sort three integers) Write a program that prompts the user to enter three integers
 * and display the integers in non-decreasing order.
 */
public class Exercise03_08 {
    public static void main(String[] args) {

        System.out.println("Please enter a three integers:");
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        int z = input.nextInt();

        if (x > y) {
            int temp1 = x;
            x = y;
            y = temp1;

        }

        if (y > z) {
            int temp2 = y;
            y = z;
            z = temp2;
        }

        if (x > y) {
            int temp3 = x;
            x = y;
            y = temp3;
        }
        System.out.println(x + "" + y + "" + z);

    }
}


