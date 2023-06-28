	package edu.kh.control.practice;

import java.util.Scanner;

public class LoopPractice {
	
	public void practice1() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1이상의 숫자를 입력하세요 : ");
		
		int num = sc.nextInt();
		
		if(num>=1) {
			
			for(int i=1; i<=num; i++) {
				System.out.print(i+" ");
			}
			
		}else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
		
	}
	
	public void practice2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("1이상의 숫자를 입력하세요 : ");
		
		int num = sc.nextInt();
		
		if(num>=1) {
			
			for(int i=num; i>=1; i--) {
				System.out.print(i+" ");
			}
			
		}else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}
			
	}
	
	/*public void practice3() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 하나 입력하세요 : ");
		
		int num = sc.nextInt();
		int sum = 0; 
		
		for(int i=1; i<=num; i++) {
			System.out.print(i+" "+"+"+" ");
			
			sum +=i;			
		}
		System.out.print("= "+sum+" 입니다.");
	}*/
	 public  void practice3(){
	        
		 	Scanner sc = new Scanner(System.in);
	        System.out.print("정수를 하나 입력하세요 : ");
	        int num = sc.nextInt();
	        int sum = 0;
	        					
	        					
	        for(int i=1; i<=num; i++){
	            sum += i;
	            System.out.print(i);
	            System.out.print(i ==num ? " = " : " + ");
	        }
	        	System.out.println(sum);
	    }

	
	public void practice4() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int num1 = sc.nextInt();
		
		System.out.print("두 번째 숫자 : ");
		int num2 = sc.nextInt();
		
		if(num1>=1 && num2>=1) {
						
			for(int i=num1; i<=num2; i++) {
				System.out.print(i+" ");
			}
			for(int i=num2; i<=num1; i++) {	
				System.out.print(i+" ");
			}
		}else {
			System.out.println("1 이상의 숫자를 입력해주세요.");
		}	
	}
	
	/*public void practice41() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
	      int num1 = sc.nextInt();
	         
	      System.out.print("두 번째 숫자 : ");
	      int num2 = sc.nextInt();
	         
	      if(num1 < 1 || num2 < 1) {
	         System.out.println("1 이상의 숫자를 입력해주세요.");
	        
	      } else if(num1 < num2) {
	         for(int i = num1; i<= num2; i++ ) {
	            System.out.print(i + " ");
	         }
	      }else {
	         for(int i = num2; i<= num1; i++ ) {
	            System.out.print(i + " ");
	         }
	      }
		// 선생님
	}
	public void priactice42() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print(" 첫 번째 숫자 : ");
        int input1 = sc.nextInt();
        
        System.out.print(" 두 번째 숫자 : ");
        int input2 = sc.nextInt();
        
        int num1;
        int num2;
        
        if (input1 < 1 || input2 < 1)
           System.out.println("1 이상의 숫자를 입력해주세요.");
        else {
           if (input1 < input2) {
              num1 = input1;
              num2 = input2;
           } else {
              num1 = input2;
              num2 = input1;
           }
           
           for (int i = num1; i <= num2; i++)
              System.out.println(i + " ");
        }
        
        // 다른분꺼
        
     }*/
	
	// 04.24일
	
	public void practice9() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		for(int x = 1; x<=input; x++) {
			
			// 1) for문 하나 더 작성
			// * 1개 출력전에 띄어쓰기 3번
			// * 2개 출력전에 띄어쓰기 2번
			// * 3개 출력전에 띄어쓰기 1번
			// * 4개 출력전에 띄어쓰기 0번
			
			// y == 3 2 1 0
			
			/* ★★1번째 방법★★
			for(int y = input -x; y>=1; y--) {
				System.out.print(" ");
			}
			
			
			for(int i =1; i<= x; i++) {
				System.out.print("*");
				
			}
			System.out.println();//줄바꿈.
			*/
			
			// 2) for + if else
			
			for (int i =1; i <=input; i++) {
				
				if(i <= input -x ) {
					System.out.print(" ");
				}else {
					System.out.print("*");
					
				}
			}System.out.println(); //줄바꿈
		}
			
	}
	
	
	public void practice10() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		int input = sc.nextInt();
		
		// 위쪽 삼각형
		for(int x =1; x <= input; x++) {
			
			for(int i = 1; i <= x; i++) {
				System.out.print("*");
				
			}System.out.println(); // 줄바꿈
		}
		
		// 아랫쪽 삼각형
		
		for(int y = input -1; y>=1; y-- ) {
			
			for(int i=1; i <= y; i++) {
				System.out.print("*");
				
			}System.out.println(); // 줄바꿈
			
		}
	
	}
	
	public void practice11() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력 : ");
		int input = sc.nextInt();
		
		for(int x = 1; x<= input; x++) { // 입력 받은 input 만큼 줄 출력
			
			// 공백 출력 for문
			
			for(int i = input-x; i>=1; i--) {
				System.out.print("  ");
			}
			
			// * 출력 for문
			// 1, 3, 5, 7, 9
			for(int i =1; i <=2*x-1; i++) { // i<=2*x-1 < 홀수구하는공식
				System.out.print("*");
			
			}System.out.println();// 줄바꿈
		}
			
	}
	
	public void practice12() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력 : ");
		int input = sc.nextInt();
		
		// row : 행(줄)
		// col(column) : 열(칸)
		
		for(int row=1; row <= input; row++) {
			
			for(int col=1; col <= input; col++) {
				// row 또는 col이 1 또는 input인 경우 * 출력 == 테두리 출력
				
				if(row ==1 || row == input || col ==1 || col ==input ) {
					System.out.print("*");
				}else { //내부
					System.out.print("  ");
				}
			}
			System.out.println(); // 줄바꿈
		}
		
	}
		
	public void practice13() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("자연수 하나를 입력하세요 : ");
		
		int num = sc.nextInt();
		int count =0;
		
		/*for(int i=two*2; i<=num; i++) {
			System.out.print(i+" ");
		}System.out.println(" ");
		for(int i=three*3; i<=num; i++) {
			System.out.print(i+" ");
		}*/
		
		for(int i=1; i<=num; i++) {
			
			if(i%2==0 || i%3==0) { 
				System.out.println(i+ " "); // 2또는3의 배수일경우	
			}
			if(i%2==0 && i%3==0) {
				count++; //2와 3의 공배수일경우
			}
			
		}System.out.println("\ncount : "+count);
	}
	
}
