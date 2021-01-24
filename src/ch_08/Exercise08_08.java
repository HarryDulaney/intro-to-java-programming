package ch_08;

/**
 * **8.8 (All closest pairs of points) Revise Listing 8.3,
 * FindNearestPoints.java, to display all closest pairs of points with the same
 * minimum distance.
 * 
 * Here is a sample run:
 * 
 * Enter the number of points: 8 Enter 8 points: 0 0 1 1 -1 -1 2 2 -2 -2 -3 -3
 * -4 -4 5 5
 * 
 * The closest two points are (0.0, 0.0) and (1.0, 1.0)
 * 
 * The closest two points are (0.0, 0.0) and (-1.0, -1.0)
 * 
 * The closest two points are (1.0, 1.0) and (2.0, 2.0)
 * 
 * The closest two points are (-1.0, -1.0) and (-2.0, -2.0)
 * 
 * The closest two points are (-2.0, -2.0) and (-3.0, -3.0)
 * 
 * The closest two points are (-3.0, -3.0) and (-4.0, -4.0)
 * 
 * Their distance is 1.4142135623730951
 *
 */
public class Exercise08_08 {

	private static int[][] points;
	static double shortestDist;

	static {
		points = new int[][] { { 0, 0 }, { 1, 1 }, { -1, -1 }, { 2, 2 }, { -2, -2 }, { -3, -3 }, { -4, -4 }, { 5, 5 } };
	}

	public static void main(String[] args) {

		shortestDist = distance(points[0][0], points[0][1], points[1][0], points[1][1]); // Initialize
		// Find shortest Distance
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double shrtTest = distance(points[i][0], points[i][1], points[j][0], points[j][1]); // Find distance
				if (shrtTest < shortestDist) {
					shortestDist = shrtTest;
				}
			}
		}
		// Print points with distance between equal to shortest distance
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double d = distance(points[i][0], points[i][1], points[j][0], points[j][1]); // check distance
				if (d == shortestDist) {
					System.out.println("The closest two points are (" + points[i][0] + "," + points[i][1] + ") and ("
																	+ points[j][0] + ", " + points[j][1] + ")");
				}

			}
		}
		System.out.print("Their distance is " + shortestDist);

	}

	public static double distance(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
}