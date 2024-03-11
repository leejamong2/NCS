package jdbc.day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DDL_create_drop_PreparedStatement_06 {

	public static void main(String[] args) {
		
		 Connection conn = null; 
	     PreparedStatement pstmt = null; 
	     ResultSet rs = null;
	     
	     try {
	    	 Class.forName("oracle.jdbc.driver.OracleDriver");
	    	 
	    	 conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JDBC_USER", "gclass");
	    	 
	    	 String sql_1 = " select * "
	    	 			  + " from user_tables "
	    	 			  + " where table_name = 'TBL_MEMO' "; //테이블이 존재하는지 확인한다
	    	 
	    	 String sql_2 = " drop table TBL_MEMO   purge ";  
	    	 						  // TBL_MEMO 테이블이 자식 테이블이 없을 경우 삭제하는 것
	    	 
	    //	 String sql_2 = " drop table TBL_MEMO cascade constraints  purge ";
	    	 					// TBL_MEMO 테이블이 자식 테이블이 있을 경우 먼저 자식테이블에 존재하는 foreign key를 먼저 삭제한 후 테이블을 삭제하는 것
	    	 					// TBL_MEMO 이 혹시나 자식 테이블이 있는 부모테이블이라면 캐스캐이드컨스트레인트 써ㅏ줘야함
	    	 
	    	 String sql_3 = " create table tbl_memo "
	    			 + " (no          number(4) "
	    			 + " ,name        Nvarchar2(20) not null "
	    			 + " ,msg         Nvarchar2(100) not null "
	    			 + " ,writeday    date default sysdate "
	    			 + " ,updateday    date "
	    			 + " ,constraint  PK_tbl_memo_no primary key(no) "
	    				+"	 ) ";
	    	 
	    	 String sql_4 = " select * "
	    			 	  +" from user_sequences "
	    			 	  +" where sequence_name = 'SEQ_MEMO' ";
	    	 
	    	 String sql_5 = " drop sequence SEQ_MEMO ";
	    			 
	    	 String sql_6 = " create sequence seq_memo "
		    	 		  + " start with 1 "
		    	 		  + " increment by 1 "
		    	 	 	  + " nomaxvalue "
		    	 		  + " nominvalue "
		    	 		  + " nocycle "
		    	 		  + " nocache ";
	    	 
	    	 String sql_7 = " insert into tbl_memo(no, name, msg) "
	    	 		      + " values(seq_memo.nextval, '이순신', '안녕하세요? 이순신입니다') ";
	    	 
	    	 String sql_8 = " select * "
	    	 		      + " from tbl_memo "
	    	 		      + " order by no desc ";
	    	 
	    	 // == 생성해야할 tbl_memo 테이블이 이미 존재하는지 알아본다
	    	 pstmt = conn.prepareStatement(sql_1);
	    	 rs = pstmt.executeQuery(); // sql문 실행
	    	 
	    	 if(rs.next()) { //sql_1 문을 실행한 결과에서 행이 있으면 트루, 없으면 폴스 //tbl_memo 테이블이 이미 존재한다면
	    		 
	    		 //tbl_memo 테이블을 drop 하겠다
	    		 pstmt.close();
	    		 pstmt = conn.prepareStatement(sql_2);
	    		 int n = pstmt.executeUpdate(); //sql실행
	    				 /*
	    	               .executeUpdate(); 은 SQL문이 DML문(insert, update, delete, merge) 이거나 
	    	                                    SQL문이 DDL문(create, drop, alter, truncate) 일 경우에 사용된다. 
	    	                     
	    	               SQL문이 DML문이라면 return 되어지는 값은 적용되어진 행의 개수를 리턴시켜준다.
	    	               예를 들어, insert into ... 하면 1 개행이 입력되므로 리턴값은 1 이 나온다. 
	    	                      update ... 할 경우에 update 할 대상의 행의 개수가 5 이라면 리턴값은 5 가 나온다. 
	    	                      delete ... 할 경우에 delete 되어질 대상의 행의 개수가 3 이라면 리턴값은 3 이 나온다.
	    	                     
	    	               SQL문이 DDL문이라면 return 되어지는 값은 무조건 0 이 리턴된다.
	    	                
	    	                
	    	               .executeQuery(); 은 SQL문이 DQL(select)일 경우에 사용된다. 
	    	           */
	    		 System.out.println("~~~확인용 drop table : " + n);
	    		 // ~~~확인용 drop table : 0
	    		 
	    	 }
	    	 
	    	 // tbl_memo 테이블 생성한다
	    	 pstmt = conn.prepareStatement(sql_3);
    		 int n = pstmt.executeUpdate(); //sql실행
    		 System.out.println("~~~확인용 create table : " + n);
    		 // ~~~확인용 create table : 0
    		 
    		 
    		 
    		 
    		// == 생성해야할 SEQ_MEMO가 이미 존재하는지 알아본다
	    	 pstmt = conn.prepareStatement(sql_4);
	    	 rs.close();
	    	 rs = pstmt.executeQuery(); // sql문 실행
	    	 
	    	 if(rs.next()) { //SEQ_MEMO 시퀀스가 이미 존재한다면
	    		 
	    		 //SEQ_MEMO 시퀀스을 drop 하겠다
	    		 pstmt.close();
	    		 pstmt = conn.prepareStatement(sql_5);
	    		 n = pstmt.executeUpdate(); //sql실행
	    		
	    		 System.out.println("~~~확인용 drop sequence : " + n);
	    		 // ~~~확인용 drop sequence : 0
	    	 }
	    	 
	    	 // SEQ_MEMO 시퀀스을 생성
	    	 pstmt = conn.prepareStatement(sql_6);
    		 n = pstmt.executeUpdate(); //sql실행
    		 System.out.println("~~~확인용 create sequence : " + n);
    		 // ~~~확인용 create sequence : 0
    		 
    		 
    		 //tbl_memo 테이블에 insert 하기
    		 pstmt = conn.prepareStatement(sql_7);
    		 n = pstmt.executeUpdate(); //sql실행  //인서트 해오고 나서는  1 나옴
    		 System.out.println("~~~확인용 insert into tbl_memo : " + n);
    		 // ~~~~~~확인용 insert into tbl_memo : 1
    		 
    		 
    		 //tbl_memo 테이블을 select 하기
    		 pstmt = conn.prepareStatement(sql_8);
    		 rs = pstmt.executeQuery();
    		 
    		 StringBuilder sb = new StringBuilder();
    		 int cnt = 0;
    		 
    		 while(rs.next()) {
    			 cnt++;
    			 
    			 if(cnt==1) {
    				 sb.append("-".repeat(70)+"\n");
    				 sb.append("일련번호\t성명\t글내용\t작성일자\t변경일자\n");
    				 sb.append("-".repeat(100)+"\n");
    			 }
    			 
    			 sb.append(rs.getInt("no")+"\t"+
    					   rs.getString("name")+"\t"+
    					   rs.getString("msg")+"\t"+
    					   rs.getString("writeday")+"\t"+
    					   rs.getString("updateday")+"\n"
    					 );
    			 
    		 }//end of while----------------------
    		 
    		 if(cnt > 0) {
    			 System.out.println(sb.toString());
    		 }
    		 else {
    			 System.out.println("입력된 데이터가 없습니다");
    		 }
    		 	 
	    	 
	     } catch (ClassNotFoundException e) {
	         System.out.println(">>> ojdbc8.jar 파일이 없습니다. <<<");
	     } catch (SQLException e) {
	         e.printStackTrace();
	     } finally {
	         
	         try {
	            if(rs != null) {
	            	rs.close(); // null이 아니어야 한다.
	            	rs = null;
	            }
	            if(pstmt != null) {
	                pstmt.close(); // null이 아니어야 한다.
	                pstmt = null;
	             }
	            
	            if(conn != null) {
	               conn.close();  // null이 아니어야 한다.
	               conn = null;
	            }
	            
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	         
	      }

	}//end of main----------------------------------

}
