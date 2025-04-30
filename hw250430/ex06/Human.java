package hw250430.ex06;

public interface Human {
	static void echo() {
		System.out.println("야호!!!");
	}
	abstract void eat();
	
	default void print() {
		System.out.println("인간입니다.");
	}
}
