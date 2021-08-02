package ch_11.exercise11_01;

import java.util.Scanner;

//__________________________UML DIAGRAM_____________________________*
/*																	|
 * 						 GeometricObject							|
 *-------------------------------------------------------------------|
 *    -color: String													|
 *    -filled: boolean												|
 *    -dateCreated: java.util.Date									|
 *    																|
 *																	|
 *-------------------------------------------------------------------|
 * 	 +GeometricObject()												|
 * 	 																|
 * 	 +GeometricObject(color: String, filled: boolean)				|
 * 																	|
 * 	 +getColor(): String  											|
 * 	 																|
 * 	 +setColor(color: String): void									|
 *  																	|
 *    +isFilled(): boolean											|
 * 																	|
 * 	 +setFilled(filled: boolean): void								|
 * 																	|
 *  	+getDateCreated(): java.util.Date								|
 * 																	|
 * 	+toString(): String												|
 * 																	|
 * 																	|
 * 																	|
 * 																	|
 * __________________________________________________________________|  */

/*_________________________________________________________________
|					     GeometricObject						   |  
|__________________________________________________________________|
								^
								|
 __________________________UML DIAGRAM______________________________
/*																	|																															
* 							  Triangle2D 								|
*-------------------------------------------------------------------|
* 	-side1 : double													|
* 																	|	
*   -side2 : double													|
* 																	|
* 	-side3 : double													|
* 																	|											
*-------------------------------------------------------------------|
* 	 +Triangle2D()													|
* 	 																|
* 	 +Triangle2D(side1:double,side2: double,side3:double)				|
* 																	|
* 	 +getSide1 : double												|
*    +getSide2 : double												|
*    +getSide3 : double												|
*																	| 
* 																	|
* 	 +getArea() : double											|
* 	 +getPerimeter() : double										|
* 																	|
* 	 																|
* 	+toString() : String ("Triangle2D: side1 = " + side1 + 			|
* 		" side2 = " + side2 + "  side3 = " + side3)					|			 																	
* 																	|	
*___________________________________________________________________|  */


/**
 * 11.1 (The Triangle2D class) Design a class named Triangle2D that extends GeometricObject.
 * The class contains:Three double data fields named side1, side2, and side3 with default
 * values 1.0 to denote three sides of the triangle. A no-arg constructor that creates a
 * default triangle. A constructor that creates a triangle with the specified side1, side2, and side3.
 * The accessor methods for all three data fields.
 * A method named getArea() that returns the area of this triangle.
 * A method named getPerimeter() that returns the perimeter of this triangle.
 * A method named toString() that returns a string description for the triangle.
 * For the formula to compute the area of a triangle, see Programming Exercise 2.19.
 * The toString() method is implemented as follows:
 * return "Triangle2D: side1 = " + side1 + " side2 = " + side2 +
 * " side3 = " + side3;
 * <p>
 * Draw the UML diagrams for the classes Triangle2D and GeometricObject and implement the classes.
 * Write a test program that prompts the user to enter three sides of the triangle, a color, and a
 * Boolean value to indicate whether the triangle is filled. The program should create a Triangle2D
 * object with these sides and set the color and filled properties using the input.
 * The program should display the area, perimeter, color, and true or false
 * to indicate whether it is filled or not.
 */
public class Exercise11_01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the three sides of the triangle:");

        double one = input.nextDouble();
        double two = input.nextDouble();
        double three = input.nextDouble();

        Triangle triangle = new Triangle(one, two, three);

        System.out.print("What color is the triangle?");

        String color = input.next();

        System.out.print("Is the triangle filled? (Enter Yes or No):");

        String fill = input.next();

        triangle.setColor(color);

        boolean filled;

        filled = !"No".matches(fill);

        triangle.setFilled(filled);

        System.out.println("For " + triangle.toString() + " the area is " + triangle.getArea()
                + " square units, " + "\nThe perimeter is " + triangle.getPerimeter());

        System.out.println("The current color is " + triangle.getColor() + " \nAnd "
                + "is the triangle filled is: " + triangle.isFilled());

        input.close();
    }
}




