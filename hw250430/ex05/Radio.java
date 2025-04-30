package hw250430.ex05;

public class Radio extends Controller{

	public Radio(boolean power) {
		super(power);
	}

	@Override
	String getName() {
		return "라디오";
	}

}
