package ch_10.exercise10_04;

/**
 * Write a test program that creates the two points (0, 0) and (10, 30.5) and displays the
 * distance between them.
 */
public class Exercise10_04 {
    public static void main(String[] args) {
        MyPoint p1 = new MyPoint(0, 0);
        MyPoint p2 = new MyPoint(10, 30.5);

        System.out.printf("The distance between p1 and p2 is %.4f", p2.distance(p1));
    }

}
