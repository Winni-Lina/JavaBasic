package hw250521;

import java.util.HashMap;
import java.util.Map;

public class task02 {
	public static void main(String[] args) {
		Map<String, String> dic = new HashMap<>();
		
		dic.put("head", "대가빠리");
		dic.put("teacher", "쌤");
		dic.put("cat", "꼬네이");
		dic.put("aunt", "아지매");
		dic.put("noodle", "국시");
		dic.put("child", "얼라");
		
		foreach(dic);
	}
	
	static void foreach(Map<String, String> dic) {
		for (String key : dic.keySet()) {
			System.out.printf("%s=%s ", key, dic.get(key));
		}
	}
}
