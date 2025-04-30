package lec250430.circle;

public class OverridingTest {
	public static void main(String []args) {
		CircleType ct;
		
		ct = new Circle(5.0);
		System.out.println(">>> 원 : ");
		System.out.println("반지름 : "+ ct.getRadius());
		System.out.println("면접적 : "+ ct.getArea());

		ct = new Ball(5.0);
		System.out.println(">>> 공 : ");
		System.out.println("반지름 : "+ ct.getRadius());
		System.out.println("면적 : "+ ct.getArea());

		ct = new Cylinder(5.0, 7.0);
		System.out.println(">>> 원기둥 : ");
		System.out.println("높이 : "+ ((Cylinder)ct).getHeight());
		System.out.println("면적 : "+ ct.getArea());
	}
}
