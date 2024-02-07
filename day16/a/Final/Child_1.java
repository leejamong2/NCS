package my.day16.a.Final;

public class Child_1 extends Final_test_parent_1 {

	int age;
	
	void my_test() {
		System.out.println(">>연습입니다.<<");
		
	}

	//메소드 오버라이딩(재저의)
	@Override
	void greeting() {
		System.out.println("\n=== Hi Hello");
		
	}
	
/*	
  	@Override
	void rule() {  // 룰 메소드는 부모클래스에서 파이널메소드이기때문에 (오버라이딩)바꿀 수 없음
		System.out.println("\n=== Honesty ===\n");
	}
*/
	
}
