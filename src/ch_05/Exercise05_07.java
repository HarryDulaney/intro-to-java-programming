package ch_05;

import java.util.Scanner;

/**
 * *5.7 (Financial application: compute future tuition) Suppose that the tuition for
 * a university is $10,000 this year and increases 5% every year. In one year, the tuition
 * will be $10,500. Write a program that computes the tuition in ten years and the
 * total cost of four years’ worth of tuition after the tenth year.
 */
public class Exercise05_07 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        double highScore = 0;
        String studentName = " ";

        System.out.print("Enter the number of students: ");
        int numberOfstudents = input.nextInt();

        System.out.print("Enter a student name: ");
        studentName = input.next();

        System.out.print("Enter the students score: ");
        highScore = input.nextDouble();

        String tempName = "";
        double tempScore = 0;

        while (numberOfstudents > 1) {

            System.out.print("Enter a student name: ");
            tempName = input.next();

            System.out.print("Enter the students score: ");
            tempScore = input.nextDouble();

            if (tempScore > highScore)
                highScore = tempScore;
            studentName = tempName;


            numberOfstudents--;
        }
        System.out.println("Top student " + studentName + "'s score is " + highScore);
    }

}
