package ch_11;

/*11.10 (Implement MyStack using inheritance) 
 * 
 * In Listing 11.10 MyStack is implemented using composition. 
 * Define a new stack class that extends ArrayList.
 * 
 * Draw the UML diagram for the classes and then implement MyStack. 
 * Write a test program that prompts the user to enter five strings 
 * and displays them in reverse order.
 */

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
 *//*********************************************/



/**
 * @author Harry G. Dulaney IV
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise11_10 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		MyStack testStack = new MyStack();
		
		do {
			
			System.out.print("Enter a string to place onto the stack:");
			testStack.push(input.nextLine());
			
			
		}while(testStack.getSize() < 5);
		
		System.out.println();
		
		while(!testStack.isEmpty()) {
			
			System.out.println(testStack.pop());
			
		}
		
		
	input.close();}
}
class MyStack extends ArrayList<Object>{

	
	public int getSize() {
		return super.size();
	}
	public Object peek() {
		return get(getSize() - 1);
	}
	
	public Object pop() {
		Object obj = get(getSize() - 1);
		remove(getSize() - 1);
		return obj;
	}
	
	public Object push(Object obj) {
		add(obj);
		return obj;
	}
	public int search(Object obj) {
		
		return indexOf(obj);
		
	}

@Override
	public String toString() {
		return "Stack: " + toString();
	
	}
}