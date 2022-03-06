package ch_23.exercise23_05;


import java.util.Comparator;

public class Heap<E> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();
    /**
     * Exercise23_05
     */
    private final Comparator<? super E> comparator;

    /**
     * Create a default heap
     * Exercise23_05
     */
    public Heap(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /**
     * Create a heap from an array of objects
     * Exercise23_05
     */
    public Heap(E[] objects, Comparator<? super E> comparator) {
        this.comparator = comparator;
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /**
     * Add a new object into the heap
     */
    public void add(E newObject) {
        list.add(newObject); // Append to the heap
        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            // Swap if the current object is greater than its parent
            // Exercise23_05
            if (comparator.compare(list.get(currentIndex), list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else
                break; // The tree is a heap now

            currentIndex = parentIndex;
        }
    }

    /**
     * Remove the root from the heap
     */
    public E remove() {
        if (list.size() == 0) return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the maximum between two children
            if (leftChildIndex >= list.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                // Exercise 23 05
                if (comparator.compare(list.get(maxIndex), list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than the maximum
            // Exercise23_05
            if (comparator.compare(list.get(currentIndex), list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else
                break; // The tree is a heap
        }

        return removedObject;
    }

    /**
     * Get the number of nodes in the tree
     */
    public int getSize() {
        return list.size();
    }
}
