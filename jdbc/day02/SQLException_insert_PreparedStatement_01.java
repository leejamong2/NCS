package jdbc.day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLException_insert_PreparedStatement_01 {

	public static void main(String[] args) {
		
		 Connection conn = null; 
	     PreparedStatement pstmt = null; 
	     ResultSet rs = null;
	     
	     Scanner sc = new Scanner(System.in);
	     
	     try {
	    	 Class.forName("oracle.jdbc.driver.OracleDriver");
	    	 
	    	 conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JDBC_USER", "gclass");
	    	 
	    	 do {
	    	 /////////////////////////////////////////////////////////////////////뺑뺑이
		    	 System.out.print("▷ 학번 : ");
		    	 String stno = sc.nextLine();
		         
		         System.out.print("▷ 성명 : ");
		         String name = sc.nextLine();
		         
		         System.out.print("▷ 연락처 : ");
		         String tel = sc.nextLine();
		         
		         System.out.print("▷ 주소 : ");
		         String addr = sc.nextLine();
		         
		         System.out.print("▷ 학급번호 : ");
		         String fk_classno = sc.nextLine();
		         
		         String sql = " insert into tbl_student(stno, name, tel, addr, fk_classno) " //입학일자 디폴트라 안씀 
		         			+ " values(to_number(?), ?, ?, ?, to_number(?)) "; //자바에선 다 스트링인데 오라클에서는 숫자타입도 있어서 확실하게 안전빵으로 문자로 바꿔줌
		         
		         pstmt = conn.prepareStatement(sql);
		         pstmt.setString(1, stno);  //1번째 위치홀더에 stno 를 넣는다
		         pstmt.setString(2, name);
		         pstmt.setString(3, tel);
		         pstmt.setString(4, addr);
		         pstmt.setString(5, fk_classno);
		         
		         try {
		        	 int n = pstmt.executeUpdate();  //sql문 실행.  틀리게 입력하면 executeUpdate는 SQLException을 실행시킴
		        	 
		        	 if(n==1) { //행이 있다면???
			        	 System.out.println(">>데이터 입력 성공!!<<");
			        	 break;
			         }
		        	 
			         
		         } catch(SQLException e) { 
		        //	 System.out.println("확인용 sql구문 오류발생 2 ");
		        	 
		        	 if(e.getErrorCode() == 1722) { //여기에 ~랑 같이 써야 문자띄우고 그냥 종료는 것이 아니라 반복됨. 그래서 밑에 쓰기보단 요기 쓰는게 좋음.
		        		 System.out.println(">>[경고]학번 및 학급번호는 정수로만 입력하세요!!\n");
		        	 }
		        	 else if(e.getErrorCode() == 1) {
		        		 System.out.println(">> [경고]입력하신 학번" + stno + "은 이미 사용중입닌다");
		        	 }
		        	 
		        	 else if(e.getErrorCode() == 2291) { 
		        		 System.out.println(">>[경고]입력하신 학급번호는 존재하지 않는 번호입니다.\n");
		        		 System.out.println(">>입력가능한 학급번호는 아래와 같습니다\n");
		        		 /*
		        		  	---------------
		        		  	학급번호	학급명
		        		  	-------------
		        		  	  1		자바~~
		        		  	  2		자바~~
		        		  	  3		자바~~
		        		  */
		        		 sql = " select classno, classname "
		                         + " from tbl_class "
		                         + " order by classno asc ";
		                       
		                       pstmt.close();
		                       pstmt = conn.prepareStatement(sql);
		                     rs = pstmt.executeQuery();  // sql문 실행하기
		                     
		                     StringBuilder sb = new StringBuilder();
		                     int cnt = 0;
		                     
		                     while(rs.next()) {
		                        cnt++;
		                        
		                        if(cnt==1) {
		                           sb.append("-".repeat(30)+"\n");
		                           sb.append("학급번호\t학급명\n");
		                           sb.append("-".repeat(30)+"\n") ;
		                        }
		                        
		                        sb.append(rs.getInt("CLASSNO")+"\t"+
		                                rs.getString("CLASSNAME")+"\n"
		                               );
		                     }
		                     
		                     System.out.println(sb.toString());
		        		 
		        	 }
		        	 else {
		        		 e.printStackTrace();
		        	 }
		         }
	         ////////////////////////////////////////////////////////////////////////뺑뻉이
	    	 } while(true);
	    	 
	    	 
	     } catch (ClassNotFoundException e) {
	         System.out.println(">>> ojdbc8.jar 파일이 없습니다. <<<");
	      } catch (SQLException e) {
	    //	 System.out.println("확인용 sql구문 오류발생 1 "); //비밀번호 틀렸을 경우 첨부터 이 오류가뜸
	         e.printStackTrace();  
	      } finally {
	         
	         try {
	            if(rs != null) {
	            	rs.close(); // null이 아니어야 한다.
	            	rs = null;
	            }
	            
	            if(conn != null) {
	               conn.close();  // null이 아니어야 한다.
	               conn = null;
	            }
	            
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	         
	      }
	      
	      
	      
	      sc.close();
	      System.out.println("~~~ 프로그램 종료 ~~~");
		

	}//end of main------------------------------

}
