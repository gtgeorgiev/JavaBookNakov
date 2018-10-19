package stringmanipulations;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Georgi Georgiev
 */
public class Task4 {

	public static void main(String[] args) {
		String text = "Microsoft announced its next generation Java compiler today. It uses advanced parser and special optimizer for the Microsoft JVM.";
		String forbiddenWords = "Java,JVM,Microsoft";
		String finalText = replaceForbiddenWordsWithStars(text, forbiddenWords);
		System.out.println(finalText);
	}

	/**
	 * @param text - the text which be changed
	 * @param forbiddenWords - the words which be replaced with stars
	 * @return formated text
	 */
	private static String replaceForbiddenWordsWithStars(String text, String forbiddenWords) {
		String finalText = text;
		String[] forbiddenWordsArr = forbiddenWords.split(",");
		for (String entry : forbiddenWordsArr) {
			finalText = finalText.replaceAll("(" + entry + ")", StringUtils.repeat("*", entry.length()));
		}
		
		return finalText;
	}
}
