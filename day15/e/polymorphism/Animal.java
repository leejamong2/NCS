package my.day15.e.polymorphism;



	/*
    ---------------------------------------------------------------------------------------------------------------------------
   접근제한자(접근지정자, accessmodifier)   자기자신클래스내부      동일패키지에있는다른클래스      다른패키지에있는하위(자식)클래스       그외의영역  
   --------------------------------------------------------------------------------------------------------------------------- 
   public                                    O                    O                         O                        O  
   protected                                 O                    O                         O                        X
   없음(default)                              O                    O                         X                        X
   private                                  O                    X                         X                        X
	*/
	
// === 미완성 클래스 (추상클래스) abstract class === // 
public abstract class Animal {
	
	
	//덕 캣 도그 의 공통 field(추상화)
	private String name;
	private int birth_year;
	
	
	//덕 캣 도그 의 공통 method(추상화)
	protected String getName() { 
		return name;
	}
	protected void setName(String name) { //널 공백 아니라면은 오케이
		if(name != null && !name.isBlank()) {
			this.name = name;
		}
		
	}
	protected int getBirth_year() {
		return birth_year;
	}
	protected void setBirth_year(int birth_year) {
		if(birth_year>0) {
		this.birth_year = birth_year;
		}
	
	}
	
	
	
	
	// === 미완성 메소드 (추상메소드) abstract method === //
	protected abstract void view_info();
	protected abstract void action();
	
	
}
