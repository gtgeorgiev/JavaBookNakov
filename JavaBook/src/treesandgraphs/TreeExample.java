package treesandgraphs;

public class TreeExample {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>(7,
				new Tree<Integer>(24, new Tree<Integer>(14), new Tree<Integer>(32), new Tree<Integer>(31)),
				new Tree<Integer>(21), 
				new Tree<Integer>(2, new Tree<Integer>(22), new Tree<Integer>(2)));
		
		System.out.println(tree.getAllSubTrees(tree.getRoot(), 3));
	}
}
