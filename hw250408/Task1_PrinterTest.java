package hw250408;

class Task1_Printer{
	int numOfPapers = 0;
	
	public void print(int amount) {
		// 코드 추가
		
		if(this.numOfPapers >= amount) 	// 용지가 충분하면
			this.numOfPapers -= amount;
		else 							// 용지가 부족하면
			System.out.println("용지가 부족합니다."); 
		
	}
}

public class Task1_PrinterTest {

	public static void main(String[] args) {
		// Printer 클래스를 테스트하는 코드
		
		// 객체 생성
		Task1_Printer p1 = new Task1_Printer();
		// 용지 100장 추가
		p1.numOfPapers += 100;
		// 70장 출력
		p1.print(70);
		// 남은 용지 수 확인
		System.out.println("남은 용지 수: "+ p1.numOfPapers);
		
	}

}
