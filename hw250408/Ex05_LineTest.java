package hw250408;

class Line{
	private int line;
	
	public Line(int line) {
		this.line = line;
	}
	
	public int getLine() {
		return line;
	}
	
	public boolean isSameLine(Line l) {
		return getLine() == l.getLine();
	}
}

public class Ex05_LineTest {
	public static void main(String[] args) {
		Line a = new Line(1);
		Line b = new Line(1);
		
		System.out.println(a.isSameLine(b));
		System.out.println(a == b);
	}
}
