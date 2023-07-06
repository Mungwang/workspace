package ed.kh.array.practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class PracticeService {
	
	
	public void ex1(){
		
		int[] arr = new int[9];
		
		for(int i=0; i<arr.length; i++) {
			arr[i]=i+1;
			System.out.print(arr[i]+" ");
			
		}System.out.println("");
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			if(i%2==0) { //arr[0]= 1
				sum+=arr[i];
			}
		}System.out.println("짝수번째 인덱스 합 : "+sum);
	}
	
	public void ex2() {
		
		 int [] arr = new int [9];
	      
	      for(int i =0; i < arr.length;i++) {
	         arr[i] = 9-i;
	         System.out.print(arr[i] + " ");
	         
	      } System.out.println();
	      
	      int sum =0;
	      for(int i=9;i>0;i--) {
	         if(i%2==0) {
	            sum+=i;
	         }
	      }
	      System.out.println("홀수 번째 인덱스 합 :"+sum);
	      // 8 6 4 2

		
		
	}	
	public void ex3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 : ");
		
		int input = sc.nextInt();
		int[] arr = new int[input];
		
		for(int i=1; i<=input; i++) {
			System.out.print(i+" ");
			
		}
	}
	
	public void ex4() {
		 
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		
		for(int i=0; i<arr.length; i++) {
			System.out.print("입력 "+i+" : "+" ");
			arr[i] = sc.nextInt();
		}
		
		System.out.print("검색할 값 : ");
			int input = sc.nextInt();
			
			boolean flag = false;
			
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==input) {
				System.out.println("인덱스 : "+i);
				
				flag=true;
			}
		}
		if(!flag) {
			System.out.println("일치하는 값이 존재하지않습니다");
		}
	}
	
	public void ex5() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String input = sc.next();
		// System.out.println(Arrays.toString(arr)); 중간확인
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		// String -> char로 바꿔준다
		
		char[] arr = new char[input.length()]; // 입력 받은 문자열 길이만큼의 배열생성
		
		int count=0; // input에 일치하는 ch가 몇개 있는지 카운트하는 변수
		System.out.print(input+"에 "+ch+"가 존재하는 위치(인덱스) : ");
		for(int i =0; i<arr.length; i++) {
			
			// 입력 받은 문자열에서 i번째 인덱스 문자를 arr[i]에 대입
			arr[i]=input.charAt(i);
			
			if(ch == arr[i]) {
				count++;
				System.out.print(i+ " ");
			}
		}
		System.out.println("\n"+ch+ " 개수 : "+count);
	
	}
	
	public void ex6() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();
		int sum =0;
		int[] arr = new int[input];
		
		for(int i=0; i<arr.length; i++) {
			System.out.print("배열 "+i+"번째 인덱스에 넣을 값 : ");
			 arr[i]=sc.nextInt();
		}
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			sum+=arr[i];
		}
		System.out.println("\n총합 : "+sum);
	
	}
	
	public void ex7() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String str =sc.nextLine();
		
		for(int i=0; i<14; i++) {
			if(i>7) {
				System.out.print("*");
			}else {
				System.out.print(str.charAt(i));
			}
			
		}
		
		
		
	}
	
	public void ex8() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("주민등록번호(-포함) : ");
		String input = sc.nextLine();
		
		char[] arr = new char[input.length()];
		
		for(int i=0; i<arr.length; i++) {
			
			if(i<=7) { // 7번 인덱스 이하(생년월일,-, 성별)
				arr[i] = input.charAt(i);
			}else { // 8번 인덱스 이상부터는 *
				arr[i] ='*';
			}
			
			System.out.print(arr[i]);
		}
		 // 선생님이 푸신거
	}
	
}
