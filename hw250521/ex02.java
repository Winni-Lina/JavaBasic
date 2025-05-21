package hw250521;

import java.util.HashSet;
import java.util.Set;

public class ex02 {
	public static void main(String[] args) {
		Set<Person> set = new HashSet<>();
		set.add(new Person("김열공", 20));
		set.add(new Person("최고봉", 56));
		set.add(new Person("우등생", 16));
		set.add(new Person("나자바", 35));
		
		set.forEach(x->System.out.println(x.name+" : "+x.age));
		foreach(set);
		
	}

	static void foreach(Set<Person> set) {
		for (Object p : set) {
			System.out.print(p.toString() + " ");
		}
	}
}

class Person{
	String name;
	int age;
	
	public Person(String n, int a) {
		this.name = n;
		this.age = a;
	}

	@Override
	public String toString() {
		return "Person[" + name + ", " + age + "]";
	}
	
}