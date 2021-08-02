package ch_13.exercise13_05;

/**
 * 13.5. (Enable GeometricObject comparable) Modify the GeometricObject class to implement
 * the Comparable interface, and define a static max method in the GeometricObject class
 * for finding the larger of two GeometricObject objects. Draw the UML diagram and implement
 * the new GeometricObject class. Write a test program that uses the max method to
 * find the larger of two circles and the larger of two rectangles.
 */
public class Exercise13_05 {
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(10.15, 11.55);
        Rectangle r2 = new Rectangle(31.22, 12.44);

        System.out.println("The larger of the two rectangles is the one:");
        System.out.println("\n" + Rectangle.max(r1, r2));

        Circle c1 = new Circle(13.45);
        Circle c2 = new Circle(10.15);

        System.out.println("\nThe larger of the two circles is the one:");
        System.out.println("\n" + Circle.max(c1, c2));

    }
}
