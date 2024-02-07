package my.day05.f.For.quiz;

public class Main_quiz_2 {

	public static void main(String[] args) {
		
		
		//for문을 사용하여 알파벳 소문자를 아래처럼 출력하세요
		// a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z
		
		
		
		String result = "";  //문자열 누적용
		
		
		for(char i='a'; i<='z'; i++) {
			
			if(i<'z')
				result += i + "," ;
			
			else result += i ;
			
		
		
		
	//----------선생님 답-----------
		//for(int i= 0; i<'z'-'a'+1; i++) {
		//	char ch = (char)('a'+i);    // (char)(97+0)  ==> 'a'
										// (char)(97+1)  ==>
			
			/*		
			String add = "";  			//이프 또는 삼항연상자 쓸수 있음
			if(i<'z'-'a'+1)
				add = ","; 
			 */
			
			
		   /*또는					
		String add = (i<'z'-'a')?",":"";		
		result += ch+add; 
		   */
			
		}//end of for--------------
	
		System.out.println(result);
		
			
			
			
			
			
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~\n");
			//for문을 사용하여 알파벳 소문자를 아래처럼 출력하세요	
			/*
			  a,b,c,d,e,f,g,h,i,j,k,l,m			 
			  n,o,p,q,r,s,t,u,v,w,x,y,z
			*/
			result = "";  //문자열 누적용
					
			for(char i= 'a'; i<='z'; i++) {
				
				if(i>='a' && 'm'>i) {
					result += i+",";
					
				}
				else if(i=='m'){
						result += i+"\n";
				}
				
				else if(i>'m' && 'z'>i) {
					result += i+",";
				}
				
				else {
					result += i;
				}
				
			}//end of for----------------
			
			
			
			
			
			//----------선생님 답-----------
			for(int i= 0; i<'z'-'a'+1; i++) {
				char ch = (char)('a'+i);    // (char)(97+0)  ==> 'a'
											// (char)(97+1)  ==>
				
						
				/* String add = "";  			//이프 또는 삼항연상자 쓸수 있음
				if(ch == 'm' || ch == 'z')
					add = "\n";
				
				else
					add = ","; 
				 */
				
				
				
			   //또는					
			String add = (ch == 'm' || ch == 'z')?"\n":",";		
			result += ch+add; 
			   
			}	
			
				
			
					
			System.out.println(result);
				
	}
	
		
			
	
	
}
