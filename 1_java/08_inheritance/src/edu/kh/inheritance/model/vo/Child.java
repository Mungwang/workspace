package edu.kh.inheritance.model.vo;

public class Child extends Parent{ // 자식 ㅡ클래스
	
	// Parent 상속 중...
	// The type Child cannot subclass 
	// the final class Parent
	// (final 클래스인 Parent는
	// Child 클래스를 자식으로 가질 수없다.
	
	@Override
	public void method() {
		System.out.println("오버라이딩성공");
	// Cannot override 
	// the final method from Parent	
		
	}
}
