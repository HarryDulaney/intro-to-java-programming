package ch_11.exercise11_10;

import java.util.Scanner;



/*______________________________________________
 |			      ArrayList						|
 |______________________________________________|
					  ^
					  ^
					  |
					  |
/***********************************************/
/*________________UML Diagram___________________*
 *______________________________________________*
 *             	    MyStack			        	*
 *______________________________________________*
 * 		-isEmpty() : boolean  			 		*
 *  	-getSize()	: int						*
 * 		-peek()	: Object						*
 * 		-pop()	: Object						*
 * 		-push(obj:Object) : Object				*
 * 		-search(obj:Object) : int				*
 * 		-toString()	:String						*
 * _____________________________________________*
 *//* /*************************************** */


/**
 * 11.10 (Implement MyStack using inheritance)
 * <p>
 * In Listing 11.10 MyStack is implemented using composition.
 * Define a new stack class that extends ArrayList.
 * <p>
 * Draw the UML diagram for the classes and then implement MyStack.
 * Write a test program that prompts the user to enter five strings
 * and displays them in reverse order.
 */

public class Exercise11_10 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        MyStack testStack = new MyStack();

        do {

            System.out.print("Enter a string to place onto the stack:");
            testStack.push(input.nextLine());


        } while (testStack.getSize() < 5);

        System.out.println();

        while (!testStack.isEmpty()) {

            System.out.println(testStack.pop());

        }


        input.close();
    }
}
