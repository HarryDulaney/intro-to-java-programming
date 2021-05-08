package ch_13.exercise13_10;


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
/*					  ^
				      ^
			    	  ^
					  ^	 
/*_________________UML Diagram__________________*
 *______________________________________________*
 *                 Rectangle	        	    *
 *______________________________________________*
 * 							  			 		*
 *  width: double 								*
 *  						    				*
 *  height: double								*						
 *  						  					*			            _____________________________________
 * 	Rectangle()									*			            *	        <<interface>>           *
 * 						  					    * 			            *  java.lang.Comparable<Rectangle>  *
 *  Rectangle(newWidth:double, newHeight:Double)* >>>>>>>>>>>>>>>>>>>>>>*___________________________________*
 *  											*			            *	+compareTo(obj:Rectangle):int   *
 * 	getArea(): double							*			            *___________________________________*
 * 	getPerimeter(): double						*
 * 												*
 * 	+toString(): String							*
 * 	+compareTo():int							*
 * 	+equals(): boolean							*
 * _____________________________________________*
 */

/* ******************************************* */

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
