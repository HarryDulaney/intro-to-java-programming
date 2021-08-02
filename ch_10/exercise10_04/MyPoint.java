package ch_10.exercise10_04;

//_________________________UML DIAGRAM______________________________*
/*																	|
 * 							  MyPoint  								|
 *------------------------------------------------------------------|
 *                     	   -x : int	                           		|
 * 															 		|
 *                         -y : int									|
 *------------------------------------------------------------------|
 *                     -MyPoint()          	    					|
 *                     -MyPoint(int, int)            		    	|
 * 	 																|
 * 					+distance(MyPoint):double	                    |
 * 						                                        	|
 * 					+distance(int,int):double						|
 *  																|
 * 																	|
 * 	                      +getX() : int	    						|
 * 			    													|
 * 	                      +getY() : int   							|
 * 	 																|
 * 																	|
 *__________________________________________________________________|  */


/**
 * 10.4 (The MyPoint class) Design a class named MyPoint to represent a point with
 * x- and y-coordinates. The class contains:
 * ■ The data fields x and y that represent the coordinates with getter
 * methods.
 * ■ A no-arg constructor that creates a point (0, 0).
 * ■ A constructor that constructs a point with specified coordinates.
 * ■ A method named distance that returns the distance from this point to a
 * specified point of the MyPoint type.
 * ■ A method named distance that returns the distance from this point to
 * another point with specified x- and y-coordinates.
 * Draw the UML diagram for the class and then implement the class.
 */
public class MyPoint {
    private double x;
    private double y;

    public MyPoint() {
        x = 0;
        y = 0;
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(MyPoint point) {
        return distance(point.x, point.y);

    }

    public double distance(double x, double y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


}
