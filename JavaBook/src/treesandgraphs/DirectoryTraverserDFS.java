package treesandgraphs;

import java.io.File;

/**
* Sample class, which traverses recursively given directory
* based on the Depth-First-Search (DFS) algorithm.
*
* @author Georgi Georgiev
*/
public class DirectoryTraverserDFS {
	private static void traverseDir(File dir, String spaces) {
		if (dir.isDirectory()) {
			System.out.println(spaces + dir.getAbsolutePath());
			String[] children = dir.list();
			
			for (String child : children) {
				traverseDir(new File(dir, child), spaces + "   ");
			}
		}
	}
	
	public static void traverseDir(String directoryPath) {
		traverseDir(new File(directoryPath), new String());
	}
	
	public static void main(String[] args) {
		traverseDir("C:\\");
	}
}
