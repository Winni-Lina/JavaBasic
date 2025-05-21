package hw250521;

import java.util.ArrayList;
import java.util.List;

public class ex01 {
	public static void main(String[] args) {
		List<String> a = new ArrayList<String>();

		a.add("갈매기");
		a.add("나비");
		a.add("다람쥐");
		a.add("라마");
		
		for(int i = 0; i < a.size(); i++) {
			if(a.get(i).length() >= 3) {
				a.remove(i);
				i--;
			}
		}
		
		for (String string : a) {
			System.out.println(string);
		}
	}
}
