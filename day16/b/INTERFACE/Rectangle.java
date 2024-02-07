package my.day16.b.INTERFACE;

public class Rectangle implements Figure {
	//Rectangle 이라는 클래스는 Figure 라는 인터페이스를  implements(구현)한다는 말이다.
	
	
	@Override
	public double area(double x, double y) {
		
		return x*y;
	}  //extends는 클래스를 상속 받아오는거.  implements는 인터페이스 상속받아오는 것.

	@Override
	public double circle_area(double r) {
		return 0;
	}

	@Override
	public double circle_area(double x, double y) {
		
		return 0;
	}

	
	
}
