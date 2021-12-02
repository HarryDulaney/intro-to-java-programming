package ch_07;

import java.util.Scanner;

/**
 * 7.1 (Assign grades) Write a program that reads student scores, gets the best score,
 * and then assigns grades based on the following scheme:
 * Grade is A if score is >= best - 10
 * Grade is B if score is >= best - 20;
 * Grade is C if score is >= best - 30;
 * Grade is D if score is >= best - 40;
 * Grade is F otherwise.
 * The program prompts the user to enter the total number of students, then prompts
 * the user to enter all of the scores, and concludes by displaying the grades.
 */
public class Exercise07_01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of students now: ");
        final int numOfStudents = in.nextInt();
        int[] grades = new int[numOfStudents];

        System.out.println("Now enter " + numOfStudents + " space separated scores: ");

        for (int i = 0; i < numOfStudents; i++) {
            grades[i] = in.nextInt();
        }
        printLetterGrades(grades, findBestGrade(grades));

    }

    static void printLetterGrades(int[] grades, int bestGrade) {

        for (int j = 0; j < grades.length; j++) {
            char letterGrade;
            if (grades[j] >= (bestGrade - 10)) {
                letterGrade = 'A';
            } else if (grades[j] >= (bestGrade - 20)) {
                letterGrade = 'B';
            } else if (grades[j] >= (bestGrade - 30)) {
                letterGrade = 'C';
            } else if (grades[j] >= (bestGrade - 40)) {
                letterGrade = 'D';
            } else {
                letterGrade = 'F';
            }
            System.out.println("Student " + j + " score is " + grades[j] + " and grade is " + letterGrade);
        }

    }

    static int findBestGrade(int[] grades) {
        int best = grades[0];
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > best) {
                best = grades[i];
            }
        }
        return best;
    }


}
