package ch_07;

import java.util.Scanner;


/**
 * 7.17 (Sort students) Write a program that prompts the user to enter the number of students,
 * the students’ names, and their scores, and prints student names and scores in decreasing
 * order of their scores. Assume that the name is a string without spaces,
 * use the Scanner’s next() method to read a name.
 */
public class Exercise07_17 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the number of students:");
        int numStudents = input.nextInt();
        double[] scores = new double[numStudents];
        String[] names = new String[numStudents];

        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter a student name:");
            names[i] = input.next();
            System.out.print("Enter the students score:");
            scores[i] = input.nextDouble();
        }

        sortArray(scores, names);
        System.out.println("The student names in decreasing order of their scores are: ");

        for (int i = 0; i < scores.length; i++) {
            System.out.println(names[i] + " " + scores[i]);
        }
    }

    public static void sortArray(double[] arr, String[] array) {
        for (int i = 0; i < arr.length; i++) {
            double currentMax = arr[i];
            int currentIndex = i;
            String temp;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > currentMax) {
                    currentMax = arr[j];
                    currentIndex = j;
                }
            }
            if (currentIndex != i) {
                temp = array[i];
                array[i] = array[currentIndex];
                array[currentIndex] = temp;
                arr[currentIndex] = arr[i];
                arr[i] = currentIndex;
            }
        }
    }
}
