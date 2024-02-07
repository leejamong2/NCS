package my.day16.d.INTERFACE;

import java.util.Scanner;

public interface Ctrl_gujikja {

	// == 구직자(Gujikja) 신규 회원가입시
	//                클래스의 필드의 요구사항에 모두 맞으면
	//CommonMember[] cmbr_arr에 저장시켜주는 메소드 생성하기 ==
	 void register(Scanner sc, CommonMember[] cmbr_arr);  //레지스터는 회원가입 시켜주는 메소드

	// === 구직자 전용메뉴 메소드 생성하기 === //
	void gu_menu(Scanner sc, Gujikja_imple login_gu,  CommonMember[] cmbr_arr, my.day16.d.INTERFACE.Recruit[] rc_arr, RecruitApply[] rcApply_arr); 
			
	 
}
