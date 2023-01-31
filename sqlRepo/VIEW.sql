-- VIEW

/*
    <VIEW>
        SELECT 문을 저장할 수 있는 객체이다.(논리적인 가상 테이블)
        데이터를 저장하고 있지 않으며 테이블에 대한 SQL만 저장되어 있어 VIEW 접근할 때 SQL을 수행하면서 결과값을 가져온다.
        
        [문법]
            CREATE [OR REPLACE] VIEW 뷰명
            AS 서브 쿼리;
*/

SELECT EMPNO , ENAME, A.DEPTNO , DNAME
FROM EMP A
JOIN DEPT B
ON A.DEPTNO = B.DEPTNO
;

CREATE VIEW V_EMP_DEPT
AS 
(
    SELECT EMPNO , ENAME, A.DEPTNO , DNAME
    FROM EMP A
    JOIN DEPT B
    ON A.DEPTNO = B.DEPTNO
);

SELECT *
FROM V_EMP_DEPT;

/*
    <뷰 컬럼에 별칭 부여>
        서브 쿼리의 SELECT 절에 함수나 산술연산이 기술되어 있는 경우 반드시 별칭을 지정해야 한다.
*/

/*
    <VIEW를 이용해서 DML(INSERT, UPDATE, DELETE) 사용>
        뷰를 통해 데이터를 변경하게 되면 실제 데이터가 담겨있는 기본 테이블에도 적용된다.
*/



/*
    <DML 구문으로 VIEW 조작이 불가능한 경우>
*/
--  1) 뷰 정의에 포함되지 않는 컬럼을 조작하는 경우
--  2) 뷰에 포함되지 않은 컬럼 중에 기본 테이블 상에 NOT NULL 제약조건이 지정된 경우
--  3) 산술 표현식으로 정의된 경우
--  4) 그룹 함수나 GROUP BY 절을 포함한 경우
--  5) DISTINCT를 포함한 경우
--  6)JOIN을 이용해 여러 테이블을 연결한 경우 


/*
    <VIEW 옵션>
        [표현법]
            CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW
            AS 서브 쿼리
            [WITH CHECK OPTION]
            [WITH READ ONLY];
            
        - OR REPLACE : 기존에 동일한 뷰가 있을 경우 덮어쓰고, 존재하지 않으면 뷰를 새로 생성한다.
        - FORCE : 서브 쿼리에 기술된 테이블이 존재하지 않는 테이블이어도 뷰가 생성된다.
        - NOFORCE : 서브 쿼리에 기술된 테이블이 존재해야만 뷰가 생성된다. (기본값)
        - WITH CHECK OPTION : 서브 쿼리에 기술된 조건에 부합하지 않는 값으로 수정하는 경우 오류를 발생시킨다.
        - WITH READ ONLY : 뷰에 대해 조회만 가능(DML 수행 불가)
*/







