package hw250423;

public class Ex03_Point {

	public static void main(String[] args) {
		System.out.println(new Point(5, 10).toString());
		System.out.println(new MovablePoint(3, 9, 20, 30).toString());
	}

}

class Point{
	private int x;
	private int y;
	
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	@Override
	public String toString() {
		return "[x=" + x + ", y=" + y + "]";
	} 
	
}

class MovablePoint extends Point{
	private int xSpeed, ySpeed;
	

	public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
		super(x, y);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	@Override
	public String toString() {
		return "[x=" + getX() + ", y=" + getY()+", xSpeed=" + xSpeed + ", ySpeed=" + ySpeed + "]";
	}
	
	
}