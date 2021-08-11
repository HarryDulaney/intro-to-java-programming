package ch_19.exercise19_02;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * UML Diagram:
 *
 * <img src="../../resources/uml-diagrams/exercise19_02.png"/>
 *
 * @param <E> Type held by the ArrayListGenericStack instance.
 */
public class ArrayListGenericStack<E> extends ArrayList<E> {

    public int getSize() {
        return size();
    }

    public E peek() {
        return get(getSize() - 1);
    }

    public Object push(E o) {
        add(o);
        return o;
    }

    public Object pop() {
        Object o = get(getSize() - 1);
        remove(getSize() - 1);
        return o;
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public String toString() {
        return "Stack: " + Arrays.toString(super.toArray());
    }
}
