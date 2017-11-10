package main.util;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {
	private List<Tree<T>> branches = null;
	private Tree<T> parent = null;
	private T object = null;
	
	private Tree (Tree<T> p, T t) {
		branches = new ArrayList<Tree<T>>();
		parent = p;
		object = t;
	}
	
	public Tree (T t) {
		branches = new ArrayList<Tree<T>>();
		object = t;
	}
	
	public List<Tree<T>> getChildren() {
		return branches;
	}
	
	public Tree<T> getParent() {
		return parent;
	}
	
	public T getValue() {
		return object;
	}
	
	public void setValue(T t) {
		object = t;
	}
	
	public void add(T t) {
		branches.add(new Tree<T>(this, t));
		branches.sort(null);
	}
	
	public List<T> toList() {
		List<T> ret = new ArrayList<T>();
		ret.add(object);
		for (Tree<T> t : branches) {
			ret.addAll(t.toList());
		}
		return ret;
	}
	
	public Tree<T> getBase() {
		if (parent == null) {
			return this;
		} else {
			return parent.getBase();
		}
	}
}
