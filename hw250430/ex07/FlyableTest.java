package hw250430.ex07;

interface Flyable {
	void speed();
	void height();
}


public class FlyableTest implements Flyable{
	public static void main(String[] args) {
		Flyable f = new FlyableTest();
		
		f.speed();
		f.height();
	}

	@Override
	public void speed() {
		System.out.println("속도");
	}

	@Override
	public void height() {
		System.out.println("높이");
	}
}