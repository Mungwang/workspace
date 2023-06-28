package edu.kh.inheritance.practice.model.service;

import java.util.Scanner;

import edu.kh.inheritance.practice.model.vo.Employee;
import edu.kh.inheritance.practice.model.vo.Student;

public class PracticeService {
	
	private  Scanner sc = new Scanner(System.in);
	
	public void homework() {
		
		Student[] std = new Student[3];
		std[0] = new Student("카리나", 20, 168.2, 70.0, 1, "정보시스템공학과");
		std[1] = new Student("정해인", 21, 187.3, 80.0, 2, "경영학과");
		std[2] = new Student("박서준", 23, 179.2, 70.0, 4, "정보통신공학과");
		
		for(Student s : std) {
			System.out.println(s);
		}
		
		int empCount=0;
		
		Employee[] emp = new Employee[10];
		
		while(true) {
			
			System.out.print("이름 : ");
			String name = sc.nextLine();

			System.out.print("나이 : ");
			int age = sc.nextInt();

			System.out.print("신장 : ");
			double height = sc.nextDouble();

			System.out.print("몸무게 : ");
			double weight = sc.nextDouble();

			System.out.print("급여 : ");
			int salary = sc.nextInt();
			sc.nextLine();

			System.out.print("부서 : ");
			String dept = sc.nextLine();

			emp[empCount++] = new Employee(name, age, height, weight, salary,dept);
			
			char ch =' ';
			
			while (true) {
				if(empCount<10) {
					System.out.println("계속 추가 하시겠습니까? (y/n)");
					ch = sc.nextLine().toUpperCase().charAt(0);	
				}
				if(empCount==10 || ch=='N') {
					for(Employee e : emp) {
						if(e !=null) {
							System.out.println(e);
						}
					}return; // 현재 메소드를 종료하고 호출한곳으로 돌아감.
				}else if(ch=='Y') {
					break;
				}else {
					System.out.println("잘못입력했음 재입력하시오.");
				}
			}
		
		
		
		
		
		
	}
	}
}
