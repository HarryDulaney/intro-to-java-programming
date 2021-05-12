package ch_13.exercise13_11;

import ch_13.exercise13_01.GeometricObject;

/**
 * 13.11 (The Octagon class) Write a class named Octagon that extends
 * GeometricObject and implements the Comparable and Cloneable interfaces.
 * Assume that all eight sides of the octagon are of equal length. The area can
 * be computed using the following formula:
 * area = (2 + 4/22)* side * side
 * Draw the UML diagram that involves Octagon, GeometricObject,
 * Comparable, and Cloneable:
 *
                                     //_________________________ UML DIAGRAM ____________________________*
                                     /*																	*
                                     * 						  GeometricObject 							*
                                     *------------------------------------------------------------------*
                                     * -color: String													*
                                     * -filled: boolean													*
                                     * -dateCreated : java.util.Date									*
                                     *																	*
                                     *------------------------------------------------------------------*
                                     * 	 #GeometricObject()												*
                                     * 	 #GeometricObject(color:String,filled:boolean)					*
                                     * 	 																*
                                     * 																	*
                                     * 	+getColor(): String												*
                                     * 	+setColor(color: String): void									*
                                     * 	+isFilled(): boolean											*
                                     * 	+setFilled(filled: boolean): void								*
                                     * 	+getDateCreated(): java.util.Date								*
                                     *  																*
                                     *  	+toString(): String											*
                                     * 	/+getArea()/: double/											*
                                     * 	/+getPerimeter(): double/										*
                                     * _________________________________________________________________| */
                                    /*					              ^
                                                				      ^
                                                			    	  ^
                                                					  ^
                                                /*_________________UML Diagram__________________*
                                                 *______________________________________________*
                                                 *                   Octagon  	        	    *
                                                 *______________________________________________*
                                                 * 							  			 		*
                                                 *  side: double 								*
                                                 *  						  					*			 _____________________________________
 _____________________________________           * 	Octagon()									*			 *	        <<interface>>            *
 *	        <<interface>>            *           * 						  					    * 			 *  java.lang.Comparable<Octagon>    *
 *      java.lang.Cloneable          *           *  Octagon(side:double)                        * >>>>>>>>>> *___________________________________*
 *___________________________________* <<<<<<<<< *  											*			 *	+compareTo(obj:Octagon):int      *
 *	    +clone():Octagon             *           * 	getArea(): double							*			 *___________________________________*
 *___________________________________*           * 	getPerimeter(): double						*
                                                 * 	getSide(): double                           *
                                                 *  	    				                    *
                                                 *  +clone(): Octagon                           *
                                                 * 	+toString(): String							*
                                                 * 	+compareTo():int							*
                                                 * _____________________________________________*
                                                 */
public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {
    private double side;

    public Octagon(){super();}

    public Octagon(double side){
        this.side = side;
    }



    @Override
    public Octagon clone() throws CloneNotSupportedException {
        return (Octagon) super.clone();

    }

    @Override
    public String toString() {
        return "Octagon{" +
                "side=" + side +
                '}';
    }

    @Override
    public double getArea() {
        return (2 + (4 / 22)) * side * side;
    }

    @Override
    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public int compareTo(Octagon o) {
        return Double.compare(this.side,o.side);
    }

}
