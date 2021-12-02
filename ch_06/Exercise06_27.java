package ch_06;

/**
 * **6.27 (Emirp) An emirp (prime spelled backward) is a non-palindromic prime number
 * whose reversal is also a prime. For example, 17 is a prime and 71 is a prime, so 17
 * and 71 are emirps. Write a program that displays the first 100 emirps. Display 10
 * numbers per line, separated by exactly one space, as follows:
 * 13 17 31 37 71 73 79 97 107 113
 * 149 157 167 179 199 311 337 347 359 389
 * ...
 */
public class Exercise06_27 {
    public static void main(String[] args) {
        int count = 1;
        int i = 2;
        while (count <= 100) {
            if (isEmips(i)) {
                System.out.print(i + " ");
                if (count % 10 == 0) {
                    System.out.println();
                }
                count++;
            }

            ++i;
        }
    }

    private static boolean isEmips(int n) {
        if (isPrime(n)) {
            String s = String.valueOf(n);
            if (checkPalindrome(s)) {
                return false;
            } else {
                String result = "";
                for (int i = s.length() - 1; i >= 0; i--) {
                    result += s.charAt(i);
                }
                int revNum = Integer.parseInt(result);
                return isPrime(revNum);
            }
        }
        return false;
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean checkPalindrome(String num) {
        for (int i = 0, j = num.length() - 1; i < num.length() / 2; i++, j--) {
            if (num.charAt(i) != num.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}