package edu.kh.array2.practice;

import java.util.Arrays;
import java.util.Scanner;

public class Array2Practice {

	// 작성된 코드가 틀린 이유와 출력값이 왜 저렇게 나오는지 이유
	// 해결 방법
	
	public void homeWork() {
	      int[][] arr = new int[4][4];
	      int rowsum = arr.length-1; // 3
	      int colsum = arr[0].length -1; //3
	      
	      for(int row=0; row<arr.length; row++) { // row =0,1,2,3
	         for(int col=0; col<arr[row].length; col++) { //col=0,1,2,3
	        	 
	            arr[row][col] = (int)(Math.random()*10+1); 
	            //3,3열이 되면 지금까지 누적한값이 날라가고 3,3에 새로운난수값이 들어감
	      
	            arr[rowsum][col] += arr[row][col];
	            // arr[rowsum][col] = arr[rowsum][col]+arr[row][col];
	            // arr[3][3] = arr[3][3] + arr[3][3];
	            arr[row][colsum] += arr[row][col];
	            //arr[row][colsum] = arr[row][colsum] + arr[row][col];
	            //arr[3][3] = arr[3][3] + arr[3][3]
	            
	            arr[rowsum][colsum] = arr[row][col];
	            System.out.printf("%3d" , arr[row][col] );
	         }
	         System.out.println();
	      }
	   }
		
	public void practice1() {
		
		String[][] strArr = new String[3][3];
		
		for(int row=0; row<strArr.length; row++) {
			
			for(int col=0; col<strArr[row].length; col++) {
				
				strArr[row][col]="("+row+", "+col+")";
				
				System.out.print(strArr[row][col]);
			}System.out.println();
		}
	}
	
	public void practice2() {
		
		int[][] intArr = new int[4][4];
		
		int num=1;
		for(int row=0; row<intArr.length; row++) {
			
			for(int col=0; col<intArr[row].length; col++) {
				
				intArr[row][col]=num++;
				
				
				System.out.printf("%3d",intArr[row][col]);
			}System.out.println();
		}
	}
	
	public void practice3() {
		
		int[][] intArr = new int[4][4];
		int num=16;
		for(int row=0; row<intArr.length; row++) {
			
			for(int col=0; col<intArr[row].length;col++) {
				
				intArr[row][col]=num--;
				System.out.printf("%3d",intArr[row][col]);
			}
			System.out.println();
		}
				
	}
	public void practice4() {
		
		int[][] intArr = new int[4][4];
		
		// 상수 사용법 : 변하지 않는 특정 값에 이름을 붙여줌
		final int ROW_LAST_INDEX = intArr.length-1; // 행 마지막 인덱스
		final int COL_LAST_INDEX = intArr[0].length-1; // 열 마지막인덱스
								
		for(int row=0; row<intArr.length; row++) { // 행의길이(행반복)
										
			for(int col=0; col<intArr[row].length; col++) { // 열반복
									// row번째 행의 열의 길이
				
				// 마지막행, 마지막 열이 아닌경우
				if(row !=ROW_LAST_INDEX && col !=COL_LAST_INDEX) {
						
					int random = (int)(Math.random()*10+1); // 1~10 난수
					intArr[row][col] = random;
					
					// 각 행의 마지막 열에 난수를 누적
					intArr[row][COL_LAST_INDEX] +=intArr[row][col];
					
					// 각 열의 마지막 행에 난수를 누적
					intArr[ROW_LAST_INDEX][col] +=intArr[row][col];
					
					// 생성된 모든 난수를 마지막 행, 마지막 열에누적
					intArr[ROW_LAST_INDEX][COL_LAST_INDEX] += intArr[row][col];
					
				}
				System.out.printf("%4d",intArr[row][col]);	
			}	//열 반복 끝
			System.out.println(); // 줄바꿈	
		}
			
			
	}
		
	public void practice5() {
		
		Scanner sc= new Scanner(System.in);
		
		while(true) {
			
			System.out.print("행 크기 : ");
			int row = sc.nextInt();
			
			System.out.print("열 크기 : ");
			int col = sc.nextInt();
			
			if(row<1 || row>10 || col < 1 || col> 10) { // 1~10사이숫자가 아닌경우
				System.out.println("반드시 1~10 사이의 정수를 입력해야 합니다.");
			
			} else {
				int[][] arr = new int[row][col];
				
				for(int i=0; i<row; i++) {
					
					for(int j=0; j<col; j++) {
 						arr[i][j] = (int)(Math.random()*26);
 						
 						char result = (char)(arr[i][j]+65);
						System.out.print(result + " ");
				
					}
					System.out.println();
				}
				break;
			 } 
			
		}
	}
		
	public void practice6() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("행의 크기 : ");
		int input1 =sc.nextInt();
		
		char[][] arr = new char[input1][];
		
		char result='a';
		
		// 열 크기 정하는 for문
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(i+ "열의 크기 : ");
			int col = sc.nextInt();
			arr[i] = new char[col];
		}
		// 출력용 for문
		for(int row=0; row<arr.length; row++) {
			
			for(int col=0; col<arr[row].length; col++) {
				arr[row][col]= result++;
				System.out.print(arr[row][col]+" ");
			}
			System.out.println();
		}
		
	}

	/*실습문제7
	   1차원 문자열 배열에 학생 이름 초기화되어 있다.
	   3행 2열 짜리 2차원 문자열 배열 2개를 새로 선언 및 할당하여
	   학생 이름을 2차원 배열에 순서대로 저장하고 아래와 같이 출력하시오.
	   (첫 번째 2차원 배열이 모두 저장된 경우 두 번째 2차원 배열에 저장 진행)
	   String[] students = {"강건강", "남나나", "도대담", "류라라", "문미미", "박보배", 
	   "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하"};
	   [실행 화면]
	   == 1분단 ==
	   강건강 남나나
	   도대담 류라라
	   문미미 박보배
	   == 2분단 ==
	   송성실 윤예의
	   진재주 차천축
	   피풍표 홍하하
	   */
	public void practice7() {
		String[] students = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하" };

		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];

		int index = 0; // students 배열에서 0 부터 1씩 증가하며 학생들을 선택하는 용도의 변수

		System.out.println("== 1분단 ==");
		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[row].length; col++) {

				arr1[row][col] = students[index];
				// students배열 index 번째 학생을 arr1[row][col]에 대입

				index++;

				System.out.print(arr1[row][col] + " ");
			}
			System.out.println();// 줄바꿈
		}

		System.out.println("== 2분단 ==");
		for (int row = 0; row < arr2.length; row++) {
			for (int col = 0; col < arr2[row].length; col++) {

				arr2[row][col] = students[index];
				// students배열 index 번째 학생을 arr2[row][col]에 대입

				index++;

				System.out.print(arr2[row][col] + " ");
			}
			System.out.println();// 줄바꿈
		}

	}

	// 위 문제에서 자리 배치한 것을 가지고 학생 이름을 검색하여
	// 해당 학생이 어느 자리에 앉았는지 출력하세요.
	public void practice8() {
		String[] students = { "강건강", "남나나", "도대담", "류라라", "문미미", "박보배", "송성실", "윤예의", "진재주", "차천축", "피풍표", "홍하하" };

		String[][] arr1 = new String[3][2];
		String[][] arr2 = new String[3][2];

		int index = 0; // students 배열에서 0 부터 1씩 증가하며 학생들을 선택하는 용도의 변수

		System.out.println("== 1분단 ==");
		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[row].length; col++) {

				arr1[row][col] = students[index];
				// students배열 index 번째 학생을 arr1[row][col]에 대입

				index++;

				System.out.print(arr1[row][col] + " ");
			}
			System.out.println();// 줄바꿈
		}

		System.out.println("== 2분단 ==");
		for (int row = 0; row < arr2.length; row++) {
			for (int col = 0; col < arr2[row].length; col++) {

				arr2[row][col] = students[index];
				// students배열 index 번째 학생을 arr2[row][col]에 대입

				index++;

				System.out.print(arr2[row][col] + " ");
			}
			System.out.println();// 줄바꿈
		}

		System.out.println("===============================");

		Scanner sc = new Scanner(System.in);

		System.out.print("검색할 학생 이름을 입력하세요 : ");
		String inputName = sc.next();

		for (int row = 0; row < arr1.length; row++) {
			for (int col = 0; col < arr1[row].length; col++) {

				if (arr1[row][col].equals(inputName)) {
					if (col == 0) {
						System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 왼쪽에 있습니다.", inputName, row + 1);
					} else {
						System.out.printf("검색하신 %s 학생은 1분단 %d번째 줄 오른쪽에 있습니다.", inputName, row + 1);
					}
				}

			}
		}

		for (int row = 0; row < arr2.length; row++) {
			for (int col = 0; col < arr2[row].length; col++) {

				if (arr2[row][col].equals(inputName)) {
					if (col == 0) {
						System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 왼쪽에 있습니다.", inputName, row + 1);
					} else {
						System.out.printf("검색하신 %s 학생은 2분단 %d번째 줄 오른쪽에 있습니다.", inputName, row + 1);
					}
				}
			}
		}
	}
	// 선생님이 풀어주신거
	
	public void practice9() {
		Scanner sc = new Scanner(System.in);
		
		String[][] arr = new String[6][6];
		System.out.print("행 인덱스 입력 : ");
		int rowIndex = sc.nextInt();
		
		System.out.print("열 인덱스 입력 : ");
		int colIndex = sc.nextInt();
		
		int num1 = 0;
		int num2 = 0;
		
		for(int row=0; row<arr.length; row++) {
			for(int col=0; col<arr[row].length; col++) {
				if(row == 0 && col !=0) {
					arr[row][col] = num1++ + " ";
				}else if(col ==0 && row !=0) {
					arr[row][col]= num2++ +" ";
				}else {
					arr[row][col]= "  ";
				}
				arr[rowIndex+1][colIndex+1] = "X";
				
				System.out.print(arr[row][col]);
			}
			System.out.println();
		}
	
	}
}
