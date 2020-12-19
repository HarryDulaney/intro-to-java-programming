package ch_03;

import java.util.*;

/**
 * *3.25 (Geometry: intersecting point) Two points on line 1 are given as (x1, y1) and (x2,
 * y2) and on line 2 as (x3, y3) and (x4, y4), as shown in Figure 3.8a–b.
 * The intersecting point of the two lines can be found by solving the following
 * linear equation:
 * (y1 - y2)x - (x1 - x2)y = (y1 - y2)x1 - (x1 - x2)y1
 * (y3 - y4)x - (x3 - x4)y = (y3 - y4)x3 - (x3 - x4)y3
 * <p>
 * This linear equation can be solved using Cramer’s rule (see Programming Exercise 3.3).
 * If the equation has no solutions, the two lines are parallel (Figure 3.8c).
 * <p>
 * Write a program that prompts the user to enter four points and displays the intersecting point. Here are sample runs:
 * Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 5 -1.0 4.0 2.0 -1.0 -2.0
 * The intersecting point is at (2.88889, 1.1111)
 * Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 7 6.0 4.0 2.0 -1.0 -2.0
 * The two lines are parallel
 * FIGURE 3.8 Two lines intersect in (a and b) and two lines are parallel in (c).
 * (x1, y1)
 * (x2, y2) (x3, y3)
 * (x4, y4)
 * (a) (b) (c)
 * (x1, y1)
 * (x2, y2)
 * (x3, y3)
 * (x4, y4)
 * (x1, y1)
 * (x2, y2)
 * (x3, y3)
 * (x4, y4)
 *
 * @author Harry Dulaney
 */
public class E0325 {
    public static void main(String[] args) {
    }
}