package my.day04.b.sungjuk;

import java.util.Scanner;

public class Main_sungjuk {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 
		Sungjuk sj = new Sungjuk(); //기본생성자
		
		System.out.print("1. 학번 : ");
		sj.hakbun = sc.nextLine();  //"091234"
		
		
		System.out.print("2. 성명 : ");
		sj.name = sc.nextLine();  //"이순신"
		
		
		//input_str = sc.nextLine(); 초기화
		
		String input_str = " ";
		int status =1;  // 점수를 입력해주는 상태라면 :1
						//나이를 입력해주는 상태라면 : 2  개발자 맘대로
		
		try {
			status =1;
			System.out.print("3. 국어 : ");
			// === *** 유효성 검사기(올바른 데이터이지 틀린 데이터인지 검사하는 것) ***=== //
			
			byte kor =Byte.parseByte(sc.nextLine()); //90 
			//101
			//234321
			//"똘똘이"
				if( !sj.check_jumsu(kor) )   {         
					sc.close(); 
					return;                  //리턴 을 만나면 해당 매소드가 종료됨     	 
				}                                
				else {
					sj.kor = kor;
				}


			

				
			System.out.print("4. 영어 : ");
			//sj.eng =Byte.parseByte(sc.nextLine());       //100  타입달라서 바꿔줘야해 스트링->
			byte eng =Byte.parseByte(sc.nextLine());     //-20, 2345232, "똘똘이",... 자바로 봐서는 오류가 아님

				if( !sj.check_jumsu(eng) )   {         
					sc.close(); 
					return;                  //리턴 을 만나면 해당 매소드가 종료됨     	 
				}                                
				else {
					sj.eng = eng;
				}



				
			System.out.print("5. 수학 : ");
			sj.math =Byte.parseByte(sc.nextLine()); //80  타입달라서 바꿔줘야해 스트링->
			byte math =Byte.parseByte(sc.nextLine());	//-20, 2345232, "똘똘이",... 자바로 봐서는 오류가 아니라서 제한해줘야함.

			if( !sj.check_jumsu(math) )   {    ////점수가 꽝이라면     
				sc.close(); 
				return;                  //리턴 을 만나면 해당 매소드가 종료됨     	 
			}                                
			else {
				sj.math = math;
			} 
			
			
			//성적출력하기
			sj.sungjuk_print();  //위의 모든 데이터가 올바르기 때문에 여기까지온거
			
			
//			====이순신님의 성적결과====
//			1.학번 : 091234
//			2.성명 : 이순신
//			3.국어 : 90
//			4.영어 : 80
//			5.수학 : 78
//			6.총점 : 248
//			7.평균 : 82.66666666667
//			8.학점 : B
			
			
			
			
			
			
		}catch(NumberFormatException e) {
				//e.printStackTrace();
				//System.out.println(e.getMessage());
		
			
			
			
			
			
			
		//if(status==1) {                 //점수를 입력해주는 상태라면
			//(NumberFormatException e)}
			 
			//status =2;
			System.out.print("6. 나이 : ");
			System.out.print( "입력하신 "+input_str+"올바른 값을 입력해주세요");
		                        
		}
			Short age = Short.parseShort(input_str);
			
			if( !sj.check_age(age)) {
				sc.close();
				return;                  //리턴 을 만나면 해당 매소드가 종료됨 
				
				
			
			}
			
		}  
	}

	
		

