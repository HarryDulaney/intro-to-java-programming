package Ch_09;


/*Exercise 9.1 (The Rectangle class) Following the example of the   
 *Circle class in Section 9.2, design a class named Rectangle 
 *to represent a rectangle. The class contains:
 * 
 * Two double data fields named width and height that specify 
 * the width and height of the rectangle. The default values 
 * are 1 for both width and height.
 *
 *A no-arg constructor that creates a default rectangle.
 *
 *A constructor that creates a rectangle with the specified width and height.
 *
 *A method named getArea() that returns the area of this rectangle.
 *
 *A method named getPerimeter() that returns the perimeter.
 *
 *Draw the UML diagram for the class and then implement the class. Write a test program 
 *that creates two Rectangle objects-one with width 4 and height 40 and the other with
 *width 3.5 and height 35.9. Display the width, height, area, and perimeter of each 
 *rectangle in this order.
 */
/***********************************************/
/*_______________UML Diagram____________________*
 *______________________________________________*
 *               Rectangle			        	*
 *______________________________________________*
 * 							  			 		*
 *  width: double 								*
 *  						    				*
 *  height: double								*
 *  						  					*
 * 	Rectangle()									*
 * 						  					    * 
 *  Rectangle(newWidth:double, newHeight:Double)*
 *  											*
 * 	getArea(): double							*
 * 												*
 * 	getPerimeter(): double						*
 * 												*
 * _____________________________________________*
 *//*********************************************/

/**
 * @author Harry G. Dulaney IV
 *
 */

public class Rectangle09_01{
	
	 double width;
	 double height;
	
	Rectangle09_01(){
		width = 1;
		height = 1;
	}
	Rectangle09_01(double newWidth, double newHeight){
		
		width = newWidth;
		height = newHeight;
	}
	
	double getArea() {
		double area = width * height;
		return area;
	}
	double getPerimeter() {
		
		double perimeter = (2*width)+(2*height);
		return perimeter;
	}
	
	public static void main(String[] args) {
		
		Rectangle09_01 r1 = new Rectangle09_01(4,40);
		
		Rectangle09_01 r2 = new Rectangle09_01(3.5,35.9);
		
		System.out.println("The width, height, area, and perimeter of rectangle one are "
				+ r1.width + " , " + r1.height + " , " + r1.getArea() + " , " + r1.getPerimeter() );
		
	
		System.out.println("The width, height, area, and perimeter of rectangle two are "
				+ r2.width + " , " + r2.height + " , " + r2.getArea() + " , " + r2.getPerimeter() );
		}
	}



