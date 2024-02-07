package my.day15.e.polymorphism;

import java.text.DecimalFormat;

public class Duck extends Animal{

	
	//덕 만 가지는 field 를 정의 (추상화)
	private int price;


	//덕 만 가지는 field 를 정의 (추상화)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price>0) {
			this.price = price;
		}
		
	}
		
	// == 메소드의 오버라이딩 == //
		@Override
		protected void view_info() {
			System.out.println("=== 오리 정보 ===\n"
					+"1. 성명 : " +super.getName()+"\n"
					+"2. 생년 : " +super.getBirth_year()+"\n"
					+"3. 가격 : " + new DecimalFormat("#,###").format(price)+"원 \n");
			
		}
		@Override
		protected void action() {
			System.out.println("[오리는 물가에서 헤엄을 칩니다.^^]");
			}
		

}
