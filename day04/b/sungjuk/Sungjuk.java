package my.day04.b.sungjuk;

public class Sungjuk {
	
	//====필드====/
	String hakbun;   // "091234"   스트링이라 맨앞에 0올 수 있음 인트라면x
	String name;
	byte kor;        // byte -128~127     0~100로 제한
	byte eng;        // 
	byte math;       // 
	short age;		 //short -32768~32767
    short all;
    double avg;
    String hakjum;
    
	
	
	
	//====메소드====
	boolean check_jumsu(byte jumsu){  //바이트가 들어왔을 때만 실행됨. 그 외에는 익셉션처리

		if(0 <= jumsu && jumsu <= 100) {////&&두개인 이유는 점수가 -50거짓이면 스킵해도되니까
			return  true; //리턴 을 만나면 해당 매소드가 종료됨 

		}
		else  {
			System.out.println("[경고] 입력하시는 점수는 0 이상 100이하 이어야만 합니다.\n");
			return false;
		}
	}//end of boolean check_jumsu(byte jumsu) --------------------------------





	boolean check_age(short age){  //바이트가 들어왔을 때만 실행됨. 그 외에는 익셉션처리

		if(20 <= age && age <=50) {////&&두개인 이유는 점수가 -50거짓이면 스킵해도되니까
			return  true; //리턴 을 만나면 해당 매소드가 종료됨 

		}
		else  {
			System.out.println("[경고] 입력하시는 점수는 0 이상 100이하 이어야만 합니다.\n"
			                  +"[나이에 대한 경고]입력하는 나이는~~이어야합니다.");
			return false;
		}
		
	} 
	//end of boolean check_age(byte age) --------------------------------

   


	




	void sungjuk_print() {
		
		float avg = (kor+eng+math)/3.0f;
		
		char hakjum = 'F';
		
		if(avg>= 90) {
		    hakjum = 'A';
		}
		else if(avg>= 90) {
			hakjum = 'B';
		}
		else if(avg>= 80) {
			hakjum = 'C';
		}
		else if(avg>= 70) {
			hakjum = 'D';
		}
		else if(avg>= 60) {
			hakjum = 'E';
		}
		
		
	   System.out.println("==="+name+"님의 성적결과====\n"
		+"1. 학번 : " + hakbun +"\n"
		+"2. 성명 : "+ name +"\n"
		+"3. 국어 : "+ kor +"\n"
		+"4. 영어 : "+ eng +"\n"
		+"5. 수학 : "+ math +"\n"
		+"6. 총점 : "+ (kor+eng+math) +"\n"
		+"7. 평균 : "+ (kor+eng+math)/3.0 +"\n" //.0붙여주기
		+"8. 학점 : "+ hakjum +"\n"
		+"9. 나이 : "+ age +"\n");
	}
}

 
















	
	
	
	
	
	
	
	

