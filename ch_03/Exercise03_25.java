package ch_03;

import java.util.*;

/**
 * *3.25 (Geometry: intersecting point) Two points on line 1 are given as (x1, y1) and (x2,
 * y2) and on line 2 as (x3, y3) and (x4, y4), as shown in Figure 3.8a–b.
 * The intersecting point of the two lines can be found by solving the following
 * linear equation:
 * (y1 - y2)x - (x1 - x2)y = (y1 - y2)x1 - (x1 - x2)y1
 * (y3 - y4)x - (x3 - x4)y = (y3 - y4)x3 - (x3 - x4)y3
 *
 * <p>
 * This linear equation can be solved using Cramer’s rule (see Programming Exercise 3.3).
 * If the equation has no solutions, the two lines are parallel (Figure 3.8c).
 * <p>
 * <p>
 * Write a program that prompts the user to enter four points and displays the intersecting point.
 * <p>
 * Here are sample runs:
 * Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 5 -1.0 4.0 2.0 -1.0 -2.0
 * The intersecting point is at (2.88889, 1.1111)
 * <p>
 * Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 7 6.0 4.0 2.0 -1.0 -2.0
 * The two lines are parallel
 *
 */
public class Exercise03_25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter x1, y1, x2, y2, x3, y3, x4, y4: ");
        double x1, x2, x3, x4, y1, y2, y3, y4;
        try {
            x1 = in.nextDouble();
            y1 = in.nextDouble();
            x2 = in.nextDouble();
            y2 = in.nextDouble();
            x3 = in.nextDouble();
            y3 = in.nextDouble();
            x4 = in.nextDouble();
            y4 = in.nextDouble();

//  breakdown:  {  a -> [(y1 - y2)]} x    -   { b -> [(x1 - x2)]} y   =  { e -> [(y1 - y2)x1 - (x1 - x2)y1] }
//              {  c -> [(y3 - y4)]} x    -   { d -> [(x3 - x4)]} y    =  { f -> [(y3 - y4)x3 - (x3 - x4)y3] }

            double a, b, c, d, e, f;
            a = y1 - y2;
            b = -(x1 - x2);
            c = y3 - y4;
            d = -(x3 - x4);
            e = a * x1 - b * y1;
            f = c * x3 - d * y3;

            double DxDy = a * d - b * c;

            if (DxDy < 0.000000001) {
                System.out.println("The equation has no solution because the lines are parallel.");

            } else {

                double x = (e * d - b * f) / DxDy;  //(a * d - b * c)
                double y = (a * f - e * c) / DxDy;  //(a * d - b * c)

                System.out.println("The intersecting point is at (" + x + "," + y + ")");
            }


        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println("Please enter values matching the prompt.");
            System.out.println(e.toString());
        }


    }
}