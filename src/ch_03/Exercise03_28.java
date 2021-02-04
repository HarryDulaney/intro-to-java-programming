package ch_03;

import java.util.*;

/**
 * 3.28 (Geometry: two rectangles) Write a program that prompts
 * the user to enter the center x-, y-coordinates, width, and
 * height of two rectangles and determines whether the second
 * rectangle is inside the first or overlaps with the first, as shown
 * in Figure 3.9. Exercise25_01 your program to cover all cases.
 *
 * @author Harry Dulaney
 */
public class Exercise03_28 {
    public static void main(String[] args) {
        //This program only tests if rectangle two is inside rectangle one or if
        //rectangle two overlaps rectangle one per the instructions


        Scanner input = new Scanner(System.in);

        System.out.println("Please enter rectangle one's center point x "
                + "and y coordinates followed by its width and height:");

        double recOneX = input.nextDouble();

        double recOneY = input.nextDouble();

        double recOnewidth = input.nextDouble();

        double recOneheight = input.nextDouble();

        System.out.println("Please enter rectangle two's center point x "
                + "and y coordinates followed by its width and height:");

        double recTwoX = input.nextDouble();

        double recTwoY = input.nextDouble();

        double recTwowidth = input.nextDouble();

        double recTwoheight = input.nextDouble();

        double recOnetopX = recOneX + recOnewidth / 2;

        double recOnetopY = recOneY + recOneheight / 2;

        double recOnebottomX = recOneX - recOnewidth / 2;

        double recOnebottomY = recOneY - recOneheight / 2;

        double recTwotopX = recTwoX + recTwowidth / 2;

        double recTwotopY = recTwoY + recTwoheight / 2;

        double recTwobottomX = recTwoX - recTwowidth / 2;

        double recTwobottomY = recTwoY - recTwoheight / 2;

        boolean isInside = checkIfinside(recOnetopX, recTwotopX, recOnebottomX, recTwobottomX, recOnetopY, recTwotopY, recOnebottomY, recTwobottomY);

        boolean overlap = checkIfoverlaps(recOnetopX, recTwotopX, recOnebottomX, recTwobottomX, recOnetopY, recTwotopY, recOnebottomY, recTwobottomY);

        if (isInside) {
            System.out.println("Rectangle two is inside of rectangle one");

        } else if (overlap) {
            System.out.println("Rectangle two overlaps rectangle one");

        } else {
            System.out.println("Rectangle two does not overlap rectangle one and is not inside of rectangle one");
        }


    }

    public static boolean checkIfinside(double x1top, double x2top, double x1bottom, double x2bottom,
                                        double y1top, double y2top, double y1bottom, double y2bottom) {


        if (x2top <= x1top & x2bottom >= x1bottom & y2top <= y1top
                & y2bottom >= y1bottom) {

            return true;

        } else

            return false;
    }

    public static boolean checkIfoverlaps(double x1top, double x2top, double x1bottom, double x2bottom,
                                          double y1top, double y2top, double y1bottom, double y2bottom) {
        return !(x1top < x2bottom | x1bottom > x2top | y1top < y2bottom
                | y1bottom > y2top);
    }

}
