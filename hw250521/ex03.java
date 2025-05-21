package hw250521;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ex03 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("김열공", 80);
		map.put("최고봉", 90);
		map.put("우등생", 95);
		map.put("나자바", 88);

		
		System.out.print("이름을 입력하세요 : ");
		System.out.println(map.get(scan.next()));
		
		scan.close();
	}
}
