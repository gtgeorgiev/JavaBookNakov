package stringmanipulations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Georgi Georgiv
 */
public class Task3 {

	public static void main(String[] args) {
		String text = "We are living in a <upcase>yellow submarine</upcase>. We don't have <upcase>anything</upcase> else.";
		String openingTag = "<upcase>";
		String closingTag = "</upcase>";
		String finalText = upperCaseTextBetweenTags(text, openingTag, closingTag);
		System.out.println(finalText);
	}

	/**
	 * @param text - the text which will be used
	 * @param openingTag - the opening tag
	 * @param closingTag - the closing tag
	 * @return the all text with upper case words
	 */
	private static String upperCaseTextBetweenTags(String text, String openingTag, String closingTag) {
		String finalText = text;
		Pattern pattern = Pattern.compile(openingTag + "(.+?)" + closingTag);
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			finalText = finalText.replaceAll(matcher.group().toString(), matcher.group().toString().toUpperCase());
		}

		finalText = finalText.replaceAll(openingTag.toUpperCase(), "");
		finalText = finalText.replaceAll(closingTag.toUpperCase(), "");

		return finalText;
	}
}
