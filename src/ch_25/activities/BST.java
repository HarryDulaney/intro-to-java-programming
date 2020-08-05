package ch_25.activities;

import java.util.Iterator;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {

	protected TreeNode<E> root;
	protected int size = 0;
	/** New Constructor */
	public BST() {
		
	}
	
	/** Constructor build BST from existing objects */
	public BST(E[] objects) {
		for (int i = 0; i < objects.length; i++) {
			insert(objects[i]);
		}
	}
	
	
	@Override
	public boolean search(E e) {
		TreeNode<E> current = root;
		
		while(current != null) {
			if (e.compareTo(current.element) < 0) {
				
			}
			
		}
		
		
		return false;
	}

	@Override
	public boolean insert(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
