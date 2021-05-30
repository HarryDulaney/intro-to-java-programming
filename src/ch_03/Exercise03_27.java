package ch_03;

import java.util.*;

/**
 * **3.27 (Geometry: points in triangle?) Suppose a right triangle is placed in a plane as
 * shown below.
 * <p>
 * The right-angle point is placed at (0, 0), and the other two points
 * are placed at (200, 0), and (0, 100).
 * <p>
 * Write a program that prompts the user to enter
 * a point with x- and y-coordinates and determines whether the point is inside the
 * triangle
 * <p>
 * Here are the sample runs:
 * <p>
 * (0, 100)
 * (0, 0) (200, 0)
 * p2
 * p1
 * Enter a point's x- and y-coordinates: 100.5 25.5
 * The point is in the triangle
 * <p>
 *
*/
public class Exercise03_27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a point's x- and y-coordinates: ");
        double x = in.nextDouble();
        double y = in.nextDouble();

        double x1 = 0, y1 = 0, x2 = 200, y2 = 0, x3 = 0, y3 = 100; //Vertex coordinates for the given triangle

        double Dx, Dy, minD, maxD;

        String result = "";
        double determinant = (y2 - y3) * (x1 - x3) - (x3 - x2) * (y3 - y1);
        minD = Math.min(determinant, 0);
        maxD = Math.max(determinant, 0);
        Dx = x - x3;
        Dy = y - y3;

        double a = y2 - y3 * Dx + (x3 - x2) * Dy;
        if (a < minD || a > maxD) {
            result += "The point is not in the triangle.";

        }
        double b = (y3 - y1) * Dx + (x1 - x3) * Dy;
        if (b < minD || b > maxD) {
            result += "The point is not in the triangle.";

        }
        double c = determinant - a - b;
        if (c < minD || c > maxD) {
            result += "The point is not in the triangle.";

        } else {
            result += "The point is in the triangle.";
        }
        System.out.println(result);

    }
}