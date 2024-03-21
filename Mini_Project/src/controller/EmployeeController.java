package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import domain.CompanyDto;
import domain.EmployeeDto;
import domain.EmployeeLoginDto;
import model.EmployeeDao;
import model.EmployeeDaoImple;

public class EmployeeController {
	
	private EmployeeDao employeeDao = new EmployeeDaoImple();
	
	private void employeeMenu(Scanner sc, EmployeeLoginDto loggedInEmp) {
		
		//dto가 null 이 아닐때 while로 메뉴 출력 무한 반복
		
		
EmployeeLoginDto member = loggedInEmp;
	
		
		
		String s_Choice = "";
		//매개변수 loggedInEmp가 null이 아닐때 while로 메뉴 출력 무한 반복
		// login 메소드에서 empLoginMem 변수가 loggedInEmp로 들어옴(타입일치)
		while(loggedInEmp != null) {
	
			
			System.out.println("-".repeat(70));
			System.out.println("============================== ◆ "+ member.getEmp_name() +" 님 전용메뉴 ◆ ==============================");
			System.out.println("1. 내정보 보기   2. 내정보 수정   3. 이력서 작성하기   4.모든구인회사 조회   5. 구인회사 검색하기 \n"
					+ "6. 모든채용공고 조회   7. 채용응모하기    8. 채용응모한것조회    9.로그아웃   10. 회원탈퇴  ");
			System.out.println("-".repeat(70));
			System.out.println("▷메뉴번호 선택 : ");
			s_Choice = sc.nextLine();
			
			switch (s_Choice) {
				case "1": // 1. 내정보 보기
				    // 괄호에 loggedInEmp 넣어도되는지??? 
					break;
					
				case "2": // 2. 내정보 수정
					break;
					
				case "3": // 3. 이력서 작성하기
					break;
					
				case "4": // 4.모든구인회사 조회
					
					break;
					
				case "5": // 5. 구인회사 검색하기
					break;
					
				case "6": // 6. 모든채용공고 조회
					break;
					
				case "7": // 7. 채용응모하기
					break;
					
				case "8": // 8. 채용응모한것조회
					break;
				
				case "9": // 9.로그아웃
					System.out.println("정말 로그아웃 하시겠습니까?[y/n]");
					String isComfirm = sc.nextLine();
					do {
						if("y".equalsIgnoreCase(isComfirm)) {
							loggedInEmp = null;	
							System.out.println("로그아웃 되었습니다");
							return;
						} else if("n".equalsIgnoreCase(isComfirm)) {
							System.out.println("로그아웃 취소");
				
						}
					}while(!("y".equalsIgnoreCase(isComfirm) || "n".equalsIgnoreCase(s_Choice)));
					
					break;
				case "10": // 10. 회원탈퇴
					break;
					
				default:
					break;
				}
				
				
		}
		
		
		
	}

	

	public void register(Scanner sc) {
		
		
		EmployeeDto employeeDto = new EmployeeDto();
		EmployeeLoginDto employeeloginDto = new EmployeeLoginDto();
		
		
		System.out.println("---------------구직자 회원가입-----------------");

		
		String emp_id = "";
		while(employeeDto.getEmp_id() == null) {
			System.out.print("사용하실 아이디 입력 : ");
			emp_id = sc.nextLine();
			employeeDto.setEmp_id(emp_id);
			
		}
		employeeloginDto.setEmp_id(emp_id);
		
		String emp_password = "";
		while(employeeloginDto.getEmp_password() == null) {
			System.out.print("사용하실 비밀번호 입력 : ");
			emp_password = sc.nextLine();
			employeeloginDto.setEmp_password(emp_password);
		}
		
		String emp_name = "";
		while(employeeDto.getEmp_name() == null) {
			
			System.out.print("이름 입력: ");
			emp_name = sc.nextLine();
			employeeDto.setEmp_name(emp_name);
			employeeloginDto.setEmp_name(emp_name);
		}
		
		String emp_email = "";
		while(employeeDto.getEmp_email() == null) {
			System.out.print("사용하실 이메일 주소 입력: ");
			emp_email = sc.nextLine();
			employeeDto.setEmp_email(emp_email);
		}
		
		String emp_addr = "";
		while(employeeDto.getEmp_address() == null) {
			System.out.print("거주지 입력: ");
			emp_addr = sc.nextLine();
			employeeDto.setEmp_address(emp_addr);
		}
		
		String emp_jubun = "";
		while(employeeDto.getJubun() == null) {
			System.out.print("주민번호 7자리 입력 : ");
			emp_jubun = sc.nextLine();
			employeeDto.setJubun(emp_jubun);
		}
		
		String emp_tel = "";
		while(employeeDto.getEmp_tel() == null) {
			System.out.print("전화번호 입력 : ");
			emp_tel = sc.nextLine();
			employeeDto.setEmp_tel(emp_tel);
		}
		
		
		
		boolean isConfirm = false;
		
		while(isConfirm == false) {
			System.out.print("이 정보로 회원가입 하시겠습니까? Y/N : ");
			String choice = sc.nextLine();
			
			if(choice.equalsIgnoreCase("y")) {
				isConfirm = true;
				int isSuccess = employeeDao.register(employeeDto, employeeloginDto);
		
				if(isSuccess == 1) {
					
					System.out.println("-----회원가입 성공!!-----");
				}else {
					
					System.out.println("-----회원가압 실패!!-----");
				}
				
				
			}else if(choice.equalsIgnoreCase("n")) {
				isConfirm = true;
				System.out.println("!!회원가입 취소!!");
			}else {
				
				System.out.println("!!!똑바로 입력하시오!!!");
			}
			
			
			
			
		};
		
		

		
		
		
	}

	public void login(Scanner sc) {
		// TODO 로그인 성공시 EmployDto를 메뉴 메소드에 넘겨줌
		
		
		// EmployeeDao 불러와서 dao에서 준 dto가 있으면 -> dto 던져줌
			// 로그인 성공할시
			// private void employeeMenu(Scanner sc, EmployeeDto loggedInEmp) 호출
			// 실패 >> 실패하였습니다 출력
				
		
		EmployeeLoginDto empLoginMem = null;
		System.out.println("\n >>> --- 로그인 --- <<<");
		
		System.out.println("▷ 아이디 : ");
		String userid = sc.nextLine();
		
		System.out.println("▷ 비밀번호 : ");
		String passwd = sc.nextLine();
		
		// userid, passwd, email, ~~~ 등을 map에 담는다. 
		
		Map<String, String> paraMap = new HashMap<>(); //맵은 넣을때 제한이 없다
		paraMap.put("userid", userid); //맵에 넣는 것 key , value - userid가 pk므로 1개 행 나옴 - 없으면 null
		paraMap.put("passwd", passwd);
		
		
		empLoginMem = employeeDao.login(paraMap); //MemberDAO_imple 실행
		
		if(empLoginMem != null) {
			this.employeeMenu(sc, empLoginMem);
		} else {
			System.out.println("\n >>> [경고] 아이디나 비밀번호 오류입니다. 다시 입력해주세요.<<< ");
		}
		

	}
	
	
	
		
		
		
	
	
	
	

}
