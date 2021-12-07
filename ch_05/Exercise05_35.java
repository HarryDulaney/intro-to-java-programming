package ch_05;

/**
 * *5.35 (Summation) Write a program to compute the following summation.
 * <p>
 * 1/[1 + sqrt(2)] + 1/[sqrt(2) + sqrt(3)] + 1/[sqrt(3) + sqrt(4)] + ..... + 1/[sqrt(624) + sqrt(625)]
 * </p>
 */
public class Exercise05_35 {
    public static void main(String[] args) {

        double result = 1 / (1 + Math.sqrt(2));
        for (int i = 2; i < 625; i++) {

            result += 1 / (Math.sqrt(i) + Math.sqrt(i + 1));

        }
        System.out.println(result);
    }
}