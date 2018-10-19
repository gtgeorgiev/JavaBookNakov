package stringmanipulations;

/**
 * @author Georgi Georgiv
 */
public class Task1 {

	public static void main(String[] args) {
		String text = "готово";
		String reversedText = reverseText(text);
		System.out.println(reversedText);
	}

	/**
	 * @param text - input text which be reversed
	 */
	private static String reverseText(String text) {
		StringBuilder sb = new StringBuilder();
		for(int i = text.length() - 1; i >= 0; i--) {
			char c = text.charAt(i);
			sb.append(c);
		}
		return sb.toString();
	}
	
}
