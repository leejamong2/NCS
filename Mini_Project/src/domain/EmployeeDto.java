package domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import myUtil.MyUtil;

//데이터베이스에서 domain 이란?
//엔티티의 속성들이 가질 수 있는 값들의 집합을 뜻하는 것이다.
//대부분의 DBMS에서 도메인이란 속성에 대응하는 컬럼에 대한 데이터 타입(Data Type)과 길이를 의미한다.

//=== DTO(Data Transfer Object, 데이터전송(운반)객체 )
//쉽게 말해서 DTO는 테이블의 1개 행(ROW)을 말한다.
//어떤 테이블에 데이터를 insert 하고자 할때 DTO에 담아서 보낸다.
//또한 어떤 테이블에서 데이터를 select 하고자 할때도 DTO에 담아서 읽어온다.
public class EmployeeDto {

	// userseq 얘들이 컬럼

	// field, attribute, property, 속성

	private int emp_seq;             // 회원번호 NN SQ
	private String emp_id;           // 회원아이디 NN UQ
	private String emp_email;        // 회원이메일 NN UQ
	private String emp_password;     // 회원비밀번호 NN
	private String emp_name;         // 회원이름 NN
	private String jubun;            // 주민번호 NN(13)
	private String emp_address;      // 주소
	private String emp_tel;          // 전화번호 NN
	private int status;              // status 컬럼의 값이 1 이면 가입된 상태, 0 이면 탈퇴된 상태 (DB 에서 update 로 볼 것이다.)

	// 데이터 유효성 검사는 생략하겠음.
	// method, operation, 기능


	//////////////////////////////////////////////


	public int getEmp_seq() {
		return emp_seq;
	}

	public void setEmp_seq(int emp_seq) {
		this.emp_seq = emp_seq;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		
		if (emp_id == null || emp_id.isBlank()) {
			System.out.println("[경고] 아이디는 공백이 아닌 값을 넣어주십시오.");
		}

		else {


			Pattern p = Pattern.compile("^[A-Za-z][A-Za-z0-9]{1,9}$");
			
			Matcher m = p.matcher(emp_id); // id 를 p 패턴에 맞춰준 값을 m 값에 맞춰준다/

			// == 3. 판별하도록 한다. == //
			if (m.matches()) { // matches 는 boolean 타입이다. 일치하면 true, 일치하지 않으면 false
				this.emp_id = emp_id;

			} else {
				System.out.println("[경고] 아이디는 첫글자는 영문이어야 하고 나머지는 " + "영문 또는 숫자로만 이루어진 글자길이는 3~10글자만 가능합니다.\n");

			} // end of if~else (m.matches() )-------------------------------------

		} // end of if~else------------------------------------------------------
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		
        Pattern pattern = Pattern.compile(emailRegex);
        if(pattern.matcher(emp_email).matches()) {
        	this.emp_email = emp_email;
        }else {
        	System.out.println("!!올바른 이메일 형식을 입력하시요!!");
        }
		
	}

	public String getEmp_password() {
		return emp_password;
	}

	public void setEmp_password(String emp_password) {
		if (MyUtil.isCheckPasswd(emp_password)) {
			this.emp_password = emp_password;
		}

		else {
			System.out.println("[경고] 비밀번호는 영대문자, 영소문자, 숫자, 특수문자가 혼합된 최소 8글자 이상 최대 15글자 이하이어야 합니다.\n");

		}
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
		
	}

	public String getJubun() {
		return jubun;
	}

	public void setJubun(String jubun) {
		if (MyUtil.isCheckJubun(jubun)) {
			this.jubun = jubun;
		} else {
			System.out.println("[경고] 주민번호 앞에서 부터 7자리 까지 올바르게 입력하세요!!\n");
		}
	}

	public String getEmp_address() {
		return emp_address;
	}

	public void setEmp_address(String emp_address) {
		this.emp_address = emp_address;
	}

	public String getEmp_tel() {
		return emp_tel;
	}

	public void setEmp_tel(String emp_tel) {
		this.emp_tel = emp_tel;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	
	@Override
	public String toString() {
		
		return "=== 나의 정보===\n"
			 + "◇ 성명 : " + emp_name + "\n"
 			 + "◇ 연락처 : " + emp_tel + "\n"
			 + "◇ 이메일 : " + emp_email + "\n";
	}
	
} // end of public class MemberDTO--------------------------
