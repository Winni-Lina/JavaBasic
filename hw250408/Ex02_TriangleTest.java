package hw250408;

class Ex02_Triangle {
	private double width;
	private double height;
	
	public Ex02_Triangle(double w, double h) {
		this.width = w;
		this.height = h;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double findArea() {
		return width * height / 2;
	}
	
	public boolean isSameArea(Ex02_Triangle t) {
		return findArea() == t.findArea();
	}
}

public class Ex02_TriangleTest {
	public static void main(String[] args) {
		Ex02_Triangle t1 = new Ex02_Triangle(10.0, 5.0);
		Ex02_Triangle t2 = new Ex02_Triangle(5.0, 10.0);
		Ex02_Triangle t3 = new Ex02_Triangle(8.0, 8.0);
		System.out.println(t1.isSameArea(t2));
		System.out.println(t1.isSameArea(t3));
	}
}
