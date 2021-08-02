package ch_10;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * 10.17 (Square numbers) Find the first ten square numbers that are greater than
 * Long.MAX_VALUE. A square number is a number in the form of n2. For example, 4, 9, and 16 are square numbers.
 * Find an efficient approach to run your program fast.
 */
public class Exercise10_17 {
    public static void main(String[] args) {
        BigInteger maxLongVal = BigInteger.valueOf(Long.MAX_VALUE);
        int count = 0;
        long rootNum = (long) Math.sqrt(maxLongVal.doubleValue());
        BigInteger root = BigInteger.valueOf(rootNum);
        BigInteger[] result = new BigInteger[10];
        while (count < 10) {
            root = root.add(BigInteger.ONE);
            BigInteger n2 = root.pow(2);
            if (n2.compareTo(maxLongVal) > 0) {
                result[count] = n2;
                count++;
            }

        }
        System.out.println("Long.MAX_VALUE = " + Long.MAX_VALUE);
        System.out.println("The square numbers greater than Long.MAX_VALUE are: ");
        System.out.println(Arrays.toString(result));


    }
}
