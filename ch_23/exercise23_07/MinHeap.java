package ch_23.exercise23_07;

import java.util.NoSuchElementException;

public class MinHeap<E extends Comparable<E>> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    /**
     * Create a default min-heap
     */
    public MinHeap() {
    }


    /**
     * Create a min-heap from an array of objects
     */
    public MinHeap(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /**
     * Add a new object into the min-heap
     */
    public void add(E newObject) {
        // First add new object at the end of the heap
        list.add(newObject);
        int currentIndex = getSize() - 1; // The index of the last node
        int parentIndex = (currentIndex - 1) / 2;
        // Now rebuild the heap to ensure min-heap property is maintained
        E nextElement = list.get(currentIndex); // Get the current node element
        E parentElement = list.get(parentIndex);// Get the parent element for current node
        while (currentIndex != 0 && nextElement.compareTo(parentElement) < 0) {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            nextElement = list.get(currentIndex);
            parentIndex = (currentIndex - 1) / 2;
            parentElement = list.get(parentIndex);
        }
    }

    /**
     * Remove the root from the heap
     */
    public E remove() {
        if (list.size() == 0) return null;

        E removedObject = list.get(0); // Remove the root element (min element)
        list.set(0, list.get(getSize() - 1));
        list.remove(getSize() - 1);

        int currentIndex = 0;
        while (currentIndex < getSize()) {

            int leftChildIndex = leftChild(currentIndex);
            int rightChildIndex = rightChild(currentIndex);

            // Find the maximum between two children
            if (leftChildIndex >= getSize()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < getSize()) {
                if (list.get(maxIndex).compareTo(
                        list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than the maximum
            if (list.get(currentIndex).compareTo(
                    list.get(maxIndex)) < 0) {
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

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        return pos >= ((list.size() - 1) / 2) && pos <= (list.size() - 1);
    }

    private void swap(int p1, int p2) {
        E tmp = list.get(p1);
        list.set(p1, list.get(p2));
        list.set(p2, tmp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < Math.pow(2, i) && j + Math.pow(2, i) < getSize(); j++) {
                sb.append(list.get(j + (int) Math.pow(2, i) - 1)).append(", ");
            }
        }
        return sb.toString();
    }

}