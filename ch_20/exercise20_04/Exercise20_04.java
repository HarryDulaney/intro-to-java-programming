package ch_20.exercise20_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * *20.4 (Sort points in a plane) Write a program that meets the following requirements:
 * ■ Define a class named Point with two data fields x and y to represent a
 * point’s x- and y-coordinates. Implement the Comparable interface for comparing the points on x-coordinates.
 * If two points have the same x-coordinates, compare their y-coordinates.
 * ■ Define a class named CompareY that implements Comparator<Point>.
 * Implement the compare method to compare two points on their y-coordinates.
 * If two points have the same y-coordinates, compare their x-coordinates.
 * ■ Randomly create 100 points and apply the Arrays.sort method to display
 * the points in increasing order of their x-coordinates and in increasing order
 * of their y-coordinates, respectively.
 */
public class Exercise20_04 {
    private static Point[] points = new Point[100];
    private static CompareY comparator = new CompareY();

    public static void main(String[] args) {
        Random randomPoint = new Random();
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(randomPoint.nextDouble() * randomPoint.nextInt(999), randomPoint.nextDouble() * randomPoint.nextInt(999));
        }
        System.out.println("Created 100 Random Points: ");
        for (Point point : points) {
            System.out.print(point.toString());
        }

        System.out.println("Increasing order by the x-coordinates: ");
        Arrays.sort(points);
        for (Point point : points) {
            System.out.print(point.toString());
        }

        System.out.println("Increasing order by the y-coordinates: ");
        Arrays.sort(points, comparator);
        for (Point point : points) {
            System.out.print(point.toString());
        }
    }
}
