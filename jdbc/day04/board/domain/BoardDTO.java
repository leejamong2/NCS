package jdbc.day04.board.domain;


	// 데이터베이스에서 domain 이란?
	// 엔티티의 속성들이 가질 수 있는 값들의 집합을 뜻하는 것이다.
	// 대부분의 DBMS에서 도메인이란 속성에 대응하는 컬럼에 대한 데이터 타입(Data Type)과 길이를 의미한다.

	// === DTO(Data Transfer Object, 데이터전송(운반)객체 )
	// 쉽게 말해서 DTO는 테이블의 1개 행(ROW)을 말한다.
	// 어떤 테이블에 데이터를 insert 하고자 할때 DTO에 담아서 보낸다.
	// 또한 어떤 테이블에서 데이터를 select 하고자 할때도 DTO에 담아서 읽어온다.

public class BoardDTO { // BoardDTO 는 오라클의 tbl_board 테이블에 해당함 
	
	//필드
	// insert 용
	private int boardno;
	private String fk_userid;
	private String subject;     
	private String contents;    
	private String writeday;    
	private int viewcount;
	
	
	////////////////////////////////////////////////////////////////
	//select 용
	
	
	
	
	
	
	
	//메소드
	///////////////////////////////////////////////////////////////

	public int getBoardno() {
		return boardno;
	}
	
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	
	public String getFk_userid() {
		return fk_userid;
	}
	
	public void setFk_userid(String fk_userid) {
		this.fk_userid = fk_userid;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContents() {
		return contents;
	}
	
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public String getWriteday() {
		return writeday;
	}
	public void setWriteday(String writeday) {
		this.writeday = writeday;
	}
	public int getViewcount() {
		return viewcount;
	}
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}
	public String getBoardpasswd() {
		return boardpasswd;
	}
	public void setBoardpasswd(String boardpasswd) {
		this.boardpasswd = boardpasswd;
	}
	private String boardpasswd;  
	
		
	
	
	
	
	
}
