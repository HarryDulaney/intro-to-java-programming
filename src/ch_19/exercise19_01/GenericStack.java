package ch_19.exercise19_01;

import java.util.Arrays;

public class GenericStack<E> {
    private static final int startCapacity = 2;
    private static final int increase = 2;
    private int currentCapacity = startCapacity;
    private int pointer = 0;

    private E[] list = (E[]) new Object[startCapacity];

    private void increaseCapacity() {
        currentCapacity *= increase;
        E[] nooList = (E[]) new Object[currentCapacity];
        for (int i = 0; i < getSize(); i++) {
            nooList[i] = list[i];
        }
        list = nooList;

    }

    public int getSize() {
        return list.length;
    }

    public E peek() {
        return list[getSize() - 1];
    }

    public void push(E o) {
        if ((getSize() - 1) < pointer) {
            increaseCapacity();
        }

        list[pointer] = o;
        ++pointer;
    }

    public E pop() {
        E o = list[getSize() - 1];
        list[getSize() - 1] = null;
        return o;
    }

    public boolean isEmpty() {
        return list.length == 0;
    }

    @Override
    public String toString() {
        return "stack: " + Arrays.toString(list);
    }
}