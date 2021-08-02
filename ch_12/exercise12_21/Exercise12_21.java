package ch_12.exercise12_21;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 12.21 (Data sorted?) Write a program that reads the strings from file SortedStrings.txt
 * and reports whether the strings in the files are stored in increasing order.
 * If the strings are not sorted in the file, displays the first two strings that are out
 * of the order.
 */
public class Exercise12_21 {
    public static void main(String[] args) {
        String nextStr = "";
        String lastStr = "";
        int strCount = 0;
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("src\\ch_12\\exercise12_21\\SortedStrings.txt"))) {

            while ((nextStr = bufferedReader.readLine()) != null) {
                if (strCount++ == 0) {
                    lastStr = nextStr;
                    continue;
                }
                if (!isIncreasingOrder(lastStr, nextStr)) {
                    System.out.println("The strings are not in increasing order...");
                    System.out.println("The first occurrence of two Strings out of order are " + lastStr +
                            " " +
                            "and " + nextStr);
                    break;
                }

                lastStr = nextStr;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    static boolean isIncreasingOrder(String s1, String s2) {
        return s1.compareTo(s2) < 0;
    }

}
