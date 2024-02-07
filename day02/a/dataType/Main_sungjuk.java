package my.day02.a.dataType;

public class Main_sungjuk {

	public static void main(String[] args) {
		
		double db1 = 12.345F;
		double db2 = 12.345678912356F;
		          // 12.3456789  //... 반올림되면서 소수점 뒤7자리로 바뀜
		
		
		Sungjuk lss_sungjuk = new Sungjuk();
		lss_sungjuk.hakbun = "091234";
		lss_sungjuk.name = "이순신";
		lss_sungjuk.kor = 68;
		lss_sungjuk.eng = 96;
		lss_sungjuk.math = 100;
		
		Sungjuk eom_sungjuk = new Sungjuk();
		eom_sungjuk.hakbun = "109876";
		eom_sungjuk.name = "엄정화";
		eom_sungjuk.kor = 79;
		eom_sungjuk.eng = 58;
		eom_sungjuk.math = 95;
		
		lss_sungjuk.sungjuk_print();
		/*
		    === 이순신님의 성적결과 ===
		    1.학번 : 091234
		    2.성명 : 이순신
		    3.국어 : 68
		    4.영어 : 96
		    5.수학 : 100 
		  
		*/
		
		eom_sungjuk.sungjuk_print();
		/*
	        === 엄정화님의 성적결과 ===
	        1.학번 : 109876
		    2.성명 : 엄정화
		    3.국어 : 78
		    4.영어 : 88
		    5.수학 : 95 
	    */
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		Sungjuk.boolean_print(); 
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		Sungjuk.char_print(); 
		
	}

}
