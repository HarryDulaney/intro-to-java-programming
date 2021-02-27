package ch_11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * *11.17 (Algebra: perfect square) Write a program that prompts
 * the user to enter an integer m and find the smallest integer n such that m * n is a perfect square. (Hint:
 * Store all smallest factors of m into an array list. n is the product of the factors that
 * appear an odd number of times in the array list.
 * <p>
 * For example, consider m = 90, store the factors 2, 3, 3, 5 in an array list. 2 and 5 appear an odd number of times
 * in the array list. So, n is 10.)
 * <p>
 * Here are sample runs:
 * Enter an integer m: 1500
 * The smallest number n for m * n to be a perfect square is 15
 * m * n is 22500
 * <p>
 * <p>
 * Enter an integer m: 63
 * The smallest number n for m * n to be a perfect square is 7
 * m * n is 441
 */
public class Exercise11_17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int m = in.nextInt();

        int n = findN(findSmallestFactors(m));
        System.out.println("The smallest number n for m * n to be a perfect square is " + n);
        System.out.println("m * n is " + m * n);

    }

    static ArrayList<Integer> findSmallestFactors(int m) {

        ArrayList<Integer> smallFactors = new ArrayList<>();

        for (int f = 2; m != 1; f++) {
            if (m % f == 0) {
                smallFactors.add(f);
                m /= f;
                f = 1; // Reset the test factor
            }
        }
        return smallFactors;
    }

    static Integer findN(ArrayList<Integer> factors) {
        ArrayList<Integer> oddCounts = new ArrayList<>();
        for (int i = 0; i < factors.size(); i++) {
            int num = factors.get(i);
            int count = 0;
            for (Integer integer : factors) {
                if (integer == num) {
                    count++;
                }
            }
            if (count % 2 != 0 && !oddCounts.contains(num)) {
                oddCounts.add(num);
            }

        }

        Integer result = 1;
        for (Integer oddCount : oddCounts) {
            result *= oddCount;
        }
        return result;
    }

}
