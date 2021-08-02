package ch_10.exercise10_13;

/**
 * Write a test program that creates a MyRectangle2D object r1 (new MyRectangle2D(2,
 * 2, 5.5, 4.9)), displays its area and perimeter, and displays the result of
 * r1.contains(3, 3), r1.contains(new MyRectangle2D(4, 5, 10.5,
 * 3.2)), and r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)).
 */
public class Exercise10_13 {
    public static void main(String[] args) {
        MyRectangle2D r1 = new MyRectangle2D(2, 2, 5.5, 4.9);
        String area = String.format("MyRectangle2D r1's area = %.3f\n", r1.getArea());
        String perimeter = String.format("Perimeter = %.3f\n", r1.getPerimeter());
        System.out.print(area);
        System.out.print(perimeter);

        System.out.println("The result of: r1.contains(3, 3) = " + r1.contains(3, 3));
        System.out.println("The result of: r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)) = " + r1.contains(new MyRectangle2D(4, 5, 10.5, 3.2)));
        System.out.println("And the result of: r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)) = " + r1.overlaps(new MyRectangle2D(3, 5, 2.3, 5.4)));
    }
}
