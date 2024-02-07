package my.day05.f.For.quiz;

import java.util.Scanner;

public class Main_quiz_3 {

	public static void main(String[] args) {
		
		  // ★첫번째 정수 : 1
	      // ★두번째 정수 : 10
	      
	      // >> 결과 <<
	      // 1 부터 10 까지의 홀수의 합 : 25  13579
	      // 1 부터 10 까지의 짝수의 합 : 30  246810
	      
	   //   -----------------------------------
	      
	      // ★첫번째 정수 : 2
	      // ★두번째 정수 : 10
	      
	      // >> 결과 <<
	      // 2 부터 10 까지의 홀수의 합 : 24  3579
	      // 2 부터 10 까지의 짝수의 합 : 30  246810
	      
	      
	      // ★첫번째 정수 : 2.3453
	      // [경고] 올바른 정수를 입력하세요!!
		
		  // ★첫번째 정수 : 1
	      // ★두번째 정수 : 똘똘이
	      // [경고] 올바른 정수를 입력하세요!!
		
		  // ★첫번째 정수 : 1
		  // ★두번째 정수 : 10
		
		  // >> 결과 <<
	      // 1 부터 10 까지의 홀수의 합 : 25  
	      // 1 부터 10 까지의 짝수의 합 : 30  
		
		
		Scanner sc = new Scanner(System.in);
		
		for(;;) { 
			
			
			
			
			
			
			
		try {
			
			
			System.out.println("★첫번째 정수 : ");
			int first_no = Integer.parseInt(sc.nextLine());
			
			
			System.out.println("★두번째 정수 : ");
			int second_no = Integer.parseInt(sc.nextLine());
			
			int sum_holsu = 0;   //홀수의 누적의 합계를 저장하는 변수
			int sum_jjaksu = 0;  //짝수의 누적의 합계를 저장하는 변수
			
			int holsu=0, jjaksu=0;  // 2씩 증가하는 용도
			
			//first_no => 1     또는  first_no => 2
		    //second_no => 10	또는	 second_no => 10
				if(first_no%2!=0) { //첫번째 입력받은 값이 홀수 라면
					holsu = first_no;          			//// first_no가 홀/짝 뭐가 나올지 모르니까 경우의 수를 세워야 함.-> if 조건문
					jjaksu = first_no + 1;	
				}
				
				else { //첫번째 입력받은 값이 짝수 라면
					holsu = first_no+1; 
					jjaksu = first_no;
				}
				
			// ==홀수 및 짝수의 합을 구한다.==//
			for(;;) {
				
				if(holsu <= second_no)														/*세컨드 넘버가 10,11 될수 있으니 경우의수 만들어야함
					sum_holsu += holsu;														세컨넘버 10일때 (홀수 <= 10)이라면 */
					
				
				if(jjaksu > second_no)
					sum_jjaksu += jjaksu;
				
				holsu +=2;
				jjaksu +=2;
				
				if(holsu > second_no && 
				   jjaksu > second_no) {                              					 		/*세컨ㄴ넘버가 10일때 홀수가 10보다 크면서 짝수도 10보다 크면 빠져나간다.  
						// holsu (1 3 5 7  9 11 13)     second_no(10)	   second_no(11)			(holsu > second_no && jjaksu> second_no) 조건식을 이렇게 하면
						// jjaksu(2 4 6 8 10 12 14)	    second_no(10)	   second_no(11)			예시 네가지 다 성립.
																								*/
					
						// holsu(3 5 7 9 11 13)			second_no(10)		second_no(11)
						//jjaksu(2 4 6 8 10 12)		 	second_no(10)		second_no(11)
					break;
				}
				
				
				
				
			}//end of for-----
			
			System.out.println(">> 결과 <<");
			System.out.println(first_no+" 부터" +second_no+ " 까지의 홀수의 합 : "+sum_holsu +"\n"
							 + first_no+" 부터 10 까지의 짝수의 합 : 30\n");
			
				
			
			
			sc.close();
			break;
			
			
			
		} catch(NumberFormatException e) {
				System.out.println("[경고] 올바른 정수를 입력하세요!!\n");}
			}
			
		{
			
		}// end of for-----------------
			
	
		System.out.println(">>프로그램 종료<<");
		
		
	}//end of public static void main(String[] args)---------------------

}
