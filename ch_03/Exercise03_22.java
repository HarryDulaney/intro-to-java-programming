package ch_03;

import java.util.*;

/**
 * **3.22 (Geometry: point in a circle?) Write a
 * program that prompts the user to enter a point (x, y) and checks whether the
 * point is within the circle centered at (0, 0) with radius 10. For example,
 * (4, 5) is inside the circle and (9, 9) is outside the circle, as shown in
 * Figure 3.7a.
 * <p>
 * (Hint: A point is in the circle if its distance to (0, 0) is
 * less than or equal to 10. The formula for computing the distance is 2(x2 -
 * x1)2 + (y2 - y1)2.
 * <p>
 * (Exercise25_01 your program to cover all cases.) <br>
 * Two sample runs are
 * shown below.
 * </p>
 * <p>
 * Enter a point with two coordinates: 4 5
 * Point (4.0, 5.0) is in the circle
 * <p>
 * Enter a point with two coordinates: 9 9
 * Point (9.0, 9.0) is not in the circle
 */
public class Exercise03_22 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("\nEnter a point with two coordinates: ");
        double x2 = in.nextInt();
        double y2 = in.nextInt();

        double x1 = 0;
        double y1 = 0;


        double distanceToZero = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        String res = "";
        if (distanceToZero <= 10) {
            res += "is in the circle";
        } else {
            res += "is not in the circle";
        }

        System.out.println("Point (" + x2 + ", " + y2 + ") " + res);


    }
}