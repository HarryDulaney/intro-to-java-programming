package ch_04;

import java.util.Scanner;

/**
 * *4.14 (Convert letter grade to number) Write a program that prompts the user to enter a
 * letter grade A, B, C, D, or F and displays its corresponding numeric value 4, 3, 2,
 * 1, or 0. Here is a sample run:
 * Enter a letter grade: B
 * The numeric value for grade B is 3
 * Enter a letter grade: T
 * T is an invalid grade
 */
public class Exercise04_14 {
    public static void main(String[] args) {

        System.out.println("Enter your letter grade: ie.(A,B,C,D,F)");

        Scanner input = new Scanner(System.in);
        String grade = input.nextLine();
        char letterGrade = grade.charAt(0);

        char numberGrade = 0;
        if (letterGrade == 'A') {
            numberGrade = '4';
        } else if (letterGrade == 'B')
            numberGrade = '3';
        else if (letterGrade == 'C')
            numberGrade = '2';
        else if (letterGrade == 'D')
            numberGrade = '1';
        else if (letterGrade == 'F')
            numberGrade = '0';
        else
            System.out.println("Invalid grade entry");

        if (numberGrade >= '1' && numberGrade <= '5') {
            System.out.println("The numeric value for letter grade: " + letterGrade + " " +
                    "is " + numberGrade);
        }
    }
}
