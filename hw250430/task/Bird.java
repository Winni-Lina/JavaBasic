package hw250430.task;

public class Bird extends Countable{
	
	public Bird(String name, int num) {
		super(name, num);
	}

	public void fly() {
		System.out.println(num+"마리 " + name+"가 날아간다.");
	}
	
	@Override
	public void count() {
		System.out.println(name+"가 "+num+"마리 있다.");
	}
}
