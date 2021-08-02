package ch_13.exercise13_08;

import java.util.ArrayList;

public class MyStack implements Cloneable {

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
