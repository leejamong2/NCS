package my.day06.a.multifor;

import java.util.Scanner;

public class Main_gugudan_2 {

	public static void main(String[] args) {
			
		/*
		   >> 몇단볼래? => 8엔터
		   
		   === 8단 ===
		   8*1=8
		   8*2=16 
		   8*3=24
		   8*4=32
		   8*5=40
		   8*6=48
		   8*7=56
		   8*8=64
		   8*9=72 
		   
		   >> 또 하시겠습니까?[Y/N] => y엔터 또는 Y엔터
		   
		   >> 몇단볼래? => 1.34엔터 또는 똘똘이엔터
		   >>> 2단부터 9단까지만 가능합니다 <<<
		   
		   >> 몇단볼래? => 345엔터
		   >>> 2단부터 9단까지만 가능합니다 <<<
		   
		   >> 몇단볼래? => 3엔터
		   
		   === 3단 ===
		   3*1=3
		   3*2=6 
		   3*3=9
		   3*4=12
		   3*5=15
		   3*6=18
		   3*7=21
		   3*8=24
		   3*9=27
		      
		   >> 또 하시겠습니까?[Y/N] => s엔터 또는 S엔터
		   >>> Y 또는 N 만 가능합니다!! <<<
		   
		   >> 또 하시겠습니까?[Y/N] => n엔터 또는 N엔터
		   
		   == 프로그램종료 ==   
		*/   
		
		
		
		Scanner sc = new Scanner(System.in);
		
		/*
		 	=== 레이블을 사용하여 break; 하기 ===
		 	레이블명 뒤에는 : 을 붙이며 반드시 반복문 앞에 써야 한다!!!!! 
		 */
		outer:    // outer: 를 레이블 이라고 부르는데 그 레이블명은 아무렇게 해도 됨.
		for(;;) {
			
			System.out.print(">> 몇단볼래? => ");
			
			try {
			int dan = Integer.parseInt(sc.nextLine());    // 정수를 입력해ㅑㅇ하니까.
			
			if(2<= dan && dan <= 9) {  //해당하는 단 출력
				
				System.out.print("===" +dan+ "단 === \n");
				for(int i =0; i<9; i++) {
					System.out.println(dan+"*"+(i+1)+"="+ dan*(i+1));   // 문자열 결합 한다음에 곱하기 계산 아니야. 곱하기 먼저 하고 문자열 결합.
				}//end of for----------------------
				
				
				for(;;) {
				System.out.print(" >> 또 하시겠습니까?[Y/N] => ");   //올바른 답 나올 때 까지 무한반복
				String yn = sc.nextLine();    //문자 입력할거니까 형변환x
				
			//	if("n".equals(yn) || "N".equals(yn))
			//또는	
				if("n".equalsIgnoreCase(yn)) { //이콜스이그노어케이스 는 대 소 문자 가리지 않음. 똑같은 말로 받아들임. 
					sc.close();
					break outer;   //레이블을 안하면 바깥 포문을 빠져나갈 방법이 없음.  가장 바깥에서 선언 되어진 for 문을 빠져나가는 것.
				} 
				else if("y".equalsIgnoreCase(yn)) {
					
				}
				
				else {
					System.out.print(">>> Y 또는 N 만 가능합니다!! <<<");
					
				}
				  
				}//end of for----------------------	
			}
			
			
			else {
				System.out.println(">>> 2단부터 9단까지만 가능합니다 <<<");
			} 
			
			 //break;  for문에서 정답만 만나면 브레이 만나서 for문 빠져나오게 되고, 오답을 만나면 오답에서 바로 캐치문으로 넘어오고, for 문이 무한대 니까 처음으로 돌아감.
			
		} catch(NumberFormatException e) {
			System.out.println(">>> 2단부터 9단까지만 가능합니다 <<<");
		}
		
			
		
			
		}//end of for
		
		System.out.println("== 프로그램종료 == ");
		
	}//end of public static void main(String[] args)-------------------

}
