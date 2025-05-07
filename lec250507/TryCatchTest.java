package lec250507;

public class TryCatchTest {
	public static void main(String[] args) {
		System.out.println("=== 프로그램 시작 ===");
		arithmeticException();
		System.out.println("=== 프로그램 종료 ===");
		
	}
	
	public static void arithmeticException() throws ArithmeticException {
		int a = 10, b = 0;
		try {
			int c = a / b;	
		} catch (ArithmeticException e) {
			System.out.println(e.toString());
		}
	}
}
