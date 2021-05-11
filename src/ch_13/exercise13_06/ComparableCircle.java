package ch_13.exercise13_06;
//___________________________UML DIAGRAM____________________________|
/*																	|
 * 						/GeometricObject/							|
 *------------------------------------------------------------------|
 *       -color: String												|
 *       -filled: boolean											|
 *       -dateCreated : java.util.Date								|
 *																	|
 *------------------------------------------------------------------|
 * 	 #GeometricObject()												|
 * 	 #GeometricObject(color:String,filled:boolean)					|
 * 	 																|
 * 																	|
 * 	+getColor(): String												|
 * 	+setColor(color: String): void									|
 * 	+isFilled(): boolean											|
 * 	+setFilled(filled: boolean): void								|
 * 	+getDateCreated(): java.util.Date								|
 *  									     						|
 *  	+toString(): String											|
 * 	/+getArea()/: double/											|
 * 	/+getPerimeter(): double/										|
 * __________________________________________________________________| */
/*							  ^
					   		  ^
					  		  ^
//_________________________________________________________________|
/*													   		  	   |
* 					     Circle     							   |
*__________________________________________________________________|
* 	       +Circle()						    				   |
*          +Circle(radius:double, color:String, boolean filled)	   |
* 	       +Circle(radius: double)				     			   |
*------------------------------------------------------------------|
                            ^
                            ^
                            ^
                            ^
//__________________________________________________________________|
/*																  	|
* 	         ComparableCircle <<<< Comparable<Circle>    	        |
*___________________________________________________________________|
*                                                                   |
*             +compareTo(circle: Circle): int                       |
//_________________________________________________________________|*/


/**
 * 13.6 (The ComparableCircle class) Define a class named ComparableCircle
 * * that extends Circle and implements Comparable.
 */
public class ComparableCircle extends Circle implements Comparable<Circle> {
    public ComparableCircle() {
        super();
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Circle circle) {
        return Double.compare(this.getArea(), circle.getArea());
    }
}
