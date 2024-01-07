package ch_22;

import java.util.*;

/**
 * **22.13 (Geometry: convex hull animation) Programming Exercise 22.11 finds a convex hull for a set of points
 * entered from the console. Write a program that enables the user to add/remove points by clicking the left/right
 * mouse button, and displays a convex hull, as shown in Figure 22.8c.
 */
public class Exercise22_13 {
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
        /* Grahams Algorithm:
         Step 1: Given a list of points S, select the rightmost lowest.
         */
        double[] lowestRightMostPt = s[0]; // initialize to first point
        for (int i = 1; i < s.length; i++) {
            double[] nextPt = s[i];
            // Pick the bottom-most or chose the right
            // most point in case of tie
            lowestRightMostPt = getLowestRightMostPoint(lowestRightMostPt, nextPt);
        }
        MyPoint rightMostLowestPoint = new MyPoint(lowestRightMostPt[0], lowestRightMostPt[1]);
        /*
        Step 2: Sort the points in S angularly along the x-axis with p0 as the
        center, as shown in Figure 22.10b. If there is a tie and two points have
        the same angle, discard the one that is closer to p0. The points in S are
        now sorted as p0, p1, p2, ..., pn-1.
         */
        // For Step 2 - We use Comparable interface to sort the points to simplify coding.
        ArrayList<MyPoint> pointsList = new ArrayList<>();
        for (double[] pt : s) {
            MyPoint p = new MyPoint(pt[0], pt[1]);
            p.setRightMostLowestPoint(rightMostLowestPoint);
            pointsList.add(p);
        }

        // If modified array of points has less than 3 points,
        // convex hull is not possible
        if (pointsList.size() < 3) {
            throw new RuntimeException("Graham's Algorithm for ConvexHull requires " +
                    "at least 3 points with different angles...");
        }
        Collections.sort(pointsList);
        // Graham scan
        // Create an empty stack and push first three points to it
       /* Step 3: Push p0, p1, and p2 into stack H. (After the algorithm finishes,
                H contains all the points in the convex hull.)
        i = 3;
        while (i < n) {
            Let t1 and t2 be the top first and second element in stack H;
            if (pi is on the left side of the direct line from t2 to t1) {
                Push pi to H;
                i++; // Consider the next point in S.
            }
                       else
            Pop the top element off stack H.
        }
        Step 5: The points in H form a convex hull.
        */
        Stack<MyPoint> stack = new Stack<>();
        int m = pointsList.size();
        MyPoint p0 = pointsList.get(0);
        MyPoint p1 = pointsList.get(1);
        MyPoint p2 = pointsList.get(2);
        stack.push(p0);
        stack.push(p1);
        stack.push(p2);
        // Process remaining n-3 points
        int i = 3;
        while (i < m) {
            // Keep removing top while the angle formed by
            // points next-to-top, top, and points[i] makes
            // a non-left turn
            MyPoint p3 = pointsList.get(i);
            int orientation = orientation(p2, p1, p3);
            if (orientation == 2) {
                stack.push(p3);
            } else if (orientation == 1) {
                stack.pop(); // pop p2
                stack.push(p3);
            } else {
                stack.pop(); // pop p2
            }
            p2 = stack.peek();
            p1 = stack.get(stack.size() - 2);
            i++;

        }
        // Now stack has the output points, print contents of stack
        return new ArrayList<>(stack);
    }


    static double[] getLowestRightMostPoint(double[] pt1, double[] pt2) {
        if (pt2[1] < pt1[1]) {
            return pt2;
        } else if (pt2[1] == pt1[1]) {
            if (pt2[0] > pt1[0]) {
                return pt2;
            }
        }
        return pt1;
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
                double distSqObj1 = distSq(rightMostLowestPoint, this);
                double distSqObj2 = distSq(rightMostLowestPoint, o);
                return Double.compare(distSqObj1, distSqObj2);
            }
            return (orientation == 2) ? 1 : -1;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }

    }

}