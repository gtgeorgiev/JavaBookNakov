package mydatastructures;

public class dfsUsingStack {
	public static void main(String[] args) {
//		System.out.println(tree.allNodes);
	}
	
	public  void dfsUsingStack(Node node) {
		Stack<Node> stack=new  Stack<Node>();
		stack.add(node);
		node.visited = true;
		while (!stack.isEmpty()) {
			Node element = stack.pop();
			System.out.print(element.data + " ");
 
			List<Node> neighbours = element.getNeighbours();
			for (int i = 0; i < neighbours.size(); i++) {
				Node n = neighbours.get(i);
				if (n != null && !n.visited) {
					stack.add(n);
					n.visited = true;
 
				}
			}
		}
	}
}
