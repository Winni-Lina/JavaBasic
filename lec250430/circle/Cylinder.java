package lec250430.circle;

public class Cylinder extends CircleType{
	
	private double height;
	
	public Cylinder(double radius, double height) {
		this.radius = radius;
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		return 2 * PI * radius * (radius + height);
	}
}
