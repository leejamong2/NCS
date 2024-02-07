package my.day15.c.overriding_overloading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.util.MyUtil;

public class CommonMember {
	
	// Gujikja 와 Company클래스에서 공통으로 사용되어지는 field (속성) 생성하기
	
	private String id;        	  // 아이디
	private String passwd;        // 비밀번호
	private String name;          // 성명 또는 회사명
	private String register_day;  // 가입일자 

	//구직자 및 컴퍼니 클래스의 부모클래스인 커먼멤버클래스의 기본생성자
	public CommonMember(){
		//System.out.println("== 부모클래스인 CommonMember 클래스의 기본생성자 호출 ==");
	
		 Date now = new Date();//현재시각
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   
		   register_day = df.format(now);
	
	}
	
	
	
	//캡슐화 되어진 필드를 메소드를 통해 접근하도록 만들기
   //getter, setter 하기  라고 부른당
   public void setId(String id) {
	   
	   if(id == null || id.isBlank() ) {
		   System.out.println("[경고] 아이디는 공백이 아닌 글자로 입력하셔야 합니다.\n");
	   }
	   else {
		   
		   // userid 는 첫글자는 반드시 영문대소문자로 시작해야하고 그나머지 글자는 
		   // 영문자 또는 숫자로만 이루어져야 한다.!
		   // 그리고 userid 의 길이는 최소 3글자, 최대 10글자로 제한한다. 
		   
		   // >>정규표현식(Regular Expression)이란? <<
		   // ==> 특정한 규칙을 가진 문자열의 집합을 표현하기 위해 쓰이는 형식언어
		   
		   // == 1. 정규표현식(Regular Expression) 패턴을 작성한다. == //
		   Pattern p = Pattern.compile("^[A-Za-z][A-Za-z0-9]{1,9}$");
		   // ^은 시작을 의미한다.
		   // $는 끝을 의미한다.
		   // []는 글자 1개가 들어오는 것을 의미한다.  A또는 B또는...Z또는 a또는 b또는...z
		   // [A-Za-z]는 글자 1개가 들어오는데 영문자만 가능하다 
		   // [A-Za-z0-9]는 글자 1개가 들어오는데 영문자 또는 숫자만 가능하다.
		   // [A-Za-z0-9]{1,9} 은 [A-Za-z0-9]이 최소 1번 반복, 최대 9번 반복해야 한다.
		   
		   // == 2. 문자열이 주어진 정규식 패턴과 일치하는지 판별하는 객체를 생성한다. == //
		   Matcher m = p.matcher(id);  //검사해야할 값을 ()에 넣어줌
		   
		   // == 3.판별하도록 한다. == //
		   if(m.matches()) {//불린타입
			   this.id = id;  //super 부모클래스, this 자기클래스
		
		   }
		   else {
			   System.out.println("[경고]아이디의 첫글자는 영문이어야 하고 나머지는 영문 또는 숫자로만 이루어진 글자길이는 3~10글자만 가능합니다.\n");
		   }
	   }
   
   }
   
   
   
	public String getId() {
		
		return id;
	}
		
	
	
	
	public void setPasswd(String passwd) {
		
		// 비밀번호는 영대문자, 영소문자, 숫자, 특수문자가 혼합된 최소 8글자 이상 최대 15글자 이하이어야 한다.
		if( MyUtil.isCheckPasswd(passwd) ) {
			this.passwd = passwd;	
		}
		else {
			System.out.println("[경고] 비밀번호는 영대문자, 영소문자, 숫자, 특수문자가 혼합된 최소 8글자 이상 최대 15글자 이하이어야 합니다.\n");
		}
	}

	
	public String getPasswd() {
		return passwd;
	}
	
	
	
/*	
	public void setName(String name) {
		// 성명은 공백이 없는 한글로만 이루어져야 하며 최소 2글자 이상 최대 6글자로만 되어져야 한다.
		
		if(name != null) {
			char[] ch_arr = name.toCharArray();
			
			boolean isOnly_hangul = true;
		    for(char ch : ch_arr) {
		       if( !('가' <= ch && ch <= '힣') ) {
		    	   isOnly_hangul = false;
		    	   break;
		       }
		    }// end of for-----------------
		    
		    if(2 <= ch_arr.length && ch_arr.length <= 6 
		       && isOnly_hangul) {
		    	this.name = name;
		    }
		    else {
		    	System.out.println("[경고] 성명은 공백이 없는 한글로만 이루어져야 하며 최소 2글자 이상 최대 6글자로만 되어져야 합니다.\n");
		    }
		}
		
	}
*/
	
	
  
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
   
   
   
	public String getRegister_day() {  //겟 만 해주면됨
	return register_day;
}





	//////////////////////////////////////////////////////////////////




	String parent_test() {
		return "부모클래스에서 만들었어요. 그냥 연습이에요!";  //메소드
	}



	public String getInfo() {
		
		return null;
	}

	public void view_all_info() {
			
		
		}
}
