package controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import domain.CompanyDto;
import domain.CompanyLoginDto;
import model.CompanyDao;
import model.CompanyDaoImple;



public class CompanyController {
	
	private CompanyDao companyDao = new CompanyDaoImple();
	
	
	private void companyMenu(Scanner sc, CompanyLoginDto loggedInComp) {
		
		CompanyLoginDto member = loggedInComp;

		String s_Choice = "";

		while(loggedInComp != null) {
			
	
				
			System.out.println("-".repeat(70));
			System.out.println("============================== ◆ 주식회사 "+ member.getComp_name() +" 님 전용메뉴 ◆ ==============================");
			System.out.println("1. 회사정보 보기   2. 회사정보 수정   3. 모든구직자 조회   4. 구직자 검색   5. 채용공고입력하기"
					+ "6. 우리회사 채용공고 조회   7. 우리회사   8.채용공고지원자 조회   9.로그아웃   10. 회사 탈퇴하기");
			System.out.println("-".repeat(70));
			System.out.println("▷메뉴번호 선택 : ");
			s_Choice = sc.nextLine();
			
			switch (s_Choice) {
				case "1": // 1. 회사정보 보기
					break;
					
				case "2": // 2. 회사정보 수정
					break;
					
				case "3": // 3.  모든구직자 조회
					break;
					
				case "4": // 4. 구직자 검색
					break;
					
				case "5": // 5. 채용공고입력하기
					break;
					
				case "6": // 6. 우리회사 채용공고 조회
					break;
					
				case "7": // 7. 우리회사
					break;
					
				case "8": // 8. 채용공고지원자 조회
					break;
				
				case "9": // 9.로그아웃
					
					String affirm = "";
					do {
						
						System.out.println("정말 로그아웃 하시겠습니까?[y/n]");
						affirm = sc.nextLine();
						
						if("y".equalsIgnoreCase(affirm)) {
							loggedInComp = null;						
							System.out.println("로그아웃 성공!!");
							
						} else if("n".equalsIgnoreCase(affirm)) {
							System.out.println("로그아웃 취소");
							
						}
					}while(!("y".equalsIgnoreCase(affirm) || "n".equalsIgnoreCase(affirm)));
					
					break;
				case "10": // 10. 회사 탈퇴하기
					break;
					
				default:
					break;
				}

		}
		
		
	}
	

	public void register(Scanner sc) {
		
		System.out.println("\n >>> ---- 기업 회원가입 ---- <<<");

		
		System.out.print("1. 아이디 : ");
		String comp_id = sc.nextLine();

		System.out.print("2. 비밀번호 : ");
		String passwd = sc.nextLine();

		System.out.print("3. 회사명 : ");
		String comp_name = sc.nextLine();

		System.out.print("4. 회사이메일 : ");
		String comp_emal = sc.nextLine();
		
		System.out.print("5. 기업규모(중,소,대) : ");
		String comp_scale = sc.nextLine();
		
		System.out.print("6. 설립일 : ");
		String comp_est_date = sc.nextLine();
		
		System.out.print("7. 회사주소 : ");
		String comp_addr = sc.nextLine();
		
		System.out.print("8. 대표자 : ");
		String comp_ceo = sc.nextLine();
		
		System.out.print("9. 사원수 : ");
		String comp_emp_cnt = sc.nextLine();
		
		System.out.print("10. 자본금 : ");
		String comp_capital = sc.nextLine();
		
		System.out.print("11. 매출액 : ");
		String comp_sales = sc.nextLine();
		
		System.out.print("12. 사대보험여부 : ");
		String comp_insurance = sc.nextLine();
		
		
		CompanyLoginDto memberLogin = new CompanyLoginDto();
		memberLogin.setComp_id(comp_id);
		memberLogin.setComp_password(passwd);
		memberLogin.setComp_name(comp_name);
		
		
		CompanyDto member = new CompanyDto();
		member.setComp_id(comp_id);
		member.setComp_email(comp_emal);
		member.setComp_name(comp_name);
		member.setComp_scale(comp_scale);
		member.setComp_est_date(comp_est_date);
		member.setComp_addr(comp_addr);
		member.setComp_ceo(comp_ceo);
		member.setComp_emp_cnt(Integer.parseInt(comp_emp_cnt));
		member.setComp_capital(Integer.parseInt(comp_capital));
		member.setComp_sales(Integer.parseInt(comp_sales));
		member.setComp_insurance(comp_insurance);
		
//		memberLogin.setCdto(member);

		// DTO 에 보낸 값을 실제로 DB 에 보내줘야한다. DAO(Database Access Object) 데이터베이스에 접근해서 어떠한
		// 일처리를 하는(DDL, DML, procedure 등등의 일처리를 해주는) 객체
		// 전개도를 보면 된다.

		int n = companyDao.memberRegister(member, memberLogin);

		// memberRegister 에 값을 성공적으로 받았을 경우 1 못받았을 경우 0(else)
		if (n == 1) {
			System.out.println("\n >>> 회원가입을 축하드립니다. <<<");
		} else {
			System.out.println(">>> 회원가입이 실패되었습니다. <<<");
		}
		
	}

	public void login(Scanner sc) {
		
		CompanyLoginDto comLoginMem = null;
		System.out.println("\n >>> --- 로그인 --- <<<");
		
		System.out.println("▷ 아이디 : ");
		String userid = sc.nextLine();
		
		System.out.println("▷ 비밀번호 : ");
		String passwd = sc.nextLine();
		
		// userid, passwd, email, ~~~ 등을 map에 담는다. 
		
		Map<String, String> paraMap = new HashMap<>(); //맵은 넣을때 제한이 없다
		paraMap.put("userid", userid); //맵에 넣는 것 key , value - userid가 pk므로 1개 행 나옴 - 없으면 null
		paraMap.put("passwd", passwd);
		
		
		comLoginMem = companyDao.login(paraMap); //MemberDAO_imple 실행
		
		if(comLoginMem != null) {
			this.companyMenu(sc, comLoginMem);
		} else {
			System.out.println("\n >>> [경고] 아이디나 비밀번호 오류입니다. 다시 입력해주세요.<<< ");
		}
		
		
	}
	
	
	

}
