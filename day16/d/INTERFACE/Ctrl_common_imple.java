package my.day16.d.INTERFACE;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ctrl_common_imple implements Ctrl_common{

	// == 시작화면 (메인메뉴)를 보여주는 메소드 생성하기 == //
	@Override
	public void main_menu() {
		System.out.println("\n === 메인메뉴 === \n"
				+ "1.구직자 회원가입   2.구인회사 회원가입   3.구직자 로그인   4.구인회사 로그인\n "
				+ "5.프로그램 종료\n");
		System.out.print("※메뉴번호 선택 : ");
	}//end of void main_menu---------------------
	
	
	// == 구직자 및 구인회사 로그인 메소드 생성하기 == //
	@Override
	public CommonMember login(Scanner sc, CommonMember[] cmbr_arr, int type) {  //리턴값을 구직자로 주든 컴패니든 둘 다 받아야함
		
		System.out.println("● ID : ");
		String id = sc.nextLine();
		
		System.out.println("● 비밀번호 : ");
		String passwd = sc.nextLine();
		
		for(int i=0; i<CommonMember.count; i++) {
			
			if(cmbr_arr[i].getType() == type &&
			   cmbr_arr[i].getId().equals(id) &&
			   cmbr_arr[i].getPasswd().equals(passwd)) {
				return cmbr_arr[i];
			}
					
					
		}//emd of for --------------------------------------------
		
		return null;  //안맞는 경우(로그인 실패)
		
		
	}//end of public CommonMember login(Scanner sc, CommonMember[] cmbr_arr, int type)
	

	
}
	
	

