package ch_05;

import java.util.Scanner;

/**
 * 5.9 (Find the two highest scores) Write a program that prompts
 * the user to enter the number of students and each student�s name
 * and score, and finally displays the student with the highest score
 * and the student with the second-highest score. Use the next() method
 * in the Scanner class to read a name rather using the nextLine() method.
 */
public class Exercise05_09 {
    public static void main(String[] args) {

        double highScore = 0, secondHigh = 0;

        String highName = "";
        String secondName = "";
        String tempName = "";
        double tempScore = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of students: ");

        int numStudents = input.nextInt();

        System.out.print("Enter a students name: ");
        highName = input.next();

        System.out.print("Enter the students score: ");
        highScore = input.nextDouble();

        while (numStudents > 1) {
            System.out.print("Enter a students name: ");
            tempName = input.next();

            System.out.print("Enter the students score: ");
            tempScore = input.nextDouble();

            if (tempScore > highScore) {
                secondHigh = highScore;
                secondName = highName;
                highScore = tempScore;
                highName = tempName;
                numStudents--;
                continue;
            }

            if (tempScore < highScore && tempScore > secondHigh) {
                secondHigh = tempScore;
                secondName = tempName;
            }
            numStudents--;

        }
        System.out.println("The top two students are: ");
        System.out.print(highName + "'s score of " + highScore);
        System.out.print(" and " + secondName + "'s score of " + secondHigh);
    }

}
