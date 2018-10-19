package stringmanipulations;

public class Task6 {

	/**
	 * @author Georgi Georgiev
	 */
	public static void main(String[] args) {
		String text = "C# is not C++ and PHP is not Delphi";
		String finalText = reveredText(text);
		System.out.println(finalText);
	}

	/**
	 * @param text - the input text
	 * @return the reversed text
	 */
	private static String reveredText(String text) {
		String[] temp = text.split(" and ");

		String firstWord  = temp[0].split(" is not ")[0];
		String secondWord = temp[0].split(" is not ")[1];
		String thirdWord  = temp[1].split(" is not ")[0];
		String fourthWord = temp[1].split(" is not ")[1];

		return fourthWord + " is not " + thirdWord + " and " + secondWord + " is not " + firstWord;
	}
}
