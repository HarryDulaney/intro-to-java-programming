package ch_23.exercise23_07;

import java.util.Random;

/**
 * 23.7 (Min-heap) The heap presented in the text is also known as a max-heap, in which
 * each node is greater than or equal to any of its children. A min-heap is a heap
 * in which each node is less than or equal to any of its children. Min-heaps are
 * often used to implement priority queues. Revise the Heap class in Listing 23.9 to
 * implement a min-heap.
 */
public class Exercise23_07 {
    public static void main(String[] args) {
        MinHeap<Double> minHeap = new MinHeap<>();
        minHeap.add(1.0);
        minHeap.add(2.0);
        for (int i = 0; i < 20; i++) {
            Double random = new Random(100).nextDouble();
            minHeap.add(random);
        }

        System.out.println("Min Heap: ");
        System.out.println(minHeap);
        System.out.println("Min Heap Size: " + minHeap.getSize());

    }
}
