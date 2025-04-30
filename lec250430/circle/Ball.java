package lec250430.circle;

public class Ball extends CircleType{
	public Ball(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return 4 * PI * radius * radius;
	}
}
