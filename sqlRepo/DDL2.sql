-- DDL 2

/*
    <DDL(Data Definition Language)>
        데이터 정의 언어로 오라클에서 제공하는 객체를 만들고(CREATE), 변경하고(ALTER), 삭제하는(DROP) 등
        실제 데이터 값이 아닌 데이터의 구조 자체를 정의하는 언어로 DB 관리자, 설계자가 주로 사용한다.

    <ALTER>
        오라클에서 제공하는 객체를 수정하는 구문이다.
    
    <테이블 수정>
        [표현법]
            ALTER TABLE 테이블명 수정할 내용;
            
        * 수정할 내용
            1) 컬럼 추가/수정/삭제
            2) 제약 조건 추가/삭제 --> 수정은 불가능(삭제한 후 새로 추가해야 한다.)
            3) 테이블명/ 컬럼명 / 제약조건명 변경
*/



-- 1) 컬럼 추가/수정/삭제
--  1-1) 컬럼 추가(ADD) : ALTER TALBE 테이블명 ADD 컬럼명 테이터타입 [DEFAULT 기본값];
-- CNAME 컬럼을 테이블 맨 뒤에 추가한다.
-- 기본값을 지정하지 않으면 새로 추가된 컬럼은 NULL값으로 채워진다.


--  1-2) 컬럼 수정(MODIFY)
--    데이터 타입 변경 : ALTER TABLE 테이블명 MODIFY 컬럼명 변경할 데이터타입;
--    기본값 변경 : ALTER TABLE 테이블명 MODIFY 컬럼명 DEFALUT 변경할 기본값;

-- 다중 수정
-- DEPT_TITLE 컬럼의 데이터 타입을 VARCHAR2(40)
-- LOCATION_ID 컬럼의 데이터 타입을 VARCHAR2(2)
-- LNAME 컬럼의 기본값을 미국으로 변경하기

--   1-3) 컬럼 삭제 (DROP COLUMN) : ALTER TABLE 테이블명 DROP COLUMN 컬럼명;
--     데이터 값이 기록되어 있어도 같이 삭제된다. (단, 삭제된 컬럼 복구는 불가능)
--     테이블에는 최소 한 개의 컬럼은 존재해야 한다.
--     참조되고 있는 컬럼이 있다면 삭제가 불가능하다.


---------------------------
-- 2) 제약조건 추가/삭제
--  2-1) 제약조건 추가
--      PRIMARY KEY : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] PRIMARY KEY(칼럼명);
--      FOREIGN KEY : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] FOREIGN KEY(칼럼명) REFERENCES 테이블명 [(칼럼명)];
--      UNIQUE      : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] UNIQUE(칼럼명);
--      CHECK       : ALTER TABLE 테이블명 ADD [CONSTRAINT 제약조건명] CHECK(칼럼에 대한 조건);
--      NOT NULL    : ALTER TABLE 테이블명 MODIFY 칼럼명 [CONSTRAINT 제약조건명] NOT NULL;


--   2-2) 제약조건 삭제
--      NOT NULL : ALTER TABLE 테이블명 MODIFY 칼럼명 NULL;
--      나머지    : ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명;



-- 3) 테이블명/칼럼명/제약조건명 변경
--  3-1) 칼럼명 변경 : ALTER TABLE 테이블명 RENAME COLUMN 기존칼럼명 TO 변경할칼럼명;


--  3-2) 제약조건명 변경 : ALTER TABLE 테이블명 RENAME CONSTRAINT 기존제약조건명 TO 변경할제약조건명;


--  3-3) 테이블명 변경
--     1) ALTER TABLE 테이블명 RENAME TO 변경할테이블명;
--     2) RENAME 기존테이블명 TO 변경할테이블명;



/*
    <DROP>
        오라클에서 제공하는 객체를 삭제하는 구문이다.
        
    * 단, 참조되고 있는 부모 테이블은 함부로 삭제가 되지 않는다.
      만약에 삭제하고자 한다면
      
      1) 자식 테이블 먼저 삭제한 후 부모 테이블을 삭제하는 방법
*/

/*
      2) 부모 테이블을 삭제할 때 제약조건도 함께 삭제하는 방법
*/
DROP TABLE MEMBER_GRADE CASCADE CONSTRAINTS;


















