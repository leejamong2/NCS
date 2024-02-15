show user;
--USER이(가) "HR"입니다.

select * from dba_users; 
/*
    ORA-00942: 테이블 또는 뷰가 존재하지 않습니다
    00942. 00000 -  "table or view does not exist"
    *Cause:    
    *Action:
    4행, 15열에서 오류 발생
*/
-- dba_users 은 관리자만 조회할 수 있는 것이지 일반 사용자인 hr 은 조회가 불가하다는 말이다. --관리자만 볼수있음. hr은 일반유저는 볼수없음 



-- *** ORACLE 은 관계형 데이터베이스(Relation DataBase) 관리 시스템(Management System) 이다. ***
--     관계형 데이터베이스 관리 시스템을 RDBMS(Relation DataBase Management System) 라고 부른다.
--     관계형 데이터베이스는 데이터를 열(Column, Field) 과 행(Row, Record, tuple) 으로 이루어진 테이블(Table, entity, 개체) 형태로 저장한다.



--** 현재 오라클 서버에 접속되어진 사용자(지금은 hr)가 만든(소유의) 테이블(Table) 목록을 조회해본다.

select*
from tab;
/*
     TNAME             TABTYPE
------------------------------
    COUNTRIES	        TABLE	
    DEPARTMENTS	        TABLE	
    EMPLOYEES	        TABLE	
    EMP_DETAILS_VIEW	VIEW    (VIEW는 테이블은 아니지만 SELECT되어진 결과물을 마치 테이블인것처럼 보는것)
    JOBS	            TABLE	
    JOB_HISTORY	        TABLE	
    LOCATIONS	        TABLE	
    REGIONS	            TABLE	
*/
select*
from DEPARTMENTS;  --sql 명령어는 대소문자를 구분하지 않는다.


SELECT*
FROM DEPARTMENTS; --sql 명령어는 대소문자를 구분하지 않는다.

sEleCt*
frOm DEPARTMENTS; --sql 명령어는 대소문자를 구분하지 않는다.




select*
from dePARtMENtS;  --테이블명도(프롬다음에 나오는거) 대소문자 구분하지 않는다. --*별 은 모든 컬럼들을 말하는것


select department_id, department_name, manager_id, location_id --컬럼명도 대소문자를 구분하지 않는다.
frOm DEPARTMENTS;

SELECT DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, LOCATION_ID --컬럼명도 대소문자를 구분하지 않는다.
FROM DEPARTMENTS;

select depArtmEnt_id, deParTment_name, mAnaGer_id, loCaTion_id --컬럼명도 대소문자를 구분하지 않는다.
from departments;

--!!! 저장되어진 데이터 값 만큼은 반드시 대소문자를 구분합니다. !!!--
select*
from departments
where department_name = 'Sales';  --결과물이 나온다.


--!!! 저장되어진 데이터 값 만큼은 반드시 대소문자를 구분합니다. !!!--
select*
from departments
where department_name = 'SALES';  --결과물이 안나온다.


--!!! 저장되어진 데이터 값 만큼은 반드시 대소문자를 구분합니다. !!!--
select*
from departments
where department_name = 'sales';  --결과물이 안나온다.


--!!! 저장되어진 데이터 값 만큼은 반드시 대소문자를 구분합니다. !!!--
select*
from departments
where department_name = 'SaLeS';  --결과물이 안나온다.




--------------------------------------------------------------------------------------------------------
/*
        =====!!!!!!!! 아주아주아주아주아주아주아주아주 중요중요중요중요중요중요 !!!!!!!!!!!=====
        >>>>>!!!!!!!! 필수암기 !!!!!!!!<<<<<<
        
        ==== 어떠한 테이블(또는 뷰)에서 데이터 정보를 꺼내와보는 명령어인  select의 처리(해석, parsing)순서 ====
        
        select 컬럼명, 컬럼명  --5
        from테이블명(또는 뷰명) --1
        where조건절           --2     where 조건절이 뜻하는 것은 해당 테이블명(또는 뷰명)에서 조건에 만족하는 행(row)을 메모리(RAM)에 로딩(올리는것)해주는 것이다!!! ★암깅
        group by 절          --3
        having 그룹함수조건절   --4
        order by 절          --6
        
*/

select*
from departments;  --"부서" 테이블

select department_id, department_name
from departments;   --이 테이블 상에서 어느컬럼(지금은 4개) 가져올래?  셀렉트 옆에 두가지 볼래


describe departments;  --describe는 뭐냐?  departments 테이블의 컬럼의 정보를 알려주는 것이다.
-- 또는
desc departments;

/*
    이름                                널?                                                                                    유형           
    ---------------                  --------                                                                              ------------ 
    DEPARTMENT_ID   (부서번호)         NOT NULL ==> NOT NULL은 반드시 데이터를 입력해야 한다는 뜻이다.                                NUMBER(4)   ==> 숫자타입   -9999  ~  9999  넘버(4)는 이 범위에서만 가능하다
    DEPARTMENT_NAME (부서명)           NOT NULL                                                                              VARCHAR2(30) ==> 문자열타입 최대 30byte까지만 입력가능함. 글자를 무한대로 받을 수 없음.
    MANAGER_ID      (부서장의 사원번호)           ==> 없는 것이나 NULL은 같은것인데 데이터를 입력하든 입력하지 않든 모두 허용한다는 뜻이다.    NUMBER(6)    ==> 숫자타입   -999999  ~  999999  넘버(6)은 이 범위에서만 가능하다
    LOCATION_ID     (부서위치ID)                                                                                              NUMBER(4)   ==> 숫자타입   -9999  ~  9999  넘버(4)는 이 범위에서만 가능하다
*/

select*
from EMPLOYEES;  -- "사원" 테이블

desc employees;
/*
    이름                                       널?            유형           
    --------------                         --------      ------------ 
    EMPLOYEE_ID    (사원번호)                NOT NULL       NUMBER(6)    
    FIRST_NAME     (이름)                                  VARCHAR2(20) 
    LAST_NAME      (성)                     NOT NULL       VARCHAR2(25) 
    EMAIL          (이메일)                  NOT NULL       VARCHAR2(25) 
    PHONE_NUMBER   (연락처)                                 VARCHAR2(20) 
    HIRE_DATE      (입사일자)                NOT NULL         DATE   --날짜타입      
    JOB_ID         (직종ID)                 NOT NULL       VARCHAR2(10) 
    SALARY         (기본급여)                               NUMBER(8,2)    -999999.99 ~ 999999.99   전체 8자리에서 소수부가 뒤에서 두번째자리라는 말
    COMMISSION_PCT (커미션(수당)퍼센티지)                      NUMBER(2,2)    -0.99 ~ 0.99   전체 2자리에서 소수부가 뒤에서 두번째자리라는 말
    MANAGER_ID     (직송상관(사수)의 사원번호)                  NUMBER(6)    
    DEPARTMENT_ID  (해당사원이 근무하는 부서번호)                NUMBER(4) 
*/

select*
from LOCATIONS;  -- 부서의 위치정보를 알려주는 테이블

select*
from COUNTRIES;  -- 국가 정보를 알려주는 테이블

select*
from REGIONS;    -- 대륙 정보를 알려주는 테이블


---------------------------------------------------------------------------------------------------------

----*** NULL 을 처리해주는 함수 ***----
----  NULL 은 존재하지 않는 것이므로 4칙연산(+ - * /)에 NULL 이 포함되면 그 결과는 무조건 NULL이 된다.!!! ★암기

1. NVL
    select '안녕하세요', 500, '500', 0075, '0075', null    --안녕하세요	500	500	75	0075	       -- 문자열은 쌍따옴표 아니고 홑따옴표'' !!! 
    from dual;    --dual 은 select 다음에 나오는 값ㄷㄹ을 화면에 보여주기 위한 용도로 쓰이는 가상테이블이다  -- 안녕하세요 를 보여주려고 from 가상테이블  을 만듬.   
    
    select 1+2, 1+null, 3*0, null*0, 5/2, 5/null     --3		0		2.5		
    from dual;
    
    select nvl(7, 3), nvl(null, 3),  
           nvl('이순신', '거북선'), nvl(null, '거북선')   --(a,b) 첫번쨰가 null입니까? null이면 b출력 아니면 a출력
    from dual;
    
    
    
    

2. NVL2

    select nvl2(7, 3, 2), nvl2(null, 3, 2),  
           nvl2('이순신', '거북선', '구국영웅'),  nvl2(null, '거북선', '구국영웅')   --(a,b,c) 첫번째가 null입니까? null이면 c출력 아니면 b출력
    from dual;


    select employee_id, first_name, last_name, job_id, salary, commission_pct, department_id   -- 3. 메모리(RAM)에 퍼올려진 행들에서 화면에 보여주는 컬럼은 employee_id, first_name, last_name, job_id, salary, commission_pct, department_id 컬럼의 값들을 화면에 보여라.
    from employees              -- 1. employees 테이블에서
    where department_id = 60;   -- 2. department_id 컬럼의 값이 60과 일치하는 행들만 메모리(RAM)에 퍼올린다.      오라클에서  = 이 기호는    같다     임.
    
    
    
    select *                     -- 2.   * 이므로 employees테이블에 존재하는 모든 컬럼들을 화면에 보여라.
    from employees;              -- 1. employees 테이블에서 where절이 없으므로 employees테이블에 저장되어진 모든 행들(107개 행)을 메모리에 퍼올린다.
    
    
    select employee_id, first_name, last_name, job_id, salary, commission_pct, department_id   -- 2. 메모리(RAM)에 퍼올려진 행들에서 화면에 보여주는 컬럼은 employee_id, first_name, last_name, job_id, salary, commission_pct, department_id 컬럼의 값들을 화면에 보여라.
    from employees;              -- 1. employees 테이블에서 where절이 없으므로 employees테이블에 저장되어진 모든 행들(107개 행)을 메모리에 퍼올린다.
    
    
    
    --월급은 기본급여(salary) + 수당(salary * commission_pct)
    --commission_pct 컬럼의 값이 null이라함은 수당이 없다는 말이고, commission_pct컬럼의 값이 0.3이라함은 자신의 기본급여(salary) * 0.3 이 실제 수당금액이다.
    
    select employee_id, first_name, last_name, salary, commission_pct,
            salary + salary * commission_pct,
            nvl( salary * commission_pct, salary ),  --a가 널이 아니면 a출력, null이면 b출력.
            nvl2( commission_pct, salary * commission_pct ,salary)
    from employees;
    
    
    
    --- *** select 된 결과물에서 컬럼에 대한 별칭(alias)을 부여하겠다. ***---
    select employee_id as "사원번호",   --별칭(alias)
            first_name "이름",   --별칭(alias)에서 as 는 생략 가능함.
            last_name 성,    --별칭(alias)에서 "" 는 생략 가능함.
            salary "기본 급여",   --별칭(alias)에서 공백을 넣으려면 "" 꼭 붙여야함.
            commission_pct 커미션퍼센티지,    
            nvl( salary * commission_pct, salary ) "1월급",  --별칭(alias)에서 첫글자에 숫자 넣으려면 "" 꼭 붙여야함  
            nvl2( commission_pct, salary * commission_pct ,salary) 월급2
    from employees;
    
    
    







