package ch_10;

/*Exercise10_03(The MyInteger class) 
 * Design a class named MyInteger. The class contains:

An int data field named value that stores the int value represented by this object.

A constructor that creates a MyInteger object for the specified int value.

A getter method that returns the int value.

The methods isEven(), isOdd(), and isPrime() that return true if the value in this 
object is even, odd, or prime, respectively.

The static methods isEven(int), isOdd(int), and isPrime(int) that return true if the 
specified value is even, odd, or prime, respectively.

The static methods isEven(MyInteger), isOdd(MyInteger), and isPrime(MyInteger) that 
return true if the specified value is even, odd, or prime, respectively.

The methods equals(int) and equals(MyInteger) that return true if the value in this 
object is equal to the specified value.

A static method parseInt(char[]) that converts an array of numeric characters to an int value.

A static method parseInt(String) that converts a string into an int value.

Draw the UML diagram for the class and then implement the class. Write a client 
program that tests all methods in the class.
 */


//__________________________UML DIAGRAM_____________________________*
/*																	|																															
* 							 MyInteger								|
*-------------------------------------------------------------------|
* -Value:int	(Value of object)									|
*																	|
*-------------------------------------------------------------------|
* 	 +MyInteger(value: int)											|
* 	 																|
* 	 +getMyIntValue() : int											|
* 																	|
* 	 +isEven(): boolean    											|
* 	 																|
* 	 +isOdd(): boolean												|
*  																	|
* 	+isPrime():boolean 												|
* 																	|
* 	__+isEven(int):boolean___										|
* 																	|
* 	___+isOdd(int):boolean___										|
* 																	|
* 	____+isPrime(int):boolean___									|
* 																	|															
* 	____+isEven	MyInteger():boolean___ 								|
* 																	|		
* 	____+isOdd(MyInteger):boolean_____   							|
* 																	|
* 	___+isPrime(MyInteger):boolean_____ 							|
* 																	|
* 	+equals(int): boolean											|
* 																	|
* 	+equals(MyInteger):boolean										|
* 																	|
* 	___+parseInt(Char[]): int___									|
* 																	|
* 	_____+parseInt(String):int____      							|
* 																	|
* 																	|
* 																	|
* 																	|
* 																	|
* __________________________________________________________________|  */



/**
 * @author Harry G. Dulaney IV
 */
import java.util.Scanner;

public class MyInteger10_03 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
	
		MyInteger10_03 testObj = new MyInteger10_03(123);
		
		MyInteger10_03 testObj2= new MyInteger10_03(24);
		
		String str = "";
		
		if(testObj.isEven()) {
			str += "Even";
		}else if(testObj.isOdd()) {
			str += "Odd";
		}else if(testObj.isPrime()) {
			str += "Prime";
		}
		
		System.out.println("The first MyInteger test object " + testObj.getValue() + " is found to be " + str);
		
		String str2 = "";
		
		if(testObj2.isEven()) {
			str2 += "Even";
		}else if(testObj2.isOdd()) {
			str2 += "Odd";
		}else if(testObj2.isPrime()) {
			str2 += "Prime";
		}
		
		System.out.println("The second MyInteger test object " + testObj2.getValue() + " is found to be " + str2);
		
		
		System.out.println("Now please enter an integer number to compare with test object one:");
		
		String str3 = "";
		
		int j = input.nextInt();
		
		if(testObj.equals(j)) {
			
			str3 += "equal";
		}else if(!testObj.equals(j)) {
			str3 += "not equal";
		}
		

		System.out.println("Integer " + j + " and test object one " + testObj.getValue() + " are found to be " + str3);
		
		char[] testArray = {1,2,3,4,5};

		System.out.println("The test array of numeric characters 1 2 3 4 5 "
				+ "has an sum integer value of: " + parseInt(testArray));
		
		String testString = "54321";
		
		
		System.out.println("The test string 54321 is now the integer number " + parseInt(testString));
			
		input.close();
	}
	
	private int value;
	
	public MyInteger10_03(int newValue){
		 
		 this.value = newValue;
		
	}
	public int getValue() {
		return value;
	}
	public boolean isEven() {
		
		if(value % 2 == 0)
			return true;
		else
			return false;
		
	}
	public boolean isOdd() {
		if(value % 2 != 0)
			return true;
		else
			return false;
		
	}
	public boolean isPrime() {
		boolean prime = false;
			for(int i = 3; i < value/2; i++) {
				if(value % i == 0) {
					prime = false;
				}else {
					prime = true;break;
				}
				}
			
		return prime;}
	
	public static boolean isEven(int a) {
		if(a % 2 == 0)
			return true;
		else
			return false;
		
	}
	public static boolean isOdd(int a) {
		if(a % 2 != 0) {
			return true;
		}else {
			return false;}
		}
	
	public static boolean isPrime(int a) {
		boolean wellisIt = false;
		
			for (int i = 2; i < a/2; i++) {
				if(a % i == 0) {
					wellisIt = false;
				}else {
					wellisIt = true;}
				
			}
			
		return wellisIt;
		
	}
	
	public static boolean isEven(MyInteger10_03 a) {
		return a.isEven();
			
		}
		
	public static boolean isOdd(MyInteger10_03 a) {
		return a.isOdd();
	}
	
	public static boolean isPrime(MyInteger10_03 a) {
		return a.isPrime();
	}
	public boolean equals(int a) {
		if(this.value == a) {
			return true;
		}else
			return false;
		}
	public boolean equals(Integer a) {
		if(this.value == a) {
			return true;
		}else {
			return false;}
	}
	public static int parseInt(char[] arr) {
		
		String str = String.valueOf(arr);
		
		 int result = 0;
		 
	       for (int j = 0; j < str.length();j++) {
	        	
	           result += str.charAt(j);
	        }
	       
	        return result;
	
	}
	public static int parseInt(String a) {
		
		int stringInt = Integer.parseInt(a);
	
		return stringInt;
		
	}
	
}