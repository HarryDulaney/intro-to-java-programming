package ch_10.exercise10_12;

import ch_10.exercise10_04.MyPoint;

/**
 * ***10.12 (Geometry: the Triangle2D class) Define the Triangle2D class that contains:
 * ■ Three points named p1, p2, and p3 of the type MyPoint with getter and
 * setter methods. MyPoint is defined in Programming Exercise 10.4.
 * ■ A no-arg constructor that creates a default triangle with the points (0, 0), (1,1), and (2, 5).
 * ■ A constructor that creates a triangle with the specified points.
 * ■ A method getArea() that returns the area of the triangle.
 * ■ A method getPerimeter() that returns the perimeter of the triangle.
 * ■ A method contains(MyPoint p) that returns true if the specified point p is inside this triangle (see Figure
 * 10.22a).
 * <p>
 * ■ A method contains(Triangle2D t) that returns true if the specified
 * triangle is inside this triangle (see Figure 10.22b).
 * ■ A method overlaps(Triangle2D t) that returns true if the specified
 * triangle overlaps with this triangle (see Figure 10.22c).
 * <p>
 * Draw the UML diagram for the class and then implement the class.
 * <p>
 * <p>
 * (Hint: For the formula to compute the area of a triangle,
 * * see Programming Exercise 2.19. To detect whether a point is inside a triangle, draw three dashed lines,
 * * as shown in Figure 10.23. If the point is inside a triangle, each dashed line
 * * should intersect a side only once. If a dashed line intersects a side twice, then
 * * the point must be outside the triangle. For the algorithm of finding the intersecting
 * * point of two lines, see Programming Exercise 3.25.)
 */
public class Triangle2D {
    /*
     * ■ Three points named p1, p2, and p3 of the type MyPoint with getter and
     * setter methods. MyPoint is defined in Programming Exercise 10.4.
     */
    private MyPoint p1;
    private MyPoint p2;
    private MyPoint p3;

    /**
     * ■ A no-arg constructor that creates a default triangle with the points (0, 0), (1,1), and (2, 5).
     */
    public Triangle2D() {
        p1 = new MyPoint(0, 0);
        p2 = new MyPoint(1, 1);
        p3 = new MyPoint(2, 5);
    }

    /**
     * A constructor that creates a triangle with the specified points.
     *
     * @param p1 MyPoint one of the triangle
     * @param p2 MyPoint two of the triangle
     * @param p3 MyPoint three of the triangle
     */
    public Triangle2D(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    /**
     * ■ A method getArea() that returns the area of the triangle.
     *
     * @return area of the triangle
     */
    public double getArea() {
        double side1 = p1.distance(p2);
        double side2 = p2.distance(p3);
        double side3 = p3.distance(p1);
        double s = (side1 + side2 + side3) / 2;

        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * ■ A method getPerimeter() that returns the perimeter of the triangle.
     *
     * @return perimeter of the triangle
     */
    public double getPerimeter() {
        return p1.distance(p2)
                + p2.distance(p3)
                + p3.distance(p1);

    }

    /**
     * ■ A method contains(MyPoint p) that returns true if the
     * specified point p is inside this triangle.
     *
     * @param p MyPoint to check with current Triangle
     * @return true if p inside this.Triangle2D
     */
    public boolean contains(MyPoint p) {
        /* Find determinant of triangle */
        double a = p2.getY() - p3.getY();
        double b = p3.getX() - p2.getX();
        double c = p3.getY() - p1.getY();
        double d = p2.getX() - p3.getX();
        double determinant = a * d - b * c;
        double maxDet = Math.max(determinant, 0);
        double minDet = Math.min(determinant, 0);
        double detOfx = p.getX() - p3.getX();
        double detOfy = p.getY() - p3.getY();
        double s = a * detOfx + b * detOfy;
        double t = c * detOfx + d * detOfy;
        double z = determinant - s - t;
        return !(s < minDet || s > maxDet) ||
                !(t < minDet || t > maxDet) ||
                !(z < minDet || z > maxDet);

    }

    /**
     * ■ A method contains(Triangle2D t) that returns true if the specified
     * * triangle is inside this triangle (see Figure 10.22b).
     *
     * @param t Triangle2D to test if it is inside of this.Triangle2D
     * @return true if t is inside of this
     */
    public boolean contains(Triangle2D t) {
        return this.contains(t.getP1()) && this.contains(t.getP2()) && this.contains(t.getP3());


    }

    /**
     * ■ A method overlaps(Triangle2D t) that returns true if the specified
     * triangle overlaps with this triangle (see Figure 10.22c).
     *
     * @param t Triangle2D to check for overlap on current Triangle
     * @return true if t overlaps this.Triangle2D
     */
    public boolean overlaps(Triangle2D t) {
        return this.contains(t.getP1()) || this.contains(t.getP2()) || this.contains(t.getP3());
    }


    public MyPoint getP1() {
        return p1;
    }

    public void setP1(MyPoint p1) {
        this.p1 = p1;
    }

    public MyPoint getP2() {
        return p2;
    }

    public void setP2(MyPoint p2) {
        this.p2 = p2;
    }

    public MyPoint getP3() {
        return p3;
    }

    public void setP3(MyPoint p3) {
        this.p3 = p3;
    }


}
