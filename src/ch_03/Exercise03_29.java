package ch_03;

import java.util.Scanner;

/**
 * **3.29 (Geometry: two circles) Write a program that prompts the user to enter the center
 * coordinates and radius of two circles and determines whether the second circle is
 * inside the first or overlaps with the first, as shown in Figure 3.10.
 * <p>
 * (Hint: circle2 is inside circle1 if the distance between the two centers  <= |r1 - r2|
 * and circle2 overlaps circle1 if the distance between the two centers <= r1 + r2.
 * <p>
 * Exercise25_01 your program to cover all cases.)
 * <p>
 * <p>
 * Enter circle1's center x-, y-coordinates, and radius: 0.5 5.1 13
 * Enter circle2's center x-, y-coordinates, and radius: 1 1.7 4.5
 * circle2 is inside circle1
 *
 */
public class Exercise03_29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double x1, y1, x2, y2, r1, r2;
        System.out.print("\nEnter circle1's center x-, y-coordinates, and radius: ");
        x1 = in.nextDouble();
        y1 = in.nextDouble();
        r1 = in.nextDouble();

        System.out.print("\nEnter circle2's center x-, y-coordinates, and radius: ");
        x2 = in.nextDouble();
        y2 = in.nextDouble();
        r2 = in.nextDouble();


        //Calculate distance between center points
        double distBetweenCenters = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        String result = "";
        if (distBetweenCenters <= Math.abs(r1 - r2)) {
            result += "is inside circle1.";

        } else if (distBetweenCenters <= r1 + r2) {
            result += "overlaps circle1.";

        } else {
            result += "is not inside of and does not overlap circle1";

        }
        System.out.println("Circle2 " + result); //Inside the first or overlaps the first?


    }

}
