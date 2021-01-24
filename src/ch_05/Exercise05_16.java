package ch_05;

import java.util.*;

/**
 * *5.16 (Find the factors of an integer) Write a program that reads an integer and displays
 * all its smallest factors in increasing order. For example, if the input integer is
 * 120, the output should be as follows: 2, 2, 2, 3, 5.
 */
public class Exercise05_16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter an integer: ");
        int num = in.nextInt();

        for (int i = 2; num / i != 1; ) {

            if (num % i == 0) {
                System.out.print(i + ",");
                num = num / i; //Remove the factor from num
            } else {
                //Iterate to next possible factor
                i++;
            }


        }
        //Print number as it has been reduced to the remaining factor
        System.out.print(num);

        in.close();


    }
}