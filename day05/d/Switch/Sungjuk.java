package my.day05.d.Switch;

public class Sungjuk {
	
	//====필드====/
	String hakbun;   // "091234"   스트링이라 맨앞에 0올 수 있음 인트라면x
	String name;
	byte kor;        // byte -128~127     0~100로 제한
	byte eng;        // 
	byte math;       // 
	
	
	
	
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







	void sungjuk_print() {
		
		float avg = (kor+eng+math)/3.0f;
		
		char hakjum = ' ';   
	/*	
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
		*/
		
	//	byte key = 0;
	//	short key = 0;
	//	int key = 0;
	//	long key= 0;  ==> 불가
	//	char key = ' ';
	//	float key =0.0F;  ==> 불가
	//	double key = 0.0;  ==> 불가
	//	String key =" ";
		switch ( ((byte)avg)/10 ) {   //switch에 들어올 비교대상값은 정수형 중에 long을 제외한 나머지인 byte, short, int만 가능.!! (암기!!!)
						   			  //   switch에 들어올 비교대상값은 char도 가능.
								      //   switch에 들어올 비교대상값으로 float 및 double은 불가
								      //   switch에 들어올 비교대상값은 String 타입도 가능.   ==> 바이트 쇼트 인트 스트링 차 가능
									  //   avg는 위에서 플롯 타입, 0~100으로 지정해놨기 때문에 타입을 바꿔주지 않으면 오류.
		case 10 :
			//or				// hakjum = 'A'; + break;  두번 쓸 필요x.
			
								// (byte)avg)/10값이 10 또는 9라면
			
		case 9:					// 90 <= (byte)avg <=100 스위치는 범위 사용 안됨. 
			hakjum = 'A';		// 90 91 92...98 99 앞자리가 전부다 9면 'A' 이렇게 생각해볼 수 있음.
								//   90/10   91/10   92/10...98/10   99/10   정수 10으로 나누면 9가 되지.
			break;				//     9	   9	   9       9	   9
								//   주의) avg를 먼저 10으로 나누고 형변환하면 안되고,  byte로 형변환 후 / 10 해줘야함.
			
		case 8:					// (byte)avg)/10값이 8라면
			hakjum = 'B';
			break;
			
		case 7:					// (byte)avg)/10값이 7라면
			hakjum = 'C';
			break;
			
		case 6:					// (byte)avg)/10값이 6라면
			hakjum = 'D';
			break;
			
		
		default: 	 
			hakjum ='F';		// (byte)avg)/10값이 10,9,8,7,6 을 제외한 다른값 이라면
			break;
		}// end of switch ( ((byte)avg)/10 )-----------------
		////맨 처음에 char가 공백이었지만 ((byte)avg)/10 로 채워짐.
		
		
		
		
		
		
		String gift = " ";   			////지역변수  초기화
		
		switch (hakjum) {
			case 'A':
				gift += "놀이공원이용권,";   // gift = gift + "놀이공원이용권,";
										// gift = "" + "놀이공원이용권,"; 맨 첨에는 이렇게 나옴
							
			case 'B':
				gift += "치킨,"; 			// gift = gift + "치킨,";
										//놀이공원이용권+치킨 을 = 키프트에 또 넣어줌
				
			case 'C':
				gift += "피자,"; 			// gift = gift + "피자,";
										//놀이공원이용권+치킨+피자 를 = 키프트에 또 넣어줌.  계속 쌓임.
			
			case 'D':
				gift += "아이스크림,"; 		// gift = gift + "치킨,";
										//놀이공원이용권+치킨+피자+아이스크림 을 = 키프트에 또 넣어줌
				break;					//break를 만나야만 switch case 문을 빠져나옴.
				
				
			default:
				gift = " 꿀밤3대";
				break;
				
		}// end of switch ( hakjum )-----------------
		
		
		
	   System.out.println("==="+name+"님의 성적결과====\n"
							+"1. 학번 : " + hakbun +"\n"
							+"2. 성명 : "+ name +"\n"
							+"3. 국어 : "+ kor +"\n"
							+"4. 영어 : "+ eng +"\n"
							+"5. 수학 : "+ math +"\n"
							+"6. 총점 : "+ (kor+eng+math) +"\n"
							+"7. 평균 : "+ +Math.round(avg*10) / 10.0 +"\n" //.0붙여주기
							+"8. 학점 : "+ hakjum +"\n"
							+"9. 선물 : "+ gift +"\n"
							);
	}
}

 
















	
	
	
	
	
	
	
	

