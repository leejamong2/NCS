package my.day15.c.overriding_overloading;

import java.text.DecimalFormat;
import java.util.Scanner;

import my.util.MyUtil;

public class Ctrl_gujikja extends Ctrl_common{

	
	// == 구직자(Gujikja) 신규 회원가입시
	//                클래스의 필드의 요구사항에 모두 맞으면
	//Gujikja[] gu_arr에 저장시켜주는 메소드 생성하기 ==
	void register(Scanner sc, Gujikja[] gu_arr) { //레지스터는 회원가입 시켜주는 메소드
		
		if(Gujikja.count < gu_arr.length) { //지금까지 생성된 구직자 회원수가 gu_arr.length(배열길이==>정원) 보다 적을 경우에만 신규회원을 받아들인다.
			
			
			Gujikja gu = new Gujikja();
			// 아이디 는 필수 입력사항이므로
			outer:
			do {
				System.out.println("1. 아이디 : ");
				String id = sc.nextLine();
				
				//중복 아이디 검사하기 시작//
				for(int i=0; i<Gujikja.count; i++) {
					
					if(id.equals(gu_arr[i].getId())) {  //내가 입력한 아이디와 저장된 아이디가 같냐
						System.out.println(">>이미 사용중인 아이디이므로 다른 아이디값을 입력하세요");
						continue outer;
					}
					
					
				}//end of for---------------
				
				
				//중복 아이디 검사하기 끝//
				
				gu.setId(id);
				
				
			}while(!(gu.getId()!=null));
			
			
					
					
					
					
/*			boolean isUse_userid;  //유저아이디가 사용가능한가
			do {
				isUse_userid = true; // do안에서 초기화 해줘야 불린값들이 바뀌지 않음.  지역변수라 선언해주고 안에다 초기화하기
				System.out.print("1.아이디 : ");
				userid = sc.nextLine();  //사용중인 엄정화 이순신 차은우 라는 아이디는 입력 불가
												//"" 또는  "      " 공백만으로는 입력불가
				//배열길이5만큼 뺑뺑이 검사하면 안돼. 여유 두개는 null값이기 때문에 null.이란건 없음  3개만 비교하면됨
				//== 가입된 회원들에 대해 중복아이디 검사기 ==//
			//	if(userid.trim().isEmpty())  //JDK 1.8
				if(userid.isBlank()){		//JDK 11
					System.out.println(">>아이디는 필수 입력사항입니다.<<\n");
					isUse_userid = false;   //유저아이디가 사용가능한가
				}
				else {
					
					for(int i=0; i<Gujikja.count; i++) {
						if(userid.equals(gu_arr[i].getUserid()) ) { //0~2까지 유저아이디가 동일한가
							System.out.println(">>이미 사용중인 아이디 입니다.");
							isUse_userid = false; 
							break;  //동일하지 않음 빠져나오기
						}
					}//end of for---------------------------------
					
					
				//isUse_userid = true;
				}
			}while(!isUse_userid);
			//end of dowhile------------------------------
			
*/			
			
			// 비밀번호는 필수 입력사항이므로
			do {
				System.out.println("2.비밀번호 : ");
				String passwd = sc.nextLine();
				
				gu.setPasswd(passwd);
				
				
				}while(!(gu.getPasswd()!=null));
			
		
			// 성명은 필수 입력사항이므로 그냥 엔터나 공백만으로 된 것이 아닐때 까지 반복해야 한다.
			// 성명은 2글자 이상 6글자 이하의 한글로만 되어져야 한다.
			do {
				System.out.println("3.성명 : ");
				String name = sc.nextLine();
				
				gu.setName(name);
				
				
				}while(!(gu.getName()!=null));
			
			// 주민번호는 필수 입력사항이면서 주민번호 조건에 맞을때 까지 반복해야 한다.
			do {
				System.out.println("4.주민번호 : ");
				String jubun = sc.nextLine();
				
				gu.setJubun(jubun);
				
				
				}while(!(gu.getName()!=null));
			
			
			///////////////////////////////////////
			
			
			gu_arr[Gujikja.count++] = gu;
			
			System.out.println(">>구직자 회원가입 성공");
			
		}
		else {//지금까지 생성된 구직자 회원수가 gu_arr.length(배열길이==>정원) 와 같거나 큰 경우에 신규회원을 받아들이면 안된다.
			System.out.println(">>정원 " + gu_arr.length + "명이 꽉 차서 구직자 회원가입이 불가합니다.<< \n");
		}
		
		
	}//end of void register(Scanner sc, Gujikja[] gu_arr)---------------------




		//구직자 로그인 메소드 생성하기 //
		public Gujikja login(Scanner sc, Gujikja[] gu_arr) {
			
			System.out.print("● 구직자 ID : ");
			String id = sc.nextLine();
			
			System.out.print("● 구직자 비밀번호 : ");
			String passwd = sc.nextLine();
			
			for(int i=0; i<Gujikja.count; i++) {
				
				if(id.equals(gu_arr[i].getId()) &&
				   passwd.equals(gu_arr[i].getPasswd()) ){
					return gu_arr[i];
				}
				
			}//end of for-----------------------------------------------------------
			
			
			return null;
		}//end of public Gujikja login(Scanner sc, Gujikja[] gu_arr)-------------------------------------------




		// === 구직자 전용메뉴 메소드 생성하기 === //
		public void gu_menu(Scanner sc, Gujikja login_gu, Company[] cp_arr, Recruit[] rc_arr, RecruitApply[] rcApply_arr) {
			String str_menuno;
			do {
				System.out.println("\n === 구직자 전용메뉴("+login_gu.getName()+"님 로그인중) === \n"
									+ "1.내정보 보기   2.내정보 수정   3.모든 구인회사 조회  4.구인회사검색하기\n"
									+ " 5.모든채용공고조회	6.채용응모하기	7.채용응모한것조회	8.로그아웃\n ");
				System.out.print("※메뉴번호 선택 : ");
				str_menuno = sc.nextLine();
				
				switch (str_menuno) {
				case "1":  //내 정보 보기
					view_myInfo(login_gu);
					break;
				case "2":  //내 정보 수정
					update_myInfo(sc, login_gu);  //리턴타입 모써야할까?  보이드.  보여주면 끝나니까
					break;
				case "3":  //모든구인회사 조회
					view_company_info(cp_arr); //메소드의 오버로딩. 파라미터 다름
					break;
				
				case "4": //구인회사검색하기
					view_company_info(sc, cp_arr); //오버로딩. 파라미터 다름
					break;
				
				case "5": //모든채용공고조회
					view_all_recruit_info(rc_arr);
					break;				
					
				case "6": //채용응모하기
					input_recruitApply(sc, login_gu, rc_arr, rcApply_arr);  //rc_arr 공고저장소,  rcApply_arr 응모저장소
					break;
					
				case "7": //채용응모한것조회
					view_my_recruitApply(login_gu, rcApply_arr);
					break;
					
				case "8":  //로그아웃
					login_gu = null;
					break;
					
				default:
					System.out.println(">>[경고]선택하신 번호는 메뉴에 없습니다.");
					break;
				}//end of switch----------------------------
				
			}while(!"8".equals(str_menuno));
			//end of dowhile-------------------------------------
			
			
			System.out.println(">> 로그아웃 되었습니다.<<\n");
		}//end of public void gu_menu(Scanner sc, Gujikja login_gu, Company[] cp_arr)-------------------------





		




		// 내 정보 보기//
		private void view_myInfo(Gujikja login_gu) {  //접근제한자가 프라이빗으로 되어있어서 다른 클래스에서 호출 못함. 구직자전용메뉴 gu_menu를 통해서만 볼 수 있다.
			
			System.out.println(login_gu.getName()+"님의 정보");
			System.out.println("-".repeat(50));
			System.out.println("아이디   비밀번호       성명        주민번호");
			System.out.println("-".repeat(50));
			System.out.println(login_gu.getId()+"\t"+
							   login_gu.getPasswd()+"\t"+
							   login_gu.getName()+"\t"+
							   login_gu.getJubun());
			/*
		 	엄정화님의 정보
		 	-----------------------------------
		 	아이디   비밀번호       성명        주민번호   
		 	-----------------------------------
		 	eomjh  qWer1234$  엄정화      8610202
		 */
			
		}//end of private void view_myInfo(Gujikja login_gu)-------------------
		
		
		// 내 정보 수정하는 메소드 생성하기 //
		private void update_myInfo(Scanner sc, Gujikja login_gu) {
			String new_passwd = "";
			
			
			view_myInfo(login_gu);  //파라미터엔 로그인된 구직자 정보들어오면됨
			
			System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터 값을 그대로 사용하시려면 그냥 엔터하세요!\n");
			
			boolean exit_ok = false;
			do {
			System.out.println("1.비밀번호 : ");
			new_passwd = sc.nextLine();  //원래qWer1234$ 비밀번호를 qWer0070$ 로 변경하려고 한다.
												//원래qWer1234$ 비밀번호를 qWer1234$ 현재비밀번호로 변경하려고 하면 기존과 동일하므로 변경 불가하다.
												//원래qWer1234$ 비밀번호를 변경하기 싫다.
												//원래qWer1234$ 비밀번호를 abcd 로 변경하고자 할 때는 비밀번호 정책에 맞지 않으므로 불가.
				if(!new_passwd.equals("")) {  //입력한 비밀번호가 엔터가 아닐 경우  
					
				}
				else { 
					login_gu.setPasswd(new_passwd);  //비밀번호를 프라이빗으로 해놔서 직접적으로 볼수없으니 겟셋으로 해야함 //비밀번호정책에 맞아야하니까 setPasswd불러오기
				}
				
					if(login_gu.getPasswd().equals(new_passwd)) {  //비밀번호를 프라이빗으로 해놔서 직접적으로 볼수없으니 겟셋으로 해야함
						System.out.println("기존 암호와 동일하므로 변경 불가합니다.");
					}
				else {//입력한 비밀번호가 엔터일 경우   //나는 안바꾸고싶어서 엔터칠건데 setPasswd경로를 가보면 널값이거나 길이가 안맞으면 꽝이라고 해놨으니 폴스로떨어지고 못바꾸니까 if문 적기.
					exit_ok = true;  //빠져나가지
				}
			
			}while(!exit_ok);
			//end of dowhile------------------------------------
			
			
			
			
		exit_ok = false;  //초기화
		do {
				System.out.println("2.성명 : ");
				String new_name = sc.nextLine();//원래 엄정화 성명을 엄화정 으로 변경하려고 한다.
												//원래 엄정화 성명을 엄정화 현재이름으로 변경하려고 하면 기존과 동일하므로 변경 불가하다.
												//원래 엄정화 성명을 변경하기 싫다.
												//원래 엄정화 성명을 엄JungHwa로 변경하고자 할 때는 성명정책에 맞지 않으므로 불가.
				if(!new_name.equals("")) {  //입력한 비밀번호가 엔터가 아닐 경우  

				}
				else { 
					login_gu.setName(new_name);  //비밀번호를 프라이빗으로 해놔서 직접적으로 볼수없으니 겟셋으로 해야함 //비밀번호정책에 맞아야하니까 setPasswd불러오기
				}
				if(login_gu.getName().equals(new_name)) {  //비밀번호를 프라이빗으로 해놔서 직접적으로 볼수없으니 겟셋으로 해야함
					System.out.println("기존 이름과 동일하므로 변경 불가합니다.");
				}
				else {//입력한 비밀번호가 엔터일 경우   //나는 안바꾸고싶어서 엔터칠건데 setPasswd경로를 가보면 널값이거나 길이가 안맞으면 꽝이라고 해놨으니 폴스로떨어지고 못바꾸니까 if문 적기.
					exit_ok = true;  //빠져나가지
				}
			
		
		}while(!exit_ok);
		
		
		
		
		
		exit_ok = false;  //초기화
		do {
			System.out.println("3.주민번호 : ");
			String new_jubun = sc.nextLine();//원래 엄정화 성명을 엄화정 으로 변경하려고 한다.
											//원래 엄정화 성명을 엄정화 현재이름으로 변경하려고 하면 기존과 동일하므로 변경 불가하다.
											//원래 엄정화 성명을 변경하기 싫다.
											//원래 엄정화 성명을 엄JungHwa로 변경하고자 할 때는 성명정책에 맞지 않으므로 불가.
			if(!new_jubun.equals("")) {  //입력한 가 엔터가 아닐 경우  

			}
			else { 
				login_gu.setJubun(new_jubun);  //비밀번호를 프라이빗으로 해놔서 직접적으로 볼수없으니 겟셋으로 해야함 //비밀번호정책에 맞아야하니까 setPasswd불러오기
			}
			if(login_gu.getJubun().equals(new_jubun)) {  //비밀번호를 프라이빗으로 해놔서 직접적으로 볼수없으니 겟셋으로 해야함
				System.out.println("기존 이름과 동일하므로 변경 불가합니다.");
			}
			else {//입력한 비밀번호가 엔터일 경우   //나는 안바꾸고싶어서 엔터칠건데 setPasswd경로를 가보면 널값이거나 길이가 안맞으면 꽝이라고 해놨으니 폴스로떨어지고 못바꾸니까 if문 적기.
				exit_ok = true;  //빠져나가지
			}
		
	
		}while(!exit_ok);
		
	}//end of private void update_myInfo(Scanner sc, Gujikja login_gu)----------------------------
		
		
		
		
		
		//모든구인회사 조회
		private void view_company_info(Company[] cp_arr) {
			
			if(Company.count == 0) { 
				System.out.println(">> 구인회사로 등록된 회사가 한개도 없습니다. <<");
			}
			else {
				title_company();
				
				StringBuilder sb = new StringBuilder();
				
				for(int i=0; i<Company.count; i++) {
					sb.append(cp_arr[i].getInfo()+"\n"); //스트링 타입으로 할거야 정보 쌓아지면 스트링빌더써야되니까
				}//end of for-----------------
				
				System.out.println(sb.toString()); //쌓은걸 출력해라
			}
			
		}//end of private void view_all_company_info(Company[] cp_arr)------------------------




		
		private void title_company() {
			
			System.out.println("=".repeat(70));
			System.out.println(" 회사명   업종   사업자등록번호   자본금 \n");
			System.out.println("=".repeat(70));
			
					  
			
		}//end of private void title_company()---------------------------------
		
		
		
		
		//구인회사검색하기 메뉴 메소드 만들기
		private void view_company_info(Scanner sc, Company[] cp_arr) {
			
				String str_menuno;
				do {
					System.out.print("※>>> 구인회사 검색메뉴 <<< : ");
					System.out.println( "\n 1.업종검색   2.자본금검색   3.구직자메뉴로 돌아가기 \n ");
					System.out.print("※검색메뉴번호 입력 : ");
					str_menuno = sc.nextLine();
					
					switch (str_menuno) {
					case "1":  //업종검색
						search_jobtype_company(sc, cp_arr);
						break;
					case "2":  //자본금검색
						search_seedmoney_company(sc, cp_arr);  //리턴타입 모써야할까?  보이드.  보여주면 끝나니까
						break;
					case "3":  //구직자메뉴로 돌아가기
						
						break;
					
					default:
						System.out.println(">>[경고]선택하신 번호는 메뉴에 없습니다.");
						break;
					}//end of switch----------------------------
					
				}while(!"3".equals(str_menuno));
				//end of dowhile-------------------------------------
				System.out.println(">> 구직자메뉴로 돌아갑니다.<<\n");
		}//end of private void search_company(Scanner sc, Company[] cp_arr)-------------------




		// 업종검색
		private void search_jobtype_company(Scanner sc, Company[] cp_arr) {
			
			System.out.print("▷ 업종명 : ");
			String job_type_name = sc.nextLine().toLowerCase();
			
			StringBuilder sb = new StringBuilder();
			boolean is_existence = false;
			for(int i=0; i<Company.count; i++) {
				if(cp_arr[i].getJob_type().toLowerCase().contains(String.join("", job_type_name.split("\\ ")))) {
					is_existence = true;
					sb.append(cp_arr[i].getInfo()+"\n");
				}
			}// end of for----------------------------
			
			if(is_existence) {
				title_company();
				System.out.println(sb.toString());
			}
			else {
				System.out.println(">> 검색하시려는 "+ job_type_name +"업종에 해당하는 회사는 없습니다.!!\n");
			}
			
		}// end of private void search_jobtype_company(Company[] cp_arr)------
		
		
		
		
		
		
	
		
		
		// 자본금검색
		   private void search_seedmoney_company(Scanner sc, Company[] cp_arr) {
		      
		      System.out.print("▷ 자본금 : ");
		      String str_search_seed_money = sc.nextLine();
		      
		      try {
		         long search_seed_money = Long.parseLong(str_search_seed_money);
		         
		         StringBuilder sb = new StringBuilder();
		         boolean is_existence = false;
		         
		         for(int i=0; i<Company.count; i++) {
		            if( search_seed_money <= cp_arr[i].getSeed_money() ) {
		               is_existence = true;
		               sb.append(cp_arr[i].getInfo()+"\n");
		            }
		         }// end of for----------------------------
		         
		         if(is_existence) {
		            title_company();
		            System.out.println(sb.toString());
		         }
		         else {
		            System.out.println(">> 검색하시려는 자본금이 "+ str_search_seed_money +"원 이상인 회사는 없습니다.!!\n");
		         }
		         
		      } catch(NumberFormatException e) {
		         System.out.println(">>[경고] 자본금은 정수로만 입력하세요!!<< \n");
		      }
		      
		   }// end of private void search_seedmoney_company(Company[] cp_arr)------
		
		   
		   
   //모든채용공고조회
   private void view_all_recruit_info(Recruit[] rc_arr) {
	   if(Recruit.count == 0) {
		   System.out.println(">>채용공고가 1개도 없습니다.<<\n");
	   }
	   else {		   
		   StringBuilder sb = new StringBuilder();
		   
		   for(int i=0; i<Recruit.count; i++) {
			   sb.append(rc_arr[i].getRecruit_no()+"\t\t"+
					   	 rc_arr[i].getCp().getName()+"\t"+ //리크루트에서 컴패니필드를 꺼내고 그 컴패니에서 상속받은 네임필드를 가져옴.
					     rc_arr[i].getCp().getJob_type()+"\t"+
					   	 new DecimalFormat("#,###").format(rc_arr[i].getCp().getSeed_money())+"원\t"+
					     rc_arr[i].getWork_type()+"\t"+
					     rc_arr[i].getCnt()+"\t"+
					     rc_arr[i].getRegister_day().substring(0, 4)+"-"+rc_arr[i].getRegister_day().substring(4, 6)+"-"+rc_arr[i].getRegister_day().substring(6)+"\t"+
					     rc_arr[i].getFinish_day().substring(0, 4)+"-"+rc_arr[i].getFinish_day().substring(4, 6)+"-"+rc_arr[i].getFinish_day().substring(6)+"\n" );
		   }//end of for---------------------------------------------------
	   
		   System.out.println("-".repeat(90));
		   System.out.println("채용공고순번		회사명	회사직종타입	채용분야(근무형태)	채용인원	등록일자	채용마감일자");
		   System.out.println("-".repeat(90));
		   System.out.println(sb.toString());
		   System.out.println("[채용공고가 "+Recruit.count+"건이 있습니다]\n");
		   
	   }

   }//end of private--------------------------------
   
   
   
   
   	//채용응모하기
	private void input_recruitApply(Scanner sc, Gujikja login_gu, Recruit[] rc_arr, RecruitApply[] rcApply_arr) {
		
		
		//구직자 자신이 응모한 채용공고 번호를 알아오자.
		String str_my_recruit_no = "";
		for(int i=0; i<RecruitApply.count; i++) {
			if(rcApply_arr[i].getGu().getId().equals(login_gu.getId())) { //내가 한것중에서 채용공고넘버를 알아온다
				str_my_recruit_no += rcApply_arr[i].getRc().getRecruit_no()+",";
			}
		}//end of for---------------------------
		 //str_my_recruit_no = "1,2,3,";
		
		str_my_recruit_no = str_my_recruit_no .substring(0, str_my_recruit_no.length()-1);
		//"1,2,3"
		
		String[] my_recruit_no_arr =  str_my_recruit_no.split("\\,");
		// {"1", "2", "3"}
		
		if(my_recruit_no_arr.length == Recruit.count) {
			System.out.println(">>이미 모든 채용공고에 응모하셨기에 더이상 응모할 채용공고번호가 없습니다.");
			return;  //메소드 종료
		}
		
		
		
		// == 채용공고번호는 채용공고로 올라온 번호만 입력해야한다 == //
		boolean is_existance, is_duplicate_recruit_no;
		Recruit rc = null;
		do {
			is_existance = false;  //초기화
			is_duplicate_recruit_no = false;
			
			System.out.print("● 채용공고번호 : ");
			String input_recruit_no =  sc.nextLine();
			
			for(int i=0; i<Recruit.count; i++) {
				if(input_recruit_no.equals(String.valueOf(rc_arr[i].getRecruit_no())) ) {
					is_existance = true;
					rc = rc_arr[i];  //채용공고에 해당하는 번호를 넣어준다
					break;
				}
			}//end of for-------------------------- //일치하지 않는 번호를 썼을 때 포문 빠져나오고 이프문 실행.
			
			if(!is_existance) {
				System.out.println(">>입력하신 " +input_recruit_no+ "번은 채용공고에 없는 번호입니다!\n");
			}
			
			else { //입력한 번호가 공고번호에 존재한다면
				   // == 채용공고번호는 채용공고로 올라온 번호이지만 이미 응모한 채용공고번호는 입력하면 안된다 == //
				for(int i=0; i<RecruitApply.count; i++) {
					
						//	rcApply_arr[i].getRc().getRecruit_no()  //채용공고번호(int)
						//	rcApply_arr[i].getGu().getId() 			//채용공고에 지원한 구직자 아이디
					if(String.valueOf(rcApply_arr[i].getRc().getRecruit_no()).equals(input_recruit_no)&& //인트타입을 밸류오브 사용해서 스트링읋빠꿔줌
					   rcApply_arr[i].getGu().getId().equals(login_gu.getId())  ) {
						is_duplicate_recruit_no = true;
						break;
					}
				}//end of for-------------------------------------
				
				if(is_duplicate_recruit_no) {  //중복됨
					System.out.println(">>입력하신 채용공고번호 "+input_recruit_no+"번은 이미 응모하신 번호입니다.\n");
				}
				else {
					do {
						System.out.print("● 지원동기 : ");
						String apply_motive =  sc.nextLine();
						if(apply_motive.isBlank()) {
							System.out.println("[경고] 지원동기는 필수로 입력하셔야 합니다.!!\n");
						}
						else {
							RecruitApply rc_apply = new RecruitApply();
							rc_apply.setRc(rc);  //rc 는 일치하면서 중복되지않은 공고번호
							rc_apply.setGu(login_gu);
							rc_apply.setApply_motive(apply_motive);
							rcApply_arr[RecruitApply.count++] =  rc_apply;//차곡차곡 쌓아주야지
							break;
						}
					}while(true);
				}
					
			}//end of if else---------------------------
				
			
		} while (!(is_existance && !is_duplicate_recruit_no));  //!()  괄호 안에는 탈출조건을 써야함.
		
	}//end of private void input_recruitApply(Scanner sc, Gujikja login_gu, Recruit[] rc_arr, RecruitApply[] rcApply_arr)----------------
	
	
	
	
	//채용응모한것조회
	private void view_my_recruitApply(Gujikja login_gu, RecruitApply[] rcApply_arr) {
		
		boolean is_existence = false;
		
		for(int i=0; i<RecruitApply.count; i++) {
			if( login_gu.getId().equals(rcApply_arr[i].getGu().getId()) ) {
				is_existence = true;
				System.out.println(rcApply_arr[i].getRc().recruit_info());
				System.out.println("●지원동기 : "+rcApply_arr[i].getApply_motive());
			}
		}//end of for---------------------
		
		if(!is_existence) {
			System.out.println(">>채용공고에 응모한 내역이 없습니다.<</n");
		}


	}//end of private void view_my_recruitApply(Gujikja login_gu, RecruitApply[] rcApply_arr)-------


	
}

		
		
		
	
	   



		


		