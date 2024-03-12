package jdbc.day04.board.model;

import jdbc.day04.board.domain.BoardDTO;

public interface BoardDAO {

	int write(BoardDTO bdto);  //게시판 글쓰기  // '실행'을 담당 
   // === Transaction 처리 ===
   //    (tbl_board 테이블에 insert 가 성공되어지면 tbl_member 테이블의 point 컬럼에 10씩 증가 update 를 할 것이다.
   //     그런데 insert 또는 update 가 하나라도 실패하면 모두 rollback 할 것이고,
   //     insert 와 update 가 모두 성공해야만 commit 할 것이다.)
   // dto가 tbl_board(DML=insert) 에도 있고 tbl_member(DML=insert)에도 잇을거아녀
}
