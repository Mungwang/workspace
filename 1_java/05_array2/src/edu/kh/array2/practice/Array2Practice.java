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
	
	public void practice10() {
		Scanner sc = new Scanner(System.in);
		
		String[][] arr = new String[6][6];
		
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
				System.out.print(arr[row][col]);
			}
			System.out.println();
		}
		while(true) {
			
			System.out.print("행 인덱스 입력 : ");
			int rowIndex = sc.nextInt();
			
			System.out.print("열 인덱스 입력 : ");
			int colIndex = sc.nextInt();
			
			if(rowIndex==99) {
				System.out.println("프로그램 종료");
				break;
			}
			for(int i=0; i<arr.length; i++) {
				for(int j=0; i<arr[0].length; j++) {
					arr[rowIndex+1][colIndex+1] = "X";
					
				}
			}
		}
	
	}
	/*public void practice10(){ 되는거
        Scanner sc = new Scanner(System.in);
        String[][] arr = new String[6][6];
        int row = 0;
        int col = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(i==0 && j==0) arr[i][j] = " ";
                else if(i==0) arr[i][j] = (j-1)+"";
                else if(j==0) arr[i][j] = (i-1)+"";
                else arr[i][j] = " ";
            }
        }
        while(true){
            System.out.print("행 인덱스 입력 : ");
            row = sc.nextInt();
            System.out.print("열 인덱스 입력 : ");
            col = sc.nextInt();
            sc.nextLine();

            if(row==99 || col==99) {
                System.out.println("프로그램 종료");
                break;
            }

            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr[0].length; j++){
                    if(i==row+1 && j==col+1) arr[row+1][col+1]="X";
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }*/
	
	public void practice11() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("빙고판 크기 지정 : ");
		int num = sc.nextInt();
		sc.nextLine();
	
		// 1차원 배열로 빙고판에 입력될 값 생성 + 중복 제거 진행
		int[] tempArr = new int[num*num]; // 1차원 배열 생성
		// num * num* --> 빙고판의 크기는 가로,세로의 곱 만큼의 공간이 필요함
		
		// 중복값 제거하면서 랜덤값 집어넣기
		for(int i=0; i<tempArr.length; i++) {
			tempArr[i] = (int)(Math.random()*(num*num))+1;
			
			// 중복제거
			for(int j=0; j<i; j++) {
				if(tempArr[i] == tempArr[j]) {
					i--; break;
				}
				
			}
		}
		// 위에서 만들어진 중복제거한 1차원 배열을 --> 2차원 배열에 넣기
		// String 배열로 변경해서 대입 진행
		// 왜 String 배열? 빙고가 된 부분을 "★"로 변경하기 위해서
		String[][] bingoBoard = new String[num][num];
		
		int index =0; // 1차원 배열 인덱스 지정을 위한 변수
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				// 1차원 배열은 0번 부터 num*num까지 반복 진행
				
				bingoBoard[i][j] = tempArr[index] + "";
				index++;
			}
		}
		// -----------------------------------------------
		
		// 랜덤 배치된 빙고판 최초 1회 출력
		
		for(int i=0; i<bingoBoard.length; i++) {
			for(int j=0; j<bingoBoard[0].length; j++) { // 열의길이 bingoBoard[0].length
				System.out.printf("%4s",bingoBoard[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("=================== 빙고게임 시작 ===================");
		while(true) {
			System.out.print("정수를 입력하시오 : ");
			String input = sc.nextLine();
			
			boolean flag = true; // 검색된 값이 빙고판에 있는지확인 (잘못된 입력확인)
			for(int i=0; i<bingoBoard.length; i++) {
				for(int j=0; j<bingoBoard[0].length; j++) {
		
					// 입력된 값과 일치되는 곳을 ★형태로 변환
					if(bingoBoard[i][j].equals(input)) {
						bingoBoard[i][j] ="★";
						flag = false;
					}
					System.out.printf("%4s",bingoBoard[i][j]);					
				}
				System.out.println();
			}
			if(flag) {
				System.out.println("잘못 입력하셨습니다. 다시 입력하세요.");
				continue;
			}
			
			// 빙고판에 크기에 따라
			// 빙고 기준이 되는 문자열 생성
			// ex) 5*5 크기 빙고 -> 한 줄이 "★★★★★" 이면 빙고
			String bingoLine = "";
			for(int i=0; i<num; i++) {
				bingoLine += "★";
			}
			
			// 빙고검사
			int bingoCount = 0 ; // 빙고 수를 저장할 변수
			
			// 가로(행) 또는 세로(열)의 문자열을 더하여 하나의 문자열로 저장
			// -> 저장된 문자열의 모양이 "★★★★★"인 경우 == 빙고
			// --> bingoCount 증가
			
			for(int i=0; i<bingoBoard.length; i++) {
				
				// 매 반복시 마다 row, col을 빈 문자열로 초기화
				// --> 바깥쪽 for문이 반복될 때 마다 검사하는 행과 열이 이동하므로
				//     빙고 여부를 검사하기 위한 row, col을 빈 문자열로 초기화 해야함
				
				String row = "";
				String col = "";
				
				for(int j=0; j<bingoBoard.length; j++) {
					row += bingoBoard[i][j]; // 현재 행의 문자를 모두 더함
					
					// i,j(행렬)를 반대로 하여 열의 모든 문자를 더함
					col += bingoBoard[j][i]; 
				}
				
				if(row.equals(bingoLine)) {
					bingoCount++; // 가로 빙고가 존재할 경우
				}
				if(col.equals(bingoLine)) {
					bingoCount++; // 세로 빙고가 존재할 경우
					
				}
			}
			 
			// 대각선 빙고 여부
			// 대각선 : diagonal(다이애그널)
			
			// 대각선은 빙고판에 두 개만 존재
			// --> 대각선 문자를 더해서 저장할 변수 두 개 선언 및 빈문자열로 초기화
			String dia1 = "";
			String dia2 = "";
			
			for(int i=0; i<bingoBoard.length; i++) {
				dia1 += bingoBoard[i][i]; // 좌상 우하
				dia2 += bingoBoard[bingoBoard.length-1-i][i]; // 우상 좌하
			}
			if(dia1.equals(bingoLine)) {
				bingoCount++;
			}
			if(dia2.equals(bingoLine)) {
				bingoCount++;
			}
			
			// 빙고 카운트 출력
			System.out.println("현재"+ bingoCount + "빙고");
			if(bingoCount >=3) { // 빙고 개수가 3개이상인 경우
				System.out.println("*********** BINGO!!! **********");
				break;
			}
		}// while문 종료
	}
}

