package ch_13;

import java.util.ArrayList;

/*13.8. (Revise the MyStack class) Rewrite the MyStack class 
 * in Listing 11.10 to perform a deep copy of the list field.
 */


/**
 * @author Harry G. Dulaney IV
 */

public class MyStack13_08 implements Cloneable {

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

		MyStack13_08 MyStack13_08_Clone = (MyStack13_08) super.clone();

		MyStack13_08_Clone.list = makeDeepCopy();

		return MyStack13_08_Clone;
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

	public static void main(String[] args) throws CloneNotSupportedException {

		MyStack13_08 start = new MyStack13_08();

		start.push(new String("One"));

		start.push(new String("Two"));

		start.push(new String("Three"));

		MyStack13_08 cloned = (MyStack13_08) start.clone();

		System.out.println("Is the cloned stack a shallow copy of the starting stack?");

		System.out.println(cloned == start);

		System.out.println("\nCloned " + cloned.toString());
		System.out.println("\nOriginal " + start.toString());
	}
}
