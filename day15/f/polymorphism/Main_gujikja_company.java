package my.day15.f.polymorphism;

import java.util.Scanner;

public class Main_gujikja_company {

	public static void main(String[] args) {

		CommonMember[] cmbr_arr = new CommonMember[9];
		

		///////////////////////////////////////////////////
		Gujikja gu1 = new Gujikja();
		gu1.setId("eomjh");
		gu1.setPasswd("qWer1234$");
		gu1.setName("엄정화");
		gu1.setJubun("8610022");
		cmbr_arr[CommonMember.count++] = gu1;  // 굳이 커먼멤버.카운트 를 쓸필요가 없다.

		Gujikja gu2 = new Gujikja();
		gu2.setId("leess");
		gu2.setPasswd("abCd12345$");
		gu2.setName("이순신");
		gu2.setJubun("8601201");
		cmbr_arr[CommonMember.count++] = gu2;  

		Gujikja gu3 = new Gujikja();
		gu3.setId("chaew");
		gu3.setPasswd("aSdf1234$");
		gu3.setName("차은우");
		gu3.setJubun("0106203");
		cmbr_arr[CommonMember.count++] = gu3; //최종적으로 3개 쌓임. 여유2개



		///////////////////////////////////////////////////



		

		Company cp1 = new Company();
		cp1.setId("samsung");
		cp1.setPasswd("Samsung1!");
		cp1.setName("삼성");   //회사라 가정하면 영어이름도 있으니까 바꿔야함 => 메소드의 오버라이딩
		cp1.setBusiness_number("8123456789");   
		cp1.setJob_type("제조업");   
		cp1.setSeed_money(8000000000L);   
		cmbr_arr[CommonMember.count++] = cp1;


		Company cp2 = new Company();
		cp2.setId("lg");
		cp2.setPasswd("Abcd007$");
		cp2.setName("엘지");
		cp2.setBusiness_number("7123456789");   
		cp2.setJob_type("IT");   
		cp2.setSeed_money(7000000000L);
		cmbr_arr[CommonMember.count++] = cp2;


		///////////////////////////////////////////////////


		Recruit[] rc_arr = new Recruit[10];

		Recruit rc1 = new Recruit();
		rc1.setCp(cp1);  							//모집자가 누구냐
		rc1.setSubject("성실한 사무직원을 채용합니다.");
		rc1.setWork_type("사무직");  				//모집분야가 뭐냐
		rc1.setCnt(2);							//몇명뽑을거
		rc1.setYearpay(4000);
		rc1.setFinish_day("20241208");
		rc_arr[Recruit.count++] = rc1;  			// 모집공고 모을겨


		Recruit rc2 = new Recruit();
		rc2.setCp(cp2);  							//모집자가 누구냐
		rc2.setSubject("우수한 기술직원을 채용합니다.");
		rc2.setWork_type("기술직");  				//모집분야가 뭐냐
		rc2.setCnt(5);							//몇명뽑을거
		rc2.setYearpay(4500);
		rc2.setFinish_day("20241207");
		rc_arr[Recruit.count++] = rc2;  			// 모집공고 모을겨


		Recruit rc3 = new Recruit();
		rc3.setCp(cp2);  //위랑 같은회사에서 뽑는것  		//모집자가 누구냐
		rc3.setSubject("성실한 영업직원을 채용합니다.");
		rc3.setWork_type("영업직");  				//모집분야가 뭐냐
		rc3.setCnt(10);							//몇명뽑을거
		rc3.setYearpay(5000);
		rc3.setFinish_day("20241202");
		rc_arr[Recruit.count++] = rc3;  			// 모집공고 모을겨

		///////////////////////////////////////////////////
	//	CommonMember cmbr = new CommonMember();
	// 	오류!! 미완성클래스(추상클래스)는 객체화(인스턴스화) 할 수 없기 떄문이다.
		
		///////////////////////////////////////////////////
		RecruitApply[] rcApply_arr = new RecruitApply[20]; 

		RecruitApply rcapply1 = new RecruitApply();
		rcapply1.setRc(rc1);  //어떤 지원서를 낼것인가
		rcapply1.setGu(gu1);  //누가
		rcapply1.setApply_motive("엄정화는 사무에 최선을 다합니다.");  //누가
		rcApply_arr[RecruitApply.count++] = rcapply1;

		RecruitApply rcapply2 = new RecruitApply();
		rcapply2.setRc(rc1);  //어떤 지원서를 낼것인가
		rcapply2.setGu(gu2);  //누가
		rcapply2.setApply_motive("이순신은 최고의 사무직 인재입니다.");  //누가
		rcApply_arr[RecruitApply.count++] = rcapply2;

		RecruitApply rcapply3 = new RecruitApply();
		rcapply3.setRc(rc2);  //어떤 지원서를 낼것인가
		rcapply3.setGu(gu3);  //누가
		rcapply3.setApply_motive("차은우는 최고의 기술을 가진 엔지니어입니다.");  //누가
		rcApply_arr[RecruitApply.count++] = rcapply3;

		RecruitApply rcapply4 = new RecruitApply();
		rcapply4.setRc(rc3);  //어떤 지원서를 낼것인가
		rcapply4.setGu(gu1);  //누가
		rcapply4.setApply_motive("엄정화는 영업의 달인입니다.");  //누가
		rcApply_arr[RecruitApply.count++] = rcapply4;

		RecruitApply rcapply5 = new RecruitApply();
		rcapply5.setRc(rc3);  //어떤 지원서를 낼것인가
		rcapply5.setGu(gu2);  //누가
		rcapply5.setApply_motive("이순신은 판매왕 입니다.");  //누가
		rcApply_arr[RecruitApply.count++] = rcapply5;

/////////////////////////////////////////////////////////////////////

		Scanner sc = new Scanner(System.in);
		Ctrl_common ctrl_common = new Ctrl_common();
		Ctrl_gujikja ctrl_gu = new Ctrl_gujikja();
		Ctrl_company ctrl_cp = new Ctrl_company();

		String str_menuno = "";
		do {//4번 할때까지 돌거야
			ctrl_common.main_menu();  //메인메뉴 보여줌
			str_menuno = sc.nextLine();

			switch (str_menuno) {
			case "1":   //구직자회원가입
				ctrl_gu.register(sc, cmbr_arr);  //(sc, gu_arr) gu_arr에 저장해야해서 
				break;

			case "2":   //구인회사 회원가입
				ctrl_cp.register(sc, cmbr_arr);// 회원저장소에서 꺼내올거니까 gu_arr		
				break;

			case "3":   //구직자 로그인
				CommonMember login_gu = ctrl_common.login(sc, cmbr_arr, 1);  //ctrl_common 로 하면 껍데기는 같은데 리턴값이 다르니까 Gujikja 는 1 Company 는 2 로 해주겟다

				if(login_gu != null) {
					System.out.println(">>구직자"+ login_gu.getName() + "님 로그인 성공^^<<\n");  //메소드에 널이냐 아니냐로 작성했으니 여기서 호출하소 널이 아니면 if문 실행, 널이면 else실행. 

					ctrl_gu.gu_menu(sc, (Gujikja)login_gu, cmbr_arr, rc_arr, rcApply_arr);
				}
				else {
					System.out.println(">> 구직자로 로그인 실패 ㅜㅜ <<\n");
				}

				break;

			case "4" :	//구인회사 로그인
				CommonMember login_cp = ctrl_common.login(sc, cmbr_arr, 2);  //ctrl_common 로 하면 껍데기는 같은데 리턴값이 다르니까 Gujikja 는 1 Company 는 2 로 해주겟다

				if(login_cp != null) {
					System.out.println(">>구직자"+ login_cp.getName() + "기업 로그인 성공^^<<\n");  //메소드에 널이냐 아니냐로 작성했으니 여기서 호출하소 널이 아니면 if문 실행, 널이면 else실행. 

					ctrl_cp.cp_menu(sc, (Company)login_cp, cmbr_arr, rc_arr, rcApply_arr);  //구인회사 전용메뉴 , 모집공고저장소
				}
				else {
					System.out.println(">> 구인회사 로그인 실패 ㅜㅜ <<\n");
				}

				break;

			case "5" :	//프로그램 종료

				break;

			default:
				System.out.println("[경고]메뉴에 없는 번호입니다.\n");
				break;
			}//end of switch----------------------------

		} while (!("5".equals(str_menuno)));  //(탈출조건)
		//end of dowhile------------------------------

		sc.close();
		System.out.println("\n>>>프로그램 종료<<<");





	}//end of-----------------------------------------

}
