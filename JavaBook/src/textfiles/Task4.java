package textfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created: 04.10.2018
 * 
 * @author Georgi Georgiev
 */
public class Task4 {

	public static void main(String[] args) {
		String fileName = "sample.txt";
		Scanner fileReader = null;
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			fileReader = new Scanner(new File(fileName));
			
			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				String word = "finish";
				String otherWord = "start";
				
				if (line.contains(word)) {
					line = line.replaceAll(word, otherWord);
				}
				list.add(line);
			}

		} catch (FileNotFoundException fnf) {
			System.out.println("File " + fileName + " not found.");
		} catch (NullPointerException npe) {
			System.out.println("File " + fileName + " not found.");
		} finally {
			if (fileReader != null) {
				fileReader.close();
			}
		}
		
		// DELETE FILE CONTENT
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(fileName);
			writer.print("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		
		// PUT NEW CONTENT IN FILE
		try {
			writer = new PrintWriter(fileName);
			for (String line: list) {
				writer.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
		
	}

}
