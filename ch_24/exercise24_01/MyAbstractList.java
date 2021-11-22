package ch_24.exercise24_01;

import java.util.Iterator;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0; // The size of the list

    /**
     * Create a default list
     */
    protected MyAbstractList() {
    }

    /**
     * Create a list from an array of objects
     */
    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /**
     * Add a new element at the end of this list
     */
    @Override
    public void add(E e) {
        add(size, e);
    }

    /**
     * Return true if this list doesn't contain any elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Remove the first occurrence of the element e
     * from this list. Shift any subsequent elements to the left.
     * Return true if the element is removed.
     */
    @Override
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else
            return false;
    }

    /*---------------------------------------------  Exercise24_01 ---------------------------------------------------*/

    /**
     * Adds the elements in otherList to this list.
     * Returns true if this list changed as a result of the call
     */
    @Override
    public boolean addAll(MyList<E> otherList) {
        int startSize = size;
        for (E e : otherList) {
            if (!contains(e)) {
                add(e);
            }
        }
        return size == startSize;
    }

    /**
     * Removes all the elements in otherList from this list
     * Returns true if this list changed as a result of the call
     */
    @Override
    public boolean removeAll(MyList<E> otherList) {
        boolean changed = false;
        for (E e : otherList) {
            boolean removed = remove(e);
            if (removed) {
                changed = true;
            }
        }
        return changed;
    }

    /**
     * Retains the elements in this list that are also in otherList
     * Returns true if this list changed as a result of the call
     */
    @Override
    public boolean retainAll(MyList<E> otherList) {
        boolean changed = false;
        for (E e : this) {
            if (!otherList.contains(e)) {
                remove(indexOf(e));
                changed = true;
            }
        }
        return changed;
    }
}