package my.day07.b.dowhile;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main_primenumber_3 {


   public static void main(String[] args) {
      

      Scanner sc = new Scanner(System.in);
      
      do {
         try {
         System.out.print("▷시작 자연수 : ");
         int start_no = sc.nextInt();       
         sc.nextLine();    
   
         System.out.print("▷끝 자연수 :  ");
         int end_no = sc.nextInt();    //10엔터  
         sc.nextLine();
         
         //소수란? 1과 자기 자신 수로만 나누었을 때 나머지가 0인 1 이외의 정수 
         
         String str_result = "";   //  소수 쌓아둠
         int cnt=0, sum=0;
         
         for(int i=start_no; i<=end_no; i++) {
            
            if(i==1) {   // 1은 소수가 아니므로 소수인지 아닌지 검사할 필요가 없다. 밑에 소수인지 아닌지 검사할 건데 1은 어차피 아니라 검사할 필요없으니 continue를 한다.
               continue;
            }

               boolean isSosu = true;  //밑에 true false 로 답을 낼거니까 불린 초기화해줘야돼
            
               for(int bunmo=2; bunmo<i; bunmo++) {//6%2  6%3  ...  6%5
                  if(i%bunmo == 0) {   //i가 5라고 가정하면 조건식에 폴스니까
                  isSosu = false;
                  break;
                  }
               }//end of for----------------
               
               if(isSosu) { //검사대상인 i 가 소수라면
               cnt++;  		//1씩 늘려준다. 소수의 개수
               sum   += i;   //소수들의 누적 합계
               
               String add =(cnt==1)?"" :",";  //두번째 이후부터 나오는 소수는 소수 앞에 ","를 붙여준다.
               str_result +=add+i;
               }
               //end of for
            }
            System.out.print(start_no+"부터"+end_no+"까지의 소수는?\n"+str_result);
            System.out.print(start_no+"부터"+end_no+"까지의 소수의 개수는? "+cnt+"개");
            System.out.print(start_no+"부터"+end_no+"까지의 소수들의 합? "+str_result);
               
            sc.close();
            break;
         }catch(InputMismatchException e) {
         
         System.out.println(">> [경고] 자연수만 입력하세요!!");
         sc.nextLine();
         }
         
         
         
         }while(true);
         
         System.out.println("\n=== 프로그램 종료 ===");
      // end of dowhile
      
   }
}
