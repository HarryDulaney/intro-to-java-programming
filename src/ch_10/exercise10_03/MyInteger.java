package ch_10.exercise10_03;


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
 *  																|
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
 * Exercise10_03(The MyInteger class)
 * Design a class named MyInteger. The class contains:
 * <p>
 * An int data field named value that stores the int value represented by this object.
 * <p>
 * A constructor that creates a MyInteger object for the specified int value.
 * <p>
 * A getter method that returns the int value.
 * <p>
 * The methods isEven(), isOdd(), and isPrime() that return true if the value in this
 * object is even, odd, or prime, respectively.
 * <p>
 * The static methods isEven(int), isOdd(int), and isPrime(int) that return true if the
 * specified value is even, odd, or prime, respectively.
 * <p>
 * The static methods isEven(MyInteger), isOdd(MyInteger), and isPrime(MyInteger) that
 * return true if the specified value is even, odd, or prime, respectively.
 * <p>
 * The methods equals(int) and equals(MyInteger) that return true if the value in this
 * object is equal to the specified value.
 * <p>
 * A static method parseInt(char[]) that converts an array of numeric characters to an int value.
 * <p>
 * A static method parseInt(String) that converts a string into an int value.
 * <p>
 * Draw the UML diagram for the class and then implement the class. Write a client
 * program that tests all methods in the class.
 */
public class MyInteger {

    private int value;

    public MyInteger(int newValue) {

        this.value = newValue;

    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {

        if (value % 2 == 0)
            return true;
        else
            return false;

    }

    public boolean isOdd() {
        if (value % 2 != 0)
            return true;
        else
            return false;

    }

    public boolean isPrime() {
        boolean prime = false;
        for (int i = 3; i < value / 2; i++) {
            if (value % i == 0) {
                prime = false;
            } else {
                prime = true;
                break;
            }
        }

        return prime;
    }

    public static boolean isEven(int a) {
        if (a % 2 == 0)
            return true;
        else
            return false;

    }

    public static boolean isOdd(int a) {
        if (a % 2 != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isPrime(int a) {
        boolean wellisIt = false;

        for (int i = 2; i < a / 2; i++) {
            if (a % i == 0) {
                wellisIt = false;
            } else {
                wellisIt = true;
            }

        }

        return wellisIt;

    }

    public static boolean isEven(MyInteger a) {
        return a.isEven();

    }

    public static boolean isOdd(MyInteger a) {
        return a.isOdd();
    }

    public static boolean isPrime(MyInteger a) {
        return a.isPrime();
    }

    public boolean equals(int a) {
        if (this.value == a) {
            return true;
        } else
            return false;
    }

    public boolean equals(Integer a) {
        if (this.value == a) {
            return true;
        } else {
            return false;
        }
    }

    public static int parseInt(char[] arr) {

        String str = String.valueOf(arr);

        int result = 0;

        for (int j = 0; j < str.length(); j++) {

            result += str.charAt(j);
        }

        return result;

    }

    public static int parseInt(String a) {

        return Integer.parseInt(a);

    }

}