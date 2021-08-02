package ch_06;

import java.util.*;

/**
 * 6.39 (Geometry: point position) Programming Exercise 3.32 shows how to test whether
 * a point is on the left side of a directed line, on the right, or on the same line.
 * Write the methods with the following headers:
 * /** Return true if point (x2, y2) is on the left side of the
 * * directed line from (x0, y0) to (x1, y1)
 * public static boolean leftOfTheLine(double x0,double y0,
 * double x1,double y1,double x2,double y2)
 * /** Return true if point (x2, y2) is on the same
 * * line from (x0, y0) to (x1, y1)
 * public static boolean onTheSameLine(double x0,double y0,
 * double x1,double y1,double x2,double y2)
 * /** Return true if point (x2, y2) is on the
 * * line segment from (x0, y0) to (x1, y1)
 * public static boolean onTheLineSegment(double x0,double y0,
 * double x1,double y1,double x2,double y2)
 * Write a program that prompts the user to enter the three points for p0,p1,and p2
 * and displays whether p2 is on the left of the line from p0 to p1,right,the same
 * line,or on the line segment.Here are some sample runs:
 * Enter three points for p0,p1,and p2:1 1 2 2 1.51.5
 * (1.5,1.5)is on the line segment from(1.0,1.0)to(2.0,2.0)
 * Enter three points for p0,p1,and p2:1 1 2 2 3 3
 * (3.0,3.0)is on the same line from(1.0,1.0)to(2.0,2.0)
 * Enter three points for p0,p1,and p2:1 1 2 2 1 1.5
 * (1.0,1.5)is on the left side of the line
 * from(1.0,1.0)to(2.0,2.0)
 * Enter three points for p0,p1,and p2:1 1 2 2 1-1
 * (1.0,-1.0)is on the right side of the line
 * from(1.0,1.0)to(2.0,2.0)
 * <br><br>
 * {@code *3.32 (Geometry: point position) Given a directed line from point p0(x0, y0) to p1(x1,
 * y1), you can use the following condition to decide whether a point p2(x2, y2) is
 * on the left of the line, on the right, or on the same line (see Figure 3.11):
 * (x1 - x0)*(y2 - y0) - (x2 - x0)*(y1 - y0) c 7= 60 p2 is on the same line 0 p2 is on the left side of the line 0 p2 is on the right side of the line
 * FIGURE 3.11 (a) p2 is on the left of the line. (b) p2 is on the right of the line. (c) p2 is on the line}
 */
public class Exercise06_39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter three sets of coordinates for the points p0, p1, p2 (ex: 4.4 2 6.5 9.5 -5 4): ");

        double x0 = in.nextDouble();
        double y0 = in.nextDouble();
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();

        String beg = "(" + x2 + "," + y2 + ") is ";
        String end = " line from " + "(" + x0 + "," + y0 + ") to " + "(" + x1 + "," + y1 + ")";
        String det = "";

        if (leftOfTheLine(x0, y0, x1, y1, x2, y2)) {
            det += "on the left side of the";

        } else if (rightOfTheLine(x0, y0, x1, y1, x2, y2)) {
            det += "on the right side of the";

        } else if (onTheSameLine(x0, y0, x1, y1, x2, y2)) {
            det += "on the same line as the";

        } else if (onTheLineSegment(x0, y0, x1, y1, x2, y2)) {
            det += "is on the segment on the line from";
        }

        System.out.println(beg + det + end);
        in.close();
    }

    /**
     * Return true if point (x2, y2) is on the left side of the
     * directed line from (x0, y0) to (x1, y1)
     */
    public static boolean leftOfTheLine(double x0, double y0,
                                        double x1, double y1, double x2, double y2) {
        double determinant = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        return determinant > 0;

    }

    /**
     * Return true if point (x2, y2) is on the right side of the
     * directed line from (x0, y0) to (x1, y1)
     */
    public static boolean rightOfTheLine(double x0, double y0,
                                         double x1, double y1, double x2, double y2) {
        double determinant = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        return determinant < 0;

    }

    /**
     * Return true if point (x2, y2) is on the same
     * line from (x0, y0) to (x1, y1)
     */
    public static boolean onTheSameLine(double x0, double y0,
                                        double x1, double y1, double x2, double y2) {
        double determinant = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        return determinant == 0;

    }

    /**
     * Return true if point (x2, y2) is on the
     * line segment from (x0, y0) to (x1, y1)
     */
    public static boolean onTheLineSegment(double x0, double y0,
                                           double x1, double y1, double x2, double y2) {
        double determinant = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);

        return determinant == 0 && (x2 > x0) && (y2 > y0) && (x2 < x1) && (y2 < y1);

    }
}