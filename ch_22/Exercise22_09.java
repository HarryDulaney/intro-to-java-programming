package ch_22;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * **22.9 (Geometry: gift-wrapping algorithm for finding a convex hull) Section 22.10.1
 * introduced the gift-wrapping algorithm for finding a convex hull for a set of
 * points. Assume that the Java’s coordinate system is used for the points.
 * Implement the algorithm using the following method:
 * // Return the points that form a convex hull
 * public static ArrayList<Point2D> getConvexHull(double[][]s)
 * Point2D is defined in Section 9.6.
 * Write a test program that prompts the user to enter the set size and the points
 * and displays the points that form a convex hull.
 * Here is a sample run:
 * <p>
 * How many points are in the set? 6
 * Enter 6 points: 1 2.4 2.5 2 1.5 34.5 5.5 6 6 2.4 5.5 9
 * The convex hull is
 * (1.5, 34.5) (5.5, 9.0) (6.0, 2.4) (2.5, 2.0) (1.0, 2.4)
 */
public class Exercise22_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many points are in the set? ");
        int numPoints = scanner.nextInt();
        System.out.print("Enter " + numPoints + " points: ");

        double[][] points = new double[numPoints][2];

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = scanner.nextDouble();
            }
        }
        scanner.close();
        List<Point2D> convexHull = getConvexHull(points);
        System.out.println("The convex hull is: ");
        for (Point2D point : convexHull) {
            System.out.print("(" + point.getX() + ", " + point.getY() + ") ");
        }


    }


    public static ArrayList<Point2D> getConvexHull(double[][] s) {
        int n = s.length;
        // map matrix into List of Point2D's
        List<Point2D> S = Arrays.stream(s).map(points -> new Point2D(points[0], points[1])).collect(Collectors.toList());
        // Created list to hold the points in the convex hull
        ArrayList<Point2D> H = new ArrayList<>();
        // Find the leftmost point
        int l = 0;
        for (int i = 1; i < n; i++)
            if (S.get(i).getX() < S.get(l).getX()) {
                l = i;
            }

        int p = l, q;
        do {
            H.add(S.get(p));

            q = (p + 1) % n;

            for (int i = 0; i < n; i++) {
                if (getOrientation(S.get(p), S.get(i), S.get(q)) == -1) {
                    q = i;
                }
            }
            p = q;

        } while (p != l);

        return H;
    }

    public static int getOrientation(Point2D p, Point2D q, Point2D r) {
        double val = (q.getY() - p.getY()) * (r.getX() - q.getX()) - (q.getX() - p.getX()) * (r.getY() - q.getY());

        if (val == 0) return 0;
        return (val > 0) ? 1 : -1;
    }
}
