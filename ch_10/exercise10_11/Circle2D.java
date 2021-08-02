package ch_10.exercise10_11;
//__________________________UML DIAGRAM_____________________________*
/*																	|
 * 							 Circle2D  								|
 *------------------------------------------------------------------|
 *                     -x : double                					|
 *					   -y : double                                  |
 *                     -radius:double								|
 *------------------------------------------------------------------|
 *          	     +Circle2D()									|
 *          +Circle2D(x:double,y:double,radius:double)		        |
 * 	 																|
 * 	              +contains(x:double,y:double) : boolean   			|
 * 																	|
 * 	              +contains(circle2D: Circle2D): boolean            |
 *                +overlaps(circle2D: Circle2D): boolean           	|
 * 	 																|
 * 	               +getPerimeter(): double							|
 *  																|
 * 	               +getArea():double   								|
 * 																	|
 * _________________________________________________________________|  */

/**
 * *10.11 (Geometry: the Circle2D class) Define the Circle2D class that contains:
 * ■ Two double data fields named x and y that specify the center of the circle
 * with getter methods.
 * ■ A data field radius with a getter method.
 * ■ A no-arg constructor that creates a default circle with (0, 0) for (x, y) and 1
 * for radius.
 * ■ A constructor that creates a circle with the specified x, y, and radius.
 * ■ A method getArea() that returns the area of the circle.
 * ■ A method getPerimeter() that returns the perimeter of the circle.
 * ■ A method contains(double x, double y) that returns true if the
 * specified point (x, y) is inside this circle (see Figure 10.21a).
 * ■ A method contains(Circle2D circle) that returns true if the specified circle is inside this circle (see Figure 10.21b).
 * ■ A method overlaps(Circle2D circle) that returns true if the specified circle overlaps with this circle (see Figure 10.21c).
 * <p>
 * Draw the UML diagram for the class and then implement the class.
 */
public class Circle2D {
    /* ■ Two double data fields named x and y that specify the center of the circle with getter methods.*/
    private double x;
    private double y;
    /* ■ A data field radius with a getter method. */
    private double radius;

    /**
     * ■ A no-arg constructor that creates a default circle with (0, 0) for (x, y) and 1
     * for radius.
     */
    public Circle2D() {
        x = 0;
        y = 0;
        radius = 1;
    }

    /**
     * ■ A constructor that creates a circle with the specified x, y, and radius.
     */
    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    /**
     * ■ A method getArea() that returns the area of the circle.
     */
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * ■ A method getPerimeter() that returns the perimeter of the circle.
     */
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * ■ A method contains(double x, double y) that returns true if the
     * specified point (x, y) is inside this circle (see Figure 10.21a).
     */
    public boolean contains(double x, double y) {
        double distanceFromCenterPoint = Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
        return distanceFromCenterPoint < radius;

    }

    /**
     * ■ A method contains(Circle2D circle) that returns true if the specified circle is inside this circle (see Figure 10.21b).
     */
    public boolean contains(Circle2D circle2D) {
        double distFromCenterPoints =
                Math.sqrt(Math.pow(circle2D.getX() - this.x, 2) + Math.pow(circle2D.getY() - this.y,
                        2));
        return this.radius > (distFromCenterPoints + circle2D.getRadius());
    }

    /**
     * ■ A method overlaps(Circle2D circle) that returns true if the specified circle overlaps with this circle (see Figure 10.21c).
     */
    public boolean overlaps(Circle2D circle2D) {
        double distCentPoints = Math.sqrt(Math.pow(circle2D.getX() - this.x, 2) + Math.pow(circle2D.getY() - this.y, 2));
        double rSqSum = Math.pow(circle2D.getRadius() + this.radius, 2);
        return distCentPoints < rSqSum;
    }

    /* Getters */
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }


}
