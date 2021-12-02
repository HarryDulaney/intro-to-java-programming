package ch_06;

/**
 * *6.13 (Sum series) Write a method to compute the following series:
 * m(i) =
 * 1 2
 * +
 * 2 3
 * + c +
 * i
 * i + 1
 * Write a test program that displays the following table:
 * i m(i)
 * 1 0.5000
 * 2 1.1667
 * ...
 * 19 16.4023
 * 20 17.3546
 */
public class Exercise06_13 {
    public static void main(String[] args) {
        System.out.println("i                 m(i)");
        System.out.println("__________________________");
        double res = 0;

        for (int num = 1; num <= 20; num++) {
            System.out.print(num + "          ");
            res += num / (num + 1.0);
            System.out.printf("         %.4f\n", res);

        }
    }
}