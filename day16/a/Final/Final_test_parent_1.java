package my.day16.a.Final;

public class Final_test_parent_1 {

	
	//field
	String id;
	String name;
	
	//field 에 파이널 을 붙이면 더이상 새로운 값으로 할당할 수 없다.
	final double PI =3.141592;  //상수변수
	
	
	//method
	void greeting() {
		System.out.println("~~~~~~~~안녕하세요~~~~~~");
		
	}
	
	//메소드에 파이널을 붙이면 자식클래스에서 메소드 오버라이딩(재정의)을 할 수 없게 된다.
	final void rule() {
		System.out.println("~~~정직하게 삽시다~~~");
	}
	
}
