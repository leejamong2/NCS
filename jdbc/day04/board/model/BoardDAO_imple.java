package jdbc.day04.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.day04.board.dbconnection.MyDBConnection;
import jdbc.day04.board.domain.BoardDTO;

public class BoardDAO_imple implements BoardDAO {

   // *** 게시판 글쓰기 ***
   
	
	// field, attribute, property, 속성
	   private Connection conn = MyDBConnection.getConn();
	   private PreparedStatement pstmt;
	   private ResultSet rs;
	   
	   
	   // method, operation, 기능
	   
	   // === 자원반납을 해주는 메소드
	   private void close() {
	      
	      try {
	         if(rs != null) {rs.close(); rs = null;}
	         if(pstmt != null) {pstmt.close(); pstmt = null;}
	         
	      } catch(SQLException e) {
	         e.printStackTrace();
	      }
	      
	   }// end of private void close()-------------------------------
	   
	   
	// === Transaction 처리 ===
	   //    (tbl_board 테이블에 insert 가 성공되어지면 tbl_member 테이블의 point 컬럼에 10씩 증가 update 를 할 것이다.
	   //     그런데 insert 또는 update 가 하나라도 실패하면 모두 rollback 할 것이고,
	   //     insert 와 update 가 모두 성공해야만 commit 할 것이다.)
	   // dto가 tbl_board(DML=insert) 에도 있고 tbl_member(DML=insert)에도 잇을거아녀
	   
	// 게시판 글쓰기 Transaction 처리하여 성공되면 1, 실패하면 -1리턴시켜줄거임
	@Override
	public int write(BoardDTO bdto) {
		
		int result = 0;
		
		//Transaction 처리를 위해서 수동 commit 으로 바뀨ㅓ준다 롤백하기위헤!!
		try {
			conn.setAutoCommit(false); //수동커밋으로 바꿈
			
			String sql = " insert into tbl_board (boardno, fk_userid, subject, contents, boardpasswd) "
						+ " values(seq_board.nextval,?,?,?,?) ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bdto.getFk_userid());
			pstmt.setString(2, bdto.getSubject());
			pstmt.setString(3, bdto.getContents());
			pstmt.setString(4, bdto.getBoardpasswd());
			
			int n1 = pstmt.executeUpdate(); // sql 문 만들었으니 실행하기
			
			if(n1==1) { // tbl_board 테이블에 insert가 성공되었다라면
				sql = " update tbl_member set point = point + 10 "
					+ " where userid = ? " ;
				
				pstmt = conn.prepareStatement(sql); 
				pstmt.setString(1, bdto.getFk_userid());
				
				int n2 = pstmt.executeUpdate();
				
				if(n2==1) { //tbl_board 테이블에 update 가 성공되었다라먄
					conn.commit();
					result = 1;
				}
				
			}
		} catch (SQLException e) {
			if(e.getErrorCode() == 2290) {
				System.out.println(">>아이디 "+bdto.getFk_userid()+"님의 포인트는 30을 초과할 수 없기 떄문에 오류발생하였습니다! <<\n");
			}
			else {
				e.printStackTrace();
			}
			try {
				conn.rollback(); //인서트만 되고 업데이트(화면에출력) 안되는경우니까 => 롤백해줘야함.
								 //인서트, 업데이트 둘 다 되어야 그제서야 커밋해줘야하니까 수동커밋으로 바꾼것이다.
				result = -1;
			} catch(SQLException e2) {}
			
		} finally { //성공이든 실패든 무조건 실행시킨다는 말
			
			try {
				conn.setAutoCommit(true); //자동 commit 으로 복원시킨다.
			} catch(SQLException e2) {}
			
			close(); //자원반납
			
		}
		
		
		return result;
		
	}//end of -------------------------------------
	

}
