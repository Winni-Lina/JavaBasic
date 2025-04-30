package hw250430.ex05;

class TV extends Controller{

	public TV(boolean power) {
		super(power);
	}

	@Override
	String getName() {
		return "TV";
	}
	
}
