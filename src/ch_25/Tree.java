package ch_25;

public interface Tree<E> extends Iterable<E> {
	/** Returns true if element is in tree */ 
	boolean search(E e);
	
	/** Insert element into BST and return successful */
	boolean insert(E e);
	
	/** Delete e from BST and return success is true or false */
	boolean delete(E e);
	
	/** Traverse in-order from root */
	void inorder();
	
	/** Traverse post-order from root */
	void postorder();
	
	/** Traverse pre-order from root */
	void preorder();
	
	/** Returns the number of nodes */
	 int getSize();
	
	/** Returns if tree is empty */
	 boolean isEmpty();
	
	
	

}
