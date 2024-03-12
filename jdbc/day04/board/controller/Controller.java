package jdbc.day04.board.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//import jdbc.day03.MemberDAO;  글자만 카피하고 싶을 때 어제꺼 이렇게 다 따라오니까 임포트 지워야해
//import jdbc.day03.MemberDAO_imple;
import jdbc.day04.board.dbconnection.MyDBConnection;
import jdbc.day04.board.domain.BoardDTO;
import jdbc.day04.board.domain.MemberDTO;
import jdbc.day04.board.model.*;

public class Controller {
	
	// 필드
	MemberDAO mdao = new MemberDAO_imple();
	BoardDAO bdao = new BoardDAO_imple();  //BoardDAO 이 인터페이스에 연결된 메소드만 보여주기 때문에 이거 씀
//	BoardDAO_imple bdao = new BoardDAO_imple();  2번쨰와 3번째 둘다 사용 가능한데 3으로 하면 BoardDAO_imple
	
	
	// 메소드
	// *** 시작메뉴 *** //

		public void menu_Start(Scanner sc) {
			
			MemberDTO member = null;
			String s_Choice = "";
			boolean isLogin = false;  //맨첨엔 폴스였다가 로그인이 성공되어지면 true 로 바꿀겨
			
		do {
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
							MyDBConnection.closeConnection();  //Connection 객체 자원반납
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
	            
	            String admin_menu = "admin".equals(member.getUserid())?"4.관리자전용(모든회원조회)":"";
	            
	            System.out.println("\n>>> ---- 시작메뉴 ["+member.getName()+"님 로그인중..]---- <<<\n"
	            					+ "1.로그아웃   2.나의정보보기   3.게시판가기  "+admin_menu+"\n"
	            					+ "-------------------------------------------------\n" );
	            
	            System.out.println("▷ 메뉴번호 선택 : ");
	            s_Choice = sc.nextLine();
	            
	            
	            switch (s_Choice) {
	               case "1":  // 로그아웃
	                  member = null;   
	                  System.out.println(">>> 로그아웃 되었습니다. <<<\n");
	                  break;
	                  
	               case "2":  // 나의정보보기
	            	   
	            	   //System.out.println(member.toString());
	            	   //또는
	            	   System.out.println(member);
	            	   break;
	            	   
	            	   
	               case "3":  // 게시판가기
	            	   menu_board(sc, member); //게시판 메뉴에 들어간다
	            	   break;
	            	   
	               case "4":  // admin 으로 로그인시 모든회원조회, 일반회원일시 없는번호 라고 나와야함
	                  if("admin".equals(member.getUserid())) {
	                	  
	                	  System.out.println("정렬 [1.회원명의 오름차순   /   2.회원명의 내림차순	/ \n"
	                			  			+"	   3.가입일자의 오름차순	/	4.가입일자의 내림차순]");
	                	  System.out.print("정렬번호 선택 : ");
	                	  String sortChoice = sc.nextLine();
	                	  
	                	  showAllMember(sortChoice);
	                  }
	                  else {
	                	  System.out.println("메뉴에 없는 번호입니다");
	                  }
	                  break;
	      
	               default:
	                  System.out.println(">>> 메뉴에 없는 번호 입니다. 다시 선택하세요!! <<<");
	                  break;

				}//end of switch-------------------------------------
	            }
			}while(true);
			
			
		}

		


	// *** 회원가입을 해주는 메소드	 *** 
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
	
	
	
	
	// *** 로그인을 해주는 메소드	 ***
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
	
	
	
	
	// *** 모든 회원을 조회해주는 메소드 ***
	private void showAllMember(String sortChoice) {
		
		if("1".equals(sortChoice)||"2".equals(sortChoice)||
		   "3".equals(sortChoice)||"4".equals(sortChoice)) {
			
			List<MemberDTO> memberList = mdao.showAllMember(sortChoice); // 많은 복수 개의 정보를 가져오기 때문에 memberDTO가 복수개. list 제네릭 타입
			
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
			
			
		}
		else {
			System.out.println("정렬에 없는 번호입니다");
		}
	}//end of -----------------------------------------------

	
	// *** 게시판 메뉴
	private void menu_board(Scanner sc, MemberDTO member) {
		
		String s_menuNo = "";
		
		do {
		///////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\n-----------게시판메뉴["+ member.getName() +"님 로그인중]------------\n"
						+ " 1.글목록보기     2.글내용보기    3.글쓰기      4.댓글쓰기 \n"
		                + " 5.글수정하기     6.글삭제하기    7.최근1주일간 일자별 게시글 작성건수 \n"
		                + " 8.이번달 일자별 게시글 작성건수   9.나가기 \n"
		                + "--------------------------------------------------------");
		System.out.print("메뉴번호 선텍 : ");
		s_menuNo = sc.nextLine();
		
		switch (s_menuNo) {
			case "1": //글목록보기
				
				break;
				
			case "2": //글내용보기
						
				break;
				
			case "3": //글쓰기
				int n = write(sc, member);  //인서트해줄거라 타입은 인트타임. 글쓰면 포인트가 올라가도록 만들거임. 그럼DML이 두개지 인서트랑 ~할거니까
											//모든것이 올바를때 1값줄거얌. 메소드의 리턴값이 1이면 성공 0이면 취소 ...할거야
			
				if(n==1) {
					System.out.println("글쓰기 성공!");
				}
				else if(n==0) {
					System.out.println("글쓰기 취소!");
				}
				else if(n==-1) {
					System.out.println("글쓰기 실패!");
				}
				
				break;
			
			case "4": //댓글쓰기
				
				break;
				
			case "5": //글수정하기
				
				break;
			case "6": //글삭제하기
				
				break;
			case "7": //최근1주일간 일자별 게시글 작성건수
				
				break;
			case "8": //이번달 일자별 게시글 작성건수
				
				break;
			case "9": //나가기
				
				break;
	
		default:
			System.out.println(">>> 메뉴에 없는 번호 입니다. 다시 선택하세요!! <<<");
			break;
			
		}//end of switch---------------------------------------
		///////////////////////////////////////////////////////////////////////////////
		}while(!("9".equals(s_menuNo)));
		
	}//end of menu_board-----------------------------



	// *** 글쓰기 해주는 메소드 *** //
	// === Transaction 처리 ===
   //    (tbl_board 테이블에 insert 가 성공되어지면 tbl_member 테이블의 point 컬럼에 10씩 증가 update 를 할 것이다.
   //     그런데 insert 또는 update 가 하나라도 실패하면 모두 rollback 할 것이고,
   //     insert 와 update 가 모두 성공해야만 commit 할 것이다.)
	private int write(Scanner sc, MemberDTO member) {
		
		int result = 0;
		
		System.out.println(">>> 글쓰기 <<<");
		System.out.println("1. 작성자명  : "+ member.getName());
		
		System.out.print("2. 글제목[최대100글자] : ");
		String subject = sc.nextLine();
		
		System.out.print("3. 글내용[최대200글자] : ");
		String contents = sc.nextLine();
		
		System.out.print("4. 글암호[최대20글자] : ");
		String boardpasswd = sc.nextLine();
		
		BoardDTO bdto = new BoardDTO();  // 모아모아 디티오에 다 담아줘서 한 행이 만들어짐. DAO한테 운반해주야지
		bdto.setFk_userid(member.getUserid());
		bdto.setSubject(subject);
		bdto.setContents(contents);
		bdto.setBoardpasswd(boardpasswd);
		
		
		do {
			//////////////////////////////////////////////////////
			System.out.print("정말 글쓰기 하시겠습니까?[y/n] => ");
			String yn = sc.nextLine();
			
			if("y".equalsIgnoreCase(yn)) {
				if( !(subject.length()>100 && contents.length()>200 && boardpasswd.length()>20) ){
					result = bdao.write(bdto);  //게시판 글쓰기   dto에 담아서 dao한테 보내준다는 말.
				}
				else {
					System.out.println("입력한 데이터가 너무 커서 입력이 불가합니다!!");
				}
				
				break; //do while 빠져나감
			}
			else if("n".equalsIgnoreCase(yn)){
				break;
			}
			else {
				System.out.println(">>y 또는 n만 입력하세요");
			}
			
			//////////////////////////////////////////////////
		}while(true);
		
		return result;   //int result = 0; 초기치를 0으로줬으니까 리턴값이 0이면 
		
		
		
	}//end of write--------------------


		
	

		
}