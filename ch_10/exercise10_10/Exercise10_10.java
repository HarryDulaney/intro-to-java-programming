package ch_10.exercise10_10;

/**
 * Write a test
 * program that adds 20 numbers from 1 to 20 into the queue and removes these
 * numbers and displays them.
 */
public class Exercise10_10 {
    public static void main(String[] args) {
        Queue q1 = new Queue();
        for (int i = 0; i < 20; i++) {
            int value = (int) (i + Math.random() * (int) (Math.random() * 9));
            q1.enqueue(value);
            System.out.println("TestQueue.enqueue(" + value + ")" + " ");
        }
        for (int i = 0; i < 20; i++) {
            int value = q1.dequeue();
            System.out.println("TestQueue.dequeue(" + value + ")" + " ");
        }
    }
}
