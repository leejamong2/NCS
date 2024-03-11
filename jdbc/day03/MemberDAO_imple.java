package jdbc.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
         if(conn != null) {conn.close(); conn = null;}
      } catch(SQLException e) {
         e.printStackTrace();
      }
      
   }// end of private void close()-------------------------------
   
   
   // 회원가입(insert) 메소드
   @Override
   public int memberRegister(MemberDTO member) {
      
      int result = 0;
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JDBC_USER", "gclass");
         
         String sql = " insert into tbl_member(userseq, userid, passwd, name, mobile) "
                  + " values(userseq.nextval, ?, ?, ?, ?) ";
         
         
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, member.getUserid());  // 1 은 String sql 에서 첫번째 위치홀더(?)를 말한다. 첫번째 위치홀더(?)에 name 을 넣어준다.
         pstmt.setString(2, member.getPasswd());  // 2 은 String sql 에서 두번째 위치홀더(?)를 말한다. 두번째 위치홀더(?)에 msg 을 넣어준다.
         pstmt.setString(3, member.getName());    // 3 은 String sql 에서 두번째 위치홀더(?)를 말한다. 세번째 위치홀더(?)에 msg 을 넣어준다.
         pstmt.setString(4, member.getMobile());  // 4 은 String sql 에서 두번째 위치홀더(?)를 말한다. 네번째 위치홀더(?)에 msg 을 넣어준다.
         
         result = pstmt.executeUpdate(); // sql문 실행
         
         
      } catch (ClassNotFoundException e) {
         System.out.println(">>> ojdbc8.jar 파일이 없습니다. <<<");
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


   // === 로그인 처리 메소드 === //
   @Override
   public MemberDTO login(Map<String, String> paraMap) {

      MemberDTO member = null;
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JDBC_USER", "gclass");
         
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
         
      } catch (ClassNotFoundException e) {
         System.out.println(">>> ojdbc8.jar 파일이 없습니다. <<<");
      } catch (SQLException e) {
         
         
      } finally {
         close();   
      }
      
      return member;
   }// end of public MemberDTO login(Map<String, String> paraMap)--------------


   @Override
   public int memberDelete(int userseq) {

      int result = 0;
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JDBC_USER", "gclass");
         
         String sql = " update tbl_member set status = 0 "
                  + " where userseq = ? ";
         
         
         pstmt = conn.prepareStatement(sql); 
         pstmt.setInt(1, userseq); 
         
         result = pstmt.executeUpdate(); // sql문 실행
         
         
      } catch (ClassNotFoundException e) {
         System.out.println(">>> ojdbc8.jar 파일이 없습니다. <<<");
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         close();   
      }
      
      
      return result;
   }


   // === 모든회원을 조회(select)해주는 메소드 ===
   @Override
   public List<MemberDTO> showAllMember() {
      
      List<MemberDTO> memberList = new ArrayList<>();
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         
         conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "JDBC_USER", "gclass");
         
         String sql = " select userseq, userid, name, mobile, point, to_char(registerday, 'yyyy-mm-dd hh24:mi:ss') as registerday "
         		  + "   ,status "
                  + " from tbl_member "
                  + " order by userseq asc ";
         
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
         
      } catch (ClassNotFoundException e) {
         System.out.println(">>> ojdbc8.jar 파일이 없습니다. <<<");
      } catch (SQLException e) {
         e.printStackTrace();
         
      } finally {
         close();   
      }
      
      return memberList;
   }
   
   
   
}