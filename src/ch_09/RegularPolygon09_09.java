package ch_09;
/*Exercise 9.9 (Geometry: n-sided regular polygon) In an n-sided regular polygon, 
 * all sides have the same length and all angles have the same degree (i.e., 
 * the polygon is both equilateral and equiangular). Design a class named 
 * RegularPolygon that contains:
 * 
 * A private int data field named n that defines the number of sides in the polygon with default value 3.
 * 
 * A private double data field named side that stores the length of the side with default value 1.
 * 
 * A private double data field named x that defines the x-coordinate of the polygon's center with default value 0.
 *
 * A private double data field named y that defines the y-coordinate of the polygon's center with default value 0.
 *
 * A no-arg constructor that creates a regular polygon with default values.
 *
 * A constructor that creates a regular polygon with the specified number of sides and length of side, centered at (0, 0).
 *
 * A constructor that creates a regular polygon with the specified number of sides, length of side, and x- and y-coordinates.
 *
 *The accessor and mutator methods for all data fields.
 *
 *The method getPerimeter() that returns the perimeter of the polygon.
 *
 * The method get
 * Area() that returns the area of the polygon. The formula for computing the area of a regular polygon is 
 *  Area=n�s24�tan(n).
 *
 *Draw the UML diagram for the class and then implement the class. 
 *
 *Write a test program that creates three RegularPolygon objects, 
 *created using the no-arg constructor, using RegularPolygon(6, 4), 
 *and using RegularPolygon(10, 4, 5.6, 7.8). For each object, 
 *display its perimeter and area.
 */

//|_____________________________UML Diagram_____________________________________|
/*																				|
 * 					   		    RegularPolygon								    |
 * _____________________________________________________________________________|
 * 																				|
 *     + n:int          (defines # of sides default 3)							|
 *     + side:double    (length of side default 1)            					|
 * 	   + x:double		  (x of center coordinate default 0)    				|
 * 	   + y:double		  (y of center coordinate default 0)    				|
 * _____________________________________________________________________________|
 *		RegularPolygon()									  					|
 *		RegularPolygon(sides:int,lengthSide:double) (at (0,0))					|
 *		RegularPolygon(sides:int,lengthSide:double,x:double,y:double) (x,y)		|
 *		getSide(): double														|
 * 	    setSide(side: double) :void												|
 *		getNumSides(): double													|
 * 		setNumSides(numSides:int) :void											|
 * 		setX(newX:int) :void													|
 * 		getX(): double															|
 * 		setY(newY:int) :void													|
 * 		getY(): double															|	
 *  	getPerimeter()															|
 * 		getArea() : double														|
 * 																				|
 * 																				|
 * 																				|
 *______________________________________________________________________________*/

/**
 * 
 * @author Harry G. Dulaney IV
 *
 */

public class RegularPolygon09_09 {
	
	private int n;
	private double side;
	private double x;
	private double y;
	
	RegularPolygon09_09(){
		
		n = 3;
		side = 1;
		x = 0;
		y = 0;
		
	}
	RegularPolygon09_09(int numSides,double sideLength){
		
		n = numSides;
		side = sideLength;
		
	}
	RegularPolygon09_09(int numSides, double sideLength, double ex, double why){
		
		n = numSides;
		side = sideLength;
		x = ex;
		y = why;
		
	}
	public void setNumSides(int newNum) {
		
		n = newNum;
		
	}
	public int getNumSides() {
		
	return n;
	}
	
	public void setSide(double newLength) {
		
		side = newLength;
	}
	public double getSide() {
		return side;
	}
	public void setX(int newX) {
		
		x = newX;
	}
	public double getX() {
		return x;
		
	}
	public void setY(double newY) {
		
		y = newY;
	}
	public double getY() {
		return y;
	}
	public double getPerimeter() {
		
	double perimeter = n * side;
	
	return perimeter;
	
	}
	public double getArea() {
		double area = n * (Math.pow(side, 2) / 4 * Math.tan(Math.PI/n));
		
	return area;
	}
public static void main(String[] args) {
		
		RegularPolygon09_09 polyOne = new RegularPolygon09_09();
		
		RegularPolygon09_09 polyTwo = new RegularPolygon09_09(6,4);
		
		RegularPolygon09_09 polyThree = new RegularPolygon09_09(10,4,5.6,7.8);
		
		System.out.println("The perimeter of polygon one is " + polyOne.getPerimeter() + " the "
				+ "area of polygon one is " + polyOne.getArea());
		
		System.out.println("The perimeter of polygon two is " + polyTwo.getPerimeter() + " the "
				+ "area of polygon two is " + polyTwo.getArea());
		
		System.out.println("The perimeter of polygon three is " + polyThree.getPerimeter() + " the "
				+ "area of polygon three is " + polyThree.getArea());
	
	}
}
