package ch_13.exercise13_05;


//__________________________UML DIAGRAM_____________________________*
/*																	|
 * 						/GeometricObject/							|
 *-------------------------------------------------------------------|
 *	 -color: String													|
 * 	-filled: boolean												|
 * 	-dateCreated : java.util.Date									|
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
 *   -max(GeometricObject o, 										|
 *		GeometricObject o1):GeometricObject							|
 *  																	|
 *  	+toString(): String												|
 *   -compareTo(GeometricObject): int								|
 * 	/+getArea()/: double/											|
 * 	/+getPerimeter(): double/										|
 * __________________________________________________________________| */

/**
 * 13.5. (Enable GeometricObject comparable) Modify the GeometricObject
 * class to implement the Comparable interface, and define a static max
 * method in the GeometricObject class for finding the larger of two GeometricObject
 * objects. Draw the UML diagram and implement the new GeometricObject class. Write a
 * test program that uses the max method to find the larger of two circles and the
 * larger of two rectangles.
 */
public abstract class GeometricObject implements Comparable<GeometricObject> {

    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    static GeometricObject max(GeometricObject o, GeometricObject o1) {

        if (o.compareTo(o1) == 1)
            return o;
        else
            return o1;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }

    @Override
    public int compareTo(GeometricObject o) {
        if (this.getArea() > o.getArea()) {
            return 1;
        } else if (this.getArea() < o.getArea()) {
            return -1;

        } else
            return 0;

    }

    public abstract double getArea();

    public abstract double getPerimeter();

}


