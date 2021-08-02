package ch_03;

import java.util.Scanner;

/**
 * 3.12 (Palindrome number) Write a program that prompts the user to enter a
 * three-digit integer and determines whether it is a palindrome number. A
 * number is palindrome if it reads the same from right to left and from left to
 * right. Here is a sample run of this program:
 * <p>
 * Enter a three-digit integer: 121 121 is a palindrome
 */
public class Exercise03_12 {
    public static void main(String[] args) {

        System.out.println("Please enter a three digit integer:");

        Scanner input = new Scanner(System.in);
        int startNum = input.nextInt();

        int numLast = startNum % 10;
        int numFirst = startNum / 100;
        input.close();

        if (numLast == numFirst) {
            System.out.println("This number is a Palindrome!");
        } else
            System.out.println("This number is not a Palindrome :(");

    }

}
