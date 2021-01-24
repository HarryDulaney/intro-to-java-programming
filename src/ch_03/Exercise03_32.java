package ch_03;

import java.util.*;

/**
 * *3.32 (Geometry: point position) Given a directed line from point p0(x0, y0) to p1(x1,
 * y1), you can use the following condition to decide whether a point p2(x2, y2) is
 * on the left of the line, on the right, or on the same line (see Figure 3.11):
 * (x1 - x0)*(y2 - y0) - (x2 - x0)*(y1 - y0) c 7= 60 p2 is on the same line 0 p2 is on the left side of the line 0 p2 is on the right side of the line
 * FIGURE 3.11 (a) p2 is on the left of the line. (b) p2 is on the right of the line. (c) p2 is on
 * <p>
 * <p>
 * Write a program that prompts the user to enter the three points for p0, p1, and p2
 * and displays whether p2 is on the left of the line from p0 to p1, on the right, or on
 * the same line. Here are some sample runs:
 * <p>
 * Enter three points for p0, p1, and p2: 4.4 2 6.5 9.5 -5 4
 * (-5.0, 4.0) is on the left side of the line from (4.4, 2.0) to (6.5, 9.5)
 * Enter three points for p0, p1, and p2: 1 1 5 5 2 2
 * (2.0, 2.0) is on the line from (1.0, 1.0) to (5.0, 5.0)
 * Enter three points for p0, p1, and p2: 3.4 2 6.5 9.5 5 2.5
 * (5.0, 2.5) is on the right side of the line from (3.4, 2.0) to (6.5, 9.5)
 *
 * @author Harry Dulaney
 */
public class Exercise03_32 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter three sets of coordinates for the points p0, p1, p2 (ex: 4.4 2 6.5 9.5 -5 4): ");

        double x0 = in.nextDouble();
        double y0 = in.nextDouble();
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();

        double determinant = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        String beg = "(" + x2 + "," + y2 + ") is ";
        String end = " line from " + "(" + x0 + "," + y0 + ") to " + "(" + x1 + "," + y1 + ")";
        String det = "";

        if (determinant > 0) {

            det += "on the left side of the";
        } else if (determinant < 0) {
            det += "on the right side of the";

        } else if (determinant == 0) {
            det += "on the same line as the";

        } else {
            System.out.println("Something went wrong...");
            System.exit(0);
        }

        System.out.println(beg + det + end);
        in.close();
    }
}