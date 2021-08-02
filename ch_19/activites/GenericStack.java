package ch_19.activites;

public class GenericStack<E> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<>();

    public int getSize() {
        return list.size();
    }

    public E peek() {
        return list.get(getSize() - 1);
    }

    public void push(E o) {
        list.add(o);
    }

    public E pop() {
        E o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return "stack: " + list.toString();
    }

    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        System.out.println("Run test?? Input: yes or no");
        if (input.nextLine().equalsIgnoreCase("yes")) {
            GenericStack<String> stack1 = new GenericStack<>();
            stack1.push("Atlanta");
            stack1.push("Memphis");
            stack1.push("New York");

            while (stack1.getSize() > 0) {
                System.out.println("Pop: " + stack1.pop());
            }

        } else {
            //Do Nothing
            input.close();
        }
        input.close();
    }
}
