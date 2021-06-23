package ch_10.exercise10_13;

import ch_10.exercise10_04.MyPoint;
//_________________________UML DIAGRAM______________________________*
/*																	|
 * 			    		  MyRectangle2D 				    		|
 *------------------------------------------------------------------|
 *                     	   -x : double	                       		|
 *                         -y : double  							|
 * 							-height:double					 		|
 * 							-width:double  					 		|
 *------------------------------------------------------------------|
 *                     -MyRectangle2D()            					|
 *                     -MyRectangle2D(double, double)  		    	|
 *             -MyRectangle2D(double, double,double,double)	    	|
 * 	 																|
 * 	 			    getArea():double								|
 * 	 				getPerimeter():double                           |
 * 	 																|
 * 					+contains(double,double):boolean	            |
 * 					+contains(MyRectangle2D):boolean	            |
 * 						                                        	|
 * 					+overlaps(MyRectangle2D):boolean				|
 *  																|
 * 	 				getters and setters 							|
 * 																	|
 *__________________________________________________________________|  */

/**
 * *10.13 (Geometry: the MyRectangle2D class) Define the MyRectangle2D class that
 * contains:
 * ■ Two double data fields named x and y that specify the center of the rectangle with getter and setter methods. (Assume that the rectangle sides are
 * parallel to x- or y- axes.)
 * ■ The data fields width and height with getter and setter methods.
 * ■ A no-arg constructor that creates a default rectangle with (0, 0) for (x, y) and
 * 1 for both width and height.
 * ■ A constructor that creates a rectangle with the specified x, y, width, and
 * height.
 * <p>
 * ■ A method getArea() that returns the area of the rectangle.
 * ■ A method getPerimeter() that returns the perimeter of the rectangle.
 * ■ A method contains(double x, double y) that returns true if the
 * specified point (x, y) is inside this rectangle (see Figure 10.24a).
 * ■ A method contains(MyRectangle2D r) that returns true if the specified rectangle is inside this rectangle (see Figure 10.24b).
 * ■ A method overlaps(MyRectangle2D r) that returns true if the specified rectangle overlaps with this rectangle (see Figure 10.24c).
 * <p>
 * Draw the UML diagram for the class and then implement the class.
 */
public class MyRectangle2D {
    private double x;
    private double y;
    private double height;
    private double width;

    public MyRectangle2D() {
        x = 0;
        y = 0;
        height = 1;
        width = 1;
    }

    public MyRectangle2D(double x, double y, double height, double width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (2 * width) + (2 * height);
    }

    public boolean contains(double x, double y) {
        // Where A,B,C,D are the corner points of this.myRectangle2D
        MyPoint A = new MyPoint(this.x - width / 2, this.y + height / 2);  //Top left
        MyPoint B = new MyPoint(this.x + width / 2, this.y - height / 2);  //Bottom Right

        return x > A.getX() && y < A.getY() && x < B.getX() && y > B.getY();

    }

    public boolean contains(MyRectangle2D r) {
        if (r.getArea() > this.getArea()) {
            return false;
        }
        return ((r.getX() + r.getWidth() / 2) <= (this.getX() + this.getWidth() / 2)) &&
                ((r.getX() - r.getWidth() / 2) >= (this.getX() - this.getWidth() / 2)) &&
                ((r.getY() + r.getHeight() / 2) <= (this.getY() + this.getHeight() / 2)) &&
                ((r.getY() - r.getHeight() / 2) >= (this.getY() - this.getHeight() / 2));
    }

    public boolean overlaps(MyRectangle2D r) {
        // Points for rectangle 'r'
        MyPoint rec1TopLeft = new MyPoint(r.getX() - r.getWidth() / 2, r.getY() + r.getHeight() / 2);
        MyPoint rec1BottomRight = new MyPoint(r.getX() + r.getWidth() / 2, r.getY() - r.getHeight() / 2);
        // Points for current object rectangle
        MyPoint rec2TopLeft = new MyPoint(this.getX() - this.getWidth() / 2, this.getY() + this.getHeight() / 2);
        MyPoint rec2BottomRight = new MyPoint(this.getX() + r.getWidth() / 2, this.getY() - this.getHeight() / 2);

        return (rec1TopLeft.getX() < rec2BottomRight.getX() && rec2TopLeft.getX() < rec1BottomRight.getX()) &&
                (rec1TopLeft.getY() > rec2BottomRight.getY() && rec2TopLeft.getY() > rec1BottomRight.getY());

    }

    public double getX() {
        return x;
    }

    public MyRectangle2D setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    public MyRectangle2D setY(double y) {
        this.y = y;
        return this;
    }

    public double getHeight() {
        return height;
    }

    public MyRectangle2D setHeight(double height) {
        this.height = height;
        return this;
    }

    public double getWidth() {
        return width;
    }

    public MyRectangle2D setWidth(double width) {
        this.width = width;
        return this;
    }
}