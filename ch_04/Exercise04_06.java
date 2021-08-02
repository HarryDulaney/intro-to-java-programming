package ch_04;

import java.util.*;

/**
 * *4.6 (Random points on a circle) Write a program that generates three random points
 * on a circle centered at (0, 0) with radius 40 and display three angles in a triangle
 * formed by these three points, as shown in Figure 4.7a.
 * (Hint: Generate a random angle a in radians between 0 and 2pi, as shown in Figure 4.7b and the point determined by
 * this angle is (r*cos(a), r*sin(a)).)]
 * <p>
 * x = r × cos(α) and y = r × sin(α)
 */
public class Exercise04_06 {
    public static void main(String[] args) {
        double radius = 40;
        //Point 1
        //Generate random angle in radians between 0 and 2*PI (2*PI radians == 360 degrees)
        double randomAngle = 0.5 + Math.random() * 361;
        System.out.println(randomAngle);
        double angleRadians = Math.toRadians(randomAngle);
        //Find point on circle with radius 40
        double x1 = radius * Math.cos(angleRadians);
        double y1 = radius * Math.sin(angleRadians);
        System.out.println("x = " + x1 + ", " + "y = " + y1);

        //Point 2
        double randomAngle2 = 0.5 + Math.random() * 361;
        System.out.println(randomAngle2);
        double angleRadians2 = Math.toRadians(randomAngle2);

        double x2 = radius * Math.cos(angleRadians2);
        double y2 = radius * Math.sin(angleRadians2);
        System.out.println("x = " + x2 + ", " + "y = " + y2);

        //Point 3
        double randomAngle3 = 0.5 + Math.random() * 361;
        System.out.println(randomAngle3);
        double angleRadians3 = Math.toRadians(randomAngle3);

        double x3 = radius * Math.cos(angleRadians3);
        double y3 = radius * Math.sin(angleRadians3);
        System.out.println("x = " + x3 + ", " + "y = " + y3);

        // Compute three sides of the triangle with given points
        double a = Math.sqrt((x2 - x3) * (x2 - x3)
                + (y2 - y3) * (y2 - y3));
        double b = Math.sqrt((x1 - x3) * (x1 - x3)
                + (y1 - y3) * (y1 - y3));
        double c = Math.sqrt((x1 - x2) * (x1 - x2)
                + (y1 - y2) * (y1 - y2));

        // Compute the angles of the triangle using values for three sides
        double A = Math.toDegrees(Math.acos((a * a - b * b - c * c)
                / (-2 * b * c)));
        double B = Math.toDegrees(Math.acos((b * b - a * a - c * c)
                / (-2 * a * c)));
        double C = Math.toDegrees(Math.acos((c * c - b * b - a * a)
                / (-2 * a * b)));

        // Display result
        System.out.println("The three angles are " +
                Math.round(A * 100) / 100.0 + " " + Math.round(B * 100) / 100.0 + " " +
                Math.round(C * 100) / 100.0);

    }


}