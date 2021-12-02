package ch_06;

/**
 * **6.26 (Palindromic prime) A palindromic prime is a prime number and also palindromic. For example, 131 is a prime and also a palindromic prime, as are 313 and
 * 757. Write a program that displays the first 100 palindromic prime numbers. Display 10 numbers per line, separated by exactly one space, as follows:
 * 2 3 5 7 11 101 131 151 181 191
 * 313 353 373 383 727 757 787 797 919 929
 *
 * @author Harry D.
 */
public class Exercise06_26 {
    public static void main(String[] args) {
        int count = 1;
        int i = 2;
        while (count <= 100) {
            if (isPalindromicPrime(i)) {
                System.out.print(i + " ");
                if (count % 10 == 0) {
                    System.out.println();
                }
                count++;
            }
            ++i;
        }
    }

    private static boolean isPalindromicPrime(int num) {
        boolean palPrime = true;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                palPrime = false;
                break;
            }
        }
        if (palPrime) {
            return checkPalindrome(num);
        }
        return false;
    }

    static boolean checkPalindrome(int num) {
        String s = String.valueOf(num);
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}