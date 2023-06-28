package edu.kh.oop.abstraction.model.service;

import edu.kh.oop.abstraction.model.vo.People;

// Service : 특정 기능(비즈니스 로직)을 제공하는 클래스) 

public class AbstractionService {
	// 해당 클래스가 객체가 되면 아래 예제 기능을 수행할 수 있다.
	
	public void ex1() {
		
		// 국민 객체 만들기
		
		People p1 = new People();
		
		// People p1 : people 객체의 주소를 저장하여 참조하는 변수 p1
		// new People() : 새로운 People 객체를 Heap 영역에 생성
		
		// *** 클래스 이름이 자료형 처럼 사용되어짐!
		// == 그래서 클래스를 "사용자 정의 자료형" 이라고 한다! ***
		
		People p2 = new People();
		
		// 만들어진 객체는 추상화가 적용되어 있어 누군지 알 수 없음.
		// -> 속성(데이터)를 추가하여 누구인지 알 수 있게 함(구체화)
	
		//p1.name = "다나카"; // The field People.name is not visible
		// 직접 접근 방법
		
		p1.setName("다나카"); //setter를 이용한 간접 접근 방법
		
		//p1.age= 27;
		p1.setAge(27);
		//p1.gender = '남';
		p1.setGender('남');
		//p1.phone ="010-1234-1234";
		p1.setPhone("010-1234-1234");				
		//p1.pNo = "002022-123456789";
		p1.setpNo("000212-45689123");
		//p1.address = "서울시 강남구 어쩌고 저쩌고";
		p1.setAddress("서울시 강남구 어쩌고 저쩌고");
		
		System.out.println("p1d의 name : "+p1. getName());
		System.out.println("p1d의 age : "+p1.getAge());
		System.out.println("p1d의 gender : "+p1.getGender());
		System.out.println("p1d의 phone : "+p1.getPhone());
		System.out.println("p1d의 pNo : "+p1.getpNo());
		System.out.println("p1d의 address : "+p1.getAddress());
		
		System.out.println("=======================================");
		/*
		p2.name = "문광민";
		p2.age= 29;
		p2.gender = '남';
		p2.phone = "010-7654-3210";
		p2.pNo = "951208-1211424";
		p2.address = "서울시 중랑구";
		
		System.out.println("p2d의 name : "+p2.name);
		System.out.println("p2d의 age : "+p2.age);
		System.out.println("p2d의 gender : "+p2.gender);
		System.out.println("p2d의 phone : "+p2.phone);
		System.out.println("p2d의 pNo : "+p2.pNo);
		System.out.println("p2d의 address : "+p2.address);
		
		p1.tax();
		p1.vote();
		p2.tax();
		p2.vote();
		*/
	}
}
