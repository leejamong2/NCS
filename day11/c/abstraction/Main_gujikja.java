package my.day11.c.abstraction;

import java.util.Scanner;

public class Main_gujikja {

	public static void main(String[] args) {
		
		Gujikja[] gu_arr = new Gujikja[5];
		
		///////////////////////////////////////////////////
		  Gujikja gu1 = new Gujikja();
	      gu1.userid = "eomjh";
	      gu1.passwd = "qWer1234$";
	      gu1.name = "엄정화";
	      gu1.jubun = "8610202";
	      gu_arr[Gujikja.count++] = gu1;  //초기치 0이었음
		
	      Gujikja gu2 = new Gujikja();
	      gu2.userid = "leess";
	      gu2.passwd = "abCd12345$";
	      gu2.name = "이순신";
	      gu2.jubun = "8601201";
	      gu_arr[Gujikja.count++] = gu2;  
	      
	      Gujikja gu3 = new Gujikja();
	      gu3.userid = "chaew";
	      gu3.passwd = "aSdf1234$";
	      gu3.name = "차은우";
	      gu3.jubun = "0106203";
	      gu_arr[Gujikja.count++] = gu3; //최종적으로 3개 쌓임. 여유2개
	      ///////////////////////////////////////////////////
	      
	      Scanner sc = new Scanner(System.in);
	      Ctrl_gujikja ctrl = new Ctrl_gujikja();
	      
	      String str_menuno = "";
	      do {//4번 할때까지 돌거야
			ctrl.main_menu();  //메인메뉴 보여줌
			str_menuno = sc.nextLine();
			
			switch (str_menuno) {
				case "1":   //구직자회원가입
					ctrl.register(sc, gu_arr);  //(sc, gu_arr) gu_arr에 저장해야해서 
					break;
					
				case "2":   //구직자모두보기
					ctrl.view_all_info(gu_arr); // 회원저장소에서 꺼내올거니까 gu_arr		
					break;
					
				case "3":   //검색하기	
					ctrl.search_menu(sc, gu_arr);
					break;
					
				case "4" :	//프로그램 종료
					
					break;
					
				default:
					System.out.println("[경고]메뉴에 없는 번호입니다.\n");
					break;
			}//end of switch----------------------------
			
		} while (!("4".equals(str_menuno)));  //(탈출조건)
	      //end of dowhile------------------------------
	      
	      sc.close();
	      System.out.println("\n>>>프로그램 종료<<<");
	      
	      
	      
	      
		
	}//end of-----------------------------------------

}
