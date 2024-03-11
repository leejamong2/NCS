package jdbc.day03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MemberCtrl {
	
	
	//필드
	MemberDAO mdao = new MemberDAO_imple();
	
	
	
	//method, operation, 기능
	//시작메뉴를 보여주는 메소드(기능)***
	
	public void menu_Start(Scanner sc) {
		
		MemberDTO member = null;
		String s_Choice = "";
		
		boolean isLogin = false;  //맨첨엔 폴스였다가 로그인이 성공되어지면 true 로 바꿀겨
		
		if(isLogin == false) { //로그인을 하기 전 이라고 확실하게 정의해줘써
			
			do {
				/////////////////////////////////////////////////////////////////////////
				System.out.println("\n>>> --- 시작메뉴 ---<<<\n"
								 +"1.회원가입   2.로그인   3.프로그램종료 \n"
								 +"---------------------------------\n");
				System.out.println("메뉴번호선택 : ");
				s_Choice = sc.nextLine();  //1,2,3만 입력
				
				switch (s_Choice) {
				case "1":  //회원가입
					memberRegister(sc);  //여따가 코드써도되는데 글케하면 유지보수가 힘들어져서 메소드 만듬
					
					break;
		
				case "2":  //로그인
					member = login(sc);  //로그인의 리턴타입은? 로그인성공이면 한 행을 불러오니까 DTO이다. 
					if(member!=null) { //가입한 회원이 있다면
						isLogin = true;
					}
					break;
				case "3":  //프로그램종료
					return; // 리턴은 메소드를 종료시킴
					
				default:
					System.out.println(">>>메뉴에 없는 번호입니다 다시 선택하세요<<<");
					break;
					
				}//end of switch------------------------------
				/////////////////////////////////////////////////////////////////////////
				
			}while(!("2".equals(s_Choice) && isLogin == true));  //isLogin불린타입 변수 만들어줌 //2번이면서 로그인이 되었을때 시작메뉴벗어남
			
		}//end of if(isLogin == false)-----------------------------
			
		
		
		if(isLogin == true) {
            
            /*
            if("admin".equals(member.getUserid())) {
               System.out.println("\n>>> ---- 시작메뉴 ["+member.getName()+"님 로그인중..]---- <<<\n"
                        + "1.로그아웃   2.회원탈퇴하기   3.나의정보보기   4.모든회원정보보기\n"
                        + "------------------------------------\n" );
            }
            */
            
            String admin_menu = "admin".equals(member.getUserid())?"4.모든회원조회":"";
            
            System.out.println("\n>>> ---- 시작메뉴 ["+member.getName()+"님 로그인중..]---- <<<\n"
            					+ "1.로그아웃   2.회원탈퇴하기   3.나의정보보기  "+admin_menu+"\n"
            					+ "-------------------------------------------------\n" );
            
            System.out.println("▷ 메뉴번호 선택 : ");
            s_Choice = sc.nextLine();
            
            
            switch (s_Choice) {
               case "1":  // 로그아웃
                  member = null;   
                  System.out.println(">>> 로그아웃 되었습니다. <<<\n");
                  break;
                  
               case "2":  // 회원탈퇴하기
            	   ////////////////////////////////////////////////////
            	   String yn = "";
            	   do {
            	   System.out.print("정말로 탈퇴하시겠습니까? [Y/N]");
            	   yn = sc.nextLine();
            	   
            	   if("y".equalsIgnoreCase(yn)) {
            		   int n = mdao.memberDelete(member.getUserseq());
            		   if(n==1) {
            			   member = null;
            			   isLogin = false;
            			   System.out.println("회원탈퇴 성공");
                       }
            	   }
            	   else if("n".equalsIgnoreCase(yn)) {
            		   System.out.println("회원탈퇴 취소함");
            	   }
            	   else {
            		   System.out.println("y/n만 입력하세요");
            	   }
                   /////////////////////////////////////////////////////
            }while(!("y".equalsIgnoreCase(yn) || "n".equalsIgnoreCase(yn)));
                  
                  
                  
                  break;
                  
               case "3":  // 나의정보보기
                //System.out.println(member.toString());
                //또는
            	  System.out.println(member);
            	 
                  break;
                  
               case "4":  // admin 으로 로그인시 모든회원조회, 일반회원일시 없는번호 라고 나와야함
                  if("admin".equals(member.getUserid())) {
                	  showAllMember();
                  }
                  else {
                	  System.out.println("메뉴에 없는 번호입니다");
                  }
                  break;
      
               default:
                  System.out.println(">>> 메뉴에 없는 번호 입니다. 다시 선택하세요!! <<<");
                  break;

			}//end of switch-------------------------------------
			menu_Start(sc);
		}
		
		
	}//end of public void menu_Start(Scanner sc)-----------------메소드 끗

	
	
	

	




	//회원가입하는 메소드
	private void memberRegister(Scanner sc) {
		
		System.out.println("\n>>> --- 회원가입 --- <<<");
		
		//한명의 회원정보를 알려줌
		System.out.println("1.아이디 : ");
		String userid = sc.nextLine();
		
		System.out.println("2.비밀번호 : ");
		String passwd = sc.nextLine();
		
		System.out.println("3.회원명 : ");
		String name = sc.nextLine();
		
		System.out.println("4.연락처(휴대폰) : ");
		String mobile = sc.nextLine();
		
		MemberDTO member = new MemberDTO();  //회원 한명 생성(한개 행을 set 해서 데이터베이스에 보냄).  데이터베이스 테이블에 넣어준다. 인서트해온다 //회원이라는 데이터를 전송해주는 객체.(회원정보 전송하는 아이! DTO)
		member.setUserid(userid);
		member.setPasswd(passwd);
		member.setName(name);
		member.setMobile(mobile);
		
		
		
		int n = mdao.memberRegister(member);
		//mdao.___     컨트롤러는 회원가입만을 위한 메소드니까 레자스터데이만 보면 됨. 그 외의 것들은 굳이 안봐도되니까 
		//(목차인 동시에 다른클래스에서 사용하는)인터페이스로 받아온다
		
		if(n==1) {
			System.out.println("\n>>회원가입 축하<<");
		}
		else {
			System.out.println(">>>회원가입 실패<<<");
		}
		
	}//end of private void memberRegister(Scanner sc)---------------
	
	
	
	
	//2번. 로그인하는 메소드
	 private MemberDTO login(Scanner sc) {
	      
	        MemberDTO member = null;
	      

			System.out.println("\n>>> --- 로그인 --- <<<");
			
			System.out.println("아이디 : ");
			String userid = sc.nextLine();
			
			System.out.println("비밀번호 : ");
			String passwd = sc.nextLine();
			
			Map<String, String> paraMap = new HashMap<>();  //맵은 넣을때 갯수제한 없고  그중 한개를 보내버리는거다
			paraMap.put("userid", userid);
			paraMap.put("passwd", passwd);
			
			
			member = mdao.login(paraMap);
			
			if(member!=null) {
				System.out.println("로그인 성공!");
			}
			else {
				System.out.println("로그인 실페ㅜㅜ\n");
			}
			
			
			
			return member;
		}//end of --------------------------------
	 
	 
	 	//모든회원조회***
	 private void showAllMember()  {
			
			List<MemberDTO> memberList = mdao.showAllMember(); // 많은 복수 개의 정보를 가져오기 때문에 memberDTO가 복수개. list 제네릭 타입
			
			if(memberList.size() > 0) {
				System.out.println("-".repeat(50));
				System.out.println("회원번호	아이디	회원명	연락처	포인트	가입일자	가입상태");
				System.out.println("-".repeat(50));
				
				StringBuilder sb = new StringBuilder();
				
				for(MemberDTO member : memberList) { //memberList를 까보면 MemberDTO 요거다. member는 지역변수
					
					String status = (member.getStatus()==1)?"가입중" :"탈퇴" ;
					
					sb.append(member.getUserseq()+" "+
							  member.getUserid()+" "+
							  member.getName()+" "+
							  member.getMobile()+" "+
							  member.getPoint()+" "+
							  member.getRegisterday()+" "+
							  status +"\n");
					
				}//end of for--------------------------------------
				
				System.out.println(sb.toString());
			}
			else {
				System.out.println(">>가입된 회원이 1명도 없습니다ㅜㅜ");
			}
			
		}//end of----------------------------------------

}
