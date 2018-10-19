package stringmanipulations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class find how many times some string is contained in other string
 * @author Georgi Georgiev
 */
public class Task2 {

	public static void main(String[] args) {
		String text = "We are living in a yellow submarine. We don't have anything else. Inside the submarine is very tight. So we are drinking all the day. We will move out of it in 5 days.";
		String word = "in";
		int occurs = searchingWordInString(text, word);
		System.out.println("Occurs --> " + occurs);
	}

	/**
	 * @param text - the text which user wants to search in
	 * @param word - the searching word
	 * @return the count of all word occurs in text
	 */
	private static int searchingWordInString(String text, String word) {
		int occurs = 0;
		String patternString = "(" + word + ")";
//		String patternString = "\\b(" + word + ")\\b"; ' separate words
//		String patternString = "\\b(" + StringUtils.join(tokens, "|") + ")\\b"; ' "tokens" is ArrayList
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(text.toLowerCase());
		while (matcher.find()) {
			occurs += 1;
		}
		
		return occurs;
	}
}
