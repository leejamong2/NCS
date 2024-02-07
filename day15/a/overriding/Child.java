package my.day15.a.overriding;

public class Child extends Parent{
	
	//메소드의 오버라이딩(overriding)  == 메소드의 재정의
	//메소드의 오버라이딩(overriding) 시 접근제한자는 부모클래스에서 정의해둔 메소드의 접근제한자와 같거나 또는 더 큰것을 해야 한다.
	//또한 메소드의 오버라이딩(overriding) 시 껍데기(리턴타입, 메소드명, 파라미터)는 똑같아야 한다. 알맹이는 리모델링할거니까 새로 만들면됨.
	@Override  //@ 를 애노테이션(어노테이션)이라고 부른다.  부모에 없는 메소드를 썼을 경우 잘못됨을 알려줌.
	protected String info() {  //부모의 접근제한자 보다 같거나 커야함. 부모가protected라면 자식도protected 또는 public을 써줘야함.
		return "아이디 : " + super.id + "\n"   //부모님이 물려준 id+ " , " +passwd  를 리모델링 함
			 +"비밀번호 : " + super.passwd;
	
	}
	
}
