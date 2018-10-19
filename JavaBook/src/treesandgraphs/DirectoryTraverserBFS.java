package treesandgraphs;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
* Sample class, which traverses given directory
* based on the Breath-First-Search (BFS) algorithm.
* @author Svetlin Nakov
*/
public class DirectoryTraverserBFS {
	/**
	* Traverses and prints given directory with BFS.
	* @param startDir - the path to the directory which
	* should be traversed.
	*/
	public static void traverseDir(String startDirectory) {
		Queue<File> visitedDirQueue = new LinkedList<File>();
		visitedDirQueue.add(new File(startDirectory));
		while (visitedDirQueue.size() > 0) {
			File currentDir = visitedDirQueue.remove();
			System.out.println(currentDir.getAbsolutePath());
			File[] children = currentDir.listFiles();
			if (children != null) {
				for (File child : children) {
					if (child.isDirectory()) {
						visitedDirQueue.add(child);
					}
				}
			}
		}
	}
}
