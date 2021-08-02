package ch_05;

import java.util.Scanner;

/**
 * *5.51 (Longest common prefix) Write a program that prompts the user to enter two
 * strings and displays the largest common prefix of the two strings. Here are some
 * sample runs:
 * Enter the first string: Welcome to C++
 * Enter the second string: Welcome to programming
 * The common prefix is Welcome to
 * Enter the first string: Atlanta
 * Enter the second string: Macon
 * Atlanta and Macon have no common prefix
 *
 * By: Harry Dulaney
 */
public class Exercise05_51 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter string one: ");
        String str1 = input.nextLine();

        final int lengthOne = str1.length();
        System.out.println("Enter string two: ");

        String str2 = input.nextLine();
        final int lengthTwo = str2.length();

        if (str1.charAt(0) != str2.charAt(0)) {

            System.out.println(str1 + " and " + str2 + " have :(. ---> no common prefix <---");

        } else {
            int indexOfLCP = 0;
            for (int i = 0; i < (Math.max(lengthOne, lengthTwo)); i++) {

                if (str1.charAt(i) == str2.charAt(i)) {
                    indexOfLCP = i;
                } else {
                    break;
                }
            }
            System.out.print("The common prefix is: " + str1.substring(0, indexOfLCP + 1));

        }

        input.close();
    }

}
