package stringmanipulations;

import java.net.MalformedURLException;
import java.net.URL;

public class Task5 {
	/**
	 * @author Georgi Georgiev
	 */
	public static void main(String[] args) {
		URL aURL;
		try {
			aURL = new URL("http://www.devbg.org/forum/index.php");
			
			System.out.println("protocol = " + aURL.getProtocol());
			System.out.println("host = " + aURL.getHost());
			System.out.println("filename = " + aURL.getFile());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
