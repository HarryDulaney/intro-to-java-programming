package ch_05;

/**
 * 5.11 (Find numbers divisible by 5 or 6, but not both) Write a program
 * that displays all the numbers from 100 to 200, ten per line, that are
 * divisible by 5 or 6, but not both. Numbers are separated by exactly one
 * space.
 */
public class Exercise05_11 {
    public static void main(String[] args) {

        int count = 0;

        for (int i = 100; i <= 200; i++) {

            if (count == 10) {
                System.out.println();
                count = 0;
            }

            if (i % 5 == 0 ^ i % 6 == 0) {
                System.out.print(i + " ");
                count++;
            }


        }
    }
}
