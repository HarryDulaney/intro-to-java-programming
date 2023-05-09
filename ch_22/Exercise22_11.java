package ch_22;

import java.util.*;

/**
 * **22.11 (Geometry: Graham’s algorithm for finding a convex hull) Section  22.10.2
 * introduced Graham’s algorithm for finding a convex hull for a set of points.
 * Assume that the Java’s coordinate system is used for the points.
 * Implement the algorithm using the following method:
 * <p>
 * <code>
 * /** Return the points that form a convex hull *\/ <br>
 * public static ArrayList<MyPoint> getConvexHull(double[][]s) <br>
 * // MyPoint is a static inner class defined as follows: <br>
 * private static class MyPoint implements Comparable<MyPoint> {<br>
 * double x, y;<br>
 * MyPoint rightMostLowestPoint;<br>
 * MyPoint(double x, double y) {<br>
 * this.x = x;<br>
 * this.y = y;<br>
 * }<br>
 * public void setRightMostLowestPoint(MyPoint p) {<br>
 * rightMostLowestPoint = p;<br>
 * }<br>
 * \ @Override public int compareTo(MyPoint o) {<br>
 * // Implement it to compare this point with point o<br>
 * // angularly along the x-axis with rightMostLowestPoint<br>
 * // as the center, as shown in Figure 22.10b. By implementing<br>
 * // the Comparable interface, you can use the Array.sort<br>
 * // method to sort the points to simplify coding.<br>
 * }<br>
 * }<br>
 * </code>
 * <br>
 * Write a test program that prompts the user to enter the set size and the points
 * and displays the points that form a convex hull.Here is a sample run:
 * How many points are in the set? 6
 * Enter 6 points: 1 2.4 2.5 2 1.5 34.5 5.5 6 6 2.4 5.5 9
 * The convex hull is
 * (1.5,34.5)(5.5,9.0)(6.0,2.4)(2.5,2.0)(1.0,2.4)
 *
 * <p>
 * <b>Helpful resources:</b>
 * <a href="https://iq.opengenus.org/graham-scan-convex-hull/">Grahams Algorithm with animations</a>
 * </p>
 */
public class Exercise22_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many points are in the set? ");
        int numPoints = scanner.nextInt();
        if (numPoints < 3) {
            throw new RuntimeException("Graham's Algorithm for ConvexHull requires at least 3 points...");
        }

        double[][] points = new double[numPoints][2];
        System.out.print("Enter " + numPoints + " points: ");

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = scanner.nextDouble();
            }
        }
        List<MyPoint> result = getConvexHull(points);
        System.out.println("The convex hull is: ");
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static ArrayList<MyPoint> getConvexHull(double[][] s) {
        /* Find Lowest and Rightest Point */
        double yMin = s[0][1];
        int minPos = 0;
        // Find the bottom most point
        for (int i = 1; i < s.length; i++) {
            double y = s[i][1];
            // Pick the bottom-most or chose the right
            // most point in case of tie
            if ((y < yMin) || (yMin == y && s[i][0] > s[minPos][0])) {
                yMin = s[i][1];
                minPos = i;

            }
        }
        // Swamp the bottom-most point for first position
        double[] temp = s[0];
        s[0] = s[minPos];
        s[minPos] = temp;
        MyPoint rightMostLowestPoint = new MyPoint(s[0][0], s[0][1]);
        ArrayList<MyPoint> rawPoints = new ArrayList<>();
        rawPoints.add(rightMostLowestPoint);
        // Create array of MyPoint objects and set rightMostLowestPoint
        for (int i = 1; i < s.length; i++) {
            MyPoint pt = new MyPoint(s[i][0], s[i][1]);
            pt.setRightMostLowestPoint(rightMostLowestPoint);
            rawPoints.add(pt);
        }
        ArrayList<MyPoint> cleanedPoints = new ArrayList<>();
        cleanedPoints.add(rightMostLowestPoint);
        //Clean points with same angle
        for (int i = 1; i < rawPoints.size() - 1; i++) {
            // Only add points where the angle of p[i] and p[i+1] is NOT the same with respect to p0
            if (orientation(rightMostLowestPoint, rawPoints.get(i), rawPoints.get(i + 1)) != 0) {
                cleanedPoints.add(rawPoints.get(i));
            }
        }
        // If modified array of points has less than 3 points,
        // convex hull is not possible
        if (cleanedPoints.size() < 3) {
            throw new RuntimeException("Graham's Algorithm for ConvexHull requires " +
                    "at least 3 points with different angles...");
        }
        Collections.sort(cleanedPoints);
        // Graham scan
        // Create an empty stack and push first three points to it
        Stack<MyPoint> stack = new Stack<>();
        int m = cleanedPoints.size();
        stack.push(cleanedPoints.get(0)); // p0 (lowest and rightest point)
        stack.push(cleanedPoints.get(1)); // p1
        stack.push(cleanedPoints.get(2)); // p2
        // Process remaining n-3 points
        for (int i = 3; i < m; i++) {
            // Keep removing top while the angle formed by
            // points next-to-top, top, and points[i] makes
            // a non-left turn
            while (orientation(nextToTop(stack), stack.peek(), cleanedPoints.get(i)) != 2) {
                stack.pop();
                stack.push(cleanedPoints.get(i));
            }

        }
        // Now stack has the output points, print contents of stack

        return new ArrayList<>(stack);
    }

    /**
     * To find orientation of ordered triplet (p, q, r).
     *
     * @param p first point
     * @param q second point
     * @param r third point
     * @return 0 --> p, q and r are co-linear
     * 1 --> Clockwise
     * 2 --> Counterclockwise
     */
    static int orientation(MyPoint p, MyPoint q, MyPoint r) {
        double val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0;  // co-linear
        return (val > 0) ? 1 : 2; // clock or counter-clock wise
    }


    /**
     * A utility function to return square of distance
     * between p1 and p2
     */
    static double distSq(MyPoint p1, MyPoint p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) +
                (p1.y - p2.y) * (p1.y - p2.y);
    }

    /**
     * A utility function to find next to top in a stack
     */
    static MyPoint nextToTop(Stack<MyPoint> s) {
        MyPoint p = s.pop();
        MyPoint res = s.peek();
        s.push(p);
        return res;
    }


    private static class MyPoint implements Comparable<MyPoint> {
        double x, y;
        MyPoint rightMostLowestPoint;

        MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public void setRightMostLowestPoint(MyPoint p) {
            rightMostLowestPoint = p;
        }

        /**
         * Implement it to compare this point with point o
         * angularly along the x-axis with rightMostLowestPoint
         * as the center, as shown in Figure 22.10b. By implementing
         * the Comparable interface, you can use the Array.sort()
         * method to sort the points to simplify coding.
         */
        @Override
        public int compareTo(MyPoint o) {
            // Find orientation
            int orientation = orientation(rightMostLowestPoint, this, o);
            if (orientation == 0) {
                return distSq(rightMostLowestPoint, o) >= distSq(rightMostLowestPoint, this) ? -1 : 1;
            }
            return (orientation == 2) ? -1 : 1;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

}
