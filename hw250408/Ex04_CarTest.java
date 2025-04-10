package hw250408;

class Car {
	private String color;
	static int numOfCar = 0;
	static int numOfRedCar = 0;
	
	public Car(String color) {
		this.color = color;
		
		numOfCar++;
		redCarCounter(color);
	}
	
	private void redCarCounter(String color) {
		if(color.toLowerCase().equals("red")) {
			numOfRedCar++;
		}
	}
	
	public String getColor() {
		return color;
	}
	
	public static int getNumOfCar() {
		return numOfCar;
	}
	
	public static int getNumOfRedCar() {
		return numOfRedCar;
	}
}

public class Ex04_CarTest {
	public static void main(String[] args) {
		Car c1 = new Car("red");
		Car c2 = new Car("blue");
		Car c3 = new Car("RED");
		
		System.out.printf("자동차 수 : %d, 빨간색 자동차 수 : %d", Car.getNumOfCar(), Car.getNumOfRedCar());
	}
}
