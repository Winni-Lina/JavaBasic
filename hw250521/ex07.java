package hw250521;

import java.util.Collections;
import java.util.HashSet;

public class ex07 {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		String[] s1 = {"a","b","a","b","c"};
		String[] s2 = {"c"};
		
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        Collections.addAll(set1, s1);
        Collections.addAll(set2, s2);

        System.out.println("set1: " + set1);
        System.out.println("set2: " + set2);
        
        System.out.println("set1과 set2는 같다 : " + set1.equals(set2));
        System.out.println("set1은 set2의  모든 원소를 포함한다 : " + set1.containsAll(set2));
        
        HashSet h1 = new HashSet<>(set1);
        h1.addAll(set2);
        
        HashSet h2 = new HashSet<>(set1);
        h2.retainAll(set2);
        
        System.out.println("합집합 : " + h1);
        System.out.println("교집합 : " + h2);
	}
}
