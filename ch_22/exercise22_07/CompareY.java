package ch_22.exercise22_07;

import java.util.Comparator;

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
