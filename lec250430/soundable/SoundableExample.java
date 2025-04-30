package lec250430.soundable;

public class SoundableExample {

	public static void main(String[] args) {
		printSound(new Cat());
		printSound(new Dog());
	}

	public static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
}
