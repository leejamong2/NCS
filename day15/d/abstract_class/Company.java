package my.day15.d.abstract_class;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Company extends CommonMember {  //상속되어진 부모클래스에 있는 겟인포라는 미완성 메소드는 오버라이딩 해야한다.
//company 클래스는 commonMember 클래스에 생성되어진 필드 및 메소드를 및 생성자를 상속 받아온다.
//CommonMember 클래스는 Gujikjad클래스의 부모 클래스가 되어지고,
//구직자클래스는 커먼멤버 클래스의 자식클래스가 됨	
	
	// field 생성
	// 필드의 캡슐화=은닉화
	
	
	
	String business_number; // 사업자등록번호 
	String job_type;
	long seed_money;
	

	static int count;  	// int가 인스턴스 변수였는데 스태틱(모두가공유)으로 쓸거야. 스태틱은 객체생성 안해도됨 //Company객체 개수를 알아오려는 용도

	//기본생성자 생략됨
	/* public Company() {
		   super();  //구직자 클래스의 부모클래스인 커먼멤버 클래스의 기본생성자 이다. 생략가능
	   }
	*/
	
	
	// == 메소드의 오버라이딩 == 부모클래스에 있는 셋네임을 바꾸고싶다. 한글영어 둘다 가능하도록
	@Override
	public void setName(String name) {
		
		//회사명은 공백이 없는 한글 또는 영문만 이루어져야 하며 최소 2글자 이상 최대10글자로만 되도록 바꾼다.
		
			   // == 1. 정규표현식(Regular Expression) 패턴을 작성한다. == //
			   Pattern p = Pattern.compile("^[가-힣A-Za-z]{2,10}$");
		   
			   
			   // == 2. 문자열이 주어진 정규식 패턴과 일치하는지 판별하는 객체를 생성한다. == //
			   Matcher m = p.matcher(name);  //검사해야할 값을 ()에 넣어줌
			   
			   
			   // == 3.판별하도록 한다. == //
			   if(m.matches()) {//불린타입
				   	super.setName(name);
			   }
			   else {
				   System.out.println("[경고2] 성명은 공백이 없는 영문 또는 한글로만 이루어져야 하며 최소 2글자 이상, 6글자 이하여야 합니다.");
			   }   
		   }
		   
		
	
	
	
	public String getBusiness_number() {
		return business_number;
	}
	
	public void setBusiness_number(String business_number) {

		//사업자등록번호는 오로지 숫자로만 들어와야하며 
		//첫글자는 0이 들어올 수 없다.
		//또한 사업자 등록번호의 길이는 10글자가 되어야한다.
		
		// == 1. 정규표현식(Regular Expression) 패턴을 작성한다. == //
		Pattern p = Pattern.compile("^[1-9][0-9]{9}$");  
		   // ^은 시작을 의미한다.
		   // $는 끝을 의미한다.
		   // []는 글자 1개가 들어오는 것을 의미한다.  A또는 B또는...Z또는 a또는 b또는...z
		   // [1-9]는 글자 1개가 들어오는데 1부터 9까지만 가능하다 
		   // [0-9]{9}는 글자 1개가 들어오는데 숫자 0부터 9까지만 가능하다. 갯수는 9번 반복해야한다.
		   
		   // == 2. 문자열이 주어진 정규식 패턴과 일치하는지 판별하는 객체를 생성한다. == //
		   Matcher m = p.matcher(business_number);  //검사해야할 값을 ()에 넣어줌
		   
		   // == 3.판별하도록 한다. == //
		   if(m.matches()) {//불린타입
			   this.business_number = business_number;  //super 부모클래스, this 자기클래스
		
		   }
		   else {
			   System.out.println("[경고]사업자등록번호는 숫자로 10자리만 가능합니다. 첫글자엔 0이 안돼요!!\n");
		   }
		   
	}

	public String getJob_type() {
		return job_type;
	}
	
	public void setJob_type(String job_type) {
		
		if(job_type == null || job_type.isBlank()) {
			System.out.println("[경고]회사직종군은 공백이 아닌 글자로 입력해야합니다\n");	
		}
		else {
			this.job_type = job_type;
		
	}
	
	
	}

	
	public long getSeed_money() {
		return seed_money;
	}
	
	public void setSeed_money(long seed_money) {
		
		
		if(seed_money<0) {
		System.out.println("[경고] 자본금은 0보다 커야 합니다.\n");
		}
		else {
			this.seed_money = seed_money;
		}
	}

	  // >> 메소드의 오버라이딩 << //
	@Override
	public String getInfo() {
		
		
		DecimalFormat df = new DecimalFormat("#,###");
		
				
					//회사명  			 업종  			 사업자등록번호  			 자본금
		return super.getName()+"\t" + job_type+ "\t"+ business_number+"\t"+df.format(seed_money)+ "원";  //부모가 프라이빗으로 해놔서 겟으로 가져와야지
		
	}//end of public String getInfo()------------------------


	
	
	
}

