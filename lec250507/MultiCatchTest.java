package lec250507;

public class MultiCatchTest {
	public static void main(String[] args) {
		System.out.println("=== 프로그램 시작 ===");
		String[] array = {"100", "1OO"};

		for(int i = 0; i <= array.length; i++) {
			
			try {
				int value = Integer.parseInt(array[i]);
				System.out.println("array["+i+"]의 value = "+value);
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요.");
			} catch (Exception e) {
				System.out.println("모든 예외는 내가 처리한다");
			}
			
		}
		
		
		System.out.println("=== 프로그램 종료 ===");
	}
}
