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
 * From GeeksForGeeks:
 * Let the coordinates of three corners be (x1, y1), (x2, y2) and (x3, y3).
 * <p>
 * And coordinates of the given point P be (x, y)
 * <p>
 * 1) Calculate area of the given triangle, i.e.,
 * area of the triangle ABC in the above diagram. Area A =[ x1(y2 –y3) + x2(y3 – y1) + x3(y1-y2)]/2 ]
 * 2) Calculate area of the triangle PAB. We can use the same formula for this. Let this area be A1.
 * 3) Calculate area of the triangle PBC. Let this area be A2.
 * 4) Calculate area of the triangle PAC. Let this area be A3.
 * 5) If P lies inside the triangle, then A1 + A2 + A3 must be equal to A.
 *
 * @author Harry Dulaney
 */
public class E0327 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a point's x- and y-coordinates: ");
        double x = in.nextDouble();
        double y = in.nextDouble();

        double a, a1, a2, a3;
        double x1 = 0, y1 = 0, x2 = 200, y2 = 0, x3 = 0, y3 = 100;
        a = calcArea(x1, y1, x2, y2, x3, y3); // Triangle ABD

        a1 = calcArea(x, y, x2, y2, x3, y3); //Triangle PAB
        a2 = calcArea(x1, y1, x, y, x3, y3); //Triangle PBC
        a3 = calcArea(x1, y1, x2, y2, x, y); //Triangle PAC

        if (a == a1 + a2 + a3) {
            System.out.println("The point is in the triangle.");
        } else {
            System.out.println("The point is not in the triangle.");
        }


    }

    private static double calcArea(double p1x, double p1y, double p2x, double p2y, double p3x, double p3y) {
        return Math.abs(p1x * (p2y - p3x) + p2x * (p3y - p1y) + p3x * (p1y - p2y) / 2);

    }
}