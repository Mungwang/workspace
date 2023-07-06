package edu.kh.control.practice;

import java.util.Scanner;

public class OpPractice {
	
		public void practice1() {
		Scanner sc = new Scanner(System.in);
				System.out.print("인원 수 : ");
				int person = sc.nextInt();
		
				System.out.print("사탕 개수 : ");
				int candy =sc.nextInt();
		
				System.out.println();
		
				System.out.println("1인당 사탕개수 : "+ candy/person);
				System.out.println("남은 사탕개수 : "+ candy%person);
				System.out.println("======================");
		}

		 public void practice2() {
		    
		    Scanner sc = new Scanner(System.in);
		    
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("학년(정수) : ");
		int grade = sc.nextInt();
		
		System.out.print("반(정수) : ");
		int classRoom = sc.nextInt();
		
		System.out.print("번호(정수) : ");
		int number = sc.nextInt();
		
		System.out.print("성별(남학생/여학생) : ");
		String gender = sc.next();
		
		System.out.print("성적(소수점 아래 둘째자리까지) : ");
		double score = sc.nextDouble();
		
		System.out.printf("%d학년 %d반 %d번 %s %s의 성적은 %.2f점입니다",grade,classRoom,number,name,gender,score);
		 }
		 
		 public void practice3() {
			 
			 Scanner sc = new Scanner(System.in);
			 
			 System.out.print("정수 입력 : ");
			 
			 int num = sc.nextInt();
			
			 String  num1 = "짝수 입니다";
			 String  num2 = "홀수 입니다";
			 
			 String result = num % 2==0? num1:num2;
			 
			 System.out.println(result);
			 
			 /*
      
		      Scanner sc = new Scanner(System.in);
		      
		      System.out.print("정수 입력 : ");
		      int input = sc.nextInt();
		      
		      String result = input % 2 == 0 ? "짝수" : "홀수";
		      
		      System.out.println(result + " 입니다.");
		      
		   	  }           //////////////////////선생님 답
			  */
		 }
		 
		 public void practice4() {
			 
			 Scanner sc = new Scanner(System.in);
			 
			 System.out.print("국어 : ");
			 int kor = sc.nextInt();
			 
			 System.out.print("영어 : ");
			 int eng = sc.nextInt();
			 
			 System.out.print("수학 : ");
			 int math = sc.nextInt();
			 System.out.println();
			 
			 int sum = kor+eng+math;
			 double avg = sum/3.0;
			 
			 System.out.println("합계 : "+sum);
			 System.out.println("평균 : "+avg);
			 
			 if(kor>=40 && eng>=40 && math>=40 && avg>=60) {
				 System.out.print("합격"); 
			 } else {
				 System.out.println("불합격");
			 }		 
			 
		 }
		 
		 public void practice5() {
				 
			 Scanner sc = new Scanner(System.in);
				 
			 System.out.print("국어 : ");
		
			 int kor = sc.nextInt();
			 
			 System.out.print("영어 : ");
			 int eng = sc.nextInt();
			 
			 System.out.print("수학 : ");
			 int math = sc.nextInt();
			 System.out.println();
			 
			 int sum = kor+eng+math;
			 double avg = sum/3.0;
			 
			 System.out.println("합계 : "+sum);
			 System.out.printf("평균 : %.1f\n" ,avg);
			 
			 boolean result = (kor >= 40) && (eng >= 40) && (math >= 40) && (avg >= 60);
		      
		     System.out.print(   result ?"합격" : "불합격" );
		      						//    조건식 ?  식1  : 식2

		 }//////////////선생님답  복습
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
}
