package ch_05;

/**
 * 5.10 (Find numbers divisible by 5 and 6) Write a program that displays
 * all the numbers from 100 to 1,000, ten per line, that are divisible by
 * 5 and 6. Numbers are separated by exactly one space.
 */
public class Exercise05_10 {
    public static void main(String[] args) {

        final int startNum = 100;
        final int endNum = 1000;

        int count = 0;
        for (int i = startNum; i <= endNum; i++) {

            if (i % 6 == 0 && i % 5 == 0) {
                System.out.print(i + " ");
                count++;

                if (count == 10) {
                    System.out.println();
                    count = 0;
                }

            }

        }

    }
}
