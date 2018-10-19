package treesandgraphs;

import java.util.ArrayList;

/**
 * Created: 05.10.2018
 * 
 * Represents a tree data structure.
 * @author Georgi Georgiev
 * @param <T> - the type of the values in the tree.
 */
public class Tree<T> {

	/**
	* Represents a tree node.
	* @param <T> - the type of the values in nodes.
	*/
	public static class TreeNode<T> {
		// Contains the value of the node
		private T value;

		// Shows whether the current node has parent
		private boolean hasParent;

		// Contains the children of the node
		private ArrayList<TreeNode<T>> children;

		/**
		 * Constructs a tree node.
		 * @param value - the value of the node.
		 */
		public TreeNode(T value) {
			if (value == null) {
				throw new IllegalArgumentException("Can not insert null value!");
			}
			this.value = value;
			this.children = new ArrayList<TreeNode<T>>();
		}

		/**
		 * @return the value of the node.
		 */
		public T getValue() {
			return this.value;
		}

		/**
		 * @param value - the value to be set. 
		 */
		public void setValue(T value) {
			this.value = value;
		}

		/**
		 * Adds child to the node.
		 * @param child - the child to be added
		 */
		public void addChild(TreeNode<T> child) {
			if (child == null) {
				throw new IllegalArgumentException("Cannot insert null value!");
			}

			if (child.hasParent) {
				throw new IllegalArgumentException("The node already has a parent!");
			}

			child.hasParent = true;
			this.children.add(child);
		}

		/**
		 * Gets the child of the node at given index.
		 * @param index - the index of the desired child.
		 * @return the child on the given position
		 */
		public TreeNode<T> getChild(int index) {
			return this.children.get(index);
		}

		/**
		 * @return the number of node's children.
		 */
		public int getChildrenCount() {
			return this.children.size();
		}
	}

	// The root of tree
	private TreeNode<T> root;
	
	// Put all nodes in ArrayList
	private ArrayList<Tree<T>> allNodes = new ArrayList<Tree<T>>();

	/**
	 * Construct the tree.
	 * @param value - the value of the node.
	 */
	public Tree(T value) {
		if (value == null) {
			throw new IllegalArgumentException("Cannot insert null value!");
		}

		this.root = new TreeNode<T>(value);
	}

	/**
	 * Construct the tree.
	 * @param value - the value of the node.
	 * @param children - the children of the root node
	 */
	public Tree(T value, Tree<T> ...children) {
		this(value);

		for (Tree<T> child : children) {
			this.root.addChild(child.root);
			this.allNodes.add(child);
		}
	}

	/**
	 * @return the root node or null if the tree is empty
	 */
	public TreeNode<T> getRoot() {
		return this.root;
	}

	/**
	 * @return the child nodes of the tree.
	 */
	public ArrayList<TreeNode<T>> getChildNodes() {
		if (this.root != null) {
			return this.root.children;
		}
		return new ArrayList<TreeNode<T>>();
	}

	/**
	 * Traverses and prints tree in Depth First Search (DFS) manner.
	 * @param root - the root of the tree to be traversed.
	 * @param spaces - the spaces used for representation of the parent-child relation.
	 */
	private void printDFS(TreeNode<T> root, String spaces) {
		if (this.root == null) {
			return;
		}

		System.out.println(spaces + root.getValue());

		TreeNode<T> child = null;
		for (int i = 0; i < root.getChildrenCount(); i++) {
			child = root.getChild(i);
			printDFS(child, spaces + "   ");
		}
	}

	/**
	 * Traverses and prints the tree in
	 * Depth First Search (DFS) manner.
	 */
	public void printDFS() {
		this.printDFS(this.root, new String());
	}

	public int getCountOfMatches(TreeNode<T> root, int matcher) {
		if (this.root == null) return 0;

		int matches = 0;

		getCountOfMatchesDFS(root, matcher, matches);

		return matches;
	}

	private void getCountOfMatchesDFS(TreeNode<T> root, int matcher, int matches) {
		TreeNode<T> child = null;
		for (int i = 0; i < root.getChildrenCount(); i++) {
			child = root.getChild(i);
			if (child.getValue() == (Integer) matcher) {
				++matches;
			}

			getCountOfMatchesDFS(child, matcher, matches);
		}
	}

	public int getAllSubTrees(TreeNode<T> root, int matcher) {
		ArrayList<Integer> counterSubTrees = new ArrayList<Integer>();
		getAllSubTreesDFS(root, matcher, counterSubTrees);
		return counterSubTrees.size();
	}

	private void getAllSubTreesDFS(TreeNode<T> root, int matcher, ArrayList<Integer> counterSubTrees) {
		if (root.getChildrenCount() == matcher) {
			counterSubTrees.add(1);
		}
		
		TreeNode<T> child = null;
		for (int i = 0; i < root.getChildrenCount(); i++) {
			child = root.getChild(i);
			getAllSubTreesDFS(child, matcher, counterSubTrees);
		}
	}
}
