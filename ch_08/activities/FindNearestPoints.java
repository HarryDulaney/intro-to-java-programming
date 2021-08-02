package ch_08.activities;

import java.util.Scanner;

/**
 * Listing 8.3 FindNearestPoints.java from (8.6 Case Study: Finding the Closest
 * Pair) Given a set of points, the closest-pair problem is to find the two
 * points that are nearest to each other.
 * 
 * In Figure 8.3, for example, points (1, 1) and (2, 0.5) are closest to each
 * other. There are several ways to solve this problem. An intuitive approach is
 * to compute the distances between all pairs of points and find the one with
 * the minimum distance, as implemented in Listing 8.3
 */
public class FindNearestPoints {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of points: ");
		int numberOfPoints = input.nextInt();

		// Create an array to store points
		double[][] points = new double[numberOfPoints][2];

		System.out.print("Enter " + numberOfPoints + " points: ");

		for (int i = 0; i < points.length; i++) {
			points[i][0] = input.nextDouble();
			points[i][1] = input.nextDouble();
		}

		// p1 and p2 are the indices in the points' array
		int p1 = 0, p2 = 1; // Initial two points
		double shortestDistance = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1]); // Initialize
																										// shortestDistance
		// Compute distance for every two points
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double distance = distance(points[i][0], points[i][1], points[j][0], points[j][1]); // Find distance
				if (shortestDistance > distance) {
					p1 = i; // Update p1
					p2 = j; // Update p2
					shortestDistance = distance; // Update shortestDistance
				}
			}
		}
		// Display result
		System.out.println("The closest two points are " + "(" + points[p1][0] + ", " + points[p1][1] + ") and ("
				+ points[p2][0] + ", " + points[p2][1] + ")");
	}

	/** Compute the distance between two points (x1, y1) and (x2, y2) */
	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
}
