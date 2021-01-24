package ch_07;

import java.util.*;

/**
 * **7.34 (Sort characters in a string) Write a method that returns a sorted string using the
 * following header:
 * public static String sort(String s)
 * For example, sort("acb") returns abc.
 * Write a test program that prompts the user to enter a string and displays the sorted
 * string.
 * The below solution to Exercise 7.34 a.k.a {@code Exercise07_34.class} implements, a classic bubble sort algorithm,
 * which is covered in Chapter 23. For more info, please see Listing 23.4 on page. 866 of the book.
 *
 * @author Harry D.
 */
public class Exercise07_34 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = in.nextLine().trim();

        System.out.print("Sorted result -> ");
        System.out.print(sort(str));

        in.close();
    }

    /**
     * Bubble sort with loop control variable.
     *
     * @param s the String to sort
     * @return sorted in alphabetic ascending order
     */
    public static String sort(String s) {
        char[] chars = s.toCharArray();
        boolean notSorted = true;
        for (int i = 1; i < chars.length && notSorted; i++) {
            notSorted = false; //Reset control variable
            for (int j = 0; j < chars.length - i; j++) {
                if (chars[j] > chars[j + 1]) {
                    chars = swap(j, j + 1, chars);
                    notSorted = true;
                }
            }
        }
        return Arrays.toString(chars);

    }

    /**
     * Swap the chars to make conform to ascending alphabetic order
     *
     * @return char[] with swapped chars at idx1 and idx2
     */
    static char[] swap(int idx1, int idx2, char[] arr) {
        char temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;

        return arr;

    }
}