package ch_19.exercise19_01;

import ch_19.activites.GenericStack;


/**
 * 19.1 (Revising Listing 19.1) Revise the GenericStack class in Listing 19.1 to implement
 * it using an array rather than an ArrayList. You should check the array size
 * before adding a new element to the stack. If the array is full, create a new array that
 * doubles the current array size and copy the elements from the current array to the
 * new array.
 */
public class Exercise19_01 {
    //Test exercise19_01.GenericStack.class
    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<>();
        stack1.push("Atlanta");
        stack1.push("Memphis");
        stack1.push("New York");
        stack1.push("Columbus");
        stack1.push("Chicago");
        stack1.push("St. Louis");
        stack1.push("New Orleans");
        stack1.push("Boston");

        while (stack1.getSize() > 0) {
            System.out.println("Pop: " + stack1.pop());
        }

    }
}
