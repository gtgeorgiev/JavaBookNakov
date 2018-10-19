package textfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Georgi Georgiev 
 */
public class Exercise2 {

	public static void main(String[] args) {
		String fileName = "sample.txt";
		Scanner fileReader = null;
		int occurs = 0;
		String word = "Java";
		try {
			fileReader = new Scanner(new File(fileName));

			while (fileReader.hasNext()) {
				if (fileReader.nextLine().contains(word)) {
					occurs += 1;
				}
			}

			System.out.printf("%s --> %d", word, occurs);
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
