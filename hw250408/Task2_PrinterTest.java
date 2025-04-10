package hw250408;

class Task2_Printer{
	private int numOfPapers = 0;
	
	public Task2_Printer(int numOfPapers) {
		this.numOfPapers = numOfPapers;
	}
	
	public void print(int amount) {
		
		if(this.numOfPapers == 0) {
			System.out.println("용지가 없습니다.");
		}
		else if(this.numOfPapers > amount) {
			this.numOfPapers -= amount;
			System.out.println(amount + "장 출력했습니다. 현재 "+ this.numOfPapers +"장 남아 있습니다.");
		}
		else if(this.numOfPapers < amount) {
			int needPapersCnt = amount - this.numOfPapers;
			System.out.println("모두 출력하려면 용지가 " + needPapersCnt + "매 부족합니다. " + this.numOfPapers + "장만 출력합니다.");
			this.numOfPapers = 0;
		}
	}
}

public class Task2_PrinterTest {

	public static void main(String[] args) {
		Task2_Printer p2  = new Task2_Printer(10);
		p2.print(2);
		p2.print(20);
		p2.print(10);
	}

}
