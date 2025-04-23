package hw250423;

public class Task03_GirlTest {
	public static void main(String[] args) {
		Girl3[] girls = {new Girl3("갑순이"), new GoodGirl3("콩쥐"), new BestGirl3("황진이")};
		
		for(Girl3 g : girls) {
			g.show();
		}
	}
}

class Girl3{
	protected String name;
	
	public Girl3(String name) {
		this.name = name;
	}
	
	public void show() {
		System.out.println(name+"는 자바 초보자이다.");
	};
}

class GoodGirl3 extends Girl3{
	public GoodGirl3(String name) {
		super(name);
	}

	public void show() {
		System.out.println(name+"는 자바를 잘 안다.");
	}
}

class BestGirl3 extends GoodGirl3{
	public BestGirl3(String name) {
		super(name);
	}

	@Override
	public void show() {
		System.out.println(name+"는 자바를 무지하게 잘 안다.");
	}
}