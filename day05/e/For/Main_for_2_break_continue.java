package my.day05.e.For;

public class Main_for_2_break_continue {

	public static void main(String[] args) {
		
		
		
		System.out.println(">> 1.break <<");
		
		for(int i=0; i<10; i++) {
			if(i==5) {   ////i가 5되면 빠져나와라
				break;  // 반복문에서 braek; 를 만나면 가장 가까운 반복문을 벗어나는 것이다.(외우깅)
			}
			
			System.out.println(i+1);
		} //end of for--------------
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		int cnt = 0;   //카운트
		
		for(;;) { 
			System.out.println(++cnt + "번째 반복");
			if(cnt == 5)
				break;
		}
	/*
		1번째 반복
		2번째 반복
		3번째 반복
		4번째 반복
		5번째 반복 
	*/
		
		
		
		
		System.out.println("\n>> 2.continue <<");
		
		for(int i=0; i<10; i++) {
			if((i+1)%2 == 0) {  //출력하고자 하는 (i+1) 값이 짝수라면 
				continue;       //반복문에서 continue;를 만나면 실행 순서가 밑으로 내려가지 않고 가장 가까운 반복문의 증감식!으로 이동시켜줌.
			}
			System.out.print((i+1) + " ");  		////홀수면 내려와서 찍어준다는 말
			// i==>0  (i+1)==>1
			// i==>1  (i+1)==>2  continue;  i++
			// i==>2  (i+1)==>3
			// i==>3  (i+1)==>4  continue;  i++
			// i==>4  (i+1)==>5
			// i==>5  (i+1)==>6  continue;  i++
			// i==>6  (i+1)==>7  
			// i==>7  (i+1)==>8  continue;  i++
			// i==>8  (i+1)==>9  
			// i==>9  (i+1)==>10 continue;  i++
			// i==>10  i<10; ==> 거짓
			// 1 3 5 7 9
		}//end of for-----------------------
		
		
		
		
		System.out.println("\n~~~~~~~~~~~\n");
		
		for(int i=0; i<10; i++) {
		
		/*	if(i<9) {
				System.out.print((i+1) + ", ");  
			}
			else {
				System.out.print((i+1)); 
		}		
		*/	
			
		//String str = (i<9)?"," : "";	
		// System.out.print((i+1) + str);
		// 1, 3, 5, 7, 9
		}
		
		
		
		
		
		System.out.println("\n~~~~~~~~~~~\n");
		
		for(int i=0; i<10; i++) {
			
			if((i+1)%2 == 0)
				continue;
			
			String str = (i+1<9)?"," : "";
			System.out.print((i+1) + str);
		}
			
		
				
			
			System.out.println("\n>> 프로그램 종료 <<");
	}
}

	
	//end of public static void main(String[] args)

		
