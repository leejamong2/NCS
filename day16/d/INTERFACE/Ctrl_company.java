package my.day16.d.INTERFACE;

import java.util.Scanner;

	interface Ctrl_company {


		void register(Scanner sc, CommonMember[] cmbr_arr);
	
		
		//구인회사 전용메뉴
		void cp_menu(Scanner sc, Company_imple login_cp, CommonMember[] cmbr_arr, Recruit[] rc_arr, RecruitApply[] rcApply_arr);
	
		
		
		
}
