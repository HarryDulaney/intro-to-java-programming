package ch_03;

import java.util.Random;

/**
 * 3.16 (Random point) Write a program that displays a random coordinate in a
 * rectangle. The rectangle is centered at (0, 0) with width 100 and height 200
 *
 */
public class Exercise03_16 {
    public static void main(String[] args) {

        Random random = new Random();

        //Random boolean value indicates making the number negative.
        boolean negOrPosX = random.nextBoolean();
        boolean negOrPosY = random.nextBoolean();

        int x = (int) ((Math.random() * 100));
        int y = (int) ((Math.random() * 200));


        if (negOrPosX) {
            x = x * -1;
        }

        if (negOrPosY) {
            y = y * -1;
        }

        System.out.println("(" + x + "," + y + ")");
    }

}
