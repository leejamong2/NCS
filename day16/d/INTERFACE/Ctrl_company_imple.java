package my.day16.d.INTERFACE;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Ctrl_company_imple extends Ctrl_common_imple implements Ctrl_company {

	// == 구인회사(Company) 신규 회원가입시
	//          Company 클래스의 필드의 요구사항에 모두 맞으면
	//CommonMember[] cmbr_arr 에 저장시켜주는 메소드 생성하기 ==

	public void register(Scanner sc, CommonMember[] cmbr_arr) {
		
		if(CommonMember.count < cmbr_arr.length) { //지금까지 생성된 구인회사가 cmbr_arr.length(배열길이==>정원) 보다 적을 경우에만 신규회원을 받아들인다.
			
			String passwd;
			String name;
			String jubun;
			
			
			Company_imple cp = new Company_imple();
			// 아이디 는 필수 입력사항이므로
			outer:
			do {
				System.out.println("1. 아이디 : ");
				String id = sc.nextLine();
				
				//중복 아이디 검사하기 시작//
				for(int i=0; i<CommonMember.count; i++) {
					
					if(cmbr_arr[i].getType()==2 && id.equals(cmbr_arr[i].getId()) ) {  //내가 입력한 아이디와 저장된 아이디가 같냐
						System.out.println(">>이미 사용중인 아이디이므로 다른 아이디값을 입력하세요");
						continue outer;
					}
				}//end of for---------------
				//중복 아이디 검사하기 끝//
				
				cp.setId(id);

			} while (!(cp.getId() != null));
					
					
					
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
			
			// 비밀번호는 필수 입력사항이므로 비밀번호 조건에 맞을때까지 반복한다
			do {
				System.out.println("2.비밀번호 : ");
				String passwd1 = sc.nextLine();
				
				cp.setPasswd(passwd1);
				
				
				}while(!(cp.getPasswd()!=null));
			
		
			// 회사명은 필수 입력사항이므로 그냥 엔터나 공백만으로 된 것이 아닐때 까지 반복해야 한다.
			// 회사명은 2글자 이상 6글자 이하의 한글로만 되어져야 한다.
			do {
				System.out.println("3.회사명 : ");
				String name1 = sc.nextLine();
				
				cp.setName(name1);
				
				
				}while(!(cp.getName()!=null));
			
			
			do {
				System.out.println("4.사업자등록번호 : ");
				String setBusiness_number = sc.nextLine();
				
				cp.setBusiness_number(setBusiness_number);
				
				
				}while(!(cp.getBusiness_number()!=null));
			
			
			
			
			
			cmbr_arr[CommonMember.count++] = cp;
			
			System.out.println(">>구인회사 회원가입 성공");
			
		}
		else {//지금까지 생성된 구직자 회원수가 cmbr_arr.length(배열길이==>정원) 와 같거나 큰 경우에 신규회원을 받아들이면 안된다.
			System.out.println(">>정원 " + cmbr_arr.length + "개가 꽉 차서 구인회사 회원가입이 불가합니다.<< \n");
		}

	}//end of public void register(Scanner sc, CommonMember[] cmbr_arr)---------------------------------------


	
	
	
	//구인회사 전용메뉴
	public void cp_menu(Scanner sc, Company_imple login_cp, CommonMember[] cmbr_arr, Recruit[] rc_arr, RecruitApply[] rcApply_arr) {
		
			String str_menuno;
			do {
				System.out.println("===구인회사 전용메뉴("+login_cp.getName()+"기업 로그인중)===");
				System.out.println("1.회사정보 보기 		 2.회사정보 수정  		 3.모든구직자 조회  		 4.구직자성별 검색	5.구직자 연령대검색"+
									"6.구직자 연령대 및 성별검색  7.채용공고입력하기  8.우리회사 채용공고 조회	  9.우리회사 채용공고지원자	조회	10.로그아웃\n");
				System.out.print("※메뉴번호 선택 : ");
				str_menuno = sc.nextLine();
				
				switch (str_menuno) {
				case "1":  //회사 정보 보기
					view_myInfo(login_cp);
					break;
				case "2":  //회사 정보 수정
					update_myInfo(sc, login_cp);  //리턴타입 모써야할까?  보이드.  보여주면 끝나니까
					break;
				case "3":  //모든구직자 조회
					view_all_info(cmbr_arr);
					break;
				
				case "4": //구직자성별검색
					search_gender(sc, cmbr_arr);
					break;
				
				case "5":  //구직자연령대검색
					search_ageLine(sc, cmbr_arr);
					break;
					
				case "6":  //구직자 연령대 및 성별검색
					search_ageLine_gender(sc, cmbr_arr);
					break;
					
				case "7":  //채용공고입력하기
					register_recruit(sc, login_cp, rc_arr);  //어느 회사에서 모집공고하는지 알아야하니까 로그인cp
					break;  
					
				case "8":  //우리회사 채용공고 조회
					view_recruit_mycompany(login_cp, rc_arr); //우리꺼만 볼거야 남의꺼 보믄 안대지
					break;
					
				case "9":  //우리회사 채용공고지원자 조회
					view_gujikja_my_recruitApply(login_cp, rcApply_arr);
					break;
					
				case "10":  //로그아웃
					login_cp = null;
					break;
					
				default:
					System.out.println(">>[경고]선택하신 번호는 메뉴에 없습니다.");
					break;
				}//end of switch----------------------------
				
			}while(!"10".equals(str_menuno));
			//end of dowhile-------------------------------------
			
			
			System.out.println(">> 로그아웃 되었습니다.<<\n");
	}//end of public void gu_menu(Scanner sc, Gujikja login_gu, Company[] cp_arr)-------------------------


	
	//우리 회사 정보보기
	private void view_myInfo(Company_imple login_cp) {

		DecimalFormat df = new DecimalFormat("#,###");
		
		System.out.println(">>>"+login_cp.getName()+"기업의 정보<<<");
		System.out.println("-".repeat(40));
		
		System.out.println("  아이디     비밀번호      회사명   가입일자      사업자등록번호    직종타입   자본금");
		System.out.println("-".repeat(50));
		System.out.println(login_cp.getId()+"\t"+
						   login_cp.getPasswd()+"\t"+
						   login_cp.getName()+"\t"+
						   login_cp.getRegister_day()+"\t"+
						   login_cp.getBusiness_number()+"\t"+
						   login_cp.getJob_type()+"\t"+
						   df.format(login_cp.getSeed_money())+"원");
		/*
	 	엄정화님의 정보
	 	-----------------------------------
	 	아이디   비밀번호       성명        주민번호   
	 	-----------------------------------
	 	eomjh  qWer1234$  엄정화      8610202
	 */
		
	}//end of private void view_myInfo(Gujikja login_gu)-------------------


	

	// 우리 회사 정보 수정하는 메소드 생성하기 //
		private void update_myInfo(Scanner sc, Company_imple login_cp) {
		      
		      view_myInfo(login_cp);
		      
		      System.out.println("\n>> [주의사항] 변경하지 않고 예전의 데이터값을 그대로 사용하시려면 그냥 엔터하세요!!\n");
		      
		      boolean exit_ok = false;
		      do {
		         //////////////////////////////////////////////////////////////
		         System.out.print("1.비밀번호 : ");
		         String new_passwd = sc.nextLine();  // 기존비밀번호인 qWer1234$ 을 qWer0070$ 으로 변경하려고 한다.
		                                             // 기존비밀번호인 qWer1234$ 을 qWer1234$ 으로 변경하려고 하려면 기존암호와 동일하므로 변경이 불가합니다. 
		                                             // 기존비밀번호인 qWer1234$ 을 변경하기 싫다. 
		                                             // 기존비밀번호인 qWer1234$ 을 abcd 로 변경하고자 할때는 비밀정책에 맞지 않으므로 안된다.!! 
		         
		         if(!new_passwd.equals("")) { // 입력한 비밀번호가 엔터가 아닐 경우 
		            
		            if(login_cp.getPasswd().equals(new_passwd) ) { // 입력한 비밀번호가 기존 비밀번호와 같을 경우 
		               System.out.println(">> 기존암호와 동일하므로 변경이 불가합니다.!!");
		            }
		            else {
		               login_cp.setPasswd(new_passwd);
		               
		               if(login_cp.getPasswd().equals(new_passwd)) {
		                  exit_ok = true;
		               }
		            }
		            
		         }
		         
		         else { // 입력한 비밀번호가 엔터일 경우
		            exit_ok = true;
		         }
		        //////////////////////////////////////////////////////////////
		      } while(!exit_ok);
		      // end of do~while-------------------------------------------
		      
		      
		      exit_ok = false;
		      do {
		         ////////////////////////////////////////////////////////////////////
		         System.out.print("2.회사명 : ");
		         String new_name = sc.nextLine(); // 기존회사명인 삼성 을 삼성전자 로 변경하려고 한다.
		                                            // 기존회사명인 삼성 을 삼성 으로 변경하려고 하려면 기존회사명과 동일하므로 변경이 불가합니다. 
		                                            // 기존회사명인 삼성 을 변경하기 싫다. 
		                                            // 기존회사명인 삼성 을 삼sung 으로 변경하고자 할때는 회사명정책에 맞지 않으므로 안된다.!!
		         
		         if(!new_name.equals("")) { // 입력한 회사명이 엔터가 아닐 경우 
		            
		            if(login_cp.getName().equals(new_name) ) { // 입력한 회사명이 기존 회사명과 같을 경우 
		               System.out.println(">> 기존의 회사명과 동일하므로 변경이 불가합니다.!!");
		            }
		            else {
		               login_cp.setName(new_name);
		               
		               if(login_cp.getName().equals(new_name)) {
		                  exit_ok = true;
		               }
		            }
		            
		         }
		         
		         else { // 입력한 회사명이 엔터일 경우
		            exit_ok = true;
		         }
		          ////////////////////////////////////////////////////////////////////
		      } while(!exit_ok);
		        
		      
		      exit_ok = false;
		      do {
		         ////////////////////////////////////////////////////////////////////
		         System.out.print("3.사업자등록번호 : ");
		         
		         String new_business_number = sc.nextLine(); 
		   
		         if(!new_business_number.equals("")) {  
		   
		            if(login_cp.getBusiness_number().equals(new_business_number) ) {  
		               System.out.println(">> 기존의 사업자등록번호와 동일하므로 변경이 불가합니다.!!");
		            }
		            else {
		               login_cp.setBusiness_number(new_business_number);
		               
		               if(login_cp.getBusiness_number().equals(new_business_number)) {
		                  exit_ok = true;
		               }
		            }
		   
		         }
		         
		         else { // 입력한 사업자등록번호가 엔터일 경우
		            exit_ok = true;
		         }
		         /////////////////////////////////////////////////////////////////   
		      } while(!exit_ok);      
		      
		      
		      exit_ok = false;
		      do {
		         ////////////////////////////////////////////////////////////////////
		         System.out.print("4.회사직종타입 : ");
		         
		         String new_job_type = sc.nextLine(); 
		   
		         if(!new_job_type.equals("")) {  
		   
		            if(login_cp.getJob_type().equals(new_job_type) ) {  
		               System.out.println(">> 기존의 직종타입과 동일하므로 변경이 불가합니다.!!");
		            }
		            else {
		               login_cp.setJob_type(new_job_type); 
		               
		               if(login_cp.getJob_type().equals(new_job_type)) {
		                  exit_ok = true;
		               }
		            }
		   
		         }
		         
		         else { // 입력한 직종타입이 엔터일 경우
		            exit_ok = true;
		         }
		         /////////////////////////////////////////////////////////////////   
		      } while(!exit_ok);   
		      
		   
		      exit_ok = false;
		      do {
		         ////////////////////////////////////////////////////////////////////
		         System.out.print("5.자본금 : ");
		         
		         String str_new_seed_money = sc.nextLine(); 
		         
		         if(!str_new_seed_money.equals("")) {  
		   
		            long new_seed_money = 0;
		            
		            try {
		                new_seed_money = Long.parseLong(str_new_seed_money);
		            } catch(NumberFormatException e) {
		               System.out.println(">> [경고] 자본금은 정수로만 입력하셔야 합니다.!! \n"); 
		               continue;
		            }
		            
		            if(login_cp.getSeed_money() == new_seed_money) {  
		               System.out.println(">> 기존의 자본금과 동일하므로 변경이 불가합니다.!!");
		            }
		            else {
		               login_cp.setSeed_money(new_seed_money); 
		               
		               if(login_cp.getSeed_money() == new_seed_money) {
		                  exit_ok = true;
		               }
		            }
		   
		         }
		         
		         else { // 입력한 자본금이 엔터일 경우
		            exit_ok = true;
		         }
		         /////////////////////////////////////////////////////////////////   
		      } while(!exit_ok);      
		      
		      
		   }// end of private void update_myInfo(Scanner sc, Company login_cp)--------



	

	// === 모든구직자 조회 === //
	private void view_all_info(CommonMember[] cmbr_arr) {
		
			/*
			 	-----------------------------------------------------------------------
			 	아이디     비밀번호     성명      생년월일     성별   만나이      가입일자
			 	-----------------------------------------------------------------------
			 	eomjh  qWe******   엄정화     961020     여    27		2024-01-31  10:30:40 
			 	leess  abC******   이순신     960120     남    28		2024-01-31  10:30:40 
			 	chaew  aSd******   차은우     010620     남    22		2024-01-31  10:30:40
			 	----------------------------------------------------------------------- 
			 */
		int cnt = 0;
		for(int i=0; i<CommonMember.count; i++) {
		/*	
		 	if(cmbr_arr[i].getType() == 1) {
				
			}
		*/	
		//	또는
			if(cmbr_arr[i] instanceof Gujikja_imple) {
				cnt++;
			}
		}//end of for -----------------------------------------------------------------------
			
		if(cnt == 0) {  //전부다 컴패니면 안올라가겟지
			System.out.println(">> 구직자로 가입된 회원이 아무도 없습니다. <<\n");
		}
		else {
			title();  //검색할때 타이틀을 다시 쓰기위해 밑에 메소드 만듬  //회원정보있으면 타이틀만들어준다는말
			StringBuilder sb = new StringBuilder();
		
			for(int i=0; i<CommonMember.count; i++) {  //Gujikja.count  이순신 엄정화 차은우 디폴트값3명
				if(cmbr_arr[i].getType() == 1)
				sb.append(cmbr_arr[i].getInfo()+"\n"); //gu_arr[i]구직자의 인스턴스들(eomjh  qWe******   엄정화     961020     여    27		2024-01-31  10:30:40 )을 보여주는 메소드 밑에 만듬
			}//end of for-------------------------------
			System.out.println(sb.toString());
		}
		
		
		
	}//end of void view_all_info -------------------------------------
	
	
	void title() {
		System.out.println("-".repeat(70)+"\n"
						  +"아이디     비밀번호          성명     생년월일   성별    만나이      가입일자 \n"
						  +"-".repeat(70));
	}//end of void title()----------------------------------------------------- 

		

		



		// == 연령대 검색해주는 메소드 == //
	int cnt = 0;
	private void search_ageLine(Scanner sc, CommonMember[] cmbr_arr) {
		
		
			
			if(Gujikja_imple.count == 0) {
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
				
				for(int i=0; i<CommonMember.count; i++) {
					if(cmbr_arr[i] instanceof Gujikja_imple) {
					
						int ageLine = ((Gujikja_imple)cmbr_arr[i]).getAge()/10*10;
						//                  나이/10*10  n
						//                  26/10*10 ==> 20
						
						if(Integer.parseInt(str_ageLine) == ageLine) { //입력한 값이랑 연령대랑 일치
							isSearch = true;
							sb.append(cmbr_arr[i].getInfo()+"\n");
						}
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
			
		}//end of void search_ageLine(Scanner sc, CommonMember[] cmbr_arr)-----------------------------------
		
		



	// == 성별 검색해주는 메소드 == //
	private void search_gender(Scanner sc, CommonMember[] cmbr_arr) {
		
		int cnt=0;
		for(int i=0; i<CommonMember.count; i++) {
			if(cmbr_arr[i].getType() == 1) {
				cnt++;
			}
		//	또는
		/*	if(cmbr_arr[i] instanceof Gujikja) {
				cnt++;
			}
		*/
		//	또는
		}//end of for--------------------------
				
			if(cnt == 0) {
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
				
				for(int i=0; i<CommonMember.count; i++) {
					
					if(	cmbr_arr[i] instanceof Gujikja_imple &&
						input_gender.equals( ((Gujikja_imple)cmbr_arr[i]).getGender()) ) { //커먼멤버에는 겟젠더가 없으니까 구직자로 바뀌어야함 그러려면 캐스트해야지((Gujikja)cmbr_arr[i]). 내가 쓴 성별과 일치하는 회원이 있다면
						isSearch = true;
						sb.append(cmbr_arr[i].getInfo()+ "\n"); //sb그 회원을 쌓아줄어야. 어디에? 겟인포 아래 회원배열에.
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
	
	
		}//end of void search_gender(Scanner sc, CommonMember[] cmbr_arr)----------------------------

		
	// === 연령대 및 성별 검색해주는 메소드 === //
	private void search_ageLine_gender(Scanner sc, CommonMember[] cmbr_arr) {
		int cnt=0;
		for(int i=0; i<CommonMember.count; i++) {
			if(cmbr_arr[i].getType() == 1) {
				cnt++;
			}
		//	또는
		/*	if(cmbr_arr[i] instanceof Gujikja) {
				cnt++;
			}
		*/
		//	또는
		}//end of for--------------------------
				
		if(cnt == 0) {
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
			
			for(int i=0; i<CommonMember.count; i++) {
				if(cmbr_arr[i] instanceof Gujikja_imple) {
					int ageLine = ((Gujikja_imple)cmbr_arr[i]).getAge()/10*10;
					//                  나이/10*10 
					//                  26/10*10 ==> 20
					
					if(Integer.parseInt(str_ageLine) == ageLine) { //입력한 값이랑 연령대랑 일치
						is_ageline_Search = true;
						break;  //찍어주기 위함이 아닌 일치하는 연령대 하나라도 있는지 확인하기 위함이라 찾으면 바로빠져나오기
					//	sb.append(gu_arr[i].getInfo()+"\n");  성별까지 보고 쌓아줘야되니까 여기에 쓰면 안됨
					}
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
				
				for(int i=0; i<CommonMember.count; i++) {
					if(cmbr_arr[i] instanceof Gujikja_imple) {
						if(Integer.parseInt(str_ageLine) == ((Gujikja_imple)cmbr_arr[i]).getAge()/10*10
						   && input_gender.equals( ((Gujikja_imple)cmbr_arr[i]).getGender()) ) { //내가 쓴 연령대와 성별 일치하는 회원이 있다면
							
							is_ageline_gender_Search = true;
							sb.append(cmbr_arr[i].getInfo()+ "\n"); //sb그 회원을 쌓아줄어야. 어디에? 겟인포 아래 회원배열에.
						}
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
		
	}//end of void search_ageLine_gender(Scanner sc, CommonMember[] cmbr_arr)-----------------------------

		
		

	// == 채용공고 입력하기 ==
	private void register_recruit(Scanner sc, Company_imple login_cp, Recruit[] rc_arr) {
		
		System.out.println("======"+login_cp.getName()+" 채용공고 등록 ======");
		Recruit_imple rc = new Recruit_imple();
		
		do {
			System.out.print("1.채용제목 : ");
			String subject = sc.nextLine();
			rc.setSubject(subject);
			
		} while (!(rc.getSubject() != null));
		
		do {
			System.out.print("2.채용분야[예> 사무직] : ");
			String work_type = sc.nextLine();
			rc.setWork_type(work_type);
			
		} while (!(rc.getWork_type() != null));
		
		do {
			System.out.print("3.채용인원 : ");
			String str_cnt = sc.nextLine();
			
			try {
				int cnt = Integer.parseInt(str_cnt);
				if(cnt<0) {
					System.out.println("[경고] 1이상 입력하세요!!");
				}
				else {
					rc.setCnt(cnt);
				}
			}catch(NumberFormatException e) {
				System.out.println("[경고] 1이상 입력하세요!!");
			}
			
		
		} while (!(rc.getCnt() > 0));
		
		do {
			System.out.print("4.연봉[단위 만원] : ");
			String str_yearpay = sc.nextLine();
			
			try {
				int yearpay = Integer.parseInt(str_yearpay);
				if(yearpay<=0) {
					System.out.println("[경고] 1이상 입력하세요!!");
				}
				else {
					rc.setYearpay(yearpay);
				}
			}catch(NumberFormatException e) {
				System.out.println("[경고] 1이상 입력하세요!!");
			}
		
		} while (!(rc.getYearpay() > 0));
		
		do {
			System.out.print("5.채용마감일자[예> 20240208] : ");
			String finish_day= sc.nextLine();
			rc.setFinish_day(finish_day);
			
		} while (!(rc.getFinish_day() != null));
		
		rc.setCp(login_cp);
		
		rc_arr[Recruit_imple.count++] = rc;
		
		
	}//end of private void register_recruit(Scanner sc, Company login_cp, Recruit[] rc_arr)-------
	
	
	
	
	// == 우리회사 채용공고 조회 ==
		private void view_recruit_mycompany(Company_imple login_cp, Recruit[] rc_arr) {
			
			boolean is_existence = false;
			
			for(int i=0; i<Recruit_imple.count; i++) {
				
				if(login_cp.getId().equals(((Recruit_imple) rc_arr[i]).getCp().getId()) ) { //로그인되어진 회사아이디와 모집공고를낸 회사 아이디가 같냐
					is_existence = true;
					System.out.println(rc_arr[i].recruit_info());
				}
				
			}//end of for--------------------------
			
			if(!is_existence) {
				System.out.println(">>채용공고를 낸 것이 없습니다<</n");
			}
			
		}//end of private void view_recruit_mycompany(Company login_cp, Recruit[] rc_arr)----------------


	
		
		
	// 우리회사 채용공고지원자 조회
	private void view_gujikja_my_recruitApply(Company_imple login_cp, RecruitApply[] rcApply_arr) {
		
		boolean is_existence = false;
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<RecruitApply.count; i++) {
			
			if(login_cp.getId().equals(rcApply_arr[i].getRc().getCp().getId()) ) {
				is_existence = true;
				sb.append(rcApply_arr[i].getRc().getRecruit_no()+"\t"+
						  rcApply_arr[i].getRc().getSubject()+"\t"+
						  rcApply_arr[i].getGu().getName()+"\t"+
						  rcApply_arr[i].getGu().getGender()+"\t"+
						  rcApply_arr[i].getGu().getAge()+"\t"+
						  rcApply_arr[i].getApply_motive()+"\n"  );
			}
			
		}//end of for-------------------------
		
		if(is_existence) {
			System.out.println("=".repeat(100));
			System.out.println("채용공고 번호	채용제목	지원자명	성별		나이		지원동기");
			System.out.println("=".repeat(100));
			System.out.println(sb.toString());
		}
		else {
			System.out.println(">>채용공고에 지원자가 없습니다.");
		}

	}//end of private void view_gujikja_my_recruitApply(Company login_cp, RecruitApply[] rcApply_arr)


		
}
	
