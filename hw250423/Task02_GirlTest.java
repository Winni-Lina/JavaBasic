package hw250423;

public class Task02_GirlTest {
	public static void main(String[] args) {
		Girl2 g1 = new Girl2(null);
		Girl2 g2 = new GoodGirl2(null);
		GoodGirl2 gg = new BestGirl2(null);
		
		g2.show();
		gg.show();
	}
}

class Girl2{
	private String name;
	
	public Girl2(String name) {
		this.name = name;
	}
	
	public void show() {
		System.out.println("그녀는 자바 초보자이다.");
	};
}

class GoodGirl2 extends Girl2{
	public GoodGirl2(String name) {
		super(name);
	}

	public void show() {
		System.out.println("그녀는 자바를 잘 안다.");
	}
}

class BestGirl2 extends GoodGirl2{
	public BestGirl2(String name) {
		super(name);
	}

	@Override
	public void show() {
		System.out.println("그녀는 자바를 무지하게 잘 안다.");
	}
}