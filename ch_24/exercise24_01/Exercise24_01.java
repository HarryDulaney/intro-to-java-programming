package ch_24.exercise24_01;

/**
 * 24.1 (Add set operations in MyList) Define the following methods in MyList and
 * implement them in MyAbstractList:
 * Adds the elements in otherList to this list.
 * Returns true if this list changed as a result of the call
 * public boolean addAll(MyList<E> otherList);
 * <p>
 * Removes all the elements in otherList from this list
 * Returns true if this list changed as a result of the call
 * <p>
 * public boolean removeAll(MyList<E> otherList);
 * <p>
 * Retains the elements in this list that are also in otherList
 * Returns true if this list changed as a result of the call
 * <p>
 * public boolean retainAll(MyList<E> otherList);
 * <p>
 * <p>
 * Write a test program that creates two MyArrayLists,list1 and list2, with
 * the initial values{"Tom","George","Peter","Jean","Jane"} and
 * {"Tom","George","Michael","Michelle","Daniel"},then perform the following operations:
 * ■ Invokes list1.addAll(list2),and displays list1 and list2.
 * ■ Recreates list1 and list2 with the same initial values,invokes
 * list1.removeAll(list2),and displays list1 and list2.
 * ■ Recreates list1 and list2 with the same initial values,invokes
 * list1.retainAll(list2),and displays list1 and list2.
 */
public class Exercise24_01 {
    private final static String[] LIST_ONE_INIT_VALS = {"Tom", "George", "Peter", "Jean", "Jane"};
    private final static String[] LIST_TWO_INIT_VALS = {"Tom", "George", "Michael", "Michelle", "Daniel"};

    public static void main(String[] args) {

        MyList<String> list1 = new MyArrayList<>(LIST_ONE_INIT_VALS);
        MyList<String> list2 = new MyArrayList<>(LIST_TWO_INIT_VALS);
        System.out.println("List 1 and List 2 initial values: ");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);


        System.out.println("list1.addAll(list2) result: ");
        list1.addAll(list2);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        list1 = new MyArrayList<>(LIST_ONE_INIT_VALS);
        list2 = new MyArrayList<>(LIST_TWO_INIT_VALS);

        System.out.println("list1.removeAll(list2) result: ");
        list1.removeAll(list2);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

        list1 = new MyArrayList<>(LIST_ONE_INIT_VALS);
        list2 = new MyArrayList<>(LIST_TWO_INIT_VALS);

        System.out.println("list1.retainAll(list2) result: ");
        list1.retainAll(list2);
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);

    }
}