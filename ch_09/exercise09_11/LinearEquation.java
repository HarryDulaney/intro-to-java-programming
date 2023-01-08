package ch_09.exercise09_11;


//|_____________________________UML Diagram_____________________________________|
/*																				|
 * 					   		   Linear Equation							   	    |
 * _____________________________________________________________________________|
 * 																				|
 *      -a:double																|
 *      -b:double    									           				|
 * 	    -c:double		  														|
 * 	    -d:double		                                            			|
 * 		-e:double																|
 * 		-f:double																|
 * _____________________________________________________________________________|
 *		LinearEquation(double:a,double:b,double:c,double:d,double:e,double:f)	|
 *		getA(): void															|
 *		getB(): void															|
 *		getC(): void															|
 *		getD(): void															|
 *		getE(): void															|
 *		getF(): void															|
 *		isSolvable(): boolean													|
 * 		getCenterX(): double															|
 * 		getCenterY(): double															|
 * 																				|
 *______________________________________________________________________________*/


/**
 * Exercise 9.11 (Algebra: 2 � 2 linear equations) Design a class
 * named LinearEquation for a 2 � 2 system of linear equations:
 * <p>
 * <p>
 * The class contains:
 * <p>
 * Private data fields a, b, c, d, e, and f.
 * <p>
 * A constructor with the arguments for a, b, c, d, e, and f.
 * <p>
 * Six getter methods for a, b, c, d, e, and f.
 * <p>
 * A method named isSolvable() that returns true if ad minus bc is not 0.
 * <p>
 * <p>
 * Methods getCenterX() and getCenterY() that return the solution for the equation.
 * <p>
 * Draw the UML diagram for the class and then implement the class.
 */
public class LinearEquation {

    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;


    public LinearEquation(double a, double b, double c, double d, double e, double f) {

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;

    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return d;
    }

    public double getE() {

        return e;
    }

    public double getF() {
        return f;
    }

    public boolean isSolvable() {

        return a * d - b * c != 0;
    }

    public double getX() {


        double x = (this.getE() * this.getD() - this.getB() * this.getF()) /
                (this.getA() * this.getD() - this.getB() * this.getC());

        return x;
    }

    public double getY() {
        double y = (this.getA() * this.getF() - this.getE() * this.getC()) /
                (this.getA() * this.getD() - this.getB() * this.getC());
        return y;
    }
}
