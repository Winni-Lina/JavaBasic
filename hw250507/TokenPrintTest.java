package hw250507;

import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class TokenPrintTest {

	public static void main(String[] args) {
		String s= "of the people, by the people, for the people";
		try {
			showTokens(s, ", ");
		} catch (NoSuchElementException e) {
			System.out.println("끝");
		}
	
	}

	private static void showTokens(String str1, String str2) {
		StringTokenizer st = new StringTokenizer(str1, str2);
		while (true) {
			System.out.println(st.nextToken());
		}
		
	}

}
