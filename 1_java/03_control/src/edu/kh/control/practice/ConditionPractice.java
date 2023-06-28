package edu.kh.control.practice;

import java.util.Scanner;

public class ConditionPractice {

	public void practice1(){
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num>=0 && num%2==0) {
			System.out.println("짝수입니다");
		}else {
			if(num%2==1) {
				System.out.println("홀수입니다");
			}else {
				System.out.println("양수만 입력해주세요");
			}
		}
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		
		int sum = kor+math+eng; 
		int average = (kor+math+eng)/3;
		
		if(kor>=40 && math>=40 && eng>=40 && average>=60) {
			/*System.out.println("국어 : "+ kor);
			System.out.println("수학 : "+ math);
			System.out.println("영어 : "+ eng);
			System.out.println("합계 : "+ sum);
			System.out.println("평균 : "+ average);
			System.out.println("축하합니다, 합격입니다!");  ★★★★*/  
			
			System.out.printf("국어 : %d\n수학 : %d\n영어 : %d\n합계 : %d\n평군 : %d\n",kor,math,eng,sum,average);
			System.out.println("축하합니다, 합격입니다!");
		}else {
			System.out.println("불합격입니다");
		}
		
	}

	public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1~12 사이의 정수 입력 : ");
		
		int month =sc.nextInt();
		
		String day;
		
		switch(month) {
			
		case 1: case 3: case 5: case 7: case 8: case 10: case 12 : day="31일까지 있습니다"; break;
		case 2: day="28일까지 있습니다."; break; 
		case 4: case 6: case 9: case 11: day="30일까지 있습니다"; break;
		
		default : day = "잘못 입력된 달입니다.";
		}
		
		System.out.println(month+"월은"+day);	
	}
		/*public void practice3() {
      
      	Scanner sc = new Scanner(System.in);
      
      	System.out.print("1~12 사이의 정수 입력 : ");
      	int month = sc.nextInt();
      
      	int date = 0;
      
      	switch(month) {
      
      	case 2: date = 28; break;
      	case 1: case 3: case 5: case 7: case 8: case 10: case 12: date = 31; break;
      	case 4: case 6: case 9: case 11:  date = 30; break;
      	default : System.out.println(month + "월은 잘못 입력된 달입니다.");
      	}
      
      	if(1<=month && month<=12) {
         System.out.println(month + "월은 " + date + "일까지 있습니다.");      
      	}
      
   	}
		 */
	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(m)를 입력해 주세요 : ");
		double height = sc.nextDouble();
		
		System.out.print("몸무게(kg)를 입력해 주세요 : ");
		double weight = sc.nextDouble();
		
		String result;
		
		double bmi = (weight/(height*height));
		
		
		/*if(bmi<18.5) {
			result = "저체중";
		}else {
			if(bmi<23) {
				result = "정상체중";
			}else if(bmi<25) {
				result = "과체중";
			}else if(bmi<30) {
				result = "비만";
			}else {
				result = "고도비만";
			} 쓰레기코드
		}*/
		
		if(bmi<18.5) {
			result = "저체중";
		}else if(bmi<23) {
			result = "정상체중";
		}else if(bmi<25) {
			result = "과체중";
		}else if(bmi<30) {
			result = "비만";
		}else {
			result = "고도비만";
		}
		
		
		System.out.println("BMI 지수 : "+ bmi);
		System.out.println(result);
		
	}
	
	public void practice5() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 :" );
		double midTerm = sc.nextDouble();
		
		System.out.print("기말 고사 점수 :" );
		double finalTerm = sc.nextDouble();
		
		System.out.print("과제 점수 :" );
		double homework = sc.nextDouble();
		
		System.out.print("출석 횟수 :" );
		double attendance = sc.nextDouble();
		
		System.out.println("=============결과=============");
		
		// △ attendance 출석횟수를 받으니까 결석횟수를 표현하려면 새로운 변수를 적어어햠
		
		if(attendance <= 20*(1 - 0.3)) { //30%이상 결석 <-> 70%미만 출석했을때랑 같은말
			System.out.println("Fail [ 출석횟수 부족 ("+ (int)attendance + "/20) ]" );

		} else {
			
			midTerm *= 0.2; //  midTrem = midTrem*0.2; 같다 
			finalTerm *= 0.3;
			homework *= 0.3;
			attendance *=5*0.2; // 출석은 20%센트라 100%센트를 맞춰주려고 5를 곱한다 근데 상관없긴함
			
			//합계
			double sum = midTerm + finalTerm + homework + attendance;
			
			System.out.printf("중간고사 점수(20)  : %.1f\n", midTerm);
			System.out.printf("기말고사 점수(30) : %.1f\n", finalTerm);
			System.out.printf("과제점수(30) : %.1f\n", homework);
			System.out.printf("출석 점수(20) : %.1f\n", attendance);
			System.out.printf("총점 : %.1f\n", sum);
			
			if(sum >=70) {
				System.out.println("PASS");	
				
			} else {
				System.out.println("Fail [ 점수미달 ]");
			}
		}
		
		
		
		
	}
	
	
	
	
	
	

}
