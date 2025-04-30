package lec250430.countable;

public class Bird implements Countable{
	private String name;
	private int num;

	public Bird(String name, int num) {
		this.name = name;
		this.num = num;
	}
	
	public void fly() {
		System.out.println(num+"마리 " + name+"가 날아간다.");
	}
	
	@Override
	public void count() {
		System.out.println(name+"가 "+num+"마리 있다.");
	}
}
