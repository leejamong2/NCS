package my.day06.a.multifor;

public class Main_homework_5 {

	public static void main(String[] args) {
		
		
		// 1. 제출할 파일명 :  본인이름_Main_homework_5.java.txt (메모장 txt 파일로 제출함)
		   // 2. 메일주소 :  tjdudgkr0959@naver.com
		   // 3. 제출기한 :  1월26일(금) 18:00 까지 
		   // 4. 자바소스 :  for 문 사용하여 만들것.      
		      
		   /*
		       == 숙제 1 == 
		      *
		      **
		      ***
		      ****
		      *****
		             
		             
		      == 숙제 2 == 
		           *
		          **
		         ***
		        ****
		       ***** 


		      == 숙제 3 == 
		      *****   
		      ****    
		      ***    
		      **     
		      *   
		      
		             
		     == 숙제 4 ==
		    
		         *
		        ***
		       ***** 
		      
		             
		     == 숙제 5 ==
		             
		       *****
		        ***
		         *
		      
		                 
		     == 숙제 6 ==
		          
		         *
		        ***
		       *****
		        ***   
		         *      


		   == 입사문제 == 
		           
		   *********1
		   ********2
		   *******3
		   ******4
		   *****5
		   ****6
		   ***7
		   **8
		   *9


		   */   
		
		
System.out.println("-------숙제1--------");
		 for(int i=1; i<=5; i++) {
			 for(int j=0; j<i; j++) {
				 System.out.print("*");
			 }//end of for-------
			 
			 System.out.println("");
		 }
		 
/*	       == 숙제 1 == 
	      *
	      **
	      ***
	      ****
	      *****
  */
		 
		 
		 
		 
System.out.println("-------숙제2--------");

			for(int i=1; i<=5; i++) {
				for(int g=4; g>=i; g--) {
					 System.out.print(" ");
				}
				 for(int j=1; j<=i; j++) {
					 System.out.print("*");
				 }//end of for-------
				 
				 System.out.println("");
			}//end of for-------
			
				
		/*	       == 숙제 2 == 
		 		   *
		          **
		         ***
		        ****
		       ***** 

*/
	
	
	
	
System.out.println("-------숙제3--------");
	
			for(int i=1; i<=5; i++) {
				for(int j=5; j>=i; j--) {
					
						System.out.print("*");
						
				}	
					System.out.println(" ");
					 
					 
				}
	/*	       == 숙제 3 == 
		      *****   
		      ****    
		      ***    
		      **     
		      *   
	*/
			
			
			
			
			
			
System.out.println("-------입사문제--------");
		
			for(int i=1; i<=9; i++) {
				
				for(int j=1; j<=i; j++) {
					System.out.print("*");
				}//end of for-------
			
				System.out.println(""+i);
				
			}
	 /*	   	== 입사문제 == 
			           
			   *********1
			   ********2
			   *******3
			   ******4
			   *****5
			   ****6
			   ***7
			   **8
			   *9
	   */
	

			
			

System.out.println("-------숙제4--------");
			
			
			for(int i=1; i<=5; i+=2) {
				for(int k=5; k>i; k-=2) {
					System.out.print(" ");
				}
				for(int j=1; j<=i; j++) {
					System.out.print("*");
				}
					
				System.out.println("");
			}
	
			
	/*	         == 숙제 4 ==
		 		    
			         *
			        ***
			       ***** 
			       i가 1일때(1행)
			       i=1 ; 1<=3 ; ->k,j
			       
			       k=3 ; 3>1 ;   ""
			       k=2 ; 2
			       
	*/	

		
			
			
System.out.println("-------숙제5--------");

		for(int i=0; i<=5; i+=2) {
			for(int j=0; j<i; j+=2) {
				 System.out.print(" ");
			}
			for(int k=5; k>i; k--) {
				System.out.print("*");
			}
			
			 System.out.println("");
		}

		
		
	
//for(int i=0; i<3; i++)

//for(int j=0; j<=i; j++) {
//	 System.out.print("*");
//}end of for-------

//== 숙제 5 ==
//
//*****
//***
//*		
		
		
		
		
System.out.println("-------숙제6--------");
			for(int i=1; i<=5; i+=2) {
				for(int k=5; k>i; k-=2) {
					System.out.print(" ");
				}
				for(int j=1; j<=i; j++) {
					System.out.print("*");
				}	
				System.out.println("");
			}
			for(int i=0; i<=5; i+=2) {
				if(!(i==0)) {
				for(int j=0; j<i; j+=2) {
					 System.out.print(" ");
				}
				for(int k=5; k>i; k--) {
					System.out.print("*");
				}
				
				 System.out.println("");
			}
			}
	}
}


/*
       		== 숙제 6 ==
		           
		         *
		        ***			j	2 1 0 1 2  
		       *****
		        ***   
		         *       
 */
	



