package my.day11.c.abstraction;

import java.util.Scanner;

import my.util.MyUtil;

public class Ctrl_gujikja {

	// == 메인메뉴를 보여주는 메소드 생성하기 == //
	void main_menu() {
		System.out.println("\n === 메인메뉴 === \n"
				          + "1.구직자 회원가입   2.구직자 모두보기   3.검색하기   4.프로그램종료\n ");
		System.out.print("※메뉴번호 선택 : ");
	}//end of void main_menu---------------------

	
	
	
	// == 구직자(Gujikja) 신규 회원가입시
	//                클래스의 필드의 요구사항에 모두 맞으면
	//Gujikja[] gu_arr에 저장시켜주는 메소드 생성하기 ==
	void register(Scanner sc, Gujikja[] gu_arr) { //레지스터는 회원가입 시켜주는 메소드
		
		if(Gujikja.count < gu_arr.length) { //지금까지 생성된 구직자 회원수가 gu_arr.length(배열길이==>정원) 보다 적을 경우에만 신규회원을 받아들인다.
			
			String userid;
			String passwd;
			String name;
			String jubun;
			
			boolean isUse_userid;  //유저아이디가 사용가능한가
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
						if(userid.equals(gu_arr[i].userid) ) { //0~2까지 유저아이디가 동일한가
							System.out.println(">>이미 사용중인 아이디 입니다.");
							isUse_userid = false; 
							break;  //동일하지 않음 빠져나오기
						}
					}//end of for---------------------------------
					
					
				//isUse_userid = true;
				}
			}while(!isUse_userid);
			//end of dowhile------------------------------
			
			
			//비밀번호는 필수 입력사항이면서 비밀번호 조건에 맞을때까지 반복해야한다.
			boolean isUse_passwd;
			do {
				isUse_passwd = true;
				System.out.print("2.비밀번호 : ");
				passwd = sc.nextLine();  // "Qw12$"  "Qwer1234sdfsdfdsfsfsdf$"  "qwer1234$"  "qWer1234$" 
				
				if(!MyUtil.isCheckPasswd(passwd)) { //비밀번호 조건에 맞지 않으면
					System.out.println("[경고] 비밀번호는 8글자 이상 15글자 이하의 대,소문자,숫자,특수기호가 혼합되어야만 합니다.\n");
					isUse_passwd = false;
				}
				
			} while (!isUse_passwd);
			//end of while------------------------
			
			
			// 성명은 필수 입력사항이므로 그냥 엔터나 공백만으로 된 것이 아닐때 까지 반복해야 한다.
			// 성명은 2글자 이상 6글자 이하의 한글로만 되어져야 한다.
			boolean isUse_name;
			do {
				isUse_name = true;
				System.out.println("3.성명 : ");
				name = sc.nextLine();  //""     "      "  "강 감 진"  "강asd" 
				
				
				if(name.isBlank()) {
					isUse_name = false;
				}
				else {
					char[] ch_arr = name.toCharArray();
					
					if(2<ch_arr.length && ch_arr.length <=6) {
						for(int i=0; i<ch_arr.length; i++) {
							if(!('가'<=ch_arr[i] && ch_arr[i]<='힣')) {
								isUse_name = false;
								break;
							}
						}//end of for--------------------------------
						
					}
					else {
						isUse_name = false;
					}
				}
				
				
				if(!isUse_name) {
					System.out.println("[경고]성명은 공백없이 2글자 이상 6글자 이하의 한글이어야 합니다.");
				}
				
			} while (!isUse_name);
			//end of while------------------------
			
			
			
			
			//주민번호는 필수 입력사항이면서 주민번호 조건에 맞을때까지 반복해야한다.
			boolean isUse_jubun;
			do {
				isUse_jubun = true;
				System.out.print("4.주민번호 : ");
				jubun = sc.nextLine();  // "9610021"  "9610022" 정상 
										// "0010023"  "0010024" 정상
										// "9604311"  "9604312" 비정상
										// "9610025" 비정상
				
				if(!MyUtil.isCheckJubun(jubun)) { //비밀번호 조건에 맞지 않으면
					System.out.println("[경고] 올바른 주민번호를 입력하세요\n");
					isUse_jubun = false;
				}
				
			} while (!isUse_jubun);
			//end of while------------------------
			
			Gujikja gu = new Gujikja();
			gu.jubun = jubun;
			gu.passwd = passwd;
			gu.name = name;
			gu.userid = userid;
			
			gu_arr[Gujikja.count++] = gu;
			
			System.out.println(">>구직자 회원가입 성공");
			
		}
		else {//지금까지 생성된 구직자 회원수가 gu_arr.length(배열길이==>정원) 와 같거나 큰 경우에 신규회원을 받아들이면 안된다.
			System.out.println(">>정원 " + gu_arr.length + "명이 꽉 차서 구직자 회원가입이 불가합니다.<< \n");
		}
		
		
	}//end of void register(Scanner sc, Gujikja[] gu_arr)---------------------




	
	// === 구직자모두보기 메소드 === //
	void view_all_info(Gujikja[] gu_arr) {
		
		/*
		 	-----------------------------------------------------------------------
		 	아이디     비밀번호     성명      생년월일     성별   만나이      가입일자
		 	-----------------------------------------------------------------------
		 	eomjh  qWe******   엄정화     961020     여    27		2024-01-31  10:30:40 
		 	leess  abC******   이순신     960120     남    28		2024-01-31  10:30:40 
		 	chaew  aSd******   차은우     010620     남    22		2024-01-31  10:30:40
		 	----------------------------------------------------------------------- 
		 */
		
		if(Gujikja.count == 0) {
			System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
		}
		else {
			title();  //검색할때 타이틀을 다시 쓰기위해 밑에 메소드 만듬  //회원정보있으면 타이틀만들어준다는말
			StringBuilder sb = new StringBuilder();
		
			for(int i=0; i<Gujikja.count; i++) {  //Gujikja.count  이순신 엄정화 차은우 디폴트값3명
				sb.append(gu_arr[i].getInfo()+"\n"); //gu_arr[i]구직자의 인스턴스들(eomjh  qWe******   엄정화     961020     여    27		2024-01-31  10:30:40 )을 보여주는 메소드 밑에 만듬
			}//end of for-------------------------------
			System.out.println(sb.toString());
		}
		
		
		
	}//end of void view_all_info -------------------------------------
	
	
	void title() {
		System.out.println("-".repeat(70)+"\n"
						  +"아이디     비밀번호          성명     생년월일   성별    만나이      가입일자 \n"
						  +"-".repeat(70));
	}//end of void title()----------------------------------------------------- 




	
	
	
	// == 검색하기 메뉴를 보여주는 메소드 생성하기 == //
	 void search_menu(Scanner sc, Gujikja[] gu_arr) {
		 
		 String str_mununo = "";
		 do {
			 System.out.println("\n === 검색메뉴 === \n"
					 			+ "1.연령대   2.성별   3.연령대 및 성별   4.메인메뉴로 돌아가기\n ");
			 System.out.print("※ 검색메뉴번호 선택 : ");
			
			 str_mununo = sc.nextLine();
			 
			 switch (str_mununo ) {
			 case "1": //연령대검색
				search_ageLine(sc, gu_arr);
				break;
				
			 case "2": //성별검색
				 search_gender(sc, gu_arr);
					break;
					
			 case "3": //연령대 및 성별검색
				 search_ageLine_gender(sc, gu_arr);
				 
					break;
					
			 case "4": //메인메뉴로 돌아가기
					
					break;

			 default:
				 System.out.println("[경고] 검색메뉴에 존재하는 번호만 입력하세요!!\n");
				break;
			}//end of switch--------------------------------------------
			 
			 
		 } while (!"4".equals(str_mununo));
		 //end of dowhile--------------
		 
	}//end of void search_menu(Scanner sc, Gujikja[] gu_arr) -----------------------------





	// == 연령대 검색해주는 메소드 == //
	void search_ageLine(Scanner sc, Gujikja[] gu_arr) {
		
		if(Gujikja.count == 0) {
					System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
		}
		
		else {  //구직자가 존재하는 경우
			
			String str_ageLine = "";
			boolean isUse_ageLine = false;
			do {
			System.out.print("※ 검색하고자 하는 연령[예: 20] => ");
			str_ageLine = sc.nextLine();  		//"0"  "20"  "30"  "40"  "50"  "60"  "70"  "80"대 정상
												//"25"  "강아지"  "-20"대  비정상
			 switch (str_ageLine) {
				case "0" : 
				case "20": 
				case "30": 
				case "40":  
				case "50":      
				case "60":
				case "70":
				case "80":
					isUse_ageLine = true;
					break;
		
				default:
					System.out.println("[경고] 올바른 연령대를 입력하세요!!\n");
					break;
			 }//end of switch----------------------------------
				
			} while (!isUse_ageLine);
			
			
			// == 입력받은 연령대에 해당하는 구직자 찾기 == //
			StringBuilder sb = new StringBuilder();
			boolean isSearch = false;
			
			for(int i=0; i<Gujikja.count; i++) {
				int ageLine = gu_arr[i].getAge()/10*10;
				//                  나이/10*10 
				//                  26/10*10 ==> 20
				
				if(Integer.parseInt(str_ageLine) == ageLine) { //입력한 값이랑 연령대랑 일치
					isSearch = true;
					sb.append(gu_arr[i].getInfo()+"\n");
				}
				
			}//end of for--------------------------
			
			if(isSearch) {
				title();
				System.out.println(sb.toString());
			}
			else {
				System.out.println("[검색결과 연령대" +str_ageLine+"대인 구직자는 없습니다]\n");
			}
			
		}//end of ifelse----------------------
		
	}//end of void search_ageLine(Scanner sc, Gujikja[] gu_arr)---------------------
	
	
	
	
	
	// == 성별 검색해주는 메소드 == //
		void search_gender(Scanner sc, Gujikja[] gu_arr) {
			if(Gujikja.count == 0) {
				System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
			}

			else {  //구직자가 존재하는 경우
				
				String input_gender = "";
				boolean isUse_input_gender = false;  //입력받은 이 문자(input_gender)가 쓸 수 있냐
				do {
				System.out.print("※ 검색하고자 하는 성별[남/여] => ");
				input_gender = sc.nextLine();  		//"남"  "여"  "  남"  "  여"  "  남  "  "  여  "  정상
													//""  "      "  "강아지"   비정상
				 switch (input_gender.trim()) {  //우선 입력받은 문자의 공백을 다 지우기
					case "남": 
					case "여": 
					
						isUse_input_gender = true;
						input_gender = input_gender.trim();  //공백을 뺀 나머지를 빼고 input_gender여기에 넣고 빠져나온다
						break;
			
					default:
						System.out.println("[경고] 남 또는 여만 입력하세요. \n");
						break;
				 }//end of switch----------------------------------
					
				} while (!isUse_input_gender);
				
				
				// == 입력받은 성별에 해당하는 구직자 찾기 == //
				StringBuilder sb = new StringBuilder();
				boolean isSearch = false;
				
				for(int i=0; i<Gujikja.count; i++) {
					
					if(input_gender.equals(gu_arr[i].getGender()) ) { //내가 쓴 성별과 일치하는 회원이 있다면
						isSearch = true;
						sb.append(gu_arr[i].getInfo()+ "\n"); //sb그 회원을 쌓아줄어야. 어디에? 겟인포 아래 회원배열에.
					}
					
				}//end of for--------------------------
				
				if(isSearch) {
					title();
					System.out.println(sb.toString());
				}
				else {
					System.out.println("[검색결과 성별" +input_gender+"자 회원은 없습니다]\n");
				}
			}//end of----------------------------------
	
	
		}//end of void search_gender()-------------------------------------------------
	
		
		
		
		
		
		
		// === 연령대 및 성별 검색해주는 메소드 === //
		 void search_ageLine_gender(Scanner sc, Gujikja[] gu_arr) {
		 
			 if(Gujikja.count == 0) {
					System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
					return;
		}
		
		else {  //구직자가 존재하는 경우
			
			String str_ageLine = "";
			boolean isUse_ageLine = false;
			do {
			System.out.print("※ 검색하고자 하는 연령[예: 20] => ");
			str_ageLine = sc.nextLine();  		//"0"  "20"  "30"  "40"  "50"  "60"  "70"  "80"대 정상
												//"25"  "강아지"  "-20"대  비정상
			 switch (str_ageLine) {
				case "0" : 
				case "20": 
				case "30": 
				case "40":  
				case "50":      
				case "60":
				case "70":
				case "80":
					isUse_ageLine = true;
					break;
		
				default:
					System.out.println("[경고] 올바른 연령대를 입력하세요!!\n");
					break;
			 }//end of switch----------------------------------
				
			} while (!isUse_ageLine);
			
			
			// == 입력받은 연령대에 해당하는 구직자 찾기 == //
		//	StringBuilder sb = new StringBuilder();    성별까지 보고 쌓아줘야되니까 여기에 쓰면 안됨
			boolean is_ageline_Search = false;
			
			for(int i=0; i<Gujikja.count; i++) {
				int ageLine = gu_arr[i].getAge()/10*10;
				//                  나이/10*10 
				//                  26/10*10 ==> 20
				
				if(Integer.parseInt(str_ageLine) == ageLine) { //입력한 값이랑 연령대랑 일치
					is_ageline_Search = true;
					break;  //찍어주기 위함이 아닌 일치하는 연령대 하나라도 있는지 확인하기 위함이라 찾으면 바로빠져나오기
				//	sb.append(gu_arr[i].getInfo()+"\n");  성별까지 보고 쌓아줘야되니까 여기에 쓰면 안됨
				}
				
			}//end of for--------------------------
			
			if(!is_ageline_Search) { //검색하고자 하는 연령대에 해당하는 구직자가 존재하지않는 경우
				System.out.println("[검색결과 연령대" +str_ageLine+"대인 구직자는 없습니다]\n");
				return;
			}
			else {//검색하고자 하는 연령대에 해당하는 구직자가 존재하는 경우
				
				// === 성별 검색 시작 === //
				String input_gender = "";
				boolean isUse_input_gender = false;  //입력받은 이 문자(input_gender)가 쓸 수 있냐
				do {
				System.out.print("※ 검색하고자 하는 성별[남/여] => ");
				input_gender = sc.nextLine();  		//"남"  "여"  "  남"  "  여"  "  남  "  "  여  "  정상
													//""  "      "  "강아지"   비정상
				 switch (input_gender.trim()) {  //우선 입력받은 문자의 공백을 다 지우기
					case "남": 
					case "여": 
						isUse_input_gender = true;
						input_gender = input_gender.trim();  //공백을 뺀 나머지를 빼고 input_gender여기에 넣고 빠져나온다
						break;
			
					default:
						System.out.println("[경고] 남 또는 여만 입력하세요. \n");
						break;  // 다른 값입력하기 전까지 뺑뺑이돌리는것.
				 }//end of switch----------------------------------
					
				} while (!isUse_input_gender);
				
				
				// == 입력받은 연령대 및 성별에 해당하는 구직자 찾기 == //
				StringBuilder sb = new StringBuilder();
				boolean is_ageline_gender_Search = false;
				
				for(int i=0; i<Gujikja.count; i++) {
					
					if(Integer.parseInt(str_ageLine) == gu_arr[i].getAge()/10*10
					   && input_gender.equals(gu_arr[i].getGender()) ) { //내가 쓴 연령대와 성별 일치하는 회원이 있다면
						
						is_ageline_gender_Search = true;
						sb.append(gu_arr[i].getInfo()+ "\n"); //sb그 회원을 쌓아줄어야. 어디에? 겟인포 아래 회원배열에.
					}
					
				}//end of for--------------------------
				
				if(is_ageline_gender_Search) {
					title();
					System.out.println(sb.toString());
				}
				else {
					System.out.println("[검색결과 연령대가" + str_ageLine+"대인 " +input_gender+"자 구직자는 없습니다]\n");
				}
				// === 성별 검색 끝 === //
			}
			
		}//end of ifelse----------------------
		
	}//end of  void search_ageLine_gender---------------------
}
