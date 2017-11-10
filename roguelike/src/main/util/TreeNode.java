package main.util;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TreeNode<T> implements Iterable<TreeNode<T>> {

	private Set<TreeNode<T>> children;
	private T object = null;
	
	public TreeNode() {
		children = new HashSet<TreeNode<T>>();
	}

	public boolean addChild(TreeNode<T> n) {
		return children.add(n);
	}

	public boolean removeChild(TreeNode<T> n) {
		return children.remove(n);
	}

	public Iterator<TreeNode<T>> iterator() {
		return children.iterator();
	}
	
	public void setObject(T t) {
		object = t;
	}
	
	public T getObject() {
		return object;
	}
	
}