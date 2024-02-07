package my.day01;

//import java.lang.*; // *의 뜻은 모든 것을 의미하다.
// 즉, java.lang 패키지속에 있는 모든 클래스들을 사용하겠다는 말이다.
//기본적으로  import java.lang.*; 은 생략되어있다.

public class Member {

/*
  만약에 쇼핑몰 프로그램을 작성하고자 한다면
  회원, 제품, 장바구니, 주문내역 등등 부품이 필요할 것이다.
  여기서 필요로 하는 부품의 설계도면을 "클래스" 라고 보면 된다.
 */
	// 추상화 ==> 필요한 속성 및 기능만 뽑아내는 것을 말한다.
	// 회원가입(병원) ==> 신장, 몸무게 혈액형, 혈압
	// 회원가입(쇼핑몰) ==> 아이디, 비밀번호, 이메일, 성명, 주소, 전화번호, 마일리지(포인트), ...
	// attribute == property == field == 속성
	

	
	
	/*
	 1). instance(인스턴스)변수
        -- instance(인스턴스)변수를 다른말로 non static 변수라고도 한다. 
        -- instance(인스턴스)는 클래스가 메모리(RAM)에 올라가서 실제 사용가능한 객체로 되어진 상태를 말하는 것이다.
        -- instance(인스턴스)변수는 서로 다른 instance 끼리 공유하지 못하고 각자 자기의 instance 내에서만 사용하는 것이다.
	  */
  String id; // String 은 문자열을 뜻하는 클래스이다.
             // id 라는 변수(변하는 수)에는 문자열이 들어온다는 뜻이다.
  
  String pwd; //비밀번호
  String name; //성명
  String email; //이메일
  
  // id, pwd, name, email은 instance(인스턴스) 변수라고 부른다.  암기
	
  
  /*
     2). static변수
        -- static변수는 동일한 클래스로 생성되어진 서로 다른 인스턴스들 끼리 공유하는 변수이다.
        
   */
	
  static String address; //변수
	
	
	
	
	
	
}
