---- **** === 오라클 계정 생성하기 시작 === **** ----

-- 오라클 계정 생성을 위해서는 SYS 또는 SYSTEM 으로 연결하여 작업을 해야 합니다. [SYS 시작] --
show user;
-- USER이(가) "SYS"입니다.

-- 오라클 계정 생성시 계정명 앞에 c## 붙이지 않고 생성하도록 하겠습니다.
alter session set "_ORACLE_SCRIPT"=true;
-- Session이(가) 변경되었습니다.

-- 오라클 계정명은 JDBC_USER 이고 암호는 gclass 인 사용자 계정을 생성합니다.
create user JDBC_USER identified by gclass default tablespace users; 
-- User JDBC_USER이(가) 생성되었습니다.

-- 위에서 생성되어진 JDBC_USER 이라는 오라클 일반사용자 계정에게 오라클 서버에 접속이 되어지고,
-- 테이블 생성 등등을 할 수 있도록 여러가지 권한을 부여해주겠습니다.
grant connect, resource, create view, unlimited tablespace to JDBC_USER;
-- Grant을(를) 성공했습니다.

---- **** === 오라클 계정 생성하기 끝 === **** ----

show user;
--USER이(가) "JDBC_USER"입니다.



create table tbl_memo
(no          number(4)
,name        Nvarchar2(20) not null
,msg         Nvarchar2(100) not null
,writeday    date default sysdate
,constraint  PK_tbl_memo_no primary key(no)
);
-- Table TBL_MEMO이(가) 생성되었습니다.

create sequence seq_memo
start with 1
increment by 1
nomaxvalue
nominvalue
nocycle
nocache;
-- Sequence SEQ_MEMO이(가) 생성되었습니다.

select no, name, msg, to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS writeday
from tbl_memo
order by no desc;

select no, name, msg, to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS writeday from tbl_memo order by no desc;

update tbl_memo set writeday = writeday - 1
where no between 1 and 2

commit;

select no, name, msg, to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS writeday
from tbl_memo
where no = '1'
order by no desc;

select no, name, msg, to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS writeday
from tbl_memo
where msg like '%'||'점심'|| '%'
order by no desc;


select no, name, msg, to_char(writeday, 'yyyy-mm-dd hh24:mi:ss') AS writeday
from tbl_memo
where to_char(writeday, 'yyyy-mm-dd') = '2024-03-07'
order by no desc;









