package edu.kh.oop.cls.model.vo;

class TestVo {

// 접근 제한자 (default) : 같은 패키지 내에서만 import가 가능함을 나타낸다
	
// Student와 같은 패키지
// -> public, protected, (default) 3개만 접근가능	
	public void ex() {
		System.out.println("같은 패키지");
		
		Student std = new Student(); // 학생 객체 생성
		System.out.println(std.v1); // public
		System.out.println(std.v2); // protected
		System.out.println(std.v3); // (default)
		//System.out.println(std.v4); // private
		// v4는 private 이기 때문에 같은 패기지라도 다른 클래스에서 직접 접근불가
	}
	
	
	
	
	
}
