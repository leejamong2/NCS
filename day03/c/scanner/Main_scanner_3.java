package my.day03.c.scanner;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_scanner_3 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
				
		System.out.println("정수를 입력하세요=>");
		
		
		String inputStr = sc.nextLine();  //"103"
										//"똘똘이"
		
		try {
		
		
		// 문자열(String)을 int타입으로 형변환 시켜주는 메소드가 있다.
		//byte n =(byte)(Byte.parseByte(inputStr) + 10);  //사칙연산 만나서 int
		 //		"103" --> 103 + 10
				
		
		// 문자열(String)을 short타입으로 형변환 시켜주는 메소드가 있다.
		//short n =(short)(Short.parseShort(inpustr) + 10);  
				 //		"103" --> 103 + 10
		
				
		// 문자열(String)을 int타입으로 형변환 시켜주는 메소드가 있다.
		int n = Integer.parseInt(inputStr) + 10;
		 //		"123"-->123
		

		// 문자열(String)을 long 타입으로 형변환 시켜주는 메소드가 있다.
		//long n = Long.parseLong(inputStr) + 10;
				 //		"3000000000"-->3000000000 + 10
				
		
		
		
		System.out.println("입력한 정수" +inputStr+" 에 10을 더한 값 :" + n);
		
		} catch(NumberFormatException e) {
			System.out.println("[경고]>> " + inputStr + "는 정수가 아닙니다. 정수만 입력하세요!!<<");
			
		}
		
		
		
		
		sc.close();
	}

}
