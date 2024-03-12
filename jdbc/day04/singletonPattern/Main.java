package jdbc.day04.singletonPattern;

public class Main {
	
   // field, attribute, property, 속성
   
   // method, operation, 기능
   
   public void a_method() {
      NoSingletonNumber aObj = new NoSingletonNumber(); // 객체생성
      
      System.out.println("aObj =>" + aObj);
      System.out.println("a_method() 메소드에서 cnt 값 호출 : " + aObj.getNextNumber());  
   }
   
   public void b_method() {
      NoSingletonNumber bObj = new NoSingletonNumber(); // 객체생성
      
      System.out.println("bObj =>" + bObj);
      System.out.println("b_method() 메소드에서 cnt 값 호출 : " + bObj.getNextNumber());  
   }
   
   public void c_method() {
      NoSingletonNumber cObj = new NoSingletonNumber(); // 객체생성
      
      System.out.println("cObj =>" + cObj);
      System.out.println("c_method() 메소드에서 cnt 값 호출 : " + cObj.getNextNumber());  
   }   
   
   // =================================================
   public void d_method() {
      // SingletonNumber dObj = new SingletonNumber(); 
      // 객체생성이 불가하다.
      // 왜냐하면 SingletonNumber 생성자의 접근제한자를 private 으로 해두었기 때문이다.
      
      SingletonNumber dObj = SingletonNumber.getInstance(); // static 메소드 호출(접근제한자는 public 임)
      
      System.out.println("dObj =>" + dObj);
      System.out.println("d_method() 메소드에서 cnt 값 호출 : " + dObj.getNextNumber());  
   }
   
   
   public void e_method() {
      // SingletonNumber eObj = new SingletonNumber(); 
      // 객체생성이 불가하다.
      // 왜냐하면 SingletonNumber 생성자의 접근제한자를 private 으로 해두었기 때문이다.
      
      SingletonNumber eObj = SingletonNumber.getInstance(); // static 메소드 호출(접근제한자는 public 임)
      
      System.out.println("eObj =>" + eObj);
      System.out.println("e_method() 메소드에서 cnt 값 호출 : " + eObj.getNextNumber());  
   }
   
   public void f_method() {
      // SingletonNumber fObj = new SingletonNumber(); 
      // 객체생성이 불가하다.
      // 왜냐하면 SingletonNumber 생성자의 접근제한자를 private 으로 해두었기 때문이다.
      
      SingletonNumber fObj = SingletonNumber.getInstance(); // static 메소드 호출(접근제한자는 public 임)
      
      System.out.println("fObj =>" + fObj);
      System.out.println("f_method() 메소드에서 cnt 값 호출 : " + fObj.getNextNumber());  
	   }
   
   
   //////////////////////////////////////////////////////   

	public static void main(String[] args) {
		Main ma = new Main();
		ma.a_method();
		/*
		 	aObj=> jdbc.day04.singletonPattern.NoSingletonNumber@주소가 달라서 매번 cnt 0으로 초기화됨
		 	a_method() 메소드에서 cnt 값 호출 : 1
		 */
		ma.b_method();
		/*
		 	bObj=> jdbc.day04.singletonPattern.NoSingletonNumber@주소가 달라서 매번 cnt 0으로 초기화됨
		 	a_method() 메소드에서 cnt 값 호출 : 1
		 */
		ma.c_method();
		/*
		 	cObj=> jdbc.day04.singletonPattern.NoSingletonNumber@주소가 달라서 매번 cnt 0으로 초기화됨
		 	a_method() 메소드에서 cnt 값 호출 : 1
		 */
		
		System.out.println("\n"+"=".repeat(50)+"\n");
		
		//////////////////////////////////////////////////////
		
		ma.d_method();
		/*
		 	dObj => jdbc.day04.singletonPattern.NoSingletonNumber@주소가 항상같아서 c++됨 //해당패키지명.클래스명@주소
		 	d_method() 메소드에서 cnt 값 호출 : 1
		 */
		ma.e_method();
		/*
		 	dObj => jdbc.day04.singletonPattern.NoSingletonNumber@주소가 항상같아서 c++됨 //해당패키지명.클래스명@주소
		 	d_method() 메소드에서 cnt 값 호출 : 2
		 */
		ma.f_method();
		/*
		 	dObj => jdbc.day04.singletonPattern.NoSingletonNumber@주소가 항상같아서 c++됨 //해당패키지명.클래스명@주소
		 	d_method() 메소드에서 cnt 값 호출 : 3
		 */
	
		
		
		
		

	}

}
