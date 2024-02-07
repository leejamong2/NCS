package my.day05.e.For;

/*
 **** 반복문(loop) ==> for 문 ****
  
    ※ for 문의 형식
   
    for(초기화; 조건식; 증감식) {
          반복해서 실행할 문장;
    }  
    
    ▣ 순서
    1) 초기화;
    2) 조건식; (조건식이 참(true)이라면 반복해서 실행할 문장;을 실행하고서 } 을 못빠져나간다.         
                              조건식이 거짓(false)이라면 반복해서 실행할 문장;을 실행하지 않고
               } 을 빠져나간다.)
    3) 증감식
    4) 조건식; (조건식이 참(true)이라면 반복해서 실행할 문장;을 실행하고서 } 을 못빠져나간다.         
                              조건식이 거짓(false)이라면 반복해서 실행할 문장;을 실행하지 않고
               } 을 빠져나간다.) 
    5) 증감식
    6) 조건식; (조건식이 참(true)이라면 반복해서 실행할 문장;을 실행하고서 } 을 못빠져나간다.         
                              조건식이 거짓(false)이라면 반복해서 실행할 문장;을 실행하지 않고
               } 을 빠져나간다.)                                                  
    
*/



public class Main_for_1 {

	public static void main(String[] args) {
		
		 for(int i=0; i<10; i++) {
	          System.out.println((i+1)+".안녕자바~~");    //// (거짓)실행 안해 = for문 빠져나옴.  (참)반복해서 실행할 문장.->증감->조건->증감->조건->...(거짓)나올때까지.
	    }  
		 
		/*
		  1.안녕자바~~
		  2.안녕자바~~
		  3.안녕자바~~
		  4.안녕자바~~
		  5.안녕자바~~
		  6.안녕자바~~
		  7.안녕자바~~
		  8.안녕자바~~
		  9.안녕자바~~
		  10.안녕자바~~
		 */		
		 
		 
		 
		 System.out.println("-------------------------");		 
		 for(int i=0; i<10; i+=1) {  //i+=1; 은 i=i+1; 와 같음
			 System.out.println((i+1) + ".안녕Java~~");
			 
		 }
		 
		 
		 /*
		  1.안녕Java~~
		  2.안녕Java~~
		  3.안녕Java~~
		  4.안녕Java~~
		  5.안녕Java~~
		  6.안녕Java~~
		  7.안녕Java~~
		  8.안녕Java~~
		  9.안녕Java~~
		  10.안녕Java~~
		 */		
		 
		 
		 
		 System.out.println("-----------------------"); 
		 for(int i=0; i<10; i++) {  //i+=1; 은 i=i+1; 와 같음
			 System.out.println( ++i + ".안녕 이클립스~~" );
		 }
		 /*
		  1.안녕 이클립스~~	
		  3.안녕 이클립스~~
		  5.안녕 이클립스~~
		  7.안녕 이클립스~~
		  9.안녕 이클립스~~
		 */		
 
		 System.out.println("-----------------------");
		 for(int i=0; i<10; i+=2) {  //i+=2; 은 i=i+2; 와 같음
			 System.out.println((i+1) + ".안녕 Eclipse~~");
		 }
		 /*
		  1.안녕 Eclipse~~	
		  3.안녕 Eclipse~~
		  5.안녕 Eclipse~~
		  7.안녕 Eclipse~~
		  9.안녕 Eclipse~~
		 */		
		 
		 
		 System.out.println("-----------------------");
		 for(int i=0, j=0; i<10; i++, j+=2) {
			 System.out.println((j+1)+".안녕 오라클~~");			 
		 }
	 /*  1.안녕 오라클~~
		 3.안녕 오라클~~
		 5.안녕 오라클~~
		 7.안녕 오라클~~
		 9.안녕 오라클~~
		 11.안녕 오라클~~
		 13.안녕 오라클~~
		 15.안녕 오라클~~
		 17.안녕 오라클~~
		 19.안녕 오라클~~
	 */
		 
		 
		 System.out.println("-----------------------");
		 for(int i=10; i>0; i--) {
			 System.out.println(i+".안녕 Oracle~~");			 
		 }
		 
		 
		 System.out.println("-----------------------");
		 for(int i=10; i>0; i-=1) {  //i-=1;은 i=i-1과 같다
			 System.out.println(i+".안녕 스프링~~");	
		 }
		 
		 
		 
		 System.out.println("-----------------------");	
		 
		 for(int i=10; i>0; i--) {  //i-=1;은 i=i-1과 같다
			 if(i%2 != 0) {  // i%2 는 i를2로 나누었을 때 나머지.		
			 System.out.println(i+".안녕 Spring~~");	
			 }
		 } 
			 
		 
		 System.out.println("-----------------------");	
		 
		 for(int i =10; i>0; i-=2) {
			 System.out.println((i-1)+".안녕하십니까?~~");
		 }
		 /*		 9.안녕하십니까?~~
				 7.안녕하십니까?~~
				 5.안녕하십니까?~~
				 3.안녕하십니까?~~
				 1.안녕하십니까?~~
		 */
		 
		 
		 System.out.println("-----------------------");	
		 for(int i=10; i>0; i--){
			 System.out.println(--i +".Hello~~");  //전위, 후위 바뀔 수 있음.
		 }
	/*	 
	 	9.Hello~~
		7.Hello~~
		5.Hello~~
		3.Hello~~
		1.Hello~~
   */

		 System.out.println("-----------------------");	
		 for(int i=0, j=9; i<5; i++, j-=1){
			 System.out.println(j+".헬로~~");
		 }
	 /*	 
		 	9.헬로~~
			7.헬로~~
			5.헬로~~
			3.헬로~~
			1.헬로~~
	 */

		 System.out.println("-----------------------");	
		 int i=0;
		 for(; i<5; i++){     //int i=0;
			 System.out.println((i+1)+".길동");
		 }//end of for-----------------
		 
		 System.out.println("반복문을 빠져나온 i값 :" + i);   //i는 지역변수라 for문에서 빠져나왔으니 못씀. int i=0; 초기화 해주면 사용가능. 맨 위에 초기화해주고 for()괄호 안에 안써도됨.
		 
		 
		 System.out.println("\n>>프로그램 종료<<");
		 
		 
		 
	}
}
	

