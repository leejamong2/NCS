package my.day15.b.overloading;

public class Child extends Parent{
	
	//field
	String name; //상속받아오고 하나 더 만듬
	
	// == 메소드의 오버라이딩(overriding)  == 메소드의 재정의 == //
	//메소드의 오버라이딩(overriding) 시 접근제한자는 부모클래스에서 정의해둔 메소드의 접근제한자와 같거나 또는 더 큰것을 해야 한다.
	//또한 메소드의 오버라이딩(overriding) 시 껍데기(리턴타입, 메소드명, 파라미터)는 똑같아야 한다. 알맹이는 리모델링할거니까 새로 만들면됨.
	@Override  //@ 를 애노테이션(어노테이션)이라고 부른다.  부모에 없는 메소드를 썼을 경우 잘못됨을 알려줌.
	public String info() {  //부모의 접근제한자 보다 같거나 커야함. 부모가protected라면 자식도protected 또는 public을 써줘야함.
		return "아이디 : " + super.id + "\n"   //부모님이 물려준 id+ " , " +passwd  를 리모델링 함
			 +"비밀번호 : " + super.passwd;
	}
	
	//둘의 차이점 오버라이딩 : 부모로부터 상속받은 메소드를 내용물을 바꾸는데 메소드의 리턴타입 이름 파라미터는 똑같아야한다 접근제한자는 같거나 커야함.
	//		   오버로딩	 : 어떤 클래스에서 메소드를 만들 때 중복되었냐. 중복되지 않게하기위함. 파라미터의 타입, 갯수, 위치중 하나만이라도 다르게하면 중복으로 보지 않음. 올바름.
	
	
	// == 메소드의 오버로딩(overloading) == //
	//메소드의 이름은 같지만 파라미터가 다르면 중복되지 않음으로 본다.
	public void info(int n) { //같은 이름의 메소드는 안되니까 파라미터(변수는 상관없고 타입을 다르게 하거나, 갯수를 다르게 하거나 타입이 같아도 위치만 다르게 가능.)를 만들어주면 됨. 
		System.out.println();
	}


	public void info(short m) { // 메소드의 리턴타입, 파라미터의 변수는 상관없음. => 파라미터 타입 다르게
		System.out.println();
	}

	public void info(int a, String str) { // 접근제한자, 메소드의 리턴타입, 파라미터의 변수는 상관없음. => 파라미터 갯수 다르게
		System.out.println();
	}
	public void info( String s, int b) { // 접근제한자, 메소드의 리턴타입, 파라미터의 변수는 상관없음. => 파라미터 위치 다르게
		System.out.println();
	}
	public String info( String s, int b, byte d) { // 접근제한자, 메소드의 리턴타입, 파라미터의 변수는 상관없음.                                                파라미터의 변수는 상관없음. 마라미터의 타입, 위치, 갯수 중 하나만 다르게하면 가능. 
		return "";
	}
	private void info( int b, String s,  byte d) { // 접근제한자, 메소드의 리턴타입, 파라미터의 변수는 상관없음.                                                파라미터의 변수는 상관없음. 마라미터의 타입, 위치, 갯수 중 하나만 다르게하면 가능. 
		System.out.println();
	}
	
	
	
	// == 생성자의 오버로딩 == //
	public Child() {
		
	}
	
	public Child(String id, String passwd) {
		this.id = id;
		this.passwd = passwd;
	}

	public Child(String id, String passwd, String name) {
		this(id, passwd);	
		this.name = name;      
							
//	public Child(String id, String passwd, String name) {
//		this(id, passwd);	
//		this.name = name;    이렇게 생성자 안에서 다른 생성자를 쓸 때 이렇게 다른걸 먼저 쓰면 꽝이다.  
	 
	}	
	
	
	
	
	

}
