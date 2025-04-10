package hw250408;

class GolfClub{
	private int num;
	private String name;
	
	
	public GolfClub() {
		num = 7;
	}
	
	public GolfClub(int number) {
		num = number;
		
	}
	
	public GolfClub(String name) {
		this.name = name;
	}
	
	public void print() {
		if(name != null) {
			System.out.println(name+"입니다.");
		}
		else {
			System.out.println(num+"번 아이언입니다.");
		}
	}
}

public class Ex07_GolfClubTest {

	public static void main(String[] args) {
		GolfClub g1 = new GolfClub();
		g1.print();

		GolfClub g2 = new GolfClub(8);
		g2.print();

		GolfClub g3 = new GolfClub("피터");
		g3.print();
	}

}
