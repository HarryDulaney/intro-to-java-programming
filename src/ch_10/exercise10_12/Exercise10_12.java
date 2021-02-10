package ch_10.exercise10_12;

import ch_10.exercise10_04.MyPoint;

/**
 * Write a test program that creates a Triangle2D objects t1 using the constructor
 * new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3),
 * new MyPoint(5, 3.5)), displays its area and perimeter,
 * and displays the
 * result of t1.contains(3, 3),
 * r1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), MyPoint(1, 3.4))), and
 * t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4, -3), MyPoint(2, 6.5))).
 */
public class Exercise10_12 {
    public static void main(String[] args) {
        Triangle2D t1 = new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5));
        System.out.print("For the Triangle2D, 't1' ");
        System.out.println("Area = " + t1.getArea());
        System.out.println(" Perimeter = " + t1.getPerimeter());
        System.out.println("Result of t1.contains(3,3) = " + t1.contains(new MyPoint(3, 3)));

        System.out.println("Result of t1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), MyPoint(1, 3" +
                ".4))) = " + t1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), new MyPoint(1, 3.4))));
        System.out.println("Result of t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4, -3), MyPoint(2, " +
                "6.5))) = " + t1.overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4, -3), new MyPoint(2, 6.5))));

    }
}
