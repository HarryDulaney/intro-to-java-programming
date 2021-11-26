package ch_19;

import java.util.Arrays;


/**
 * 19.1 (Revising Listing 19.1) Revise the ArrayListGenericStack class in Listing 19.1 to implement
 * it using an array rather than an ArrayList. You should check the array size
 * before adding a new element to the stack. If the array is full, create a new array that
 * doubles the current array size and copy the elements from the current array to the
 * new array.
 */
public class Exercise19_01 {
    //Test
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
        stack1.push("Atlanta");
        stack1.push("Memphis");
        stack1.push("New York");
        stack1.push("Chicago");
        stack1.push("St. Louis");
        stack1.push("New Orleans");
        stack1.push("Boston");
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

class GenericStack<E> {
    private static int capacity = 16;
    private static final int INCREMENT = 16;
    private int size;
    private E[] list = (E[]) new Object[capacity];

    public GenericStack() {
    }

    private void increaseCapacity() {
        capacity += INCREMENT;
        E[] nuList = (E[]) new Object[capacity];
        for (int i = 0; i < list.length; i++) {
            nuList[i] = list[i];
        }
        list = nuList;
    }

    public int getSize() {
        return size;
    }

    public E peek() {
        return list[size - 1];
    }

    public void push(E o) {
        list[size++] = o;
        if (size == capacity) {
            increaseCapacity();
        }
    }

    public E pop() {
        if (size > 0) {
            return list[--size];
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "stack: " + Arrays.toString(list);
    }
}