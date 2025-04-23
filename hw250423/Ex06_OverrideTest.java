package hw250423;

public class Ex06_OverrideTest {

	public static void main(String[] args) {
		Car c = new Car("파랑", 200, 1000, 5);
		c.show();
		
		System.out.println();
		Vehicle v = c;
		v.show();
	}

}

class Vehicle{
	String color;
	int speed;
	
	public Vehicle(String color, int speed) {
		this.color = color;
		this.speed = speed;
	}

	public void show() {
		System.out.println("[color=" + color + ", speed=" + speed + "]");
	}
}

class Car extends Vehicle{
	int displacement;
	int gears;
	
	public Car(String color, int speed, int displacement, int gears) {
		super(color, speed);
		this.displacement = displacement;
		this.gears = gears;
	}
	
	public void show() {
		System.out.println("[color=" + color + ", speed=" + speed + ", displacement=" + displacement + ", gears=" + gears + "]");
	}
}