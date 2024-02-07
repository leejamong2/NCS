package my.day15.e.polymorphism;

public class Dog extends Animal{

	//도그 만 가지는 field 를 정의 (추상화)
	private int weight;

	
	//도그 만 가지는 field 를 정의 (추상화)
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		if(weight>0) {
			
		}
		this.weight = weight;
	}

	
	// == 메소드의 오버라이딩 == //
	@Override
	protected void view_info() {
		System.out.println("=== 강아지 정보 ===\n"
				+"1. 성명 : "+super.getName()+"\n"
				+"2. 생년 : "+super.getBirth_year()+"\n"
				+"3. 몸무게 : "+weight+"kg \n");
		
	}
	@Override
	protected void action() {
	System.out.println("[강아지가 빠르게 달립니다~~~]");
	}
}
