package my.day06.a.multifor;

public class Main_multifor_1 {

	public static void main(String[] args) {
		
		//단일 for 문으로 아래와 같이 나오도록 한다.
		
		/*
		 	abcdefg
		 	hijklmn
		 	opqrstu
		 	
		 */

		
		char ch = 'a';
		for(int i=0; i<'u'-'a'+1; i++) {
			String add = ((i+1)%7 == 0)?"\n":""  ;     ////7의 배수 . 7니까.
			System.out.print(ch++ + add);  // ch=ch+1  ch에 +1해주고 다시 ch에 넣어준다는 뜻.    ch=(char)(ch+1)자동형변환 바뀐다.
			
		}
		
		
		
		
		
		
		System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		//이중 for 문으로 아래와 같이 나오도록 한다.
		
			/*
			 	abcdefg  3행 7열
			 	hijklmn
			 	opqrstu
			 	
			 */
			ch ='a';
		
		for(int i=0; i<3; i++) { //바깥 for문 ==> 행     ////참이면 내부 for 문으로 넘어감
			
		
			for(int j=0; j<7; j++) { //내부 for문 ==> 열
				System.out.println(ch++);
				
			}//end of for--------
			System.out.println("\n");
		}//end of for--------
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		/*
		 	[0,0][0,1][0,2]
		 	[1,0][1,1][1,2]   4행 3열
		 	[2,0][2.1][2,2]
		 	[3,0][3,1][3,2]
		 */
		
		//===단일 for 문을 사용하여 출력해본다.===
		
		int m=0, n=0;  //반복할 때마다 0값이 되니까 int m=0, n=0; 을 for 문 밖으로 빼줘야함 
		for(int i=0; i<12; i++) {    //// [첫m, 두번째n]
			/*
			 	i==> 0~2 이라면 m => 0		n ==> 0 1 2		i가 ~될때 m이 ~되고 n은 0 1 2 된다.
			 	i==> 3~5 이라면 m => 1		n ==> 0 1 2
			 	i==> 6~8 이라면 m => 2		n ==> 0 1 2
			 	i==> 9~11이라면 m => 3		n ==> 0 1 2
			 */
			if(i>0 && i%3==0) {   // 조건에 i>0 && 가 없다면 m이 1부터 시작됨.
				m++;
				n=0;
			}
			
			//int m=0;  //반복할 때마다 0값이 되니까 int m=0, n=0; 을 for 문 밖으로 빼줘야함 
			//int n=0;
			System.out.print("["+m +","+n++ +"]");    //++n 전위가 되면 n은 1 2 3 찍힘
			
			
			if((i+1)%3==0) {  
				System.out.println("\n");
			}
			
		}//end os for-------------------------
		
		
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		/*
	 	[0,0][0,1][0,2]
	 	[1,0][1,1][1,2]   4행 3열
	 	[2,0][2.1][2,2]
	 	[3,0][3,1][3,2]
	 */
		//이중 for 문을 사용하여 출력해본다.		
		for(int i=0; i<4; i++) {  	 //4행
			for(int j=0; j<3; j++) { //3열
				System.out.print("["+i+","+j+"]");      /*[행,열]    i가 0이라면 3(0,1,2,3)번 반복
																	i가 1이라면 3(0,1,2,3)번 반복 ...*/
				
				
			}//end of for----------------
			System.out.println("\n");
		}//end of for----------------
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		/*
	 	[0,0][0,1][0,2]   4행 3열
	 	[1,0][1,1][1,2]   
	 	[2,0][2.1][2,2]  =>스킵
	 	[3,0][3,1][3,2]
	 */
		for(int i=0; i<4; i++) {  	 //4행
			
			if(i==2) continue;    //i가 2라면 내려가지말고 증감식으로 가라구
			
			for(int j=0; j<3; j++) { //3열
				System.out.print("["+i+","+j+"]");      /*[행,열]    i가 0이라면 3(0,1,2,3)번 반복
																	i가 1이라면 3(0,1,2,3)번 반복 ...*/
				
				
			}//end of for----------------
			System.out.println("\n");
		}//end of for----------------
		
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		/*
		 	  스킵
	 	[0,0][0,1][0,2]   4행 3열
	 	[1,0][1,1][1,2]   
	 	[2,0][2.1][2,2]  
	 	[3,0][3,1][3,2]
	 */
		for(int i=0; i<4; i++) {  	 //4행
			
			for(int j=0; j<3; j++) { //3열
				if(j==1) continue;    //j가 2라면 내려가지말고 증감식으로 가라구
				System.out.print("["+i+","+j+"]");     
			
				
			}//end of for----------------
			System.out.println("\n");
		}//end of for----------------
		
		
		
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println("안녕하세요\t내일\t또 뵐게요~~");
		/*
		 	501호 	 502호	503호	505호
		 	301호	 302호	303호	305호    4행 4열
		 	201호 	 202호	203호	205호
		 	101호	 102호	103호	105호
		  */
		
		for(int i=5; i>0; i--) {  	 //4행 3열
			if(i==4) continue;
			
			for(int j=1; j<=5; j++) { 
			if(j==4) continue;    //j가 4라면 내려가지말고 증감식으로 가라구
				System.out.print(i+"0"+j+"호\t");     
		
			}
				
				System.out.print("\n");
		}//end of main----
		
		
	
		
		
		
	}

}
