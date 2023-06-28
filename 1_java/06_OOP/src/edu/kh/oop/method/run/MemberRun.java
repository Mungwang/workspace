package edu.kh.oop.method.run;

import edu.kh.oop.method.model.service.MemberService;

public class MemberRun {

	public    static void main(String[] args) {
// [접근제한자]  [예약어] 반환형 메소드명([매개변수] []< 없을수도있다)
		
		MemberService service = new MemberService();
		// MemberService의 기본생성자가 작성되어 있지 않지만 문제없이 사용가능
		
		// 왜?? 컴파일러가 코드를 번역할때 클래스 내부에 생성자가 하나도없다면 자동으로 기본생성자를 추가해줌
		// (주의) 생성자가 하나라도 있으면 자동생성을 안해준다
		// (The constructor MemberService() is undefined)
	
		service.displayMenu();
	}
	
	

}
