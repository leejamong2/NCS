package my.day07.b.dowhile;

import java.util.Scanner;

public class Main_factorial_2 {

	public static void main(String[] args) {
		

		// ===입사문제===//
		/*
		 	알고싶은 팩토리얼 수를 입력 => 5 엔터
		 	>>결과 : 5! = 120
		 	>>또 할래?[Y/N] => y
		 	
		 	
		 	
		 	5! ==> 5*4*3*2*1
		 	
		 	알고싶은 팩토리얼 수를 입력 => 0 엔터
		 	>>[경고] 자연수만 입력하세요!!
		
		 	알고싶은 팩토리얼 수를 입력 => -5 엔터
		 	>>[경고] 자연수만 입력하세요!!
		 	
		 	알고싶은 팩토리얼 수를 입력 => 1.25 엔터
		 	>>[경고] 정수만 입력하세요!!

		 	알고싶은 팩토리얼 수를 입력 => 똘똘이 엔터
		 	>>[경고] 정수만 입력하세요!!
		 	
		 	알고싶은 팩토리얼 수를 입력 => 4 엔터
		 	>>결과 : 4! = 24
		 	>>또 할래?[Y/N] => s 엔터
		 	>>[경고] Y또는 n만 입력하세요!!
		 	>>또 할래?[Y/N] => n 엔터
		 	>>>프로그램 종료
		 	
		 */
		
		
		Scanner sc = new Scanner(System.in);
		
		outer:
		do {
			try {
				System.out.print("알고싶은 팩토리얼 수를 입력 => ");
				long num = Integer.parseInt(sc.nextLine());
				
				if(num <= 0) {
					System.out.println(">>[경고] 자연수만 입력하세요!!");
					continue;
					//continue; 를 만나면 아래로떨어지지 않고 dowhile문 조간식으로 들어간다.
				} 
				
				// == 팩토리얼 구하기 시작 == //
				long factorial = 1;
				for(long i=num; i>0; i--) {
					factorial *= i;  // factorial = factorial *i;
									// 	factorial = 	1*5
									// 	factorial = 	5*4
									// 	factorial = 	5*4*3
									// 	factorial = 	5*4*3*2
									// 	factorial = 	5*4*3*2*1
					
				}//end of for-----------
				
				System.out.println(num+"!="+factorial);
				// == 팩토리얼 구하기 끝 == //
				
				
				do {
				System.out.print(">>또 할래?[Y/N] =>");
				String yn = sc.nextLine();
				
				if("y".equalsIgnoreCase(yn)) {
					break;
				}
				
				else if("n".equalsIgnoreCase(yn)){
					sc.close();
					break outer;  // == 팩토리얼 구하는 프로그램을 끝 == //
				}
				
				else {
					System.out.println(">>[경고] Y또는 n만 입력하세요!!");
				}
				
				}while(true);
				//end of dowhile------------------------------------
				
				
			}catch(NumberFormatException e) {
				System.out.println(">>[경고] 정수만 입력하세요!!");
			}
			
		} while (true);
		//end of dowhile
		
		System.out.println("\n>>>프로그램 종료<<<");
		
		
		
		
		
	}//end of main()--------------------------------------------------------

}

