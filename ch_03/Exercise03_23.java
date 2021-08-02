package ch_03;

import java.util.*;

/**
 * **3.23 (Geometry: point in a rectangle?)
 * Write a program that prompts the user to enter a point (x, y) and checks whether the point is within the rectangle
 * centered at (0, 0) with width 10 and height 5.
 * <p>
 * For example, (2, 2) is inside the rectangle and
 * (6, 4) is outside the rectangle, as shown in Figure 3.7b.
 * <p>
 * (Hint: A point is in the rectangle if its horizontal distance to (0, 0) is less than or equal to 10 / 2 and its
 * vertical distance to (0, 0) is less than or equal to 5.0 / 2. Exercise25_01 your program to cover all cases.)
 * <p>
 * Here are two sample runs.
 * <p>
 * Enter a point with two coordinates: 2 2
 * Point (2.0, 2.0) is in the rectangle
 * <p>
 * Enter a point with two coordinates: 6 4
 * Point (6.0, 4.0) is not in the rectangle
 */
public class Exercise03_23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nEnter a point with two coordinates: ");

        double x2 = in.nextInt();
        double y2 = in.nextInt();

        double x1 = 0;
        double y1 = 0;
        double rectWidth = 10;
        double rectHeight = 5;


        String res = "";
        if (x2 <= 10.0 / 2 && y2 <= 5.0 / 2) {
            res += "is in the rectangle";
        } else {
            res += "is not in the rectangle";
        }

        System.out.println("Point (" + x2 + ", " + y2 + ") " + res + " Centered at (0,0) with a Height of 5 and " +
                "a Width of 10");

        in.close();

    }
}