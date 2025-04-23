package hw250423;

public class Ex05_Phone {

	public static void main(String[] args) {
		Phone[] phones= { new Phone("황진이"), new Telephone("길동이", "내일"), new Smartphone("민국이", "갤러그") };
		
		phones[0].talk();
		((Telephone) phones[1]).autoAnswering();
		((Smartphone) phones[2]).playGame();
	}

}

class Phone{
	protected String owner;
	
	public Phone(String owner) {
		this.owner = owner;
	}
	
	public void talk() {
		System.out.println(owner+"가 통화 중이다.");
	}
}

class Telephone extends Phone{
	private String when;
	
	public Telephone(String owner, String when) {
		super(owner);
		this.when = when;
	}
	
	public void autoAnswering() {
		System.out.println(owner+"가 없다. " + when + " 전화 줄래.");
	}
	
}

class Smartphone extends Phone{
	private String game;
	
	public Smartphone(String owner, String game) {
		super(owner);
		this.game = game;
	}
	
	public void playGame() {
		System.out.println(owner + "가 "+game+" 게임을 하는 중이다.");
	}
}