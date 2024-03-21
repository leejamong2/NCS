package main;

import java.util.Scanner;

import controller.CompanyController;
import controller.EmployeeController;
import dbConnect.MyDBConnection;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		
		CompanyController companyController = new CompanyController();
		EmployeeController employeeController = new EmployeeController();
		

		String menuNo = "";
		
		boolean isRunning = true; 
		while(isRunning) {
			
			System.out.println(">>-----구인사이트 시작메뉴-----<<");
			System.out.println("1. 구직자 회원가입      2. 구인회사 회원가입      3.구직자 로그인      4. 구인회사 로그인       5.프로그램종료");
			System.out.println("-----------------------------------------------------------------------------------------");
			
			System.out.print("메뉴번호 선택 : ");
			menuNo = sc.nextLine();
			
			switch (menuNo) {
			case "1":
				
				employeeController.register(sc);
				
				
				
				break;
				
			case "2":
				
				companyController.register(sc);
		
				break;

				
			case "3":
				
				employeeController.login(sc);

				
				break;

				
			case "4":
				
				companyController.login(sc);
				
				break;

				
			case "5"://program shutdown
				
				isRunning = false;
				MyDBConnection.closeConnection();
				break;


				
				
				
				
			default:
				System.out.println("-----------!!올바른 메뉴번호를 입력해 주세요!!!-----------");
				
				
				break;
			}
			
			
		}
		
		System.out.println("-----프로그램 종료-----");

	}

}
