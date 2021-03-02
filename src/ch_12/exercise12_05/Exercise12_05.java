package ch_12.exercise12_05;


/**
 * *12.5 (IllegalTriangleException) Programming Exercise 11.1 defined the
 * Triangle class with three sides. In a triangle, the sum of any two sides is
 * greater than the other side. The Triangle class must adhere to this rule.
 * <p>
 * Create the IllegalTriangleException class, and modify the constructor
 * of the Triangle class to throw an IllegalTriangleException object if a
 * triangle is created with sides that violate the rule, as follows:
 * <p>
 * {@code /* Construct a triangle with the specified sides
 * public Triangle(double side1,double side2,double side3)
 * throws IllegalTriangleException {
 * // Implement it
 * }}
 */
public class Exercise12_05 {
    public static void main(String[] args) {
        System.out.println("Test new Triangle with non-compliant values:");
        try {
            Triangle triangle = new Triangle(1.0, 0.1, 0.2);
            System.out.println("The Triangle's area is " + triangle.getArea());
        } catch (IllegalTriangleException e) {
            System.out.println(e);
        }
        System.out.println("Test new Triangle with compliant values:");
        try {
            Triangle triangle = new Triangle(1.0, 1.0, 1.0);
            System.out.println("The Triangle's area is " + triangle.getArea());
        } catch (IllegalTriangleException e) {
            System.out.println(e);
        }

    }


}
