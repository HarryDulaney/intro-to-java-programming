package ch_09;

import java.util.Scanner;

/*Exercise 9.11 (Algebra: 2 � 2 linear equations) Design a class
 * named LinearEquation for a 2 � 2 system of linear equations:
 * 
 * 
 * The class contains:
 * 
 * Private data fields a, b, c, d, e, and f.
 * 
 * A constructor with the arguments for a, b, c, d, e, and f.
 * 
 * Six getter methods for a, b, c, d, e, and f.
 * 
 * A method named isSolvable() that returns true if ad minus bc is not 0.
 * 
 * 
 * Methods getX() and getY() that return the solution for the equation.
 * 
 * Draw the UML diagram for the class and then implement the class. Write 
 * a test program that prompts the user to enter a, b, c, d, e, and f and 
 * displays the result. If ad minus bc is 0, report that "The equation has 
 * no solution."
 *
 */


//|_____________________________UML Diagram_____________________________________|
/*																				|
* 					   		   Linear Equation							   	    |
* ______________________________________________________________________________|
* 																				|
*       +a:double																|
*       +b:double    									           				|
* 	    +c:double		  														|
* 	    +d:double		                                            			|
* 		+e:double																|
* 		+f:double																|
* ______________________________________________________________________________|
*		LinearEquation(double:a,double:b,double:c,double:d,double:e,double:f)	|
*		getA(): void															|
*		getB(): void															|
*		getC(): void															|
*		getD(): void															|
*		getE(): void															|
*		getF(): void															|
*		isSolvable(): boolean													|															
* 		getX(): double															|
* 		getY(): double															|
* 																				|																
*______________________________________________________________________________*/


/**
 * @author Harry G. Dulaney IV
 */

public class LinearEquation09_11 {
	
	private double a;
	private double b;
	private double c;
	private double d;
	private double e;
	private double f;


LinearEquation09_11(double A, double B, double C, double D, double E, double F){
	
	a = A;
	b = B;
	c = C;
	d = D;
	e = E;
	f = F;
	
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
	
	
	double x = (this.getE()*this.getD()-this.getB()*this.getF())/
				(this.getA()*this.getD()-this.getB()*this.getC());
			
return x;
}

public double getY() {
	double y = (this.getA()*this.getF()-this.getE()*this.getC())/
				(this.getA()*this.getD()-this.getB()*this.getC());
	return y;
	}
public static void main(String[] args) {
	
	Scanner input = new Scanner(System.in);
	
	double a, b, c, d, e, f;
	
	System.out.println("Enter values for a, b, c, d, e, and f now:");
	
	a = input.nextDouble();
	b = input.nextDouble();
	c = input.nextDouble();
	d = input.nextDouble();
	e = input.nextDouble();
	f = input.nextDouble();
	
	LinearEquation09_11 tester = new LinearEquation09_11(a,b,c,d,e,f);
	
	if(tester.isSolvable()) {
		
		
		System.out.println("x is " + tester.getX());
		System.out.println("y is " + tester.getY());
		
		
		
	}else {
		System.out.println("The equation has no solution");
		}	input.close();
	}
}
