package ch_11;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * 11.13 (Remove duplicates) Write a method that removes the
 * duplicate elements from an array list of integers using the following header:
 * public static void removeDuplicate(ArrayList<Integer> list)
 * <p>
 * <p>
 * Write a test program that prompts the user to enter 10 integers to a list
 * and displays the distinct integers in their input order and
 * separated by exactly one space.
 */
public class Exercise11_13 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Integer> testList = new ArrayList<>();

        System.out.println("Enter ten integers to put into the list now:");

        for (int i = 0; i < 10; i++) {
            testList.add(input.nextInt());
        }

        removeDuplicate(testList);


        System.out.print("The distinct integers are ");
        for (Integer integer : testList) {
            System.out.print(integer + " ");
        }
        input.close();
    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        Integer temp;
        for (int i = 0; i < list.size(); i++) {

            temp = list.get(i);

            list.remove(i);

            while (list.contains(temp)) {

                list.remove(temp);
            }

            list.add(i, temp);

        }


    }
}
