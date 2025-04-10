package hw250408;

class Task3_Printer{
	private int numOfPapers = 0;
	private boolean duplex;
	
	public Task3_Printer(int numOfPapers, boolean duplex) {
		this.numOfPapers = numOfPapers;
		this.duplex = duplex;
	}
	
	public void print(int amount) {
		int needPaper = duplex ? amount / 2 + (amount % 2) : amount;
		
		if(this.numOfPapers == 0) {
			System.out.println("용지가 없습니다.");
		}
		else if(this.numOfPapers > needPaper) {
			System.out.print(duplex ? "양면으로 " : "단면으로 ");
			this.numOfPapers -= needPaper;
			System.out.println(needPaper + "장 출력했습니다. 현재 "+ this.numOfPapers +"장 남아 있습니다.");
		}
		else if(this.numOfPapers < needPaper) {
			System.out.print(duplex ? "양면으로 " : "단면으로 ");
			int moreNeedPapersCnt = needPaper - this.numOfPapers;
			System.out.println("모두 출력하려면 용지가 " + moreNeedPapersCnt + "매 부족합니다. " + this.numOfPapers + "장만 출력합니다.");
			this.numOfPapers = 0;
		}
	}
	
	public boolean getDuplex() {
		return duplex;
	}
	
	public void setDuplex(boolean duplex) {
		this.duplex = duplex;
	}
}

public class Task3_PrinterTest {

	public static void main(String[] args) {
		Task3_Printer p3  = new Task3_Printer(20, true);
		p3.print(25);
		p3.setDuplex(false);
		p3.print(10);
	}

}
