package ch_06;

/**
 * 6.1 (Math: pentagonal numbers) A pentagonal number is defined
 * as  . . ., and so on. Therefore, the
 * first few numbers are 1, 5, 12, 22, . . . . Write a method with
 * the following header that returns a pentagonal number:
 */
public class Exercise06_01 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) {
                System.out.printf("%7d\n", getPentagonalNumber(i));
            } else
                System.out.printf("%7d", getPentagonalNumber(i));

        }
    }

    public static int getPentagonalNumber(int n) {
        return n * (3 * n - 1) / 2;
    }
}

