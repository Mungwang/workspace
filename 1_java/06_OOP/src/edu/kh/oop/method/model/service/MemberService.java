package edu.kh.oop.method.model.service;

import java.util.Scanner;

import edu.kh.oop.method.model.vo.Member;

public class MemberService { // 클래스
	
	// 속성(필드)
	private Scanner sc = new Scanner(System.in);
	// System.in : 자바에서 기본적으로 지정해둔 입력 장치(키보드) 
	
	private Member memberInfo = null; // 가입한 회원의 정보를 저장할 변수
	private Member loginMember = null; // 로그인한 화원의 정보를 저장할 변수
	
	// 기능 (생성자, 메소드)
	public MemberService(){} //기본생성자
	
	// ** 메소드 작성법 **
		
	// [접근 제한자] 		[예약어]			 반환형			메소드명([매개변수]) {}
	//	public			static		    기본자료형
	//	protected		final		    참조형(배열,클래스)
	// 	(default)		abstract	   	void(반환값이없다)
	// 	private 		static final
	
	
	// ** 반환형 void **
	// - 반환(return)이란? 메소드 수행 후 호출부로 돌아가는 것
	// - 반환 값 : 돌아가면서 가져갈 결과 값
	// - 반환 형 : 반화 값의 자료형
	// -> void : 돌려보낼 값(반환 값)이 없다.
	
	public void displayMenu() { // 메뉴 화면 출력 기능
		
		int menuNum = 0;
		do { // 한번은 무조건반복
			System.out.println("==== 회원 정보 관리 프로그램 v1 ====");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 회원 정보 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("0. 프로그램 종료");
			
			System.out.print("메뉴 입력 >> ");
			menuNum = sc.nextInt(); // 필드에 작성된 Scanner sc 사용
			sc.nextLine(); // 입력 버퍼에 남은 개행 문자제거
			
			switch(menuNum) {
			case 1 : System.out.println( signUp()); break;
				// 같은 클래스 내부에 있는 필드,메소드는 이름만 불러도 호출 가능!
				// signUp() 메소드를 호출하여 수행 후 반환 받읍 값을 출력
			
			case 2 : System.out.println( login());break;
			case 3 : System.out.println(selectMember());break;
			case 4 : 
			
				int result = updateMember(); // 회원 정보 수정메소드 수행 후
											 // 반환되는 결과를 result 변수에 저장
				if(result ==-1) {
					System.out.println("로그인 후 이용해주세요.");
				} else if( result==0) {
					System.out.println("회원 정보 수정 실패(비밀번호 불일치)");
				} else { // result==1
					System.out.println("회원 정보가 수정되었습니다");
				}
				
			case 0 : System.out.println("프로그램을 종료합니다...."); break;
			
			default : System.err.println("잘못입력하셨습니다. 다시입력하시오");
			}
			
		}while(menuNum!=0);
			
		}
		
		// 회원 가입 기능
		public String signUp() { //This method must return a result of type String
			// (반환형)
			// 해당 메소스가 끝나고 호출한 곳으로 돌아갈 때
			// void : 반환할 값이 없다
			// String : String 자료형 값을 가지고 돌아간다.
			
			System.out.println("\n******회원 가입 기능******");
			
			System.out.print("아이디 : ");
			String memberId = sc.next();
			
			System.out.print("비밀번호 : ");
			String memberPw = sc.next();
	
			System.out.print("비밀번호 확인 : ");
			String memberPw2 = sc.next();
			
			System.out.print("이름 : ");
			String memberName = sc.next();
			
			System.out.print("나이 : ");
			int memberAge = sc.nextInt();
			
			// 비밀번호, 비밀번호 확인이 일치하며 회원가입 / 일치하지않으면 회원가입 실패
			
			if(memberPw.equals(memberPw2)) { // 일치하는경우 (문자열비교는 이퀄스)
				
				// 입력 받은 정보를 이용해서 Member 객체를 생성한 후
				// 생성된 객체의 주소를 필드에 있는 memberInfo에 대입
				memberInfo = new Member(memberId,memberPw,memberName,memberAge);
				return("회원 가입 성공!!");
			
			}else { // 일치하지 않는경우
				return("회원 가입 실패!! (비밀번호 불일치)");
				
			}
		}
		
		// 로그인 메소드(기능)
		public String login() {
			
			System.out.println("\n***** 로그인 *****");
			
			// 회원 가입을 했는지 부터 확인!
			// == memberInfo가 객체를 참조하고 있는지 확인
			
			if(memberInfo == null) { //회원 가입을 먼저 안한 경우
				// null : 아무것도 참조하고 있지않음
				
				return "회원 가입부터 진행 해주세요.";
			}
			
			System.out.print("아이디 입력 : ");
			String memberId = sc.nextLine();
			
			System.out.print("비밀번호 입력 : ");
			String memberPw= sc.nextLine();
			
			// 회원 가입 정보 (memberInfo가 참조하는 Member 객체)에서 
			// 저장된 아이디,비밀번호가 입력된 아이디, 비밀번호와 같으면 "로그인"성공
			// 아니면 "아이디가 또는 비밀번호가 일치하지 않습니다."
			
			if(memberInfo.getMemberId().equals(memberId) &&
			   memberInfo.getMemberPw().equals(memberPw)) {
		// 입력 받은 memberId와 memberInfo 필드에서 참조중인 Member객체의 memberId가 같은지확인 
			
				loginMember = memberInfo;
				// 	참조형   = Member객체 주소 (얕은복사)
				// 회원 가입정보를 loginMember에 대입하여 어떤회원이 로그인했는지 구분할 수있게함
				
				return loginMember.getMemberName() + "님 환영합니다.";
			} else {
				return "아이디 또는 비밀번호가 일치하지 않습니다";
				
			}
		}
		
		public String selectMember() {
			
			System.out.println("***** 회원 정보 조회*****");
			
			// 1) 로그인 여부 확인 -> 필드 loginMember가 참조하는 객체가 있는지 확인
			
			if(loginMember==null) {// loginMember가 참조하는 객체가 없을경우(null)
								   // memberInfo를 쓰면 로그인안해도 정보조회가 가능함.
				return "로그인 후 이용 해주새요.";
				// ★★return 구문이 수행되면 해당 메소드는 즉시 종료되고 호출한곳으로 돌아감★★
			}
			
			// 2) 로그인이 되어있는 경우
			//	  회원 정보를 출력한 문자열을 만들어서 반환(return)
			//	  (단,비밀번호는 제외)
			
			// 이름 : 유저일
			// 아이디: user01
			// 나이 : 25
			
			String str = "이름 : "+loginMember.getMemberName();
			// String 		edu.kh.oop.method.model.vo.Member.getMemberName()
			// 반환형								메소드 코드 위치
			
			str += "\n아이디 : "+ loginMember.getMemberId();
			str += "\n나이 : "+ loginMember.getMemberAge();
		
			return str;
		}
		
		// 회원 정보 수정(update) 기능
		
		public int updateMember() {
			
			System.out.println("\n***** 회원 정보 수정*****");
			
			// 1) 로그인 여부 판별
			// 	  로그인이 되어있지 않으면 -1 반환
			
			if(loginMember==null) {
				return -1;
			}
			
			
			// 2) 수정할 회원 정보 입력 받기(이름,나이)
			System.out.print("수정할 이름 입력 : ");
			String inputName = sc.next();
			
			System.out.print("수정할 나이 입력 : ");
			int inputAge = sc.nextInt();
			
			sc.nextLine();// 그냥 next같은거 써줄때 써주면됌 
			
			// 3) 비밀번호를 입력받아서 로그인한 회원의 비밀번호와 일치한지 확인
			System.out.print("비밀번호 입력 : ");
			String inputPw = sc.nextLine();
			
			if(inputPw.equals(loginMember.getMemberPw() ) ) {
				// 4) 비밀번호가 같은경우 - 로그인한 회원의이름,나이정보를 입력받은 값으로 변경후 1반환
				
				loginMember.setMemberName(inputName);
				// 입력 받은 inputName을 loginMember가 참조하는 Member객체의 필드 memberName에 대입
				loginMember.setMemberAge(inputAge);
				
				return 1;
				//set으로 값을 변경해준다
			}else {
				// 5) 비빌번호가 다를 경우 0 반환
				return 0;
				
				
			}
			
			
		}
		
		
		
		
		
}
