package edu.kh.inheritance.model.service;

import java.util.Scanner;

import edu.kh.inheritance.model.vo.Employee;
import edu.kh.inheritance.model.vo.Person;
import edu.kh.inheritance.model.vo.Student;

public class InheritanceService {

	public void ex1() {
		// 상속 확인
		// - Person을 상속 받은 Student가 Person의 필드,메소드를 사용할수있는가?

		Person p = new Person();

		// p.name = "홍길동"; private 때문에 직접 접근 불가

		p.setAge(25);
		p.setName("홍길동");
		p.setNationallity("대한민국");

		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getNationallity());

		System.out.println("-----------------------------------------------");

		// Student 객체 생성

		Student std = new Student();

		// Student만의 고유한메서드
		std.setGrade(3);
		std.setClassRoom(5);

		// Person 클래스로 부터 상속받음 메소드
		std.setName("고아라");
		std.setAge(19);
		std.setNationallity("대한민국");

		System.out.println(std.getGrade());
		System.out.println(std.getClassRoom());

		// Student가 Person의 메소드뿐만 아니라 필드 상속 받았는지 확인
		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationallity());

		System.out.println("----------------------------------------------");

		Employee emp = new Employee();

		// Employee만의 고유 메소드
		emp.setCompany("KH정보교육원");

		// Person 클래스로 부터 상속 받은 메소드
		emp.setName("다나카");
		emp.setAge(35);
		emp.setNationallity("일본");

		System.out.println(emp.getCompany());

		System.out.println(emp.getName());
		System.out.println(emp.getAge());
		System.out.println(emp.getNationallity());

		System.out.println("----------------------------------------------");

		// 추가된 breath()메소드 확인하기
		p.breath();
		std.breath();
		emp.breath();

	}

	public void ex2() {

		// super() 생성자 사용 방법

		// Student 매개변수 5개 짜리 생성자
		Student std = new Student("문광민", 29, "대한민국", 1, 3);

		System.out.println(std.getName());
		System.out.println(std.getAge());
		System.out.println(std.getNationallity());
		System.out.println(std.getGrade());
		System.out.println(std.getClassRoom());
	}

	public void ex3() {
		// 오버라이딩 확인 예제

		Student std = new Student();
		Employee emp = new Employee();

		std.move(); // 오버라이딩 x -> Person의 메소드 수행

		emp.move(); // 오버라이딩 o -> Employee 메소드 수행

	}

	public void ex4() {

		// 모든 클래스는 Object 클래스의 후손
		// == 모든 클래스의 최상의 부모는 Object

		// 1) Object 상속 여부 확인

		Person p = new Person(); // Object를 상속 받은 Person 객체 생성

		Student std = new Student(); // Person을 상속 받은 Student 객체 생성
		// Object ->상속 Person ->상속 Student
		Scanner sc = new Scanner(System.in);

		String str = "abc";

		// ** Object 상속과 단계적인 상속 확인

		System.out.println(p.hashCode()); // Object에서 물려 받은 hashCode()

		System.out.println(std.getAge()); // Person에서 물려받은 getAge()

		System.out.println(std.hashCode());
		// Person이 Object에서 물려받은 hashCode()를 Student가 또 물려받아 사용
		// -> 상속의 상속의 상속의 .... 상속가능

		// * Object가 모든 클래스의 최상위 부모인지 확인
		System.out.println(sc.hashCode()); // Object - hashCode()

		System.out.println(str.hashCode());
		// String - hashCode()
		// -> String이 Object에게 물려 받은 hashCode()를 오버라이딩
	}

	public void ex5() {

		Person p = new Person("윈터", 28, "한국");

		System.out.println(p.toString());
		System.out.println(p);

		// print 구문 수행시 참조 변수명을 작성하면 자동으로 toString() 메소드를 호출해서 출력한다

		System.out.println("---------------------------------------------");

		Student std = new Student("윈터", 27, "미국", 2, 6);

		System.out.println(std.toString());
		// 1) Student 클래스 toString() 오버라이딩 전
		// Person으로 부터 상속 받은 오버라이딩된 toString() 수행

		// 2) Student 클래스 toString 오버라이딩 후
		// Student의 toString()수행

		Employee emp = new Employee("김근로", 26, "한국", "증권");
		System.out.println(emp);
	}

}
