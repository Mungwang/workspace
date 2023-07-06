package edu.kh.oop.cls.model.vo;

public class User {

	// 속성 (== 필드)
	
	// 아이디,비밀번호,이름,나이,성별 (추상화 진행)
	private String userId;
	private String userPw;
	private String userName;
	private int userAge;
	private char userGender;
	
	// 기능(==생성자 + 메소드)
	
	// 생성자 : new 연산자를 토애서 객체가 생성될 때
	//  	  생성된 객체의 필드 값 초기화 + 기능 수행역할
	
	// 기본생성자
	public User() {
		// 기능
		System.out.println("기본 생성자로 User 객체 생성");
		
		// 필드 초기화
		userId = "user01";  // 필드초기화를 하지않았으면 null
		userPw = "pass01";  //  JVM 기본값이들어가있음 null
		userName = "홍길동";  //                   null
		userAge = 20;   	//                    0
		userGender = '남';	//                  \u0000\
	}
	
	// 매개변수 생정자
	// ** 사용되는 기술, 변수 : 매개변수, overloading(오버로딩), this
	
	// ** 매개변수 : 생성자나 메소스 호출 시 ()안에 작성되어 전달되어지는 값을 저장하는 변수
	// -> 전달 받은 값을 저장하고있는 매개체(지니고있는) 역할의 변수
	
	public User (String userId, String userPw) {
				// 매개변수
		
		System.out.println("매개변수 생성자를 이용해서 user 객체 생성");
		System.out.println(userId+"/"+userPw);
		
		// 전달 받은 값을 필드에 초기화(this 참조변수)
		
		// *** this 참조 변수 ***
		// - 객체가 자신 자신을 참조할 수 있도록 하는 변수
		// - ★★모든 객체 내부에 숨겨져 있다.
		// ?? 왜 사용하는가
		// -> 필드명과 매개변수명이 같은 경우 이를 구분하기 위해서 주로 사용.
		
		this.userId = userId;
		//필드 = 매개변수
		this.userPw = userPw;

	}
	
	// 필드를 전부 초기화 하는 목적의 매개변수 생성자
	public User( String userId,String userPw,String userName, 
			     int userAge, char userGender) {
		
		// 매개변수로 전달 받은 값으로 필드 초기화
		//this.userId = userId; // 현재 객체가 가지고있는 필드 userId에 매개변수 userId값을 대입
		//this.userPw = userPw;
		
		this(userId,userPw); 
		// 위에 2개짜리매개변수값을 불러줌 - this()생성자
		// - 생성자 내에서 ★★반드시 첫번째 줄★★ 작성되어야 한다.
		
		// 왜 사용하는가? 중복 코드제거, 코드 길이감소,재사용성 증가
		// (가독성이 어려운 경우가 생길 수있어서 많이 사용되진 않음) 
		
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
	}
	
	// 자바는 기본적으로 필드명,생정자며으,메소드명,변수명의 중복을 허용하지않음.
	/*
	private String userId; // Duplicate field User.userId
	public User() {} // Duplicate method User() in type User 
	public String getUserId() {} // Duplicate method getUserId() in type User
	public void ex() {
		int num = 10;
		int num = 10; // Duplicate local variable num
	}
	*/
	
	// *** 오버로딩(Over Loading) *** ☆☆☆☆외워야함☆☆☆☆
	// - 클래스 내에 동일한 이름의 메소드(생성자도 포함)을 여러 개 작성하는 기법
	// --> 하나의 이름으로 여러 기능을 수행할 수 있게 하는것
	
	// [오버로딩 조건]
	// 1. 메소드(생성자 포함)의 이름이 동일해야한다
	// 2. 매개변수의 개수,타입,순서 중 1개라도 달라야 함
	
	// public User() {} // 기본생성자가 이미 작성되어 있어서 중복
	
	public User(String userId) {} // 매개변수 개수가 같은 생저가 없음 -> 오버로딩 성립
	
	public User(int userAge) {} // 매개변수 개수는 같지만 타입이 다르다 -> 오버로딩 성립
	
	public User(int userAge, String userId) {} // ↑ 같은이유
	public User(String userId, int userAge) {} // 매개변수의 개수,타입은 같지만 순서가다름
											   // -> 오버로딩 성립
	
	public User(String userId,String userPw,String userName) {}
	//public User(String userName, String userId, String userPw) {} // 에러
	// 매개변수의 개수,타입,순서가 모두 같아서 오버로딩 불가 -> 변수명은 신경x
	
	
	// 캡슐화로 인한 간접 접근 기능 (getter / setter)
	
	public String getUserId() { // userID의 getter 
		return userId;
	}
	public void setUserId(String userId) { // userID의 setter
		this.userId = userId;
	}
	
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	public char getUserGender() {
		return userGender;
	}
	public void setUserGender(char userGender) {
		this.userGender = userGender;
	}
	
	
}
