package ch_09.exercise09_10;


//|_______________________UML Diagram________________________|
/*														   	 |
 * 			   		  QuadraticEquation		        		 |
 * __________________________________________________________|
 * 												   		     |
 *        			- a:double                               |
 * 	   	 			- b:double                               |
 * 	   	 			- c:double                               |
 * __________________________________________________________|
 *		QuadraticEquation(a:double,b:double,c:double)	     |
 *		getRoot1(): double								     |
 * 	    getRoot2(): double								     |
 *		getDiscriminant(): double							 |
 * 		getA(): double										 |
 * 		getB(): double										 |
 * 		getC(): double  ss									 |
 * 															 |
 *___________________________________________________________*/


/**
 * *9.10 (Algebra: quadratic equations) Design a class named QuadraticEquation for
 * a quadratic equation ax2 + bx + x = 0. The class contains:
 * ■ Private data fields a, b, and c that represent three coefficients.
 * ■ A constructor for the arguments for a, b, and c.
 * ■ Three getter methods for a, b, and c.
 * ■ A method named getDiscriminant() that returns the discriminant, which is
 * b2 - 4ac.
 * ■ The methods named getRoot1() and getRoot2() for returning two roots of
 * the equation
 * r1 = -b + Sqrt(b^2 - 4ac) / 2a
 * r2 = -b - Sqrt(b2 - 4ac) / 2a
 * These methods are useful only if the discriminant is non-negative. Let these methods return 0 if the discriminant
 * is negative.
 * <p>
 * Draw the UML diagram for the class and then implement the class.
 */
public class QuadraticEquation {
    /*  ■ Private data fields a, b, and c that represent three coefficients.*/
    private double a;
    private double b;
    private double c;

    /* ■ A constructor for the arguments for a, b, and c. */
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /* ■ The methods named getRoot1() and getRoot2() for returning two roots of the equation */
    protected double getRoot1() {
        if (getDiscriminant() < 0) {
            return 0;
        }
        return (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c)) / (2 * a));
    }

    protected double getRoot2() {
        if (getDiscriminant() < 0) {
            return 0;
        }
        return (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c)) / (2 * a));
    }

    /* ■ A method named getDiscriminant() that returns the discriminant, which is b2 - 4ac.*/
    protected double getDiscriminant() {
        return (b * 2) - (4 * a * c);
    }


    /* ■ Three getter methods for a, b, and c. */
    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }


}
