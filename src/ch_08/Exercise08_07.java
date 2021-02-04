package ch_08;


/**
 * *8.7 (Points nearest to each other) Listing 8.3 gives a program that finds
 * two points in a two-dimensional space nearest to each other. Revise the
 * program so that it finds two points in a three-dimensional space nearest to
 * each other. Use a two-dimensional array to represent the points. Exercise25_01 the
 * program using the following points: double[][] points = {{-1, 0, 3}, {-1, -1,
 * -1}, {4, 1, 1}, {2, 0.5, 9}, {3.5, 2, -1}, {3, 1.5, 3}, {-1.5, 4, 2}, {5.5,
 * 4, -0.5}};
 * 
 * The formula for computing the distance between two points (x1, y1, z1) and
 * (x2, y2, z2) is SQRT[(x2 - x1)^2 + (y2 - y1)^2 + (z2 - z1)^2].
 * 
 * @author Harry Dulaney
 *
 */
public class Exercise08_07 {
	static double[][] points = { { -1, 0, 3 }, { -1, -1, -1 }, { 4, 1, 1 }, { 2, 0.5, 9 }, { 3.5, 2, -1 },
			{ 3, 1.5, 3 }, { -1.5, 4, 2 }, { 5.5, 4, -0.5 } };

	public static void main(String[] args) {
		findDistance3D();
	}

	public static void findDistance3D() {

		int p1 = 0, p2 = 1, p3 = 2; // Initial 2 points
		double shortestDistance = distance(points[p1][0], points[p1][1], points[p2][0], points[p2][1], points[p3][0],
				points[p3][1]);

		// Compute distance for every 2 points
		for (int i = 0; i < points.length; i++) {
			for (int j = i + 1; j < points.length; j++) {
				double distance = distance(points[i][0], points[i][1], points[i][2], points[j][0], points[j][1],
						points[j][2]);
				if (shortestDistance > distance) {
					p1 = i;
					p2 = j;
					p3 = j;
					shortestDistance = distance; // Update shortestDistance
				}
			}
		}

		System.out.println("The closest 2 points are " + "(" + points[p1][0] + ", " + points[p1][1] + ", "
				+ points[p1][2] + ") and (" + points[p2][0] + ", " + points[p2][1] + ", " + points[p2][2] + ")");
	}

	public static double distance(double x1, double y1, double z1, double x2, double y2, double z2) {
		return Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)) + ((z2 - z1) * (z2 - z1)));
	}

}