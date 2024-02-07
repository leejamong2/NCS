package my.day16.b.INTERFACE;

// === 인터페이스(interface)란? === //
// 오로지 미완성메소드(추상메소드)와 field는 final변수로만 이루어진 것을 말한다.
// 그리고 미완성메소드(추상메소드)와 field의 접근제한자는 public 으로만 되어진다.
// 미완성메소드(추상메소드) 생성시 public abstract 은 생략되어져 있다.
// field 생성시 public final 이 생략되어져 있다.

public interface Figure { 

	//== field == 
	//public double pi = 3.141592;   
	//또는 
	  double PI = 3.141592;  //public double 이 생략된 것이다. 위 코드와 같은말
	  
	  
	  //== method ==
	  double area(double x, double y);  //body 가 있으면 안됨.
	  //즉 public abstract double area(double x, double y); 이다.
	  
	  
	  //정원의 면적
	  double circle_area(double r);  //body 가 있으면 안됨.
	  //즉 public abstract double area(double x, double y); 이다.
	  
	  
	  //타원의 면적
	  double circle_area(double x, double y);  //body 가 있으면 안됨.
	  //즉 public abstract double area(double x, double y); 이다.
	  
	  
}
