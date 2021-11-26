package ch_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 19.2 (Implement ArrayListGenericStack using inheritance) In Listing 19.1, ArrayListGenericStack is
 * implemented using composition. Define a new stack class that extends ArrayList.
 * Draw the UML diagram for the classes and then implement ArrayListGenericStack.
 * <p>
 * Write a test program that prompts the user to enter five strings and displays them in
 * reverse order.
 */
public class Exercise19_02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter five String values seperated by space: ");
        String[] input = in.nextLine().split(" ");
        ArrayListGenericStack<String> stack = new ArrayListGenericStack<>();
        for (String s : input) {
            stack.push(s);
        }
        in.close();
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}


/**
 * UML Diagram:
 *
 * <img src="../../resources/uml-diagrams/exercise19_02.png"/>
 *
 * @param <E> Type held by the ArrayListGenericStack instance.
 */
class ArrayListGenericStack<E> extends ArrayList<E> {

    public int getSize() {
        return size();
    }

    public E peek() {
        return get(getSize() - 1);
    }

    public Object push(E o) {
        add(o);
        return o;
    }

    public Object pop() {
        Object o = get(getSize() - 1);
        remove(getSize() - 1);
        return o;
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack: " + Arrays.toString(super.toArray());
    }
}

