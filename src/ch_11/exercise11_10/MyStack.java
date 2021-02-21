package ch_11.exercise11_10;

import java.util.ArrayList;

public class MyStack extends ArrayList<Object> {


    public int getSize() {
        return super.size();
    }

    public Object peek() {
        return get(getSize() - 1);
    }

    public Object pop() {
        Object obj = get(getSize() - 1);
        remove(getSize() - 1);
        return obj;
    }

    public Object push(Object obj) {
        add(obj);
        return obj;
    }

    public int search(Object obj) {

        return indexOf(obj);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        while (getSize() > 0) {
            sb.append(String.valueOf(pop()));
        }
        return "Stack: " + sb.toString();

    }
}
