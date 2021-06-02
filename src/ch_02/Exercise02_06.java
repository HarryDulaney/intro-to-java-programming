package ch_02;

import java.util.Scanner;

/**
 * 2.6 (Sum the digits in an integer)
 * Write a program that reads an integer between 0 and
 * 1000 and adds all the digits in the integer.
 * For example, if an integer is 932, the sum of all its digits is 14.
 */
public class Exercise02_06 {
    public static void main(String[] args) {

        System.out.print("Enter an integer to discover the sum of its digits: ");

        Scanner input = new Scanner(System.in);

        int userNumber = input.nextInt();


        System.out.println(sumDigits(userNumber));


    }

    private static int sumDigits(int a) {

        int sum = 0;
        while (a > 0) {

            sum += (a % 10);

            a /= 10;
        }


        return sum;

    }

}
