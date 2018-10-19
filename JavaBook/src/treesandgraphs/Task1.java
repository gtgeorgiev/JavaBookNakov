package treesandgraphs;

/**
 * @author Georgi Georgiev
 */
public class Task1 {

	public static void main(String[] args) {
		Node<Integer> parent = new Node<Integer>(100);
		Node<Integer> childNode1 = new Node<Integer>(50, parent);
		Node<Integer> childNode2 = new Node<Integer>(25);
		childNode2.setParent(parent);
	}

}
