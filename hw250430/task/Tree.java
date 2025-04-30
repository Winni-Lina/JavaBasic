package hw250430.task;

public class Tree extends Countable{
	
	public Tree(String name, int num) {
		super(name, num);
	}

	public void ripen() {
		System.out.println(num+"그루 "+name+"나무에 열매가 잘 익었다.");
	}
	
	@Override
	public void count() {
		System.out.println(name+"가 "+num+"그루 있다.");
	}
}
