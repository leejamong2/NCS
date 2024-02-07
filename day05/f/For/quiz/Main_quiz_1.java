package my.day05.f.For.quiz;

public class Main_quiz_1 {

	public static void main(String[] args) {
		
		String word = "Abz3서a0#$T";
		//             0123456789
		
		
		System.out.println(word + "문자열의 길이(글자수) : " + word.length());
		//Abz3서a0#$T문자열의 길이(글자수) : 10
		
		System.out.println(word.charAt(0));  // 'A'
		System.out.println(word.charAt(2));  // 'a'
		System.out.println(word.charAt(3));  // '3'
		System.out.println(word.charAt(4));  // '서'
		System.out.println(word.charAt(7));  // '#'
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		int upper_cnt = 0, lower_cnt=0, number_cnt=0, hangul_cnt=0, special_cnt=0;  //카운트. 종류별로 개수 알아야하니까 선언사용.
		
		
		
		for(int i=0; i<word.length(); i++) {  //문자 번호가 0부터 있으니까 i+1 안해도됨.
			char ch = word.charAt(i);		//  한글자 한글자 ch
		
			
			if(Character.isUpperCase(ch))     	//대문자인지 검사
				upper_cnt++;                	//참이면 증가해준다
			  
			else if (Character.isLowerCase(ch)) // 소문자인지 검사
				lower_cnt++;                    //참이면 증가해준다
			
			else if (Character.isDigit(ch))   	// 소문자인지 검사
				number_cnt++;				  	//참이면 증가해준다
			
			else if ('가' <= ch && ch <= '힣') 	// 한글인지 검사
				hangul_cnt++;				  	//참이면 증가해준다
			
			else {                            	//그 외에는 특수문자
				special_cnt++;				  	//참이면 증가해준다
			}
				
				
			 
		} //end of for---------------
				
				
				
				
				
				
				
		System.out.println(word+"\n"
									+"대문자 개수 : " + upper_cnt + "\n"
									+"소문자 개수 : " + lower_cnt + "\n"
									+"숫자 개수 : " + number_cnt + "\n"
									+"한글 개수 : " + hangul_cnt + "\n"
									+"특수문자 개수 : " + special_cnt + "\n");
				
				
				
				
				
				
				
		
	}

}
