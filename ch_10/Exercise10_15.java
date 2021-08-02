package ch_10;

import ch_10.exercise10_13.MyRectangle2D;

import java.util.Scanner;

/**
 * *10.15 (Geometry: the bounding rectangle) A bounding rectangle is the minimum rectangle
 * that encloses a set of points in a two-dimensional plane, as shown in
 * Figure 10.24d. Write a method that returns a bounding rectangle for a set of
 * points in a two-dimensional plane, as follows:
 * public static MyRectangle2D getRectangle(double[][] points)
 * <p>
 * The Rectangle2D class is defined in Programming Exercise 10.13.
 * Write a test program that prompts the user to enter five points and displays the bounding
 * rectangle’s center, width, and height. Here is a sample run:
 * Enter five points: 1.0 2.5 3 4 5 6 7 8 9 10
 * The bounding rectangle's center (5.0, 6.25), width 8.0, height 7.5
 * <p>
 * About Bounding Rectangle:
 * The top of the rectangle is determined by the y-coordinate of the top-most point - point B
 * The bottom of the rectangle is determined by the y-coordinate of the lowest point - point D
 * The left side of the rectangle is determined by the x-coordinate of the leftmost point - point A
 * The right of the rectangle is determined by the x-coordinate of the rightmost point - point C
 */
public class Exercise10_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter five points:");

        double[][] pts = new double[5][2];
        for (int i = 0; i < pts.length; i++) {
            for (int j = 0; j < pts[i].length; j++) {
                pts[i][j] = in.nextDouble();
            }
        }
        MyRectangle2D rectangle2D = getRectangle(pts);
        System.out.print("\nThe bounding rectangle's center (" + rectangle2D.getX() + "," + rectangle2D.getY() + ")" +
                "," + " width: " + rectangle2D.getWidth() + "," + " height: " + rectangle2D.getHeight() + ")");
    }


    public static MyRectangle2D getRectangle(double[][] points) {
        double[] lowestPoint = lowestPoint(points);
        double[] highestPoint = highestPoint(points);
        double[] leftMostPoint = leftMostPoint(points);
        double[] rightMostPoint = rightMostPoint(points);

        double height = Math.abs(highestPoint[1]) - Math.abs(lowestPoint[1]);
        double width = Math.abs(rightMostPoint[0]) - Math.abs(leftMostPoint[0]);
        MyRectangle2D resultRectangle2D = new MyRectangle2D();
        resultRectangle2D.setHeight(height);
        resultRectangle2D.setWidth(width);
        double centerX = leftMostPoint[0] + (width / 2);
        double centerY = lowestPoint[1] + (height / 2);
        resultRectangle2D.setX(centerX);
        resultRectangle2D.setY(centerY);

        return resultRectangle2D;

    }

    static double[] lowestPoint(double[][] pts) {
        double[] lowPt = pts[0];
        for (int n = 1; n < pts.length; n++) {
            lowPt = pts[n][1] < lowPt[1] ? pts[n] : lowPt;
        }
        return lowPt;
    }

    static double[] highestPoint(double[][] pts) {
        double[] hiPt = pts[0];
        for (int n = 1; n < pts.length; n++) {
            hiPt = pts[n][1] > hiPt[1] ? pts[n] : hiPt;
        }
        return hiPt;
    }

    static double[] rightMostPoint(double[][] pts) {
        double[] rghtPt = pts[0];
        for (int n = 1; n < pts.length; n++) {
            rghtPt = pts[n][0] > rghtPt[0] ? pts[n] : rghtPt;
        }
        return rghtPt;
    }

    static double[] leftMostPoint(double[][] pts) {
        double[] lftPt = pts[0];
        for (int n = 1; n < pts.length; n++) {
            lftPt = pts[n][0] < lftPt[0] ? pts[n] : lftPt;
        }
        return lftPt;
    }

}
