package my.day03.c.scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_scanner_2 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
				
		System.out.println("정수를 입력하세요=>");
		
		try {
		    int inputNum = sc.nextInt();  //123	
			 							  //이순신
			sc.nextLine();
			System.out.println(" 입력한 정수 : "+ inputNum);
		} catch(InputMismatchException e)       {
			System.out.println(">>경고 : 정수만 입력하세요!!<<");
			e.printStackTrace();    ////어디가 오류인지 추적해줌
		}
		
		sc.close();
	}

}
