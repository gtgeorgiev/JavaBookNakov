package textfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exercise1 {

	/**
	 * @author Georgi Georgiev
	 */
	public static void main(String[] args) {
		String fileName = "sample.txt";
		Scanner fileReader = null;
		int lineNumber = 0;

		try {
			fileReader = new Scanner(new File(fileName));

			while (fileReader.hasNextLine()) {
				lineNumber++;
				System.out.printf("Line %d: %s%n", lineNumber, fileReader.nextLine());
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
