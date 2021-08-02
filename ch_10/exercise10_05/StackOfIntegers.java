package ch_10.exercise10_05;

/**
 * FIGURE 10.13 The StackOfIntegers class encapsulates the stack storage and provides
 * the operations for manipulating the stack.
 * ... . . .
 * elements[0]
 * elements[1]
 * elements[size  1]
 * capacity
 * top
 * bottom
 * size
 * elements[capacity  1]
 * How do you implement the StackOfIntegers class? The elements in the stack are stored
 * in an array named elements. When you create a stack, the array is also created. The no-arg
 * constructor creates an array with the default capacity of 16. The variable size counts the
 * number of elements in the stack, and size – 1 is the index of the element at the top of the
 * stack, as shown in Figure 10.13. For an empty stack, size is 0.
 * The StackOfIntegers class is implemented in Listing 10.8. The methods empty(),
 * peek(), pop(), and getSize() are easy to implement. To implement push(int value),
 * assign value to elements[size] if size < capacity (line 24). If the stack is full (i.e.,
 * size >= capacity), create a new array of twice the current capacity (line 19), copy the contents of
 * the current array to the new array (line 20), and assign the reference of the new array
 * to the current array in the stack (line 21). Now you can add the new value to the array (line 24).
 */
public class StackOfIntegers {
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    /**
     * Construct a stack with the default capacity 16
     */
    public StackOfIntegers() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Construct a stack with the specified maximum capacity
     */
    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
    }

    /**
     * Push a new integer to the top of the stack
     */
    public void push(int value) {
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = value;
    }

    /**
     * Return and remove the top element from the stack
     */
    public int pop() {
        return elements[--size];
    }

    /**
     * Return the top element from the stack
     */
    public int peek() {
        return elements[size - 1];
    }

    /**
     * Test whether the stack is empty
     */
    public boolean empty() {
        return size == 0;
    }

    /**
     * Return the number of elements in the stack
     */
    public int getSize() {
        return size;
    }
}
