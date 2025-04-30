package lec250430.circle;

public class Circle extends CircleType{
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return radius * radius * PI;
	}
}
