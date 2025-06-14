package hw250423;

public class Ex01_Circle {
	public static void main(String[] args) {
		Circle c1 = new Circle(5);
		ColoredCircle c2 = new ColoredCircle(10, "빨간색");
		
		c1.show();
		c2.show();
		
	}
}

class Circle {
	int radius;
	
	public Circle(int radius) {
		this.radius = radius;
	}
	
	public void show() {
		System.out.println("반지름이 " + radius +"인 원이다.");
	}
}

class ColoredCircle extends Circle {
	String color;
	
	public ColoredCircle(int radius, String color) {
		super(radius);
		this.color = color;
	}
	
	public void show() {
		System.out.println("반지름이 " + radius +"인 "+color+" 원이다.");
	}
	
}