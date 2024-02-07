package my.day16.c.INTERFACE_inheritance;

public class Child implements Inter_child {  //추상메소드 반드시 오버라이딩 해야함

	@Override
	public void work() {
		System.out.println("보람차게 일합니다");
		
	}

	@Override
	public void cook() {
		System.out.println("맛있는 요리를 합니다");
		
	}

	@Override
	public void play() {
		System.out.println("재미나게 놀아요^^");
		
	}  

}
