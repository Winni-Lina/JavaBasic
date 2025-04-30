package hw250430.ex06;

public class HemanTest {

	public static void main(String[] args) {
		Human.echo();
		
		Student s = new Student(20);
		s.print();
		s.eat();
		
		Human p = new Worker();
		p.print();
		p.eat();

	}

}
