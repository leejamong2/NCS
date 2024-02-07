package my.day04.a.wrapper;

import java.util.Scanner;

/*
=== *** wrapper 클래스 *** ===

------------------------------------------------
  기본자료형(원시형, primitive)     wrapper 클래스
------------------------------------------------
 byte                           Byte 
 short                          Short
 int                            Integer  ////
 long                           Long
 char                           Character  ////
 float                          Float
 double                         Double
 boolean                        Boolean 
 ------------------------------------------------
 
  기본자료형(원시형)은 데이터 저장 및 4칙연산 에서만 사용하는 것이고, 
  wrapper 클래스는  데이터 저장 및 4칙연산 뿐만아니라 
  아주 다양한 기능의 메소드가 제공되므로 다방면으로 사용되어진다.  
*/



public class Main_wrappper {

	public static void main(String[] args) {
		
		
		char ch = 'a';
		System.out.println("ch =>" + ch); //  ch => a
		System.out.println((ch +1)); // (int)ch+1  97+1  98
		System.out.println((char)(ch-32)); // (int)ch-32  97=32  65  (char)65 =>  A   ////자동형변환
		
		
		//Character char = new Character('a'); 
			// 생성자 Character(char) 는 더이상 사용되지 않으며 제거대상으로 표시되었습니다.
		
		Character chr = Character.valueOf('a'); 
		System.out.println("chr =>"+ chr);  //char => a
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~\n");
		
		System.out.println((char)('a'-32));  //  A
		System.out.println(Character.toUpperCase('a')); //  A
		System.out.println(Character.toLowerCase('A')); //  a
		System.out.println(Character.toUpperCase(97)); //  65  ////95자리가 int라서
		System.out.println(Character.toLowerCase(65)); //  
		
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~\n");
		
		char ch2 = 'c';
		
		if('A' <= ch2 && ch2 <= 'Z') {  //
			System.out.println(ch2 +"는 대문자 입니다.");
		}
		
		else if('a' <= ch2 && ch2 <= 'z') {
			System.out.println(ch2 +"는 소문자 입니다.");
		}
		
		else if('0' <= ch2 && ch2 <= 'z') {
			System.out.println(ch2 +"는 숫자 입니다.");
		
		}

		else if('0' <= ch2 && ch2 <= 'z') {
			System.out.println(ch2 +"는 숫자 입니다.");     ////0=  ,  a=   , 외우기
		
		}
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~\n");
		
		Scanner sc = new Scanner(System.in);
		String input_str = sc.nextLine();
		
		char c5= input_str.charAt(0);
		
		if(Character.isUpperCase(c5)) {  //대문자인지 알아본다
			System.out.println(c5 +"는 대문자 입니다.");
		}
		
		else if(Character.isLowerCase(c5)) {  //
			System.out.println(c5 +"는 소문자 입니다.");
		}
		
		else if(Character.isDigit(c5)){
			System.out.println(c5 +"는 숫자 입니다.");
		}

		else {
			System.out.println(c5 +"는 특수문자 입니다.");     ////0=  ,  a=   , 외우기
		}
	
		
		
		
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~\n");
		
		
		String str = "Baby";
		//   index    0123   (암기)   ////0부터 시작 
		
		char ch1 = str.charAt(0);  //'B'
		System.out.println(ch1);  //B
		
		ch1 = str.charAt(3);   // 'y'
		System.out.println(ch1);  // y
		
		
		System.out.print(">>[퀴즈]한글을 포함한 문장을 입력하세요 =>");
				
		input_str = sc.nextLine();   // Java , java, ...   ////리턴타입이 스트링타입
		  // I am a boy          ==> 첫글자 I 은(는) 대문자 입니다.
	      // superman          ==> 첫글자 s 은(는) 소문자 입니다.
	      // 8080 tomcat       ==> 첫글자 8 은(는) 숫자 입니다.
		  // 안녕하세요 goodmoring ==> 첫글자 안 은(는) 한글 입니다.
	      //  좋은하루 되세요          ==>첫글자   은(는) 공백 입니다.		
	      // @gmail.com        ==> 첫글자 @ 은(는) 기타문자 입니다.
	     
	      // 첫글자 I 은(는) 대문자 입니다.
	      // 첫글자 s 은(는) 소문자 입니다.
	      // 첫글자 8 은(는) 숫자 입니다.
	      // 첫글자 @ 은(는) 기타문자 입니다.
	      // 첫글자 안 은(는) 한글 입니다.
		
		
	  
		
		char c = input_str.charAt(0);  
		
		
		if(Character.isUpperCase(c)) {  //대문자인지 알아본다
			System.out.println("첫글자" +"는 대문자 입니다.");
			
		}
		else if(Character.isLowerCase(c)) {  //
			System.out.println("첫글자" +"는 소문자 입니다.");
		}
		
		else if(Character.isDigit(c)){
			System.out.println("첫글자"+ c +"는 숫자 입니다.");
		
	}
		else if('가' <= c && c <= '힣') {
			System.out.println("첫글자" + c +"는 한글 입니다.");
		
	}
		else if(c ==' ') {
			System.out.println("첫글자" + c +"는 공백 입니다.");
		}
			
		else {
			System.out.println(c +"는 특수문자 입니다.");     ////0=  ,  a=   , 외우기
	}

		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.println("== 오토박싱, 오토언박싱 에 대해서 알아봅니다.==");   
	      
	      // Boxing(박싱, 포장을 하는것) 이란 ?
	      // ==> 기본자료형(boolean, byte, short, int, long, char, float, double)으로 되어진 변수를 
	      //     객체타입인 Wrapper 클래스(Boolean, Byte, Short, Integer, Long, Character, Float, Double)   
	      //     타입의 객체로 만들어주는 것을 말한다.
		
		int a1=10;
		
	   //Integer a2 = new Integer(a1);  //Boxing(박싱)
		Integer a2 = Integer.valueOf(a1);      //Boxing(박싱)    jdk11 방식
		System.out.println("a2=> " +a2);  //a2=> 10
		
		int b1 = 10;
		Integer b2 = b1; 
		System.out.println("b2=>"+b2);  //b2=>10
		
		
		// UnBoxing(언박싱, 포장을 푸는것) 이란?   
	      // ==> Wrapper 클래스(Boolean, Byte, Short, Integer, Long, Character, Float, Double)로 
	      //     되어져 있는 객체를 기본자료형(boolean, byte, short, int, long, char, float, double)으로 
	      //     만들어주는 것을 말한다.
		Integer a3 = Integer.valueOf(20);
		int a4 = a3.intValue();  //언박싱
		System.out.println("a4=>"+a4);  // a4=> 20
		
		int a5 = Integer.valueOf(20);  //auto 언박싱   a3.intValue(); 을 생략함.
		System.out.println("a5=>"+a5);  // a5=> 20

		
		
		
		
		
		
		
		
		sc.close();
		
	}
		
		
		
}
