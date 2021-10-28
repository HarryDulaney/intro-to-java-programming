package ch_20;

import java.util.PriorityQueue;

/**
 * 20.12 (Clone PriorityQueue) Define MyPriorityQueue class that extends
 * PriorityQueue to implement the Cloneable interface and implement the
 * clone() method to clone a priority queue.
 */
public class Exercise20_12 {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyPriorityQueue<String> queue = new MyPriorityQueue<>();
        queue.offer("Testing");
        queue.offer("Test");
        queue.offer("TEST");
        MyPriorityQueue<String> clonedQueue = (MyPriorityQueue<String>) (queue.clone());

        System.out.print(clonedQueue);
    }
}

class MyPriorityQueue<E> extends PriorityQueue<E> implements Cloneable {

    @Override
    public Object clone() throws CloneNotSupportedException {
        MyPriorityQueue<E> queue = new MyPriorityQueue<E>();

        for (E e : this) {
            queue.offer(e);
        }

        return queue;
    }
}