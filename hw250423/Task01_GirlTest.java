package hw250423;

public class Task01_GirlTest {
	public static void main(String[] args) {
		Girl1 g1 = new Girl1();
		Girl1 g2 = new GoodGirl1();
		GoodGirl1 gg = new BestGirl1();
		
		// g2.show();
		gg.show();
	}
}

class Girl1{
	String name;
}

class GoodGirl1 extends Girl1{
	public void show() {
		System.out.println("그녀는 자바를 잘 안다.");
	}
}

class BestGirl1 extends GoodGirl1{
	@Override
	public void show() {
		System.out.println("그녀는 자바를 무지하게 잘 안다.");
	}
}