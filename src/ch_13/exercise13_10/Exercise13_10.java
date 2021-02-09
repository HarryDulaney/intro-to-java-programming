package ch_13.exercise13_10;


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
/*					  ^
				      ^
			    	  ^
					  ^	 
/*_________________UML Diagram__________________*
 *______________________________________________*
 *               Rectangle		        	*
 *______________________________________________*
 * 							  			 		*
 *  width: double 								*
 *  						    				*
 *  height: double								*						
 *  						  					*			   ____________________________________
 * 	Rectangle()									*			  |	           <<interface>>           |
 * 						  					    * 			  |java.lang.Comparable<Rectangle>|
 *  Rectangle(newWidth:double, newHeight:Double)* >>>>>>>>>>> |____________________________________|
 *  											*			  |	+compareTo(obj:Rectangle):int |
 * 	getArea(): double							*			  |____________________________________|			
 * 	getPerimeter(): double						*
 * 												*
 * 	+toString(): String							*
 * 	+compareTo():int							*
 * 	+equals(): boolean							*
 * _____________________________________________*
 */

/*********************************************/

/**
 * 13.10. (Enable Rectangle comparable) Rewrite the Rectangle class in
 * Listing 13.3 to extend GeometricObject and implement the Comparable
 * interface. Override the equals method in the Object class. Two Rectangle
 * objects are equal if their areas are the same. Draw the UML diagram that
 * involves Rectangle, GeometricObject, and Comparable.
 */
public class Exercise13_10 {
    public static void main(String[] args) {

        Rectangle rectangle1 = new Rectangle(4, 7, "Yellow", true);
        Rectangle rectangle2 = new Rectangle(4, 7, "Blue", false);

        System.out.println("\nRectangle 1:\n " + rectangle1.toString()
                + "\n\nand\n" + "\nRectangle 2: \n" + rectangle2.toString());

        System.out.println("\nAre they equal? " + rectangle1.equals(rectangle2));


    }

}

class Rectangle extends GeometricObject implements Comparable<Rectangle> {

    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {

        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public int compareTo(Rectangle obj) {
        if (this.getArea() > obj.getArea()) {
            return 1;
        } else if (this.getArea() < obj.getArea()) {

            return -1;
        } else
            return 0;

    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Rectangle) {
            return this.compareTo((Rectangle) obj) == 0;
        } else
            return false;

    }

    @Override
    public String toString() {
        return super.toString() + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
    }

}
