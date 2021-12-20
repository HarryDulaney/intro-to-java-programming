package ch_18;

import java.math.BigInteger;
import java.util.Scanner;

import static resources.lib.UnitTest.*;

/**
 * *18.1 (Factorial) Using the BigInteger class introduced in Section 10.9, you can
 * find the factorial for a large number (e.g., 100!).
 * Implement the factorial method using recursion.
 * Write a program that prompts the user to enter an integer and displays its factorial.
 */
public class Exercise18_01 {

    static boolean runTest = false; // Change to true to the Test instead of user input.

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        if (runTest) {
            System.out.println("Successful test indicator: " + Test.testFactorial());
        } else {
            System.out.print("\nEnter an integer to find its factorial: ");
            long numToFactor = in.nextLong();

            System.out.println(numToFactor + "! is " + findFactorial(numToFactor));
        }
    }


    static BigInteger findFactorial(long num) {
        long startIterateNum = 1;
        BigInteger initResult = BigInteger.ONE;

        return factorial(num, startIterateNum, initResult);
    }

    static BigInteger factorial(long num, long i, BigInteger result) {
        if (i <= num) {
            result = result.multiply(new BigInteger(String.valueOf(i)));

            return factorial(num, ++i, result);
        }

        return result;

    }

    private static class Test {

        public static boolean testFactorial() {
            BigInteger correctResult = new BigInteger("30414093201713378043612608166064768844377641568960512000000000000");
            BigInteger res = Exercise18_01.findFactorial(50);
            try {
                assertEquals(correctResult, res);
            } catch (AssertionError error) {
                error.printStackTrace();
                return false;
            }
            return true;

        }

    }
}


