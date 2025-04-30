package lec250430.circle;

public abstract class CircleType {
	public static final double PI = 3.14;
	protected double radius;
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	abstract double getArea();
}
