package textfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created: 05.10.2018
 * 
 * @author Georgi Georgiev
 */
public class Task5 {

	public static void main(String[] args) {
		String fileName = "sample.txt";
		ArrayList<String> allWords = getAllWordsFromFile(fileName);
		HashMap<String, Integer> wordsMap = countWordsInArrList(allWords);
		Set<Entry<String, Integer>> set = wordsMap.entrySet();
		Iterator<Entry<String, Integer>> iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, Integer> mapEntry = (Map.Entry<String, Integer>)iterator.next();
			System.out.println(mapEntry.getKey() + " - " + mapEntry.getValue());
		}
	}

	/**
	 * @param fileName - the name of file
	 * @return the array with all words in file
	 */
	private static ArrayList<String> getAllWordsFromFile(String fileName) {
		ArrayList<String> arrList = new ArrayList<String>();
		Scanner fileReader = null;

		try {
			fileReader = new Scanner(new File(fileName));

			while (fileReader.hasNextLine()) {
				String line = fileReader.nextLine();
				String[] arr = line.replaceAll("^[.,\\s]+", "").split("[.,\\s]+"); // only words, without symbols
				for (String entry : arr) {
					arrList.add(entry.toLowerCase());
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

		return arrList;
	}

	/**
	 * @param arrList - the array list with all words
	 * @return the map of all word with there count
	 */
	private static HashMap<String, Integer> countWordsInArrList(ArrayList<String> arrList) {
		HashMap<String, Integer> finalMap = new HashMap<String, Integer>();

		for (String entry: arrList) {
		    if (finalMap.containsKey(entry)) {
		    	int count = finalMap.get(entry);
		    	finalMap.put(entry, ++count);
		    } else {
		    	finalMap.put(entry, 1);
		    }
		}

		return finalMap;
	}
}
