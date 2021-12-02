package ch_07;

import java.util.Scanner;

/*7.14 (Computing gcd) Write a method that returns the gcd of an
 * unspecified number of integers. The method header is specified as follows:
 * public static int gcd(int... numbers)
 * Write a test program that prompts the user to enter five numbers,
 * invokes the method to find the gcd of these numbers, and displays the gcd.
 */
public class Exercise07_14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numsToFind = new int[5];
        System.out.println("Please enter 5 numbers now to find their GCD:");

        for (int i = 0; i < numsToFind.length; i++) {
            numsToFind[i] = input.nextInt();
        }

        System.out.println("The GCD of these 5 integers is " + gcd(numsToFind));
    }

    public static int gcd(int... numbers) {
        int minNum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minNum) {
                minNum = numbers[i];
            }
        }

        int gcd = 1;
        boolean checkNum;

        for (int i = 2; i < minNum; i++) {
            checkNum = true;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] % i != 0)
                    checkNum = false;
            }
            if (checkNum) {
                gcd = i;
            }
        }
        return gcd;
    }
}

