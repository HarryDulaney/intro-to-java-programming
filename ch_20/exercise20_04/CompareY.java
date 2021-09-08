package ch_20.exercise20_04;

import java.util.Comparator;

/**
 * Define a class named CompareY that implements Comparator<Point>.
 * Implement the compare method to compare two points on their y-coordinates.
 * If two points have the same y-coordinates, compare their x-coordinates.
 */
public class CompareY implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        int resultY;
        if (p1.y < p2.y) {
            resultY = -1;
        } else if (p1.y > p2.y) {
            resultY = 1;
        } else {
            resultY = 0;
        }
        if (resultY == 0) {
            if (p1.x < p2.x) {
                return -1;
            }
            if (p1.x > p2.x) {
                return 1;
            }
            return 0;
        }
        return resultY;
    }
}
