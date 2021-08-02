package ch_03;

import java.util.Scanner;

/**
 * *3.34 (Geometry: point on line segment) Programming Exercise 3.32 shows how to test
 * whether a point is on an unbounded line. Revise Programming Exercise 3.32 to
 * test whether a point is on a line segment. Write a program that prompts the user
 * to enter the three points for p0, p1, and p2 and displays whether p2 is on the line
 * segment from p0 to p1.
 * <p>
 * Here are some sample runs:
 * <p>
 * Enter three points for p0, p1, and p2: 1 1 2.5 2.5 1.5 1.5
 * (1.5, 1.5) is on the line segment from (1.0, 1.0) to (2.5, 2.5)
 * Enter three points for p0, p1, and p2: 1 1 2 2 3.5 3.5
 * (3.5, 3.5) is not on the line segment from (1.0, 1.0) to (2.0, 2.0)
 */
public class Exercise03_34 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter three sets of coordinates for the points p0, p1, p2 (ex: 4.4 2 6.5 9.5 -5 4): ");

        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double x3 = in.nextDouble();
        double y3 = in.nextDouble();


        double determinant = ((x2 - x1) * (y3 - y1)) - ((y2 - y1) * (x3 - x1));

        String beg = "(" + x3 + "," + y3 + ") is ";
        String end = " from " + "(" + x1 + "," + y1 + ") to " + "(" + x2 + "," + y2 + ")";

        String det = "";

        if (x3 > x2 || y3 > y2 || x3 < x1 || y3 < y1 || determinant > 0 || determinant < 0) {
            det += "not on the line segment";

        } else if (determinant == 0) {
            det += "on the line segment";

        }

        System.out.println(beg + det + end);
        in.close();

    }
}