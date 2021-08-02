package ch_12.exercise12_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 12.15 (Write/read data) Write a program to create a file named Exercise12_15.txt if
 * it does not exist.
 * <p>
 * Write 100 integers created randomly into the file using text I/O.
 * <p>
 * Integers are separated by spaces in the file.
 * <p>
 * Read the data back from the file and display the data in increasing order.
 */
public class Exercise12_15 {
    static ArrayList<Integer> lines = new ArrayList<>();

    public static void main(String[] args) {
        boolean success = true;
        File file = new File("src" + File.separator + "ch_12" + File.separator + "exercise12_15" + File.separator +
                "Exercise12_15.txt");
        if (!file.exists()) {
            try {
                success = file.createNewFile();
            } catch (IOException ioe) {
                success = false;
                ioe.printStackTrace();
            }
        }
        if (success) {
            try (PrintWriter printWriter = new PrintWriter(file)) {
                for (int i = 0; i < 100; i++) {
                    int random = (int) (1 + Math.random() * 9999);
                    printWriter.write(String.valueOf(random));
                    printWriter.write(" ");
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try (Scanner fileIn = new Scanner(file)) {
                while (fileIn.hasNextLine()) {
                    String[] line = fileIn.nextLine().split(" ");
                    for (String num : line) {
                        lines.add(Integer.parseInt(num));
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            lines.sort((i1, i2) -> i1 - i2);
            System.out.println(Arrays.toString(lines.toArray()));
            System.out.println("Integer count= " + lines.size());

        }
    }
}
