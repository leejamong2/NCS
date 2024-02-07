package my.day16.b.INTERFACE;

public class Ellipse implements Figure {
	//Ellipse 이라는 클래스는 Figure 라는 인터페이스를  implements(구현)한다는 말이다.
	
	@Override
	public double area(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double circle_area(double r) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double circle_area(double x, double y) {
		
		return PI*x*0.5*y*0.5;
	}

}
