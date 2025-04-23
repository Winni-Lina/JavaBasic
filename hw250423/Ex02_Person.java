package hw250423;

public class Ex02_Person {

	public static void main(String[] args) {
		Person p = new Person("길동이", 22);
		Student s = new Student("황진이", 23, 100);
		ForeignStudent f = new ForeignStudent("Amy", 30, 200, "U.S.A");
		
		p.show();
		s.show();
		f.show();
	}

}


class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void show() {
		System.out.println("사람[ 이름 : "+name+", 나이 : "+age+" ]");
	}
}

class Student extends Person {
	private int studentNo;
	
	public Student(String name, int age, int studentNo) {
		super(name, age);
		this.studentNo = studentNo;
	}

	public int getStudentNo() {
		return studentNo;
	}

	@Override
	public void show() {
		System.out.println("학생[ 이름 : "+super.getName()+", 나이 : "+super.getAge()+", 학번 : "+studentNo+" ]");
	}
	
	
}

class ForeignStudent extends Student{
	private String country;
	
	public ForeignStudent(String name, int age, int studentNo, String country) {
		super(name, age, studentNo);
		this.country = country;
	}

	public String getCountry() {
		return country;
	}
	
	@Override
	public void show() {
		System.out.println("외국학생[ 이름 : "+super.getName()+", 나이 : "+super.getAge()+", 학번 : "+super.getStudentNo()+", 국적 : "+country+" ]");
	}
	
}