package ch_01;

/**
 * 1.4 (Print a table) Write a program that displays the following table:
 * a a^2 a^3
 * 1 1 1
 * 2 4 8
 * 3 9 27
 * 4 16 64
 */
// for a general case we can put the below snippet inside a method.
public class Exercise01_04 {

    public static void main(String[] args) {
        int num = 4;
        for (int row = 1; row <= num; row++) {
            System.out.println(row + " " + row * row + " " + row * row * row);
        }
    }

}
