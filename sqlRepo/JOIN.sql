-- JOIN

/*
    <JOIN>
        �� ���� �̻��� ���̺��� �����͸� ��ȸ�ϰ��� �� �� ����ϴ� �����̴�.
        
        1. � ����(EQUAL JOIN) / ���� ����(INNER JOIN)
            �����Ű�� �÷��� ���� ��ġ�ϴ� ��鸸 ���εǼ� ��ȸ�Ѵ�.(��ġ�ϴ� ���� ���� ���� ��ȸ X)
            
            1) ����Ŭ ���� ����
                [ǥ����]
                    SELECT �÷�, �÷�, ...
                    FROM ���̺�1, ���̺�2
                    WHERE ���̺�1.�÷��� = ���̺�2.�÷���;
                
                - FROM ���� ��ȸ�ϰ��� �ϴ� ���̺���� �޸�(,)�� �����Ͽ� �����Ѵ�.
                - WHERE ���� ��Ī ��ų �÷��� ���� ������ �����Ѵ�.
            
            2) ANSI ǥ�� ����
                [ǥ����]
                    SELECT �÷�, �÷�, ...
                    FROM ���̺�1
                    [INNER] JOIN ���̺�2 ON (���̺�1.�÷��� = ���̺�2.�÷���);
                
                - FROM ���� ������ �Ǵ� ���̺��� ����Ѵ�.
                - JOIN ���� ���� ��ȸ�ϰ��� �ϴ� ���̺��� ��� �� ��Ī ��ų �÷��� ���� ������ ����Ѵ�.
                - ���ῡ ����Ϸ��� �÷����� ���� ��� ON ���� ��ſ� USING(�÷���) ������ ����Ѵ�.
*/

SELECT ENAME , A.DEPTNO , DNAME
FROM EMP A
RIGHT JOIN DEPT B
ON A.DEPTNO = B.DEPTNO
;

INSERT INTO EMP (EMPNO , ENAME , DEPTNO) VALUES(999 , 'ȫ�浿' , NULL);


/*
    2. ���� JOIN
        ���� ���� ���̺� �����ϴ� ��쿡 ����Ѵ�.
*/


/*
    3. �ܺ� ���� (OUTTER JOIN)
        ���̺� ���� JOIN �� ��ġ���� �ʴ� �൵ ���Խ��Ѽ� ��ȸ�� �����ϴ�.
        ��, �ݵ�� �����̵Ǵ� ���̺�(�÷�)�� �����ؾ� �Ѵ�. (LEFT/RIGHT/(+))
*/

/*
    4. ī�׽þȰ�(CARTESIAN PRODUCT) / ���� ����(CROSS JOIN)
        ���εǴ� ��� ���̺��� �� ����� ���μ��� ��� ���ε� �����Ͱ� �˻��ȴ�.
        ���̺��� ����� ��� ������ ����� ������ ��� -> ����ȭ�� ����
*/

/*
    5. �� ����(NON EQUAL JOIN)
        ���� ���ǿ� ��ȣ(=)�� ������� �ʴ� ���ι��� �� �����̶�� �Ѵ�.
        ������ �÷� ���� ��ġ�ϴ� ��찡 �ƴ�, ���� ������ ���ԵǴ� ����� �����ϴ� ����̴�.
        ( = �̿ܿ� �� ������ >, <, >=, <=, BETWEEN AND, IN, NOT IN ���� ����Ѵ�.)
        ANSI �������δ� JOIN ON �������θ� ����� �����ϴ�. (USING ��� �Ұ�)
*/

CREATE TABLE SAL_GRADE(
    GRADE VARCHAR2(100)
    , MIN NUMBER
    , MAX NUMBER
);
INSERT INTO SAL_GRADE VALUES('�ʱ�' , 200 , 300);
INSERT INTO SAL_GRADE VALUES('�߱�' , 300 , 400);
INSERT INTO SAL_GRADE VALUES('���' , 400 , 900);

SELECT * FROM SAL_GRADE;

SELECT *
FROM EMP A
JOIN SAL_GRADE B
ON A.SAL BETWEEN B.MIN AND B.MAX
;

/*
    6. ��ü ����(SELF JOIN)
        ���� ���̺��� �ٽ� �ѹ� �����ϴ� ��쿡 ����Ѵ�.
*/








