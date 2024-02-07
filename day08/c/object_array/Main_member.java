package my.day08.c.object_array;

import java.util.Scanner;

import my.util.MyUtil;

public class Main_member {

	public static void main(String[] args) {
		
		//System.out.println("시작"+MyUtil.space_delete("이순신")+"끝");
		
		//System.out.println(MyUtil.space_delete(null)+"끝");
		
		System.out.println("시작"+"       "+"끝");  //양쪽의 공백을 다 제거해줌
		System.out.println("시작"+"      ".trim()+"끝");
		
		System.out.println("시작"+"   중  간   "+"끝");
		System.out.println("시작"+"   중  간  ".trim()+"끝");
		
		System.out.println("      ".isEmpty());  //true  리턴타입 블린
		System.out.println("  ".isEmpty());  //false
		System.out.println("        ".trim().isEmpty()); //true
		System.out.println("   하   ".trim().isEmpty()); //false
		System.out.println("".trim().isEmpty()); //true
		
	  //int[] arr_subject = new int[7]; 
		Member[] arr_mbr= new Member[3]; //멤버 3명까지만 받을거임. 3를 받아주면서 널로 초기화되고잇음
		int mbr_cnt = 0;
		
	 /*
		for(int i=0; i<arr_mbr.length; i++) {
			System.out.println(arr_mbr[i]);
		}//end of for--------------------
	 */
		
		Scanner sc = new Scanner(System.in);
		String str_menuno = null;
		
		do {
			System.out.println("\n======== >> 메뉴 << ================\n"
								+ "1. 회원가입  2. 모든회원조회  3.프로그램종료\n"
								+ "==================================");
			System.out.print("선택하세요 => ");
			
			
			str_menuno = MyUtil.space_delete(sc.nextLine());   //문자로 입력해줄거야,   메소드를 만들어 줄거야. 
			
			/*if(str_menuno!="1" ||
				str_menuno!="2"||
				str_menuno!="3") {
			System.out.println("[경고] 메뉴에 없는 것입니다.");
			}
		*/
			
	switch(str_menuno) {
		case "1" : //회원가입
			
			if(mbr_cnt < arr_mbr.length)  { //멤버 수가 배열방길이[3]보다는 작아야 하지.

				String id = null;
				
				id_outer:
				//outer:
				do {//무한번 반복해야하니까. do는 처음말 나오는데에 조건 없이 그냥 나올 수있으니까. 폴 등등등은 조건필요.
					System.out.print("\n아이디 : ");
					id = sc.nextLine();
					
					
					if(id.trim().isEmpty()) {
						System.out.println(">>[경고] 아이디값을 공백이 아닌 다른 값으로 입력하세요<<\n");
					}
					else {
						/*//==입력한 아이디가 중복된 아이디 인지 검사하기 첫번째 방법==//
						boolean isDuplicate_id = false;
						for(int i=0; i<mbr_cnt; i++){//비교대상이 필요하지. 배열안에 들어가 있으니 거기서 꺼낸다고 arr_mbr.length하면 문자열타입이라  오류. //맨 처음 가입할때는 비교할필요 없지
							if(id.equals(arr_mbr[i].id)) {  //id내가입력한아이디.equals(arr_mbr[i].id)등록된아이디  랑 같냐.    arr_mbr[i]는 초기값이 널 =>  널.쩜은 없다.
								System.out.println(id+"는 이미 사용중인 id이므로 새로운 id값을 넣으세요.");
								isDuplicate_id = true;
								break;
							}
							//continue outer;
						
						}//end of for---------------------------------
						
						if(!isDuplicate_id)
							break;  //공백이 아니다, 중복이 아니다라는 판명 나고 빠져나오기
					}*/
						
					//////////////////////////////////////////////////////////
						
					//==입력한 아이디가 중복된 아이디 인지 검사하기 두번째 방법==//
				
					for(int i=0; i<mbr_cnt; i++){//비교대상이 필요하지. 배열안에 들어가 있으니 거기서 꺼낸다고 arr_mbr.length하면 문자열타입이라  오류. //맨 처음 가입할때는 비교할필요 없지
						if(id.equals(arr_mbr[i].id)) {  //id내가입력한아이디.equals(arr_mbr[i].id)등록된아이디  랑 같냐.    arr_mbr[i]는 초기값이 널 =>  널.쩜은 없다
							System.out.println(id+"는 이미 사용중인 id이므로 새로운 id값을 넣으세요."); 
							continue id_outer;
						}
					}//end of for---------------------------------
					
					break; // 다 올바른 경우 두와일문 빠져나와서 비밀번호로 넘어감
					}
			} while (true);



				String passwd = "";
				do {
					System.out.print("비밀번호 : ");
					passwd= sc.nextLine();
					if( !MyUtil.isCheckPasswd(passwd)) {
						System.out.println(">>[경고] 비밀번호는 8글자 이상 15글자 이하의 영문 대,소문자 및 특수문자가 혼합되어야만 합니다.<<\n");
					}
					else {
						break;
					}
				} while (true);



				//공백 없이 2글자 이상 6글자 이하의 한글

				String name = "";
				do {

					System.out.print("성명 : ");
					name = sc.nextLine();

					boolean isUsename = true;    //초기값

					if(name.length()<2 || name.length() > 6) {
						isUsename = false;
					}
					else { //입력한 성명의 길이가 두글자 이상 6글자 이하인경우
						for(int i=0; i<name.length(); i++) {
							if(!('가' <= name.charAt(i) && name.charAt(i) <= '힣')) {
								isUsename = false;
								break;
							}
						}//end of for-------------------------------

					}
					if(isUsename) {
						break;  //와일 문 빠져나오는 브레이크
					}
					else {
						System.out.println("[경고] 성명은 한글로만 2글자 이상 6글자 이하로 입력하세요<<\\n");
					}

				} while (true);


				Member mbr = new Member();		    //회원이란 객체를 인스턴스에 넣어줌
				mbr.id = id;
				mbr.passwd = passwd;
				mbr.name = name;

				arr_mbr[mbr_cnt++] = mbr;  //mbr_cnt 초기치를 위에서 0으로 잡아줬음. 회원이 증가할때마다 ++

				System.out.println(">>회원가입 성공!!<<\n");
			}
			else {
				System.out.println(">>정원마감되어 회원가입이 불가합니다.<<\n");
			}
				break;	//스위치문 빠져나가는 브레이크
			
			
		case "2" : 	//모든회원조회
			
			if(mbr_cnt == 0) {
				System.out.println(">>가입된 회원이 없습니다.<<\n");
			}
			
			else {
				System.out.println("---------------------------------\n"
									+"아이디     비밀번호    	 성명  \n"
									+"-------------------------------");
				
				for(int i=0; i<mbr_cnt; i++) {
					System.out.println(arr_mbr[i].view_info()) ;  //이 메소드를 스트링 타입으로해야지
				}//end of for----------------------------
				
			}
			
			break;	//스위치문 빠져나가는 브레이크
			
		case "3" : 	//종료
			
			break;	//스위치문 빠져나가는 브레이크
		
		default:
			System.out.println("[경고] 메뉴에 없는 것입니다.");
			break;	//스위치문 빠져나가는 브레이크
			
		
		
		}
		
		
		
	} while (!("3".equals(str_menuno)));  //입력한 메뉴 번호가 3번이라면 반복문을 빠져나와야 한다.   스트링이니까 이퀄스 써줘야해 ()안에는 변수만와야해.
	        //null값 못와
	
	sc.close();
	
	System.out.println("\n====프로그램 종료====\n");
	
		
		

	}//end of main()---------------------

}
