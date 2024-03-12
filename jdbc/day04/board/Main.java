package jdbc.day04.board;

import java.util.Scanner;

import jdbc.day04.board.controller.Controller;

public class Main {

	public static void main(String[] args) {  // 요 메인 클래스에서는 프로그램의 시작 끝 만듬
		
		Controller ctrl = new Controller(); 
		Scanner sc =new Scanner(System.in);
		
		ctrl.menu_Start(sc);
		
		sc.close();
		System.out.println("프로그램 종료");

	}//end of main------------------------------------------------

}
