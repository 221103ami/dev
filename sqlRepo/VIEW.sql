-- VIEW

/*
    <VIEW>
        SELECT ���� ������ �� �ִ� ��ü�̴�.(������ ���� ���̺�)
        �����͸� �����ϰ� ���� ������ ���̺� ���� SQL�� ����Ǿ� �־� VIEW ������ �� SQL�� �����ϸ鼭 ������� �����´�.
        
        [����]
            CREATE [OR REPLACE] VIEW ���
            AS ���� ����;
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
    <�� �÷��� ��Ī �ο�>
        ���� ������ SELECT ���� �Լ��� ��������� ����Ǿ� �ִ� ��� �ݵ�� ��Ī�� �����ؾ� �Ѵ�.
*/

/*
    <VIEW�� �̿��ؼ� DML(INSERT, UPDATE, DELETE) ���>
        �並 ���� �����͸� �����ϰ� �Ǹ� ���� �����Ͱ� ����ִ� �⺻ ���̺��� ����ȴ�.
*/



/*
    <DML �������� VIEW ������ �Ұ����� ���>
*/
--  1) �� ���ǿ� ���Ե��� �ʴ� �÷��� �����ϴ� ���
--  2) �信 ���Ե��� ���� �÷� �߿� �⺻ ���̺� �� NOT NULL ���������� ������ ���
--  3) ��� ǥ�������� ���ǵ� ���
--  4) �׷� �Լ��� GROUP BY ���� ������ ���
--  5) DISTINCT�� ������ ���
--  6)JOIN�� �̿��� ���� ���̺��� ������ ��� 


/*
    <VIEW �ɼ�>
        [ǥ����]
            CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW
            AS ���� ����
            [WITH CHECK OPTION]
            [WITH READ ONLY];
            
        - OR REPLACE : ������ ������ �䰡 ���� ��� �����, �������� ������ �並 ���� �����Ѵ�.
        - FORCE : ���� ������ ����� ���̺��� �������� �ʴ� ���̺��̾ �䰡 �����ȴ�.
        - NOFORCE : ���� ������ ����� ���̺��� �����ؾ߸� �䰡 �����ȴ�. (�⺻��)
        - WITH CHECK OPTION : ���� ������ ����� ���ǿ� �������� �ʴ� ������ �����ϴ� ��� ������ �߻���Ų��.
        - WITH READ ONLY : �信 ���� ��ȸ�� ����(DML ���� �Ұ�)
*/







