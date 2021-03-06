package ch_12.exercise12_14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * *12.14 (Process scores in a text file) Suppose that a text file contains an unspecified
 * number of scores separated by blanks. Write a program that prompts the user
 * to enter the file, reads the scores from the file, and displays their total and
 * average
 * <p>
 * TO TEST: Enter "ScoresFile.txt" when prompted.
 */
public class Exercise12_14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a file to read: ");
        String filePath =
                "src" + File.separator + "ch_12" + File.separator + "exercise12_14" + File.separator + in.nextLine().trim();
        File file = new File(filePath);

        try (Scanner fileScanner = new Scanner(file)) {
            ArrayList<Double> scores = new ArrayList<>();
            while (fileScanner.hasNext()) {
                String value = fileScanner.next();
                scores.add(Double.parseDouble(value));
            }
            double total = 0;
            for (Double score : scores) {
                total += score;
            }
            double average = total / scores.size();
            System.out.printf("\nTotal is %.2f", total);
            System.out.printf("\nAverage is %.2f", average);

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.out.println("Could not find this file: " + file.getAbsolutePath());
        }

        in.close();
    }
}
