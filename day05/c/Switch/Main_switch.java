package my.day05.c.Switch;

import java.util.Scanner;

public class Main_switch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String input_str = "";
		
		try {
			System.out.print("▣ 첫번째 정수 입력 => ");
			input_str = sc.nextLine();
			int num1 = Integer.parseInt(input_str);  // 문자열을 정수로 형변환 시킨다. 
			                                         // 10 
			                                         // 3000000000
			                                         // 똘똘이 
			
			System.out.print("▣ 두번째 정수 입력 => ");
			input_str = sc.nextLine();
			int num2 = Integer.parseInt(input_str);  // 문자열을 정수로 형변환 시킨다. 
			                                         // 4 
			                                         // 5000000000
			                                         // 헤헤헤
			
			System.out.print("▣ 사칙연산을 선택하세요(+ - * /) : ");    // +  -  *  / 
			                                                     // 우하하하  
			                                                     // #  
			                                                     // 7
			String operator = sc.nextLine();
			
			String result = "";
			double calc_result = 0;
			
			
			
	/*
			if("+".equals(operator)) {
				calc_result = num1 + num2;
			}
			
			else if("-".equals(operator)) {
				calc_result = num1 - num2;
			}
			
			else if("*".equals(operator)) {
				calc_result = num1 * num2;
			}
			
			else if("/".equals(operator)) {
				calc_result = (double)num1 / num2;
			}
			
			else {
				// 사칙연산 선택시 + - * / 를 제외한 다른것을 입력한 경우 
				System.out.println("[경고] 사칙연산 선택은 + - * / 만 입력하세요!!");
				sc.close();
				return; // 종료
			}
	*/
			
			//암기
			switch (operator) {   ////(비교대상)이 오면""와 같냐는 것.  비교대상과 오퍼레이트는 키보드
			case "+": //operator 값이 "+"와 같다라면
				calc_result = num1 + num2;    
				break;//switch문장에서 break를 만나면(operator){} 부분을 빠져나가라는 말이다.
				
			case "-": //operator 값이 "-"와 같다라면
				calc_result = num1 - num2;    
				break;     ////스위치문 빠져나옴
				
			case "*": //operator 값이 "*"와 같다라면
				calc_result = num1 * num2;    
				break; 
				
			case "/": //operator 값이 "/"와 같다라면
				calc_result = (double)num1 / num2;   
				break; 
				
			default:   
				// 사칙연산 선택시 + - * / 를 제외한 다른것을 입력한 경우    //기타 = else
				System.out.println("[경고] 사칙연산 선택은 + - * / 만 입력하세요!!");
				sc.close();
				return; // 종료.  리턴 있으니까 브레이크 쓰지 말기
				
			}// end of switch(operator)--------------------
			
			
			
			
			/*
			    if("/".equals(operator)) { //  /  인 경우
			 
				
				if(num1%num2 == 0) {
					result = num1 + operator + num2 + "=" + (int)calc_result;
					      // 10/5=2
				}
				else {
					result = num1 + operator + num2 + "=" + calc_result;
					      // 10/4=2.5 
				}
				      
			}
			else { //  + - * 인 경우
				result = num1 + operator + num2 + "=" + (int)calc_result;
				     // 10+4=14
			         // 10-4=6
			         // 10*4=40
			}
			*/
			
			switch (operator) {   ////(키보드)에 입력한 값이 나누기 입니까??? 라는 말
				case "/":
					if(num1%num2 == 0) {
						result = num1 + operator + num2 + "=" + (int)calc_result;
						    // 10/5=2  
					}
					else {
						result = num1 + operator + num2 + "=" + calc_result;
						    // 10/4=2.5 
					}
					
					break;  ////스위치문 빠져나옴. 그 후 리저트 써줘야 함.
	
				default:   	////=else문
					result = num1 + operator + num2 + "=" + (int)calc_result;
				     // 10+4=14
			         // 10-4=6
			         // 10*4=40
					break;
				}//end of switch (operator)----------
				
			
			
			
			System.out.println(result); 
			//  10 + 4 = 14
			//  10 - 4 = 6
			//  10 * 4 = 40
			//  10 / 4 = 2.5  
			
			
		} catch(NumberFormatException e) {
			System.out.println(">>> "+ input_str +" 은 올바른 데이터 아닙니다. 올바른 정수를 입력하세요!!"); 
		} catch(ArithmeticException e) {
			System.out.println(">>> 0 으로 나눌 수 없습니다. <<<");
		}
		
		sc.close();
		
	}// end of public static void main(String[] args)------


}
 