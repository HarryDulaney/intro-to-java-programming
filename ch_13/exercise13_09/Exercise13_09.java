package ch_13.exercise13_09;

/**
 * 13.9 (Enable Circle comparable) Rewrite the Circle class in Listing 13.2 to extend
 * GeometricObject and implement the Comparable interface. Override the
 * equals method in the Object class.
 * <p>
 * Two Circle objects are equal if their radii
 * are the same. Draw the UML diagram that involves Circle, GeometricObject,
 * and Comparable.
 * <p>
 * Test Circle.class
 */
public class Exercise13_09 {
    public static void main(String[] args) {
        Circle c1 = new Circle(12.23);
        Circle c2 = new Circle(67.89);
        Circle c3 = new Circle(65.43);
        Circle c4 = new Circle(12.23);

        System.out.println("c1.equals(c2): " + c1.equals(c2));
        System.out.println("c1.equals(c4)" + c1.equals(c4));
        System.out.println("c2.compareTo(c3)" + c2.compareTo(c3));
    }


}

