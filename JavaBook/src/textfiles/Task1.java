package textfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Georgi Georgiev
 */
public class Task1 {

	public static void main(String[] args) {
		String fileName = "sample.txt";
		Scanner fileReader = null;
		int lineNumber = 0;

		try {
			fileReader = new Scanner(new File(fileName));

			while (fileReader.hasNextLine()) {
				lineNumber++;
				String line = fileReader.nextLine();

				if (lineNumber % 2 == 1) {
					System.out.println(line);
				}
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
	}

}
