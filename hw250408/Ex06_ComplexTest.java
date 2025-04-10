package hw250408;

class Complex{
	private double num1;
	private double num2;
	
	public Complex(double n1) {
		num1 = n1;
		num2 = 0.0;
	}
	
	public Complex(double n1, double n2) {
		num1 = n1;
		num2 = n2;
	}
	
	public void print() {
		System.out.println(""+num1+" + "+num2+"i");
	}
	
}

public class Ex06_ComplexTest {

	public static void main(String[] args) {
		Complex c1 = new Complex(2.0);
		c1.print();
		Complex c2 = new Complex(1.5, 2.5);
		c2.print();
	}

}
