package ch_13.exercise13_01;

import ch_13.exercise13_10.GeometricObject;

//__________________________UML DIAGRAM_____________________________*
/*																	|
 * 						/GeometricObject/							|
 *-------------------------------------------------------------------|
 * -color: String													|
 * -filled: boolean													|
 * -dateCreated : java.util.Date										|
 *																	|
 *-------------------------------------------------------------------|
 * 	 #GeometricObject()												|
 * 	 #GeometricObject(color:String,filled:boolean)					|
 * 	 																|
 * 																	|
 * 	+getColor(): String												|
 * 	+setColor(color: String): void									|
 * 	+isFilled(): boolean											|
 * 	+setFilled(filled: boolean): void								|
 * 	+getDateCreated(): java.util.Date								|
 *  																	|
 *  	+toString(): String												|
 * 	/+getArea()/: double/											|
 * 	/+getPerimeter(): double/										|
 * __________________________________________________________________| */
/*							  ^
					   		  ^
							  ^
//|_________________________________________________________________|
/*																  	|
* 					     Triangle2D							    |
* _________________________________________________________________|
* 																	|
*     -side1: double         		 								|
*     -side2: double              									|
* 	   -side3: double	      										| 	  	    		
* _________________________________________________________________|
*																	|
* 		+Triangle2D()											|
*		+Triangle2D(side1:double,side2:double,side3:double)		|
* 		+getSide1(): double											|
* 		+setSide1(side1: double): void								|
* 		+getSide2(): double											|
* 		+setSide2(side2: double): void								|
* 		+getSide3(): double											|
* 		+setSide3(side3: double): void								|
* 																	|
* 		+getArea(): double											|
* 		+getPerimeter(): double										|
* 																	|				
*__________________________________________________________________|*/

/** 13.1 (Triangle2D class) Design a new Triangle2D class that extends the abstract
 *GeometricObject class. Draw the UML diagram for the classes Triangle2D
 *and GeometricObject and then implement the Triangle2D class. Write a test
 *program that prompts the user to enter three sides of the triangle, a color, and a
 *Boolean value to indicate whether the triangle is filled. The program should create
 *a Triangle2D object with these sides and set the color and filled properties using
 *the input. The program should display the area, perimeter, color, and true or false
 *to indicate whether it is filled or not.
 *
 */
public class Triangle extends GeometricObject {

    private double side1;
    private double side2;
    private double side3;

    public Triangle() {

    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double s = 0.5 * (side1 + side2 + side3);

        return Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);

    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

}