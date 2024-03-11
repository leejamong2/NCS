package jdbc.day03;

import java.util.Scanner;

public class Member_main {

	public static void main(String[] args) {
		
		MemberCtrl mctrl = new MemberCtrl();  //회원 컨트롤 하는 객체 만들었엉
		Scanner sc = new Scanner(System.in);
		
		mctrl.menu_Start(sc); //객체.클래스명  요러한 메소드를 만들거얌 ->클래스 만듬  //이 메소드가 실행->종료된다음 여기로 넘어와서 스캐너 닫고 >>프로그램종료<<되어야 하니까 그클래스에서 리턴해줌.
		
		sc.close();
		System.out.println("\n~~~프로그램 종료~~~");
		
	}//end of main

}
