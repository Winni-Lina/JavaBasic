package app;

import java.util.Scanner;

public class MyAppReader {

	Scanner sc = new Scanner(System.in);
	
	public String readString(String message) {
		System.out.print(message);
		return sc.nextLine().strip();
	}
	
	public int readInt(String message) {
		System.out.print(message);
		return Integer.parseInt(sc.nextLine());
	}
}
