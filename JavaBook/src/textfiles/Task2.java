package textfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Georgi Georgiev
 */
public class Task2 {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		getNamesOfFile(names);
		sortNamesInNewFile(names);
	}

	/**
	 * @param names - the names in file
	 */
	private static void getNamesOfFile(ArrayList<String> names) {
		String oldFile = "unsortedNames.txt";
		Scanner fileReader = null;
		
		try {
			fileReader = new Scanner(new File(oldFile), "UTF-8");

			while (fileReader.hasNextLine()) {
				names.add(fileReader.nextLine());
			}

		} catch (FileNotFoundException fnf) {
			System.out.println("File " + oldFile + " not found.");
		} catch (NullPointerException npe) {
			System.out.println("File " + oldFile + " not found.");
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}
	}

	/**
	 * @param - names - the names in file
	 */
	private static void sortNamesInNewFile(ArrayList<String> names) {
		Collections.sort(names);

		PrintStream fileWriter = null;
		try {
			fileWriter = new PrintStream("sortedNames.txt");
		
			for (String name : names) {
				fileWriter.println(name);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fileWriter != null) {
				fileWriter.close();
			}
		}
	}
}
