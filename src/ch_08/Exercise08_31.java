package ch_08;

import java.util.Scanner;

/**
 * 8.31 (Geometry: intersecting point) Write a method that returns the
 * intersecting point of two lines. The intersecting point of the two
 * lines can be found by using the formula shown in Programming
 * Exercise 3.25. Assume that (x1, y1) and (x2, y2) are the two points on
 * line 1 and (x3, y3) and (x4, y4) are on line 2............
 * The points are stored in a 4-by-2 two-dimensional array points with
 * (points[0][0], points[0][1]) for (x1, y1). The method returns the
 * intersecting point or null if the two lines are parallel. Write a
 * program that prompts the user to enter four points and displays the
 * intersecting point.
 */
public class Exercise08_31 {
    public static double[] getIntersectingPoint(double[][] points) {

        double[] interPoint = new double[2];


        if ((points[0][0] - points[1][0]) * (points[2][1] - points[3][1]) -
                (points[0][1] - points[1][1]) * (points[2][0] - points[3][0]) == 0)
            return null;


        double a = points[0][1] - points[1][1];

        double b = -(points[0][0] - points[1][0]);

        double c = (points[0][1] - points[1][1]) *
                points[0][0] - (points[0][0] - points[1][0]) * points[0][1];

        double d = (points[2][1] - points[3][1]);

        double e = -(points[2][0] - points[3][0]);

        double f = ((points[2][1] - points[3][1]) * points[2][0]) -
                ((points[2][0] - points[3][0]) * points[2][1]);

        double x = ((e * d) - (b * f)) / ((a * d) - (b * c));
        double y = ((a * f) - (e * c)) / ((a * d) - (b * c));


        interPoint[0] = x;
        interPoint[1] = y;

        return interPoint;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        final int pointsRows = 4;
        final int pointsCol = 2;

        double[][] points = new double[pointsRows][pointsCol];

        System.out.println("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = input.nextDouble();

            }
        }

        double[] intersectingPoints = getIntersectingPoint(points);

        if (intersectingPoints != null) {
            System.out.println("The intersecting point is at: " +
                    "( " + intersectingPoints[0] + ", " + intersectingPoints[1]
                    + " )");
        } else {
            System.out.println("The two lines are parallel");
        }
    }

}
