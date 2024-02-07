package my.day07.c.random;

import java.util.Random;
import java.util.Scanner;

public class Main_gawibawibo_3 {

	public static void main(String[] args) {
	
		/*
		   ============= 메뉴 ==============
		   1.가위 2.바위 3.보 4.게임종료
		   ================================
		   >> 선택하세요 => 5엔터
		   [경고] 메뉴에 존재하지 않는 번호입니다!!
		   
		   >> 선택하세요 => 똘똘이엔터
		   [경고] 정수로만 입력하세요!!
		   
		   >> 선택하세요 => 2
		   >> 사용자님이 이겼습니다!!^^   이긴경우
		   >> 사용자님이 졌습니다ㅜㅜ     진경우
		   >> 비겼습니다~~             비긴경우
		   
		   ============= 메뉴 ==============
		   1.가위 2.바위 3.보 4.게임종료
		   ================================
		   >> 선택하세요 => 4
		   
		   >> 프로그램 종료 <<
		 */
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		int choice_num = 0;
		do {
			System.out.println(" ============= 메뉴 ==============\r\n"
					+ "	 1.가위 2.바위 3.보 4.게임종료\n"
					+ " ================================");
			System.out.println(">> 선택하세요 => ");
			
			try {
				choice_num = Integer.parseInt(sc.nextLine());
				
				
				
				
				if(!(1<=choice_num && choice_num<=4)) {
					System.out.println("[경고] 메뉴에 존재하지 않는 번호입니다!!");
					continue;  //choice_num 5라면 조건문(while)으로 감  근데 ==4니까 못빠져나가고 다시 위로 올라감. choice_num 3이라면 2번째 이프문으로 넘어감.
				}
				
				
				
				int pc_num = ran.nextInt(3-1+1)+ 1;
				 //pc넘 의 랜덤수
				 // 사용자가 1 또는 2또는 3을 낸 경우
				 /*
				 	pc도 1 또는 2또는 3 중에 하나를 랜덤하게 내야한다.
				 	//처음 얼마부터 마지막 얼마까지 랜덤한 정수
					// ==> rndom.nextInt(마지막수 - 처음수+1) + 처음수;
				 */
					
				if(choice_num!=4) {
					//사용자가 이긴경우
					 if(choice_num==1 && pc_num==3 ||
						 choice_num==2 && pc_num==1 ||
						 choice_num==3 && pc_num==2) {
						 System.out.println(">> 사용자님이 이겼습니다!!^^");
					 }
					 
					//사용자가 진경우
					else if(choice_num==1 && pc_num==2 ||
					  choice_num==2 && pc_num==3 ||
					  choice_num==3 && pc_num==1) {
						System.out.println(">> 사용자님이 졌습니다ㅜㅜ ");
					}
					//비긴경우
					else {
								System.out.println(">> 비겼습니다~~  ");
							}
					
					
				}


			} catch( NumberFormatException e ) {
				System.out.println("[경고] 정수로만 입력하세요!!");
			}

		} while (choice_num!=4);   //4라서 여기까지 내려온건데 조건문에(4가 아닌숫자) 되어있으니까 false -> 프로그램 종료.
		sc.close();
		System.out.println(">> 프로그램 종료 <<");

	}//end of main()------------------------------------------------

}
