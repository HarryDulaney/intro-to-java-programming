package ch_10.exercise10_10;

//__________________________UML DIAGRAM_____________________________*
/*																	|
 * 							 Queue  								|
 *------------------------------------------------------------------|
 *                     -elements : int[]          					|
 *					   -size : int                                  |
 *                     +capacity:int								|
 *------------------------------------------------------------------|
 *          	     +Queue()										|
 * 	 																|
 * 	              +enqueue(int) : void				       			|
 * 																	|
 * 	              +dequeue():  void    					    		|
 * 	 																|
 * 	               +empty(): boolean								|
 *  																|
 * 	               getSize():int   									|
 * 																	|
 * _________________________________________________________________|  */

import java.util.Arrays;

/**
 * *10.10 (The Queue class) Section 10.6 gives a class for Stack.
 * Design a class named Queue for storing integers.
 * Like a stack, a queue holds elements.
 * <p>
 * In a stack, the elements are retrieved in a last-in first-out fashion.
 * In a queue, the elements are
 * retrieved in a first-in first-out fashion.
 * <p>
 * The class contains:
 * ■ An int[] data field named elements that stores the int values in the
 * queue.
 * ■ A data field named size that stores the number of elements in the queue.
 * ■ A constructor that creates a Queue object with default capacity 8.
 * ■ The method enqueue(int v) that adds v into the queue.
 * ■ The method dequeue() that removes and returns the element from the
 * queue.
 * ■ The method empty() that returns true if the queue is empty.
 * ■ The method getSize() that returns the size of the queue.
 * Draw an UML diagram for the class.
 * <p>
 * Implement the class with the initial array
 * size set to 8. The array size will be doubled once the number of the elements
 * exceeds the size. After an element is removed from the beginning of the array,
 * you need to shift all elements in the array one position the left.
 */
public class Queue {
    int[] elements;
    int size;
    static final int DEFAULT_CAPACITY = 8;

    public Queue() {
        elements = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    void enqueue(int v) {
        if ((size + 1) > elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
        elements[size] = v;
        size++;
    }

    int dequeue() {
        int res = -1;
        if (size > 0) {
            res = elements[0];
            for (int i = 1; i < size; i++) {
                elements[i - 1] = elements[i];
            }
            size--;
        }
        return res;
    }

    boolean empty() {
        return size == 0;
    }

    int getSize() {
        return size;
    }


}
