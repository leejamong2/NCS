show user;

select *
from tbl_member
order by userseq desc;

update tbl_member set status = 1;
commit;



---- *** 게시판 테이블 생성하기 *** ----
create table tbl_board
(boardno       number         not null        -- 글번호
,fk_userid     varchar2(30)   not null        -- 작성자아이디
,subject       Nvarchar2(100) not null        -- 글제목
,contents      Nvarchar2(200) not null        -- 글내용
,writeday      date default sysdate not null  -- 작성일자 
,viewcount     number default 0 not null      -- 조회수 
,boardpasswd   varchar2(20) not null          -- 글암호
,constraint PK_tbl_board_boardno primary key(boardno)
,constraint FK_tbl_board_fk_userid foreign key(fk_userid) references tbl_member(userid)
);
-- Table TBL_BOARD이(가) 생성되었습니다.

create sequence seq_board
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;
-- Sequence SEQ_BOARD이(가) 생성되었습니다. 

desc tbl_board;

select *
from tbl_board
order by boardno desc;

desc tbl_member;
-- 글번호   글제목   작성자   작성일자    조회수





-----------------------------------------------------------------------------------------
/*
   Transaction(트랜잭션) 처리 실습을 위해서
   tbl_member 테이블의 point. 컬럼의 값은 최대 30을 넘지 못하도록 check 제약을 걸도록 하겠습니다.
   --글쓴건 성공이지만 포인트는 안올라가니까 40일때 다 롤백해줘야함)
*/
-----------------------------------------------------------------------------------------
alter table tbl_member
add constraint CK_tbl_member_point check( point between 0 and 30);  --위의 제약 걸어줌
--Table TBL_MEMBER이(가) 변경되었습니다.

select *
from tbl_member
order by userseq desc;

update tbl_member set point = point + 10
where userid = 'leess';
-- 1 행 이(가) 업데이트되었습니다.

update tbl_member set point = point + 10
where userid = 'leess';
-- 1 행 이(가) 업데이트되었습니다.

update tbl_member set point = point + 10
where userid = 'leess';
-- 1 행 이(가) 업데이트되었습니다.

update tbl_member set point = point + 10
where userid = 'leess';
/*
오류 보고 -
ORA-02290: 체크 제약조건(JDBC_USER.CK_TBL_MEMBER_POINT)이 위배되었습니다
*/
select *
from tbl_member
order by userseq desc;

rollback;
--롤백

select *
from tbl_board
order by boardno desc;


