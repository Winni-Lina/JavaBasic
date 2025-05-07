package lec250507;

public class ExceptionTest {
	public static void main(String[] args){
		ExceptionTest et = new ExceptionTest();
		
		try {
			et.arithmeticException();	
		} catch (ArithmeticException e) {
			System.out.println(e.toString());
		}
		et.indexException();
		et.nullPointerException();
		et.numberFormatException();
	}

	public void arithmeticException() throws ArithmeticException {
//		try {
			int a = 10, b = 0;
			int c = a / b;	
//		} catch (ArithmeticException e) {
//			System.out.println(e.toString());
//		}
	}
	
	public void indexException() {
		try {
			int[] array = {0,1,2,};
			System.out.println(array[3]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.toString());
		}
		
	}
	
	public void nullPointerException() {
		try {
			String str = null;
			str.charAt(1);
		} catch (NullPointerException e) {
			System.out.println(e.toString());
		}
	}
	
	public void numberFormatException() {
		try {
			String str = "123AA";
			int num = Integer.parseInt(str);
		}catch(NumberFormatException e) {
			System.out.println(e.toString());
		}
	}
}
