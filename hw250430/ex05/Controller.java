package hw250430.ex05;

public abstract class Controller {
	boolean power;
	
	public Controller(boolean power){
		this.power = power;
	}
	
	void show() {
		System.out.println(this.getName()+ "이가 " + (power ? "켜":"꺼")+"졌습니다.");
	};
	
	abstract String getName();
}
