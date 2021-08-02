package ch_09.exercise09_01;

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
 */
public class Rectangle {

    double width;
    double height;

    Rectangle() {
        width = 1;
        height = 1;
    }

    Rectangle(double newWidth, double newHeight) {

        width = newWidth;
        height = newHeight;
    }

    double getArea() {
        return width * height;
    }

    double getPerimeter() {

        return (2 * width) + (2 * height);
    }
}



