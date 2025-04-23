package hw250423;

public class Ex04_OvershadowTest {

	public static void main(String[] args) {
		Parent p = new Child();
		System.out.println(p.name);
		p.print();
	}

}

class Parent{
	String name = "영조";
	
	public void print() {
		System.out.println(name);
	}
}

class Child extends Parent{
	String name = "사도세자";
	
	public void print() {
		System.out.println("나는 "+ name+"이다.");
	}
}