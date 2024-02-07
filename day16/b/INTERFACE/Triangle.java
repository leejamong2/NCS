package my.day16.b.INTERFACE;

public class Triangle implements Figure {
	//Triangle 이라는 클래스는 Figure 라는 인터페이스를  implements(구현)한다는 말이다.
	
	@Override
	public double area(double x, double y) {
		
		return x*y*0.5;
	}

	@Override
	public double circle_area(double r) {  //안쓰더라도 오버라이딩 해야 함.
		return 0;
	}

	@Override
	public double circle_area(double x, double y) {
		
		return 0;
	}
	
	
	
}
