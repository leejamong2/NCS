package my.day07.a.While;

public class Main_while_1 {

	public static void main(String[] args) {
		
		
		/*
	      === while 문 형식 ===
	      
	      변수의 초기화;
	         
	      while(조건식) {
	         조건식이 참(true)이라면 반복해서 실행할 명령문을 실행하고,
	         조건식이 거짓(false)이라면 while의 { } 이부분을 빠져나간다. 
	         
	         반복해서 실행할 명령문;
	         증감식;
	      }
	   */      
		
		int cnt=5, loop=0;     //다섯번 반복하겟다, 반복할 때마다 루프 늘어남
		while(loop < cnt) {
			System.out.println((loop+1)+".안녕 자바~~");
			loop++;
		}	
				
				
		/*
		  	1.안녕 자바~~~~
		  	2.안녕 자바~~~~
		  	3.안녕 자바~~~~
		  	4.안녕 자바~~~~
		  	5.안녕 자바~~~~
		 */
		
		

		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		cnt=5; loop=0;     //다섯번 반복하겟다, 반복할 때마다 루프 늘어남
		while(loop++ < cnt) {
			System.out.println(loop+".Hello Java~~");
			
		}	//end of while
		
		System.out.println("\n>>>프로그램 종료<<<");
		
		/*
	  	1.Hello Java~~
	  	2.Hello Java~~
	  	3.Hello Java~~
	  	4.Hello Java~~
	  	5.Hello Java~~
		 */
		
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		cnt=5; loop=0;     //다섯번 반복하겟다, 반복할 때마다 루프 늘어남
		while(loop < cnt) {
			System.out.println(++loop+".Hello Java~~");
			
		}	//end of while
		/*
	  	1.Hi Eclipse~~
	  	2.Hi Eclipse~~
	  	3.Hi Eclipse~~
	  	4.Hi Eclipse~~
	  	5.Hi Eclipse~~
		 */
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		loop=0;
		while(true) { //트루면 무한 루프
			
			System.out.println(++loop + ".Hi 이클립스~~");
			if(loop == 5)
				break;
			
		}//end of while---------------
		
		/*
	  	1.Hi 이클립스~~
	  	2.Hi 이클립스~~
	  	3.Hi 이클립스~~
	  	4.Hi 이클립스~~
	  	5.Hi 이클립스~~
		 */
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		loop=0;
		while(!(++loop>5)) {   //조건이 false 가 되면 !(true)빠져나온다는 말  => !(빠져나갈 조건)  느낌표가 브레이크야
			System.out.println(loop+".안녕 오라클~~");
			
		}//end of while---------------
		/*
	  	1.안녕 오라클~~
	  	2.안녕 오라클~~
	  	3.안녕 오라클~~
	  	4.안녕 오라클~~
	  	5.안녕 오라클~~
		 */
		System.out.println("\n>>>프로그램 종료<<<");
		
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		loop=0;
		while(true) {
			if(++loop > 10)// 탈출 조건
				break;
			if(loop%2==0)
				continue;  //아래로 내려가지 않고 while()의 괄호() 속의 조건식으로 이동함.
			//10번 돌릴건데 짝수만나면 출력하지말고 위로 올라가 라는 말
			System.out.println(loop+".Hi Oracle~~");
		}//end of while---------------		
		System.out.println("\n>>>프로그램 종료<<<");
		
		
		
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.println("\n===5단===");
		/*
		 	===5단===
		 	5*1=
		 	5*2=5
		 	5*3=5
		 	5*4=5
		 	5*5=5
		 	5*6=5
		 	5*7=5
		 	5*8=5
		 	5*9=5
		 */
		
		loop =0;
		int i=5;
		while(!(++loop>9)) {
			System.out.println(i + "*" + loop+ "="+ i*loop);
		}
		
		
		
		
		System.out.println("\n===5단===");
		loop =0;
		int a = 5;
		while(!(++loop > 9)) {
			System.out.println("5*"+loop+ "="+ loop*a);
		
		}
			
		
		System.out.println("\n===6단===");
		loop =0;
		while(true) {
			if(++loop > 9)
				break;
			System.out.println("6*" + loop+ "="+ 6*loop);
		}
		
		

		System.out.println("\n===7단===");
		loop =0;
		while(!(++loop > 9)) {
			System.out.println("7*" + loop+ "="+ 7*loop);
		}
		
		
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.println("===구구단===");
		
		
		int jul=0, dan=1;
		
		while(!(++jul>9)) { //9행
		
			while(!(++dan>9)) { // 8열       jul시행할 때 dan을 9번 돌린다
				String add = (dan<9)?"\t" : "\n";
				System.out.print(dan+"*"+jul+"="+(dan*jul)+add);
				
			}//end of while----------------
			
			//위의 while문 빠져나올때 dan의 값은 10이다. 
			// 그러므로 아래와 같이 단어의 값을 1로 초기화 해줘야함.
			dan=1;
			
		}//end of while---------------------
		
		
		
		
		
		System.out.println("\n>>>프로그램 종료<<<");
		
		
		}	
		

	
	}//end of main------


