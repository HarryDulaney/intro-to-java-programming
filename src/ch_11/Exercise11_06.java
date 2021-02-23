package ch_11;

import ch_17.exercise17_06.Loan;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Date;

/**
 * 11.6 (Use ArrayList) Write a program that creates an ArrayList and adds a Loan
 * object, a Date object, a string, and a Circle object to the list, and use a loop
 * to display all the elements in the list by invoking the object’s toString()
 * method.
 */
public class Exercise11_06 {
    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        list.add(new Loan());
        list.add(new Date());
        list.add("stringTest");
        list.add(new Circle());
        for (Object obj : list) {
            System.out.println(obj.toString());
        }
    }
}
