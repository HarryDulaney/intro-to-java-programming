package ch_13.exercise13_11;


/**
 * 13.11 (The Octagon class) Write a class named Octagon that extends
 * GeometricObject and implements the Comparable and Cloneable interfaces.
 * Assume that all eight sides of the octagon are of equal length. The area can
 * be computed using the following formula:
 * area = (2 + 4/22)* side * side
 * Draw the UML diagram that involves Octagon, GeometricObject,
 * Comparable, and Cloneable.
 * @see Octagon
 * <p>
 * Write a test program that creates an Octagon
 * object with side value 5 and displays its area and perimeter. Create a new object
 * using the clone method and compare the two objects using the compareTo
 * method.
 */
public class Exercise13_11 {
    public static void main(String[] args) {
        Octagon octagon1 = new Octagon(5);
        System.out.println("Octagon1 perimeter = " + octagon1.getPerimeter() + ", area = " + octagon1.getArea());
        Octagon octagon2 = null;
        System.out.println("Cloning Octagon1 .......");
        try {
             octagon2 = octagon1.clone();
        }catch (CloneNotSupportedException cnse){
            cnse.printStackTrace();
        }

        System.out.println("octagon1.compareTo(octagon 2): " + octagon1.compareTo(octagon2));
        System.out.println("Octagon 2 area = " + octagon2.getArea() + ", perimeter = " + octagon2.getPerimeter());


    }

}
