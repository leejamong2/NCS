package my.day05.e.For;

import java.util.Scanner;

public class Main_for_5_sum_3 {

	public static void main(String[] args) {
		
		
		
	/*
    >> 누적해야할 시작 숫자 => 1
    >> 누적해야할 마지막 숫자 => 10
    [실행결과] 1+2+3+4+5+6+7+8+9+10=55 
    
    >> 누적해야할 시작 숫자 => 3
    >> 누적해야할 마지막 숫자 => 5
    [실행결과] 3+4+5=12
    
    >> 누적해야할 시작 숫자 => 똘똘이
      [경고] 올바른 정수만 입력하세요!!
      >> 누적해야할 시작 숫자 => 3
    >> 누적해야할 마지막 숫자 => 345234543643643543
      [경고] 올바른 정수만 입력하세요!!
      >> 누적해야할 마지막 숫자 => 6
    [실행결과] 3+4+5+6=18
 */
		
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;     //합을 저장하는 변수로써 0으로 초기화함
		String str = ""; //누적될 숫자와 +를 문자열로 결합해서 변수로써 "" 으로 초기화함
		
		for(;;) {  ////우리가 어떤 숫자를 할 지 모르니까 (;;)로. 무한반복
			
			
			try {  ////꽝이 나올 수 있으니 트라이 써주기
				System.out.print(">> 누적해야할 시작 숫자 => ");
				int start_no = Integer.parseInt(sc.nextLine());  ////스트링타입이라서 숫자 누적하려면 인트로바꿔줘야함. parseInt란 String타입의 숫자를 int타입으로 변환해주는 녀석
				// start_no => 1   3   3
				// start_no => 똘똘이  30000000000 ==> 꽝 ->
				
				System.out.print(">> 누적해야할 마지막 숫자 => ");
				int end_no = Integer.parseInt(sc.nextLine());
				// start_no => 10   5   6
				// start_no => 이순신  40000000000 ==> 꽝
				
				
				
				
				
				for(int i=start_no; i<=end_no; i++) {  ////
					
					/*
					 * if(i<end_no) 
					 * 		str += i+"+";
					 * 
					 * else 
					 * 		str += i+"="; //맨 마지막에는 "="이 나와야 해서.
					 */
					  
					 
				
					
					//또는
					  String add = (i<end_no)? "+" : "="; 
					  str += i+add;
					 
					
					  sum += i;
				}//end of for -------------------------								
				
				
			}catch(NumberFormatException e) {
				System.out.println("[경고] 올바른 정수만 입력하세요!!");
				continue;  //가장 가까운 증감식으로 -> (;;)무한대니까 다시 반복해줌. 다시시작.
			}	
			
			sc.close();
			break;  //for문 빠져나간다.
		}//end of for------------------------------
		
		System.out.println(str+sum);
		
		
		System.out.println("\n===프로그램 종료 ===");

	}// public static void main(String[] args)----

}
