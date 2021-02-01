package ch_10.exercise10_03;

import java.util.Scanner;

import static ch_10.exercise10_03.MyInteger.parseInt;

public class Exercise10_03 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        MyInteger testObj = new MyInteger(123);

        MyInteger testObj2 = new MyInteger(24);

        String str = "";

        if (testObj.isEven()) {
            str += "Even";
        } else if (testObj.isOdd()) {
            str += "Odd";
        } else if (testObj.isPrime()) {
            str += "Prime";
        }

        System.out.println("The first MyInteger test object " + testObj.getValue() + " is found to be " + str);

        String str2 = "";

        if (testObj2.isEven()) {
            str2 += "Even";
        } else if (testObj2.isOdd()) {
            str2 += "Odd";
        } else if (testObj2.isPrime()) {
            str2 += "Prime";
        }

        System.out.println("The second MyInteger test object " + testObj2.getValue() + " is found to be " + str2);

        System.out.println("Please enter an integer number to compare with test object one:");

        String str3 = "";

        int j = input.nextInt();

        if (testObj.equals(j)) {

            str3 += "equal";
        } else if (!testObj.equals(j)) {
            str3 += "not equal";
        }


        System.out.println("Integer " + j + " and test object one " + testObj.getValue() + " are found to be " + str3);

        char[] testArray = {1, 2, 3, 4, 5};

        System.out.println("The test array of numeric characters 1 2 3 4 5 "
                + "has an sum integer value of: " + parseInt(testArray));
        System.out.println("Enter a string to convert to an Integer: ");

        String testString = input.next();

        System.out.println("The test string 54321 is now the integer number " + parseInt(testString));

        input.close();
    }
}
