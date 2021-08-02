package ch_05;

import java.util.*;

/**
 * *5.18 (Display four patterns using loops) Use nested loops that display the following
 * patterns in four separate programs:
 * Pattern A Pattern B Pattern C Pattern D
 */
public class Exercise05_18 {
    public static void main(String[] args) {
        patternA();
        System.out.println();

        patternB();
        System.out.println();

        patternC();
        System.out.println();

        patternD();
    }

    static void patternA() {
        System.out.println("Pattern A");
        int x = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j <= x; j++) {
                System.out.print(j);
            }
            System.out.println();
            x++;
        }

    }

    static void patternB() {
        System.out.println("Pattern B");
        int x = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j < 7 - x; j++) {
                System.out.print(j);
            }
            System.out.println();
            x++;
        }

    }

    static void patternC() {
        System.out.println("Pattern C");

        for (int i = 1; i <= 6; i++) {

            for (int j = 6 - i; j >= 1; j--) {
                System.out.print(" ");
            }
            for (int z = i; z >= 1; z--) {
                System.out.print(z);
            }
            System.out.println();

        }
    }

    static void patternD() {
        System.out.println("Pattern D");
        for (int i = 0; i < 6; i++) {

            for (int z = 0; z < i; z++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 6 - i; j++) {
                System.out.print(j);
            }
            System.out.println();

        }
    }
}
