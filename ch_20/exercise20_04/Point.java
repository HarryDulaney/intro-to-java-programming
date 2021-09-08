package ch_20.exercise20_04;

/**
 * ■ Define a class named Point with two data fields x and y to represent a
 * * point’s x- and y-coordinates.
 * Implement the Comparable interface for comparing the points on x-coordinates.
 * If two points have the same x-coordinates, compare their y-coordinates.
 */
public class Point implements Comparable<Point> {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public Point setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public Point setY(double y) {
        this.y = y;
        return this;
    }


    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                "}\n";
    }

    @Override
    public int compareTo(Point that) {
        if (this.x == that.x) {
            if (this.y < that.y) {
                return -1;
            }
            if (this.y > that.y) {
                return 1;
            }
            return 0; // this.y == that.y

        } else {
            if (this.x < that.x) {
                return -1;
            }
            if (this.x > that.x) {
                return 1;
            }
            return 0;//this.x == that.x

        }

    }

}
