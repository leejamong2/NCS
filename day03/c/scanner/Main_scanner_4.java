package my.day03.c.scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_scanner_4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String str_no = "";    //지역변수 초기화하기
		
	try {
	
		System.out.print("1.첫번째 정수 입력:");
		str_no = sc.nextLine();  // 키보드에서 str_no 로 바꾸겠다
		int first_no = Integer.parseInt(str_no);
		
		System.out.print("2.두번째 정수 입력:");  
		str_no = sc.nextLine();
		int second_no = Integer.parseInt(str_no );
		
		System.out.print(">>"+first_no+"+"+second_no+"="+(first_no + second_no));


		}catch(NumberFormatException e) {
		   System.out.println(">>[경고]"+ str_no+"는 정수가 아닙니다.");
		}
		
		
		
		
		
		
	
	}
	 
}
