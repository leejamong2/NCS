package jdbc.day04.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jdbc.day04.board.dbconnection.MyDBConnection;
import jdbc.day04.board.domain.MemberDTO;

public class MemberDAO_imple implements MemberDAO {
	
   // field, attribute, property, 속성
   private Connection conn;
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
   
   
   // 회원가입(insert) 메소드
   @Override
   public int memberRegister(MemberDTO member) {
      
      int result = 0;
      
      try {
         conn = MyDBConnection.getConn();  //매번 오라클에서 불러오고 끄고 하면 과부하가 크니까
         
         String sql = " insert into tbl_member(userseq, userid, passwd, name, mobile) "
                  + " values(userseq.nextval, ?, ?, ?, ?) ";
         
         
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, member.getUserid());  // 1 은 String sql 에서 첫번째 위치홀더(?)를 말한다. 첫번째 위치홀더(?)에 name 을 넣어준다.
         pstmt.setString(2, member.getPasswd());  // 2 은 String sql 에서 두번째 위치홀더(?)를 말한다. 두번째 위치홀더(?)에 msg 을 넣어준다.
         pstmt.setString(3, member.getName());    // 3 은 String sql 에서 두번째 위치홀더(?)를 말한다. 세번째 위치홀더(?)에 msg 을 넣어준다.
         pstmt.setString(4, member.getMobile());  // 4 은 String sql 에서 두번째 위치홀더(?)를 말한다. 네번째 위치홀더(?)에 msg 을 넣어준다.
         
         result = pstmt.executeUpdate(); // sql문 실행
         
         
      
      } catch (SQLException e) {
         
         if(e.getErrorCode() == 1) {
            System.out.println(">> 아이디 중복되었습니다. 새로운 아이디를 입력하세요!! <<");
         }
         else {
            e.printStackTrace();
         }
         
      } finally {
         close();   
      }
      
      
      return result;
   }// end of public int memberRegister(MemberDTO member)-------------
   
   
   //로그인처리
   @Override
   public MemberDTO login(Map<String, String> paraMap) {

      MemberDTO member = null;
      
      try {
         
         
         conn =  MyDBConnection.getConn();
         
         String sql = " select userseq, userid, name, mobile, point, to_char(registerday, 'yyyy-mm-dd hh24:mi:ss') as registerday "
                  + " from tbl_member "
                  + " where status = 1 and userid = ? and passwd = ? ";
         
         
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, paraMap.get("userid"));  // 1 은 String sql 에서 첫번째 위치홀더(?)를 말한다. 첫번째 위치홀더(?)에 name 을 넣어준다.
         pstmt.setString(2, paraMap.get("passwd"));  // 2 은 String sql 에서 두번째 위치홀더(?)를 말한다. 두번째 위치홀더(?)에 msg 을 넣어준다.
         
         rs = pstmt.executeQuery(); // sql문 실행
         
         if(rs.next()) {
            member = new MemberDTO();
            
            member.setUserseq( rs.getInt("userseq") );
            member.setUserid( rs.getString("userid") );
            member.setName( rs.getString("name") );
            member.setMobile( rs.getString("mobile") );
            member.setPoint( rs.getInt("point") );
            member.setRegisterday( rs.getString("registerday") );
         }
         
      
      } catch (SQLException e) {
         
         
      } finally {
         close();   
      }
      
      return member;
   }// end of public MemberDTO login(Map<String, String> paraMap)--------------

// === 모든회원을 조회(select)해주는 메소드 ===
   @Override
   public List<MemberDTO> showAllMember(String sortChoice) {
      
      List<MemberDTO> memberList = new ArrayList<>();
   
      try {

     
      conn =  MyDBConnection.getConn();
      
      String sql = " select userseq, userid, name, mobile, point, to_char(registerday, 'yyyy-mm-dd hh24:mi:ss') as registerday "
      		  + "   ,status "
               + " from tbl_member " ;
      switch (sortChoice) {
		case "1": //회원명의 오름차순
			sql += " order by name asc ";
			break;
		case "2": //회원명의 내림차순
			sql += " order by name desc ";
			break;
		case "3": //가입일자의 오름차순
			sql += " order by userseq asc ";
			break;
		case "4": //가입일자의 내림차순
			sql += " order by userseq desc ";
			break;
	
		default:
		break;
	}//end of switch-------------------------------------
      
      pstmt = conn.prepareStatement(sql);
      
      rs = pstmt.executeQuery(); // sql문 실행
      
      while(rs.next()) {
     	 MemberDTO member = new MemberDTO();
         
         member.setUserseq( rs.getInt("userseq") );
         member.setUserid( rs.getString("userid") );
         member.setName( rs.getString("name") );
         member.setMobile( rs.getString("mobile") );
         member.setPoint( rs.getInt("point") );
         member.setStatus( rs.getInt("status") );
         
         memberList.add(member);
      }// end of while-------------------------------------
      
   
   } catch (SQLException e) {
      e.printStackTrace();
      
   } finally {
      close();   
   }
   
   return memberList;
}

}
