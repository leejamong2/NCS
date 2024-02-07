package my.day15.a.overriding;

public class Main {

	public static void main(String[] args) {
		
		Child cd = new Child();

		cd.id = "leess";
		cd.passwd = "Qwer1234$";
		
		//자식클래스인 child클래스에서 info() 메소드를 오버라이딩 하기 전
	//	System.out.println(cd.info());  //상속이 패런트
		//leess , Qwer1234$
		
		
		//자식클래스인 child클래스에서 info() 메소드를 오버라이딩 한 후
		System.out.println(cd.info());  //상속이 차일드
		/*
		 	아이디 : leess
			비밀번호 : Qwer1234$
		*/
		
		
		
		
		
	}

}
