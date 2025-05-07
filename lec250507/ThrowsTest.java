package lec250507;

public class ThrowsTest {
	public static void main(String[] args) throws ClassNotFoundException {
//		try {
			method1();	
//		} catch (ClassNotFoundException e) {
//			System.out.println(e.toString());
//		}
		System.out.println("=== 프로그램 종료 ===");
	}
	
	static void method1() {
		try {
			method2();	
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}
	
	static void method2() throws ClassNotFoundException{
		Class.forName("java.lang.String2");
	}
}
