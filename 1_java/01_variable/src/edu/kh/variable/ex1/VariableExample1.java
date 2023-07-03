package edu.kh.variable.ex1;

public class VariableExample1 {
	// 생선된 .java 파일과 class의 오른쪽에 작성된 이름은 같아야 한다.
	
	public static void main(String[] args) {
		
		/* 변수(Variable)
		   * - 메모리*(RAM)에 값을 기록하는공간
		   	   * -> 공간에 기록되는값(Date)이 변할수있어서 변수라고한다.
		   	   * - 변수는 여러 종류 존재 (지정되는 값을 형태 ,크기가다름) 
		   	   * 변수 사용의 장점
		   	   * 1. 가독성 증가(읽기 편해짐)
		   	   * 2. 재사용성 증가(한번 만든 변수를 계속사용)
		   	   * 3. 코드 길이의 감소
		   	   * 4. 유지보수성 증가 (코드 수정이 간단해짐)ㅇ
		       */
		System.out.println(2 * 3.141592653589793 * 10);
		System.out.println(3.141592653589793 * 10 *10);
		System.out.println(3.141592653589793 * 10 *10 *20 );
		System.out.println(4 * 3.141592653589793 * 10 * 10) ;
	
		//변수사용
		
		double pi = 3.141592653589723; // 원주율
		int r = 10; // 반지름(radius)
		int h = 20; // 높이(height)
		
		System.out.println("--------------");
		System.out.println( 2* pi * r); // 원의 둘레
		System.out.println( pi * r* r); // 원의 넓이
		System.out.println( pi * r* r *h); // 원기둥의 부피
		System.out.println(	4* pi * r* r ); // 구의 겉넓이
		
		
	}

}
