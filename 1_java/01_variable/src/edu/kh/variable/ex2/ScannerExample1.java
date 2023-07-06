package edu.kh.variable.ex2;

// ★★★ import : 다른 패키지에 존재하는 클래스를 얻어오는 구문
import java.util.Scanner;

public class ScannerExample1 {
	
	public static void main (String[] args) {
		
		// Scanner : 프로그램 실행 중 키보드 입력을 받을 수 있게하는 역할

		// Scanner 생성
		// -> 프로그램 안에 스캐너라는 기계를 만드는 것
		
		Scanner sc = new Scanner(System.in);
		
		//System.in 은 사용자로부터 입력을 받기 위한 입력 스트림이다.
		//그렇기 때문에 Scanner 뿐만 아니라 다른 입력 방식들도 사용자로부터 입력을 받기 위해서는 System.in 이 들어간다.
		
		// 오류 원인 -> 만들고 싶은데 설계도(class)가 없어서 못만들고있음
		// -> improt 구문 작성이 오류 해결!
	
	
		System.out.print("정수 1 입력 : ");
	
		int input1 = sc.nextInt(); // 입력 받은 정수를 input1에 대입
		// nextInt() : 다음 입력된 정수를 읽어옴 (키보드로 입력된 정수를 읽어온다
		
		System.out.print("정수 2 입력 : ");
		
		int input2 = sc.nextInt();
		
		System.out.printf("%d + %d = %d", input1,input2,input1 + input2); // 입력값 색깔 안바뀜.
		// 입력받은 값을 이용하여 결과값을 출력한다 (응용)
		// 사용자가 응용 어플리케이션(프로그램)
		
		
	}
}
