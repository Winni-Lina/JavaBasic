package hw250408;

class Dice{
	
	public double roll() {
		return Math.random();
	}
}

public class Ex08_DiceTest {
	public static void main(String[] args) {
		Dice d = new Dice();
		System.out.println("주사위의 숫자 : " + d.roll());
	}
}
