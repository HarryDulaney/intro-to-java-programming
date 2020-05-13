package ch_02;

import java.util.Scanner;

/*2.9 (Physics: acceleration) Average acceleration is defined as the change of velocity
divided by the time taken to make the change, as shown in the following formula:
a =
v1 - v0
t
Write a program that prompts the user to enter the starting velocity v0 in meters/
second, the ending velocity v1 in meters/second, and the time span t in seconds,
and displays the average acceleration. Here is a sample run:
*/

public class Exercise0209 {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Enter v0, v1, and t:  ");
    double v0,v1,t;

    v0 = input.nextDouble();
    v1 = input.nextDouble();
    t = input.nextDouble();

    double a = (v1 - v0) / t;

    System.out.println("Acceleration is " + a);


  }


}
