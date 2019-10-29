package Ch_12;

/*12.1 (NumberFormatException) Listing 7.9 Calculator.java, is 
 *a simple command-line calculator. Note that the program terminates 
 *if any operand is non-numeric. Write a program with an exception 
 *handler that deals with non-numeric operands.
 */


/**
 * @author Harry G. Dulaney IV
 */
public class Exercise12_01 {  
		  public static void main(String[] args) throws NumberFormatException{
			  
	 try {  
		 int num1 = Integer.parseInt(args[0]);}
	 
	 catch(NumberFormatException ex) {
		 
		 System.out.println("Invalid Input: " + args[0]);
		 System.exit(1);
		 
	 }
	 try {
		int num2 = Integer.parseInt(args[2]);
	 }
	 catch(NumberFormatException ex) {
		 
		System.out.println("Invalid Input: " + args[2]);
		System.exit(2);
	 }
			  
		    int result = 0;

		    switch (args[1].charAt(0)) { 
		      case '+': result = Integer.parseInt(args[0]) + 
		                         Integer.parseInt(args[2]);
		                break;
		      case '-': result = Integer.parseInt(args[0]) -
		                         Integer.parseInt(args[2]);
		                break;
		      case '.': result = Integer.parseInt(args[0]) *
		                         Integer.parseInt(args[2]);
		                break;
		      case '/': result = Integer.parseInt(args[0]) /
		                         Integer.parseInt(args[2]);
		    }

		    
		    System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
		      + " = " + result);
		  }
		  
		  
		}
			
		


