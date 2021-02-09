package ch_13;

import java.util.ArrayList;

/**
 * 13.8. (Revise the MyStack class) Rewrite the MyStack class
 * in Listing 11.10 to perform a deep copy of the list field.
 */
public class Exercise13_08 {

    public static void main(String[] args) throws CloneNotSupportedException {

        MyStack start = new MyStack();

        start.push(new String("One"));
        start.push(new String("Two"));
        start.push(new String("Three"));

        MyStack cloned = (MyStack) start.clone();
        System.out.println("Is the cloned stack a shallow copy of the starting stack?");
        System.out.println(cloned == start);
        System.out.println("\nCloned " + cloned.toString());
        System.out.println("\nOriginal " + start.toString());
    }

}

class MyStack implements Cloneable {

    private ArrayList<Object> list = new ArrayList<Object>();

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(getSize() - 1);
    }

    public Object pop() {
        Object obj = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return obj;
    }

    public void push(Object obj) {
        list.add(obj);

    }

    public int search(Object obj) {

        return list.indexOf(obj);

    }

    @Override
    public Object clone() throws CloneNotSupportedException {

        MyStack myStack_Clone = (MyStack) super.clone();

        myStack_Clone.list = makeDeepCopy();

        return myStack_Clone;
    }

    private ArrayList<Object> makeDeepCopy() {

        ArrayList<Object> arrlist = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {

            arrlist.add(list.get(i));
        }
        return arrlist;
    }

    @Override
    public String toString() {
        return "Stack: " + list.toString();

    }
}
