package hw250521;

import java.util.ArrayList;
import java.util.List;

public class task01 {
	public static void main(String[] args) {
		List<String> capitals = new ArrayList<String>();
		capitals.add("서울");
		capitals.add("워싱턴");
		capitals.add("베이징");
		capitals.add("파리");
		capitals.add("마드리드");
		
		printList(capitals);
		
		capitals.add("런던");
		
		printList(capitals);
		
		for(int i = 0; i < capitals.size(); i++) {
			if(capitals.get(i).length() >= 3) {
				capitals.remove(i);
				i--;
			}
		}
		
		printList(capitals);
		
	}
	
	static void printList(List<String> ls) {
		for (String s : ls) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
}
