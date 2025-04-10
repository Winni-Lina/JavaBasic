package hw250408;

class Ex01_Triangle {
	private double width;
	private double height;
	
	public Ex01_Triangle(double w, double h) {
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
}

public class Ex01_TriangleTest {
	public static void main(String[] args) {
		Ex01_Triangle t = new Ex01_Triangle(10.0, 5.0);
		System.out.println(t.findArea());
	}
}
