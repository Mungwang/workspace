package edu.kh.variable.ex2;

import java.util.Scanner;

public class ScannerExample4 {
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 1 : ");				// println 안쓰는이유 자동줄바꿈되기떄문
		String input = sc.next() + " "; // 띄어쓰기 추가 
						//안녕 친구들
		
		System.out.println(input);
		
		System.out.print("입력 2 : ");
		input = input + sc.next() + " "; 
				// 안녕_반가워_
		
		// 대입 연산자(=) : 위에 input값을 추가하고 대입한다
		
		System.out.println(input);
		
		System.out.print("입력 3 : ");
		input = input + sc.next()+ " ";
		
		System.out.println(input);	//위로부터 차례대로 대입된다
		
		// 누적 효과 ( 변수의 재사용성 ) 
	}
}
