package ch_01;

/**
 * 1.5 (Compute expressions) Write a program that displays the result of
 * <p>
 * 9.5 * 4.5 - 2.5 * 3
 * 45.5 - 3.5
 */
public class Exercise01_05 {
    public static void main(String[] args) {
        double numerator = (9.5 * 4.5) - (2.5 * 3);
        double denominator = 45.5 - 3.5;

        double solution = numerator / denominator;

        String outStr = solution + " ";

        System.out.printf("%.4f", solution);

    }
}
