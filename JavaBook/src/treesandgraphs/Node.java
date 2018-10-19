package treesandgraphs;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	private T data = null;
	private ArrayList<Node<T>> children= new ArrayList<>();
	private Node<T> parent = null;
	
	public Node(T data) {
		if (data == null) {
			throw new IllegalArgumentException("Cannot insert null value!");
		}
		this.data = data;
	}
	
	public Node(T data, Node<T> parent) {
		this(data);
		this.parent = parent;
	}
	
	public Node<T> addChild(Node<T> child) {
		child.setParent(this);
		this.children.add(child);
		return child;
	}
	
	public void setParent(Node<T> parent) {
		parent.addChild(this);
		this.parent = parent;
	}
	
	public List<Node<T>> getChildren() {
		return children;
	}
	
	public T getData() {
		return this.data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public boolean isRoot() {
		return (this.parent == null);
	}
	
	public boolean isLeaf() {
		return (this.children.size() == 0);
	}
	
	public void removeParent(){
		this.parent = null;
	}
}
